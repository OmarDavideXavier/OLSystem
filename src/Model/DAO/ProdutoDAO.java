/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Entidades.Fornecedor;
import Model.Entidades.Produto;
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
public class ProdutoDAO {
      private Connection conexao;

    public ProdutoDAO() {
        try {
            this.conexao = BDconexao.getConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void inserir(Produto produto) {
        String sql = "INSERT INTO produto(idproduto,nome,quantidade,tipo,preco) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, produto.getIdproduto());
            ps.setString(2, produto.getNome());
            ps.setFloat(3, produto.getQuantidade());
            ps.setString(4, produto.getTipoProduto());
            ps.setFloat(5, produto.getPreco());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void actualizar(Produto produto) {
        try {
            String sql = "UPDATE produto SET idProduto = ?, nome = ?, quantidade = ?, tipo=?, preco=? WHERE idProduto = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
             ps.setInt(1, produto.getIdproduto());
            ps.setString(2, produto.getNome());
            ps.setFloat(3, produto.getQuantidade());
            ps.setString(4, produto.getTipoProduto());
            ps.setFloat(5, produto.getPreco());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void apagar(Produto produto) {
        String sql = "DELETE FROM produto WHERE idFornecedor = ?";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, produto.getIdproduto());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Produto> todos() {
        try {
            String sql = "SELECT * from produto";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Produto> lista = new ArrayList<>();
            while (rs.next()) {
                Produto c = new Produto();
                c.setIdproduto(rs.getInt("idProduto"));
                c.setNome(rs.getString("Nome"));
                c.setQuantidade(rs.getFloat("Quantidade"));
                 c.setTipoProduto(rs.getString("Tipo"));
                 c.setPreco(rs.getFloat("Preco"));
                lista.add(c);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }
    }
}

