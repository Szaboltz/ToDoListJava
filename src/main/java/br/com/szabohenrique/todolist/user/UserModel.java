package br.com.szabohenrique.todolist.user;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "tb_users")
@Data // Lombok (lib) fazendo os get e set do meu código
public class UserModel {
    
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(unique = true) // Isso faz com que ocorra uma validação para o cadastro usuário 
    private String username;
    private String name;
    private String password;

    @CreationTimestamp
    private LocalDateTime createdAt;

    /**
        public void setUsername(String username) {
            this.username = username;
        }

        public String getUsername() {
            return username;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getPassword() {
            return password;
        }
    */
}

