import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RegisterComponent } from '../../components/register-component/register.component';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [CommonModule, RegisterComponent],
  templateUrl: './register-page.component.html',
})
export class RegisterPageComponent {}
