import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CompteModifComponent } from './compte-modif.component';

describe('CompteModifComponent', () => {
  let component: CompteModifComponent;
  let fixture: ComponentFixture<CompteModifComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CompteModifComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CompteModifComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
