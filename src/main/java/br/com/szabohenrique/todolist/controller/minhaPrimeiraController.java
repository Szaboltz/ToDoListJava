package br.com.szabohenrique.todolist.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Controller é unm componente que é a camada entre a riquisição do user e outras camadas 

@RestController
@RequestMapping("/primeiraRota") // http://localhost:8080/ Aqui seria a rota
public class minhaPrimeiraController {

    /**
     - Metodos de uma requisição HTTP -

     GET - Buscar dado 
     POST - Adicionar um dado 
     PUT - Alterar uma dado 
     DELETE - Remover um dado
     PATCH - Alterar somente uma parte do dado
    */

    @GetMapping("/primeiroMetodo")
    public String primeiraMenssagem() { // Isso aqui é um método de uma classe 
        return "Funcionou"; // Precisa passar um path para a api acessar o metodo
    }
}