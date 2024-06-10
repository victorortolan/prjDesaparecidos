package com.lp1.prjDesaparecidos.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class MainController {

    @GetMapping("")
    public String showHome() {
        return "index";
    }

    @GetMapping("login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("lista")
    public String showListaDesaparecidos() {
        return "lista";
    }

    @GetMapping("desaparecido")
    public String showAddDesaparecido() {
        return "desaparecido";
    }

    @GetMapping("atualizar")
    public String showAtualizarDesaparecido(@RequestParam("id") String id, Model model) {
        model.addAttribute("id", id);
        return "atualizar";
    }
}
