import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserIconComponent } from '../../../../shared/components/user-icon/user-icon.component';

@Component({
  selector: 'app-user-section',
  standalone: true,
  imports: [CommonModule, UserIconComponent],
  templateUrl: './user-section.component.html',
  styleUrl: './user-section.component.css'
})
export class UserSectionComponent {

}
