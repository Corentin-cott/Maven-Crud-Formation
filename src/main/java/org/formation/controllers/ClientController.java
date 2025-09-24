package org.formation.controllers;

import org.formation.entities.Client;
import org.formation.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientController {

    @Autowired
    ClientRepository repository;

    /// **Method GET**
    ///
    /// Méthode classique pour récupérer une ressource.
    ///
    /// `@PathVariable` précise que pour récupérer la variable `long id`, il faut prendre depuis la variable présente entre crochets dans l'URI : `{id}`.
    @RequestMapping(value="/client/{id}", method=RequestMethod.GET)
    public Client get(@PathVariable long id) {
        return repository.findById(id).orElse(null);
    }

    /// **Method POST**
    ///
    /// Méthode spécialisée pour ajouter une nouvelle ressource.
    ///
    /// `@RequestBody` précise que pour récupérer la variable `Client client`, il faut prendre depuis le body de la requête.
    @RequestMapping(value="/client", method=RequestMethod.POST)
    public Client save(@RequestBody Client client) {
        return repository.save(client);
    }

    /// **Method PUT**
    ///
    /// Méthode spécialisée pour mettre à jour une ressource.
    @RequestMapping(value="/client", method=RequestMethod.PUT)
    public Client update(@RequestBody Client client) {
        return repository.save(client);
    }

    /// **Method DELETE**
    ///
    /// Méthode spécialisée pour supprimer une ressource. Ne renvoi rien, sauf le code **200 OK**.
    @RequestMapping(value="/client/{id}", method=RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        repository.deleteById(id);
    }
}
