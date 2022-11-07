package View.Interface;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/*
 * @author Omar Davide Xavier
 */
public class Login extends JFrame implements ActionListener {

    private JButton bLogin, bResetBotao;
    private JTextField tEmail;
    private JPasswordField password;
    private JLabel lEmail, lpassword, lMensagem;

    private HashMap<String, String> loginInfo = new HashMap<String, String>();

    public Login() {
        //Passwords
        loginInfo.put("omardavidexavier", "12345678");
        loginInfo.put("luisjuniormunaira", "87654321");
        loginInfo.put("OLSystem", "poo22022");
        loginInfo.put("User Id", "password");
        loginInfo.put("", "");

        InstaciarObjectos();
        ConfigurarJanela();

    }

    private void InstaciarObjectos() {
        bLogin = new JButton("Login");
        bResetBotao = new JButton("Reset");
        tEmail = new JTextField();
        password = new JPasswordField();
        lEmail = new JLabel("User Id");
        lpassword = new JLabel("password");
        lMensagem = new JLabel("");

        bLogin.addActionListener(this);
        bResetBotao.addActionListener(this);
        lMensagem.setFont(new Font(null, Font.ITALIC, 25));
        
        Font fonte=new Font(null, Font.BOLD, 20);
        bLogin.setFont(fonte);
        bResetBotao.setFont(fonte);
        tEmail.setFont(fonte);
        password.setFont(fonte);
        lEmail.setFont(fonte);
        lpassword.setFont(fonte);
        
        bLogin.setBackground(Color.GREEN);
        bResetBotao.setBackground(Color.yellow);

    }

    private JPanel GerirPaineis() {

        JPanel pLogin = new JPanel(new GridBagLayout());
        pLogin.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        pLogin.setBounds(500, 284, 450, 250);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 2;
        pLogin.add(lEmail, gbc);

         gbc.gridy = 1;
        pLogin.add(tEmail, gbc);

        gbc.gridy = 2;
        pLogin.add(lpassword, gbc);

        gbc.gridy = 3;
        pLogin.add(password, gbc);

        JPanel aux = new JPanel(new GridLayout(1, 2, 10, 10));
        aux.add(bResetBotao);
        aux.add(bLogin);

        gbc.gridy = 4;
        gbc.gridx = 1;
        pLogin.add(aux, gbc);

        gbc.gridy = 5;
        gbc.gridx = 1;
        pLogin.add(lMensagem, gbc);

        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.gridheight=4;
        ImageIcon img7 = new ImageIcon("src\\View\\imagens\\tuy.png");
        JLabel img = new JLabel();
        img.setIcon(img7);
        pLogin.add(img,gbc);

        return pLogin;
    }

    private void ConfigurarJanela() {
        this.setLayout(null);
        this.add(GerirPaineis());
        this.setTitle("Login");
        this.setSize(1366, 768);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == bResetBotao) {
            tEmail.setText("");
            password.setText("");
        }

        if (ae.getSource() == bLogin) {
            String user = tEmail.getText();
            String passe = String.valueOf(password.getPassword());

            if (loginInfo.containsKey(user)) {
                if (loginInfo.get(user).contentEquals(passe)) {
                    lMensagem.setForeground(Color.GREEN);
                    lMensagem.setText("Done! :)");
                   this.dispose();
                   new Menu();
                    
                } else {
                    lMensagem.setForeground(Color.RED);
                    lMensagem.setText("  Wrong Password    ");
                }
            } else {
                lMensagem.setForeground(Color.RED);
                lMensagem.setText("User name not found");
            }
        }

    }

    public static void main(String[] args) {
        new Login();
    }

}
