package org.formation.repository;

import org.formation.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {
    // Le type de l'entité gérée par ce repository est Client.
    // Le type de l'identifiant primaire est Long.
}