import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './views/home/home.component';
import { AgregarComponent } from './views/agregar/agregar.component';
const routes: Routes = [
  {path: "", component:HomeComponent},
  {path: "agregar", component: AgregarComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
