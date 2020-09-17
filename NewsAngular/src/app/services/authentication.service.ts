import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {


  constructor(public httpClient: HttpClient) {
  }

  authenticateUser(data) {
    const authenticated = this.httpClient.post('http://localhost:8765/user-auth/api/v1/auth/login', data);

    return authenticated;

  }

  setBearerToken(token: any) {
    localStorage.setItem('bearerToken', token);
  }

  getBearerToken() {
    return localStorage.getItem('bearerToken');
  }

  isUserAuthenticated(token): boolean {

    if (this.getBearerToken()) {
      return true;
    } else {
      return false;
    }
  }

  setUserId(userId: any) {
    localStorage.setItem('userId', userId);
  }

  getUserId() {
    return localStorage.getItem('userId');
  }
}
