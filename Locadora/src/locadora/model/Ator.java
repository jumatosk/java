/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora.model;

import java.util.ArrayList;
/**
 *
 * @author jumat
 */
public class Ator {
    private Integer codigoAtor;
    private String nome;
    private String nacionalidade;
    private ArrayList<Filme> filmes = new ArrayList<Filme>();
    
    public Ator () {
        
    }
    
    public Ator (String nome, String nacionalidade) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
    }

    public Integer getCodigoAtor() {
        return codigoAtor;
    }

    public String getNome() {
        return nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public ArrayList<Filme> getFilmes() {
        return filmes;
    }

    public void setCodigoAtor(Integer codigoAtor) {
        this.codigoAtor = codigoAtor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public void setFilmes(ArrayList<Filme> filmes) {
        this.filmes = filmes;
    }
    
    public void cadastrarAtor(Ator ator) {
        
    }
    
}
