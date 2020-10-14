/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import locadora.model.Cliente;

/**
 *
 * @author jumat
 */
public class ClienteDAO {
    public void cadastrarCliente(Cliente cliente) throws ExceptionDAO{
        String insert = "insert into cliente(nome, cpf, email, endereco, dataNascimento) values(?, ?, ?, ?, ?)";
        PreparedStatement ps = null;
        Connection conn = null;
        
        try {
            conn = new ConnectionMVC().getConnection();
            ps = conn.prepareStatement(insert);
            
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCpf());
            ps.setString(3, cliente.getEmail());
            ps.setString(4, cliente.getEndereco());
            ps.setDate(5, new java.sql.Date(cliente.getDataNascimento().getTime()));
            ps.execute();

        } catch (SQLException e) {
            throw new ExceptionDAO("Houve um erro ao inserir o cliente: " + e);
        } finally {
            try {
                if(ps != null) { ps.close(); }
            } catch (SQLException e) {
                throw new ExceptionDAO("Houve um erro ao fechar o statement: " + e);
            }
            
            try {
                if(conn != null) { conn.close(); }
            } catch (Exception e) {
                throw new ExceptionDAO("Houve um erro ao fechar a conexão." + e);
            }
        }
    }
}
