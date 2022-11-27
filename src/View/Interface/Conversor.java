package View.Interface;

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/*
 * @author Omar Davide Xavier
 */
public class Conversor extends JFrame implements ActionListener {

    JLabel Lde, Lvalor, Lmocambique, Leuropa, Lamerica;
    JButton Bok, BSair;
    JComboBox conver;
    JTextField tvalor, tmocambique, teuropa, tamerica;
        Calculadora c;

    public Conversor() {
           c = new Calculadora();
        InstanciarObjectos();
        ConfigurarJanela();
        
    }

    private void InstanciarObjectos() {
        tvalor = new JTextField();
        tmocambique = new JTextField();
        teuropa = new JTextField();
        tamerica = new JTextField();
        conver = new JComboBox();
        conver.addItem("Mocambique");
        conver.addItem("Europa");
        conver.addItem("America");
        Lde = new JLabel("De");
        Lvalor = new JLabel("Valor");
        Lmocambique = new JLabel("Mocambique");
        Leuropa = new JLabel("Europa");
        Lamerica = new JLabel("America");
        Bok = new JButton("Ok");
        BSair = new JButton("Sair");
        BSair.addActionListener(this);
        Bok.addActionListener(this);
    }

    JPanel GLobalPanel() {
        JPanel aux = new JPanel(new GridBagLayout());
        aux.setBorder(new EmptyBorder(10, 10, 10, 10));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        
        JPanel pSairOk=new JPanel(new FlowLayout(FlowLayout.TRAILING));
        pSairOk.add(BSair);
        pSairOk.add(Bok);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        aux.add(Lde, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        aux.add(Lvalor, gbc);

        gbc.gridy = 1;
        gbc.gridx = 0;
        aux.add(conver, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        aux.add(c.texto, gbc);

        c.PainelPrimario().setBackground(Color.BLUE);
        gbc.gridy = 2;
        gbc.gridx = 1;
        gbc.gridheight = 5;
        aux.add(c.PainelPrimario(), gbc);

        gbc.gridheight = 1;
        gbc.gridy = 2;
        gbc.gridx = 0;
        aux.add(Lmocambique, gbc);

        gbc.gridy = 3;
        gbc.gridx = 0;
        aux.add(tmocambique, gbc);

        gbc.gridy = 4;
        gbc.gridx = 0;
        aux.add(Leuropa, gbc);

        gbc.gridy = 5;
        gbc.gridx = 0;
        aux.add(teuropa, gbc);

        gbc.gridy = 6;
        gbc.gridx = 0;
        aux.add(Lamerica, gbc);

        gbc.gridy = 7;
        gbc.gridx = 0;
        aux.add(tamerica, gbc);
        
        gbc.gridy = 7;
        gbc.gridx = 1;
        aux.add(pSairOk, gbc);

        return aux;
    }

    public void ConfigurarJanela() {
        this.add(GLobalPanel());
        this.setTitle("Conversor");
        this.setSize(618, 499);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        float moz, amer, euro;
        if (conver.getSelectedItem() == "Mocambique") {
            moz = Float.parseFloat(c.texto.getText());
            amer = (float) (0.0157 * moz);
            euro = (float) (0.0163 * moz);

        } else if (conver.getSelectedItem() == "Europa") {
            euro = Float.parseFloat(c.texto.getText());
            amer = (float) (0.9596 * euro);
            moz = (float) (61.2501 * euro);
        } else {
            amer = Float.parseFloat(c.texto.getText());
            moz = (float) (63.8302 * amer);
            euro = (float) (1.0421 * amer);
        }

        if (ae.getSource() == Bok) {
            tmocambique.setText(new DecimalFormat(".##").format(moz) + " MZN");
            tamerica.setText(amer + " USD");
            teuropa.setText(euro + " EUR");
        }

        if (ae.getSource() == BSair) {
            this.dispose();
        }

    }
    public static void main(String[] args) {
        new Conversor();
    }

}
