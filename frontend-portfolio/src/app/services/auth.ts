import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class Auth {
  private http = inject(HttpClient);
  private apiUrl = 'http://localhost:8080/api/auth/login';

  login(username: string, password: string) {
    return this.http.post<any>(this.apiUrl, { username, password });
  }
}
