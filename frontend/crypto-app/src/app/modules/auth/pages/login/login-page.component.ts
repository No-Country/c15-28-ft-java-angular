import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from '../../components/login-component/login.component';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, LoginComponent],
  templateUrl: './login-page.component.html',
})
export class LoginPageComponent {}
