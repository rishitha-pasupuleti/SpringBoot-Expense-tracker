import { Routes } from '@angular/router';
import { ExpenseList } from './components/expense-list/expense-list';
import { Summary } from './components/summary/summary';

export const routes: Routes = [
  { path: '', component: ExpenseList },
  { path: 'summary', component: Summary }
];
