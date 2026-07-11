package com.hibernate.ferreteria;

import com.hibernate.ferreteria.entity.Articulo;
import com.hibernate.ferreteria.repositorio.RepoArticulo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class FerreteriaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FerreteriaApplication.class, args);
	}

	private RepoArticulo repoArticulo;

	public FerreteriaApplication(RepoArticulo repoArticulo) {
		this.repoArticulo = repoArticulo;
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Aplicacion iniciada correctamente");
		List<Articulo> articulos = repoArticulo.findAll();
		//articulos.stream().forEach(System.out::println);
	}
}
/*
* La interfaz permite que al iniciar el server, spring inicie el metodo run
* */