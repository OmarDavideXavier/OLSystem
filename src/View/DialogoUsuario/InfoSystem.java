/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.DialogoUsuario;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Omar Davide Xavier
 */
public class InfoSystem extends JDialog implements ActionListener{

    public JButton gitHub, interfac;

    public InfoSystem(JFrame frame) {
        gitHub = new JButton("Click Aqui");
        gitHub.setBackground(Color.yellow);
        gitHub.addActionListener(this);

        interfac = new JButton("Click Aqui");
        interfac.setBackground(Color.GREEN);
        interfac.addActionListener(this);

        gitHub.setFont(new Font("Sans-serif", Font.BOLD, 15));
        interfac.setFont(new Font("Sans-serif", Font.BOLD, 15));
        DialogoInfoSystem();
    }

    private void DialogoInfoSystem() {
        this.setTitle("Acerca do Sistema");
        this.setModal(true);
        this.setSize(443, 399);
        this.setBounds(910, 10, 443, 399);

        JPanel aux = new JPanel(new BorderLayout());
        aux.setLayout(new BoxLayout(aux, BoxLayout.Y_AXIS));
        aux.setBorder(new EmptyBorder(10, 10, 10, 10));

        JPanel pCima = new JPanel();
        pCima.setBackground(Color.BLUE);
        JLabel lCima = new JLabel("OLSystem");
        lCima.setFont(new Font("Sans-serif", Font.BOLD, 40));
        lCima.setForeground(Color.WHITE);
        pCima.add(lCima);

        JTextArea tarea = new JTextArea(10, 30);
        tarea.setBackground(new Color(238, 238, 238));
        tarea.setForeground(Color.BLACK);
        tarea.setFont(new Font("Sans-serif", Font.PLAIN, 12));
        tarea.setText("OLSystem é um Sistema que oferece a possibilidade"
                + " de automatizar tarefas manuais de gerenciamento de"
                + " vendas e compras de produtos da agricultura assim como a pecuária."
                + "\n\n\n"
                + "\nVersao:1.0"
                + "\nCompiladores JDK,NetBeans"
                + "\nUltima Actualidacao:01/11/2022"
                + "\nCriadores do Sistema: Omar David Xavier,"
                + "\nLuis Junior Munaira");
        tarea.setBackground(Color.WHITE);
        tarea.setEditable(false);
        tarea.setLineWrap(true);
        tarea.setWrapStyleWord(true);
        JScrollPane barra = new JScrollPane(tarea);
        barra.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        barra.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        JLabel lgitHub = new JLabel("Repositorio Github:");
        lgitHub.setFont(new Font("Sans-serif", Font.BOLD, 15));
        JLabel linterface = new JLabel("Repositorio Interface:");
        linterface.setFont(new Font("Sans-serif", Font.BOLD, 15));

        JPanel pBaixo = new JPanel(new GridLayout(2, 2));
        pBaixo.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        pBaixo.add(lgitHub);
        pBaixo.add(gitHub);
        pBaixo.add(linterface);
        pBaixo.add(interfac);

        aux.add(pCima, BorderLayout.NORTH);
        aux.add(barra, BorderLayout.CENTER);
        aux.add(pBaixo, BorderLayout.SOUTH);

        this.add(aux);
    }
    
     @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == gitHub) {
            try {
                Desktop.getDesktop().browse(new URL("https://github.com/OmarDavideXavier").toURI());
            } catch (IOException ex) {
                Logger.getLogger(InfoSystem.class.getName()).log(Level.SEVERE, null, ex);
            } catch (URISyntaxException ex) {
                Logger.getLogger(InfoSystem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (ae.getSource() == interfac) {
            try {
                Desktop.getDesktop().browse(new URL("https://www.figma.com/proto/7baEFM8gTd0vPzgoQlXfeG/OLSystem?node-id=1%3A339&scaling=contain&page-id=1%3A169").toURI());
            } catch (IOException ex) {
                Logger.getLogger(InfoSystem.class.getName()).log(Level.SEVERE, null, ex);
            } catch (URISyntaxException ex) {
                Logger.getLogger(InfoSystem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
