import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {UploadDTO} from '../Models/UploadDTO'
@Injectable({
  providedIn: 'root'
})
export class UploadService {
  private url = 'http://localhost:8080/publicaciones'
  constructor(private http: HttpClient) { }
  getAll(): Observable<any>{
    return this.http.get(this.url);
  }
  post(upload: any): Observable<any>{
    return this.http.post(this.url + "/agregar", upload)
  }

  delete(uploadId: number): Observable<any>{
    return this.http.delete(this.url + "/eliminar/" + uploadId)
  }

  update(upload: any, uploadId:number): Observable<any>{
    return this.http.patch(this.url + "/actualizar/" + uploadId, upload)
  }
}
