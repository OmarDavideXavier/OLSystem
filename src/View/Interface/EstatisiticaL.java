package View.Interface;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class EstatisiticaL {

    JFrame estatistica = new JFrame("Estatistica");
    JMenu operacao, ajuda;
    JMenuItem compra, venda;
    JMenuBar menubar;
    JButton but_sair, but_voltar, butConsultar;
    JLabel Gquantidade, GquantidadeValor, GquantidadeSting, GvalorObtido_label,
            GvalorObtido_numero, GvalorObtido_string,
            Gdesconto_label, Gdesconto_valor, Gdesconto_string,
            Gtotalgados_label, Gtotalgados_valor, Gtotalgados_string,
            GadosSobra_label, Gadosobra_valor, Gadosobra_string; // sobre gados
    JLabel squantidade, squantidadeValor, squantidadeSting, svalorObtido_label,
            svalorObtido_numero, svalorObtido_string,
            sdesconto_label, sdesconto_valor, sdesconto_string,
            stotalgados_label, stotalgados_valor, stotalgados_string,
            cereaisSobra_label, cereaisSobra_valor, cereaisSobra_string; // sobre cereais
    JComboBox Comboperacao, Combclientefornecedor;
    JTextField txdia, txmes, txano; // para cereais assim como para gados
    JLabel dataConsulta, label_gado, label_comra, Label_venda, estatistica_L,
            totalEntrada, totalendravalor, totalsaida, totalsaidavalor, totaldisponivel, totaldisponivelvalor;

    public EstatisiticaL() {
        componentes();
        Janela();

    }

    public void componentes() {

        but_sair = new JButton("Sair");
        but_sair.setBackground(Color.red);
        but_voltar = new JButton("Voltar");
        but_voltar.setBackground(Color.GRAY);
        butConsultar = new JButton("Consultar");
        butConsultar.setBackground(Color.GREEN);
        JButton[] arrayFonte = {but_sair, but_voltar, butConsultar};
        Font fonteLetra = new Font("Sans-serif", Font.BOLD, 20);
        for (int i = 0; i < arrayFonte.length; i++) {
            arrayFonte[i].setFont(fonteLetra);
        }

        JLabel[] arrayLabel_cereais = {squantidade, squantidadeValor, squantidadeSting, svalorObtido_label,
            svalorObtido_numero, svalorObtido_string,
            sdesconto_label, sdesconto_valor, sdesconto_string,
            stotalgados_label, stotalgados_valor, stotalgados_string,
            cereaisSobra_label, cereaisSobra_valor, cereaisSobra_string};
        JLabel[] arrayLabelCima = {totalEntrada, totalendravalor, totalsaida, totalsaidavalor, totaldisponivel, totaldisponivelvalor};

        compra = new JMenuItem("Compras");
        venda = new JMenuItem("Vendas");
        operacao = new JMenu("OPERACAO");
        operacao.add(compra);
        operacao.add(venda);
        ajuda = new JMenu("HELP");
        menubar = new JMenuBar();
        menubar.add(operacao);
        menubar.add(ajuda);
        estatistica.setJMenuBar(menubar);

        Gquantidade = new JLabel("QUANTIDADE"); // instancia de labels sobre gado
        GquantidadeValor = new JLabel("0.0");
        GquantidadeSting = new JLabel("...");
        GvalorObtido_label = new JLabel("VALOR OBTIDO");
        GvalorObtido_numero = new JLabel("0,00");
        GvalorObtido_string = new JLabel("Mt");
        Gdesconto_label = new JLabel("DESCONTO FEITO");
        Gdesconto_valor = new JLabel("0,00");
        Gdesconto_string = new JLabel("Mt");
        Gtotalgados_label = new JLabel("TOTAL");
        Gtotalgados_valor = new JLabel("0");
        Gtotalgados_string = new JLabel("");
        GadosSobra_label = new JLabel("STOCK");
        Gadosobra_valor = new JLabel("00");
        Gadosobra_string = new JLabel("DISPONIVEL");

        squantidade = new JLabel("QUANTIDADE"); // instancia de labels sobre cereais
        squantidadeValor = new JLabel("0.0");
        squantidadeSting = new JLabel("...");
        svalorObtido_label = new JLabel("VALOR OBTIDO");
        svalorObtido_numero = new JLabel("0,00");
        svalorObtido_string = new JLabel("Mt");
        sdesconto_label = new JLabel("DESCONTO FEITO");
        sdesconto_valor = new JLabel("0,00");
        sdesconto_string = new JLabel("Mt");
        stotalgados_label = new JLabel("TOTAL");
        stotalgados_valor = new JLabel("0");
        stotalgados_string = new JLabel("");
        cereaisSobra_label = new JLabel("STOCK");
        cereaisSobra_valor = new JLabel("00");
        cereaisSobra_string = new JLabel("DISPONIVEL");

        String operacaoo[] = {"Venda", "Compra"};
        Comboperacao = new JComboBox(operacaoo);
        Comboperacao.setFont(new Font("Sans-serif", Font.BOLD, 17));
        String clientFornec[] = {"Cliete", "Fornecedor"};
        Combclientefornecedor = new JComboBox(clientFornec);
        Combclientefornecedor.setFont(new Font("Sans-serif", Font.BOLD, 17));
        dataConsulta = new JLabel("Data");
        dataConsulta.setFont(new Font("Sans-serif", Font.BOLD, 17));
        txdia = new JTextField();
        txdia.setFont(new Font("Sans-serif", Font.BOLD, 18));
        txmes = new JTextField();
        txmes.setFont(new Font("Sans-serif", Font.BOLD, 18));
        txano = new JTextField();
        txano.setFont(new Font("Sans-serif", Font.BOLD, 18));
        label_gado = new JLabel("GADO");
        label_comra = new JLabel("COMPRAS");// evento
        Label_venda = new JLabel("VENDAS");
        Label_venda.setFont(new Font("Sans-serif", Font.BOLD, 50));
        label_comra.setFont(new Font("Sans-serif", Font.BOLD, 50));
        label_comra.setForeground(Color.WHITE);
        Label_venda.setForeground(Color.WHITE);
        estatistica_L = new JLabel("ESTATISTICA >>");

        totalEntrada = new JLabel("TOTAL ENTRADA");
        totalendravalor = new JLabel("0.00 ");
        totalsaida = new JLabel("TOTAL SAIDA ");
        totalsaidavalor = new JLabel("0.00 ");
        totaldisponivel = new JLabel("TOTAL DISPONIVEL ");
        totaldisponivelvalor = new JLabel("0.00 ");
    }

    private JPanel cereais() {
        JPanel P_cereais = new JPanel(new GridLayout(2, 1));
        //  P_cereais.setBackground(Color.LIGHT_GRAY);
        JPanel aux33 = new JPanel(new GridLayout(3, 2, 5, 10));

        JPanel aux22 = new JPanel(new GridLayout(5, 3, 20, 20));
        aux22.setBorder(new EmptyBorder(2, 10, 2, 10));
        aux22.setBorder(new TitledBorder(new LineBorder(Color.gray, 4, true), "CEREAIS"));
        aux33.setBorder(new TitledBorder(new LineBorder(Color.gray, 4, true), "CONSULTA"));

        JLabel[] arrayLabel_cereais = {squantidade, squantidadeValor, squantidadeSting, svalorObtido_label,
            svalorObtido_numero, svalorObtido_string,
            sdesconto_label, sdesconto_valor, sdesconto_string,
            stotalgados_label, stotalgados_valor, stotalgados_string,
            cereaisSobra_label, cereaisSobra_valor, cereaisSobra_string};

        Font fonteLetra = new Font("Sans-serif", Font.BOLD, 15);
        for (int i = 0; i < arrayLabel_cereais.length; i++) {
            arrayLabel_cereais[i].setFont(fonteLetra);
        }

        for (int i = 0; i < arrayLabel_cereais.length; i++) {
            aux22.add(arrayLabel_cereais[i]);
        }
        aux33.add(Comboperacao);
        aux33.add(Combclientefornecedor);
        aux33.add(dataConsulta);
        aux33.add(new JLabel(""));
        JPanel painel_Data = new JPanel(new GridLayout(1, 3));
        painel_Data.add(txdia);
        painel_Data.add(txmes);
        painel_Data.add(txano);
        aux33.add(painel_Data);
        aux33.add(butConsultar);

        P_cereais.add(aux22);
        P_cereais.add(aux33);
        return P_cereais;
    }

    private JPanel gado() {
        JPanel P_gado = new JPanel(new GridLayout(2, 1, 20, 1));
        JPanel aux2 = new JPanel(new GridLayout(5, 3, 20, 20));
        aux2.setBorder(new EmptyBorder(2, 10, 2, 10));
        aux2.setBorder(new TitledBorder(new LineBorder(Color.gray, 4, true), "GADO"));


        JLabel[] arrayLabels_gado = {Gquantidade, GquantidadeValor, GquantidadeSting, GvalorObtido_label,
            GvalorObtido_numero, GvalorObtido_string,
            Gdesconto_label, Gdesconto_valor, Gdesconto_string,
            Gtotalgados_label, Gtotalgados_valor, Gtotalgados_string,
            GadosSobra_label, Gadosobra_valor, Gadosobra_string};

        Font fonteLetra = new Font("Sans-serif", Font.BOLD, 15);
        for (int i = 0; i < arrayLabels_gado.length; i++) {
            arrayLabels_gado[i].setFont(fonteLetra);
        }

        for (int i = 0; i < arrayLabels_gado.length; i++) {
            aux2.add(arrayLabels_gado[i]);
        }

        P_gado.add(aux2);
        return P_gado;
    }

    private JPanel SairVoltar() {
        JPanel p_sair_voltr = new JPanel(new GridLayout(1, 8, 14, 14));
        p_sair_voltr.setBorder(new EmptyBorder(2, 10, 12, 10));
        p_sair_voltr.add(new JLabel(""));
        p_sair_voltr.add(new JLabel(""));
        p_sair_voltr.add(new JLabel(""));
        p_sair_voltr.add(new JLabel(""));
        p_sair_voltr.add(new JLabel(""));
        p_sair_voltr.add(new JLabel(""));
        p_sair_voltr.add(but_voltar);
        p_sair_voltr.add(but_sair);
        return p_sair_voltr;
    }

    public JPanel painelcima() {
        JPanel p_cima = new JPanel(new GridLayout(1, 3));
        p_cima.setBackground(new Color(89, 130, 176));
        estatistica_L.setForeground(Color.WHITE);
        estatistica_L.setFont(new Font("Sans-serif", Font.BOLD, 50));
        JLabel[] arrayLabelCima = {totalEntrada, totalendravalor, totalsaida, totalsaidavalor, totaldisponivel, totaldisponivelvalor};
        Font fonteLetra = new Font("Sans-serif", Font.BOLD, 20);
        for (int i = 0; i < arrayLabelCima.length; i++) {
            arrayLabelCima[i].setFont(fonteLetra);
            arrayLabelCima[i].setForeground(Color.WHITE);
        }
         //Painel azul 1
        JPanel a = new JPanel(new GridLayout(3, 1));
        a.setBackground(new Color(89, 130, 176));
        a.add(estatistica_L);
        a.add(new JLabel(""));
        a.add(new JLabel(""));
        // painel azul 2
         JPanel b = new JPanel(new GridLayout(3, 1));
        b.setBackground(new Color(89, 130, 176));
        b.add(Label_venda);
        b.add(new JLabel(""));
        b.add(new JLabel(""));
        // painel azul geral 3
        JPanel p_mineEstatistica = new JPanel(new GridLayout(3, 2));
        p_mineEstatistica.setBackground(new Color(89, 130, 176));
        p_mineEstatistica.setBorder(new TitledBorder(new LineBorder(Color.WHITE, 4, true), "GERAL"));
        for (int i = 0; i < arrayLabelCima.length; i++) {
            p_mineEstatistica.add(arrayLabelCima[i]);
        }
        p_cima.add(a);
        p_cima.add(b);
        p_cima.add(p_mineEstatistica);
        return p_cima;
    }
  

    public void Janela() {
        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout());
        JPanel org = new JPanel(new GridLayout(1, 2));
        org.setBorder(new EmptyBorder(0, 5, 0, 5));
        org.add(cereais());
        org.add(gado());// OCUPA TODA TELA
        painel.add(org);
        painel.add(painelcima(), BorderLayout.NORTH);
        painel.add(SairVoltar(), BorderLayout.SOUTH);

        estatistica.add(painel);
        estatistica.setSize(1350, 750);
        estatistica.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        estatistica.setVisible(true);
    }

    public static void main(String[] args) {
        new EstatisiticaL();
    }
}
