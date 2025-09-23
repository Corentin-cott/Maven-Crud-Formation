package org.formation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/// L'annotation `@SpringBootApplication` est une annotation qui active
/// l'auto-configuration de Spring. Elle équivaut à utiliser les annotations
/// `@Configuration`, `@EnableAutoConfiguration` et `@ComponentScan` ensemble.
/// Elle permet de configurer et de démarrer une application Spring Boot de manière simplifiée.
@SpringBootApplication
public class Main {
    /// La méthode `main` permet de lancer l'application comme une application classique.
    /// Pour lancer Spring, il faut utiliser `SpringApplication.run`.
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}