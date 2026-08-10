import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { Expense } from '../../models/expense';
import { ExpenseService } from '../../services/expense';
import { ExpenseForm } from '../expense-form/expense-form';

@Component({
  selector: 'app-expense-list',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    ExpenseForm
  ],
  templateUrl: './expense-list.html',
  styleUrl: './expense-list.css'
})
export class ExpenseList implements OnInit {

  expenses: Expense[] = [];

  total = 0;

  category = '';

  constructor(private expenseService: ExpenseService) {}

  ngOnInit(): void {
    this.loadExpenses();
  }

  loadExpenses() {

    if (this.category === '') {

      this.expenseService.getExpenses().subscribe(data => {
        this.expenses = data;
      });

    } else {

      this.expenseService.getByCategory(this.category).subscribe(data => {
        this.expenses = data;
      });

    }

    this.expenseService.getTotal().subscribe(data => {
      this.total = data;
    });

  }

  deleteExpense(id: number) {
    this.expenseService.deleteExpense(id).subscribe(() => {

      this.expenses = this.expenses.filter(e => e.id !== id);

      this.total = this.expenses.reduce((sum, e) => sum + e.amount, 0);

    });


  }

  toggleComplete(id: number) {
    this.expenseService.toggleComplete(id).subscribe(updatedExpense => {

      const expense = this.expenses.find(e => e.id === id);

      if (expense) {
        expense.completed = updatedExpense.completed;
      }

    });
  

  }
  filterByCategory(category: string) {
    this.category = category;
    this.loadExpenses();
  }

}
