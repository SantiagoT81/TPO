import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {
  private url = 'http://localhost:8080/usuarios';
  constructor(private http: HttpClient) { }
  getAll(): Observable<any>{
    return this.http.get(this.url)
  }
  getByID(id: number): Observable<any>{
    return this.http.get(this.url + "/" + id)
  }
}
