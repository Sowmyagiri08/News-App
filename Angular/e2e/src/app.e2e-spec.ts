import { AppPage } from './app.po';
import { browser, element, logging, by } from 'protractor';

describe('News_SPA Testing', () => {

  const page = new AppPage();

  beforeAll(() => {
    page.navigateTo();
  });

  it('should load trending page on app launch', () => {

    expect(browser.getCurrentUrl()).toContain('trending');
  });

  it('should go to login page on click', () => {
    const login = page.getLoginLink();
    login.click();
    expect(browser.getCurrentUrl()).toContain('login');
  });

  it('should redirect to favourites page on successful login', () => {
    const login = page.getLoginLink();
    login.click();
    const username = page.getUsernameInput();
    username.sendKeys('admin');
    const password = page.getPasswordInput();
    password.sendKeys('123pass234');

    const submit = page.getSubmitButton();
    submit.click();
    expect(browser.getCurrentUrl()).toContain('favourites');
  });

  it('should stay on login page on unsuccessful login', () => {
    const login = page.getLoginLink();
    login.click();
    const username = page.getUsernameInput();
    username.sendKeys('admin');
    const password = page.getPasswordInput();
    password.sendKeys('123pass');

    const submit = page.getSubmitButton();
    submit.click();
    expect(browser.getCurrentUrl()).toContain('login');
  });





});


