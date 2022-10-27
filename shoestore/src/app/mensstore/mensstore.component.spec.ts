import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MensstoreComponent } from './mensstore.component';

describe('MensstoreComponent', () => {
  let component: MensstoreComponent;
  let fixture: ComponentFixture<MensstoreComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MensstoreComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MensstoreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
