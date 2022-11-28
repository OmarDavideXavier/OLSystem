/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DAO.ClienteDAO;
import Model.DAO.CompraDAO;
import Model.DAO.ProdutoDAO;
import Model.DAO.VendaDAO;
import View.Interface.Compra;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * @author Omar Davide Xavier
 */
public class cCompra implements ActionListener {

    Compra v = new Compra();
    CompraDAO cDao = new CompraDAO();

    public cCompra() {
        v.botaoValidar.addActionListener(this);
               v. bok.addActionListener(this);
        v.combTipoProduto.addActionListener(this);
        v.radioCereais.addActionListener(this);
        v.radioGado.addActionListener(this);
        v.botaoFinalizar.addActionListener(this);
        v.botaoCancelar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == v.botaoValidar) {
            ClienteDAO CliDao = new ClienteDAO();
            ProdutoDAO pdao=new ProdutoDAO();
            cDao.CadastrarCliente_Produto(v);
            CliDao.CadastrarCliente(v);
            pdao.CadastrarProduto(v);
            JOptionPane.showMessageDialog(null, "Operacao efectuada com sucesso!");
            v.dispose();
            new cCompra();
        }
                if (ae.getSource() == v.radioCereais) {
            v.img = new ImageIcon("src\\View\\imagens\\cereais.png");
            v.imagem.setIcon(v.img);
            v.pImagem.add(v.imagem);
            for (int i = 0; i < v.arrayCereais.length; i++) {
                v.combTipoProduto.removeItem(v.arrayGado[i]);
                v.combTipoProduto.addItem(v.arrayCereais[i]);
            }

        } else if (ae.getSource() == v.radioGado) {
            v.img = new ImageIcon("src\\View\\imagens\\gado.png");
            v.imagem.setIcon(v.img);
            v.pImagem.add(v.imagem);
            v.combTipoProduto.setLayout(null);
            for (int i = 0; i < v.arrayGado.length; i++) {
                v.combTipoProduto.removeItem(v.arrayCereais[i]);
                v.combTipoProduto.addItem(v.arrayGado[i]);
            }
        }
        if (ae.getSource() == v.botaoFinalizar) {
            v.dispose();
        }

        if (ae.getSource() == v.botaoCancelar) {
            v.tIdProduto.setText("");
            v.tQuantidade.setText("");
            v.tData.setText("");
            v.tNomeCliente.setText("");
            v.tContacto.setText("");
            v.tPreco.setText("");
            v.tDinheiro.setText("");
            v.tIdCliente.setText("");
            v.tEndereco.setText("");
        }
        if (ae.getSource() == v.combTipoProduto) {
            if (v.combTipoProduto.getSelectedItem() == "Arroz") {
                v.preco = Float.parseFloat(v.tQuantidade.getText()) * 250;
            } else if (v.combTipoProduto.getSelectedItem() == "Milho") {
                v.preco = Float.parseFloat(v.tQuantidade.getText()) * 350;
            } else if (v.combTipoProduto.getSelectedItem() == "Mandioca") {
                v.preco = Float.parseFloat(v.tQuantidade.getText()) * 300;
            } else if (v.combTipoProduto.getSelectedItem() == "Trigo") {
                v.preco = Float.parseFloat(v.tQuantidade.getText()) * 450;
            } else if (v.combTipoProduto.getSelectedItem() == "Cabrito") {
                v.preco = Float.parseFloat(v.tQuantidade.getText()) * 450;
            } else if (v.combTipoProduto.getSelectedItem() == "Boi") {
                v.preco = Float.parseFloat(v.tQuantidade.getText()) * 500;
            } else if (v.combTipoProduto.getSelectedItem() == "Vaca") {
                v.preco = Float.parseFloat(v.tQuantidade.getText()) * 400;
            } else if (v.combTipoProduto.getSelectedItem() == "Suino") {
                v.preco = Float.parseFloat(v.tQuantidade.getText()) * 425;
            }
            v.tPreco.setText(v.preco + "");
        }if(ae.getSource()==v.bok){
        float auxvalor=(Float.parseFloat(v.tDinheiro.getText()))-v.preco;
            v.LTrocovalor.setText(auxvalor+"MZN");
            auxvalor=(Float.parseFloat(v.tDinheiro.getText()))-v.preco;
            v.LprecRecebidolvalor.setText(Float.parseFloat(v.tDinheiro.getText())+"MZN");
        }
    }

    public static void main(String[] args) {
        new cCompra();
    }
}
