import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { environment } from "src/environments/environment";
import { PagedResults } from "../interfaces/paged.results";
import { User } from "../interfaces/user";



@Injectable({
    providedIn: 'root'
})
export class UserService {

    path: string = environment.apiUrl + '/users';

    constructor(private http: HttpClient) { }

    getAllFiltered(): Observable<PagedResults<User>> {
        return this.http.get<PagedResults<User>>(this.path + '/getAllFiltered');
    }    
}
