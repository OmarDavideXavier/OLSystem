package Model.DAO;

import Controller.cCliente;
import Model.Entidades.ClienteM;
import View.Interface.Cliente;
import View.Interface.Compra;
import java.awt.Dimension;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Omar Davide Xavier
 */
public class ClienteDAO {

    private Connection conexao;
    public JTable tabela;

    public ClienteDAO() {
        tabela = new JTable();
        try {
            this.conexao = BDconexao.getConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void inserir(ClienteM cliente) {
        String sql = "INSERT INTO cliente(idCliente,nome,endereco,contacto) VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, cliente.getIdCliente());
            ps.setString(2, cliente.getNome());
            ps.setString(3, cliente.getEndereco());
            ps.setInt(4, cliente.getContacto());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void actualizar(ClienteM cliente) {
        try {
            String sql = "UPDATE cliente SET nome = ?, endereco = ?, contacto = ?, WHERE idCliente = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, cliente.getIdCliente());
            ps.setString(2, cliente.getNome());
            ps.setString(3, cliente.getEndereco());
            ps.setInt(4, cliente.getContacto());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void apagar(ClienteM c) {
        String sql = "DELETE FROM Cliente WHERE idCliente= ?";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, c.getIdCliente());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//Metodo que retorna um arrayList
    private ArrayList<ClienteM> todos() {
        ArrayList<ClienteM> lista = new ArrayList<>();
        try {
            String sql = "SELECT * from cliente";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ClienteM e = new ClienteM(
                        rs.getInt("idCliente"),
                        rs.getString("Nome"),
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

    //Metodo que retorna Tzabela preenchida
    public JScrollPane MostrarTabelaTodos() {
        tabela.setPreferredScrollableViewportSize(new Dimension(760, 430));
        DefaultTableModel dtm = new DefaultTableModel();

        Object[] coluna = new Object[4];
        coluna[0] = "Id Cliente";
        coluna[1] = "Nome";
        coluna[2] = "Endereco";
        coluna[3] = "Contacto";
        dtm.setColumnIdentifiers(coluna);

        Object[] dados = new Object[4];

        for (int i = 0; i < todos().size(); i++) {
            dados[0] = todos().get(i).getIdCliente() + "";
            dados[1] = todos().get(i).getNome();
            dados[2] = todos().get(i).getEndereco();
            dados[3] = todos().get(i).getContacto() + "";
            dtm.addRow(dados);
        }
        tabela.setModel(dtm);
        JScrollPane painelScrol = new JScrollPane(tabela);
        return painelScrol;
    }

    //Cadastrar Cliente JFrame Cliente // pegar textos da Interface
    public void Cadastrar(Cliente c) {
        ClienteM cm = new ClienteM(
                Integer.parseInt(c.tIdCliente.getText()),
                c.tNomeCliente.getText(),
                c.tEndereco.getText(),
                Integer.parseInt(c.tContacto.getText()));
        inserir(cm);
        JOptionPane.showMessageDialog(null, "Operacao efectuada com sucesso!");
        c.dispose();
        new cCliente();
    }

    //Cadastro de Cliente //JFrame Compra
    public void CadastrarCliente(Compra v) {
        ClienteDAO c = new ClienteDAO();
        ClienteM cm = new ClienteM(
                Integer.parseInt(v.tIdCliente.getText()),
                v.tNomeCliente.getText(),
                v.tEndereco.getText(),
                Integer.parseInt(v.tContacto.getText()));
        c.inserir(cm);
    }

    public void ApagarNaTabela() {
        MostrarTabelaTodos();

        System.out.println("Linha selecionada= " + tabela.getSelectedRow());
        if (tabela.getSelectedRow() != -1) {
            System.out.println("gggggggggggggggggggg");
            ClienteM c = new ClienteM();
            c.setIdCliente((int) tabela.getValueAt(tabela.getSelectedRow(), 0));
            apagar(c);

        }
    }

}
