import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ActivitesLogementsListComponent } from './activites-logements-list.component';

describe('ActivitesLogementsListComponent', () => {
  let component: ActivitesLogementsListComponent;
  let fixture: ComponentFixture<ActivitesLogementsListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ActivitesLogementsListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ActivitesLogementsListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
