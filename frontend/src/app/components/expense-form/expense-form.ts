import { Component, EventEmitter, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Expense } from '../../models/expense';
import { ExpenseService } from '../../services/expense';

@Component({
  selector: 'app-expense-form',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './expense-form.html',
  styleUrl: './expense-form.css'
})
export class ExpenseForm {

  @Output() expenseAdded = new EventEmitter<void>();

  expense: Expense = {
    title: '',
    amount: 0,
    category: '',
    date: '',
    completed: false
  };

  constructor(private expenseService: ExpenseService) {}

  addExpense() {

    this.expenseService.addExpense(this.expense).subscribe(() => {

      this.expense = {
        title: '',
        amount: 0,
        category: '',
        date: '',
        completed: false
      };

      this.expenseAdded.emit();

    });

  }

}
