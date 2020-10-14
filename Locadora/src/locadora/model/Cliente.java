/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora.model;

import java.util.ArrayList;
import java.util.Date;
import locadora.dao.ClienteDAO;
import locadora.dao.ExceptionDAO;
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
    
    public Cliente(){
        
    }
    
    public Cliente(String nome, String cpf, String email, String endereco, Date dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
    }

    public void setCodigoCliente(Integer codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setItens(ArrayList<Item> itens) {
        this.itens = itens;
    }

    public Integer getCodigoCliente() {
        return codigoCliente;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getEndereco() {
        return endereco;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public ArrayList<Item> getItens() {
        return itens;
    }
    
    public void cadastrarCliente(Cliente cliente) throws ExceptionDAO {
        new ClienteDAO().cadastrarCliente(cliente);
    }
    
}
