import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NotFound404Component } from './shared/pages/not-found-404/not-found-404.component';

export const routes: Routes = [
  {
    path: 'auth',
    children: [
      {
        path: 'login',
        title: 'Login',
        loadComponent: () =>
          import('./modules/auth/pages/login/login-page.component').then(
            (m) => m.LoginPageComponent
          ),
      },
      {
        path: 'register',
        title: 'Registro',
        loadComponent: () =>
          import('./modules/auth/pages/register/register-page.component').then(
            (m) => m.RegisterPageComponent
          ),
      },
      { path: '', redirectTo: 'login', pathMatch: 'full' },
    ],
  },
  {
    path: 'dashboard',
    title: 'Dashboard',
    loadComponent: () =>
      import('./modules/dashboard/pages/index/index.component').then(
        (m) => m.IndexComponent
      ),
  },
  {
    path: 'user',
    title: 'Perfil de usuario',
    loadComponent: () =>
      import('./modules/user/pages/profile/profile.component').then(
        (m) => m.ProfileComponent
      ),
  },
  {
    path: '404',
    loadComponent: () =>
      import('./shared/pages/not-found-404/not-found-404.component').then(
        (m) => m.NotFound404Component
      ),
  },

  { path: '', redirectTo: 'dashboard', pathMatch: 'full' },
  { path: '**', redirectTo: '404' },
];
