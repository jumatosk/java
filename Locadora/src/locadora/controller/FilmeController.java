/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora.controller;

import locadora.dao.ExceptionDAO;
import locadora.model.Filme;

/**
 *
 * @author jumat
 */
public class FilmeController {

    public boolean cadastrarFilme(String titulo, String genero, String sinopse, int duracao) throws ExceptionDAO {
        if (titulo != null && titulo.length() > 0
                && genero != null && genero.length() > 0
                && sinopse != null && sinopse.length() > 0
                && duracao > 0) {
            Filme filme = new Filme(titulo, genero, sinopse, duracao);
            
            filme.cadastrarFilme(filme);
            return true;       
        }
        return false;
    }

}
