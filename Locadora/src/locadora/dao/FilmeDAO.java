/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora.dao;

/**
 *
 * @author jumat
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import locadora.model.Filme;

public class FilmeDAO {
    public void cadastrarFilme(Filme filme) throws ExceptionDAO{
        String insert =  "insert into filme (titulo, genero, sinopse, duracao) values (?, ?, ?, ?)";
        PreparedStatement ps = null;
        Connection conn = null;
        
        try {
            conn = new ConnectionMVC().getConnection();
            
            ps = conn.prepareStatement(insert);
            ps.setString(1, filme.getTitulo());
            ps.setString(2, filme.getGenero());
            ps.setString(3, filme.getSinopse());
            ps.setInt(4, filme.getDuracao());
            
            ps.execute();
        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao cadastrar o filme: " + e);
        } finally {
            try {
                if(ps != null) 
                    ps.close();
            } catch (SQLException e) {
                throw new ExceptionDAO("Erro ao fechar o statement" + e);
            } try {
                if(conn != null) 
                    conn.close();
            } catch (SQLException e) {
                throw new ExceptionDAO("Erro ao fechar a conexão com o BD." + e);
            }
        }
    }
}
