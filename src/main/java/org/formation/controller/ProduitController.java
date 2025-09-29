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

    @RequestMapping("/produit/details/{productId}")
    public String readProduct(Model model, @PathVariable Long productId) {
        Produit produit = produitRepository.findById(productId).orElse(null);
        if (produit == null) {
            System.out.println("Produit n'existe pas !");
            return "produit/liste";
        }
        model.addAttribute("produit", produit);
        return "produit/details";
    }

    @RequestMapping("/produit/creer")
    public String createProductForm() {
        return "produit/creer";
    }

    @PostMapping(path = "/produit/creer")
    public String createProduct (Model model, @RequestParam String produitNom, @RequestParam BigDecimal produitPrix, @RequestParam Integer produitStock) {
        Produit nouveauProduit = new Produit();
        nouveauProduit.setNom(produitNom);
        nouveauProduit.setPrix(produitPrix);
        nouveauProduit.setStock(produitStock);
        produitRepository.save(nouveauProduit);

        return "/index";
    }

    @RequestMapping("/produit/modifier/{productId}")
    public String updateProductForm(Model model, @PathVariable Long productId) {
        Produit produit = produitRepository.findById(productId).orElse(null);
        if (produit == null) {
            return "produit/liste";
        }
        model.addAttribute("produit", produit);
        return "produit/modifier";
    }

    @PostMapping(path = "/produit/modifier")
    public String updateProduct(Model model, @RequestParam Long produitId, @RequestParam String produitNom, @RequestParam BigDecimal produitPrix, @RequestParam Integer produitStock) {
        Produit produitModif = produitRepository.findById(produitId).orElse(null);
        if (produitModif == null) {
            System.out.println("Produit n'existe pas !");
            return "/";
        }
        produitModif.setNom(produitNom);
        produitModif.setPrix(produitPrix);
        produitModif.setStock(produitStock);
        produitRepository.save(produitModif);

        return "/index";
    }

    @RequestMapping("/produit/suprimer/{productId}")
    public String deleteProduct(Model model, @PathVariable Long productId) {
        Produit produit = produitRepository.findById(productId).orElse(null);
        if (produit == null) {
            return "/";
        }
        model.addAttribute("produit", produit);
        return "/index";
    }

}
