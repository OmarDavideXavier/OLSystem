package View.Interface;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Omar Davide Xavier
 */
public class ConexaoODX extends JFrame implements ActionListener {

    public JButton gitHub, interfac;

    public ConexaoODX() {

        gitHub = new JButton("Click Aqui");
        gitHub.setBackground(Color.yellow);
        gitHub.addActionListener(this);

        interfac = new JButton("Click Aqui");
        interfac.setBackground(Color.GREEN);
        interfac.addActionListener(this);
        
         gitHub.setFont(new Font("Sans-serif", Font.BOLD, 15));
         interfac.setFont(new Font("Sans-serif", Font.BOLD, 15));
    }

    public static void main(String[] args) {
        new ConexaoODX();
    }

    //Associar com internet
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == gitHub) {
            try {
                Desktop.getDesktop().browse(new URL("https://github.com/OmarDavideXavier").toURI());
            } catch (MalformedURLException ex) {
                Logger.getLogger(ConexaoODX.class.getName()).log(Level.SEVERE, null, ex);
            } catch (URISyntaxException ex) {
                Logger.getLogger(ConexaoODX.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ConexaoODX.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (ae.getSource() == interfac) {
            try {
                Desktop.getDesktop().browse(new URL("https://www.figma.com/proto/7baEFM8gTd0vPzgoQlXfeG/OLSystem?node-id=1%3A339&scaling=contain&page-id=1%3A169").toURI());
            } catch (MalformedURLException ex) {
                Logger.getLogger(ConexaoODX.class.getName()).log(Level.SEVERE, null, ex);
            } catch (URISyntaxException ex) {
                Logger.getLogger(ConexaoODX.class.getName()).log(Level.SEVERE, null, ex);
                
            } catch (IOException ex) {
                Logger.getLogger(ConexaoODX.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
