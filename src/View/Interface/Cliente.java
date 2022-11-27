package View.Interface;

import Model.DAO.ClienteDAO;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author Omar Davide Xavier
 */
public class Cliente extends JFrame{

    public JButton bCadastrar;
    public JButton bRemover;

    public JButton bPaginaInicial,bActualizar;
    private JLabel lGestaoCliente, lNomeCliente, lIdCliente, lContacto, lEndereco, limg, lIdRemover;
    public JTextField tNomeCliente, tIdCliente, tContacto, tEndereco, tIdRemover;
    private JPanel pInformacoes, pTitulo, pCadastro, pRemocao, pVisualizar,pOpcoes;
    
    //Construtor
    public Cliente() {
        this.setLayout(null);
        InstanciarObjectos();
        GerirPaineis();
        Tabela();
        ConfigurarJanela();
    }

    //Instancia de Objectos
    private void InstanciarObjectos() {
        bCadastrar = new JButton("Cadastrar");
        bRemover = new JButton("Apagar");
        bPaginaInicial = new JButton("Pagina Inicial");
        lGestaoCliente = new JLabel("Gestao Cliente");
        lNomeCliente = new JLabel("Nome Cliente");
        lIdCliente = new JLabel("Id Cliente");
        lIdRemover = new JLabel("Id Cliente");
        lContacto = new JLabel("Contacto");
        lEndereco = new JLabel("Endereco");
        tNomeCliente = new JTextField();
        tIdCliente = new JTextField();
        tContacto = new JTextField();
        tEndereco = new JTextField();
        bActualizar=new JButton("Actualizar");
        pInformacoes = new JPanel(new GridLayout(1, 1));
        pTitulo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pCadastro = new JPanel(new GridLayout(8, 1, 10, 10));
        Font fonteLetr = new Font(Font.SERIF, Font.BOLD, 27);
        bPaginaInicial.setFont(fonteLetr);
        bPaginaInicial.setForeground(Color.WHITE);
        bPaginaInicial.setBackground(new Color(26, 31, 38));
        bCadastrar.setFont(fonteLetr);
        bActualizar.setFont(fonteLetr);
        bRemover.setFont(fonteLetr);
        
        JLabel b[] = {lGestaoCliente, lNomeCliente, lIdCliente, lContacto, lEndereco, lIdRemover};
        for (int i = 0; i < b.length; i++) {
            b[i].setFont(fonteLetr);
        }

        Font fonteLetra = new Font(Font.SERIF, Font.BOLD, 50);
        lGestaoCliente.setFont(fonteLetra);
        lGestaoCliente.setForeground(Color.WHITE);
        Tabela();
    }
    //Configuracao da JFrame
    private void ConfigurarJanela() {
        this.add(pOpcoes);
        this.add(pTitulo);
        this.add(pCadastro);
        this.add(pVisualizar);
        this.add(pInformacoes);
        this.setTitle("Cliente");
        this.setSize(1366, 768);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    //Gestao de paineis
    private void GerirPaineis() {
        //Painel de Informacoes
        pInformacoes.setBackground(new Color(92, 104, 104));
        pInformacoes.setBounds(0, 100, 200, 60);
        pInformacoes.add(bPaginaInicial);
        
        //Painel Titulo
        pTitulo.setBackground(Color.BLUE);
        pTitulo.setBounds(0, 0, 1366, 100);
        pTitulo.add(lGestaoCliente);

        //Painel Cadastro
        pCadastro.setBounds(200, 120, 300, 420);
        pCadastro.setBorder(BorderFactory.createTitledBorder("Cadastro"));
        pCadastro.add(lNomeCliente);
        pCadastro.add(tNomeCliente);
        pCadastro.add(lIdCliente);
        pCadastro.add(tIdCliente);
        pCadastro.add(lContacto);
        pCadastro.add(tContacto);
        pCadastro.add(lEndereco);
        pCadastro.add(tEndereco);
        
        //painel Opcoes  
        pOpcoes=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pOpcoes.setBounds(550, 630, 800, 50);
        
        bCadastrar.setBackground(Color.GREEN);
        bActualizar.setBackground(Color.ORANGE);
        bRemover.setBackground(Color.RED);
        pOpcoes.add(bCadastrar);
        pOpcoes.add(bActualizar);
        pOpcoes.add(bRemover);
        
    }
    
    //Painel para tabela
    public void Tabela() {
        ClienteDAO cDao = new ClienteDAO();
        pVisualizar = new JPanel();
        pVisualizar.setBackground(new Color(89, 130, 176));
        pVisualizar.setBorder(BorderFactory.createTitledBorder("Tabela Cliente"));
        pVisualizar.add(cDao.MostrarTabelaTodos());
        pVisualizar.setBounds(550, 120, 800, 500);
    }
}
