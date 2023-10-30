package com.example.demo.Services;

import com.example.demo.DTO.LibroDTO;
import com.example.demo.DTO.UsuarioDTO;
import com.example.demo.Models.Autor;
import com.example.demo.Models.Libro;
import com.example.demo.Models.Usuario;
import com.example.demo.Repositories.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.springframework.http.HttpStatus.*;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository ur;
    private final ModelMapper mm = new ModelMapper();
    public UsuarioService(UsuarioRepository ur){
        this.ur = ur;
    }
    public Usuario findByID(int id){
        return ur.findById(id).orElse(null);
    }

    public ResponseEntity<?> getUsuarios(){
        try{
            List<UsuarioDTO> usuarioDTOS = new ArrayList<>();
            List<Usuario> usuarios = ur.findAll();
            for(Usuario u: usuarios){
                usuarioDTOS.add(mm.map(u, UsuarioDTO.class));
            }
            return ResponseEntity.status(OK).body(usuarioDTOS);
        }catch(Error e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Ocurrió un error al traer la lista de usuarios");
        }

    }
    public ResponseEntity<?> add(Usuario u){
        try{
            Usuario usuarioExistente = ur.findByUsername(u.getUsername());
            if(usuarioExistente != null){
                return ResponseEntity.status(CONFLICT).body("Usuario preexistente");
            }
            String pass = u.getPassword();
            Pattern patron = Pattern.compile(".*[a-zA-Z].*[0-9].*");
            Matcher matcher = patron.matcher(pass);
            if(matcher.matches()){
                ur.save(u);
                return ResponseEntity.status(CREATED).body(u);
            }
            return ResponseEntity.status(CONFLICT).body("La contraseña debe ser alfanumérica");

        }catch(Error e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(e);
        }
    }

    public ResponseEntity<?> delete(Integer id){
        try{
            if(findByID(id) == null){
                return ResponseEntity.status(NOT_FOUND).body("No se encontró el usuario a eliminar");
            }
            ur.deleteById(id);
            return ResponseEntity.status(OK).build();
        }catch(Error e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body("Ocurrió un error al eliminar el usuario");
        }
    }

    public ResponseEntity<?> update(Usuario u, Integer id){
        try{
            Usuario usuario = findByID(id);
            if(usuario != null){
                if(u.getUsername() != null){
                    usuario.setUsername(u.getUsername());
                }
                if(u.getEmail() != null){
                    usuario.setEmail(u.getEmail());
                }
                if(u.getProfilePic() != null){
                    usuario.setProfilePic(u.getProfilePic());
                }
                ur.save(usuario);
                return ResponseEntity.status(OK).body(usuario);
            }
            return ResponseEntity.status(NOT_FOUND).body("No se encontró el usuario a actualizar");
        }catch(Error e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body("Ocurrió un error al actualizar los datos del usuario");
        }
    }
}
