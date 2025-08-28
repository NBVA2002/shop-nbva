import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class SiginService {
    private tokenUrl = 'http://localhost:8080/realms/nbva-realm/protocol/openid-connect/token';

    constructor(private http: HttpClient) { }

    login(username: string, password: string): Observable<any> {
        const body = new HttpParams()
            .set('client_id', 'nbva-app')
            .set('scope', 'openid')
            .set('grant_type', 'password')
            .set('client_secret', 'VAvx3ucjQiXnaBfMEZqjNgIpOlbaWGks')
            .set('username', username)
            .set('password', password);

        const headers = new HttpHeaders({
            'Content-Type': 'application/x-www-form-urlencoded'
        });

        return this.http.post(this.tokenUrl, body.toString(), { headers });
    }

    saveToken(token: string) {
        localStorage.setItem('access_token', token);
    }

    getToken(): string | null {
        return localStorage.getItem('access_token');
    }

    logout() {
        localStorage.removeItem('access_token');
    }
}
