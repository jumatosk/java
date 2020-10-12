/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import locadora.model.Cliente;

/**
 *
 * @author jumat
 */
public class ClienteController {
    public boolean cadastrarCliente(String nome, String cpf, String email, String endereco, String dataNascimento) throws ParseException {
        if(nome != null && nome.length() > 0 && cpf != null && cpf.length() > 0 &&
           email != null && email.length() > 0 && endereco != null && endereco.length() > 0 &&
           validarData(dataNascimento)){
            
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date dataNsc = formato.parse(dataNascimento);
            
            Cliente cliente = new Cliente(nome, cpf, email, endereco, dataNsc);
            cliente.cadastrarCliente(cliente);
            return true;
        }
        return false;
    } 
    
    public boolean validarCPF(String cpf) {
        for(int i=0; i<cpf.length(); i++) {
            if(!Character.isDigit((cpf.charAt(i)))) {
                if(! (i == 3 || i == 7 || i == 11)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean validarData(String dataNascimento) {
        for(int i=0; i<dataNascimento.length(); i++) {
            if(!Character.isDigit((dataNascimento.charAt(i)))) {
                if(! (i == 2 || i == 5)) {
                    return false;
                }
            }
        }
        return true;
    }
}
