package com.lp1.prjDesaparecidos.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
}
