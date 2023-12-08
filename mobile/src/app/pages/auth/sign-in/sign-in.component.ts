import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { IonicModule } from '@ionic/angular';
import { Validators } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-sign-in',
  standalone: true,
  imports:[IonicModule, ReactiveFormsModule, CommonModule, FormsModule],
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.scss', '../auth.component.scss'],
})
export class SignInComponent  implements OnInit {

  loginForm: FormGroup;
  isVisiblePassword: boolean = false;

  constructor(
    private readonly formBuilder: FormBuilder
  ) { 
    this.loginForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.pattern(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/)]]
    })

  }

  ngOnInit() {}
  login(){
    alert('hacer algo')
    console.log(this.loginForm);
  }

  viewPassword():void{
    this.isVisiblePassword = !this.isVisiblePassword;
  }

}
