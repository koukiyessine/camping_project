import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TopDestinationsComponent } from './top-destinations.component';

describe('TopDestinationsComponent', () => {
  let component: TopDestinationsComponent;
  let fixture: ComponentFixture<TopDestinationsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TopDestinationsComponent]
    });
    fixture = TestBed.createComponent(TopDestinationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
