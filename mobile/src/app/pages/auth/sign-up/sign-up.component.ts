import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { RouterLink } from '@angular/router';
import { IonicModule } from '@ionic/angular';

@Component({
  selector: 'app-sign-up',
  standalone: true,
  imports: [IonicModule, RouterLink, ReactiveFormsModule],
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.scss', '../auth.component.scss', '../sign-in/sign-in.component.scss'],
})
export class SignUpComponent implements OnInit {
  registerForm: FormGroup;

  constructor(private readonly formBuilder: FormBuilder) {
    this.registerForm = this.formBuilder.group({
      username: ['', [Validators.required, Validators.min(3)]],
      email: ['', [Validators.required, Validators.min(3)]],
      password: ['', [Validators.required, Validators.min(3)]],
    });
  }

  ngOnInit() {}
  signUp() {
    alert('hol');
  }
}
