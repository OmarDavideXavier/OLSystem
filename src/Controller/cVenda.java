/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DAO.FornecedorDAO;
import Model.DAO.ProdutoDAO;
import Model.DAO.VendaDAO;
import View.Interface.Venda;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
/*
 * @author Omar Davide Xavier
 */
public class cVenda implements ActionListener {

   private Venda v;
   VendaDAO vd=new VendaDAO();
 
    public cVenda() {
        v = new Venda();
        v.but_Sair.addActionListener(this);
        v.radioCereais.addActionListener(this);
        v.radioGado.addActionListener(this);
        v.but_Confirmar.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == v.but_Sair) {
            v.dispose();
        }
        if(ae.getSource()==v.but_Confirmar){
            vd.CadastrarFornecedor_Produto(v);
            ProdutoDAO p=new ProdutoDAO();
            p.CadastrarProduto(v);
            FornecedorDAO f=new FornecedorDAO();
            f.CadastroFornecedor(v);
            JOptionPane.showMessageDialog(null, "Operacao efectuada com sucesso!");
            v.dispose();
            new cVenda();
        } 
        
          if (ae.getSource() == v.radioCereais) {
            for (int i = 0; i < v.arrayCereais.length; i++) {
                v.combo_nomeProduto.removeItem(v.arrayGado[i]);
                v.combo_nomeProduto.addItem(v.arrayCereais[i]);
            }

        } else if (ae.getSource() == v.radioGado) {
           v.combo_nomeProduto.setLayout(null);
            for (int i = 0; i < v.arrayGado.length; i++) {
                v.combo_nomeProduto.removeItem(v.arrayCereais[i]);
                v.combo_nomeProduto.addItem(v.arrayGado[i]);
            }
        }
    }
    
    public static void main(String[] args) {
        new cVenda();
    }
}
