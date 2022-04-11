import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HoteInscriptionComponent } from './hote-inscription.component';

describe('HoteInscriptionComponent', () => {
  let component: HoteInscriptionComponent;
  let fixture: ComponentFixture<HoteInscriptionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HoteInscriptionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HoteInscriptionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
