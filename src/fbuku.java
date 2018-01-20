/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * fbuku.java
 *
 * Created on Oct 2, 2015, 11:14:42 AM
 */


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author asus
 */
public class fbuku extends javax.swing.JInternalFrame {
    Connection con;
    Statement stmt;
    ResultSet rs;
    ResultSetMetaData meta;
    String[] header = {"Id Buku","Judul Buku","Penulis","Tahun Terbit","Kategori","Deskripsi"};
    String[] header1 = {"Nama Kategori"};
    String[] header2 = {"Nama Penulis"};
    String[][] dataTable;
    int id,a;
            

    /** Creates new form fbuku */
    public fbuku() {
        initComponents();
        koneksi();
//        no();
        tampilPnls();
        //tampilData();
        txtpenulis.disable();
        ID();
        txtkat.disable();
        txtid.disable();
        tampilKtgr();
    }

      void koneksi() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/perpustakaan","root","");
            System.out.println("Koneksi database berhasil");
        } catch (ClassNotFoundException eclass) {
            System.out.println("Driver tidak ada");
        } catch (SQLException esql) {
            System.out.println(esql.getMessage());
        }
    }
       
      public void ID(){
        try{ 
            stmt=(Statement) con.createStatement();
            rs=stmt.executeQuery("select id_buku from buku where id_buku=(select max(id_buku)from buku)");
            while(rs.next()){
                txtid.setText(rs.getString("id_buku"));
            }
            
            id = Integer.parseInt(txtid.getText());
              a  = 1;
        txtid.setText(String.valueOf(id+a));
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
   
     
      
      void simpan(){
          try{
             String sql = "Insert Into buku set id_buku = \"" + txtid.getText() + "\","
                    + "judul_buku= \"" + txtjudul.getText() + "\","
                    + "penulis= \"" + txtpenulis.getText() + "\","
                    + "tahun_terbit= \"" + txtthn.getText() + "\","
                    + "kategori= \"" + txtkat.getText() + "\","
                    + "deskripsi= \"" + txtdesk.getText() + "\"";
            
            stmt = (Statement) con.createStatement();
            stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
            System.out.println("berhasil menyimpan"); 
              
              
              
          }catch(Exception e){
              System.out.println(e);
          }
          //tampilData();
          txtid.setText("");
          txtjudul.setText("");
          txtpenulis.setText("");
          txtthn.setText("");
          txtdesk.setText("");
         txtkat.setText("") ;
      }
      
       void hapusData() {

        try {
            String sql = "DELETE FROM buku WHERE  id_buku = \"" + txtid.getText()+"\"";
             stmt = (Statement) con.createStatement();
            stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
            System.out.println("berhasil  dihapus");
        } catch (Exception e) {
            System.out.println(e);
        }
//         tampilData();
          txtid.setText("");
          txtjudul.setText("");
          txtpenulis.setText("");
          txtthn.setText("");
          txtdesk.setText("");
         txtkat.setText("") ;
    }

    private void ubahData() {
          try {
            String sql = "UPDATE buku set id_buku = \"" + txtid.getText() + "\","
                    + "judul_buku= \"" + txtjudul.getText() + "\","
                    + "penulis= \"" + txtpenulis.getText() + "\","
                    + "tahun_terbit= \"" + txtthn.getText() + "\","
                    + "kategori= \"" + txtkat.getText()  + "\","
                    + "deskripsi= \"" + txtdesk.getText() + "\" WHERE id_buku = \"" + txtid.getText() + "\"";
             stmt = (Statement) con.createStatement();
            stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Data berhasil diubah");
            System.out.println("berhasil  diupdate");
        } catch (Exception e) {
            System.out.println(e);
        }
 //         tampilData();
          txtid.setText("");
          txtjudul.setText("");
          txtpenulis.setText("");
          txtthn.setText("");
          txtdesk.setText("");
          txtkat.setText("") ;
    }
   
    void tampilPnls(){
         try{
             stmt = (Statement) con.createStatement();
            rs = stmt.executeQuery("select * from penulis");

            meta = (ResultSetMetaData) rs.getMetaData();
            int col = meta.getColumnCount();
            int baris = 0;
            while(rs.next()) {
                baris = rs.getRow();
            }
            dataTable = new String [baris][col];
            int x = 0;
            rs.beforeFirst();
            while(rs.next()) {
                dataTable[x][0] = rs.getString("nama_penulis");
                
                x++;
} 
            tblpnls.setModel(new DefaultTableModel(dataTable,header2));
             
         }catch(Exception e){
             System.out.println(e);
         }
     }
    
     
     void tampilKtgr(){
         try{
             stmt = (Statement) con.createStatement();
            rs = stmt.executeQuery("select * from kategori");

            meta = (ResultSetMetaData) rs.getMetaData();
            int col = meta.getColumnCount();
            int baris = 0;
            while(rs.next()) {
                baris = rs.getRow();
            }
            dataTable = new String [baris][col];
            int x = 0;
            rs.beforeFirst();
            while(rs.next()) {
                
                dataTable[x][0] = rs.getString("nama_kategori");
                
                x++;
} 
            tblktgr.setModel(new DefaultTableModel(dataTable,header1));
             
         }catch(Exception e){
             System.out.println(e);
         }
     }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtjudul = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtpenulis = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtthn = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtdesk = new javax.swing.JTextArea();
        txtkat = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblpnls = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblktgr = new javax.swing.JTable();

        setClosable(true);

        jPanel1.setBackground(java.awt.SystemColor.activeCaption);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Data Buku");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(235, 235, 235))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jPanel3.setBackground(java.awt.SystemColor.activeCaption);
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Segoe UI Semilight", 1, 12)); // NOI18N
        jLabel2.setText("Id Buku");

        txtid.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI Semilight", 1, 12)); // NOI18N
        jLabel3.setText("Judul Buku");

        txtjudul.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI Semilight", 1, 12)); // NOI18N
        jLabel4.setText("Kategori");

        jLabel6.setFont(new java.awt.Font("Segoe UI Semilight", 1, 12)); // NOI18N
        jLabel6.setText("Penulis");

        txtpenulis.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI Semilight", 1, 12)); // NOI18N
        jLabel7.setText("Tahun Terbit");

        txtthn.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI Semilight", 1, 12)); // NOI18N
        jLabel8.setText("Deskripsi");

        txtdesk.setColumns(20);
        txtdesk.setRows(5);
        jScrollPane2.setViewportView(txtdesk);

        txtkat.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel5)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8))))
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtpenulis)
                                .addComponent(txtjudul))
                            .addComponent(txtthn, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(285, 285, 285))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtkat, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtjudul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtpenulis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(5, 5, 5)
                        .addComponent(jLabel7))
                    .addComponent(txtthn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtkat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(java.awt.SystemColor.activeCaption);
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jButton2.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        jButton2.setText("Simpan");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        jButton3.setText("Ubah");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Segoe UI Semilight", 1, 12)); // NOI18N
        jButton4.setText("Hapus");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        jPanel10.setBackground(java.awt.SystemColor.activeCaption);
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel11.setFont(new java.awt.Font("Segoe UI Semilight", 1, 12)); // NOI18N
        jLabel11.setText("Pencarian");

        jTextField5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField5KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblpnls.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        tblpnls.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Nama Penulis"
            }
        ));
        tblpnls.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblpnlsMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblpnls);

        jPanel11.setBackground(java.awt.SystemColor.activeCaption);
        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel12.setFont(new java.awt.Font("Segoe UI Semilight", 1, 12)); // NOI18N
        jLabel12.setText("Pencarian");

        jTextField6.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField6KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField6, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblktgr.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        tblktgr.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Nama Kategori"
            }
        ));
        tblktgr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblktgrMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblktgr);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, 0, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

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
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
               simpan();
}//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
                ubahData();
}//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
             hapusData();
}//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyPressed
        // TODO add your handling code here:
        try{
            stmt = (Statement) con.createStatement();
            rs = stmt.executeQuery("select * from penulis  where nama_penulis like '%" +jTextField5.getText()+"%'");
            
            ResultSetMetaData metadata = (ResultSetMetaData) rs.getMetaData();
            int col = metadata.getColumnCount();
            int baris = 0;
            while(rs.next()) {
                baris = rs.getRow();
            }
            dataTable = new String [baris][col];
            int x = 0;
            rs.beforeFirst();
            while(rs.next()) {
                dataTable[x][0] = rs.getString("nama_penulis");
                
                x++;
            }
            tblpnls.setModel(new DefaultTableModel(dataTable,header2));
        }catch(Exception e){
            System.out.println(e);
        }
}//GEN-LAST:event_jTextField5KeyPressed

    private void tblpnlsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblpnlsMouseClicked
        // TODO add your handling code here:
        int row = tblpnls.getSelectedRow();
       
        String nama = tblpnls.getValueAt(row, 0).toString();
        
   
        txtpenulis.setText(nama);
}//GEN-LAST:event_tblpnlsMouseClicked

    private void jTextField6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyPressed
        // TODO add your handling code here:
        try{
            stmt = (Statement) con.createStatement();
            rs = stmt.executeQuery("select * from kategori  where nama_kategori like '%" +jTextField6.getText()+"%'");
            
            meta = (ResultSetMetaData) rs.getMetaData();
            int col = meta.getColumnCount();
            int baris = 0;
            while(rs.next()) {
                baris = rs.getRow();
            }
            dataTable = new String [baris][col];
            int x = 0;
            rs.beforeFirst();
            while(rs.next()) {
                
                dataTable[x][0] = rs.getString("nama_kategori");
                
                x++;
} 
            tblktgr.setModel(new DefaultTableModel(dataTable,header1));
             
         }catch(Exception e){
             System.out.println(e);
         }
}//GEN-LAST:event_jTextField6KeyPressed

    private void tblktgrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblktgrMouseClicked
        // TODO add your handling code here:
        int row = tblktgr.getSelectedRow();
        String kt = tblktgr.getValueAt(row, 0).toString();
        
       
        txtkat.setText(kt) ;
}//GEN-LAST:event_tblktgrMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTable tblktgr;
    private javax.swing.JTable tblpnls;
    private javax.swing.JTextArea txtdesk;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtjudul;
    private javax.swing.JTextField txtkat;
    private javax.swing.JTextField txtpenulis;
    private javax.swing.JTextField txtthn;
    // End of variables declaration//GEN-END:variables
}
