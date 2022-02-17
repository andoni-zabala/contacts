import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { SnackBarService } from '../services/snack.bar.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  form: FormGroup;

  constructor(private formBuilder: FormBuilder, private snackBarService: SnackBarService, private router: Router) {
    this.form = this.formBuilder.group({
      user: ['', Validators.required],
      password:  ['', Validators.required]
    });
   }

  ngOnInit(): void {
  }

  login() { 
    if (this.form.value.user && this.form.value.password) { // TODO: improve login, jwt ?
      localStorage.setItem('userLogged', this.form.value.user);

      this.openSnackBar(this.form.value.user);
      this.router.navigate(['/dashboard']);
    }
  }

  openSnackBar(user: string) {
    this.snackBarService.openSnackBar('Welcome back ' + user + '!', {
      duration: 2000,
      panelClass: ['my-snack-bar']
    })
  }
}
