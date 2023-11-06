import { Component } from '@angular/core';
import { LibroService } from 'src/app/Services/libro.service';

@Component({
  selector: 'app-cargar-libro',
  templateUrl: './cargar-libro.component.html',
  styleUrls: ['./cargar-libro.component.css']
})
export class CargarLibroComponent {
  constructor(private libroService: LibroService){}

  autoLibros(){
    let libros = [
      {
        "titulo": "Libro 1",
        "descripcion": "Primer libro",
        "fechaCreacion": "2023-01-01",
        "urlPortada": "y.com"
      },
      {
        "titulo": "Libro 2",
        "descripcion": "Segundo libro",
        "fechaCreacion": "2023-01-01",
        "urlPortada": "y.com"
      },
      {
        "titulo": "Libro 3",
        "descripcion": "Tercer libro",
        "fechaCreacion": "2023-01-01",
        "urlPortada": "y.com"
      }
    ]
    libros.forEach(element => {
      this.libroService.post(element).subscribe((data) =>{
        console.log(data)
      })
    });
  }
}
