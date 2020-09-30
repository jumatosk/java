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
public class Filme {
    private Integer codigoFilme;
    private String titulo;
    private String genero;
    private String sinopse;
    private Integer duracao;
    private ArrayList<Item> itens = new ArrayList<Item>();
    private ArrayList<Ator> atores = new ArrayList<Ator>(); 

    public Filme(String titulo, String genero, String sinopse, int duracao) {
        this.titulo = titulo;
        this.genero = genero;
        this.sinopse = sinopse;
        this.duracao = duracao;
    }
    

    public Integer getCodigoFilme() {
        return codigoFilme;
    }

    public void setCodigoFilme(Integer codigoFilme) {
        this.codigoFilme = codigoFilme;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Item> itens) {
        this.itens = itens;
    }

    public ArrayList<Ator> getAtores() {
        return atores;
    }

    public void setAtores(ArrayList<Ator> atores) {
        this.atores = atores;
    }
    
    public void cadastrarFilme(Filme filme){
        
    }
    
}
