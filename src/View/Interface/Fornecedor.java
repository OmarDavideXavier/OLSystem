package View.Interface;

/**
 *
 * @author Omar Davide Xavier
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Fornecedor extends JFrame implements MouseMotionListener, ActionListener {
    
    JButton bCadastrar, bRemover, bVisualizar, bPaginaInicial, bCancelar, bValidar, bSim, bNao, bContinuar;
    JLabel lGestaoFornecedor, lNomeFornecedor, lIdFornecedor, lContacto, lEndereco,limg;
    JTextField tNomeFornecedor, tIdFornecedor, tContacto, tEndereco;
    JPanel pInformacoes, pTitulo, pCadastro, pRemocao, pVisualizacao;
    
    public Fornecedor() {
        InstanciarObjectos();
        Tabela();
        GerirPaineis();
        ConfigurarJanela();
    }
    
    private void InstanciarObjectos() {
        bCadastrar = new JButton("Cadastrar");
        bRemover = new JButton("Remover");
        bVisualizar = new JButton("Visualizar");
        bPaginaInicial = new JButton("Pagina Inicial");
        bCancelar = new JButton("Cancelar");
        bValidar = new JButton("Validar");
        bSim = new JButton("Sim");
        bNao = new JButton("Nao");
        bContinuar = new JButton("Continuar");
        lGestaoFornecedor = new JLabel("Gestao Fornecedor");
        lNomeFornecedor = new JLabel("Nome Fornecedor");
        lIdFornecedor = new JLabel("Id Fornecedor");
        lContacto = new JLabel("Contacto");
        lEndereco = new JLabel("Endereco");
        tNomeFornecedor = new JTextField();
        tIdFornecedor = new JTextField();
        tContacto = new JTextField();
        tEndereco = new JTextField();
        
        pInformacoes = new JPanel(new GridLayout(12, 1));
        pTitulo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pCadastro = new JPanel(new GridLayout(8, 1, 10, 10));
        
        Font fonteLetr = new Font(Font.SERIF, Font.BOLD, 30);
        JButton a[] = {bCadastrar, bRemover, bVisualizar, bPaginaInicial};
        for (int i = 0; i < a.length; i++) {
            a[i].setFont(fonteLetr);
            a[i].setForeground(Color.WHITE);
            a[i].setBackground(new Color(26, 31, 38));
            
        }
        JLabel b[] = {lGestaoFornecedor, lNomeFornecedor, lIdFornecedor, lContacto, lEndereco};
        for (int i = 0; i < b.length; i++) {
            b[i].setFont(fonteLetr);
            
        }
        
        Font fonteLetra = new Font(Font.SERIF, Font.BOLD, 50);
        lGestaoFornecedor.setFont(fonteLetra);
        lGestaoFornecedor.setForeground(Color.WHITE);
        
    }
    
    private void ConfigurarJanela() {
        this.setLayout(null);
        Eventos();
        this.add(pTitulo);
        this.add(pInformacoes);
        this.setTitle("Fornecedor");
        this.setSize(1366, 768);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    private void GerirPaineis() {
        //Painel de Informacoes
        pInformacoes.setBackground(new Color(16, 25, 48));
        pInformacoes.setBounds(0, 100, 270, 700);
        pInformacoes.add(bPaginaInicial);
        pInformacoes.add(bCadastrar);
        pInformacoes.add(bVisualizar);
        pInformacoes.add(bRemover);

        //Painel Titulo
        pTitulo.setBackground(new Color(117, 91, 150));
        pTitulo.setBounds(0, 0, 1366, 100);
        pTitulo.add(lGestaoFornecedor);

        //Painel Cadastro
        pCadastro.setBounds(290, 120, 900, 500);
        pCadastro.setBorder(BorderFactory.createTitledBorder("Cadastro"));
        pCadastro.add(lNomeFornecedor);
        pCadastro.add(lIdFornecedor);
        pCadastro.add(lContacto);
        pCadastro.add(tNomeFornecedor);
        pCadastro.add(tIdFornecedor);
        pCadastro.add(tContacto);
        pCadastro.add(lEndereco);
        pCadastro.add(new JPanel());
        pCadastro.add(new JPanel());
        pCadastro.add(tEndereco);
        pCadastro.add(new JPanel());
        pCadastro.add(new JPanel());
        pCadastro.add(new JPanel());
        pCadastro.add(new JPanel());
        pCadastro.add(new JPanel());
        pCadastro.add(new JPanel());
        pCadastro.add(new JPanel());
        pCadastro.add(new JPanel());
        pCadastro.add(new JPanel());
        pCadastro.add(new JPanel());
        pCadastro.add(new JPanel());
        pCadastro.add(new JPanel());
        pCadastro.add(new JPanel());
        

        ImageIcon img=new ImageIcon("src\\View\\imagens\\fornecedor-que-impulsiona.jpg");

        limg=new JLabel();
        limg.setIcon(img);
        limg.setBounds(310, 120, 800, 500);
        this.add(limg);
        
        
        JPanel aux = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bValidar.setBackground(Color.GREEN);
        bCancelar.setBackground(Color.RED);
        aux.add(bCancelar);
        aux.add(bValidar);
        pCadastro.add(aux);
        
    }
    
    private void Tabela() {
        String colunas[] = {"Nome", "Id Fornecedor", "Contacto", "Endereco"};
        String produto[][] = {{"Omar", "1234", "865444444", "CCA"},
        {"Edson", "1234", "865444444", "CCA"},
        {"Tuy", "4544", "865444444", "RAA"},
        {"Dan", "1234", "865444444", "CCA"},
        {"Joel", "1234", "865444444", "CCA"}};
        
        pVisualizacao = new JPanel();
        pVisualizacao.setBorder(BorderFactory.createTitledBorder("Tabela Fornecedor"));
        pVisualizacao.setBounds(310, 120, 800, 500);
        
        JTable tabela = new JTable(produto, colunas);
        JScrollPane barra = new JScrollPane(tabela);
        pVisualizacao.add(barra);
        tabela.setPreferredScrollableViewportSize(new Dimension(760, 430));
        
    }
    
    public static void main(String[] args) {
        new Fornecedor();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == bCadastrar) {
            this.remove(limg);
            this.remove(pVisualizacao);
            this.add(pCadastro);
            this.setVisible(false);
            this.setVisible(true);
        }
        if (ae.getSource() == bVisualizar) {
             this.remove(limg);
            this.remove(pCadastro);
            this.add(pVisualizacao);
            this.setVisible(false);
            this.setVisible(true);
            
        }
        if (ae.getSource() == bPaginaInicial) {
            this.setVisible(false);
            new Menu();
        }
    }
    
    private void Eventos() {
        bCadastrar.addActionListener(this);
        bVisualizar.addActionListener(this);
        bPaginaInicial.addActionListener(this);
        bCadastrar.addMouseMotionListener(this);
//        bVisualizar.addMouseListener(this);
//        bPaginaInicial.addMouseListener(this);
    }

    @Override
    public void mouseDragged(MouseEvent me) {
       
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
