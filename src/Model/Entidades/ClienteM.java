package Model.Entidades;

/**
 *
 * @author Omar Davide Xavier
 */
public class ClienteM {

    private String nome, endereco;
    private int idCliente, contacto;

    public ClienteM(int idCliente, String nome, String endereco, int contacto) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.endereco = endereco;
        this.contacto = contacto;
    }

    public ClienteM() {
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public int getContacto() {
        return contacto;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setContacto(int contacto) {
        this.contacto = contacto;
    }
}
