import { Component, OnInit } from '@angular/core';
import { Libro } from 'src/app/Models/Libro';
import { LibroService } from 'src/app/Services/libro.service';

@Component({
  selector: 'app-seleccion',
  templateUrl: './seleccion.component.html',
  styleUrls: ['./seleccion.component.css']
})
export class SeleccionComponent implements OnInit{
  libros: Libro[] = [] 
  constructor(private libroService: LibroService){}
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
}
