import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Expense } from '../models/expense';

@Injectable({
  providedIn: 'root'
})
export class ExpenseService {

  private apiUrl = 'http://localhost:8081/api/expenses';

  constructor(private http: HttpClient) {}

  getExpenses(): Observable<Expense[]> {
    return this.http.get<Expense[]>(this.apiUrl);
  }

  addExpense(expense: Expense): Observable<Expense> {
    return this.http.post<Expense>(this.apiUrl, expense);
  }

  updateExpense(id: number, expense: Expense): Observable<Expense> {
    return this.http.put<Expense>(`${this.apiUrl}/${id}`, expense);
  }

  deleteExpense(id: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/${id}`);
  }

  toggleComplete(id: number): Observable<Expense> {
    return this.http.patch<Expense>(`${this.apiUrl}/${id}/complete`, {});
  }

  getTotal(): Observable<number> {
    return this.http.get<number>(`${this.apiUrl}/summary`);
  }

  getMonthlyTotal(month: string): Observable<number> {
    return this.http.get<number>(
      `${this.apiUrl}/summary/monthly?month=${month}`
    );
  }

  getByCategory(category: string): Observable<Expense[]> {
    return this.http.get<Expense[]>(
      `${this.apiUrl}?category=${category}`
    );
  }

}
