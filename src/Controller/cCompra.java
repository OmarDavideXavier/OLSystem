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
import javax.swing.JOptionPane;

/**
 * @author Omar Davide Xavier
 */
public class cCompra implements ActionListener {

    Compra v = new Compra();
    CompraDAO cDao = new CompraDAO();

    public cCompra() {
        v.botaoValidar.addActionListener(this);
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
    }

    public static void main(String[] args) {
        new cCompra();
    }
}
