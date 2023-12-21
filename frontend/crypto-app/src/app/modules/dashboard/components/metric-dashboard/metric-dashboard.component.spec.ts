import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MetricDashboardComponent } from './metric-dashboard.component';

describe('MetricDashboardComponent', () => {
  let component: MetricDashboardComponent;
  let fixture: ComponentFixture<MetricDashboardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MetricDashboardComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(MetricDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
