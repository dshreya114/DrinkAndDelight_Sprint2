import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OrderMgtComponent } from './order-mgt.component';

describe('OrderMgtComponent', () => {
  let component: OrderMgtComponent;
  let fixture: ComponentFixture<OrderMgtComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OrderMgtComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OrderMgtComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
