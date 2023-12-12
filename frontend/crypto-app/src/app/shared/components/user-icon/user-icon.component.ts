import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-user-icon',
  standalone: true,
  imports: [CommonModule],
  template: `
    <div class="UserIcon text-[#ffffff]">
        <img [src]="img" [alt]="'User' + name" class="userImage object-contain bg-white rounded-full p-1"/>
      <div class="userData flex flex-col p-1">
        <h3>{{ name }}</h3>
        <span class="text-[.5rem]">{{ email }}</span>
      </div>
      <div class="userNotifications relative cursor-pointer">
        <img 
          class="w-[1rem]"
          src="../../../../assets/svg/notification.svg"
          alt="notifications"
        >
        <span class="number-notification">{{notification_counter}}</span>
      </div>
    </div>
  `,
  styleUrl: './user-icon.component.css',
})
export class UserIconComponent {
  @Input() name: string = '';
  @Input() email: string = '';
  @Input() img: string = '../../../../assets/svg/user-default.svg';
  @Input() notification_counter: number = 0;
}