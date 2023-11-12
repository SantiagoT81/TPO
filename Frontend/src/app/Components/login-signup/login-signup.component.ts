import { Component } from '@angular/core';
import { Usuario } from 'src/app/Models/Usuario';
import { UsuarioService } from 'src/app/Services/usuario.service';
import { Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-login-signup',
  templateUrl: './login-signup.component.html',
  styleUrls: ['./login-signup.component.css']
})
export class LoginSignupComponent {
  mostrarLogin: boolean = true;
  constructor(private usuarioService: UsuarioService, private router:Router, private fb: FormBuilder){}

  
  loggearse(forma: any) {
    this.usuarioService.getByUsername(forma.username).subscribe(
      (data) => {
        const usuario: Usuario = data;
  
        if (usuario === null) {
          window.alert("Usuario no encontrado");
        } else if (usuario && usuario.pass === forma.contrasenia) {
          //Guardarlo en sessionstorage para que al hacer una publicación se use el nombre del usuario actual.
          sessionStorage.setItem("usuario", JSON.stringify(usuario));
          this.router.navigate(['/home']);
        } else {
          window.alert("Contraseña o usuario incorrecto");
        }
      },
      (error) => {
        //Para notificar de que el usuario no se encontró.
        if (error.status === 404) {
          window.alert("Usuario no encontrado");
        } else {
          console.error('Error:', error);
          window.alert("Error al intentar iniciar sesión");
        }
      }
    );
  }

  toggleMostrarLogin(){
    this.mostrarLogin = !this.mostrarLogin;
  }

  registrarse(forma: any) {
    const usuario: Usuario = new Usuario();
    usuario.email = forma.correo;
    usuario.username = forma.username;
    usuario.pass = forma.contrasenia;
  
    this.usuarioService.post(usuario).subscribe(
      (response) => {
        window.alert("Usuario registrado exitosamente");
      },
      (error: { status: number }) => {
        console.log(error.status);
        if (error.status === 409) {
          window.alert("Ese nombre de usuario ya está en uso");
        }
      }
    );
  }
}
