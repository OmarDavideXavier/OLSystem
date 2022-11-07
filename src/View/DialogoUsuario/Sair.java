/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.DialogoUsuario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Omar Davide Xavier
 */
public class Sair {
    
JDialog d;
public Sair(JFrame janela){
    d = new JDialog(janela, "Sair da Operacao", true);
    d.setSize(406, 224);
    Dialogo();
}
 private void Dialogo(){
      JPanel aux = new JPanel(new BorderLayout());
        aux.setLayout(new BoxLayout(aux, BoxLayout.Y_AXIS));
        aux.setBorder(new EmptyBorder(10,10,10,10));
        
        
        d.add(aux);
        d.setVisible(true);
 }

}
