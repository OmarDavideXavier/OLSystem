package Model.DAO;

import Model.Entidades.ClienteM;
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
public class ClienteDAO {

    private Connection conexao;

    public ClienteDAO() {
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

    public void apagar(ClienteM cliente) {
        String sql = "DELETE FROM cliente WHERE idCliente = ?";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, cliente.getIdCliente());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<ClienteM> todos() {
        try {
            String sql = "SELECT * from cliente";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<ClienteM> lista = new ArrayList<>();
            while (rs.next()) {
                ClienteM e = new ClienteM();
                e.setNome(rs.getString("Nome"));
                e.setIdCliente(rs.getInt("idCliente"));
                e.setEndereco(rs.getString("Endereco"));
                e.setContacto(rs.getInt("Contacto"));
                lista.add(e);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }
    }
}
