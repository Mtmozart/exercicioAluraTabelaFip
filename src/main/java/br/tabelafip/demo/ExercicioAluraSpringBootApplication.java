package br.tabelafip.demo;

import br.tabelafip.demo.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExercicioAluraSpringBootApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ExercicioAluraSpringBootApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Principal principal = new Principal();
        principal.exibiMenu();
    }

}
