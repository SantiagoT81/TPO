import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './views/home/home.component';
import { AgregarComponent } from './views/agregar/agregar.component';
import { LoginSignupComponent } from './Components/login-signup/login-signup.component';
const routes: Routes = [
  {path: "", component: LoginSignupComponent },
  {path: "agregar", component: AgregarComponent},
  {path: "home", component:HomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
