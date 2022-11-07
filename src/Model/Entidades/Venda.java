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
public class Venda {
    String dataVenda;
     int idfornecedor, idProduto;

    public Venda() {
    }

    public Venda(int idfornecedor, int idProduto, String dataVenda) {
        this.idfornecedor = idfornecedor;
        this.idProduto = idProduto;
        this.dataVenda = dataVenda;
    }

    public int getIdfornecedor() {
        return idfornecedor;
    }

    public void setIdfornecedor(int idfornecedor) {
        this.idfornecedor = idfornecedor;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    @Override
    public String toString() {
        return "Venda{" + "idfornecedor=" + idfornecedor + ", idProduto=" + idProduto + ", dataVenda=" + dataVenda + '}';
    }
    
    
}
