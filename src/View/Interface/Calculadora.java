package View.Interface;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/*
 * @author Omar Davide Xavier
 */
public class Calculadora  implements ActionListener {

    JTextField texto;
    String [] numero = {"0","7","8","9","4","5","6","1","2","3"}; 
    JButton [] numBotao=new JButton[10];
    JButton badicionar, bdividir, bmultiplicar, bsubtrair;
    JButton bponto, bigual, bapagar, bLimpar;
    JPanel painel;

    double num1 = 0, num2 = 0, resultado = 0;
    char operador;

    public Calculadora() {
        InstanciarObjecto();
    }

    private void Operacao(char operad, double n1, double n2){
        switch (operad) {
            case '+':
                resultado = n1 + n2;
                break;
            case '-':
                resultado = n1 - n2;
                break;
            case '*':
                resultado = n1 * n2;
                break;
            case '/':
                resultado = n1 / n2;
                break;
        }
    }

    public void InstanciarObjecto() {
        Font fonte = new Font(Font.SERIF, Font.BOLD, 30);
        texto = new JTextField("");
        texto.setBackground(Color.WHITE);
        texto.setEditable(false);
        texto.setFont(fonte);

        badicionar = new JButton("+");
        bsubtrair = new JButton("-");
        bdividir = new JButton("/");
        bmultiplicar = new JButton("*");
        bponto = new JButton(".");
        bigual = new JButton("=");
        bapagar = new JButton("Apagar");
        bLimpar = new JButton("Limpar");

       JButton[] funcaoBotao ={badicionar,bsubtrair,bmultiplicar,bdividir,bponto,bigual,bapagar,bLimpar};

        for (int i = 0; i < funcaoBotao.length; i++) {
            funcaoBotao[i].addActionListener(this);
            funcaoBotao[i].setFont(fonte);
        }

        for (int i = 0; i < 10; i++) {
            numBotao[i] = new JButton(numero[i]);
            numBotao[i].addActionListener(this);
            numBotao[i].setFont(fonte);
        }

    }

    public JPanel PainelPrimario() {
        JPanel global1 = new JPanel(new BorderLayout());
        global1.setBorder(new EmptyBorder(10,10,10,10));
        global1.setBackground(Color.LIGHT_GRAY);
        
        JPanel global2 = new JPanel(new GridLayout(4, 4, 10, 10));
        global2.setBackground(Color.LIGHT_GRAY);
        global2.add(numBotao[1]);
        global2.add(numBotao[2]);
        global2.add(numBotao[3]);
        global2.add(bdividir);
        global2.add(numBotao[4]);
        global2.add(numBotao[5]);
        global2.add(numBotao[6]);
        global2.add(bmultiplicar);
        global2.add(numBotao[7]);
        global2.add(numBotao[8]);
        global2.add(numBotao[9]);
        global2.add(bsubtrair);
        global2.add(numBotao[0]);
        global2.add(bponto);
        global2.add(bigual);
        global2.add(badicionar);
        
        JPanel global3 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        global3.setBackground(Color.LIGHT_GRAY);
        global3.add(bapagar);
        global3.add(bLimpar);

        global1.add(global2, BorderLayout.CENTER);
        global1.add(global3, BorderLayout.SOUTH);

        return global1;
    }

    public void actionPerformed(ActionEvent ae) {

        for (int i = 0; i < 10; i++) {
            if (ae.getSource() == numBotao[i]) {
                texto.setText(texto.getText().concat(numero[i]));
            }
        }

        if (ae.getSource() == bponto) {
            texto.setText(texto.getText().concat("."));
        }
        if (ae.getSource() == badicionar) {
            num1 = Double.parseDouble(texto.getText());
            operador = '+';
            texto.setText("");
        }
        if (ae.getSource() == bsubtrair) {
            num1 = Double.parseDouble(texto.getText());
            operador = '-';
            texto.setText("");
        }
        if (ae.getSource() == bmultiplicar) {
            num1 = Double.parseDouble(texto.getText());
            operador = '*';
            texto.setText("");
        }
        if (ae.getSource() == bdividir) {
            num1 = Double.parseDouble(texto.getText());
            operador = '/';
            texto.setText("");
        }

        if (ae.getSource() == bigual) {
            num2 = Double.parseDouble(texto.getText());
            Operacao(operador, num1, num2);

            texto.setText((String.valueOf(resultado)));
            num1 = resultado;
        }

        if (ae.getSource() == bapagar) {
            texto.setText("");
        }

        if (ae.getSource() == bLimpar) {
            String str = texto.getText();
            texto.setText("");

            for (int i = 0; i < str.length() - 1; i++) {
                texto.setText(texto.getText() + str.charAt(i));
            }
        }

    }

}
