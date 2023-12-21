import { Component, Input, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ChartConfiguration, ChartOptions } from 'chart.js';
import { NgChartsModule } from 'ng2-charts';
import { Chart } from 'chart.js';


Chart.defaults.color = "#C7C6C6"
Chart.defaults.font.size = 8;

@Component({
  selector: 'app-metric-linear-component',
  standalone: true,
  imports: [CommonModule, NgChartsModule],
  template: `
      <canvas baseChart
              [data]="lineChartData"
              [options]="lineChartOptions"
              [legend]="lineChartLegend"
              width="400"
              height="300"
              [type]="'line'">
      </canvas>
  `,
  styleUrl: './metric-linear-component.component.css'
})
export class MetricLinearComponentComponent implements OnInit {
  @Input() arrayData: any[] = [];
  @Input() chartTitle: string = '';
  
  public lineChartData: ChartConfiguration<'line'>['data'] = {
    labels: [],
    datasets: [],
  };

  public lineChartOptions: ChartOptions<'line'> = {
    responsive: true,
    elements: {
      line: {
        borderWidth: 1
      }
    },
    aspectRatio: 13/6,
    datasets: {
      line: {
      }
    }
  };

  public lineChartLegend = true;

  ngOnInit(): void {
    this.initializeChartData();
  }

  private initializeChartData(): void {
    this.lineChartData.labels = this.arrayData.map(transaction => transaction.date);
    this.lineChartData.datasets = [
      {
        data: this.arrayData.map(transaction => transaction.amount),
        label: this.chartTitle,
        fill: true,
        tension: 0,
        borderColor: '#EE49FD',
        backgroundColor: 'transparent',
        pointBackgroundColor:"transparent",
        pointBorderColor: "transparent",
      }
    ];
  }
}
