package View.Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;

/**
 * @author Munaira
 */
public class Venda extends JFrame{

    JLabel L_idProduto, L_quantidade, L_preco, L_nomeProduto, L_data, L_endereco, L_telefone,
            L_nomeFornecedor, L_idFornecedor, L_subtotal, L_total, L_Troco;
    public JTextField t_idProduto, t_quantidade, t_preco,t_endereco, t_telefone,
            t_nomeFornecedor, t_idFornecedor, t_subtotal, t_total, t_Troco, t_grupo, t_data;
    public JButton but_novoProduto, but_Limpar, but_Sair, but_Cancelar, but_Confirmar;
    JComboBox combo_nomeProduto, combo_grupo;
    JLabel SbTotalValor, totalValor, Troco;
    JPanel principal;
    String arrayGado[] = {"Cabrito", "Boi", "Vaca", "Suino"};
    String arrayCereais[] = {"Arroz", "Milho", "Mandioca", "Trigo"};

    public Venda() {
        InstanciarObjecto();
        ConfigurarJanela();
    }

    private void InstanciarObjecto() {
        String grupo[] = {"Cereais", "Gado"};
        combo_grupo = new JComboBox(grupo);
         combo_nomeProduto = new JComboBox();
        but_novoProduto = new JButton("Novo Produto");
        but_Limpar = new JButton("Limpar");
        but_Sair = new JButton("Sair");
        but_Cancelar = new JButton("Cancelar Compra");
        but_Confirmar = new JButton("Validar");
        L_idProduto = new JLabel("IdProduto");
        L_quantidade = new JLabel("Quantidade(Kg)");
        L_preco = new JLabel("Preco(MZN)");
        L_nomeProduto = new JLabel("NomeProduto");
        L_data = new JLabel("Data");
        t_data = new JTextField();
        L_endereco = new JLabel("Endereco");
        L_nomeFornecedor = new JLabel("Nome do Fornecedor");
        L_telefone = new JLabel("Contacto");
        L_idFornecedor = new JLabel("Id Forncedor");
        L_subtotal = new JLabel("SubTotal");
        SbTotalValor = new JLabel("0,00");
        totalValor = new JLabel("0,00");
        L_total = new JLabel("Total");
        L_Troco = new JLabel("Troco");
        Troco = new JLabel("0, 00");
        t_idProduto = new JTextField();
        t_quantidade = new JTextField();
        t_preco = new JTextField();
        t_endereco = new JTextField();
        t_nomeFornecedor = new JTextField();
        t_telefone = new JTextField();
        t_idFornecedor = new JTextField();
        but_novoProduto.setBackground(Color.GREEN);
        but_Limpar.setBackground(Color.YELLOW);
        but_Sair.setBackground(Color.red);
        but_Cancelar.setBackground(Color.gray);
        but_Confirmar.setBackground(Color.GREEN);

        Font fonte20 = new Font("Sans-serif", Font.BOLD, 20);
        JLabel arrayLabel[] = {L_idProduto, L_quantidade, L_preco, L_nomeProduto, L_data,
            L_endereco, L_nomeFornecedor, L_telefone, L_idFornecedor};

        for (int i = 0; i < arrayLabel.length; i++) {
            arrayLabel[i].setFont(fonte20);
            arrayLabel[i].setForeground(Color.BLACK);
        }
        combo_grupo.setFont(fonte20);

        Font fonte25 = new Font("Sans-serif", Font.BOLD, 25);
        JButton arrayBotao[] = {but_novoProduto, but_Limpar, but_Sair, but_Cancelar, but_Confirmar};

        for (int i = 0; i < arrayBotao.length; i++) {
            arrayBotao[i].setFont(fonte25);
        }

        JTextField arrayTextField[] = {t_idProduto, t_data, t_quantidade, t_preco,
            t_endereco, t_nomeFornecedor, t_telefone, t_idFornecedor};
        for (int i = 0; i < arrayTextField.length; i++) {
            arrayTextField[i].setFont(fonte20);
        }

        L_subtotal.setFont(fonte25);
        SbTotalValor.setFont(fonte25);
        L_total.setFont(fonte25);
        totalValor.setFont(fonte25);
        totalValor.setForeground(Color.WHITE);
        L_Troco.setFont(fonte25);
        Troco.setFont(fonte25);
    }

    private JPanel OrganizarPainel() {
        JPanel psubtotal = new JPanel(new FlowLayout());
        psubtotal.setBackground(Color.lightGray);
        psubtotal.add(L_subtotal);
        psubtotal.add(new JLabel("                      "));
        psubtotal.add(SbTotalValor);

        JPanel ptotal = new JPanel(new FlowLayout());
        ptotal.setBackground(Color.GREEN);
        ptotal.add(L_total);
        ptotal.add(new JLabel("                                 "));
        ptotal.add(totalValor);

        JPanel ptroco = new JPanel(new FlowLayout());
        ptroco.setBackground(Color.lightGray);
        ptroco.add(L_Troco);
        ptroco.add(new JLabel("                              "));
        ptroco.add(Troco);

        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(3, 1, 80, 20));
        p2.setBackground(Color.blue);
        p2.add(new JLabel(""));
        p2.add(new JLabel("")); //Painel Azul de Cima
        p2.add(new JLabel(""));

        JPanel p3 = new JPanel(new GridLayout(1, 1));
        JLabel la = new JLabel("CAIXA VENDA");
        p3.setBackground(Color.BLUE);
        // p3.add(new JLabel(""));
        p3.add(la);
        la.setForeground(Color.WHITE);
        la.setFont(new Font("Sans-serif", Font.BOLD, 60));

        JPanel painelTot = new JPanel();
        painelTot.setLayout(new GridLayout(1, 2));
        painelTot.add(p2);
        painelTot.add(p3);

        JPanel pcentro = new JPanel();
        pcentro.setLayout(new GridLayout(7, 3, 10, 2));
        pcentro.setBackground(Color.LIGHT_GRAY);
        pcentro.add(combo_grupo);
        pcentro.add(new JLabel(""));
        pcentro.add(new JLabel(""));
        pcentro.add(L_idProduto);
         pcentro.add(L_quantidade);
        pcentro.add(L_nomeFornecedor);
        pcentro.add(t_idProduto);
         pcentro.add(t_quantidade);       
        pcentro.add(t_nomeFornecedor);
       pcentro.add(L_nomeProduto);
        pcentro.add(L_data);
        pcentro.add(L_telefone);
        pcentro.add(combo_nomeProduto);
        pcentro.add(t_data);
        pcentro.add(t_telefone);
        pcentro.add(L_preco);
        pcentro.add(L_endereco);
        pcentro.add(L_idFornecedor);
        pcentro.add(t_preco);
        pcentro.add(t_endereco);
        pcentro.add(t_idFornecedor);

        JPanel pCentroTabela = new JPanel(new GridLayout(1, 2));
        pCentroTabela.add(pcentro);
        pCentroTabela.add(Tabela());

        JPanel pbaixo = new JPanel();
        // pbaixo.setBackground(Color.);
        pbaixo.setLayout(new GridLayout(4, 3, 80, 10));
        pbaixo.add(psubtotal);
        pbaixo.add(ptotal);
        pbaixo.add(ptroco);
        pbaixo.add(but_Cancelar);
        pbaixo.add(new JLabel(" "));
        pbaixo.add(new JLabel(" "));
        pbaixo.add(new JLabel(" "));
        // pbaixo.add(but_novoProduto);
        pbaixo.add(new JLabel(" "));
        pbaixo.add(new JLabel(" "));
        pbaixo.add(new JLabel(" "));
        pbaixo.add(new JLabel(" "));

        JPanel p_ok_sair = new JPanel();
        p_ok_sair.setLayout(new GridLayout(1, 2, 2, 2));
        p_ok_sair.add(but_Confirmar);
        p_ok_sair.add(but_Sair);
        pbaixo.add(p_ok_sair);

        JPanel principal_baixo = new JPanel(new BorderLayout());
        principal_baixo.setBorder(new EmptyBorder(10, 10, 10, 10));
        principal_baixo.add(pbaixo, BorderLayout.NORTH);

        principal = new JPanel();
        //principal.setBackground(Color.WHITE);
        principal.setLayout(new BorderLayout());
        principal.add(pCentroTabela, BorderLayout.CENTER);
        principal.add(painelTot, BorderLayout.NORTH);
        principal.add(new JPanel(), BorderLayout.EAST);
        principal.add(principal_baixo, BorderLayout.SOUTH);
        return principal;
    }

    private JPanel Tabela() {
        String colunas[] = {"ID", "Produto", "Tipo", "Quantidade", "Preco"};
        String produto[][] = {{"0001", "Gado", "Cabrito", "30", "40000"},
        {"0002", "Gado", "Vaca", "20", "340000"},
        {"3462", "Cereais", "Milho", "50", "10000"}};
        JPanel ptabela = new JPanel();
        ptabela.setBackground(Color.BLACK);
        JTable tabela = new JTable(produto, colunas);
        JScrollPane barra = new JScrollPane(tabela);
        ptabela.add(barra);
        tabela.setPreferredScrollableViewportSize(new Dimension(664, 430));
        return ptabela;
    }

    private void ConfigurarJanela() {
        this.add(OrganizarPainel());
        this.setSize(1366, 768);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Venda();
    }
}
