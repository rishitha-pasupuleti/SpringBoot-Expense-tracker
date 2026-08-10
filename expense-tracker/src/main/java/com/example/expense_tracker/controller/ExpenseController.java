package com.example.expense_tracker.controller;

import com.example.expense_tracker.model.Expense;
import com.example.expense_tracker.service.ExpenseService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;

@RestController
@RequestMapping("/api/expenses")
@CrossOrigin(origins = "*")
public class ExpenseController {

    private final ExpenseService service;

    public ExpenseController(ExpenseService service) {
        this.service = service;
    }
    @GetMapping
    public List<Expense> getExpenses( @RequestParam(required = false) String category) {
        if (category != null) {
            return service.getExpensesByCategory(category);
        }
        return service.getExpenses();
    }

    @GetMapping("/summary")
    public double getTotal(
            @RequestParam(required = false) String category) {

        if (category != null) {
            return service.getCategoryTotal(category);
        }

        return service.getTotal();
    }

    @PutMapping("/{id}")
    public Expense updateExpense(
            @PathVariable Long id,
            @RequestBody Expense expense) {

        return service.updateExpense(id, expense);
    }

    @PostMapping
    public Expense addExpense(@RequestBody Expense expense) {
        return service.addExpense(expense);
    }

    @DeleteMapping("/{id}")
    public boolean deleteExpense(@PathVariable Long id) {
        return service.deleteExpense(id);
    }

    @PatchMapping("/{id}/complete")
    public Expense toggleComplete(@PathVariable Long id) {
        return service.toggleComplete(id);
    }


    @GetMapping("/summary/monthly")
    public double getMonthlySummary(
            @RequestParam String month) {

        return service.getMonthlyTotal(month);
    }

}


