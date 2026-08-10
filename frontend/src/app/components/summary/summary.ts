import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ExpenseService } from '../../services/expense';

@Component({
  selector: 'app-summary',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './summary.html',
  styleUrl: './summary.css'
})
export class Summary {

  month = '';

  monthlyTotal = 0;

  constructor(private expenseService: ExpenseService) {}

  getSummary() {
    this.expenseService.getMonthlyTotal(this.month).subscribe(data => {
      this.monthlyTotal = data;
    });
  }

}
