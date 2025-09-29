package org.formation.controller;

import org.formation.model.Produit;
import org.formation.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class ProduitController {

    @Autowired
    private ProduitRepository produitRepository;

    @RequestMapping("/produit/liste")
    public String listProduct(Model model) {
        List<Produit> produits = produitRepository.findAll();
        System.out.println("Produits trouvés par 'findAll()' : " + produits);
        model.addAttribute("produits", produits);
        return "produit/liste";
    }

    @RequestMapping("/produit/creer")
    public String createProductForm() {
        return "produit/creer";
    }

    @PostMapping(path = "/produit/creer")
    public String createProduct (Model model, @RequestParam String produitNom, @RequestParam BigDecimal produitPrix, @RequestParam Integer produitStock) {
        model.addAttribute("nom", produitNom);
        model.addAttribute("prix", produitPrix);
        model.addAttribute("stock", produitStock);

        Produit nouveauProduit = new Produit();
        nouveauProduit.setNom(produitNom);
        nouveauProduit.setPrix(produitPrix);
        nouveauProduit.setStock(produitStock);
        produitRepository.save(nouveauProduit);

        return "produit/details";
    }

    @RequestMapping("/produit/details")
    public String readProduct(Model model) {
        model.addAttribute("product_id", "1");
        return "produit/details";
    }

    @RequestMapping("/produit/modifier")
    public String updateProduct(Model model) {
        return "produit/modifier";
    }

    @RequestMapping("/produit/suprimer")
    public String deleteProduct(Model model) {
        return "produit/suprimer";
    }

}
