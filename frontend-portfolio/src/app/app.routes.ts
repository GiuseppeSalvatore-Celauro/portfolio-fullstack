import { Routes } from '@angular/router';
import { Herosection } from './page-content/herosection/herosection';
import { AboutMe } from './page-content/about-me/about-me';
import { Progetti } from './page-content/progetti/progetti';
import { Normallayout } from './layouts/normallayout/normallayout';
import { Authlayout } from './layouts/authlayout/authlayout';
import { LoginPage } from './page-content/login-page/login-page';

export const routes: Routes = [
    {path: '', component: Normallayout, children: [
        {path: '', redirectTo: '/home', pathMatch: 'full'},
        {path: 'home', component: Herosection},
        {path: 'about-me', component: AboutMe},
        {path: 'progetti', component: Progetti},
    ]},
    {path: '', component: Authlayout, children: [
        {path: 'auth/login', component: LoginPage},
    ]}
    
];
