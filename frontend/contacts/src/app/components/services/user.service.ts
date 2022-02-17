import { HttpClient, HttpParams } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { environment } from "src/environments/environment";
import { PagedResults } from "../interfaces/paged.results";
import { User } from "../interfaces/user";

@Injectable({
    providedIn: 'root'
})
export class UserService {

    private path: string = environment.apiUrl + '/users';

    constructor(private httpClient: HttpClient) { }

    getAllFiltered$(filter: string = '', page: number = 0, pageSize: number = 10): Observable<PagedResults<User>> {
        const params = new HttpParams().append('nameOrLastName', filter).append('page', page).append('size', pageSize);
        
        return this.httpClient.get<PagedResults<User>>(this.path + '/getAllFiltered', {params} );
    }

    getByEmail$(email: string): Observable<User> {
        return this.httpClient.get<User>(this.path + '/by-email/' + email);
    }

    delete(id: number) {
        return this.httpClient.delete(this.path + '/' + id);
    }

    save$(user: User):  Observable<User> {
        return this.httpClient.post<User>(this.path, user);
    }
}
