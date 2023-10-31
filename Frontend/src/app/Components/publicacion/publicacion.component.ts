import { Component, OnInit } from '@angular/core';
import { Libro } from 'src/app/Models/Libro';
import { LibroService } from 'src/app/Services/libro.service';

@Component({
  selector: 'app-publicacion',
  templateUrl: './publicacion.component.html',
  styleUrls: ['./publicacion.component.css']
})
export class PublicacionComponent implements OnInit{
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
