import { browser, by, element } from 'protractor';
import { FavouritesPage } from './favourites.po';

describe('Favourites Page', () => {
    let page = new FavouritesPage();
    beforeAll(() => {
        page = new FavouritesPage();
        page.navigateToFavourites();
    });

    it('should navigate to favourites', () => {
        expect(browser.getCurrentUrl()).toContain('favourites');
    });

    it('should contain add to favourites chip', () => {
        expect(page.getAddToFavouritesButton()).toBeTruthy();
    });

    it('should contain view favourites chip', () => {
        expect(page.getViewFavouritesButton()).toBeTruthy();
    });

    it('should navigate to add to favourites section', () => {
        page.navigateToAddToFavourites();
        expect(browser.getCurrentUrl()).toContain('addtofavourites');
    });

    it('should navigate to view favourites section', () => {
        page.navigateToViewFavourites();
        expect(browser.getCurrentUrl()).toContain('viewfavourites');
    });

    it('Add favourites page should contain input box for keyword', () => {
        expect(page.getKeywordInput()).toBeTruthy();

    });


    it('Add favourites page should contain search button', () => {
        expect(page.getSearchButton()).toBeTruthy();

    });






});

