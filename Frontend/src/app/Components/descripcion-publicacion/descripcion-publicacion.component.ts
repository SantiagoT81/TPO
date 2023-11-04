import { Component, Input, ViewEncapsulation } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-descripcion-publicacion',
  templateUrl: './descripcion-publicacion.component.html',
  styleUrls: ['./descripcion-publicacion.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class DescripcionPublicacionComponent {
  closeResult!: string
  @Input() texto!: string;
  @Input() titulo!: string;
  constructor(private modalService: NgbModal){}

  openScrollableContent(descripcion: any){
    this.modalService.open(descripcion, {scrollable:true})
  }
}
