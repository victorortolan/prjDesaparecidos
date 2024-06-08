package com.lp1.prjDesaparecidos.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Desaparecidos_beta")
public class Desaparecido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private int idade;
    private String cor;
    private String cabelos;
    private String documento;
    private String cidade;
    private boolean encontrado;

    // private String data_desaparecimento;
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getCor() {
        return cor;
    }

    public String getCabelos() {
        return cabelos;
    }

    public String getDocumento() {
        return documento;
    }

    public String getCidade() {
        return cidade;
    }

    public boolean isEncontrado() {
        return encontrado;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setCabelos(String cabelos) {
        this.cabelos = cabelos;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEncontrado(boolean encontrado) {
        this.encontrado = encontrado;
    }

    public Desaparecido(Long id, String nome, int idade, String cor, String cabelos, String documento, String cidade,
            boolean encontrado) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.cor = cor;
        this.cabelos = cabelos;
        this.documento = documento;
        this.cidade = cidade;
        this.encontrado = encontrado;
    }

}
