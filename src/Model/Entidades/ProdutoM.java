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
public class ProdutoM {
    int idproduto;
    String nome;
    float quantidade, preco;

    public ProdutoM() {
    }

    public ProdutoM(int idproduto, String nome,float quantidade, float preco) {
        this.idproduto = idproduto;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
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
}
