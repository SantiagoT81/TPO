import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Libro } from '../Models/Libro';


@Injectable({
  providedIn: 'root'
})
export class LibroService {
  private url = 'http://localhost:8080/libros'
  constructor(private http: HttpClient) { }
  getAll(): Observable<any>{
    return this.http.get(this.url);
  }
  post(libro:any): Observable<any>{
    return this.http.post(this.url + "/agregar", libro)
  }
}
