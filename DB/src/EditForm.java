
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
 * @author ttoyr
 */
public class EditForm extends javax.swing.JFrame {

    /**
     * Creates new form EditForm
     */
    String driver = "com.mysql.cj.jdbc.Driver";
    String un = "root";
    String pw = "Doubletrocks1";
    String currentTable;

    //tent lists
    ArrayList<Integer> Tent_IDs = new ArrayList<Integer>();
    ArrayList<String> Sizes = new ArrayList<String>();
    ArrayList<Integer> Num_Stakes = new ArrayList<Integer>();
    ArrayList<Integer> Num_Poles = new ArrayList<Integer>();
    ArrayList<Integer> Square_Footages = new ArrayList<Integer>();
    
    //party lists
    ArrayList<Integer> Party_IDs = new ArrayList<Integer>();    
    ArrayList<String> Locations = new ArrayList<String>();
    ArrayList<Date> Setup_Dates = new ArrayList<Date>();
    ArrayList<Date> Takedown_Dates = new ArrayList<Date>();
    ArrayList<Double> Costs = new ArrayList<Double>();
    ArrayList<Integer> Tables = new ArrayList<Integer>();
    ArrayList<Integer> Chairs = new ArrayList<Integer>();
    
    //customer lists
    ArrayList<Integer> Customer_IDs = new ArrayList<Integer>();
    ArrayList<String> Customer_FNames = new ArrayList<String>();
    ArrayList<String> Customer_LNames = new ArrayList<String>();
    ArrayList<Long> Customer_Phones = new ArrayList<Long>();
    ArrayList<String> Customer_Emails = new ArrayList<String>();    
    
    //employee lists
    ArrayList<Integer> Employee_IDs = new ArrayList<Integer>();
    ArrayList<String> Employee_FNames = new ArrayList<String>();
    ArrayList<String> Employee_LNames = new ArrayList<String>();
    ArrayList<Long> Employee_Phones = new ArrayList<Long>();
    
    //work day lists
    ArrayList<Date> Work_Dates = new ArrayList<Date>();
    ArrayList<String> Start_Times = new ArrayList<String>();
    ArrayList<String> End_Times = new ArrayList<String>();
    
    //work order    
    ArrayList<Date> Work_Day_Dates = new ArrayList<Date>();
    public EditForm(String currentTable) {
        initComponents();
        this.currentTable = currentTable;
        switch(currentTable.toLowerCase()){
            case "none":
                setVisible(false);
                dispose();
                break;
            case "tent_rental":  
                lblFormName.setText("Edit Tent Rental");
                dropdownAttribute.addItem("TENT_ID");
                dropdownAttribute.addItem("PARTY_ID");
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
                lblFormName.setText("Edit Tent");
                dropdownAttribute.addItem("Tent_ID");
                dropdownAttribute.addItem("Size");
                dropdownAttribute.addItem("Num_Stakes");
                dropdownAttribute.addItem("Num_Poles");
                dropdownAttribute.addItem("Square_Footage");
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
                        Sizes.add(rs.getString(2));
                        Num_Stakes.add(rs.getInt(3));
                        Num_Poles.add(rs.getInt(4));
                        Square_Footages.add(rs.getInt(5));
                }                
                for(int i = 0; i < Tent_IDs.size(); i++){
                    dropdownRowID.addItem(Tent_IDs.get(i).toString());
                }
                }catch (Exception e) {
                    System.out.println("SQL Exception: "+ e.toString());
                }
                break;
            case "party":
                lblFormName.setText("Edit Party");
                dropdownAttribute.addItem("Party_ID");
                dropdownAttribute.addItem("Customer_ID");
                dropdownAttribute.addItem("Location");
                dropdownAttribute.addItem("Setup_Date");
                dropdownAttribute.addItem("Takedown_Date");
                dropdownAttribute.addItem("Cost");
                dropdownAttribute.addItem("Tables");
                dropdownAttribute.addItem("Chairs");
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
                            Customer_IDs.add(rs.getInt(2));
                            Locations.add(rs.getString(3));
                            Setup_Dates.add(rs.getDate(4));
                            Takedown_Dates.add(rs.getDate(5));
                            Costs.add(rs.getDouble(6));
                            Tables.add(rs.getInt(7));
                            Chairs.add(rs.getInt(8));

                   }                    
                    for(int i = 0; i < Party_IDs.size(); i++){
                        dropdownRowID.addItem(Party_IDs.get(i).toString());
                    }
                    }catch (Exception e) {
                        System.out.println("SQL Exception: "+ e.toString());
                    }
                break;
            case "customer":
                lblFormName.setText("Edit Customer");
                dropdownAttribute.addItem("CUSTOMER_ID");
                dropdownAttribute.addItem("CUSTOMER_FNAME");
                dropdownAttribute.addItem("CUSTOMER_LNAME");
                dropdownAttribute.addItem("CUSTOMER_PHONE");
                dropdownAttribute.addItem("CUSTOMER_EMAIL");
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
                            Customer_FNames.add(rs.getString(2));
                            Customer_LNames.add(rs.getString(3));
                            Customer_Phones.add(rs.getLong(4));
                            Customer_Emails.add(rs.getString(5));
                        }                        
                        for(int i = 0; i < Customer_IDs.size(); i++){
                            dropdownRowID.addItem(Customer_IDs.get(i).toString());
                        }
                    }catch (Exception e) {
                        System.out.println("SQL Exception: "+ e.toString());
                    }
                break;
            case "employee":   
                lblFormName.setText("Edit Employee");
                dropdownAttribute.addItem("Employee_ID");
                dropdownAttribute.addItem("Employee_FName");
                dropdownAttribute.addItem("Employee_LName");
                dropdownAttribute.addItem("Employee_Phone");
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
                    Employee_FNames.add(rs.getString(2));
                    Employee_LNames.add(rs.getString(3));
                    Employee_Phones.add(rs.getLong(4));
                    }                    
                    for(int i = 0; i < Employee_IDs.size(); i++){
                       dropdownRowID.addItem(Employee_IDs.get(i).toString()); 
                    }
                }catch (Exception e) {
                    System.out.println("SQL Exception: "+ e.toString());
                }
                break;
            case "workday":  
                lblFormName.setText("Edit Work Day");
                dropdownAttribute.addItem("Work_Date");
                dropdownAttribute.addItem("Start_Time");
                dropdownAttribute.addItem("End_Time");
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
                   Start_Times.add(rs.getString(2));
                   End_Times.add(rs.getString(3));
                   }                   
                   for(int i = 0; i < Work_Dates.size(); i++){
                       dropdownRowID.addItem(Work_Dates.get(i).toString());
                   }
                }catch (Exception e) {
                    System.out.println("SQL Exception: "+ e.toString());
                }
                break;
            case "workorder":
                lblFormName.setText("Edit Work Order");
                dropdownAttribute.addItem("Work_Date");
                dropdownAttribute.addItem("Party_ID");
                dropdownAttribute.addItem("Setup");
                dropdownAttribute.addItem("Takedown");
                dropdownAttribute.addItem("Order_Number");
                ArrayList<Date> Work_Dates = new ArrayList<Date>();
                ArrayList<Integer> Party_IDs = new ArrayList<Integer>();
                ArrayList<Boolean> Setups = new ArrayList<Boolean>();
                ArrayList<Boolean> Takedowns = new ArrayList<Boolean>();
                ArrayList<Integer> Order_Numbers = new ArrayList<Integer>();

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
                    Order_Numbers.add(rs.getInt(5));
                    }                    
                    for(int i = 0; i < Work_Dates.size(); i++){
                        dropdownRowID.addItem(Work_Dates.get(i) + ", " + Party_IDs.get(i) + ", " + Setups.get(i)+ ", " + Takedowns.get(i));
                    }                    
                }catch (Exception e) {
                    System.out.println("SQL Exception: "+ e.toString());
                }
                break;
            case "scheduling": 
                lblFormName.setText("Edit Scheduling");
                dropdownAttribute.addItem("Employee_ID");
                dropdownAttribute.addItem("Work_Day_Date");
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
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFormName = new javax.swing.JLabel();
        textfieldEdit = new javax.swing.JTextField();
        dropdownAttribute = new javax.swing.JComboBox<>();
        lblError = new javax.swing.JLabel();
        btnConfirm = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        dropdownRowID = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblFormName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFormName.setText("Edit TableName");

        textfieldEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textfieldEditActionPerformed(evt);
            }
        });

        dropdownAttribute.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select an Item" }));

        lblError.setText("jLabel1");

        btnConfirm.setText("Confirm");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        dropdownRowID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select an Item" }));

        jLabel1.setText("Row ID");

        jLabel2.setText("Atrribute to Edit");

        jLabel3.setText("New Value");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textfieldEdit)
                    .addComponent(dropdownAttribute, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dropdownRowID, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFormName, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblFormName, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel1)
                .addGap(2, 2, 2)
                .addComponent(dropdownRowID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dropdownAttribute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(2, 2, 2)
                .addComponent(textfieldEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblError)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirm)
                    .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void textfieldEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfieldEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textfieldEditActionPerformed

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        // TODO add your handling code here:
        String query = "";
        String [] keys;
        switch(currentTable.toLowerCase()){
            case "none":                
                break;
            case "tent_rental":
                keys = dropdownRowID.getSelectedItem().toString().split(",");                
                query = "UPDATE tent_rental SET "+ dropdownAttribute.getSelectedItem().toString() + " = " + 
                    textfieldEdit.getText() + "WHERE Tent_ID = " + keys[0] + " AND Party_ID = " + keys[1];
                
                break;
            case "tent":
                if(dropdownAttribute.getSelectedItem().toString().equals("Size") || dropdownAttribute.getSelectedItem().toString().equals("Square_Footage")){
                    query = "UPDATE tent SET " + dropdownAttribute.getSelectedItem().toString()+ 
                            " = '" + textfieldEdit.getText() + "' WHERE Tent_ID = " + 
                            dropdownRowID.getSelectedItem().toString();
                }else{
                    query = "UPDATE tent SET " + dropdownAttribute.getSelectedItem().toString()+ " = " + textfieldEdit.getText() + " WHERE Tent_ID = " + dropdownRowID.getSelectedItem().toString();
                }
                break;
            case "party":
                 if(dropdownAttribute.getSelectedItem().toString().equals("Location") || dropdownAttribute.getSelectedItem().toString().equals("Setup_Date") || dropdownAttribute.getSelectedItem().toString().equals("Takedown_Date")){
                    query = "UPDATE party SET " + dropdownAttribute.getSelectedItem().toString()+ 
                            " = '" + textfieldEdit.getText() + "' WHERE Party_ID = " + 
                            dropdownRowID.getSelectedItem().toString();
                }else{
                    query = "UPDATE party SET " + dropdownAttribute.getSelectedItem().toString()+ 
                            " = " + textfieldEdit.getText() + " WHERE Party_ID = " + 
                            dropdownRowID.getSelectedItem().toString();
                }
                break;
            case "customer":
                if(dropdownAttribute.getSelectedItem().toString().equals("CUSTOMER_FNAME") || dropdownAttribute.getSelectedItem().toString().equals("CUSTOMER_LNAME") || dropdownAttribute.getSelectedItem().toString().equals("CUSTOMER_PHONE") || dropdownAttribute.getSelectedItem().toString().equals("CUSTOMER_EMAIL")){
                    query = "UPDATE party SET " + dropdownAttribute.getSelectedItem().toString()+ 
                            " = '" + textfieldEdit.getText() + "' WHERE Customer_ID = " + 
                            dropdownRowID.getSelectedItem().toString();
                }else{
                    query = "UPDATE party SET " + dropdownAttribute.getSelectedItem().toString()+ 
                            " = " + textfieldEdit.getText() + " WHERE Customer_ID = " + 
                            dropdownRowID.getSelectedItem().toString();
                }
                break;
            case "employee":
                if(dropdownAttribute.getSelectedItem().toString().equals("Employee_FName") || dropdownAttribute.getSelectedItem().toString().equals("Employee_LName") || dropdownAttribute.getSelectedItem().toString().equals("Employee_Phone")){
                    query = "UPDATE employee SET " + dropdownAttribute.getSelectedItem().toString()+ 
                            " = '" + textfieldEdit.getText() + "' WHERE Employee_ID = " + 
                            dropdownRowID.getSelectedItem().toString();
                }else{
                    query = "UPDATE employee SET " + dropdownAttribute.getSelectedItem().toString()+ 
                            " = " + textfieldEdit.getText() + " WHERE Employee_ID = " + 
                            dropdownRowID.getSelectedItem().toString();
                }
                break;
            case "workday":
                query = "UPDATE workday SET " + dropdownAttribute.getSelectedItem().toString() + " = '" + textfieldEdit.getText()  + "' WHERE Work_Date = '" + dropdownRowID.getSelectedItem().toString() + "'";
                break;
            case "workorder":
                keys = dropdownRowID.getSelectedItem().toString().split(",");
                if(dropdownAttribute.getSelectedItem().toString().equals("Work_Date")){
                    query = "UPDATE workorder SET " + dropdownAttribute.getSelectedItem().toString() + "= '"+ textfieldEdit.getText() + "' WHERE Work_Date = '" + keys[0] + "' AND Party_ID = " + keys[1] + 
                        " AND Setup = " + keys[2] + " AND Takedown = " + keys[3];
                }else{
                    query = "UPDATE workorder SET " + dropdownAttribute.getSelectedItem().toString() + " = "+ textfieldEdit.getText() + " WHERE Work_Date = '" + keys[0] + "' AND Party_ID = " + keys[1] + 
                        " AND Setup = " + keys[2] + " AND Takedown = " + keys[3];
                }                
                break;
            case "scheduling":
                keys = dropdownRowID.getSelectedItem().toString().split(",");
                if(dropdownAttribute.getSelectedItem().toString().equals("Work_Day_Date")){
                    query = "UPDATE scheduling SET "+ dropdownAttribute.getSelectedItem().toString() + " = '"+ textfieldEdit.getText() + "' WHERE Employee_ID = " + keys[0] + " AND Work_Day_Date = '" + keys[1] + "'";
                }else{
                    query = "UPDATE scheduling SET "+ dropdownAttribute.getSelectedItem().toString() + " = "+ textfieldEdit.getText() + " WHERE Employee_ID = " + keys[0] + " AND Work_Day_Date = '" + keys[1] + "'";
                }                      
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
    }//GEN-LAST:event_btnConfirmActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JComboBox<String> dropdownAttribute;
    private javax.swing.JComboBox<String> dropdownRowID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblFormName;
    private javax.swing.JTextField textfieldEdit;
    // End of variables declaration//GEN-END:variables
}
