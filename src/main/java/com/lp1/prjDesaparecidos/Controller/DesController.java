package com.lp1.prjDesaparecidos.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lp1.prjDesaparecidos.Model.entitys.Desaparecido;
import com.lp1.prjDesaparecidos.Model.services.DesaparecidoService;

@RestController
@RequestMapping(path = "/api/v1/")
public class DesController {

    @Autowired
    private DesaparecidoService service;

    @PostMapping("/adiciona")
    public ResponseEntity<String> addDesaparecido(@RequestBody Desaparecido des) {
        service.adicionaDes(des);
        return ResponseEntity.status(HttpStatus.OK).body("Adicionado.");
    };

    @DeleteMapping("/deleted/{id}")
    public ResponseEntity<String> delDesaparecido(@PathVariable Long id) {
        service.deletaDes(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deletado da Listagem.");
    };

    @GetMapping("/lista")
    public ResponseEntity<List<Desaparecido>> getDesaparecidos() {
        List<Desaparecido> response = service.getDesaparecidos();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // @PutMapping("/desaparecido/{id}")
    // public void atualizaDesaparecido(@PathVariable Long id,@RequestBody
    // Desaparecido des){
    // service.update();
    // }
}
