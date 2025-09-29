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

    /* CREATE */

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

        List<Produit> produits = produitRepository.findAll();
        model.addAttribute("produits", produits);
        return "produit/liste";
    }

    /* READ */

    @RequestMapping("/produit/liste")
    public String listProduct(Model model) {
        List<Produit> produits = produitRepository.findAll();
        model.addAttribute("produits", produits);
        return "produit/liste";
    }

    @RequestMapping("/produit/details/{produitId}")
    public String readProduct(Model model, @PathVariable Long produitId) {
        Produit produit = findByIdOrFallback(model , produitId);
        if (produit == null) { return  "produit/liste"; }

        model.addAttribute("produit", produit);
        return "produit/details";
    }

    /* UPDATE */

    @RequestMapping("/produit/modifier/{produitId}")
    public String updateProductForm(Model model, @PathVariable Long produitId) {
        Produit produit = findByIdOrFallback(model , produitId);
        if (produit == null) { return  "produit/liste"; }

        model.addAttribute("produit", produit);
        return "produit/modifier";
    }

    @PostMapping(path = "/produit/modifier")
    public String updateProduct(Model model, @RequestParam Long produitId, @RequestParam String produitNom, @RequestParam BigDecimal produitPrix, @RequestParam Integer produitStock) {
        Produit produit = findByIdOrFallback(model , produitId);
        if (produit == null) { return  "produit/liste"; }

        produit.setNom(produitNom);
        produit.setPrix(produitPrix);
        produit.setStock(produitStock);
        produitRepository.save(produit);

        List<Produit> produits = produitRepository.findAll();
        model.addAttribute("produits", produits);
        return "produit/liste";
    }

    /* DELETE */

    @RequestMapping("/produit/supprimer/{produitId}")
    public String deleteProduct(Model model, @PathVariable Long produitId) {
        Produit produit = findByIdOrFallback(model , produitId);
        if (produit == null) { return  "produit/liste"; }

        produitRepository.delete(produit);

        List<Produit> produits = produitRepository.findAll();
        model.addAttribute("produits", produits);
        return "produit/liste";
    }

    /* PRIVATE METHODS */

    private Produit findByIdOrFallback(Model model, @PathVariable Long produitId) {
        Produit produit = produitRepository.findById(produitId).orElse(null);
        if (produit == null) {
            System.out.println("Produit n'existe pas !");
            List<Produit> produits = produitRepository.findAll();
            model.addAttribute("produits", produits);
            return null;
        }
        return produit;
    }

}
