package org.formation.repositories.test;

import org.formation.Main;
import org.formation.entities.Client;
import org.formation.repositories.ClientRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/// **L'annotation `@RunWith`** permet de spécifier le runner de test à utiliser pour exécuter les tests JUnit.
/// Dans ce cas, nous utilisons `SpringJUnit4ClassRunner` pour intégrer les fonctionnalités de test de Spring avec JUnit.
///
/// **L'annotation `@SpringBootTest`** permet de configurer le contexte de test Spring Boot.
/// Elle permet de spécifier les classes de configuration à utiliser pour le test, ainsi que d'activer certaines fonctionnalités de test comme l'auto-configuration.
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Main.class)
public class ClientRepositoriesTests {
    /// Ce bout de code permet d'injecter automatiquement une instance de `ClientRepository` dans le test,
    /// ce qui nous permet d'accéder aux méthodes de repository sans avoir à les instancier manuellement.
    @Autowired
    ClientRepository repository;

    /// L'annotation `@Test` indique que la méthode qui la suit est un test JUnit.
    /// Cette annotation est utilisée par le runner de test pour identifier les méthodes à exécuter lors du test.
    /// Elle permet de :
    /// - Identifier les méthodes de test & les exécuter automatiquement
    /// - Gérer les exceptions qui peuvent être levées pendant l'exécution du test,
    ///   en les capturant et en les rapportant comme des erreurs de test si elles ne sont pas attendues.
    @Test
    public void testRepositories() {

        // On commence par créer un client
        Client client = new Client();
        client.setNom("Thomas");
        client.setPrenom("Angelo");
        client.setAge("30");

        // La méthode `repository.save` enregistre le client dans la base
        repository.save(client);

        // Cette ligne vérifie que nous avons éxactement 1 client dans la base, c'est le client précédemment ajouté
        assertEquals(1, repository.findAll().size());

        // Ici, nous vérifions que notre client a bien été mis à jour avec nos `setters`
        Client loadedClient = repository.findById(client.getId()).get();
        assertEquals("Thomas", loadedClient.getNom());
        assertEquals("Angelo", loadedClient.getPrenom());
        assertEquals("30", loadedClient.getAge());

        // Notre client a bien les bons paramètres, nous pouvons le supprimer de la base.
        repository.delete(client);

        // Maintenant, il faut vérifier qu'il a bien été subprimé.
        assertEquals(0, repository.findAll().size());

    }
}
