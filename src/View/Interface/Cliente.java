package View.Interface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author Omar Davide Xavier
 */
public class Cliente extends JFrame implements ActionListener {

    public JButton bCadastrar, bRemover, bVisualizar, bPaginaInicial, bCancelar, bValidar, bSim, bNao, bContinuar;
    public JLabel lGestaoCliente, lNomeCliente, lIdCliente, lContacto, lEndereco,limg;
    public JTextField tNomeCliente, tIdCliente, tContacto, tEndereco;
    public JPanel pInformacoes, pTitulo, pCadastro, pRemocao, pVisualizar;

    public Cliente() {
        InstanciarObjectos();
        GerirPaineis();
        Tabela();
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
        lGestaoCliente = new JLabel("Gestao Cliente");
        lNomeCliente = new JLabel("Nome Cliente");
        lIdCliente = new JLabel("Id Cliente");
        lContacto = new JLabel("Contacto");
        lEndereco = new JLabel("Endereco");
        tNomeCliente = new JTextField();
        tIdCliente = new JTextField();
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
        JLabel b[] = {lGestaoCliente, lNomeCliente, lIdCliente, lContacto, lEndereco};
        for (int i = 0; i < b.length; i++) {
            b[i].setFont(fonteLetr);

        }

        Font fonteLetra = new Font(Font.SERIF, Font.BOLD, 50);
        lGestaoCliente.setFont(fonteLetra);
        lGestaoCliente.setForeground(Color.WHITE);

    }

    private void ConfigurarJanela() {
        this.setLayout(null);
        Eventos();
        this.add(pTitulo);
        this.add(pInformacoes);
        this.setTitle("Cliente");
        this.setSize(1366, 768);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void GerirPaineis() {
        //Painel de Informacoes
        pInformacoes.setBackground(new Color(92, 104, 104));
        pInformacoes.setBounds(0, 100, 270, 700);
        pInformacoes.add(bPaginaInicial);
        pInformacoes.add(bCadastrar);
        pInformacoes.add(bVisualizar);
        pInformacoes.add(bRemover);

        //Painel Titulo
        pTitulo.setBackground(new Color(94, 154, 167));
        pTitulo.setBounds(0, 0, 1366, 100);
        pTitulo.add(lGestaoCliente);

        //Painel Cadastro
        pCadastro.setBounds(290, 120, 900, 500);
        pCadastro.setBorder(BorderFactory.createTitledBorder("Cadastro"));
        pCadastro.add(lNomeCliente);
        pCadastro.add(lIdCliente);
        pCadastro.add(lContacto);
        pCadastro.add(tNomeCliente);
        pCadastro.add(tIdCliente);
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

        ImageIcon img = new ImageIcon("src\\View\\imagens\\cliente_1.png");

        limg = new JLabel();
        limg.setIcon(img);
        limg.setBounds(480, 180, 800, 500);
        this.add(limg);

        JPanel aux = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bValidar.setBackground(Color.GREEN);
        bCancelar.setBackground(Color.RED);
        aux.add(bCancelar);
        aux.add(bValidar);
        pCadastro.add(aux);

    }

    private void Tabela() {
        String colunas[] = {"Nome", "Id Cliente", "Contacto", "Endereco"};
        String produto[][] = {{"Omar", "1234", "865444444", "CCA"},
        {"Edson", "1234", "865444444", "CCA"},
        {"Tuy", "4544", "865444444", "RAA"},
        {"Dan", "1234", "865444444", "CCA"},
        {"Joel", "1234", "865444444", "CCA"}};
        pVisualizar = new JPanel();
        pVisualizar.setBorder(BorderFactory.createTitledBorder("Tabela Cliente"));
        pVisualizar.setBounds(310, 120, 800, 500);
//        ptabela.setBackground(Color.BLACK);
        JTable tabela = new JTable(produto, colunas);
        JScrollPane barra = new JScrollPane(tabela);
        pVisualizar.add(barra);
        tabela.setPreferredScrollableViewportSize(new Dimension(760, 430));
    }

    public static void main(String[] args) {
        new Cliente();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == bCadastrar) {
            this.remove(limg);
            this.remove(pVisualizar);
            this.add(pCadastro);
            this.setVisible(false);
            this.setVisible(true);
        }
        if (ae.getSource() == bVisualizar) {
            this.remove(limg);
            this.remove(pCadastro);
            this.add(pVisualizar);
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
    }

}
