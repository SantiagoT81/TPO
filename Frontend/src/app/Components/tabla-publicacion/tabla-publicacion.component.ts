import { Component, Directive, EventEmitter, Input, Output, QueryList, ViewChildren } from '@angular/core';
import { DecimalPipe, NgFor } from '@angular/common';
import { UploadDTO } from 'src/app/Models/UploadDTO';
import { UploadService } from 'src/app/Services/upload.service';
import { UsuarioService } from 'src/app/Services/usuario.service';
@Component({
  selector: 'app-tabla-publicacion',
  templateUrl: './tabla-publicacion.component.html',
  styleUrls: ['./tabla-publicacion.component.css']
})
export class TablaPublicacionComponent {
  publicaciones: UploadDTO[] = []
  constructor(private uploadService: UploadService, private usuarioService: UsuarioService){}
  ngOnInit(): void{
    console.log(this.publicaciones.length)
    this.getAll()
  }
  getAll(){
    this.uploadService.getAll().subscribe((data) => {
      this.publicaciones = data;
    })
  }

deleteOne(publicacion: any) {
  console.log('Antes:', this.publicaciones);
  console.log('Ahora:', publicacion);
  
  this.uploadService.delete(publicacion.id).subscribe(
    () => {
      const indice: number = this.publicaciones.indexOf(publicacion);
      if (indice !== -1) {
        this.publicaciones.splice(indice, 1);
      }
      console.log('After deletion:', this.publicaciones);
    }
  );
}

}
