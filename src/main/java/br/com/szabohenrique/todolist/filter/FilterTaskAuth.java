package br.com.szabohenrique.todolist.filter;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import at.favre.lib.crypto.bcrypt.BCrypt;
import br.com.szabohenrique.todolist.user.IUserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Component
public class FilterTaskAuth extends OncePerRequestFilter {

    @Autowired
    private IUserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
                // pegar autenticação (usuário e senha)
                var authorization = request.getHeader("Authorization");

                // Mascarar as credenciais do usuário
                var authEncoded = authorization.substring("Basic".length()).trim();

                // Passar credenciais para um array de bytes
                byte[] authDecode = Base64.getDecoder().decode(authEncoded);

                // Uma string que decodifica as credenciais em usuário e senha 
                var authString = new String(authDecode);
                String[] credentials = authString.split(":");
                String username = credentials[0];
                String password = credentials[1];

                // Validar Usuário 
                var user = this.userRepository.findByusername(username);

                if (user == null) {
                    response.sendError(401);
                } else {
                    // Validar a senha do usuário 
                    var passwordVerify = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());
                    if (passwordVerify.verified == true) {
                        // Segue viagem
                         filterChain.doFilter(request, response);
                    } else {
                        response.sendError(401);
                    }
                }

    }

}
