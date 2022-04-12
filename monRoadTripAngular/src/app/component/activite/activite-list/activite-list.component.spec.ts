import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AcliviteListComponent } from './activite-list.component';

describe('ActiviteListComponent', () => {
  let component: AcliviteListComponent;
  let fixture: ComponentFixture<AcliviteListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AcliviteListComponent],
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AcliviteListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
