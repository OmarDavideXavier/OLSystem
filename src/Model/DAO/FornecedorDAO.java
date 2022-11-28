/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Controller.cFornecedor;
import Model.Entidades.CompraM;
import Model.Entidades.FornecedorM;
import View.Interface.Fornecedor;
import View.Interface.Venda;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Omar Davide Xavier
 */
public class FornecedorDAO {

    private Connection conexao;
    public JTable tabela;

    public FornecedorDAO() {
        tabela = new JTable();
        try {
            this.conexao = BDconexao.getConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Inserir Fornecedor
    public void inserir(FornecedorM fornecedor) {
        String sql = "INSERT INTO fornecedor(idFornecedor,Nome_Fornecedor,endereco, contacto) VALUES(?,?,?,?)";
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

    public void apagar(int id) {
        String sql = "DELETE FROM fornecedor WHERE idFornecedor = ?";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            VerificaRemocao(id);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//Metodo que retorna ArrayList do tipo FornecedorM

    private ArrayList<FornecedorM> todos() {
        ArrayList<FornecedorM> lista = new ArrayList<>();
        try {
            String sql = "SELECT * from fornecedor";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                FornecedorM e = new FornecedorM(
                        rs.getInt("idFornecedor"),
                        rs.getString("Nome_Fornecedor"),
                        rs.getString("Endereco"),
                        rs.getInt("Contacto")
                );
                lista.add(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        return lista;
    }
    ///Mostrar Dados da BD na tabela

    public JScrollPane MostrarTabelaTodos() {
        tabela.setPreferredScrollableViewportSize(new Dimension(760, 430));
        DefaultTableModel dtm = new DefaultTableModel();

        Object[] coluna = new Object[4];
        coluna[0] = "Id Fornecedor";
        coluna[1] = "Nome";
        coluna[2] = "Endereco";
        coluna[3] = "Contacto";
        dtm.setColumnIdentifiers(coluna);

        Object[] dados = new Object[4];

        for (int i = 0; i < todos().size(); i++) {
            dados[0] = todos().get(i).getIdfornecedor() + "";
            dados[1] = todos().get(i).getNomefornec();
            dados[2] = todos().get(i).getEndereco();
            dados[3] = todos().get(i).getContacto() + "";
            dtm.addRow(dados);
        }
        tabela.setModel(dtm);

        JScrollPane painelScrol = new JScrollPane(tabela);
        return painelScrol;

    }

    private void VerificaRemocao(int id) {
        int aux = 0;
        for (int i = 0; i < todos().size(); i++) {
            if (todos().get(i).getIdfornecedor() == id) {
                aux = id;
            }
        }
        if (aux == id) {
            JOptionPane.showMessageDialog(null, "Removido com sucesso");
        } else {
            JOptionPane.showMessageDialog(null, "O funcionario nao existe");
        }
    }
    
    
    public void CadastroFornecedor(Venda f){
                    FornecedorM fm = new FornecedorM(
                    Integer.parseInt(f.t_idFornecedor.getText()),
                    f.t_nomeFornecedor.getText(),
                    f.t_endereco.getText(),
                    Integer.parseInt(f.t_telefone.getText()));
            inserir(fm);
            JOptionPane.showMessageDialog(null, "Operacao efectuada com sucesso!");
    }
       public void CadastroFornecedor(Fornecedor f){
                    FornecedorM fm = new FornecedorM(
                    Integer.parseInt(f.tIdFornecedor.getText()),
                    f.tNomeFornecedor.getText(),
                    f.tEndereco.getText(),
                    Integer.parseInt(f.tContacto.getText()));
            inserir(fm);
            JOptionPane.showMessageDialog(null, "Operacao efectuada com sucesso!");
    }
}
