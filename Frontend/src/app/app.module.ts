import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PublicacionComponent } from './Components/publicacion/publicacion.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './views/home/home.component';
import { NavComponent } from './Components/nav/nav.component';
import { AgregarComponent } from './views/agregar/agregar.component';
import { FormularioPublicacionComponent } from './Components/formulario-publicacion/formulario-publicacion.component';
import { PuntajeComponent } from './Components/puntaje/puntaje.component';
import { SeleccionComponent } from './Components/seleccion/seleccion.component';

@NgModule({
  declarations: [
    AppComponent,
    PublicacionComponent,
    HomeComponent,
    NavComponent,
    AgregarComponent,
    FormularioPublicacionComponent,
    PuntajeComponent,
    SeleccionComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
