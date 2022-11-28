package View.Interface;

import Controller.cCliente;
import Controller.cFornecedor;
import Controller.cCompra;
import Controller.cVenda;
import View.DialogoUsuario.DialSair;
import View.DialogoUsuario.InfoSystem;
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
    DialSair s=new DialSair(this);
    InfoSystem ifs=new InfoSystem(this);

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
        Eventos();
    }

    private JPanel ConfigurarPaineis() {
        JPanel pPrincipal = new JPanel(new BorderLayout());
        pPrincipal.setLayout(new BoxLayout(pPrincipal, BoxLayout.Y_AXIS));

        JPanel pCentral = new JPanel(new GridLayout(4, 5, 30, 0));
        pCentral.setBorder(new EmptyBorder(140, 300, 650, 300));
        
        pCentral.add(bCompra);
        pCentral.add(bVenda);
        pCentral.add(bProduto);
        pCentral.add(bEstatistica);
        pCentral.add(new JLabel());
        pCentral.add(lCompra);
        pCentral.add(lVenda);
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
            new cVenda();
        }
        if (ae.getSource() == bCompra) {
             new cCompra();      
        }
         if (ae.getSource() == bRecibo) {
            new Recibo();
        }
        if (ae.getSource() == bProduto) {
            new Produto();
        }
        if (ae.getSource() == bEstatistica) {
            new EstatisiticaL();
        }
        if (ae.getSource() == bSair) {
            s.setVisible(true);
        }
        if (ae.getSource() == bCliente) {
            new cCliente();
            this.setVisible(false);
        }
        if (ae.getSource() == bFornecedor) {
            new cFornecedor();

            this.setVisible(false);

        }
        if (ae.getSource() == bInformacoes) {

            ifs.setVisible(true);

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
        bEstatistica.addActionListener(this);
        bRecibo.addActionListener(this);
    }
}
