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
public class FornecedorM {

    int idfornecedor, contacto;
    String nomefornec, endereco;

    public FornecedorM() {
    }

    public FornecedorM(int idfornecedor, String nomefornec, String endereco, int contacto) {
        this.idfornecedor = idfornecedor;
        this.nomefornec = nomefornec;
        this.endereco = endereco;
        this.contacto = contacto;
    }

    public int getIdfornecedor() {
        return idfornecedor;
    }

    public void setIdfornecedor(int idfornecedor) {
        this.idfornecedor = idfornecedor;
    }

    public int getContacto() {
        return contacto;
    }

    public void setContacto(int contacto) {
        this.contacto = contacto;
    }

    public String getNomefornec() {
        return nomefornec;
    }

    public void setNomefornec(String nomefornec) {
        this.nomefornec = nomefornec;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

}
