import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { map, pipe } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  backendUrl: string = environment.api || 'http://localhost:8080/';

  constructor(private readonly httpClient: HttpClient) {}

  login(credentials: any): any {
    return this.httpClient.post(`${this.backendUrl}]]login`, credentials).pipe(
      map((response: any) => {
        console.log(response);
        return response;
      })
    );
  }
}
