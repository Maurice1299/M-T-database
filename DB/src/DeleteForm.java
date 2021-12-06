
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author lilmoe12
 */
public class DeleteForm extends javax.swing.JFrame {

    /**
     * Creates new form Delete
     */
    String driver = "com.mysql.cj.jdbc.Driver";
    String un = "root";
    String pw = "Doubletrocks1";
    String currentTable;
    int deleteIndex;
    //Party Lists
        ArrayList<Integer> Party_IDs = new ArrayList<Integer>();        
        
        //Tent Lists
        ArrayList<Integer> Tent_IDs = new ArrayList<Integer>();
                
        //Customer Lists
        ArrayList<Integer> Customer_IDs = new ArrayList<Integer>();
        
        //Employee Lists
        ArrayList<Integer> Employee_IDs = new ArrayList<Integer>();
                
        //Work Day Lists
        ArrayList<Date> Work_Dates = new ArrayList<Date>();        
        
        //Work Order Lists
        ArrayList<Boolean> Setups = new ArrayList<Boolean>();
        ArrayList<Boolean> Takedowns = new ArrayList<Boolean>();
        
        //Scheduling Lists        
        ArrayList<Date> Work_Day_Dates = new ArrayList<Date>();
    
    public DeleteForm(String currentTable) {
        initComponents();
        this.currentTable = currentTable;
        
        switch(currentTable){
            case "tent_rental":
                lblFormName.setText("Delete Tent Rental");
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    String connectionURL = "jdbc:mysql://localhost:3306/patrickspartyrental";
                    Connection conn;
                    conn = DriverManager.getConnection(connectionURL, un, pw);
                    Statement st = conn.createStatement();
                    String query = "Select * from tent_rental";
                    ResultSet rs = st.executeQuery(query);
                    while(rs.next()){
                        Tent_IDs.add(rs.getInt(1));
                        Party_IDs.add(rs.getInt(2));
                    }
                    for(int i = 0; i < Tent_IDs.size(); i++){
                        dropdownRowID.addItem(Tent_IDs.get(i).toString() + ", " + Party_IDs.get(i).toString());
                    }
                    }catch (Exception e) {
                        System.out.println("SQL Exception: "+ e.toString());
                    }
                break;
            case "tent":
                lblFormName.setText("Delete Tent");
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    String connectionURL = "jdbc:mysql://localhost:3306/patrickspartyrental";
                    Connection conn;
                    conn = DriverManager.getConnection(connectionURL, un, pw);
                    Statement st = conn.createStatement();
                    String query = "Select * from tent";
                    ResultSet rs = st.executeQuery(query);
                    while(rs.next()){
                        Tent_IDs.add(rs.getInt(1));
                    }                
                    for(int i = 0; i < Tent_IDs.size(); i++){
                        dropdownRowID.addItem(Tent_IDs.get(i).toString());
                    }

                }catch (Exception e) {
                    System.out.println("SQL Exception: "+ e.toString());
                }
                break;
            case "party":
                lblFormName.setText("Delete Party");
                try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                String connectionURL = "jdbc:mysql://localhost:3306/patrickspartyrental";
                Connection conn;
                conn = DriverManager.getConnection(connectionURL, un, pw);
                Statement st = conn.createStatement();
                String query = "Select * from party";
                ResultSet rs = st.executeQuery(query);
                while(rs.next()){
                    Party_IDs.add(rs.getInt(1));                    
                }                
                for(int i = 0; i < Party_IDs.size(); i++){
                    dropdownRowID.addItem(Party_IDs.get(i).toString());
                }
                }catch (Exception e) {
                    System.out.println("SQL Exception: "+ e.toString());
                }
                break;
            case "employee":   
                lblFormName.setText("Delete Employee");
                 try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    String connectionURL = "jdbc:mysql://localhost:3306/patrickspartyrental";
                    Connection conn;
                    conn = DriverManager.getConnection(connectionURL, un, pw);
                    Statement st = conn.createStatement();
                    String query = "Select * from employee";
                    ResultSet rs = st.executeQuery(query);
                    while(rs.next()){
                    Employee_IDs.add(rs.getInt(1));                    
                    }                    
                    for(int i = 0; i < Employee_IDs.size(); i++){
                        dropdownRowID.addItem(Employee_IDs.get(i).toString());
                    }
                }catch (Exception e) {
                    System.out.println("SQL Exception: "+ e.toString());
                } 
                break;
            case "customer":
                lblFormName.setText("Delete Customer");
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    String connectionURL = "jdbc:mysql://localhost:3306/patrickspartyrental";
                    Connection conn;
                    conn = DriverManager.getConnection(connectionURL, un, pw);
                    Statement st = conn.createStatement();
                    String query = "Select * from customer";
                    ResultSet rs = st.executeQuery(query);
                    while(rs.next()){
                        Customer_IDs.add(rs.getInt(1));                        
                    }                    
                    for(int i = 0; i < Customer_IDs.size(); i++){
                        dropdownRowID.addItem(Customer_IDs.get(i).toString());
                        
                    }                
                    }catch (Exception e) {
                        System.out.println("SQL Exception: "+ e.toString());
                    }
                break;
            case "workday":
                lblFormName.setText("Delete Work Day");
                try{
                   Class.forName("com.mysql.cj.jdbc.Driver");
                   String connectionURL = "jdbc:mysql://localhost:3306/patrickspartyrental";
                   Connection conn;
                   conn = DriverManager.getConnection(connectionURL, un, pw);
                   Statement st = conn.createStatement();
                   String query = "Select * from workday";
                   ResultSet rs = st.executeQuery(query);
                   while(rs.next()){
                   Work_Dates.add(rs.getDate(1));                   
                   }              
                   for(int i = 0; i < Work_Dates.size(); i++){
                       dropdownRowID.addItem(Work_Dates.get(i).toString());
                   }
                }catch (Exception e) {
                    System.out.println("SQL Exception: "+ e.toString());
                }
                break;
            case "workorder":  
                lblFormName.setText("Delete Work Order");
                 try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    String connectionURL = "jdbc:mysql://localhost:3306/patrickspartyrental";
                    Connection conn;
                    conn = DriverManager.getConnection(connectionURL, un, pw);
                    Statement st = conn.createStatement();
                    String query = "Select * from workorder";
                    ResultSet rs = st.executeQuery(query);
                    while(rs.next()){
                    Work_Dates.add(rs.getDate(1));
                    Party_IDs.add(rs.getInt(2));
                    Setups.add(rs.getBoolean(3));
                    Takedowns.add(rs.getBoolean(4));                    
                    }                    
                    for(int i = 0; i < Work_Dates.size(); i++){
                        dropdownRowID.addItem(Work_Dates.get(i) + ", " + Party_IDs.get(i) + ", " + Setups.get(i)+ ", " + Takedowns.get(i));
                    }
                }catch (Exception e) {
                    System.out.println("SQL Exception: "+ e.toString());
                }
                break;
            case "scheduling":  
                lblFormName.setText("Delete Scheduling");
                 try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    String connectionURL = "jdbc:mysql://localhost:3306/patrickspartyrental";
                    Connection conn;
                    conn = DriverManager.getConnection(connectionURL, un, pw);
                    Statement st = conn.createStatement();
                    String query = "Select * from scheduling";
                    ResultSet rs = st.executeQuery(query);
                    while(rs.next()){
                        Employee_IDs.add(rs.getInt(1));
                        Work_Day_Dates.add(rs.getDate(2));
                    }                    
                    for(int i = 0; i < Employee_IDs.size(); i++){
                        dropdownRowID.addItem(Employee_IDs.get(i) + ", " + Work_Day_Dates.get(i));
                    }
                }catch (Exception e) {
                    System.out.println("SQL Exception: "+ e.toString());
                }
                break;
            default:
                break;
        }
        setVisible(true);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        lblFormName = new javax.swing.JLabel();
        lblRowID = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        dropdownRowID = new javax.swing.JComboBox<>();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblFormName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFormName.setText("Delete from tableName");

        lblRowID.setText("Row ID");

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        dropdownRowID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select an item" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblRowID, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lblFormName, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(dropdownRowID, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblFormName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRowID, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dropdownRowID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnDelete))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        String query = "";
        String [] keys;
        switch(currentTable.toLowerCase()){
            case "none":                
                break;
            case "tent_rental":
                keys = dropdownRowID.getSelectedItem().toString().split(",");
                query = "DELETE FROM tent_rental WHERE Tent_ID = " + keys[0] + " AND Party_ID = " + keys[1];
                break;
            case "tent":
                query = "DELETE FROM tent WHERE Tent_ID = " + dropdownRowID.getSelectedItem().toString();
                break;
            case "party":
                query = "DELETE FROM party WHERE Party_ID = " + dropdownRowID.getSelectedItem().toString();
                break;
            case "customer":
                query = "DELETE FROM customer WHERE Customer_ID = " + dropdownRowID.getSelectedItem().toString();
                break;
            case "employee":
                query = "DELETE FROM employee WHERE Employee_ID = " + dropdownRowID.getSelectedItem().toString();
                break;
            case "workday":
                query = "DELETE FROM workday WHERE Work_Date = '" + dropdownRowID.getSelectedItem().toString() + "'";
                break;
            case "workorder":
                keys = dropdownRowID.getSelectedItem().toString().split(",");
                query = "DELETE FROM workorder WHERE Work_Date = '" + keys[0] + "' AND Party_ID = " + keys[1] + 
                        " AND Setup = " + keys[2] + " AND Takedown = " + keys[3];
                break;
            case "scheduling":
                keys = dropdownRowID.getSelectedItem().toString().split(",");
                query = "DELETE FROM scheduling WHERE Employee_ID = " + keys[0] + " AND Work_Day_Date = '" + keys[1] + "'";
                break; 
            default:
                break;
        }
         try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                String connectionURL = "jdbc:mysql://localhost:3306/patrickspartyrental";
                Connection conn;
                conn = DriverManager.getConnection(connectionURL, un, pw);
                Statement st = conn.createStatement();                
                st.execute(query);
            }catch (Exception e) {
                System.out.println("SQL Exception: "+ e.toString());
            }
         setVisible(false);
         dispose();
    }//GEN-LAST:event_btnDeleteActionPerformed

        
        
    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    
   
    
    
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(DeleteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(DeleteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(DeleteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(DeleteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new DeleteForm().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JComboBox<String> dropdownRowID;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFormName;
    private javax.swing.JLabel lblRowID;
    // End of variables declaration//GEN-END:variables
}
