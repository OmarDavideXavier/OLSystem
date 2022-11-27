/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Entidades.FornecedorM;
import Model.Entidades.ProdutoM;
import View.Interface.Compra;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Omar Davide Xavier
 */
public class ProdutoDAO {

    private Connection conexao;
    public float subtotal=0;

    public ProdutoDAO() {
        try {
            this.conexao = BDconexao.getConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void inserir(ProdutoM produto) {
        String sql = "INSERT INTO produto(idproduto,nome,quantidade,preco) VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, produto.getIdproduto());
            ps.setString(2, produto.getNome());
            ps.setFloat(3, produto.getQuantidade());
            ps.setFloat(4, produto.getPreco());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void actualizar(ProdutoM produto) {
        try {
            String sql = "UPDATE produto SET idProduto = ?, nome = ?, quantidade = ?, tipo=?, preco=? WHERE idProduto = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, produto.getIdproduto());
            ps.setString(2, produto.getNome());
            ps.setFloat(3, produto.getQuantidade());
            ps.setFloat(4, produto.getPreco());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void apagar(ProdutoM produto) {
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

    public List<ProdutoM> todos() {
        try {
            String sql = "SELECT * from produto";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<ProdutoM> lista = new ArrayList<>();
            while (rs.next()) {
                ProdutoM c = new ProdutoM();
                c.setIdproduto(rs.getInt("idProduto"));
                c.setNome(rs.getString("Nome"));
                c.setQuantidade(rs.getFloat("Quantidade"));
                c.setPreco(rs.getFloat("Preco"));
                lista.add(c);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }
    }
    
    
      //Metodo que retorna Tzabela preenchida
    public JScrollPane MostrarTabelaTodos() {
        JTable tabela=new JTable();
        tabela.setPreferredScrollableViewportSize(new Dimension(705, 420));
        DefaultTableModel dtm = new DefaultTableModel();

        Object[] coluna = new Object[4];
        coluna[0] = "Id Produto";
        coluna[1] = "Nome";
        coluna[2] = "Quantidade";
        coluna[3] = "Preco";
        dtm.setColumnIdentifiers(coluna);

        Object[] dados = new Object[4];

        for (int i = 0; i < todos().size(); i++) {
            dados[0] = todos().get(i).getIdproduto() + "";
            dados[1] = todos().get(i).getNome();
            dados[2] = todos().get(i).getQuantidade()+"Kg";
            dados[3] = todos().get(i).getPreco() + "MZN";
            dtm.addRow(dados);
            subtotal=subtotal+todos().get(i).getPreco();
        }
        tabela.setModel(dtm);
        JScrollPane painelScrol = new JScrollPane(tabela);
        return painelScrol;
    }

    
    
    
    
    
        public void CadastrarProduto(Compra c) {
        ProdutoM cm = new ProdutoM(
                Integer.parseInt(c.tIdProduto.getText()),
                c.combTipoProduto.getSelectedItem()+"",
                Float.parseFloat(c.tQuantidade.getText()),
        Float.parseFloat(c.tPreco.getText()));
        inserir(cm);
    }
    
}
