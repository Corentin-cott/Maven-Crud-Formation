package org.formation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProduitController {

    @RequestMapping("/produit/creer")
    public String createProduct() {
        return "produit/creer";
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
