import { Component, Input } from '@angular/core';
import { Libro } from 'src/app/Models/Libro';
import { LibroService } from 'src/app/Services/libro.service';
import { UploadService } from 'src/app/Services/upload.service';

@Component({
  selector: 'app-formulario-publicacion',
  templateUrl: './formulario-publicacion.component.html',
  styleUrls: ['./formulario-publicacion.component.css']
})
export class FormularioPublicacionComponent {
  showToast = false;
  @Input() modoPublicar!: boolean;
  @Input() publicacionEditable!: any
  selectedRating: number = 0;
  libros: Libro[] = [] 
  constructor(private libroService: LibroService, private uploadService: UploadService){}
  ngOnInit(): void {
      this.getAll()
  }
  getAll() {
    this.libroService.getAll().subscribe((data) => {
      this.libros = data
    })
  }
  ejemplo(id:number){
    alert(id)
  }
  enviar(forma: any){
    const publi: any = ({
      "rate": this.selectedRating,
      "descripcion": forma.descripcion,
      "titulo": forma.titulo,
      "usuario": {
          "id": 1
      },
      "libro": {
          "id": forma.libro
      }
    });
    if(publi.descripcion == "" || publi.titulo == "" || publi.rate == 0){
      console.log(publi)
      window.alert("Por favor rellene todos los campos.")
      return;
    }
    this.uploadService.post(publi).subscribe((data) => {
      console.log(data)
    });
    window.alert("Publicado con éxito.")
  }
  update(forma:any){
    const publi: any = ({
      "id": this.publicacionEditable.id,
      "descripcion": forma.descripcion,
      "titulo": forma.titulo,
      "rate": this.publicacionEditable.rate
    });
    window.alert(this.publicacionEditable.rate)
    this.uploadService.update(publi, publi.id).subscribe((data) => {
      console.log(data)
    })
  }
}
