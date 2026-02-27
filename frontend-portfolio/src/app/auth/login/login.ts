import { Component, inject, Input, OnInit } from '@angular/core';
import { FormsModule, ReactiveFormsModule, FormGroup, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { Auth } from '../../services/auth';

@Component({
  selector: 'app-login',
  imports: [FormsModule, ReactiveFormsModule],
  templateUrl: './login.html',
  styleUrl: './login.css',
})
export class Login implements OnInit {
  loginForm!: FormGroup;
  submitted = false;
  loginError = '';
  private authService = inject(Auth);

  constructor(private fb: FormBuilder, private router: Router) {}

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      username: [''],
      password: ['']
    });
  }

  onSubmit(): void {
    this.submitted = true;
    this.loginError = '';

    if (this.loginForm.invalid) {
      return;
    }

    const { username, password } = this.loginForm.value;

    this.authService.login(username, password).subscribe({
      next: (response) => {
        localStorage.setItem('token', response.token);
        localStorage.setItem('username', response.username);
        localStorage.setItem('role', response.role);
        localStorage.setItem('expiration date', response.exp);
        this.router.navigate(['/']);
      },
      error: (err) => {
        console.error('Login failed', err);
        this.loginError = 'Invalid username or password';
      }
    });
  }
}
