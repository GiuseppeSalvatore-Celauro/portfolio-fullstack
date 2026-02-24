import { Routes } from '@angular/router';
import { Herosection } from './page-content/herosection/herosection';
import { AboutMe } from './page-content/about-me/about-me';
import { Progetti } from './page-content/progetti/progetti';
import { Login } from './auth/login/login';

export const routes: Routes = [
    {path: '', redirectTo: '/home', pathMatch: 'full'},
    {path: 'home', component: Herosection},
    {path: 'about-me', component: AboutMe},
    {path: 'progetti', component: Progetti},
    {path: 'auth/login', component: Login}
];
