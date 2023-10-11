package br.com.szabohenrique.todolist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication; // Para usar esse framework necessitamos importar ele 

@SpringBootApplication // Iremos usar o Springboot framework
public class TodolistApplication { 

	public static void main(String[] args) {
		SpringApplication.run(TodolistApplication.class, args); // aqui tem um container por debaixo dos panos (tomcat)
	}

}