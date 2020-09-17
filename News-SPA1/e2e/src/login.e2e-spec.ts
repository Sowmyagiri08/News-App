import { browser, by, element } from 'protractor';
import { LoginPage } from './login.po';

describe('Login Page', () => {
    const page = new LoginPage();

    beforeAll(() => {
        page.navigateToLogin();
    });

    it('should contain input box for username', () => {

        expect(page.getUsernameInput()).toBeTruthy();
    });

    it('should contain input box for password', () => {

        expect(page.getPasswordInput()).toBeTruthy();
    });

    it('should contain login button', () => {

        expect(page.getLoginButton()).toBeTruthy();
    });



});
