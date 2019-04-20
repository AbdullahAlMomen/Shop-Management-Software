/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopstock;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author User
 */

public class PurchaseAndSaleDetail extends javax.swing.JFrame {

    /**
     * Creates new form PurchaseAndSaleDetail
     */
    String User;
    DatabaseConnection DbC = new DatabaseConnection();
    public PurchaseAndSaleDetail(String a) {
        initComponents();
        User=a;
        
          }
    PurchaseAndSaleDetail() {
        initComponents();
        
    }
    public void ChangeName(JTable table,int index,String col_name){
        JTableHeader th=table.getTableHeader();
        th.getColumnModel().getColumn(index).setHeaderValue(col_name);
        th.repaint();
    }
    public ArrayList<PurchaseVar> getPurchase()
    {
        ArrayList<PurchaseVar> PurchaseList = new ArrayList<PurchaseVar>();
        if(jXDatePicker1.getDate()==null||jXDatePicker2.getDate()==null){
            JOptionPane.showMessageDialog(null, "Please give both the Dates");
        }
        
        
        else{
            Date oDate1 = jXDatePicker1.getDate();        
            DateFormat oDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
            String szDate1 = oDateFormat1.format(oDate1);
            Date oDate2 = jXDatePicker2.getDate();        
            DateFormat oDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
            String szDate2 = oDateFormat2.format(oDate2);
            System.out.println(szDate1+" =come= "+szDate2);
            
            String sql="select ProductName,PurchaseDate,PurchaseQuantity,PurchasePrice,PurchaseTotal from PRODUCT,PURCHASE where PRODUCT.ProductId=PURCHASE.ProductId AND PurchaseDate BETWEEN '"+szDate1+"' AND '"+szDate2+"'";
            try{
                Statement pst =DbC.connection().createStatement();
                ResultSet rs=pst.executeQuery(sql);
                PurchaseVar user;

               while(rs.next())
               {
                   user = new PurchaseVar(rs.getString("ProductName"),rs.getString("PurchaseDate"),rs.getInt("PurchaseQuantity"),rs.getFloat("PurchasePrice"),rs.getFloat("PurchaseTotal"));
                   PurchaseList.add(user);
               }
               DbC.connection().close();

            } 
            catch (Exception e) {
               e.printStackTrace();
            }
            
        }
        return PurchaseList;
    }
    public void show_Purchase_table(){
        ChangeName(SaleTable,1,"Purchase Date");
        ChangeName(SaleTable,2,"Purchase Quantity");
        ChangeName(SaleTable,3,"Purchase Price");
        ChangeName(SaleTable,4,"Purchase Sum");
        DefaultTableModel model=(DefaultTableModel)SaleTable.getModel();
        model.setRowCount(0);
        ArrayList<PurchaseVar> list=getPurchase();
        
        Object[] row = new Object[5];
        for(int i=0;i<list.size();i++){
            row[0]=list.get(i).getProductName();
            row[1]=list.get(i).getPurchaseDate();
            row[2]=list.get(i).getPurchaseQuantity();
            row[3]=list.get(i).getPurchasePrice();
            row[4]=list.get(i).getPurchaseTotal();
            model.addRow(row);
        }
        SaleTable.setModel(model);
        model.fireTableDataChanged();
        //model.fireTableDataChanged();
    }
    public ArrayList<SaleVar> getSale()
    {
        ArrayList<SaleVar> SaleList = new ArrayList<SaleVar>();
       
            Date oDate1 = jXDatePicker1.getDate();        
            DateFormat oDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
            String szDate1 = oDateFormat1.format(oDate1);
            Date oDate2 = jXDatePicker2.getDate();        
            DateFormat oDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
            String szDate2 = oDateFormat2.format(oDate2);
            System.out.println(szDate1+" =come= "+szDate2);
            
            String sql="select ProductName,SaleDate,SaleQuantity,SalePrice,SaleTotal from PRODUCT,Sale where PRODUCT.ProductId=Sale.ProductId AND SaleDate BETWEEN '"+szDate1+"' AND '"+szDate2+"'";
            try{
                Statement pst =DbC.connection().createStatement();
                ResultSet rs=pst.executeQuery(sql);
                SaleVar user;

               while(rs.next())
               {
                   user = new SaleVar(rs.getString("ProductName"),rs.getString("SaleDate"),rs.getInt("SaleQuantity"),rs.getFloat("SalePrice"),rs.getFloat("SaleTotal"));
                   SaleList.add(user);
               }
               DbC.connection().close();

            } 
            catch (Exception e) {
               e.printStackTrace();
            }
        return SaleList;
    }
    
    public void show_Sale_table(){
        ChangeName(SaleTable,1,"Sale Date");
        ChangeName(SaleTable,2,"Sale Quantity");
        ChangeName(SaleTable,3,"Sale Price");
        ChangeName(SaleTable,4,"Sale Sum");
        DefaultTableModel model=(DefaultTableModel)SaleTable.getModel();
        model.setRowCount(0);
        ArrayList<SaleVar> list=getSale();
        
        Object[] row = new Object[5];
        for(int i=0;i<list.size();i++){
            row[0]=list.get(i).getProductName();
            row[1]=list.get(i).getSaleDate();
            row[2]=list.get(i).getSaleQuantity();
            row[3]=list.get(i).getSalePrice();
            row[4]=list.get(i).getSaleTotal();
            model.addRow(row);
        }
        SaleTable.setModel(model);
        model.fireTableDataChanged();
        //model.fireTableDataChanged();
    }
    public ArrayList<DamageVar> getDamage()
    {
        ArrayList<DamageVar> DamageList = new ArrayList<DamageVar>();
       
            Date oDate1 = jXDatePicker1.getDate();        
            DateFormat oDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
            String szDate1 = oDateFormat1.format(oDate1);
            Date oDate2 = jXDatePicker2.getDate();        
            DateFormat oDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
            String szDate2 = oDateFormat2.format(oDate2);
            
            String sql="select ProductName,DamageDate,DamageQuantity,DamagePrice,DamageTotal from PRODUCT,DAMAGE where PRODUCT.ProductId=DAMAGE.ProductId AND DamageDate BETWEEN '"+szDate1+"' AND '"+szDate2+"'";
            try{
                Statement pst =DbC.connection().createStatement();
                ResultSet rs=pst.executeQuery(sql);
                DamageVar user;

               while(rs.next())
               {
                   user = new DamageVar(rs.getString("ProductName"),rs.getString("DamageDate"),rs.getInt("DamageQuantity"),rs.getFloat("DamagePrice"),rs.getFloat("DamageTotal"));
                   DamageList.add(user);
               }
               DbC.connection().close();

            } 
            catch (Exception e) {
               e.printStackTrace();
            }
        return DamageList;
    }
    
    public void show_Damage_table(){
        ChangeName(SaleTable,1,"Damage Date");
        ChangeName(SaleTable,2,"Damage Quantity");
        ChangeName(SaleTable,3,"Damage Price");
        ChangeName(SaleTable,4,"Damage Sum");
        DefaultTableModel model=(DefaultTableModel)SaleTable.getModel();
        model.setRowCount(0);
        ArrayList<DamageVar> list=getDamage();
        
        Object[] row = new Object[5];
        for(int i=0;i<list.size();i++){
            row[0]=list.get(i).getProductName();
            row[1]=list.get(i).getDamageDate();
            row[2]=list.get(i).getDamageQuantity();
            row[3]=list.get(i).getDamagePrice();
            row[4]=list.get(i).getDamageTotal();
            model.addRow(row);
        }
        SaleTable.setModel(model);
        model.fireTableDataChanged();
        //model.fireTableDataChanged();
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
        SaleTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        jXDatePicker2 = new org.jdesktop.swingx.JXDatePicker();
        PurchaseShow = new javax.swing.JButton();
        TotalLabel = new javax.swing.JLabel();
        TotalSaleText = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        PurchaseShow1 = new javax.swing.JButton();
        PurchaseShow2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1200, 600));
        setMinimumSize(new java.awt.Dimension(1200, 600));
        setResizable(false);

        SaleTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Name", "Sale Date", "SaleQuantity", "Sale Price", "Sale Sum"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        SaleTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(SaleTable);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("From");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("To");

        jXDatePicker1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXDatePicker1ActionPerformed(evt);
            }
        });

        jXDatePicker2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXDatePicker2ActionPerformed(evt);
            }
        });

        PurchaseShow.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PurchaseShow.setText("Show Purchase");
        PurchaseShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PurchaseShowActionPerformed(evt);
            }
        });

        TotalLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        TotalLabel.setText("Total");

        TotalSaleText.setEditable(false);
        TotalSaleText.setBackground(new java.awt.Color(51, 255, 255));
        TotalSaleText.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        TotalSaleText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalSaleTextActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/shopstock/back.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        PurchaseShow1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PurchaseShow1.setText("Show Sale");
        PurchaseShow1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PurchaseShow1ActionPerformed(evt);
            }
        });

        PurchaseShow2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PurchaseShow2.setText("Show Damage");
        PurchaseShow2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PurchaseShow2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TotalLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TotalSaleText, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jXDatePicker2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(PurchaseShow2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(PurchaseShow1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(PurchaseShow, javax.swing.GroupLayout.Alignment.LEADING))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 817, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXDatePicker2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addComponent(PurchaseShow)
                        .addGap(18, 18, 18)
                        .addComponent(PurchaseShow1)
                        .addGap(18, 18, 18)
                        .addComponent(PurchaseShow2)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TotalLabel)
                    .addComponent(TotalSaleText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(124, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jXDatePicker1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXDatePicker1ActionPerformed
        // TODO add your handling code here:
        jXDatePicker1.setFormats(new String[]{"yyyy-MM-dd"});
    }//GEN-LAST:event_jXDatePicker1ActionPerformed

    private void jXDatePicker2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXDatePicker2ActionPerformed
        // TODO add your handling code here:
        jXDatePicker2.setFormats(new String[]{"yyyy-MM-dd"});
    }//GEN-LAST:event_jXDatePicker2ActionPerformed

    private void PurchaseShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PurchaseShowActionPerformed
        // TODO add your handling code here:
        show_Purchase_table();
        
        Date oDate1 = jXDatePicker1.getDate();        
        DateFormat oDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        String szDate1 = oDateFormat1.format(oDate1);
        Date oDate2 = jXDatePicker2.getDate();       
        DateFormat oDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
        String szDate2 = oDateFormat2.format(oDate2);
        
        float PurchaseSum=0;
        try{
            
            
            String sql3="SELECT SUM(PurchaseTotal) AS TS FROM PURCHASE WHERE PurchaseDate BETWEEN '"+szDate1+"' AND '"+szDate2+"'";
            PreparedStatement st =DbC.connection().prepareStatement(sql3);

            ResultSet rs=st.executeQuery();
                    if(rs.next()){
                    PurchaseSum= rs.getFloat("TS");
                    }
                    System.out.println(PurchaseSum);
                    TotalLabel.setText("Total Purchase");
                    TotalSaleText.setHorizontalAlignment(SwingConstants.RIGHT);
                    TotalSaleText.setText(Float.toString(PurchaseSum));
                    DbC.connection().close();
        }
        catch(SQLException ex){
            
        }
        
        /*int benifit=SaleSum-PurchaseSum;
        BenifitShow.setHorizontalAlignment(SwingConstants.CENTER);
        BenifitShow.setText("Benifit From "+szDate1+" to "+szDate2+" is "+benifit);
        */
    }//GEN-LAST:event_PurchaseShowActionPerformed

    private void TotalSaleTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalSaleTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TotalSaleTextActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        AdminWorkingWin ob= new AdminWorkingWin(User);
        this.setVisible(false);
        ob.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void PurchaseShow1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PurchaseShow1ActionPerformed
        // TODO add your handling code here:
        show_Sale_table();
        Date oDate1 = jXDatePicker1.getDate();        
        DateFormat oDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        String szDate1 = oDateFormat1.format(oDate1);
        Date oDate2 = jXDatePicker2.getDate();       
        DateFormat oDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
        String szDate2 = oDateFormat2.format(oDate2);
        float SaleSum=0;
        try{
            String sql3="SELECT SUM(SaleTotal) AS TS FROM Sale WHERE SaleDate BETWEEN '"+szDate1+"' AND '"+szDate2+"'";
            PreparedStatement st =DbC.connection().prepareStatement(sql3);

            ResultSet rs=st.executeQuery();
                    if(rs.next()){
                    SaleSum= rs.getFloat("TS");
                    }
                    System.out.println(SaleSum);
                    TotalLabel.setText("Total Sale");
                    TotalSaleText.setHorizontalAlignment(SwingConstants.RIGHT);
                    TotalSaleText.setText(Float.toString(SaleSum));
                    DbC.connection().close();
        }
        catch(SQLException ex){
            
        }
    }//GEN-LAST:event_PurchaseShow1ActionPerformed

    private void PurchaseShow2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PurchaseShow2ActionPerformed
        // TODO add your handling code here:
        show_Damage_table();
        Date oDate1 = jXDatePicker1.getDate();        
        DateFormat oDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        String szDate1 = oDateFormat1.format(oDate1);
        Date oDate2 = jXDatePicker2.getDate();       
        DateFormat oDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
        String szDate2 = oDateFormat2.format(oDate2);
        float DamageSum=0;
        try{
            String sql3="SELECT SUM(DamageTotal) AS TS FROM DAMAGE WHERE DamageDate BETWEEN '"+szDate1+"' AND '"+szDate2+"'";
            PreparedStatement st =DbC.connection().prepareStatement(sql3);

            ResultSet rs=st.executeQuery();
                    if(rs.next()){
                    DamageSum= rs.getFloat("TS");
                    }
                    System.out.println(DamageSum);
                    TotalLabel.setText("Total Damage");
                    TotalSaleText.setHorizontalAlignment(SwingConstants.RIGHT);
                    TotalSaleText.setText(Float.toString(DamageSum));
                    DbC.connection().close();
        }
        catch(SQLException ex){
            
        }
    }//GEN-LAST:event_PurchaseShow2ActionPerformed

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
            java.util.logging.Logger.getLogger(PurchaseAndSaleDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PurchaseAndSaleDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PurchaseAndSaleDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PurchaseAndSaleDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PurchaseAndSaleDetail().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton PurchaseShow;
    private javax.swing.JButton PurchaseShow1;
    private javax.swing.JButton PurchaseShow2;
    private javax.swing.JTable SaleTable;
    private javax.swing.JLabel TotalLabel;
    private javax.swing.JTextField TotalSaleText;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker2;
    // End of variables declaration//GEN-END:variables
}
