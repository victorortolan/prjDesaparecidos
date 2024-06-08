package com.lp1.prjDesaparecidos.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lp1.prjDesaparecidos.Model.Desaparecido;
import com.lp1.prjDesaparecidos.Model.DesaparecidoService;

@RestController
@RequestMapping(path = "/api/v1/")
public class DesController {

    @Autowired
    private DesaparecidoService service;

    @PostMapping("/adiciona")
    public String addDesaparecido(@RequestBody Desaparecido des) {
        service.adicionaDes(des);

        return "oi";
    };

    @DeleteMapping("/deleted/{id}")
    public String delDesaparecido(@PathVariable Long id) {
        service.deletaDes(id);
        return "Deletado da Listagem.";
    };
}
