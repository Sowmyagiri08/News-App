import { TestBed, async, inject } from '@angular/core/testing';

import { CanActivateFavouritesGuard } from './can-activate-favourites.guard';

describe('CanActivateFavouritesGuard', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CanActivateFavouritesGuard]
    });
  });

  it('should ...', inject([CanActivateFavouritesGuard], (guard: CanActivateFavouritesGuard) => {
    expect(guard).toBeTruthy();
  }));
});
