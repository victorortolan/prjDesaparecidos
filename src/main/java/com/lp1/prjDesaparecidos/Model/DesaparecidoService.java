package com.lp1.prjDesaparecidos.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DesaparecidoService {
    @Autowired
    private DesaparecidoRepository repository;

    public Desaparecido adicionaDes(Desaparecido des) {
        return repository.save(des);
    }

    public void deletaDes(Long id) {
        repository.deleteById(id);
    }
}
