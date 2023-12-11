import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-not-found-404',
  standalone: true,
  imports: [CommonModule, NotFound404Component],
  templateUrl: './not-found-404.component.html',
  styleUrl: './not-found-404.component.css',
})
export class NotFound404Component {}
