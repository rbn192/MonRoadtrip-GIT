import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClientInscriptionComponent } from './client-inscription.component';

describe('ClientInscriptionComponent', () => {
  let component: ClientInscriptionComponent;
  let fixture: ComponentFixture<ClientInscriptionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ClientInscriptionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ClientInscriptionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
