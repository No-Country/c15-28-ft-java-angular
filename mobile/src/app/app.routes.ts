import { Routes } from '@angular/router';
import { AuthComponent } from './pages/auth/auth.component';
import { SignUpComponent } from './pages/auth/sign-up/sign-up.component';
import { SignInComponent } from './pages/auth/sign-in/sign-in.component';

export const routes: Routes = [
    { path: '', redirectTo: '/auth', pathMatch: 'full' },
    { path: 'auth', component: AuthComponent },
    { path: 'register', component: SignUpComponent },
    { path: 'login', component: SignInComponent },
];
