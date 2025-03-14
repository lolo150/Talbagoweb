package fr.talbagoweb.controller;

import fr.talbagoweb.model.Produit;
import fr.talbagoweb.repository.CategoryRepository;
import fr.talbagoweb.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProduitController {

    @Autowired
    private ProduitRepository produitRepository;

    @Autowired
    private CategoryRepository categorieRepository;

    @GetMapping("/produits")
    public String getAllProduits(Model model) {
        List<Produit> produits = produitRepository.findAll();
        model.addAttribute("produits", produits);
        return "produits";
    }

    @GetMapping("/produits/ajouter")
    public String showAddProduitForm(Model model) {
        model.addAttribute("produit", new Produit());
        model.addAttribute("categories", categorieRepository.findAll());
        return "ajouter-produit";
    }

    @PostMapping("/produits/ajouter")
    public String addProduit(@ModelAttribute Produit produit) {
        produitRepository.save(produit);
        return "redirect:/produits";
    }
}
