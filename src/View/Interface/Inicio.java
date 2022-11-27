package View.Interface;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

/**
 *
 * @author Omar Davide Xavier
 */
public class Inicio extends JFrame{

    JProgressBar bar; 
    
    public Inicio() {
        bar=new JProgressBar();
        bar.setValue(0);
        bar.setBounds(0,680, 1366,50);
        bar.setStringPainted(true);
        
        JLabel ols=new JLabel("OLSystem");
                Font fonteLetra = new Font(Font.SERIF, Font.BOLD, 100);
                ols.setBounds(450, 40, 1366, 584);
        ols.setFont(fonteLetra);
        ols.setForeground(Color.WHITE);
        
        
//         ImageIcon img7 = new ImageIcon("src\\View\\imagens\\Inicio.png");
//         JLabel img=new JLabel();
//         img.setIcon(img7);
//         img.setBounds(623, 70, 1366,704);
        
        JPanel aux=new JPanel();
        aux.setLayout(null);
        aux.add(ols);
       aux.setBackground(Color.BLUE);
        aux.setBounds(0, 0, 1366, 680);

//         ImageIcon imag1 = new ImageIcon("src\\View\\imagens\\771.gif");
//         JLabel im=new JLabel();
//         im.setIcon(imag1);
//         im.setBounds(647,290,1366,714);
        
    //     this.add(im);
   //     this.add(img);
        this.add(aux);
        this.setLayout(null);
        this.add(bar);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1366, 768);
        this.setLayout(null);
        this.setVisible(true);
        Encher();
   }
    
    private void Encher(){
        int cont=0;
        bar.setForeground(Color.BLACK);
        bar.setFont(new Font("MV Boli", Font.BOLD,25));
        while(cont<=100){
            bar.setValue(cont);
            try{
            Thread.sleep(150-120); //tem haver com timing de execucao
        }catch(InterruptedException e){
            //TODO Auto_Generated catch block
            e.printStackTrace();
        }
            cont+=1;
    }
        bar.setString("Done! :)");
        
        if(bar.getValue()==100){
          //  this.setVisible(false);
            this.dispose(); //Fechar a tela, envez de usar setVisible false. Usar dispose
            new Login();
        }
        
    }
    
    public static void main(String[] args) {
        new Inicio();
        }
    }
    
