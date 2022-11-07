package View.Interface;

import View.DialogoUsuario.DialSair;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Omar Davide Xavier
 */
public class Menu extends JFrame implements ActionListener {

    JButton bVenda, bCompra, bProduto, bEstatistica, bCliente, bFornecedor, bRecibo, bInformacoes, bSair, bdSair;
    JLabel lVenda, lCompra, lProduto, lEstatistica, lCliente, lFornecedor, lRecibo, lInformacoes, LSair;
    JDialog d;
    DialSair s=new DialSair(this);

    public Menu() {
        
        InstanciarObjecto();
        ConfigurarJanela();
    }

    private void InstanciarObjecto() {
        bVenda = new JButton();
        bCompra = new JButton();
        bProduto = new JButton();
        bEstatistica = new JButton();
        bCliente = new JButton();
        bFornecedor = new JButton();
        bRecibo = new JButton();
        bInformacoes = new JButton();
        lVenda = new JLabel("Venda");
        lCompra = new JLabel("Compra");
        lProduto = new JLabel("Produto");
        lEstatistica = new JLabel("Estatistica");
        lCliente = new JLabel("Cliente");
        lFornecedor = new JLabel("Fornecedor");
        lRecibo = new JLabel("Recibo");
        lInformacoes = new JLabel("Info System");
        bSair = new JButton();
        LSair = new JLabel("Sair");
        bdSair = new JButton("Sair");

        JLabel[] arrayFonte = {lVenda, lCompra, lProduto, lEstatistica, lCliente, lFornecedor, lRecibo, lInformacoes, LSair};

        Font fonteLetra = new Font(Font.SERIF, Font.BOLD, 22);
        for (int i = 0; i < arrayFonte.length; i++) {
            arrayFonte[i].setFont(fonteLetra);
        }
        bSair.setFont(fonteLetra);

        ImageIcon img = new ImageIcon("src\\View\\imagens\\Fornecedor.png");
        ImageIcon img1 = new ImageIcon("src\\View\\imagens\\Venda.png");
        ImageIcon img2 = new ImageIcon("src\\View\\imagens\\Cliente.png");
        ImageIcon img3 = new ImageIcon("src\\View\\imagens\\Compra.png");
        ImageIcon img4 = new ImageIcon("src\\View\\imagens\\Estatistica1.png");
        ImageIcon img5 = new ImageIcon("src\\View\\imagens\\Informacoes.png");
        ImageIcon img6 = new ImageIcon("src\\View\\imagens\\Recibo.png");
        ImageIcon img7 = new ImageIcon("src\\View\\imagens\\Produto.png");
        ImageIcon img8 = new ImageIcon("src\\View\\imagens\\Sair.png");

        bFornecedor.setIcon(img);
        bVenda.setIcon(img1);
        bCliente.setIcon(img2);
        bCompra.setIcon(img3);
        bEstatistica.setIcon(img4);
        bInformacoes.setIcon(img5);
        bRecibo.setIcon(img6);
        bProduto.setIcon(img7);
        bSair.setIcon(img8);

        DialogoInfoSystem();
        Eventos();
    }

    private JPanel ConfigurarPaineis() {
        JPanel pPrincipal = new JPanel(new BorderLayout());
        pPrincipal.setLayout(new BoxLayout(pPrincipal, BoxLayout.Y_AXIS));

        JPanel pCentral = new JPanel(new GridLayout(4, 5, 30, 0));
        pCentral.setBorder(new EmptyBorder(140, 300, 650, 300));

        pCentral.add(bVenda);
        pCentral.add(bCompra);
        pCentral.add(bProduto);
        pCentral.add(bEstatistica);
        pCentral.add(new JLabel());
        pCentral.add(lVenda);
        pCentral.add(lCompra);
        pCentral.add(lProduto);
        pCentral.add(lEstatistica);
        pCentral.add(new JLabel());
        pCentral.add(bCliente);
        pCentral.add(bFornecedor);
        pCentral.add(bRecibo);
        pCentral.add(bInformacoes);
        pCentral.add(bSair);
        pCentral.add(lCliente);
        pCentral.add(lFornecedor);
        pCentral.add(lRecibo);
        pCentral.add(lInformacoes);
        pCentral.add(LSair);

        pPrincipal.add(pCentral, BorderLayout.NORTH);
        return pPrincipal;
    }

    private void ConfigurarJanela() {;

        this.setAlwaysOnTop(false);
        this.add(ConfigurarPaineis());
        this.setTitle("Menu");
        this.setSize(1366, 768);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Menu();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == bVenda) {
            new Venda();
        }
        if (ae.getSource() == bCompra) {
            new Compra();
        }
        if (ae.getSource() == bProduto) {
            new Produto();
        }
        if (ae.getSource() == bSair) {
            
            s.setVisible(true);
        }
        if (ae.getSource() == bCliente) {
            new Cliente();
            this.setVisible(false);
        }
        if (ae.getSource() == bFornecedor) {
            new Fornecedor();

            this.setVisible(false);

        }
        if (ae.getSource() == bInformacoes) {

            d.setVisible(true);

        }if(ae.getSource()==s.nao){
            s.setVisible(false);
        }
        if(ae.getSource()==s.sim){
            s.dispose();
            this.dispose();
        }


    }

    private void Eventos() {
        bVenda.addActionListener(this);
        bCompra.addActionListener(this);
        bSair.addActionListener(this);
        bCliente.addActionListener(this);
        bProduto.addActionListener(this);
        bInformacoes.addActionListener(this);
        bFornecedor.addActionListener(this);
        s.nao.addActionListener(this);
        s.sim.addActionListener(this);

    }

    private void DialogoInfoSystem() {
        d = new JDialog(this, "Acerca do Sistema", true);
        d.setSize(443, 399);
        d.setBounds(910, 10, 443, 399);

        JPanel aux = new JPanel(new BorderLayout());
        aux.setLayout(new BoxLayout(aux, BoxLayout.Y_AXIS));
        aux.setBorder(new EmptyBorder(10,10,10,10));

        JPanel pCima = new JPanel();
        pCima.setBackground(Color.BLUE);
        JLabel lCima = new JLabel("OLSystem");
        lCima.setFont(new Font("Sans-serif", Font.BOLD, 40));
        lCima.setForeground(Color.WHITE);
        pCima.add(lCima);

        JTextArea tarea = new JTextArea(10, 30);
        tarea.setBackground(new Color(238, 238, 238));
        tarea.setForeground(Color.BLUE);
        tarea.setFont(new Font("Sans-serif", Font.BOLD, 18));
        tarea.setText("OLSystem é um Sistema que oferece a possibilidade"
                + " de automatizar tarefas manuais de gerenciamento de"
                + " vendas e compras de produtos da agricultura assim como a pecuária."
                + "\n"
                + "\nVersao:1.0"
                + "\nCompiladores JDK,NetBeans"
                + "\nUltima Actualidacao:01/11/2022"
                + "\nCriadores do Sistema: Omar David Xavier,"
                + "\nLuis Junior Munaira");
        tarea.setEditable(false);
        tarea.setLineWrap(true);
        tarea.setWrapStyleWord(true);
        JScrollPane barra = new JScrollPane(tarea);
        barra.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        barra.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        JLabel lgitHub=new JLabel("Repositorio Github:");
        lgitHub.setFont(new Font("Sans-serif", Font.BOLD, 15));
        JLabel linterface=new JLabel("Repositorio Interface:");
         linterface.setFont(new Font("Sans-serif", Font.BOLD, 15));
        
        JPanel pBaixo=new JPanel(new GridLayout(2,2));
        pBaixo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
         ConexaoODX c=new ConexaoODX();
         
        pBaixo.add(lgitHub);  
        pBaixo.add(c.gitHub);
        pBaixo.add(linterface);
        pBaixo.add(c.interfac);
        
        
        aux.add(pCima, BorderLayout.NORTH);
        aux.add(barra, BorderLayout.CENTER);
        aux.add(pBaixo,BorderLayout.SOUTH);

        d.add(aux);
    }
}
