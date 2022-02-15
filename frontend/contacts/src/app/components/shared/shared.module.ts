import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';


import { MatToolbarModule } from '@angular/material/toolbar';
import { MatFormFieldModule } from '@angular/material/form-field'; 
import { MatInputModule } from '@angular/material/input'; 
import { MatButtonModule } from '@angular/material/button'; 
import { MatSnackBarModule } from '@angular/material/snack-bar'; 
import { MatIconModule } from '@angular/material/icon'; 
import { MatTableModule } from '@angular/material/table'; 
import { MatTooltipModule } from '@angular/material/tooltip'; 
import { MatPaginatorModule } from '@angular/material/paginator'; 
import { MatCardModule } from '@angular/material/card'; 
import { MatGridListModule } from '@angular/material/grid-list'; 
import { MatSelectModule } from '@angular/material/select'; 

import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';


@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    MatToolbarModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatSnackBarModule,
    MatIconModule,
    MatTableModule,
    MatTooltipModule,
    MatPaginatorModule,
    MatCardModule,
    MatGridListModule,
    MatSelectModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  exports: [
    CommonModule,
    MatToolbarModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatSnackBarModule,
    MatIconModule,
    MatTableModule,
    MatTooltipModule,
    MatPaginatorModule,
    MatCardModule,
    MatGridListModule,
    MatSelectModule,
    ReactiveFormsModule,
    HttpClientModule
  ]

})
export class SharedModule { }
