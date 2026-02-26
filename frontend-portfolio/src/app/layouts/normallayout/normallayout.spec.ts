import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Normallayout } from './normallayout';

describe('Normallayout', () => {
  let component: Normallayout;
  let fixture: ComponentFixture<Normallayout>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Normallayout]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Normallayout);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
