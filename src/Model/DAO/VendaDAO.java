package Model.DAO;

/*
 * @author Omar Davide Xavier
 */
import Controller.cCliente;
import Controller.cCompra;
import Model.Entidades.ClienteM;
import Model.Entidades.ProdutoM;
import Model.Entidades.VendaM;
import View.Interface.Cliente;
import View.Interface.Compra;
import View.Interface.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class VendaDAO {

    private Connection conexao;

    public VendaDAO() {
        try {
            this.conexao = BDconexao.getConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void inserir(VendaM venda) {
        String sql = "INSERT INTO fornecedor_produto(idfornecedor,idProduto,Data_Venda) VALUES(?,?,?)";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, venda.getIdfornecedor());
            ps.setInt(2, venda.getIdProduto());
            ps.setString(3, venda.getDataVenda());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void actualizar(VendaM venda) {
        try {
            String sql = "UPDATE venda SET idFornecedor = ?, idProduto = ?, dataCompra = ? WHERE idFornecedor = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, venda.getIdfornecedor());
            ps.setInt(2, venda.getIdProduto());
            ps.setString(3, venda.getDataVenda());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void apagar(VendaM venda) {
        String sql = "DELETE FROM venda WHERE idFornecedor = ?";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, venda.getIdfornecedor());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<VendaM> todos() {
        try {
            String sql = "SELECT * from venda";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<VendaM> lista = new ArrayList<>();
            while (rs.next()) {
                VendaM c = new VendaM();
                c.setIdfornecedor(rs.getInt("idFornecedor"));
                c.setIdProduto(rs.getInt("idProduto"));
                c.setDataVenda(rs.getString("dataVenda"));
                lista.add(c);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }
    }
    
        //Cadastro de Venda (Relacionamento entre Fornecedor e Produto
    public void CadastrarFornecedor_Produto(Venda v) { 
        VendaM cm = new VendaM(
                Integer.parseInt(v.t_idFornecedor.getText()),
                Integer.parseInt(v.t_idProduto.getText()),
                v.t_data.getText());
        inserir(cm);
    }
}
