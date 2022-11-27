/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class Recibo extends JFrame{

    public JButton bImprimir, bSair,bCompra,bVenda;
    public JPanel pCompra, pVenda, pCima,pInfo, pOpcao;
    private JLabel lOLSystem;
    
    public Recibo() {
        this.setLayout(null);
        InstanciarObjectos();
        GerirPaineis();
        ConfigurarJanela();
    }

    private void InstanciarObjectos() {
        lOLSystem=new JLabel("OLSystem");       
        lOLSystem.setFont(new Font(null, Font.BOLD, 30));
        pCima=new JPanel();
        bCompra=new JButton("Compra");
        bVenda=new JButton("Venda");
        bImprimir =new JButton("Imprimir");
        bSair=new JButton("Sair");
        pOpcao=new JPanel(new GridLayout(1,2,10,0));
        
        pInfo=new JPanel(new GridLayout(2,1));
    }

    private void ConfigurarJanela() {
        this.add(pCima);
        this.add(pInfo);
        this.add(pCompra);
        this.add(pOpcao);
        this.setTitle("Recibo");
        this.setSize(467, 362);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void GerirPaineis() {
        //Painel Cima
        pCima.setBackground(Color.BLUE);
         lOLSystem.setForeground(Color.WHITE);
        pCima.setBounds(0, 0, 500, 50);
        pCima.add(lOLSystem);
        
       pInfo.add(bCompra);
       pInfo.add(bVenda);
       pInfo.setBounds(10,50,100,60);
       
        pOpcao.setBounds(240,270,180,30);
        pOpcao.add(bImprimir);
        pOpcao.add(bSair);
       
       //Tabela
         
        String[] array = {"id Produto", "Produto", "Preco"};

        String[][] array1 = {{"12345678", "Arroz",  "25000 mts"},
        {"12345678", "Arroz", "25000 mts"},
          {"12345678", "Farinha", "25000 mts"},
        {"12345678", "Vaca","25000 mts"},
        {"12345678", "Cabrito", "25000 mts"},
        {"12345678", "Boe", "25000 mts"},
        {"12345678", "Boe", "25000 mts"},
        {"12345678", "Farinha", "25000 mts"},
        {"12345678", "Vaca","25000 mts"},
        {"12345678", "Cabrito", "25000 mts"},
        {"12345678", "Boe", "25000 mts"},
        {"12345678", "Boe", "25000 mts"},
        {"12345678", "Arroz", "25000 mts"},{"12345678", "Cabrito", "25000 mts"},
        {"12345678", "Boe", "25000 mts"},
        {"12345678", "Boe", "25000 mts"},
        {"12345678", "Arroz", "25000 mts"}
        };

        JTable tabela = new JTable(array1, array);
        JScrollPane scroll = new JScrollPane(tabela);;
        scroll.setPreferredSize(new Dimension(305, 100));

        pCompra = new JPanel();
        pCompra.add(scroll);
        pCompra.setBorder(BorderFactory.createTitledBorder("Lista de Produtos"));
        
        pCompra.setBounds(110, 90, 350, 150);
      
       
       
        
    }
    public static void main(String[] args) {
        new Recibo();
    }
}

