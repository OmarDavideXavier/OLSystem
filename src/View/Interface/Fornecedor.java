package View.Interface;

/*
 * @author Omar Davide Xavier
 */
import Model.DAO.FornecedorDAO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Fornecedor extends JFrame {

    public JButton bCadastrar, bRemover, bVisualizar, bPaginaInicial, bCancelar, bValidar, bContinuar;
    public JLabel lGestaoFornecedor, lNomeFornecedor, lIdFornecedor, lIdFor, lContacto, lEndereco, limg;
    public JTextField tNomeFornecedor, tIdFornecedor, tContacto, tEndereco, tIdFor;
    public JPanel pInformacoes, pTitulo, pCadastro, pRemocao, pVisualizar;

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
        bCancelar = new JButton("Reset");
        bValidar = new JButton("Validar");
        bContinuar = new JButton("Continuar");
        lGestaoFornecedor = new JLabel("Gestao Fornecedor");
        lNomeFornecedor = new JLabel("Nome Fornecedor");
        lIdFornecedor = new JLabel("Id Fornecedor");
        lIdFor = new JLabel("Id Fornecedor");
        lContacto = new JLabel("Contacto");
        lEndereco = new JLabel("Endereco");
        tNomeFornecedor = new JTextField();
        tIdFornecedor = new JTextField();
        tIdFor = new JTextField();
        tContacto = new JTextField();
        tEndereco = new JTextField();

        pInformacoes = new JPanel(new GridLayout(4, 1));
        pTitulo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pCadastro = new JPanel(new GridLayout(8, 1, 10, 10));
        pRemocao = new JPanel(new GridLayout(8, 1, 10, 10));

        Font fonteLetr = new Font(null, Font.BOLD, 30);
        JButton a[] = {bCadastrar, bRemover, bVisualizar, bPaginaInicial, bContinuar, bValidar, bCancelar};
        for (int i = 0; i < a.length; i++) {
            a[i].setFont(fonteLetr);
            a[i].setForeground(Color.WHITE);
            a[i].setBackground(new Color(26, 31, 38));
        }

        bValidar.setForeground(Color.BLACK);
        bCancelar.setForeground(Color.BLACK);
        bContinuar.setBackground(Color.GREEN);
        bContinuar.setForeground(Color.BLACK);

        JLabel b[] = {lGestaoFornecedor, lNomeFornecedor, lIdFornecedor, lIdFor, lContacto, lEndereco};
        for (int i = 0; i < b.length; i++) {
            b[i].setFont(fonteLetr);

        }

        Font fonteLetra = new Font(null, Font.BOLD, 50);
        lGestaoFornecedor.setFont(fonteLetra);
        lGestaoFornecedor.setForeground(Color.WHITE);
    }

    private void ConfigurarJanela() {
        this.setLayout(null);
        this.add(pTitulo);
        this.add(pInformacoes);
        this.setTitle("Fornecedor");
        this.setSize(1366, 768);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void GerirPaineis() {
        //Painel de Informacoes
        pInformacoes.setBackground(new Color(89, 130, 176));
        pInformacoes.setBounds(0, 100, 270, 200);
        pInformacoes.add(bPaginaInicial);
        pInformacoes.add(bCadastrar);
        pInformacoes.add(bVisualizar);
        pInformacoes.add(bRemover);

        //Painel Titulo
        pTitulo.setBackground(Color.BLUE);
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

        //Pianel Remover
        pRemocao.setBounds(290, 120, 800, 400);
        pRemocao.setBorder(BorderFactory.createTitledBorder("Remocao de Fornecedor"));
        pRemocao.add(lIdFor);
        pRemocao.add(tIdFor);
        pRemocao.add(new JPanel());
        pRemocao.add(new JPanel());
        pRemocao.add(new JPanel());
        pRemocao.add(new JPanel());
        pRemocao.add(new JPanel());
        pRemocao.add(new JPanel());
        pRemocao.add(new JPanel());
        pRemocao.add(new JPanel());
        pRemocao.add(new JPanel());
        pRemocao.add(new JPanel());
        pRemocao.add(new JPanel());
        JPanel au = new JPanel(new GridLayout(1, 2, 20, 10));
        au.add(new JPanel());
        au.add(bContinuar);
        pRemocao.add(au);

        ImageIcon img = new ImageIcon("src\\View\\imagens\\fornecedor-que-impulsiona.jpg");

        limg = new JLabel();
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

    public void Tabela() {
        FornecedorDAO fDao = new FornecedorDAO();
        pVisualizar = new JPanel();
        pVisualizar.setBackground(new Color(89, 130, 176));
        pVisualizar.setBorder(BorderFactory.createTitledBorder("Tabela Fornecedor"));
        pVisualizar.setBounds(310, 120, 800, 500);
    }
}
