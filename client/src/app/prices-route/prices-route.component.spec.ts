import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PricesRouteComponent } from './prices-route.component';

describe('PricesRouteComponent', () => {
  let component: PricesRouteComponent;
  let fixture: ComponentFixture<PricesRouteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PricesRouteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PricesRouteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
