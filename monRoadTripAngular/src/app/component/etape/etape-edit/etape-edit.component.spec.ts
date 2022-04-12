import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EtapeEditComponent } from './etape-edit.component';

describe('EtapeEditComponent', () => {
  let component: EtapeEditComponent;
  let fixture: ComponentFixture<EtapeEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EtapeEditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EtapeEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
