package org.formation.repository;

import org.formation.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

/// Cette interface définit un repository pour les clients, en étendant les fonctionnalités de JpaRepository.
/// Les méthodes de base pour les opérations CRUD (Create, Read, Update, Delete) sont fournies par JpaRepository et n'ont donc pas besoin d'être ajouté manuellement.
public interface ClientRepository extends JpaRepository<Client, Long> {
    // Le type de l'entité gérée par ce repository est Client.
    // Le type de l'identifiant primaire est Long.
}
