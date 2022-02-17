import { Injectable } from "@angular/core";
import { MatSnackBar, MatSnackBarConfig } from "@angular/material/snack-bar";


@Injectable({
    providedIn: 'root'
})
export class SnackBarService {

    constructor(private matSnackBar: MatSnackBar) { }

    openSnackBar(message: string, config?: MatSnackBarConfig<any>) {
        this.matSnackBar.open(message, 'x', config);
    };
}