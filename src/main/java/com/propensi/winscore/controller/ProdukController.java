package com.propensi.winscore.controller;

import com.propensi.winscore.model.ProdukModel;
import com.propensi.winscore.service.ProdukService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/produk")
//@PreAuthorize("isAuthenticated()")
public class ProdukController {

    @Autowired
    @Qualifier("ProdukServiceImpl")
    private ProdukService produkService;

    public void setProdukService(ProdukService produkService) {
        this.produkService = produkService;
    }

    @GetMapping()
     public String retrieveAllProduk(Model model) {
        model.addAttribute("produkList", produkService.getRepository().findAll());
        return "pages/ProdukListView.html";
    }

    @PostMapping("/add")
    public String addProduk(@ModelAttribute ProdukModel produk, RedirectAttributes redirectAttributes) {
        return "pages/AddProduk.html";
    }
}
