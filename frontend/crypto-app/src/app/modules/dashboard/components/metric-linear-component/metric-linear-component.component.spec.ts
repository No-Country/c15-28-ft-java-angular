import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MetricLinearComponentComponent } from './metric-linear-component.component';

describe('MetricLinearComponentComponent', () => {
  let component: MetricLinearComponentComponent;
  let fixture: ComponentFixture<MetricLinearComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MetricLinearComponentComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(MetricLinearComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
