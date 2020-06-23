import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListTableComponentComponent } from './list-table-component.component';

describe('ListTableComponentComponent', () => {
  let component: ListTableComponentComponent;
  let fixture: ComponentFixture<ListTableComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListTableComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListTableComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
