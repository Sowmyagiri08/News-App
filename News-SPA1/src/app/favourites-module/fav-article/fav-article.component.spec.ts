import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FavArticleComponent } from './fav-article.component';

describe('FavArticleComponent', () => {
  let component: FavArticleComponent;
  let fixture: ComponentFixture<FavArticleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [FavArticleComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FavArticleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
