import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TrendingViewComponent } from './trending-view.component';

describe('TrendingViewComponent', () => {
  let component: TrendingViewComponent;
  let fixture: ComponentFixture<TrendingViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [TrendingViewComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TrendingViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
