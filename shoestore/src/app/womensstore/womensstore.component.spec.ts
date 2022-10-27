import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WomensstoreComponent } from './womensstore.component';

describe('WomensstoreComponent', () => {
  let component: WomensstoreComponent;
  let fixture: ComponentFixture<WomensstoreComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WomensstoreComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(WomensstoreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
