package org.formation.controllers;

import org.formation.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/// L'annotation `@RestController` indique que la classe est un contrôleur
/// qui écoute les requêtes web et retourne des données sous forme de réponse HTTP.
/// Elle est une combinaison de `@Controller` et `@ResponseBody`.
@RestController
public class HelloWorldController {
    /// L'annotation `@RequestMapping` est utilisée pour mapper une méthode de
    /// contrôleur à une requête HTTP. Elle définit l'URL et la méthode
    /// HTTP (GET, POST, PUT, DELETE, etc.) que la méthode de controller peut gérer.
    @RequestMapping("/ping")
    public String ping() {
        return "En ligne";
    }
}
