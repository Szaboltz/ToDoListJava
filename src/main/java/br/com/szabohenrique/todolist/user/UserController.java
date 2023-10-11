package br.com.szabohenrique.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    private IUserRepository userRepository;

    // Iremos passar o objeto como parametro para esse metodo
    @PostMapping("/")
    public ResponseEntity create(@RequestBody UserModel userModel) { 
        var user = this.userRepository.findByusername(userModel.getUsername());

        if (user != null) {
           System.out.println("Usuário existente");
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já existe");
        }

        var userCreated = this.userRepository.save(userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }
}
