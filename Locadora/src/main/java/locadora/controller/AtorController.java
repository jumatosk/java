/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora.controller;

import locadora.model.Ator;

/**
 *
 * @author jumat
 */
public class AtorController {
    
    public boolean cadastroAtor(String nome, String nacionalidade) {
        if(nome != null && nome.length() > 0 &&
           nacionalidade != null && nacionalidade.length() > 0) {
            Ator ator = new Ator(nome, nacionalidade);
            ator.cadastrarAtor(ator);
            return true;
        }
        return false;
    }
    
}
