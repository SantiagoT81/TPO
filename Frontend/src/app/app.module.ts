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
import { FormsModule } from '@angular/forms';
import { TablaPublicacionComponent } from './Components/tabla-publicacion/tabla-publicacion.component';
import { DescripcionPublicacionComponent } from './Components/descripcion-publicacion/descripcion-publicacion.component';
import { NotificacionComponent } from './Components/notificacion/notificacion.component';
import { ActualizadorPublicacionComponent } from './Components/actualizador-publicacion/actualizador-publicacion.component';
import { CargarLibroComponent } from './Components/cargar-libro/cargar-libro.component';

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
    TablaPublicacionComponent,
    DescripcionPublicacionComponent,
    NotificacionComponent,
    ActualizadorPublicacionComponent,
    CargarLibroComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
