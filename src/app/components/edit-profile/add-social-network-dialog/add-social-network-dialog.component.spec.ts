import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddSocialNetworkDialogComponent } from '././add-social-network-dialog.component';

describe('AddSocialMediaDialogComponent', () => {
  let component: AddSocialNetworkDialogComponent;
  let fixture: ComponentFixture<AddSocialNetworkDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AddSocialNetworkDialogComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AddSocialNetworkDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
