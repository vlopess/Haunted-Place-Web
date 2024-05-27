import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChipsTagComponent } from './chips-tag.component';

describe('ChipsTagComponent', () => {
  let component: ChipsTagComponent;
  let fixture: ComponentFixture<ChipsTagComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ChipsTagComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ChipsTagComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
