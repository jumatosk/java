/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora.model;

import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author jumat
 */
public class Cliente {
    private Integer codigoCliente;
    private String nome;
    private String cpf;
    private String email;
    private String endereco;
    private Date dataNascimento;
    private ArrayList<Item> itens = new ArrayList<Item>();
}
