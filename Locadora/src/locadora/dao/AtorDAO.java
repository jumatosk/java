/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import locadora.model.Ator;

/**
 *
 * @author jumat
 */
public class AtorDAO {
    public void cadastrarAtor(Ator ator) throws ExceptionDAO{
        String insert = "insert into ator (nome, nacionalidade) values (?, ?)";
        PreparedStatement ps = null;
        Connection conn = null;
        
        try {
            conn = new ConnectionMVC().getConnection();
            ps = conn.prepareStatement(insert);
            
            ps.setString(1, ator.getNome());
            ps.setString(2, ator.getNacionalidade());
            ps.execute();
        } catch (SQLException e) {
            throw new ExceptionDAO("Houve um erro ao cadastrar o ator: " + e);
        } finally {
            try{
                if(ps != null) {ps.close();}
            } catch(SQLException e) {
                throw new ExceptionDAO("Houve um erro ao fechar o statement: " + e);
            }
            
            try {
                if(conn != null) { conn.close(); }
            } catch (SQLException e) {
                throw new ExceptionDAO("Houve um erro ao fechar a conexão: " + e);
            }
        }
    }
}
