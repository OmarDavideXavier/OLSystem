package Model.DAO;

import Model.Entidades.ClienteM;
import Model.Entidades.Compra;
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
public class CompraDAO {

    private Connection conexao;

    public CompraDAO() {
        try {
            this.conexao = BDconexao.getConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void inserir(Compra compra) {
        String sql = "INSERT INTO Compra(idCliente,idProduto,dataComra) VALUES(?,?,?)";
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

    public void actualizar(Compra compra) {
        try {
            String sql = "UPDATE comopra SET idCliente = ?, IdProduto = ?, dataCompra = ?, WHERE idCliente = ?";
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

    public void apagar(Compra compra) {
        String sql = "DELETE FROM compra WHERE idCliente = ?";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, compra.getIdcliente());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Compra> todos() {
        try {
            String sql = "SELECT * from compra";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Compra> lista = new ArrayList<>();
            while (rs.next()) {
                Compra c = new Compra();
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
}
