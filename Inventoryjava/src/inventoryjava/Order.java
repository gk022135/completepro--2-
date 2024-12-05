
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package inventoryjava;
import inventoryjava.OrderSummary;
import inventoryjava.OrderSummary;
import inventoryjava.HomePage;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;


/**
 *
 * @author priya
 */
public final class Order extends javax.swing.JFrame {

    public void customerListTableInit(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventorymanagement","root","root");
            String query = "SELECT * FROM PRODUCT";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            model.setRowCount(0);
            while (rs.next()) {
              Object[] row = {
                rs.getInt("CUSTID"),    
                rs.getString("CUSTNAME"), 
                rs.getString("CUSTPHONE") 
            };
            model.addRow(row);
        }
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Creates new form Order
     */
    public Order() {
        initComponents();
        customerListTableInit();
        Selectprod();
        GetDate();
    }
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
public void Selectprod(){
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventorymanagement","root","root");
        String query = "SELECT * FROM NEW_PRODUCT_TABLE";
        ps = con.prepareStatement(query);
        rs = ps.executeQuery();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            while (rs.next()) {
              Object[] row = {
                rs.getInt("PRODUCT_ID"),    
                rs.getString("PRODUCT_NAME"),
                rs.getString("CATEGORIES"),
                rs.getString("RATE"),
                rs.getString("QUANTITY")
                
                
            };
            model.addRow(row);
        
    } 
    }
     catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
        }
}
private void GetDate(){
    DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    LocalDateTime now = LocalDateTime.now();
    jLabel11.setText(dt.format(now));
}
public void selectProd(){
    try {
    // Establish the database connection
    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventorymanagement", "root", "root");

    // Execute the query to fetch products
     Statement st = con.createStatement();
    rs = st.executeQuery("SELECT * FROM NEW_PRODUCT_TABLE");

    // Set the JTable's model manually using DefaultTableModel
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel(); // Ensure productTable is your JTable
    model.setRowCount(0); // Clear any existing rows

    // Populate the table with data from the ResultSet
    while (rs.next()) {
        Object[] row = {
            rs.getInt("PRODUCT_ID"),      // Replace with the correct column name
            rs.getString("PRODUCT_NAME"), // Replace with the correct column name
            rs.getInt("CATEGORIES"),
            rs.getString("RATE"),
            rs.getString("QUANTITY")
        };
        model.addRow(row);
    }

    // Close resources
    
} catch (SQLException ex) {
    System.out.println("Error: " + ex.getMessage());
}

}

private void update(){
    int newqty = oldqty - Integer.parseInt(Quantity.getText());
    try {
            // TODO add your handling code here:
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory","root","admin");
//            ps = con.prepareStatement("UPDATE PRODUCT SET CUSTNAME=?,CUSTPHONE=? WHERE CUSTID=?");
//            ps.setString(1, Custname.getText());
//            ps.setString(2, Custphone.getText());
//            ps.setInt(3, Integer.parseInt(CUstid.getText()));
//            
//            int rowsUpdated = ps.executeUpdate();
//            if (rowsUpdated > 0) {
//                JOptionPane.showMessageDialog(this, "Updated Successfully");
//                refreshTableData(); // Call the method to refresh table data
//            } else {
//                JOptionPane.showMessageDialog(this, "Update Failed");
//            }
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventorymanagement", "root", "root");

    // Step 2: Update the product in the database
           ps = con.prepareStatement("UPDATE NEW_PRODUCT_TABLE SET Quantity="+newqty+""+" WHERE PRODUCT_ID="+productid);
           

//           int rowsUpdated = 
             ps.executeUpdate();
             Selectprod();
//           if (rowsUpdated > 0) {
//              JOptionPane.showMessageDialog(this, "Updated Successfully");
//           } else {
//              JOptionPane.showMessageDialog(this, "Update Failed");
//           }

    
            
         } catch (SQLException ex) {
            System.out.println(ex);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        totalAmtlbl = new javax.swing.JLabel();
        Quantity = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        BillID = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        CustNamelbl = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        Price1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        totalAmtlbl1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Showcard Gothic", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Manage orders");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(293, 293, 293)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 934, -1));

        jPanel3.setBackground(new java.awt.Color(223, 242, 235));
        jPanel3.setLayout(null);
        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 561, 934, -1));

        totalAmtlbl.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        totalAmtlbl.setForeground(new java.awt.Color(0, 204, 204));
        totalAmtlbl.setText("amount");
        jPanel1.add(totalAmtlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 500, -1, -1));

        Quantity.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.add(Quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(649, 258, 134, 23));

        jButton1.setBackground(new java.awt.Color(102, 102, 102));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 204, 204));
        jButton1.setText("Add Order");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 382, 99, 36));

        jButton2.setBackground(new java.awt.Color(102, 102, 102));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 204, 204));
        jButton2.setText("View Orders");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(201, 382, -1, 36));

        jButton3.setBackground(new java.awt.Color(102, 102, 102));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 204, 204));
        jButton3.setText("Home");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 430, -1, 38));

        jTable1.setBackground(new java.awt.Color(204, 204, 204));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ProdID", "Name", "Category", "Rate", "Quantity"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(506, 103, 410, 137));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setText("Products List");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 204)));
        jLabel5.setOpaque(true);
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(626, 72, -1, -1));

        jTable2.setBackground(new java.awt.Color(204, 204, 204));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CustID", "Name", "Phone"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 103, 439, 111));

        jLabel6.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 204, 204));
        jLabel6.setText("Orderid");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 245, -1, -1));

        jLabel7.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 204, 204));
        jLabel7.setText("customer name");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 301, -1, -1));

        BillID.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.add(BillID, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 244, 164, -1));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 102));
        jLabel8.setText("   customers list");
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 204)));
        jLabel8.setOpaque(true);
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 170, 30));

        CustNamelbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        CustNamelbl.setForeground(new java.awt.Color(243, 243, 224));
        CustNamelbl.setText("CustName");
        jPanel1.add(CustNamelbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 300, -1, -1));

        jLabel10.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 204, 204));
        jLabel10.setText("Date");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 330, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(243, 243, 224));
        jLabel11.setText("Date");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, -1, -1));

        jButton6.setBackground(new java.awt.Color(153, 153, 153));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(185, 229, 232));
        jButton6.setText("AddToOrder");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(789, 258, -1, -1));

        jTable3.setBackground(new java.awt.Color(204, 204, 204));
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Num", "Product", "Quantity", "Price", "Total"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, 525, 176));

        jLabel3.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 204, 204));
        jLabel3.setText("Quantity");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(542, 259, -1, -1));

        Price1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.add(Price1, new org.netbeans.lib.awtextra.AbsoluteConstraints(464, 258, 72, 23));

        jLabel4.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 204, 204));
        jLabel4.setText("price");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(391, 259, -1, -1));

        totalAmtlbl1.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        totalAmtlbl1.setForeground(new java.awt.Color(0, 204, 204));
        totalAmtlbl1.setText("rs");
        jPanel1.add(totalAmtlbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 500, -1, -1));

        jLabel2.setForeground(new java.awt.Color(0, 204, 204));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/newpackage/pexels-karolina-grabowska-5624985.jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -3, 960, 680));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new OrderSummary().setVisible(true);
//        String orderid="12";
//        String Custname = "random1";
//        String Orderdate = "2024/11/25";
//        double Amount = 250.6;
//        OrderSummary summary = new OrderSummary(orderid,Custname,Orderdate,Amount);
//        new OrderSummary()
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
         
        new HomePage().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        
    }//GEN-LAST:event_formWindowOpened

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
//         try {
//            // TODO add your handling code here:
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory","root","admin");
//            ps = con.prepareStatement("insert into Orders values(?,?,?)");
//            ps.setInt(1, Integer.parseInt(orderId.getText()));
//            ps.setInt(2, Integer.parseInt(Price.getText()));
//            ps.setInt(3, Integer.parseInt(Quantity.getText()));
//            ps.executeUpdate();
//            JOptionPane.showMessageDialog(this, "Order list Added");
//            
//            ps = con.prepareStatement("SELECT * FROM Orders");
//            rs = ps.executeQuery();
//            
//            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
//        
//            while (rs.next()) {
//             int order = rs.getInt("ProdID");
//             String price = rs.getString("Price");
//             String quantity = rs.getString("Quantity");
//             String[] arr = {rs.getInt("ProdID")+"", rs.getString("Price"), rs.getString("Quantity") };
//             model.addRow(arr);
//             System.out.println("Customer ID: " + order + ", Name: " + price + ", Phone: " + quantity);
//        }
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(ManageCustomer.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        int index = jTable2.getSelectedRow();
        //CustId.setText(model.getValueAt(index, 0).toString());
        CustNamelbl.setText(model.getValueAt(index, 1).toString());
        //Custphone.setText(model.getValueAt(index, 2))
        
    }//GEN-LAST:event_jTable2MouseClicked
int i = 1,Price,tot=0,total;
String Name;
    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        // TODO add your handling code here:
        if(flag == 0 || Quantity.getText().isEmpty() || Price1.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Select and Enter Qty");
        }
        else{
        
        Price = Integer.parseInt(Price1.getText());
        tot = Price * Integer.parseInt(Quantity.getText());
        Vector v = new Vector();
        v.add(i);
        v.add(Name);
        v.add(Quantity.getText());
        v.add(Price);
        v.add(tot);
        DefaultTableModel dt = (DefaultTableModel)jTable3.getModel();
        dt.addRow(v);
        total = total + tot;
        totalAmtlbl.setText(""+total);
        update();
        i++;
        
        }
        
    }//GEN-LAST:event_jButton6MouseClicked
    int flag =0,productid,oldqty;
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
            // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int myindex = jTable1.getSelectedRow();
        //BillID.setText 
        productid = Integer.parseInt(model.getValueAt(myindex, 0).toString());
        Name = model.getValueAt(myindex, 1).toString();
        oldqty = Integer.parseInt(model.getValueAt(myindex, 4).toString());
        flag = 1;
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        if(BillID.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "enter the Bill Id");
        }
        else{
        
        try {
            // TODO add your handling code here:
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventorymanagement","root","root");
            PreparedStatement add = con.prepareStatement("INSERT INTO ORDERTEL VALUES(?,?,?,?)");
            add.setInt(1, Integer.parseInt(BillID.getText()));
            add.setString(2, CustNamelbl.getText());
            add.setString(3, jLabel11.getText());
            add.setInt(4, Integer.parseInt(totalAmtlbl.getText()));
            
            add.executeUpdate();
            JOptionPane.showMessageDialog(this, "Order is added");
            
            PreparedStatement dt = con.prepareStatement("SELECT * FROM ORDERTEL");
            rs = dt.executeQuery();
            while (rs.next()) {
    
                int id = rs.getInt("Orderid");
                String customerName = rs.getString("Custname");
                String phone = rs.getString("Orderdate");
                String totalAmount = rs.getString("Amount");

                
                System.out.println("orderid: " + id + ", CustomerName: " + customerName + 
                       ", orderdate: " + phone + ", Amount: " + totalAmount);
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_jButton1MouseClicked

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
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Order().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BillID;
    private javax.swing.JLabel CustNamelbl;
    private javax.swing.JTextField Price1;
    private javax.swing.JTextField Quantity;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JLabel totalAmtlbl;
    private javax.swing.JLabel totalAmtlbl1;
    // End of variables declaration//GEN-END:variables
}
