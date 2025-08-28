import { Component, OnInit } from '@angular/core';
import { SiginService } from './service/sigin.service';
import { Router } from '@angular/router';

@Component({
    selector: 'app-signin',
    templateUrl: './signin.component.html',
    styleUrls: ['./signin.component.scss']
})
export class SigninComponent implements OnInit {
    test: Date = new Date();
    focus;
    focus1;
    username: string = '';
    password: string = '';
    constructor(
        private siginService: SiginService,
        private router: Router
    ) { }

    ngOnInit() { }

    onLogin() {
        this.siginService.login(this.username, this.password).subscribe({
            next: (res) => {
                if (res && res.access_token) {
                    this.siginService.saveToken(res.access_token);
                    this.router.navigate(['/products']);
                }
            },
            error: (err) => {
                console.error('Login failed', err);
            }
        });
    }
}
