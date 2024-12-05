/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package inventoryjava;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gauravkrrr
 */
public class Products1 extends javax.swing.JFrame {

    public Products1() {
        initComponents();
         loadCategories();
    }
    private void loadCategories() {
    // Database connection details
    String url = "jdbc:mysql://localhost:3306/inventorymanagement";
    String user = "root";
    String password = "root";

   java.sql.Connection connection = null;
    java.sql.PreparedStatement preparedStatement = null;
    java.sql.ResultSet resultSet = null;

    try {
        // Establish connection
        connection = java.sql.DriverManager.getConnection(url, user, password);

        // SQL Query to fetch categories
        String query = "SELECT catname FROM productcategory"; // Update as per your database
        preparedStatement = connection.prepareStatement(query);
        resultSet = preparedStatement.executeQuery();

        // Clear the combo box before adding items
        jComboBox1.removeAllItems();

        // Add each category to the combo box
        while (resultSet.next()) {
            String categoryName = resultSet.getString("catname");
            jComboBox1.addItem(categoryName);
        }

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error fetching categories: " + e.getMessage(),
                "Database Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        try {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        t_amount = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Product_Name = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Rate = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Quantity = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Product_id = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        Categories = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Home");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 20, 100, 30));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Categories", "Electronics", "Clothings", "Hardwares", "Medicines", "Grocery" }));
        jComboBox1.setOpaque(true);
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, 120, 30));

        jTable2.setBackground(new java.awt.Color(204, 204, 255,1));
        jTable2.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jTable2.setForeground(new java.awt.Color(255, 255, 255));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Product_Id", "Product_Name", "Categories", "Rate", "Quantity", "t_amount"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 60, 550, 430));

        jButton7.setBackground(new java.awt.Color(0, 255, 255));
        jButton7.setText("OK");
        jButton7.setOpaque(true);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, 50, 30));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("    Products");
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 60));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Rating");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 332, 106, 20));

        t_amount.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 255, 255), new java.awt.Color(204, 0, 204), null));
        getContentPane().add(t_amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 330, 138, -1));

        jLabel4.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Product_Name");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 204, 106, 22));

        Product_Name.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 255, 255), new java.awt.Color(204, 0, 204), null));
        getContentPane().add(Product_Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 194, 138, -1));

        jLabel5.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Rate");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 244, 106, 25));

        Rate.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 255, 255), new java.awt.Color(204, 0, 204), null));
        Rate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RateActionPerformed(evt);
            }
        });
        getContentPane().add(Rate, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 244, 138, -1));

        jLabel6.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Quantity");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 287, 106, 25));

        Quantity.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 255, 255), new java.awt.Color(204, 0, 204), null));
        getContentPane().add(Quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 287, 138, -1));

        jLabel7.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Product_id");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 154, 106, 32));

        Product_id.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 255, 255), new java.awt.Color(204, 0, 204), null));
        Product_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Product_idActionPerformed(evt);
            }
        });
        getContentPane().add(Product_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 154, 138, -1));

        jLabel2.setBackground(new java.awt.Color(255, 204, 204));
        jLabel2.setFont(new java.awt.Font("Noto Sans", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Manage Your Products of Shop/Grocery");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 283, -1));

        jButton2.setBackground(new java.awt.Color(0, 255, 255));
        jButton2.setText("Add Product");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 120, -1));

        jButton3.setBackground(new java.awt.Color(255, 51, 51));
        jButton3.setText("Delete item");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, 110, -1));

        jButton4.setBackground(new java.awt.Color(204, 255, 102));
        jButton4.setText("Edit");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 120, -1));

        jButton5.setText("Show Detail");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 460, 110, -1));

        jButton6.setBackground(new java.awt.Color(0, 204, 51));
        jButton6.setText("Reset");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 420, 110, -1));

        Categories.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 255, 255), new java.awt.Color(204, 0, 204), null));
        Categories.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CategoriesActionPerformed(evt);
            }
        });
        getContentPane().add(Categories, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 140, -1));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Categories");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 80, 20));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/newpackage/headphones.jpg"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1010, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        HomePage HomePage = new HomePage(); // Assuming Product extends JFrame or JPanel
          HomePage.setVisible(true);        // Display the Product page
          this.dispose(); 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void Product_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Product_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Product_idActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    try{   
    String username = "root";
    String password = "root";
    String db = "jdbc:mysql://localhost:3306/inventorymanagement";
    
    java.sql.Connection con = java.sql.DriverManager.getConnection(db, username, password);
    String query = "SELECT * FROM New_Product_table WHERE Product_id = ?";
    java.sql.PreparedStatement pst = con.prepareStatement(query);
    
    pst.setString(1, Product_id.getText()); // Assuming Product_id contains the ID to search
    
    java.sql.ResultSet rs = pst.executeQuery(); // Execute the query and get the result set
    
    String query2 = "SELECT * FROM New_Product_table";
    java.sql.PreparedStatement pst2 = con.prepareStatement(query2);
    java.sql.ResultSet rs2 = pst2.executeQuery();
    
    DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            model.setRowCount(1); // Clear existing data
            while (rs2.next()) {
                
                String Product_id = rs2.getString("Product_id");
                String Pro_name = rs2.getString("Product_Name");
                String Catego = rs2.getString("Categories");
                String Rte = rs2.getString("Rate");
                String qun = rs2.getString("Quantity");
                
                 float R = Float.parseFloat(Rte);
                  int q = Integer.parseInt(qun);
                 float y = q*R;
                
                
                
//add into table fields
                Object[] row = {Product_id, Pro_name,Catego, Rte, qun,y};
                model.addRow(row);
    
    
    if (rs.next()) { // Check if a row is returned
        String productId = rs.getString("Product_id");
        String productName = rs.getString("Product_Name");
        String Categ = rs.getString("Categories");
        String rate = rs.getString("Rate");
        String quantity = rs.getString("Quantity");
        
        float rte = Float.parseFloat(rate);
        int qt = Integer.parseInt(quantity);
        float x = rte*qt;
        
        // Print the values or use them as needed
        JOptionPane.showMessageDialog(rootPane, 
            "Product ID: " + productId + "\n" +
            "Product Name: " + productName + "\n" +
            "Categories:"+Categ+"\n"+
            "Rate: " + rate + "\n" +
            "Quantity: " + quantity +"\n"+
            "Total_amount:"+x
        );
    } 
    else {
        JOptionPane.showMessageDialog(rootPane, "No record found with the given Product ID");
        }
     }}
    catch(Exception E){
        JOptionPane.showMessageDialog(rootPane, "Error occured" + E.getMessage());
    }
           

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        //Reset Button Function
        Product_id.setText("");
        Product_Name.setText("");
        Categories.setText("");
        Rate.setText("");
        Quantity.setText("");
        JOptionPane.showMessageDialog(rootPane, "Cleared");
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Work for adding product in database to be done here
        String pname = Product_Name.getText();
        String Pid = Product_id.getText();
        String Cate = Categories.getText();
        String Rte = Rate.getText();
        String quan = Quantity.getText();
        
        if(pname == null || Pid == null || Rte == null || quan == null){
            JOptionPane.showMessageDialog(rootPane, "all fields are required");
        }
        else{
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String username = "root";
                String password = "root";
                String db = "jdbc:mysql://localhost:3306/inventorymanagement";
                
                java.sql.Connection con = java.sql.DriverManager.getConnection(db, username, password);
                String query = "insert into New_Product_table(Product_id,Product_Name,Categories,Rate,Quantity) values(?,?,?,?,?)";
                java.sql.PreparedStatement pst = con.prepareStatement(query); 
                
                pst.setString(1,Product_id.getText());
                pst.setString(2,Product_Name.getText());
                pst.setString(3,Categories.getText());
                pst.setString(4,Rate.getText());
                pst.setString(5,Quantity.getText());
                
                 int count = pst.executeUpdate();
                
                if(count>0){
                    JOptionPane.showMessageDialog(rootPane, "Record Store to DataBase");
                
                }
                else{
                    JOptionPane.showMessageDialog(rootPane, "some error occurs");
                }
                con.close();
                

                
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(Products1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
                
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Deletion Process is done Here
        String str = Product_id.getText();
        if(str == null){
            JOptionPane.showMessageDialog(rootPane, "Only Product id Required");
        }
        else{
        try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    String username = "root";
    String password = "root";
    String db = "jdbc:mysql://localhost:3306/inventorymanagement";
    
    java.sql.Connection con = java.sql.DriverManager.getConnection(db, username, password);
    String query = "DELETE FROM New_Product_table WHERE Product_id = ?";
    java.sql.PreparedStatement pst = con.prepareStatement(query); 
    
    pst.setString(1, Product_id.getText()); // Assuming Product_id is a field containing the ID to delete
    
    int count = pst.executeUpdate();
    
    if(count > 0) {
        JOptionPane.showMessageDialog(rootPane, "Record Deleted from Database");
    } else {
        JOptionPane.showMessageDialog(rootPane, "No record found with the given Product ID");
    }
    con.close();
} catch (ClassNotFoundException | SQLException ex) {
    Logger.getLogger(Products1.class.getName()).log(Level.SEVERE, null, ex);
}
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // Code for updating previous entries
        try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    String username = "root";
    String password = "root";
    String db = "jdbc:mysql://localhost:3306/inventorymanagement";

    java.sql.Connection con = java.sql.DriverManager.getConnection(db, username, password);
    
    
    String query = "UPDATE New_Product_table SET Product_Name = ?,Categories =?,Rate = ?, Quantity = ? WHERE Product_id = ?";
    java.sql.PreparedStatement pst = con.prepareStatement(query);
    
    pst.setString(1, Product_Name.getText());
    pst.setString(2, Categories.getText());
    pst.setFloat(3, Float.parseFloat(Rate.getText()));
    pst.setInt(4, Integer.parseInt(Quantity.getText()));
    pst.setInt(5, Integer.parseInt(Product_id.getText()));
    int count = pst.executeUpdate();

    if (count > 0) {
        JOptionPane.showMessageDialog(rootPane, "Record Updated Successfully");
    } else {
        JOptionPane.showMessageDialog(rootPane, "No record found with the given Product ID");
    }

    con.close();
} catch (ClassNotFoundException | SQLException ex) {
    Logger.getLogger(Products1.class.getName()).log(Level.SEVERE, null, ex);
} catch (NumberFormatException ex) {
    JOptionPane.showMessageDialog(rootPane, "Please enter valid numerical values for Rate and Quantity", "Input Error", JOptionPane.ERROR_MESSAGE);
}

    }//GEN-LAST:event_jButton4ActionPerformed

    private String selectedItem;
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        selectedItem = (String) jComboBox1.getSelectedItem();
        System.out.println("Selected Item: " + selectedItem);
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        //Categories working
        try{   
        String username = "root";
    String password = "root";
    String db = "jdbc:mysql://localhost:3306/inventorymanagement";
    
    java.sql.Connection con = java.sql.DriverManager.getConnection(db, username, password);
 
    
    String query2 = "SELECT * FROM New_Product_table WHERE Categories = ?";
    java.sql.PreparedStatement pst2 = con.prepareStatement(query2);
     pst2.setString(1,selectedItem);
    java.sql.ResultSet rs2 = pst2.executeQuery();
    
    DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            model.setRowCount(1); // Clear existing data
            while (rs2.next()) {
                
                String Product_id = rs2.getString("Product_id");
                String Pro_name = rs2.getString("Product_Name");
                String Catego = rs2.getString("Categories");
                String Rte = rs2.getString("Rate");
                String qun = rs2.getString("Quantity");
                
                 float R = Float.parseFloat(Rte);
                  int q = Integer.parseInt(qun);
                 float y = q*R;
                
                
                
//add into table fields
                Object[] row = {Product_id, Pro_name,Catego, Rte, qun,y};
                model.addRow(row);
     }}
    catch(Exception E){
        JOptionPane.showMessageDialog(rootPane, "Error occured" + E.getMessage());
    }                                        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void CategoriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CategoriesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CategoriesActionPerformed

    private void RateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RateActionPerformed

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
            java.util.logging.Logger.getLogger(Products1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Products1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Products1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Products1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Products1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Categories;
    private javax.swing.JTextField Product_Name;
    private javax.swing.JTextField Product_id;
    private javax.swing.JTextField Quantity;
    private javax.swing.JTextField Rate;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField t_amount;
    // End of variables declaration//GEN-END:variables
}
