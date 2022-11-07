/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.DialogoUsuario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Omar Davide Xavier
 */
public class DialSair extends JDialog{

    JDialog d;
    public JButton sim, nao;

    public DialSair(JFrame janela) {
        this.setTitle("Yes or No?");
        this.setModal(true);
        this.setSize(406, 224);
        this.setLocationRelativeTo(null);

        sim = new JButton("Yes");
        sim.setBackground(Color.GREEN);
        sim.setFont(new Font(null, Font.BOLD, 18));
        sim.setForeground(Color.WHITE);
        nao = new JButton("No");
        nao.setBackground(new Color(12, 146, 235));
        nao.setFont(new Font(null, Font.BOLD, 18));
        nao.setForeground(Color.WHITE);
        Dialogo();
    }

    private void Dialogo() {
        JPanel aux = new JPanel(new BorderLayout());
        aux.setLayout(new BoxLayout(aux, BoxLayout.Y_AXIS));

        ImageIcon img = new ImageIcon("src\\View\\imagens\\quest.png");
        JLabel imagem = new JLabel("Are you sure you want to exit?");
        imagem.setFont(new Font(null, Font.BOLD, 18));
        imagem.setIcon(img);
        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p.add(imagem);

        JPanel psalvar = new JPanel(new GridLayout(1, 2, 10, 10));
        psalvar.setBorder(new EmptyBorder(70, 180, 10, 10));
        psalvar.add(nao);
        psalvar.add(sim);

        aux.add(p, BorderLayout.NORTH);
        aux.add(psalvar, BorderLayout.SOUTH);

        this.add(aux);
    }
}

