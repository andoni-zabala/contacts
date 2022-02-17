import { HttpClient, HttpParams } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { environment } from "src/environments/environment";
import { Category } from "../interfaces/category";

@Injectable({
    providedIn: 'root'
})
export class CategoryService {

    private path: string = environment.apiUrl + '/categories';

    constructor(private httpClient: HttpClient) { }

    getAll$(): Observable<Category[]> {        
        return this.httpClient.get<Category[]>(this.path);
    }
}