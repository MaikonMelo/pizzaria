/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import regraNegocio.ConsultarClienteRN;
import vo.ConsultarClienteVO;

/**
 *
 * @author Raphael
 */
public class ConsultaCliente extends javax.swing.JFrame {
    Pedido telaPassada=null;
    RelatorioCliente telaPassada2=null;
    RelatorioPeriodo telaPassada3=null;
    /**
     * Creates new form ConsultaCliente
     */
    public ConsultaCliente() {
        initComponents();
        listarCliente();     
        this.setLocationRelativeTo(null);
        setResizable(false);
    }
    public ConsultaCliente(Pedido tela) {
        initComponents();
        listarCliente();
        telaPassada = tela;
        this.setLocationRelativeTo(null); 
        setResizable(false);
    }
       
    public ConsultaCliente(RelatorioCliente tela) {
        initComponents();
        listarCliente();
        telaPassada2 = tela;
        this.setLocationRelativeTo(null); 
        setResizable(false);
    }
    public ConsultaCliente(RelatorioPeriodo tela) {
        initComponents();
        listarCliente();
        telaPassada3 = tela;
        this.setLocationRelativeTo(null); 
        setResizable(false);
    }
    
    public void listarCliente(){
        try {
            ConsultarClienteRN clientern = new ConsultarClienteRN();
            ArrayList<ConsultarClienteVO> clientes = clientern.listarClientes();
            
            DefaultTableModel modelo = (DefaultTableModel)tbCliente.getModel();
            modelo.setRowCount(0);
            for (ConsultarClienteVO ConsultarCliente : clientes) {
                
                modelo.addRow(new Object[]{ConsultarCliente.getTelefone(),ConsultarCliente.getNome(),ConsultarCliente.getCep(),ConsultarCliente.getCidade(),ConsultarCliente.getBairro(),ConsultarCliente.getEstado(),ConsultarCliente.getLogradouro(),ConsultarCliente.getNumerocasa(),ConsultarCliente.getComplemento()});
            }
            tbCliente.setModel(modelo);
            ajustarTabelaCliente();
            
            
           
        } catch (SQLException | ClassNotFoundException ex) {
           
        } catch (Exception ex) {
            Logger.getLogger(ConsultaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void ajustarTabelaCliente(){
        
        tbCliente.getColumnModel().getColumn(0).setHeaderValue("Telefone");
        tbCliente.getColumnModel().getColumn(1).setHeaderValue("Nome");
        tbCliente.getColumnModel().getColumn(2).setHeaderValue("CEP");
        tbCliente.getColumnModel().getColumn(3).setHeaderValue("Cidade");
        tbCliente.getColumnModel().getColumn(4).setHeaderValue("Bairro");
        tbCliente.getColumnModel().getColumn(5).setHeaderValue("Estado");
        tbCliente.getColumnModel().getColumn(6).setHeaderValue("Logradouro");
        tbCliente.getColumnModel().getColumn(7).setHeaderValue("Numero");
        tbCliente.getColumnModel().getColumn(8).setHeaderValue("Complemento");
        
        tbCliente.getColumnModel().getColumn(0).setPreferredWidth(100);
        tbCliente.getColumnModel().getColumn(1).setPreferredWidth(200);
        tbCliente.getColumnModel().getColumn(2).setPreferredWidth(100);
        tbCliente.getColumnModel().getColumn(3).setPreferredWidth(100);
        tbCliente.getColumnModel().getColumn(4).setPreferredWidth(100);
        tbCliente.getColumnModel().getColumn(5).setPreferredWidth(100);
        tbCliente.getColumnModel().getColumn(6).setPreferredWidth(200);
        tbCliente.getColumnModel().getColumn(7).setPreferredWidth(50);
        tbCliente.getColumnModel().getColumn(8).setPreferredWidth(150);
    }
    
    public void puxarCliente(Long cod){
        try {
            ConsultarClienteRN clientern = new ConsultarClienteRN();
            ConsultarClienteVO cliente = clientern.buscarCliente(cod);
            if(telaPassada!=null){
                Pedido pedido = new Pedido(cliente);
                pedido.setVisible(true);
                telaPassada.dispose();
            }else if(telaPassada2!=null){
                RelatorioCliente rel = new RelatorioCliente(cliente);
                rel.setVisible(true);
                telaPassada2.dispose();
            }else if(telaPassada3!=null){
                RelatorioPeriodo rel = new RelatorioPeriodo(cliente);
                rel.setVisible(true);
                telaPassada3.dispose();
            }

            this.dispose();
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Erro selecionar cliente! ","Cliente",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCliente = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de Clientes");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Cliente : ");

        txtCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tbCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Cliente", "Telefone", "Título 3", "Título 4", "Título 5", "Título 6", "Título 7", "Título 8", "Título 9"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbCliente.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbCliente.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbCliente);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbClienteMouseClicked
        int zerando = evt.getClickCount();
        
        if(zerando >= 2){
            int selecionada = tbCliente.getSelectedRow();
            puxarCliente(Long.parseLong(tbCliente.getValueAt(selecionada, 0).toString()));
          
        }
        zerando = 0;
    }//GEN-LAST:event_tbClienteMouseClicked

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
            java.util.logging.Logger.getLogger(ConsultaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbCliente;
    private javax.swing.JTextField txtCliente;
    // End of variables declaration//GEN-END:variables
}
