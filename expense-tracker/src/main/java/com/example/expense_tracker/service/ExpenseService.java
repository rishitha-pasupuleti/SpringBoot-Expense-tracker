package com.example.expense_tracker.service;
import com.example.expense_tracker.model.Expense;
import org.springframework.stereotype.Service;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenseService {

    private final ObjectMapper mapper = new ObjectMapper();
    private final File file = new File("src/main/resources/data/expenses.json");

    public List<Expense> getExpenses() {
        try {
            return mapper.readValue(file, new TypeReference<List<Expense>>() {});
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }


    public Expense addExpense(Expense expense) {
        List<Expense> expenses = getExpenses();

        long nextId = 1;

        for (Expense existingExpense : expenses) {
            if (existingExpense.getId() != null &&
                    existingExpense.getId() >= nextId) {

                nextId = existingExpense.getId() + 1;
            }
        }

        expense.setId(nextId);
        expenses.add(expense);

        saveExpenses(expenses);

        return expense;
    }

    public List<Expense> getExpensesByCategory(String category) {
        return getExpenses().stream()
                .filter(e -> e.getCategory().equalsIgnoreCase(category))
                .toList();
    }

    public double getTotal() {
        return getExpenses().stream()
                .mapToDouble(Expense::getAmount)
                .sum();
    }

    public double getCategoryTotal(String category) {
        return getExpensesByCategory(category).stream()
                .mapToDouble(Expense::getAmount)
                .sum();
    }

    public Expense updateExpense(Long id, Expense updatedExpense) {
        List<Expense> expenses = getExpenses();

        for (Expense expense : expenses) {
            if (expense.getId().equals(id)) {
                updatedExpense.setId(id);
                expenses.set(expenses.indexOf(expense), updatedExpense);
                saveExpenses(expenses);
                return updatedExpense;
            }
        }

        return null;
    }



    public Expense toggleComplete(Long id) {
        List<Expense> expenses = getExpenses();

        for (Expense expense : expenses) {
            if (expense.getId().equals(id)) {
                expense.setCompleted(!expense.isCompleted());
                saveExpenses(expenses);
                return expense;
            }
        }

        return null;
    }


    public boolean deleteExpense(Long id) {
        List<Expense> expenses = getExpenses();

        for (Expense expense : expenses) {
            if (expense.getId().equals(id)) {
                expenses.remove(expense);
                saveExpenses(expenses);
                return true;
            }
        }

        return false;
    }

    public void saveExpenses(List<Expense> expenses) {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, expenses);
        } catch (Exception e) {
            throw new RuntimeException("Could not save expenses");
        }
    }


    public double getMonthlyTotal(String month) {

        return getExpenses().stream()
                .filter(expense -> expense.getDate().startsWith(month))
                .mapToDouble(Expense::getAmount)
                .sum();
    }

}
