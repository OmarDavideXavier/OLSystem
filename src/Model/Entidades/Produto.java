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
public class Produto {
    int idproduto;
    String nome,tipoProduto;
    float quantidade, preco;

    public Produto() {
    }

    public Produto(int idproduto, String nome, String tipoProduto, float quantidade, float preco) {
        this.idproduto = idproduto;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
        this.tipoProduto=tipoProduto;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    
    public int getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(int idproduto) {
        this.idproduto = idproduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Produto{" + "idproduto=" + idproduto + ", nome=" + nome + ", tipoProduto=" + tipoProduto + ", quantidade=" + quantidade + ", preco=" + preco + '}';
    }

 
    
    
}
