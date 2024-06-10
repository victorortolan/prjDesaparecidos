package com.lp1.prjDesaparecidos.Model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lp1.prjDesaparecidos.Model.entitys.Desaparecido;
import com.lp1.prjDesaparecidos.Model.repository.DesaparecidoRepository;

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

    public List<Desaparecido> getDesaparecidos() {
        return repository.findAll();
    }

    public Desaparecido getDesaparecido(Long id) {
        return repository.getReferenceById(id);
    }

    public void updateDesaparecido(Long id, Desaparecido desaparecido) {
        Desaparecido des = repository.getReferenceById(id);
        des.setNome(desaparecido.getNome());
        des.setIdade(desaparecido.getIdade());
        des.setCabelos(desaparecido.getCabelos());
        des.setCidade(desaparecido.getCidade());
        des.setDocumento(desaparecido.getDocumento());
        des.setCor(desaparecido.getCor());
        repository.save(des);
    }
}
