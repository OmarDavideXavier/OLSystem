/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.Interface.Venda;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Omar Davide Xavier
 */
public class cVenda implements ActionListener {

   private Venda v;

    public cVenda() {
        v = new Venda();
        v.but_Sair.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == v.but_Sair) {
            v.dispose();
        }
    }
    
    public static void main(String[] args) {
        new cVenda();
    }
}
