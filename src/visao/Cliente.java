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
import regraNegocio.ClienteRN;
import regraNegocio.ConsultarClienteRN;
import vo.ConsultarClienteVO;
import vo.ClienteVO;

/**
 *
 * @author Waly
 */
public class Cliente extends Template implements ActionListener{

    /**
     * Creates new form Cliente
     */
    public Cliente() {
        initComponents();
        listarCliente();
        this.setLocationRelativeTo(null);
        setResizable(false);
    }

    public void listarCliente(){
        try {
            ClienteRN clientern = new ClienteRN();
            ArrayList<ClienteVO> clientes = clientern.listarClientes();
            
            DefaultTableModel modelo = (DefaultTableModel)tbTemplate.getModel();
            modelo.setRowCount(0);
            int n;
            for(n = 0;n<=9;n++)
                modelo.addColumn(this);
            for (ClienteVO Cliente : clientes) {
                
                modelo.addRow(new Object[]{Cliente.getTelefone(),Cliente.getNome(),Cliente.getCep(),Cliente.getCidade(),Cliente.getBairro(),Cliente.getEstado(),Cliente.getLogradouro(),Cliente.getNumerocasa(),Cliente.getComplemento(), Cliente.getStatus()});
            }
            tbTemplate.setModel(modelo);
            ajustarTabelaCliente();
            
            
           
        } catch (SQLException | ClassNotFoundException ex) {
           
        } catch (Exception ex) {
            Logger.getLogger(ConsultaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void ajustarTabelaCliente(){
        
        tbTemplate.getColumnModel().getColumn(0).setHeaderValue("Telefone");
        tbTemplate.getColumnModel().getColumn(1).setHeaderValue("Nome");
        tbTemplate.getColumnModel().getColumn(2).setHeaderValue("CEP");
        tbTemplate.getColumnModel().getColumn(3).setHeaderValue("Cidade");
        tbTemplate.getColumnModel().getColumn(4).setHeaderValue("Bairro");
        tbTemplate.getColumnModel().getColumn(5).setHeaderValue("Estado");
        tbTemplate.getColumnModel().getColumn(6).setHeaderValue("Logradouro");
        tbTemplate.getColumnModel().getColumn(7).setHeaderValue("Numero");
        tbTemplate.getColumnModel().getColumn(8).setHeaderValue("Complemento");
        tbTemplate.getColumnModel().getColumn(9).setHeaderValue("Status");
        
        tbTemplate.getColumnModel().getColumn(0).setPreferredWidth(100);
        tbTemplate.getColumnModel().getColumn(1).setPreferredWidth(200);
        tbTemplate.getColumnModel().getColumn(2).setPreferredWidth(100);
        tbTemplate.getColumnModel().getColumn(3).setPreferredWidth(100);
        tbTemplate.getColumnModel().getColumn(4).setPreferredWidth(100);
        tbTemplate.getColumnModel().getColumn(5).setPreferredWidth(100);
        tbTemplate.getColumnModel().getColumn(6).setPreferredWidth(200);
        tbTemplate.getColumnModel().getColumn(7).setPreferredWidth(150);
        tbTemplate.getColumnModel().getColumn(8).setPreferredWidth(150);
        tbTemplate.getColumnModel().getColumn(9).setPreferredWidth(150);
        
        tbTemplate.setDefaultEditor(Object.class, null);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        rbAtivo = new javax.swing.JRadioButton();
        rbInativo = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JTextField();
        pDadosPedido = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtLogradouro = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtComplemento = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtUf = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCep = new javax.swing.JTextField();
        btCep = new javax.swing.JButton();
        lNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cliente");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Status", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        rbAtivo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbAtivo.setSelected(true);
        rbAtivo.setText("Ativo");
        rbAtivo.setEnabled(false);
        rbAtivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAtivoActionPerformed(evt);
            }
        });

        rbInativo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbInativo.setText("Inativo");
        rbInativo.setEnabled(false);
        rbInativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbInativoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbAtivo)
                .addGap(18, 18, 18)
                .addComponent(rbInativo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbAtivo)
                    .addComponent(rbInativo))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Telefone Cliente :");

        txtTelefone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTelefone.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTelefoneCaretUpdate(evt);
            }
        });

        pDadosPedido.setBorder(javax.swing.BorderFactory.createTitledBorder("Endereço"));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Logradouro:");

        txtLogradouro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtLogradouro.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Nº");

        txtNumero.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNumero.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Complemento:");

        txtComplemento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtComplemento.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Bairro:");

        txtBairro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtBairro.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Cidade:");

        txtCidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCidade.setEnabled(false);
        txtCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCidadeActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("UF:");

        txtUf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtUf.setEnabled(false);

        jLabel7.setText("CEP:");

        txtCep.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCep.setEnabled(false);
        txtCep.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtCepCaretUpdate(evt);
            }
        });

        btCep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/list_add.png"))); // NOI18N
        btCep.setToolTipText("Pode se cadastrar novo CEP nao existente no sistema!");
        btCep.setEnabled(false);
        btCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCepActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pDadosPedidoLayout = new javax.swing.GroupLayout(pDadosPedido);
        pDadosPedido.setLayout(pDadosPedidoLayout);
        pDadosPedidoLayout.setHorizontalGroup(
            pDadosPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDadosPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pDadosPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pDadosPedidoLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btCep, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLogradouro))
                    .addGroup(pDadosPedidoLayout.createSequentialGroup()
                        .addGroup(pDadosPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pDadosPedidoLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3))
                            .addGroup(pDadosPedidoLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)
                        .addGroup(pDadosPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pDadosPedidoLayout.createSequentialGroup()
                                .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pDadosPedidoLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtUf, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 77, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pDadosPedidoLayout.setVerticalGroup(
            pDadosPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDadosPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pDadosPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pDadosPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btCep, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pDadosPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pDadosPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pDadosPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pDadosPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pDadosPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lNome.setText("Nome:");

        txtNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNome.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pDadosPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lNome)
                        .addGap(18, 18, 18)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(pDadosPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbAtivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAtivoActionPerformed
        rbAtivo.setSelected(true);
        rbInativo.setSelected(false);
    }//GEN-LAST:event_rbAtivoActionPerformed
    
    private void rbInativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbInativoActionPerformed
        rbAtivo.setSelected(false);
        rbInativo.setSelected(true);
    }//GEN-LAST:event_rbInativoActionPerformed

    private void btCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCepActionPerformed
        CEP cep = new CEP();
        cep.setVisible(true);
    }//GEN-LAST:event_btCepActionPerformed

    private void txtCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCidadeActionPerformed

    private void txtCepCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtCepCaretUpdate
        try {
            String cep = txtCep.getText();
            
            ClienteRN clientern = new ClienteRN();
            ConsultarClienteVO clientevo = clientern.buscaCep(cep);
            
            
            txtCep.setText(clientevo.getCep());
            txtCidade.setText(clientevo.getCidade());
            txtBairro.setText(clientevo.getBairro());
            txtLogradouro.setText(clientevo.getLogradouro());
            String uf= clientevo.getEstado();
            txtUf.setText(uf.substring(uf.length()-2));
            
            txtNumero.setEnabled(true);
            txtComplemento.setEnabled(true);

        } catch (Exception e) {
        }
    }//GEN-LAST:event_txtCepCaretUpdate

    private void txtTelefoneCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTelefoneCaretUpdate
       try {
            Long cliente = Long.parseLong(txtTelefone.getText());
            
            ClienteRN clientern = new ClienteRN();
            ClienteVO clientevo = clientern.buscaCliente(cliente);
            
            txtTelefone.setText(String.valueOf(clientevo.getTelefone()));
            txtNome.setText(clientevo.getNome());
            txtCep.setText(clientevo.getCep());
            txtCidade.setText(clientevo.getCidade());
            txtBairro.setText(clientevo.getBairro());
            txtLogradouro.setText(clientevo.getLogradouro());
            txtNumero.setText(String.valueOf(clientevo.getNumerocasa()));
            txtComplemento.setText(clientevo.getComplemento());
            String uf= clientevo.getEstado();
            txtUf.setText(uf.substring(uf.length()-2));

            btEditar.setEnabled(true);
            
        } catch (Exception e) {
        }
    }//GEN-LAST:event_txtTelefoneCaretUpdate

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
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCep;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lNome;
    private javax.swing.JPanel pDadosPedido;
    private javax.swing.JRadioButton rbAtivo;
    private javax.swing.JRadioButton rbInativo;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCep;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtComplemento;
    private javax.swing.JTextField txtLogradouro;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtTelefone;
    private javax.swing.JTextField txtUf;
    // End of variables declaration//GEN-END:variables

    @Override
    public void btCadastrarActionPerformed(ActionEvent e) {
        txtNome.setEnabled(true);
        txtCep.setEnabled(true);
        rbAtivo.setEnabled(true);
        rbInativo.setEnabled(true);
        btCep.setEnabled(true);
    }

    @Override
    public void btEditarActionPerformed(ActionEvent e) {
        txtNome.setEnabled(true);
        txtCep.setEnabled(true);
        rbAtivo.setEnabled(true);
        rbInativo.setEnabled(true);
        btCep.setEnabled(true);
        txtNumero.setEnabled(true);
        txtComplemento.setEnabled(true);
        
        int selecionada = tbTemplate.getSelectedRow();
        
        txtTelefone.setText((tbTemplate.getValueAt(selecionada, 0).toString()));
        txtNome.setText((tbTemplate.getValueAt(selecionada, 1).toString()));
        txtCep.setText((tbTemplate.getValueAt(selecionada, 2).toString()));
        txtCidade.setText((tbTemplate.getValueAt(selecionada, 3).toString()));
        txtBairro.setText((tbTemplate.getValueAt(selecionada, 4).toString()));
        String uf = tbTemplate.getValueAt(selecionada, 5).toString();
        txtUf.setText(uf.substring(uf.length() - 2));
        txtLogradouro.setText((tbTemplate.getValueAt(selecionada, 6).toString()));
        txtNumero.setText((tbTemplate.getValueAt(selecionada, 7).toString()));
        txtComplemento.setText((tbTemplate.getValueAt(selecionada, 8).toString()));
        
        if ("t".equals(tbTemplate.getValueAt(selecionada, 9).toString())){
             rbAtivo.setSelected(true);
             rbInativo.setSelected(false);
            }
            else{
             rbInativo.setSelected(true);
             rbAtivo.setSelected(false);
            }   
    }

    @Override
    public void btExcluirActionPerformed(ActionEvent e) {
        txtNome.setEnabled(false);
        txtCep.setEnabled(false);
        rbAtivo.setEnabled(false);
        rbInativo.setEnabled(false);
        btCep.setEnabled(false);
        int n = JOptionPane.showConfirmDialog(null,"Deseja excluir o cliente? ","Cliente",JOptionPane.YES_NO_OPTION);
        if(n==0){
         try{
            ClienteVO clienteVO = new ClienteVO();
     
            int selecionada = tbTemplate.getSelectedRow();
            clienteVO.setTelefone((Long) tbTemplate.getValueAt(selecionada, 0));
            
            ClienteRN clienteRN = new ClienteRN();
            clienteRN.excluirCliente(clienteVO);
            
            
            
            atualizarLista();
            JOptionPane.showMessageDialog(null,"Cliente excluido com sucesso! ","Cliente",JOptionPane.INFORMATION_MESSAGE);
            //buscaBorda.popularTabela();
            
        } catch (SQLException w) {

            JOptionPane.showMessageDialog(null, "Erro: " + w.getMessage(), "Exclusão de Cliente", JOptionPane.ERROR_MESSAGE);
        
        } catch (Exception w) {

            JOptionPane.showMessageDialog(null, "Erro: " + w.getMessage(), "Exclusão de Borda", JOptionPane.ERROR_MESSAGE);
        }
        txtTelefone.setText("");
        txtNome.setText("");
        txtCep.setText("");
        txtCidade.setText("");
        txtBairro.setText("");
        txtUf.setText("");
        txtLogradouro.setText("");
        txtNumero.setText("");
        txtComplemento.setText("");
         
        }
    }

    @Override
    public void btCancelarActionPerformed(ActionEvent e) {
        int n = JOptionPane.showConfirmDialog(null,"Deseja cancelar? ","Cliente",JOptionPane.YES_NO_OPTION);
        if(n==0){
            this.dispose();
        }
    }

    @Override
    public void btSalvarActionPerformed(ActionEvent e) {
        txtNome.setEnabled(false);
        txtCep.setEnabled(false);
        rbAtivo.setEnabled(false);
        rbInativo.setEnabled(false);
        btCep.setEnabled(false);
        if (save == 1) {
            try{
                ClienteVO clienteVO = new ClienteVO();

                clienteVO.setTelefone(Long.parseLong(txtTelefone.getText()));
                clienteVO.setCep(txtCep.getText());
                clienteVO.setNome(txtNome.getText());
                clienteVO.setCasa(Integer.parseInt(txtNumero.getText()));
                clienteVO.setComplemento(txtComplemento.getText());
                if(rbAtivo.isSelected())
                    clienteVO.setStatus("true");
                else
                    clienteVO.setStatus("false");

                ClienteRN clienteRN = new ClienteRN();
                clienteRN.cadastrarCliente(clienteVO);

                atualizarLista();

                //buscaBorda.popularTabela();

                JOptionPane.showMessageDialog(null,"Cliente adicionado com sucesso! ","Cliente",JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException w) {

                JOptionPane.showMessageDialog(null, "Erro: " + w.getMessage(), "Cadastro Bebida SQL", JOptionPane.ERROR_MESSAGE);

            } catch (Exception w) {

                JOptionPane.showMessageDialog(null, "Erro: " + w.getMessage(), "Cadastro Bebida EX", JOptionPane.ERROR_MESSAGE);
            } 
        }else if (save == 2) {
            try{
                ClienteVO clienteVO = new ClienteVO();

                clienteVO.setTelefone(Long.parseLong(txtTelefone.getText()));
                clienteVO.setCep(txtCep.getText());
                clienteVO.setNome(txtNome.getText());
                clienteVO.setCasa(Integer.parseInt(txtNumero.getText()));
                clienteVO.setComplemento(txtComplemento.getText());
                if(rbAtivo.isSelected())
                    clienteVO.setStatus("true");
                else
                    clienteVO.setStatus("false");

                ClienteRN clienteRN = new ClienteRN();
                clienteRN.editarCliente(clienteVO);

                atualizarLista();

                //buscaBorda.popularTabela();

                JOptionPane.showMessageDialog(null,"Cliente editado com sucesso! ","Cliente",JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException w) {

                JOptionPane.showMessageDialog(null, "Erro: " + w.getMessage(), "Editar Cliente SQL", JOptionPane.ERROR_MESSAGE);

            } catch (Exception w) {

                JOptionPane.showMessageDialog(null, "Erro: " + w.getMessage(), "Editar Cliente EX", JOptionPane.ERROR_MESSAGE);
            }
        }
        txtTelefone.setText("");
        txtNome.setText("");
        txtCep.setText("");
        txtCidade.setText("");
        txtBairro.setText("");
        txtUf.setText("");
        txtLogradouro.setText("");
        txtNumero.setText("");
        txtComplemento.setText("");
    }
    
    public final void atualizarLista(){
        try{
            ClienteRN clientern = new ClienteRN();
            ArrayList<ClienteVO> clientes = clientern.listarClientes();
            
            DefaultTableModel modelo = (DefaultTableModel)tbTemplate.getModel();
            modelo.setRowCount(0);
            
            for (ClienteVO Cliente : clientes) {
                
                modelo.addRow(new Object[]{Cliente.getTelefone(),Cliente.getNome(),Cliente.getCep(),Cliente.getCidade(),Cliente.getBairro(),Cliente.getEstado(),Cliente.getLogradouro(),Cliente.getNumerocasa(),Cliente.getComplemento(), Cliente.getStatus()});
            }
            tbTemplate.setModel(modelo);
            ajustarTabelaCliente();
            
            
    
        }catch (SQLException | ClassNotFoundException ex) {
           
        } catch (Exception ex) {
            Logger.getLogger(ClienteRN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
