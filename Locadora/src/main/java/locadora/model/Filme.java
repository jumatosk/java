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
    private Long duracao;
    private ArrayList<Item> itens = new ArrayList<Item>();
    private ArrayList<Ator> atores = new ArrayList<Ator>(); 
}
