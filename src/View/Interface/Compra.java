package View.Interface;

import Model.DAO.ProdutoDAO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import javax.swing.*;
import javax.swing.border.*;
import java.util.Date.*;

/*
* @author Omar Davide Xavier
 */
public class Compra extends JFrame implements ActionListener {

    private float preco;
    JPanel paineImg, PainelGLobal, pImagem, pTabela;
    public JComboBox combTipoProduto;
    JRadioButton radioCereais, radioGado;
    ButtonGroup grupoBotao;
    JLabel labidProduto, labQuantidade, labTipoProduto, labPrecoProduto, labDinheiro, labEnter, labSubtotal,
            labData, labNomeCliente, labIdCliente, labContacto, labEndereco,
            labValorSubTotal, labPrecoRecebido, labTroco, f5, f2, f7, f9, imagem, LSubtotalvalor,
            LprecRecebidolvalor,
            LTrocovalor;
    public JButton botaoValidar, botaoFinalizar, botaoCancelar,bok;
    public JTextField tQuantidade, tPreco, tDinheiro, tIdProduto, tData, tNomeCliente, tIdCliente, tContacto, tEndereco;
    ImageIcon img;
    ProdutoDAO p;

    public Compra() {
        InstanciarObjecto();
        ConfigurarJanela();
        Eventos();
    }

    String arrayGado[] = {"Cabrito", "Boi", "Vaca", "Suino"};
    String arrayCereais[] = {"Arroz", "Milho", "Mandioca", "Trigo"};

    private void InstanciarObjecto() {
        p = new ProdutoDAO();
        Tabela();
        LocalDate ldt = LocalDate.now();
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
        tData = new JTextField(ldt + "");
        radioCereais = new JRadioButton("Cereais");
        radioGado = new JRadioButton("Gados");
        grupoBotao = new ButtonGroup();
        grupoBotao.add(radioCereais);
        grupoBotao.add(radioGado);
        labidProduto = new JLabel("Id Produto");
        labTipoProduto = new JLabel("Nome Produto");
        labDinheiro = new JLabel("Preco Recebido");
        combTipoProduto = new JComboBox(); //Gado ou Cereais
        labQuantidade = new JLabel("Quantidade(Kg)");
        tQuantidade = new JTextField();
        labPrecoProduto = new JLabel("Preco(MZn)");
        tPreco = new JTextField();
        tDinheiro = new JTextField();
        tIdProduto = new JTextField();
        botaoValidar = new JButton("Validar");
        botaoFinalizar = new JButton("Finalizar");
        botaoCancelar = new JButton("Reset");
        botaoCancelar.setBackground(Color.yellow);
        botaoValidar.setBackground(Color.GREEN);
        botaoFinalizar.setBackground(Color.RED);
        labEnter = new JLabel("Enter -Validar Venda");
        labSubtotal = new JLabel("Sub Total");
        labValorSubTotal = new JLabel();
        labPrecoRecebido = new JLabel("Preco Recebido");
        labTroco = new JLabel("Troco");
        LSubtotalvalor = new JLabel(p.subtotal + "MZN");
        LprecRecebidolvalor = new JLabel("0,00");
        LTrocovalor = new JLabel("0,00");
        f5 = new JLabel("F5-Conversor(MZn)");
        f2 = new JLabel("F2-Eliminar Ultimo Item");
        f7 = new JLabel("F8-Apagar Tudo");
        f9 = new JLabel("F9-Alterar Preco");
        bok=new JButton("Ok");

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
        bok.setFont(fonteLetr);
        bok.setBackground(Color.BLUE);
        bok.setForeground(Color.WHITE);
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
        aux4.add(pTabela, BorderLayout.NORTH);
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
        pbotoes.add(bok);
        pbotoes.add(botaoCancelar);
        pbotoes.add(botaoValidar);
        pbotoes.add(botaoFinalizar);

        pbaixo.add(pbotoes);

        JLabel la = new JLabel("CAIXA COMPRA");
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
        aux2.setBackground(Color.BLUE);
        aux2.setLayout(new BoxLayout(aux2, BoxLayout.Y_AXIS));
        aux2.add(pImagem);
        aux2.add(aux);

        return aux2;

    }

    private void Tabela() {
        pTabela = new JPanel();
        pTabela.add(p.MostrarTabelaTodos());
        pTabela.setBorder(BorderFactory.createTitledBorder("Lista de Produtos"));
        pTabela.setBackground(Color.BLUE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == radioCereais) {
            img = new ImageIcon("src\\View\\imagens\\cereais.png");
            imagem.setIcon(img);
            pImagem.add(imagem);
            for (int i = 0; i < arrayCereais.length; i++) {
                combTipoProduto.removeItem(arrayGado[i]);
                combTipoProduto.addItem(arrayCereais[i]);
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
        if (ae.getSource() == combTipoProduto) {
            if (combTipoProduto.getSelectedItem() == "Arroz") {
                preco = Float.parseFloat(tQuantidade.getText()) * 250;
            } else if (combTipoProduto.getSelectedItem() == "Milho") {
                preco = Float.parseFloat(tQuantidade.getText()) * 350;
            } else if (combTipoProduto.getSelectedItem() == "Mandioca") {
                preco = Float.parseFloat(tQuantidade.getText()) * 300;
            } else if (combTipoProduto.getSelectedItem() == "Trigo") {
                preco = Float.parseFloat(tQuantidade.getText()) * 450;
            } else if (combTipoProduto.getSelectedItem() == "Cabrito") {
                preco = Float.parseFloat(tQuantidade.getText()) * 450;
            } else if (combTipoProduto.getSelectedItem() == "Boi") {
                preco = Float.parseFloat(tQuantidade.getText()) * 500;
            } else if (combTipoProduto.getSelectedItem() == "Vaca") {
                preco = Float.parseFloat(tQuantidade.getText()) * 400;
            } else if (combTipoProduto.getSelectedItem() == "Suino") {
                preco = Float.parseFloat(tQuantidade.getText()) * 425;
            }
            tPreco.setText(preco + "");
        }if(ae.getSource()==bok){
        float auxvalor=(Float.parseFloat(tDinheiro.getText()))-preco;
            LTrocovalor.setText(auxvalor+"MZN");
            auxvalor=(Float.parseFloat(tDinheiro.getText()))-preco;
            LprecRecebidolvalor.setText(Float.parseFloat(tDinheiro.getText())+"MZN");
        }
        
    }

    private void Eventos() {
        bok.addActionListener(this);
        combTipoProduto.addActionListener(this);
        radioCereais.addActionListener(this);
        radioGado.addActionListener(this);
        botaoFinalizar.addActionListener(this);
        botaoCancelar.addActionListener(this);
    }

    public static void main(String[] args) {
        new Compra();
    }
}
