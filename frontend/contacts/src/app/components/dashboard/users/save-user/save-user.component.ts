import { Component, OnInit } from '@angular/core';
import { Form, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar, _SnackBarContainer } from '@angular/material/snack-bar';
import { Router, RouterLink } from '@angular/router';
import { Category } from 'src/app/components/interfaces/category';
import { User } from 'src/app/components/interfaces/user';
import { CategoryService } from 'src/app/components/services/category.service';
import { SnackBarService } from 'src/app/components/services/snack.bar.service';
import { UserService } from 'src/app/components/services/user.service';

@Component({
  selector: 'app-save-user',
  templateUrl: './save-user.component.html',
  styleUrls: ['./save-user.component.css']
})
export class SaveUserComponent implements OnInit {
  
  userToSave: User;
  form: FormGroup;
  categories: Category[];
  emailAlreadyExists: boolean;

  constructor(private userService: UserService, private categoryService: CategoryService, private snackBarService: SnackBarService,
              private formBuilder: FormBuilder, private router: Router) {
                
    this.userToSave = this.router.getCurrentNavigation()?.extras?.queryParams['userToEdit'];
    this.form = formBuilder.group({
      firstName: [this.userToSave?.firstName, Validators.required],
      lastName: [this.userToSave?.lastName, Validators.required],
      email: [this.userToSave?.email, Validators.required],
      phoneNumber: [this.userToSave?.phoneNumber, Validators.required],
      category: [this.userToSave?.category],
    });
   }

  ngOnInit(): void {
    this.setCategories();
  }

  setCategories() {
    this.categoryService.getAll$().subscribe({
      next: categories => { this.categories = categories }
    });
  }

  getUserByEmail() {
    if (this.form.value.email.trim() == this.userToSave?.email) {
      return;
    }
    this.emailAlreadyExists = false;
    this.userService.getByEmail$(this.form.value.email.trim()).subscribe({
      next: user => {
        if (user != null) {
          this.form.controls['email'].setErrors({'incorrect': true});
          this.emailAlreadyExists = true;
        }
      }
    });
  }

  addUser() {
    const user: User = {
      id: this.userToSave?.id,
      firstName: this.form.value.firstName,
      lastName: this.form.value.lastName,
      email: this.form.value.email,
      phoneNumber: this.form.value.phoneNumber,
      category: this.form.value.category,
      changesHistory: this.form.value.changesHistory
    }
    this.userService.save$(user).subscribe({
      next: () => {
        this.router.navigate(['/dashboard/users']);
        this.snackBarService.openSnackBar('The user has been added succesfully.', {
          duration: 1500
        });
      }
    });
  }

  compareObjects(a: Category, b: Category): boolean {
    return a.category == b.category;
  }
}