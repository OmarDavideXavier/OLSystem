package View.Interface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import javax.swing.border.*;

/*
* @author Omar Davide Xavier
 */
public class Venda extends JFrame implements ActionListener,KeyListener {

    JPanel paineImg, PainelGLobal, pImagem;
    JComboBox combTipoProduto;
    JRadioButton radioCereais, radioGado;
    ButtonGroup grupoBotao;
    JLabel labidProduto, labQuantidade, labTipoProduto, labPrecoProduto, labDinheiro, labEnter, labSubtotal,
            labData, labNomeCliente, labIdCliente, labContacto, labEndereco,
            labValorSubTotal, labPrecoRecebido, labTroco, f5, f2, f7, f9, imagem, LSubtotalvalor,
            LprecRecebidolvalor,
            LTrocovalor;
    JButton botaoValidar, botaoFinalizar, botaoCancelar;
    JTextField tQuantidade, tPreco, tDinheiro, tIdProduto, tData, tNomeCliente, tIdCliente, tContacto, tEndereco;
    ImageIcon img;

    public Venda() {
        InstanciarObjecto();
        ConfigurarJanela();
        Eventos();
    }

    String arrayGado[] = {"Cabrito", "Boi", "Vaca", "Suino"};
    String arrayCereais[] = {"Arroz", "MIlho", "Mandioca", "Trigo"};

    private void InstanciarObjecto() {
        labNomeCliente = new JLabel("Nome CLiente");
        labIdCliente = new JLabel("Id CLiente");
        labContacto = new JLabel("Contacto");
        labEndereco = new JLabel("Endereco");
        tNomeCliente = new JTextField();
        tNomeCliente = new JTextField();
        tIdCliente = new JTextField();
        tContacto = new JTextField();
        tEndereco = new JTextField();
        labData = new JLabel("Data");
        tData = new JTextField();
        radioCereais = new JRadioButton("Cereais");
        radioGado = new JRadioButton("Gados");
        grupoBotao = new ButtonGroup();
        grupoBotao.add(radioCereais);
        grupoBotao.add(radioGado);
        labidProduto = new JLabel("Id Produto");
        labTipoProduto = new JLabel("Tipo de Produto");
        labDinheiro = new JLabel("Dinheiro (MZn)");
        combTipoProduto = new JComboBox();
        labQuantidade = new JLabel("Quantidade(Kg)");
        tQuantidade = new JTextField();
        labPrecoProduto = new JLabel("Preco(MZn)");
        tPreco = new JTextField();
        tDinheiro = new JTextField();
        tIdProduto = new JTextField();
        botaoValidar = new JButton("Validar");
        botaoFinalizar = new JButton("Finalizar");
        botaoCancelar = new JButton("Cancelar");
        botaoCancelar.setBackground(Color.yellow);
        botaoValidar.setBackground(Color.GREEN);
        botaoFinalizar.setBackground(Color.RED);
        labEnter = new JLabel("Enter -Validar Venda");
        labSubtotal = new JLabel("Sub Total");
        labValorSubTotal = new JLabel();
        labPrecoRecebido = new JLabel("Preco Recebido");
        labTroco = new JLabel("Troco");
        LSubtotalvalor = new JLabel("0,00");
        LprecRecebidolvalor = new JLabel("0,00");
        LTrocovalor = new JLabel("0,00");
        f5 = new JLabel("F5-Conversor(MZn)");
        f2 = new JLabel("F2-Eliminar Ultimo Item");
        f7 = new JLabel("F8-Apagar Tudo");
        f9 = new JLabel("F9-Alterar Preco");

        JLabel[] arrayFonte = {labQuantidade, labidProduto, labData, labIdCliente, labContacto, labEndereco, labTipoProduto, labPrecoProduto,
            labNomeCliente, labDinheiro, labEnter, labSubtotal,
            labValorSubTotal, labPrecoRecebido, labTroco, f5, f2, f7, f9, LSubtotalvalor,
            LprecRecebidolvalor, LTrocovalor};

        Font fonteLetra = new Font(Font.SERIF, Font.BOLD, 22);
        for (int i = 0; i < arrayFonte.length; i++) {
            arrayFonte[i].setFont(fonteLetra);
            arrayFonte[i].setBackground(new Color(0, 62, 108));
        }
        Font fonteLetr = new Font(Font.SERIF, Font.BOLD, 20);
        JTextField a[] = {tQuantidade, tPreco, tDinheiro, tIdProduto, tData, tNomeCliente, tIdCliente, tContacto, tEndereco};
        for (int i = 0; i < a.length; i++) {
            a[i].setFont(fonteLetr);
        }

        botaoCancelar.setFont(fonteLetr);
        botaoFinalizar.setFont(fonteLetr);
        botaoValidar.setFont(fonteLetr);
    }

    public JPanel GerirPaineis() {
        JPanel aux2 = new JPanel(new GridLayout(10, 2, 20, 18));
        aux2.add(labidProduto);
        aux2.add(labQuantidade);
        aux2.add(tIdProduto);
        aux2.add(tQuantidade);
        aux2.add(labTipoProduto);
        aux2.add(labPrecoProduto);
        aux2.add(combTipoProduto);
        aux2.add(tPreco);
        aux2.add(labData);
        aux2.add(labDinheiro);
        aux2.add(tData);
        aux2.add(tDinheiro);
        aux2.add(labNomeCliente);
        aux2.add(labIdCliente);
        aux2.add(tNomeCliente);
        aux2.add(tIdCliente);
        aux2.add(labContacto);
        aux2.add(labEndereco);
        aux2.add(tContacto);
        aux2.add(tEndereco);
        aux2.setBackground(Color.LIGHT_GRAY);
        JPanel aux4 = new JPanel(new BorderLayout());
        aux4.add(Tabela(), BorderLayout.NORTH);
        JPanel aux5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        aux5.add(PainelImagem());
        aux5.add(aux2);
        aux5.add(aux4);

        JPanel psubtotal = new JPanel(new FlowLayout());
        psubtotal.setBackground(Color.lightGray);
        psubtotal.add(labSubtotal);
        psubtotal.add(new JLabel("                      "));
        psubtotal.add(LSubtotalvalor);
        JPanel pPrecoRecebido = new JPanel(new FlowLayout());
        pPrecoRecebido.setBackground(Color.GREEN);
        pPrecoRecebido.add(labPrecoRecebido);
        pPrecoRecebido.add(new JLabel("                                 "));
        pPrecoRecebido.add(LprecRecebidolvalor);
        JPanel ptroco = new JPanel(new FlowLayout());
        ptroco.setBackground(Color.lightGray);
        ptroco.add(labTroco);
        ptroco.add(new JLabel("                              "));
        ptroco.add(LTrocovalor);

        JPanel pbaixo = new JPanel(new GridLayout(4, 3, 20, 0));
        pbaixo.add(new JLabel(" "));
        pbaixo.add(new JLabel(" "));
        pbaixo.add(new JLabel(" "));
        pbaixo.add(psubtotal);
        pbaixo.add(pPrecoRecebido);
        pbaixo.add(ptroco);
        pbaixo.add(new JLabel(" "));
        pbaixo.add(new JLabel(" "));
        pbaixo.add(new JLabel(" "));
        pbaixo.add(new JLabel(" "));
        pbaixo.add(new JLabel(" "));

        JPanel pbotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pbotoes.add(botaoCancelar);
        pbotoes.add(botaoValidar);
        pbotoes.add(botaoFinalizar);

        pbaixo.add(pbotoes);

        JLabel la = new JLabel("CAIXA VENDA");
        la.setForeground(Color.WHITE);
        la.setFont(new Font("Sans-serif", Font.BOLD, 50));
        JPanel pi = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pi.add(la);
        pi.setBackground(Color.BLUE);
        JPanel lb = new JPanel(new FlowLayout(FlowLayout.LEFT));
        radioCereais.setFont(new Font("Sans-serif", Font.BOLD, 40));
        radioGado.setFont(new Font("Sans-serif", Font.BOLD, 40));
        lb.add(radioCereais);
        lb.add(radioGado);
        JPanel painelCima = new JPanel(new GridLayout());
        painelCima.add(lb);
        painelCima.add(la);
        painelCima.setBackground(Color.GREEN);

        PainelGLobal = new JPanel(new BorderLayout());
        PainelGLobal.setLayout(new BoxLayout(PainelGLobal, BoxLayout.Y_AXIS));
        PainelGLobal.add(painelCima, BorderLayout.NORTH);
        PainelGLobal.add(aux5, BorderLayout.CENTER);
        PainelGLobal.add(pbaixo, BorderLayout.SOUTH);

        return PainelGLobal;

    }

    private void ConfigurarJanela() {
        this.requestFocus();
        
        this.addKeyListener(this);
        this.add(GerirPaineis());
        this.setTitle("Venda");
        this.setSize(1366, 768);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private JPanel PainelImagem() {
        img = new ImageIcon("src\\View\\imagens\\intro.png");
        imagem = new JLabel();
        imagem.setIcon(img);
        pImagem = new JPanel();
        pImagem.add(imagem);
        pImagem.setOpaque(false);

        JPanel aux = new JPanel(new GridLayout(5, 1, 10, 10));
        aux.setBorder(BorderFactory.createTitledBorder("Atalhos"));
        aux.add(labEnter);
        aux.add(f5);
        aux.add(f2);
        aux.add(f7);
        aux.add(f9);
        aux.setBackground(new Color(255, 255, 255));

        JPanel aux2 = new JPanel(new BorderLayout());
        aux2.setBackground(new Color(89, 130, 176));
        aux2.setLayout(new BoxLayout(aux2, BoxLayout.Y_AXIS));
        aux2.add(pImagem);
        aux2.add(aux);

        return aux2;

    }

    private JPanel Tabela() {
        String[] array = {"id Produto", "Produto", "Tipo", "Quantidade", "Preco"};

        String[][] array1 = {{"12345678", "Arroz", "Cereal", "250kg", "25000 mts"},
        {"12345678", "Arroz", "Cereal", "250kg", "25000 mts"},
        {"12345678", "Farinha", "Cereal", "250kg", "25000 mts"},
        {"12345678", "Vaca", "Gado", "250kg", "25000 mts"},
        {"12345678", "Cabrito", "Cereal", "250kg", "25000 mts"},
        {"12345678", "Boe", "Cereal", "250kg", "25000 mts"},
        {"12345678", "Boe", "Cereal", "250kg", "25000 mts"},
        {"12345678", "Arroz", "Cereal", "250kg", "25000 mts"}
        };

        JTable tabela = new JTable(array1, array);
        JScrollPane scroll = new JScrollPane(tabela);;
        scroll.setPreferredSize(new Dimension(705, 445));

        JPanel aux = new JPanel();
        aux.add(scroll);
        aux.setBorder(BorderFactory.createTitledBorder("Lista de Produtos"));
        aux.setBackground(new Color(89, 130, 176));
        return aux;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == radioCereais) {
            img = new ImageIcon("src\\View\\imagens\\cereais.png");
            imagem.setIcon(img);
            pImagem.add(imagem);
            for (int i = 0; i < arrayCereais.length; i++) {
                combTipoProduto.addItem(arrayCereais[i]);
                combTipoProduto.removeItem(arrayGado[i]);
            }

        } else if (ae.getSource() == radioGado) {
            img = new ImageIcon("src\\View\\imagens\\gado.png");
            imagem.setIcon(img);
            pImagem.add(imagem);
            combTipoProduto.setLayout(null);
            for (int i = 0; i < arrayGado.length; i++) {
                combTipoProduto.removeItem(arrayCereais[i]);
                combTipoProduto.addItem(arrayGado[i]);
            }
        }
        if (ae.getSource() == botaoFinalizar) {
            this.setVisible(false);
        }

        if (ae.getSource() == botaoCancelar) {
            tIdProduto.setText("");
            tQuantidade.setText("");
            tData.setText("");
            tNomeCliente.setText("");
            tContacto.setText("");
            tPreco.setText("");
            tDinheiro.setText("");
            tIdCliente.setText("");
            tEndereco.setText("");
        }

    }

    private void Eventos() {
        radioCereais.addActionListener(this);
        radioGado.addActionListener(this);
        botaoFinalizar.addActionListener(this);
        botaoCancelar.addActionListener(this);

    }

    public static void main(String[] args) {
        new Venda();
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        System.out.println("voce precionou" +ke.getKeyChar());
       // if(ke.getKeyChar()==KeyEvent.)
// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
