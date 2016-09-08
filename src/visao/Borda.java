/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import regraNegocio.BordaRN;
import vo.BordaVO;


/**
 *
 * @author Raphael
 */
public class Borda extends Template implements ActionListener{

    /**
     * Creates new form Borda
     */
    public Borda() {
        initComponents();
        listarBorda();
       
        this.setLocationRelativeTo(null);
        setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        rbDoce = new javax.swing.JRadioButton();
        rbSalgada = new javax.swing.JRadioButton();
        txtPreco = new javax.swing.JTextField();
        txtSabor = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Borda");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipo :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        rbDoce.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbDoce.setSelected(true);
        rbDoce.setText("Doce");
        rbDoce.setEnabled(false);
        rbDoce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDoceActionPerformed(evt);
            }
        });

        rbSalgada.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbSalgada.setText("Salgada");
        rbSalgada.setEnabled(false);
        rbSalgada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSalgadaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbDoce)
                    .addComponent(rbSalgada))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbDoce)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbSalgada)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtPreco.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPreco.setEnabled(false);

        txtSabor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtSabor.setEnabled(false);

        txtCodigo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCodigo.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Código :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Sabor :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Preço :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSabor)
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(302, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtSabor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbDoceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDoceActionPerformed
        rbDoce.setSelected(true);
        rbSalgada.setSelected(false);
    }//GEN-LAST:event_rbDoceActionPerformed

    private void rbSalgadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSalgadaActionPerformed
        rbDoce.setSelected(false);
        rbSalgada.setSelected(true);
    }//GEN-LAST:event_rbSalgadaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Borda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Borda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Borda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Borda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Borda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton rbDoce;
    private javax.swing.JRadioButton rbSalgada;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtSabor;
    // End of variables declaration//GEN-END:variables

    @Override
    public void btCadastrarActionPerformed(ActionEvent e) {
        txtPreco.setEnabled(true);
        txtSabor.setEnabled(true);
        rbDoce.setEnabled(true);
        rbSalgada.setEnabled(true);
        btEditar.setEnabled(true);
        
        BordaRN bordaRN = new BordaRN();        
        try {
            int ultimoID = bordaRN.pegarUltimoID() + 1;
            txtCodigo.setText(String.valueOf(ultimoID));
        } catch (SQLException sqle) {

            JOptionPane.showMessageDialog(null, "Erro: " + sqle.getMessage(), "Borda", JOptionPane.ERROR_MESSAGE);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage(), "Borda", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void btEditarActionPerformed(ActionEvent e) {
        txtPreco.setEnabled(true);
        txtSabor.setEnabled(true);
        rbDoce.setEnabled(true);
        rbSalgada.setEnabled(true);
        
        int selecionada = tbTemplate.getSelectedRow();
        String vtemp = (tbTemplate.getValueAt(selecionada, 2).toString());
            txtCodigo.setText((tbTemplate.getValueAt(selecionada, 0).toString()));
            txtSabor.setText((tbTemplate.getValueAt(selecionada, 1).toString()));
            txtPreco.setText(vtemp.replace(" ", "").replace("R","").replace("$","").replace(",","."));
            if ("Doce".equals(tbTemplate.getValueAt(selecionada, 3).toString())){
             rbDoce.setSelected(true);
             rbSalgada.setSelected(false);
            }
            else{
             rbSalgada.setSelected(true);
             rbDoce.setSelected(false);
            }
    }

    @Override
    public void btExcluirActionPerformed(ActionEvent e) {
        txtPreco.setEnabled(false);
        txtSabor.setEnabled(false);
        rbDoce.setEnabled(false);
        rbSalgada.setEnabled(false);
        int n = JOptionPane.showConfirmDialog(null,"Deseja excluir a borda? ","Borda",JOptionPane.YES_NO_OPTION);
        if(n==0){
            try{
            BordaVO bordaVO = new BordaVO();
     
            int selecionada = tbTemplate.getSelectedRow();
            bordaVO.setCodigo((int) tbTemplate.getValueAt(selecionada, 0));
            
            BordaRN bordaRN = new BordaRN();
            bordaRN.excluirBorda(bordaVO);
            
            txtCodigo.setText("");
            txtSabor.setText("");
            txtPreco.setText("");
            
            atualizarLista();
            
            //buscaBorda.popularTabela();
            
        } catch (SQLException w) {

            JOptionPane.showMessageDialog(null, "Erro: " + w.getMessage(), "Exclusão de Borda", JOptionPane.ERROR_MESSAGE);
        
        } catch (Exception w) {

            JOptionPane.showMessageDialog(null, "Erro: " + w.getMessage(), "Exclusão de Borda", JOptionPane.ERROR_MESSAGE);
        }
        
        //this.dispose();
        
        txtPreco.setEnabled(false);
        txtSabor.setEnabled(false);
        rbDoce.setEnabled(false);
        rbSalgada.setEnabled(false);
            
            JOptionPane.showMessageDialog(null,"Borda excluida com sucesso! ","Borda",JOptionPane.INFORMATION_MESSAGE);
        }
            
        
    }

    @Override
    public void btCancelarActionPerformed(ActionEvent e) {
        int n = JOptionPane.showConfirmDialog(null,"Deseja cancelar? ","Borda",JOptionPane.YES_NO_OPTION);
        if(n==0){
            this.dispose();
        }
        
    }

    @Override
    public void btSalvarActionPerformed(ActionEvent e) {        
        
        
        if (save == 1) {
            try{
                BordaVO bordaVO = new BordaVO();

                bordaVO.setCodigo(Integer.parseInt(txtCodigo.getText()));
                bordaVO.setSabor(txtSabor.getText());
                bordaVO.setPreco(txtPreco.getText());
                if(rbDoce.isSelected())
                    bordaVO.setTipo("Doce");
                else
                    bordaVO.setTipo("Salgada");
               bordaVO.setStatus("true");


                BordaRN bordaRN = new BordaRN();
                bordaRN.cadastrarBorda(bordaVO);

                txtCodigo.setText("");
                txtSabor.setText("");
                txtPreco.setText("");

                atualizarLista();

                //buscaBorda.popularTabela();

                JOptionPane.showMessageDialog(null,"Borda adicionada com sucesso! ","Borda",JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException w) {

                JOptionPane.showMessageDialog(null, "Erro: " + w.getMessage(), "Cadastro Borda SQL", JOptionPane.ERROR_MESSAGE);

            } catch (Exception w) {

                JOptionPane.showMessageDialog(null, "Erro: " + w.getMessage(), "Cadastro Borda EX", JOptionPane.ERROR_MESSAGE);
            }
    }else if (save == 2) {
        try{
            BordaVO bordaVO = new BordaVO();

            bordaVO.setCodigo(Integer.parseInt(txtCodigo.getText()));
            bordaVO.setSabor(txtSabor.getText());
            bordaVO.setPreco(txtPreco.getText());
            if(rbDoce.isSelected())
                bordaVO.setTipo("Doce");
            else
                bordaVO.setTipo("Salgada");
           bordaVO.setStatus("true");
           
            
            BordaRN bordaRN = new BordaRN();
            bordaRN.editarBorda(bordaVO);
            
            txtCodigo.setText("");
            txtSabor.setText("");
            txtPreco.setText("");
            
            atualizarLista();
            
            //buscaBorda.popularTabela();
            
            JOptionPane.showMessageDialog(null,"Borda Editada com sucesso! ","Borda",JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException w) {

            JOptionPane.showMessageDialog(null, "Erro: " + w.getMessage(), "Edição de Borda", JOptionPane.ERROR_MESSAGE);
        
        } catch (Exception w) {

            JOptionPane.showMessageDialog(null, "Erro: " + w.getMessage(), "Edição de Borda", JOptionPane.ERROR_MESSAGE);
        } 
    }
        txtPreco.setEnabled(false);
        txtSabor.setEnabled(false);
        rbDoce.setEnabled(false);
        rbSalgada.setEnabled(false);
        
    }
    public final void atualizarLista(){
        try{
            BordaRN bordarn = new BordaRN();
            ArrayList<BordaVO> bordas = bordarn.listarBorda();
            
            DefaultTableModel modelo = (DefaultTableModel)tbTemplate.getModel();
            modelo.setRowCount(0);
            
            for (BordaVO bordaVO : bordas) {
                
                modelo.addRow(new Object[]{bordaVO.getCodigo(),bordaVO.getSabor(),bordaVO.getPreco(),bordaVO.getTipo(),bordaVO.getStatus()});
            }
            tbTemplate.setModel(modelo);
            
            ajustarTabelaBorda();
            
            
    
        }catch (SQLException | ClassNotFoundException ex) {
           
        } catch (Exception ex) {
            Logger.getLogger(BordaRN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public final void listarBorda(){
        try {
            
            BordaRN bordarn = new BordaRN();
            ArrayList<BordaVO> bordas = bordarn.listarBorda();
            
            DefaultTableModel modelo = (DefaultTableModel)tbTemplate.getModel();
            modelo.setRowCount(0);
            int n;
            
            for(n = 0; n<=3 ;n++)
            modelo.addColumn(this);
            
            for (BordaVO bordaVO : bordas) {
                
                modelo.addRow(new Object[]{bordaVO.getCodigo(),bordaVO.getSabor(),bordaVO.getPreco(),bordaVO.getTipo(),bordaVO.getStatus()});
            }
            tbTemplate.setModel(modelo);
            
            ajustarTabelaBorda();
            
            
            
           
        } catch (SQLException | ClassNotFoundException ex) {
           
        } catch (Exception ex) {
            Logger.getLogger(BordaRN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void ajustarTabelaBorda(){
        
        
        tbTemplate.getColumnModel().getColumn(0).setHeaderValue("Código");
        tbTemplate.getColumnModel().getColumn(1).setHeaderValue("Sabor");
        tbTemplate.getColumnModel().getColumn(2).setHeaderValue("Preço");
        tbTemplate.getColumnModel().getColumn(3).setHeaderValue("Tipo");
        
        tbTemplate.getColumnModel().getColumn(0).setPreferredWidth(200);
        tbTemplate.getColumnModel().getColumn(1).setPreferredWidth(200);
        tbTemplate.getColumnModel().getColumn(2).setPreferredWidth(100);
        tbTemplate.getColumnModel().getColumn(3).setPreferredWidth(200);
        
        tbTemplate.setDefaultEditor(Object.class, null);
        
      
    }
   
   /* public final void tbTemplateMouseClicked(java.awt.event.MouseEvent evt) {                                        
        //int zerando = e.getClickCount();
        
        //if(zerando >= 2){
        try{
            int selecionada = tbTemplate.getSelectedRow();
            txtCodigo.setText((tbTemplate.getValueAt(selecionada, 0).toString()));
            txtSabor.setText((tbTemplate.getValueAt(selecionada, 1).toString()));
            txtPreco.setText((tbTemplate.getValueAt(selecionada, 2).toString()));
            if ("Doce".equals(tbTemplate.getValueAt(selecionada, 3).toString()))
                rbDoce.isSelected();
            else
             rbSalgada.isSelected();
            
            btEditar.setEnabled(true);
            btExcluir.setEnabled(true);
            txtPreco.setEnabled(true);
            txtSabor.setEnabled(true);
            rbDoce.setEnabled(true);
            rbSalgada.setEnabled(true);
        //}
        
    }catch (Exception w) {

            JOptionPane.showMessageDialog(null, "Erro: " + w.getMessage(), "Erro ao Caputurar dados da Tabela EX", JOptionPane.ERROR_MESSAGE);
        }
    }
*/
}
