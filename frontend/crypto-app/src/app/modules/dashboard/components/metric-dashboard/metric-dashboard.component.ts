import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MetricLinearComponentComponent } from '../metric-linear-component/metric-linear-component.component';

@Component({
  selector: 'app-metric-dashboard',
  standalone: true,
  imports: [CommonModule, MetricLinearComponentComponent],
  templateUrl: './metric-dashboard.component.html',
  styleUrl: './metric-dashboard.component.css'
})
export class MetricDashboardComponent {

}
