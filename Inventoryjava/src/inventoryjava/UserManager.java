/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package inventoryjava;

//import java.awt.Color;
import java.awt.Color;
import javax.swing.JFrame;
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
public class UserManager extends javax.swing.JFrame {

    /**
     * Creates new form UserManager
     */
    public UserManager() {
        initComponents();
        getUserIntoTable();
        usertable.setBackground(Color.GREEN);
        updatebtn.setEnabled(false);

        updatebtn.setToolTipText("Select a row to enable this button");

    }
    Integer myIndex;

    public Boolean insertUser(String userName, String userContact, String email, String address, String pass, String status) {

        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventorymanagement", "root", "root");
            String query = "insert into user(name, mob, email, address, pass, status) values (?, ?, ?, ?, ?, ?);";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, userName);
            pst.setString(2, userContact);
            pst.setString(3, email);
            pst.setString(4, address);
            pst.setString(5, pass);
            pst.setString(6, status);

            int val = pst.executeUpdate();

            System.out.println(val + " row affected.");
            return true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error : " + e.getMessage());

            return false;
        }
    }

    public void getUserIntoTable() {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventorymanagement", "root", "root");
            String query = "select * from user;";
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) usertable.getModel();
            model.setRowCount(0); // Clear existing data
            while (rs.next()) {

                String userName = rs.getString("name");
                String address = rs.getString("address");
                String email = rs.getString("email");
                String status = rs.getString("status");
                int ID = rs.getInt("id");
//add into table fields
                Object[] row = {userName, address, email, status, ID};
                model.addRow(row);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error : " + e.getMessage());
        }
        
    }

    public void updateuser(String userName, String email, String address, String status) {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventorymanagement", "root", "root");
            String query = "update user set name=?, email=?,address=?,status=? where id=? ;";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, userName);
            pst.setString(2, email);
            pst.setString(3, address);
            pst.setString(4, status);
            pst.setInt(5, myIndex);
            int rowsAffected = pst.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(rootPane, "User updated successfully!");
                getUserIntoTable(); // Refresh table
            } else {
                JOptionPane.showMessageDialog(rootPane, "Update failed. User not found.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error : " + e.getMessage());

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        usercontact = new javax.swing.JTextField();
        usermail = new javax.swing.JTextField();
        useradd = new javax.swing.JTextField();
        userpassword = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        usertable = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        statuscb = new javax.swing.JComboBox<>();
        savebtn = new javax.swing.JButton();
        updatebtn = new javax.swing.JButton();
        resetbtn = new javax.swing.JButton();
        closebtn = new javax.swing.JButton();
        tt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 255, 51));
        setUndecorated(true);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(jLabel2.getFont().deriveFont(jLabel2.getFont().getStyle() | java.awt.Font.BOLD, 14));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("NAME");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 77, 53, -1));

        jLabel3.setFont(jLabel3.getFont().deriveFont(jLabel3.getFont().getStyle() | java.awt.Font.BOLD));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText(" MOBILE NUMBER");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, -1, 28));

        jLabel4.setFont(jLabel4.getFont().deriveFont(jLabel4.getFont().getStyle() | java.awt.Font.BOLD));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("EMAIL");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 170, 54, -1));

        jLabel5.setFont(jLabel5.getFont().deriveFont(jLabel5.getFont().getStyle() | java.awt.Font.BOLD));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ADDRESS");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 208, -1, -1));

        jLabel6.setFont(jLabel6.getFont().deriveFont(jLabel6.getFont().getStyle() | java.awt.Font.BOLD));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("PASSWORD");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 271, -1, -1));

        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        getContentPane().add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 75, 151, -1));
        getContentPane().add(usercontact, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 110, 151, -1));
        getContentPane().add(usermail, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 167, 151, -1));

        useradd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useraddActionPerformed(evt);
            }
        });
        getContentPane().add(useradd, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 208, 151, -1));
        getContentPane().add(userpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 268, 151, -1));

        usertable.setBackground(new java.awt.Color(203, 255, 255));
        usertable.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        usertable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "NAME", "ADDRESS", "EMAIL", "STATUS", "ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        usertable.setOpaque(false);
        usertable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usertableMouseClicked(evt);
            }
        });
        usertable.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                usertablePropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(usertable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 75, 488, 286));

        jLabel7.setFont(jLabel7.getFont().deriveFont(jLabel7.getFont().getStyle() | java.awt.Font.BOLD));
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("STATUS");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 312, -1, -1));

        statuscb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "active", "inactive" }));
        statuscb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statuscbActionPerformed(evt);
            }
        });
        getContentPane().add(statuscb, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 309, 151, -1));

        savebtn.setBackground(new java.awt.Color(0, 255, 255));
        savebtn.setFont(savebtn.getFont().deriveFont(savebtn.getFont().getStyle() | java.awt.Font.BOLD));
        savebtn.setText("SAVE ");
        savebtn.setToolTipText("Save Details\n");
        savebtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                savebtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                savebtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                savebtnMouseExited(evt);
            }
        });
        savebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savebtnActionPerformed(evt);
            }
        });
        getContentPane().add(savebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 430, -1, 31));

        updatebtn.setBackground(new java.awt.Color(102, 255, 0));
        updatebtn.setFont(updatebtn.getFont().deriveFont(updatebtn.getFont().getStyle() | java.awt.Font.BOLD));
        updatebtn.setText("UPDATE");
        updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebtnActionPerformed(evt);
            }
        });
        getContentPane().add(updatebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 430, -1, 31));

        resetbtn.setBackground(new java.awt.Color(0, 255, 204));
        resetbtn.setFont(resetbtn.getFont().deriveFont(resetbtn.getFont().getStyle() | java.awt.Font.BOLD));
        resetbtn.setText("RESET");
        resetbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetbtnActionPerformed(evt);
            }
        });
        getContentPane().add(resetbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 430, 83, 31));

        closebtn.setBackground(new java.awt.Color(255, 0, 51));
        closebtn.setFont(closebtn.getFont().deriveFont(closebtn.getFont().getStyle() | java.awt.Font.BOLD));
        closebtn.setText("CLOSE");
        closebtn.setToolTipText("Close the tab\n");
        closebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closebtnActionPerformed(evt);
            }
        });
        getContentPane().add(closebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 370, -1, 31));

        tt.setText("hello");
        tt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ttActionPerformed(evt);
            }
        });
        getContentPane().add(tt, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 370, 143, 31));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("  USER MANAGER");
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 280, -1));

        jButton1.setBackground(new java.awt.Color(0, 204, 204));
        jButton1.setText("Poduct Manager");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 430, 140, 30));

        jButton2.setBackground(new java.awt.Color(0, 204, 204));
        jButton2.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jButton2.setText("Home");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, 110, 30));

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/newpackage/perfumes.png"))); // NOI18N
        jLabel9.setOpaque(true);
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(-80, -3, 860, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void savebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savebtnActionPerformed

        String userName = username.getText();
        String userContact = usercontact.getText();
        String email = usermail.getText();
        String address = useradd.getText();
        String pass = userpassword.getText();
        String status = (String) statuscb.getSelectedItem();
        if (userName.isEmpty() || email.isEmpty() || pass.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Some fields are empty please check and fill");
        } else {
            if (insertUser(userName, userContact, email, address, pass, status)) {
//        add data to table
                getUserIntoTable();
                JOptionPane.showMessageDialog(rootPane, "User Added!");

            }
        }
    }//GEN-LAST:event_savebtnActionPerformed

    private void resetbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetbtnActionPerformed
        // TODO add your handling code here:
        username.setText("");
        usercontact.setText("");
        usermail.setText("");
        useradd.setText("");
        userpassword.setText("");
        tt.setText("hello");
        statuscb.setSelectedItem("active");
        userpassword.setEditable(true);
        usercontact.setEditable(true);
        userpassword.setBackground(Color.WHITE);
        usercontact.setBackground(Color.WHITE);
        usertable.clearSelection();
    }//GEN-LAST:event_resetbtnActionPerformed

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void useraddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useraddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_useraddActionPerformed

    private void savebtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_savebtnMouseClicked

    }//GEN-LAST:event_savebtnMouseClicked

    private void savebtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_savebtnMouseExited
        // TODO add your handling code here:
        savebtn.setBackground(new Color(153, 153, 255));

    }//GEN-LAST:event_savebtnMouseExited

    private void usertablePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_usertablePropertyChange
        // TODO add your handling code here:

    }//GEN-LAST:event_usertablePropertyChange

    private void closebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closebtnActionPerformed
        JFrame fr = new JFrame("CLOSE");
        if (JOptionPane.showConfirmDialog(fr, "Confirm If you want to close", "CLOSE REALLY?", JOptionPane.YES_OPTION) == JOptionPane.YES_NO_OPTION) {
            System.exit(0);

        }
    }//GEN-LAST:event_closebtnActionPerformed

    private void updatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebtnActionPerformed
        // TODO add your handling code here:
        String userName = username.getText();
        String email = usermail.getText();
        String address = useradd.getText();
        String status = (String) statuscb.getSelectedItem();
//        String mob= 
        if (userName.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Error : Empty fields");
        } else {
            updateuser(userName, email, address, status);
//        add data to table
            getUserIntoTable();
//                JOptionPane.showMessageDialog(rootPane, "User Added!");
        }
//        tt.setText(username.getText());
        tt.setText("Id no. " + myIndex + " Updated!");
//try{  String driver = "com.mysql.cj.jdbc.Driver";
//Class.forName(driver);
//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventorymanagement", "root", "root");
//
//// Query to fetch the mobile number where id = myIndex
//String query = "SELECT mob FROM user WHERE id = ?;";
//PreparedStatement pst = con.prepareStatement(query);
//
//// Set the value for the placeholder `?` in the query
//pst.setInt(1, myIndex); // Assuming `myIndex` is an integer variable containing the user ID
//
//// Execute the query
//ResultSet rs = pst.executeQuery();
//
//// Fetch the result
//if (rs.next()) {
//    String mobileNumber = rs.getString("mob"); // Get the mobile number from the result set
//    tt.setText(mobileNumber);
//} else {
//    System.out.println("No user found with ID: " + myIndex);
//}
//     
//     
//// Close resources
//rs.close();
//pst.close();
//con.close();}
//catch (Exception e) {
//            JOptionPane.showMessageDialog(rootPane, "Error : " + e.getMessage());
//
//         
//        }
    }//GEN-LAST:event_updatebtnActionPerformed

    private void ttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ttActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ttActionPerformed

    private void usertableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usertableMouseClicked
        // TODO add your handling code here:

        DefaultTableModel model = (DefaultTableModel) usertable.getModel();
        myIndex = usertable.getSelectedRow();
        username.setText(model.getValueAt(myIndex, 0).toString());
        useradd.setText(model.getValueAt(myIndex, 1).toString());
        usermail.setText(model.getValueAt(myIndex, 2).toString());
        tt.setText(model.getValueAt(myIndex, 0).toString());
//        tt.setText(model.getValueAt(myIndex, 2).tosString());
        if (myIndex == -1) {
        JOptionPane.showMessageDialog(rootPane, "No row selected.");
        return;
    }

    // Validate table column count
    if (usertable.getColumnCount() <= 4) {
        JOptionPane.showMessageDialog(rootPane, "Table does not have enough columns.");
        return;
    }

    // Retrieve ID from column 4 safely
    int id;
    try {
        id = Integer.parseInt(usertable.getValueAt(myIndex, 4).toString());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(rootPane, "Invalid ID format in column 4.");
        return;
    }
//        myIndex = id;
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventorymanagement", "root", "root");
            String query = "SELECT mob,pass FROM user WHERE id = ?;";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, id);
            System.out.println(pst);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                String mob = rs.getString("mob");
                String pass=rs.getString("pass");
                usercontact.setText(mob);
                userpassword.setText(pass);
            } else {
                System.out.println("No user found with ID: " + myIndex);
            }
//            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error : " + e.getMessage());
        }
        Integer index;
        if (model.getValueAt(myIndex, 3).toString().equals("active")) {

            index = 0;
        } else {

            index = 1;
        }
        statuscb.setSelectedIndex(index);
       
        userpassword.setEditable(false);
        usercontact.setEditable(false);
        userpassword.setBackground(Color.LIGHT_GRAY);  // jab ye disable hoga tabke liye color set kiya h
        usercontact.setBackground(Color.LIGHT_GRAY);
        savebtn.setEnabled(false);
        updatebtn.setEnabled(true);


    }//GEN-LAST:event_usertableMouseClicked

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
        savebtn.setEnabled(true);
        usertable.clearSelection();
    }//GEN-LAST:event_formMouseClicked

    private void savebtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_savebtnMouseEntered
        // TODO add your handling code here:
        savebtn.setBackground(new Color(150, 145, 200));
    }//GEN-LAST:event_savebtnMouseEntered

    private void statuscbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statuscbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statuscbActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         Products1 HomePage = new Products1(); // Assuming Product extends JFrame or JPanel
          HomePage.setVisible(true);        // Display the Product page
          this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        HomePage Home = new HomePage(); // Assuming Product extends JFrame or JPanel
          Home.setVisible(true);        // Display the Product page
          this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(UserManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

//        usr.setDefaultCLoseOperation(JFrame.EXIT_ON_CLOSE);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserManager().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closebtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton resetbtn;
    private javax.swing.JButton savebtn;
    private javax.swing.JComboBox<String> statuscb;
    private javax.swing.JTextField tt;
    private javax.swing.JButton updatebtn;
    private javax.swing.JTextField useradd;
    private javax.swing.JTextField usercontact;
    private javax.swing.JTextField usermail;
    private javax.swing.JTextField username;
    private javax.swing.JTextField userpassword;
    private javax.swing.JTable usertable;
    // End of variables declaration//GEN-END:variables
}
