import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator, PageEvent } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { PagedResults } from '../../interfaces/paged.results';
import { User } from '../../interfaces/user';
import { SnackBarService } from '../../services/snack.bar.service';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  filter: string;
  pageEvent: PageEvent;
  pagedResults: PagedResults<User>;
  dataSource: MatTableDataSource<User>;
  pageSizeOptions = [5, 10, 25, 100];
  displayedColumns: string[] = ['name', 'lastName', 'email', 'phoneNumber', 'category', 'actions'];

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(private userService: UserService, private snackBarService: SnackBarService,
              private router: Router) { }

  ngOnInit(): void {
    this.setUsers();
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }

  applyFilter(event?: Event) {
    let filterValue = (event?.target as HTMLInputElement).value.trim(); // TODO: Add spinner with boolean variable
    this.setUsers(filterValue);
  }

  setUsers(filter?: string, pageIndex?: number, pageSize?: number) {
    this.userService.getAllFiltered$(filter, pageIndex, pageSize).subscribe({
      next: users => {
        this.pagedResults = users;
        this.dataSource = new MatTableDataSource(this.pagedResults.results)
      },
      error: err => { console.log(err) }
    });
  }

  deleteUser(id: number) {
    this.userService.delete(id).subscribe({
      next: () => {
        this.setUsers();
        this.snackBarService.openSnackBar('User deleted successfully', { duration: 2000});
      }
    });
  }

  editUser(user?: User) {
    this.router.navigate(['/dashboard/save-user'], { queryParams: { userToEdit: user } }  ); 
  }
}