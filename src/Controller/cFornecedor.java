/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DAO.ClienteDAO;
import Model.DAO.FornecedorDAO;
import Model.Entidades.FornecedorM;
import View.Interface.Fornecedor;
import View.Interface.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.JOptionPane;

/**
 *
 * @author Omar Davide Xavier
 */
public class cFornecedor implements ActionListener {
    
    Fornecedor f = new Fornecedor();
    FornecedorDAO fDao = new FornecedorDAO();
    
    public cFornecedor() {
        f.bRemover.addActionListener(this);
        f.bCadastrar.addActionListener(this);
        f.bVisualizar.addActionListener(this);
        f.bPaginaInicial.addActionListener(this);
        f.bValidar.addActionListener(this);
        f.bCancelar.addActionListener(this);
        f.bContinuar.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == f.bCadastrar) {
            f.remove(f.pRemocao);
            f.remove(f.limg);
            f.remove(f.pVisualizar);
            f.add(f.pCadastro);
            f.setVisible(false);
            f.setVisible(true);
        }
        if (ae.getSource() == f.bValidar) {
            fDao.CadastroFornecedor(f);
            f.tContacto.setText("");
            f.tEndereco.setText("");
            f.tIdFornecedor.setText("");
            f.tNomeFornecedor.setText("");
        }
        if (ae.getSource() == f.bPaginaInicial) {
            new Menu();
            f.dispose();
        }
        if (ae.getSource() == f.bCancelar) {
            f.tContacto.setText("");
            f.tEndereco.setText("");
            f.tIdFornecedor.setText("");
            f.tNomeFornecedor.setText("");
        }
        if (ae.getSource() == f.bVisualizar) {
            f.pVisualizar.add(fDao.MostrarTabelaTodos());
            f.remove(f.pRemocao);
            f.remove(f.limg);
            f.remove(f.pCadastro);
            f.add(f.pVisualizar);
            f.dispose();
            f.setVisible(true);
        }
        
        if (ae.getSource() == f.bRemover) {
            f.remove(f.pVisualizar);
            f.remove(f.limg);
            f.remove(f.pCadastro);
            f.add(f.pRemocao);
            f.dispose();
            f.setVisible(true);
        }
        if (ae.getSource() == f.bContinuar) {
            fDao.apagar(Integer.parseInt(f.tIdFor.getText()));
        }
        
    }
    
    public static void main(String[] args) {
        new cFornecedor();
    }
}
