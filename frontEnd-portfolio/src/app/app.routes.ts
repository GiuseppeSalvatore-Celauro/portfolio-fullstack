import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home-component/home-component';
import { ErrorComponent } from './pages/error-page/error-page';
import { Contatti } from './pages/contatti/contatti';
import { Dashboard } from './pages/admin/dashboard/dashboard';
import { Progetti } from './pages/progetti/progetti';
import { Login } from './pages/admin/login/login';

export const routes: Routes = [
    {path: '', redirectTo: 'home', pathMatch: 'full'},
    {path: 'home', component: HomeComponent},
    {path: 'contatti', component: Contatti},
    {path: 'progetti', component: Progetti},
    {path: 'admin/dashboard', component: Dashboard},
    {path: 'admin/login', component: Login},
    {path: '404', component: ErrorComponent},
    {path: '**', redirectTo: '404', pathMatch: 'full'}
];
