import { browser, by, element } from 'protractor';

export class AppPage {
  navigateTo() {
    browser.get('/');
  }

  getTitleText() {
    return element(by.css('app-root .content span')).getText() as Promise<string>;
  }

  getLoginLink() {
    return element.all(by.css('#login')).get(0);
  }

  getUsernameInput() {
    return element.all(by.css('input')).get(0);
  }

  getPasswordInput() {
    return element.all(by.css('input')).get(1);
  }

  getSubmitButton() {
    return element.all(by.css('button')).get(0);
  }
}

