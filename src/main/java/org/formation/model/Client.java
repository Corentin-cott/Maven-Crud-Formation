package org.formation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/// L'annotation `@Entity` indique que la classe `Client` est une entité de données,
/// c'est-à-dire qu'elle représente une table dans la base de données.
@Entity
public class Client {
    /// **L'annotation `@Id`** indique que le champ `id` est la clé primaire de l'entité `Client`.
    ///
    /// **L'annotation `@GeneratedValue`** indique que l'`id` client sera incrémenté automatiquement
    /// à chaque nouvelle instance de `Client`.
    @Id
    @GeneratedValue
    private long id;
    private String nom;
    private String prenom;
    private String age;

    /// Les getters et setters ci-dessous ont été générés automatiquement à l'aide de la fonctionnalité "Generate" d'IntelliJ.
    /// La méthode :
    ///
    /// - **Clic droit** n'importe où puis choisir **Generate...** dans le menu contextuel.
    /// - Sélection de **Getters and Setters** dans la boîte de dialogue **Generate**.
    /// - Sélection des champs souhaités puis clic sur **OK**

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
