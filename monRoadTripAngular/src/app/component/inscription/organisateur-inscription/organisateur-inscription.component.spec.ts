import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrganisateurInscriptionComponent } from './organisateur-inscription.component';

describe('OrganisateurInscriptionComponent', () => {
  let component: OrganisateurInscriptionComponent;
  let fixture: ComponentFixture<OrganisateurInscriptionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OrganisateurInscriptionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OrganisateurInscriptionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
