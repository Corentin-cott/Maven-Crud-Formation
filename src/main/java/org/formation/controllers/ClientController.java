package org.formation.controllers;

import org.formation.entities.Client;
import org.formation.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientController {

    @Autowired
    ClientRepository repository;

    @RequestMapping(value="/client/{id}", method=RequestMethod.GET)
    public Client get(@PathVariable long id) {
        return repository.findById(id).orElse(null);
    }

    @RequestMapping(value="/client/{id}", method=RequestMethod.POST)
    public Client save(@RequestBody Client client) {
        return repository.save(client);
    }

    @RequestMapping(value="/client/{id}", method=RequestMethod.PUT)
    public Client update(@RequestBody Client client) {
        return repository.save(client);
    }

    @RequestMapping(value="/client/{id}", method=RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        repository.deleteById(id);
    }
}
