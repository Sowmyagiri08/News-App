import { browser, by, element } from 'protractor';
export class FavouritesPage {
    navigateToFavourites() {
        browser.get('/favourites');
    }

    getAddToFavouritesButton() {
        this.navigateToFavourites();
        return element.all(by.css('#add')).get(0);
    }

    getViewFavouritesButton() {
        this.navigateToFavourites();
        return element.all(by.css('#view')).get(0);
    }

    navigateToAddToFavourites() {
        this.getAddToFavouritesButton().click();
    }

    navigateToViewFavourites() {
        this.getViewFavouritesButton().click();
    }

    getKeywordInput() {
        this.navigateToAddToFavourites();
        return element(by.css('#keyword'));
    }

    getSearchButton() {
        this.navigateToAddToFavourites();
        return element(by.css('#search'));
    }


}
