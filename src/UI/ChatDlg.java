/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.Color;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sistema30
 */
public class ChatDlg extends javax.swing.JDialog {
    private int id=-1;
    private boolean isServer;
    private ServerSocket ss;
    private Socket s;
    private DataInputStream dis;
    private DataOutputStream dos;
    /**
     * Creates new form ChatDlg
     */
    public ChatDlg(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIsServer(boolean isServer) {
        this.isServer = isServer;
    }

    private class ChatServer extends Thread{
        @Override
        public void run(){
            try {
                ss=new ServerSocket(1206);
                s=ss.accept();
                dis=new DataInputStream(s.getInputStream());
                dos=new DataOutputStream(s.getOutputStream());
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            String msgin="";
            while(!msgin.equals("exit")){
                try {
                    msgin=dis.readUTF();
                    appendMessage(msgin);
                } catch (IOException ex) {
                    Logger.getLogger(ChatDlg.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }   
    }
    
    private class ClientChat extends Thread{
        @Override
        public void run(){
            try {
                ss=null;
                s=new Socket(iptxt.getText(), Integer.parseInt(porttxt.getText()));
                dis=new DataInputStream(s.getInputStream());
                dos=new DataOutputStream(s.getOutputStream());
            } catch (IOException ex) {
                Logger.getLogger(ChatDlg.class.getName()).log(Level.SEVERE, null, ex);
            }
            String msgin="";
            while(!msgin.equals("exit")){
                try {
                    msgin=dis.readUTF();
                    appendMessage(msgin);
                } catch (IOException ex) {
                    Logger.getLogger(ChatDlg.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
        }
    }
    
    
    private void appendMessage(String newmsg){
        msgarea.setText(msgarea.getText()+"\n"+newmsg);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        msgtxt = new javax.swing.JTextField();
        sendbtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        connectedlbl = new javax.swing.JLabel();
        porttxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        msgarea = new javax.swing.JTextArea();
        submitbtn = new javax.swing.JButton();
        iptxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        msgtxt.setPreferredSize(new java.awt.Dimension(200, 20));
        jPanel1.add(msgtxt);

        sendbtn.setText("Enviar");
        sendbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendbtnActionPerformed(evt);
            }
        });
        jPanel1.add(sendbtn);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("IP");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 15);
        jPanel2.add(jLabel1, gridBagConstraints);

        jLabel2.setText("Puerto");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 15);
        jPanel2.add(jLabel2, gridBagConstraints);

        connectedlbl.setText("jLabel3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        jPanel2.add(connectedlbl, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 140;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 15);
        jPanel2.add(porttxt, gridBagConstraints);

        msgarea.setColumns(20);
        msgarea.setRows(5);
        jScrollPane1.setViewportView(msgarea);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 65;
        jPanel2.add(jScrollPane1, gridBagConstraints);

        submitbtn.setText("Conectar");
        submitbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitbtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        jPanel2.add(submitbtn, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 140;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 15);
        jPanel2.add(iptxt, gridBagConstraints);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(416, 339));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        connectedlbl.setText("DESCONECTADO");
        connectedlbl.setForeground(Color.red);
        this.setTitle("Chat #"+id);
        msgarea.setText("-");
        msgarea.setEditable(false);
        if(isServer){
            setServer();
        }
    }//GEN-LAST:event_formWindowOpened

    private void setServer(){
        iptxt.setEnabled(false);
        porttxt.setEnabled(false);
        ChatServer chat=new ChatServer();
        chat.start();
        porttxt.setText(String.valueOf(s.getPort()));
        if(s.isConnected()){
            connectedlbl.setText("CONECTADO");
            connectedlbl.setForeground(Color.green);
        }
    }
    private void setClient(){
        ClientChat chat=new ClientChat();
        chat.start();
        if(s.isConnected()){
            connectedlbl.setText("CONECTADO");
            connectedlbl.setForeground(Color.green);
        }
    }
    private void sendbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendbtnActionPerformed
        String msgout="";
        msgout=msgtxt.getText();
        try {
            dos.writeUTF(msgout);
        } catch (IOException ex) {
            Logger.getLogger(ChatDlg.class.getName()).log(Level.SEVERE, null, ex);
        }
        appendMessage(msgout);
    }//GEN-LAST:event_sendbtnActionPerformed

    private void submitbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitbtnActionPerformed
        setClient();
    }//GEN-LAST:event_submitbtnActionPerformed

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
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChatDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChatDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChatDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChatDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ChatDlg dialog = new ChatDlg(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel connectedlbl;
    private javax.swing.JTextField iptxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea msgarea;
    private javax.swing.JTextField msgtxt;
    private javax.swing.JTextField porttxt;
    private javax.swing.JButton sendbtn;
    private javax.swing.JButton submitbtn;
    // End of variables declaration//GEN-END:variables
}
