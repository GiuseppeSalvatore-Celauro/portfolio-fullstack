import { Routes } from '@angular/router';
import { Herosection } from './page-content/herosection/herosection';

export const routes: Routes = [
    {path: '', redirectTo: '/home', pathMatch: 'full'},
    {path: 'home', component: Herosection},
    {path: '**', redirectTo: '/home'}
];
