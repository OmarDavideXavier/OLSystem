package Model.DAO;
/*
 * @author Omar Davide Xavier
 */
import Model.Entidades.Produto;
import Model.Entidades.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VendaDAO{

    private Connection conexao;

    public VendaDAO() {
        try {
            this.conexao = BDconexao.getConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void inserir(Venda venda) {
        String sql = "INSERT INTO venda(idfornecedor,idProduto,dataVenda) VALUES(?,?,?)";
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

    public void actualizar(Venda venda) {
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

    public void apagar(Venda venda) {
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

    public List<Venda> todos() {
        try {
            String sql = "SELECT * from venda";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Venda> lista = new ArrayList<>();
            while (rs.next()) {
                Venda c = new Venda();
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
}
