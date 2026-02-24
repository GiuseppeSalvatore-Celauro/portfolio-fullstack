import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AboutME } from './about-me';

describe('AboutME', () => {
  let component: AboutME;
  let fixture: ComponentFixture<AboutME>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AboutME]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AboutME);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
