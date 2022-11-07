/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Entidades;

/**
 *
 * @author Omar Davide Xavier
 */
public class ClienteM {
    
    private String nome,endereco; 
    private int idCliente,contacto;

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

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", nome=" + nome + ", endereco=" + endereco + ", contacto=" + contacto + '}';
    }
    
    
}
