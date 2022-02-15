import { Component, OnInit } from '@angular/core';
import { Form, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar, _SnackBarContainer } from '@angular/material/snack-bar';
import { Router, RouterLink } from '@angular/router';
import { User } from 'src/app/components/interfaces/user';
import { CategoryService } from 'src/app/components/services/category.service';
import { UserService } from 'src/app/components/services/user.service';


export interface Tile {
  color: string;
  cols: number;
  rows: number;
  text: string;
}

@Component({
  selector: 'app-save-user',
  templateUrl: './save-user.component.html',
  styleUrls: ['./save-user.component.css']
})
export class SaveUserComponent implements OnInit {
  
  form: FormGroup;

  foods = [
    {value: 'steak-0', viewValue: 'Steak'},
    {value: 'pizza-1', viewValue: 'Pizza'},
    {value: 'tacos-2', viewValue: 'Tacos'},
  ];

  constructor(private userService: UserService, private categoryService: CategoryService,
              private formBuilder: FormBuilder, private rotuer: Router, private snackBar: MatSnackBar) {
                
    this.form = formBuilder.group({
      firstName: [, Validators.required],
      lastName: [, Validators.required],
      email: [, Validators.required],
      phoneNumber: [, Validators.required],
      category: ['name'],
      notes: [],
    });
   }

  ngOnInit(): void {
  }

  addUser() {
    const user: User = {
      firstName: this.form.value.firstName,
      lastName: this.form.value.lastName,
      email: this.form.value.email,
      phoneNumber: this.form.value.phoneNumber,
      category: this.form.value.category,
      changesHistory: this.form.value.changesHistory
    }
    this.userService.save(user).subscribe({
      next: () => {
        this.rotuer.navigate(['/dashboard/usuarios']);
        this.snackBar.open('The user has been added succesfully', '', {
          duration: 1500
        })
      }

    });
  }

}
