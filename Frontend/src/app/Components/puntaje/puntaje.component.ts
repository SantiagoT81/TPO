import { Component, Input } from '@angular/core';
import { NgbRatingConfig } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-puntaje',
  templateUrl: './puntaje.component.html',
  styleUrls: ['./puntaje.component.css']
})
export class PuntajeComponent {
  @Input() selectedRating!: number;
  @Input() seleccionable!: boolean;

  constructor(config: NgbRatingConfig){
    config.max = 5;
  }
}
