import { browser, by, element } from 'protractor';
export class LoginPage {

    navigateToLogin() {
        browser.get('/login');
    }

    getUsernameInput() {
        return element(by.css('#username'));
    }

    getPasswordInput() {
        return element(by.css('#passowrd'));
    }

    getLoginButton() {
        return element(by.css('#login'));
    }



}

