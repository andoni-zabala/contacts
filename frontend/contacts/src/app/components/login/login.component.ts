import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  form: FormGroup;

  constructor(private formBuilder: FormBuilder, private matSnackBar: MatSnackBar, private router: Router) {
    this.form = this.formBuilder.group({
      user: ['', Validators.required],
      password:  ['', Validators.required]
    });
   }

  ngOnInit(): void {
  }


  login() { 
    if (this.form.value.user && this.form.value.password) { // TODO: improve login, jwt ?
      this.openSnackBar(this.form.value.user);
      this.router.navigate(['dashboard']);
    }
  }

  openSnackBar(user: string) {
    this.matSnackBar.open('Welcome back ' + user, 'Close', {
      duration: 2500,
      panelClass: ['my-snack-bar']
    });
  }
}
