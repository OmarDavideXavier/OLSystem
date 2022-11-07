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
public class Compra {

    int idcliente, idProduto;
    String dataCompra;
    public Compra() {
    }

    public Compra(int idcliente, int idProduto, String dataCompra) {
        this.idcliente = idcliente;
        this.idProduto = idProduto;
        this.dataCompra = dataCompra;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(String dataCompra) {
        this.dataCompra = dataCompra;
    }

    @Override
    public String toString() {
        return "Compra{" + "idcliente=" + idcliente + ", idProduto=" + idProduto + ", dataCompra=" + dataCompra + '}';
    }
    
    
}
