
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author lilmoe12
 */
public class AddForm extends javax.swing.JFrame {

    /**
     * Creates new form AddForm
     */
    String currentTable;
    String [] vals;
    String driver = "com.mysql.cj.jdbc.Driver";
    String un = "root";
    String pw = "Doubletrocks1";
    boolean adding = true;
    
    //Set the current table, set label texts, and set correct amount
    //of text boxes visible
    public AddForm(String currentTable) {
        this.currentTable = currentTable;
        initComponents();
        switch(this.currentTable){
            case "tent_rental":
                AddTableName.setText("Add Tent Rental");
                AddLabel1.setText("Tent ID:");
                AddTextBox1.setVisible(true);
                AddLabel2.setText("Party_ID");
                AddTextBox2.setVisible(true);
                AddLabel3.setText("");
                AddTextBox3.setVisible(false);
                AddLabel4.setText("");
                AddTextBox4.setVisible(false);
                AddLabel5.setText("");
                AddTextBox5.setVisible(false);
                AddLabel6.setText("");
                AddTextBox6.setVisible(false);
                AddLabel7.setText("");
                AddTextBox7.setVisible(false);
                AddLabel8.setText("");
                AddTextBox8.setVisible(false);
                break;
            case "tent":
                AddTableName.setText("Add Tent");
                AddLabel1.setText("Tent ID");
                AddTextBox1.setVisible(true);
                AddLabel2.setText("Size");
                AddTextBox2.setVisible(true);
                AddLabel3.setText("Num Stakes");
                AddTextBox3.setVisible(true);
                AddLabel4.setText("Num Poles");
                AddTextBox4.setVisible(true);
                AddLabel5.setText("Square Footage");
                AddTextBox5.setVisible(true);
                AddLabel6.setText("");
                AddTextBox6.setVisible(false);
                AddLabel7.setText("");
                AddTextBox7.setVisible(false);
                AddLabel8.setText("");
                AddTextBox8.setVisible(false);
                break;
            case "party":
                AddTableName.setText("Add Party");
                AddLabel1.setText("Party ID");
                AddTextBox1.setVisible(true);
                AddLabel2.setText("Customer ID");
                AddTextBox2.setVisible(true);
                AddLabel3.setText("Location");
                AddTextBox3.setVisible(true);
                AddLabel4.setText("Setup date (YYYY-MM-DD)");
                AddTextBox4.setVisible(true);
                AddLabel5.setText("Takedown date (YYYY-MM-DD)");
                AddTextBox5.setVisible(true);
                AddLabel6.setText("Cost");
                AddTextBox6.setVisible(true);
                AddLabel7.setText("Tables");
                AddTextBox7.setVisible(true);
                AddLabel8.setText("Chairs");
                AddTextBox8.setVisible(true);
                break;    
            case "employee":
                AddTableName.setText("Add Employee");
                AddLabel1.setText("Employee ID");
                AddTextBox1.setVisible(true);
                AddLabel2.setText("Employee F-Name");
                AddTextBox2.setVisible(true);
                AddLabel3.setText("Employee L-Name");
                AddTextBox3.setVisible(true);
                AddLabel4.setText("Employee Phone");
                AddTextBox4.setVisible(true);
                AddLabel5.setText("");
                AddTextBox5.setVisible(false);
                AddLabel6.setText("");
                AddTextBox6.setVisible(false);
                AddLabel7.setText("");
                AddTextBox7.setVisible(false);
                AddLabel8.setText("");
                AddTextBox8.setVisible(false);
                break;
            case "customer":
                AddTableName.setText("Add Customer");
                AddLabel1.setText("Customer ID");
                AddTextBox1.setVisible(true);
                AddLabel2.setText("Customer F-Name");
                AddTextBox2.setVisible(true);
                AddLabel3.setText("Customer L-Name");
                AddTextBox3.setVisible(true);
                AddLabel4.setText("Customer Phone");
                AddTextBox4.setVisible(true);
                AddLabel5.setText("Customer Email");
                AddTextBox5.setVisible(true);
                AddLabel6.setText("");
                AddTextBox6.setVisible(false);
                AddLabel7.setText("");
                AddTextBox7.setVisible(false);
                AddLabel8.setText("");
                AddTextBox8.setVisible(false);
                break;
            case "workday":
                AddTableName.setText("Add Work Day");
                AddLabel1.setText("Work Date");
                AddTextBox1.setVisible(true);
                AddLabel2.setText("Start Time");
                AddTextBox2.setVisible(true);
                AddLabel3.setText("End Time");
                AddTextBox3.setVisible(true);
                AddLabel4.setText("");
                AddTextBox4.setVisible(false);
                AddLabel5.setText("");
                AddTextBox5.setVisible(false);
                AddLabel6.setText("");
                AddTextBox6.setVisible(false);
                AddLabel7.setText("");
                AddTextBox7.setVisible(false);
                AddLabel8.setText("");
                AddTextBox8.setVisible(false);
                break;
            case "workorder":
                AddTableName.setText("Add Work Order");
                AddLabel1.setText("Work Day Date");
                AddTextBox1.setVisible(true);
                AddLabel2.setText("Party ID");
                AddTextBox2.setVisible(true);
                AddLabel3.setText("Setup (true or false)");
                AddTextBox3.setVisible(true);
                AddLabel4.setText("Takedown (true or false)");
                AddTextBox4.setVisible(true);
                AddLabel5.setText("Order Number");
                AddTextBox5.setVisible(true);
                AddLabel6.setText("");
                AddTextBox6.setVisible(false);
                AddLabel7.setText("");
                AddTextBox7.setVisible(false);
                AddLabel8.setText("");
                AddTextBox8.setVisible(false);
                break;
            case "scheduling":
                AddTableName.setText("Add Scheduling");
                AddLabel1.setText("Employee ID");
                AddTextBox1.setVisible(true);
                AddLabel2.setText("Work Date");
                AddTextBox2.setVisible(true);
                AddLabel3.setText("");
                AddTextBox3.setVisible(false);
                AddLabel4.setText("");
                AddTextBox4.setVisible(false);
                AddLabel5.setText("");
                AddTextBox5.setVisible(false);
                AddLabel6.setText("");
                AddTextBox6.setVisible(false);
                AddLabel7.setText("");
                AddTextBox7.setVisible(false);
                AddLabel8.setText("");
                AddTextBox8.setVisible(false);
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

        AddTableName = new javax.swing.JLabel();
        AddLabel1 = new javax.swing.JLabel();
        AddTextBox1 = new javax.swing.JTextField();
        AddLabel2 = new javax.swing.JLabel();
        AddTextBox2 = new javax.swing.JTextField();
        AddLabel3 = new javax.swing.JLabel();
        AddTextBox3 = new javax.swing.JTextField();
        AddLabel4 = new javax.swing.JLabel();
        AddTextBox4 = new javax.swing.JTextField();
        AddLabel5 = new javax.swing.JLabel();
        AddTextBox5 = new javax.swing.JTextField();
        AddLabel6 = new javax.swing.JLabel();
        AddTextBox6 = new javax.swing.JTextField();
        AddLabel7 = new javax.swing.JLabel();
        AddTextBox7 = new javax.swing.JTextField();
        AddLabel8 = new javax.swing.JLabel();
        AddTextBox8 = new javax.swing.JTextField();
        DoneBtn = new javax.swing.JButton();
        CancelBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        AddTableName.setText("AddTableName");

        AddLabel1.setText("AddLabel1");

        AddLabel2.setText("AddLabel2");

        AddLabel3.setText("AddLabel3");

        AddLabel4.setText("AddLabel4");

        AddLabel5.setText("AddLabel5");

        AddLabel6.setText("AddLabel6");

        AddLabel7.setText("AddLabel7");

        AddLabel8.setText("AddLabel8");

        DoneBtn.setText("Done");
        DoneBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DoneBtnActionPerformed(evt);
            }
        });

        CancelBtn.setText("Cancel");
        CancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(DoneBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CancelBtn))
                    .addComponent(AddTextBox7, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddLabel8)
                    .addComponent(AddLabel7)
                    .addComponent(AddLabel6)
                    .addComponent(AddLabel5)
                    .addComponent(AddLabel4)
                    .addComponent(AddLabel2)
                    .addComponent(AddLabel1)
                    .addComponent(AddTableName, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddLabel3)
                    .addComponent(AddTextBox8)
                    .addComponent(AddTextBox1)
                    .addComponent(AddTextBox6)
                    .addComponent(AddTextBox5)
                    .addComponent(AddTextBox4)
                    .addComponent(AddTextBox3)
                    .addComponent(AddTextBox2))
                .addContainerGap(570, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(AddTableName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(AddLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AddTextBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(AddLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AddTextBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AddLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AddTextBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AddLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AddTextBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AddLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AddTextBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AddLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AddTextBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AddLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AddTextBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AddLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AddTextBox8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DoneBtn)
                    .addComponent(CancelBtn))
                .addContainerGap(199, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBtnActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        dispose();
        
    }//GEN-LAST:event_CancelBtnActionPerformed

    private void DoneBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DoneBtnActionPerformed
        // TODO add your handling code here:
        setValues(currentTable);
        setVisible(false);
    }//GEN-LAST:event_DoneBtnActionPerformed

    
    private void setValues(String currentTable){
        switch(currentTable){
            case "tent_rental":
                if((AddTextBox1.getText().equals("")) || (AddTextBox2.getText().equals(""))){
                    System.out.println("Error: No blank entries allowed");
                }else{
                    String[] values = {AddTextBox1.getText(), AddTextBox2.getText()};
                    vals = values;
                    insertIntoTable(currentTable, values);
                }
            case "tent":
                if((AddTextBox1.getText().equals(""))){
                    System.out.println("Error: Tend ID cannot be blank");
                }else{
                    String[] values = {AddTextBox1.getText(), AddTextBox2.getText(),
                    AddTextBox3.getText(), AddTextBox4.getText(), AddTextBox5.getText()};
                    vals = values;
                    insertIntoTable(currentTable, values);
                }
                break;
            case "party":
                if((AddTextBox1.getText().equals("")) || (AddTextBox2.getText().equals(""))){
                    System.out.println("Error: Party ID and Customer ID cannot be blank");
                }else{
                    String[] values = {AddTextBox1.getText(), AddTextBox2.getText(),
                    AddTextBox3.getText(), AddTextBox4.getText(), AddTextBox5.getText(),
                    AddTextBox6.getText(), AddTextBox7.getText(), AddTextBox8.getText()};
                    vals = values;
                    insertIntoTable(currentTable, values);
                }
                break;
            case "employee":
                if((AddTextBox1.getText().equals(""))){
                    System.out.println("Error: Employee ID cannot be blank");
                }else{
                    String[] values = {AddTextBox1.getText(), AddTextBox2.getText(),
                    AddTextBox3.getText(), AddTextBox4.getText()};
                    vals = values;
                    insertIntoTable(currentTable, values);
                }
                break;
            case "customer":
                if((AddTextBox1.getText().equals(""))){
                    System.out.println("Error: Customer ID cannot be blank");
                }else{
                    String[] values = {AddTextBox1.getText(), AddTextBox2.getText(),
                    AddTextBox3.getText(), AddTextBox4.getText(), AddTextBox5.getText()};
                    vals = values;
                    insertIntoTable(currentTable, values);
                }
                break;
            case "workday":
                if((AddTextBox1.getText().equals(""))){
                    System.out.println("Error: Date cannot be hlank");
                }else{
                    String[] values = {AddTextBox1.getText(), AddTextBox2.getText(),
                    AddTextBox3.getText()};
                    vals = values;
                    insertIntoTable(currentTable, values);
                }
                break;
            case "workorder":
                if((AddTextBox1.getText().equals("")) || (AddTextBox2.getText().equals("")) || (AddTextBox3.getText().equals("")) || (AddTextBox4.getText().equals(""))){
                    System.out.println("Error: Date, Party ID, Setup, and Takedown cannot be blank");
                }else{
                    String[] values = {AddTextBox1.getText(), AddTextBox2.getText(),
                    AddTextBox3.getText(), AddTextBox4.getText(), AddTextBox5.getText()};
                    vals = values;
                    insertIntoTable(currentTable, values);
                }
                break;
            case "scheduling":
                if((AddTextBox1.getText().equals("")) || (AddTextBox2.getText().equals("")) || (AddTextBox3.getText().equals("")) || (AddTextBox4.getText().equals(""))){
                    System.out.println("Error: No blank entries allowed");
                }else{
                    String[] values = {AddTextBox1.getText(), AddTextBox2.getText()};
                    vals = values;
                    insertIntoTable(currentTable, values);
                }
                break;
            default:
                 break;     
        }
    }
    private void insertIntoTable(String currentTable, String[] values){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectionURL = "jdbc:mysql://localhost:3306/patrickspartyrental";
            Connection conn;
            conn = DriverManager.getConnection(connectionURL, un, pw);
            Statement st = conn.createStatement();
            String query;
            switch(currentTable){
            case "tent_rental":
                query = "INSERT INTO tent_rental VALUES(" + Integer.parseInt(values[0])+ ",\"" + values[1] +"\")";
                st.executeUpdate(query);
                break;
            case "tent":
                query = "INSERT INTO tent VALUES(" + Integer.parseInt(values[0])+ ",'" + values[1] + "'," + 
                        Integer.parseInt(values[2]) + "," + Integer.parseInt(values[3]) +",'" + values[4] +"')";
                st.executeUpdate(query);
                break;
            case "party":
                query = "INSERT INTO party VALUES(" + Integer.parseInt(values[0])+ "," + Integer.parseInt(values[1]) + 
                        ",'" + values[2] +"','" + values[3] +"','" + values[4] + "'," + Integer.parseInt(values[5]) + "," +
                        Integer.parseInt(values[6]) +"," + Integer.parseInt(values[7]) +")";
                st.executeUpdate(query);
                break;
            case "employee":
                query = "INSERT INTO employee VALUES(" + Integer.parseInt(values[0])+ ",'" + values[1] +"','" + values[2] +"','" + values[3] + "')";               
                st.executeUpdate(query);
                break;
            case "customer":
                query = "INSERT INTO customer VALUES(" + Integer.parseInt(values[0])+ ",'" + values[1] +"','" + 
                        values[2] +"','" + values[3] + "','" + values[4] + "')";               
                st.executeUpdate(query);
                break;
            case "workday":
                query = "INSERT INTO workday VALUES(" + Integer.parseInt(values[0])+ ",'" + values[1] + "','" + values[2] +"')";
                st.executeUpdate(query);
                break;
            case "workorder":
                query = "INSERT INTO workorder VALUES('" + values[0]+ "'," + Integer.parseInt(values[1]) +",'" + 
                        values[2] +"','" + values[3] + "','" + values[4] + "')";
                st.executeUpdate(query);
                break;
            case "scheduling":
                query = "INSERT INTO scheudling VALUES(" + Integer.parseInt(values[0])+ ",'" + values[1] +"')";
                st.executeUpdate(query);
                break;
            default:
                break;       
        }
            
        }catch (Exception e) {
            System.out.println("SQL Exception: "+ e.toString());
        }
    
    }
    /**
     * @param args the command line arguments
     */
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
//            java.util.logging.Logger.getLogger(AddForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(AddForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(AddForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(AddForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new AddForm().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AddLabel1;
    private javax.swing.JLabel AddLabel2;
    private javax.swing.JLabel AddLabel3;
    private javax.swing.JLabel AddLabel4;
    private javax.swing.JLabel AddLabel5;
    private javax.swing.JLabel AddLabel6;
    private javax.swing.JLabel AddLabel7;
    private javax.swing.JLabel AddLabel8;
    private javax.swing.JLabel AddTableName;
    private javax.swing.JTextField AddTextBox1;
    private javax.swing.JTextField AddTextBox2;
    private javax.swing.JTextField AddTextBox3;
    private javax.swing.JTextField AddTextBox4;
    private javax.swing.JTextField AddTextBox5;
    private javax.swing.JTextField AddTextBox6;
    private javax.swing.JTextField AddTextBox7;
    private javax.swing.JTextField AddTextBox8;
    private javax.swing.JButton CancelBtn;
    private javax.swing.JButton DoneBtn;
    // End of variables declaration//GEN-END:variables
}
