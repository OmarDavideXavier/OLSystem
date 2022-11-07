/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Entidades.Compra;
import Model.Entidades.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Omar Davide Xavier
 */
public class FornecedorDAO {

    private Connection conexao;

    public FornecedorDAO() {
        try {
            this.conexao = BDconexao.getConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void inserir(Fornecedor fornecedor) {
        String sql = "INSERT INTO fornecedor(idFornecedor,nome,endereco, contacto) VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, fornecedor.getIdfornecedor());
            ps.setString(2, fornecedor.getNomefornec());
            ps.setString(3, fornecedor.getEndereco());
            ps.setInt(4, fornecedor.getContacto());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void actualizar(Fornecedor fornecedor) {
        try {
            String sql = "UPDATE fornecedor SET idFornecedor = ?, nome = ?, endereco = ?, contacto=? WHERE idFornecedor = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, fornecedor.getIdfornecedor());
            ps.setString(2, fornecedor.getNomefornec());
            ps.setString(3, fornecedor.getEndereco());
            ps.setInt(4, fornecedor.getContacto());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void apagar(Fornecedor fornecedor) {
        String sql = "DELETE FROM fornecedor WHERE idFornecedor = ?";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, fornecedor.getIdfornecedor());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Fornecedor> todos() {
        try {
            String sql = "SELECT * from fornecedor";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Fornecedor> lista = new ArrayList<>();
            while (rs.next()) {
                Fornecedor c = new Fornecedor();
                c.setIdfornecedor(rs.getInt("idFornecedor"));
                c.setNomefornec(rs.getString("Nome"));
                c.setEndereco(rs.getString("Endereco"));
                 c.setContacto(rs.getInt("EContacto"));
                lista.add(c);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }
    }
}
