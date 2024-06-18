import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChipSocialNetworkComponent } from '././chip-social-network.component';

describe('ChipSocialMediaComponent', () => {
  let component: ChipSocialNetworkComponent;
  let fixture: ComponentFixture<ChipSocialNetworkComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ChipSocialNetworkComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ChipSocialNetworkComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
