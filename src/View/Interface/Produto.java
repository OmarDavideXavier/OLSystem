package View.Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Munaira
 */
public class Produto extends JFrame implements ActionListener{

    JLabel Tipo_produto, lProduto, consulta;
    JComboBox comboprotudo;
    JButton sair, voltar, pesquisar;
    JTextField txtipoProduto;
    String produto[] = {"Cereais", "Gado"};

    public Produto() {
        InstanciarObjecto();
        ConfigurarJanela();
    }

    private void InstanciarObjecto() {
        txtipoProduto = new JTextField();
        Tipo_produto = new JLabel("Tipo de Produto");
        lProduto = new JLabel("Produto");
        comboprotudo = new JComboBox(produto);
        sair = new JButton("Sair");
        voltar = new JButton("Voltar");
        pesquisar = new JButton("Pesquisar");
        consulta = new JLabel("\n\nConsulta");

        Font fonte = new Font("Sans-serif", Font.BOLD, 20);

        sair.setFont(fonte);
        pesquisar.setFont(fonte);
        voltar.setFont(fonte);
        txtipoProduto.setFont(fonte);
        Tipo_produto.setFont(fonte);
        lProduto.setFont(fonte);
        comboprotudo.setFont(fonte);
        consulta.setFont(new Font("Sans-serif", Font.BOLD, 100));
        sair.setBackground(Color.red);
        pesquisar.setBackground(Color.LIGHT_GRAY);
        voltar.setBackground(Color.GREEN);
        consulta.setForeground(Color.WHITE);

        sair.addActionListener(this);
    }

    private JPanel GerirPainel() {
        JPanel pCima = new JPanel(new GridLayout(1, 3, 80, 20));
        pCima.setBackground(Color.BLUE);

        JPanel aux = new JPanel();
        aux.setBackground(Color.LIGHT_GRAY);

        pCima.add(consulta);
        pCima.add(aux);

        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(6, 2, 40, 20));
        p2.setBorder(new EmptyBorder(10, 20, 20, 10));
        p2.add(lProduto);
        p2.add(new JLabel());
        p2.add(comboprotudo);
        p2.add(new JLabel());
        p2.add(Tipo_produto);
        p2.add(new JLabel());
        p2.add(txtipoProduto);
        p2.add(new JLabel());
        p2.add(new JLabel());

        JPanel p_pesquisar = new JPanel(new GridLayout(1, 2));
        p_pesquisar.setBorder(new EmptyBorder(0, 0, 0, 20));
        p_pesquisar.add(pesquisar);

        p2.add(p_pesquisar);

        JPanel paux = new JPanel(new GridLayout(1, 2, 20, 20));
        paux.setBorder(new EmptyBorder(10, 100, -20, 20));
        paux.add(sair);
        paux.add(voltar);
        p2.add(new JLabel());
        p2.add(paux);

        JPanel principal = new JPanel();
        principal.setLayout(new BorderLayout());
        principal.setBorder(new EmptyBorder(0, 0, 30, 0));
        principal.add(pCima, BorderLayout.NORTH);
        principal.add(p2, BorderLayout.CENTER);
        principal.setBounds(0,0,1366,768);
        return principal;
    }

    private void ConfigurarJanela() {
        this.setLayout(null);
        
           ImageIcon img8 = new ImageIcon("src\\View\\imagens\\pesqusar.png");
          JLabel limg=new JLabel();
          limg.setIcon(img8);
          limg.setBounds(690,70,700,550);
        
       this.add(limg);
        this.add(GerirPainel());
        this.setTitle("produto");
        this.setSize(1366, 768);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        new Produto();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
      if(ae.getSource()==sair){
          this.setVisible(false);
      }
    }
}
