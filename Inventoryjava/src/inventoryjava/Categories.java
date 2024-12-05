/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package inventoryjava;


import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kuldeepsharma
 */
public class Categories extends javax.swing.JFrame {

    /**
     * Creates new form Categories
     */
    public Categories() {
        initComponents();
        getcattable();
        editbtn.setEnabled(false);
        deletebtn.setVisible(false);
    }
    int myIndex;
    
    public boolean insercat(int catid,String catname){
        try { String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventorymanagement", "root", "root");
            String query1 = "insert into productcategory(catid,catname) values (?, ?);";
            PreparedStatement pst = con.prepareStatement(query1);
            pst.setInt(1, catid);
            pst.setString(2, catname);
            pst.executeUpdate();
            return true;
    }catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error : " + e.getMessage());

            return false;
        }
    }
    
    
    public void getcattable() {
       try{ String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventorymanagement", "root", "root");
           
            String query2="select * from productcategory;";
            PreparedStatement pst2=con.prepareStatement(query2);
            ResultSet rs = pst2.executeQuery(query2);
            DefaultTableModel model = (DefaultTableModel) cattable.getModel();
            model.setRowCount(0); // Clear existing data
            while (rs.next()) {
                
                String catid = rs.getString("catid");
                String catname = rs.getString("catname");
                 Object[] row = {catid, catname};
                 model.addRow(row); 
    }}catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error : " + e.getMessage());

            
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cattable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        CATID = new javax.swing.JTextField();
        CATNAME = new javax.swing.JTextField();
        addbtn = new javax.swing.JButton();
        resetbtn = new javax.swing.JButton();
        editbtn = new javax.swing.JButton();
        homebtn = new javax.swing.JButton();
        deletebtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(740, 500));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("  MANAGE CATEGORIES");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(167, 167, 167)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 762, 50);

        jPanel2.setBackground(new java.awt.Color(102, 51, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 452, 756, 0);

        jPanel3.setLayout(null);

        cattable.setBackground(new java.awt.Color(204, 255, 255));
        cattable.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        cattable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "CAT.ID", "CAT.NAME"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        cattable.setPreferredSize(new java.awt.Dimension(250, 300));
        cattable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cattableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(cattable);

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(323, 25, 433, 327);

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        jLabel2.setText("CATEGORY LIST");
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel2.setOpaque(true);
        jPanel3.add(jLabel2);
        jLabel2.setBounds(489, 0, 111, 19);

        jLabel3.setFont(jLabel3.getFont().deriveFont(jLabel3.getFont().getStyle() | java.awt.Font.BOLD, 14));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CATEGORY ID");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(37, 27, 110, 20);

        jLabel4.setFont(jLabel4.getFont().deriveFont(jLabel4.getFont().getStyle() | java.awt.Font.BOLD));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("CATEGORY NAME");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(50, 74, 116, 23);

        CATID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CATIDActionPerformed(evt);
            }
        });
        jPanel3.add(CATID);
        CATID.setBounds(172, 25, 145, 23);
        jPanel3.add(CATNAME);
        CATNAME.setBounds(172, 74, 145, 23);

        addbtn.setBackground(new java.awt.Color(255, 153, 153));
        addbtn.setFont(addbtn.getFont().deriveFont(addbtn.getFont().getStyle() | java.awt.Font.BOLD));
        addbtn.setText("ADD");
        addbtn.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        addbtn.setBorderPainted(false);
        addbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addbtnMouseClicked(evt);
            }
        });
        addbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbtnActionPerformed(evt);
            }
        });
        jPanel3.add(addbtn);
        addbtn.setBounds(62, 178, 65, 31);

        resetbtn.setBackground(new java.awt.Color(102, 255, 102));
        resetbtn.setFont(resetbtn.getFont().deriveFont(resetbtn.getFont().getStyle() | java.awt.Font.BOLD));
        resetbtn.setText("RESET");
        resetbtn.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        resetbtn.setBorderPainted(false);
        resetbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetbtnActionPerformed(evt);
            }
        });
        jPanel3.add(resetbtn);
        resetbtn.setBounds(196, 177, 68, 32);

        editbtn.setBackground(new java.awt.Color(51, 255, 255));
        editbtn.setFont(editbtn.getFont().deriveFont(editbtn.getFont().getStyle() | java.awt.Font.BOLD));
        editbtn.setText("EDIT");
        editbtn.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        editbtn.setBorderPainted(false);
        editbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editbtnActionPerformed(evt);
            }
        });
        jPanel3.add(editbtn);
        editbtn.setBounds(128, 140, 67, 31);

        homebtn.setBackground(new java.awt.Color(0, 255, 204));
        homebtn.setFont(homebtn.getFont().deriveFont(homebtn.getFont().getStyle() | java.awt.Font.BOLD));
        homebtn.setText("HOME");
        homebtn.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        homebtn.setBorderPainted(false);
        homebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homebtnActionPerformed(evt);
            }
        });
        jPanel3.add(homebtn);
        homebtn.setBounds(128, 215, 67, 29);

        deletebtn.setBackground(new java.awt.Color(255, 51, 51));
        deletebtn.setFont(deletebtn.getFont().deriveFont(deletebtn.getFont().getStyle() | java.awt.Font.BOLD));
        deletebtn.setForeground(new java.awt.Color(255, 255, 255));
        deletebtn.setText("Delete");
        deletebtn.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        deletebtn.setBorderPainted(false);
        deletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebtnActionPerformed(evt);
            }
        });
        jPanel3.add(deletebtn);
        deletebtn.setBounds(329, 358, 68, 32);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/newpackage/headphones.jpg"))); // NOI18N
        jPanel3.add(jLabel5);
        jLabel5.setBounds(-10, -133, 800, 630);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 56, 762, 390);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
        addbtn.setEnabled(true);
        editbtn.setEnabled(false);
        cattable.clearSelection();
        deletebtn.setVisible(false);
    }//GEN-LAST:event_formMouseClicked

    private void deletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = cattable.getSelectedRow(); // Get the selected row

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(rootPane, "Please select a row to delete.");
            return; // Exit if no row is selected
        }

        try {
            // Retrieve the ID from the selected row
            int id = Integer.parseInt(cattable.getValueAt(selectedRow, 0).toString());

            // Confirm deletion
            int confirm = JOptionPane.showConfirmDialog(
                rootPane,
                "Are you sure you want to delete this record?",
                "Delete Confirmation",
                JOptionPane.YES_NO_OPTION
            );

            if (confirm == JOptionPane.YES_OPTION) {
                // Establish database connection
                String driver = "com.mysql.cj.jdbc.Driver";
                Class.forName(driver);
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventorymanagement", "root", "root");

                // Delete query
                String query = "DELETE FROM productcategory WHERE catid = ?";
                PreparedStatement pst = con.prepareStatement(query);
                pst.setInt(1, id); // Set the ID for deletion

                // Execute deletion
                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(rootPane, "Record deleted successfully!");
                    getcattable(); // Refresh the table
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Error: Record not found.");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_deletebtnActionPerformed

    private void homebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homebtnActionPerformed
        // TODO add your handling code here:
        HomePage ur=new HomePage();
        ur.setVisible(true);
        //       this.dispose();
        this.setVisible(false);

    }//GEN-LAST:event_homebtnActionPerformed

    private void editbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editbtnActionPerformed
        // TODO add your handling code here:
        int catid = Integer.parseInt(CATID.getText());
        String catname=CATNAME.getText();
        if(CATID.getText().isEmpty() || catname.isEmpty()){
            JOptionPane.showMessageDialog(rootPane, " Please fill both the fields");
        }else{
            try{
                String driver = "com.mysql.cj.jdbc.Driver";
                Class.forName(driver);
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventorymanagement", "root", "root");
                String query = "update productcategory set catid=?,catname=? where catid=?;";
                PreparedStatement pst = con.prepareStatement(query);
                pst.setInt(1, catid);
                pst.setString(2, catname);
                pst.setInt(3,myIndex);
                int rowsAffected=pst.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(rootPane, "User updated successfully!");
                    getcattable();

                }else {
                    JOptionPane.showMessageDialog(rootPane, "Update failed. User not found.");

                }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(rootPane, "Error : " + e.getMessage());

            }}

    }//GEN-LAST:event_editbtnActionPerformed

    private void resetbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetbtnActionPerformed
        // TODO add your handling code here:
        CATID.setText("");
        CATNAME.setText("");
    }//GEN-LAST:event_resetbtnActionPerformed

    private void addbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbtnActionPerformed
        // TODO add your handling code here:
        //        int catid;  //= Integer.valueOf(CATID.getText());
        if (CATID.getText().matches("\\d+")) { // Check if input is numeric
            int catid = Integer.parseInt(CATID.getText());

            String catname=CATNAME.getText();
            if(CATID.getText().isEmpty() || catname.isEmpty()){
                JOptionPane.showMessageDialog(rootPane, " Please fill both the fields");
            }else
            {
                if(insercat(catid,catname)){
                    getcattable();
                    JOptionPane.showMessageDialog(rootPane, "New Product Category Added!");
                }
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Please enter a valid numeric ID.");
        }

    }//GEN-LAST:event_addbtnActionPerformed

    private void addbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addbtnMouseClicked

    }//GEN-LAST:event_addbtnMouseClicked

    private void CATIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CATIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CATIDActionPerformed

    private void cattableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cattableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) cattable.getModel();
        myIndex = cattable.getSelectedRow();
        int id = Integer.parseInt(cattable.getValueAt(myIndex, 0).toString());
        CATID.setText(model.getValueAt(myIndex, 0).toString());
        CATNAME.setText(model.getValueAt(myIndex, 1).toString());
        myIndex=id;
        addbtn.setEnabled(false);
        editbtn.setEnabled(true);
        deletebtn.setVisible(true);
    }//GEN-LAST:event_cattableMouseClicked

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
            java.util.logging.Logger.getLogger(Categories.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Categories.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Categories.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Categories.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Categories().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CATID;
    private javax.swing.JTextField CATNAME;
    private javax.swing.JButton addbtn;
    private javax.swing.JTable cattable;
    private javax.swing.JButton deletebtn;
    private javax.swing.JButton editbtn;
    private javax.swing.JButton homebtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton resetbtn;
    // End of variables declaration//GEN-END:variables
}
