import { Component, OnInit } from '@angular/core';
import { PagedResults } from '../../interfaces/paged.results';
import { User } from '../../interfaces/user';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  users!: PagedResults<User>;
  displayedColumns: string[] = ['name', 'last_name', 'email', 'phone_number', 'category', 'actions'];

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.getUsers();
  }

  getUsers() {
    this.userService.getAllFiltered().subscribe({
      next: users => {this.users = users},
      error: err => { console.log(err)}
    });
  }

}
