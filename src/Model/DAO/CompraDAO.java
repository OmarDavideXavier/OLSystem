package Model.DAO;

import Model.Entidades.ClienteM;
import Model.Entidades.CompraM;
import View.Interface.Compra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Omar Davide Xavier
 */
public class CompraDAO {

    private Connection conexao;

    public CompraDAO() {
        try {
            this.conexao = BDconexao.getConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void inserir(CompraM compra) {
        String sql = "INSERT INTO Cliente_Produto(idCliente,idProduto,Data_Compra) VALUES(?,?,?)";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, compra.getIdcliente());
            ps.setInt(2, compra.getIdProduto());
            ps.setString(3, compra.getDataCompra());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void actualizar(CompraM compra) {
        try {
            String sql = "UPDATE Cliente_Produto SET idCliente = ?, IdProduto = ?, dataCompra = ?, WHERE idCliente = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, compra.getIdcliente());
            ps.setInt(2, compra.getIdProduto());
            ps.setString(3, compra.getDataCompra());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void apagar(CompraM compra) {
        String sql = "DELETE FROM Cliente_Produto WHERE idCliente = ?";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, compra.getIdcliente());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<CompraM> todos() {
        try {
            String sql = "SELECT * from Cliente_Produto";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<CompraM> lista = new ArrayList<>();
            while (rs.next()) {
                CompraM c = new CompraM();
                c.setIdcliente(rs.getInt("idCliente"));
                c.setIdProduto(rs.getInt("idProduto"));
                c.setDataCompra(rs.getString("dataComprs"));
                lista.add(c);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }
    }
    // Cadastro de Cliente que realizaram a compra 
    //Cadastro de Compra(Relacao Cliente Produto)  Tela Compra
    public void CadastrarCliente_Produto(Compra c) {
        CompraM cm = new CompraM(
                Integer.parseInt(c.tIdCliente.getText()),
                Integer.parseInt(c.tIdProduto.getText()),
                c.tData.getText());
        inserir(cm);
    }

}
