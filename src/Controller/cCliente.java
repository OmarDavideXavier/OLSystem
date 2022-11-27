package Controller;

import Model.*;
import Model.DAO.*;
import View.Interface.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import javax.swing.*;
/*
 * @author Omar Davide Xavier
 */
public class cCliente implements ActionListener {

    private Cliente c;
    ClienteDAO cDao = new ClienteDAO();

    public cCliente() {
        c = new Cliente();
        c.bCadastrar.addActionListener(this);
        c.bRemover.addActionListener(this);
        c.bPaginaInicial.addActionListener(this);
        c.bRemover.addActionListener(this);   
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == c.bCadastrar) {
            cDao.Cadastrar(c);
        }
        if (ae.getSource() == c.bPaginaInicial) {
            c.dispose();
            new Menu();
        }
        if(ae.getSource()==c.bRemover){
            cDao.ApagarNaTabela();
        }
    }
    
    public static void main(String[] args) {
        new cCliente();  
    }
}
