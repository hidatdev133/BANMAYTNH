package GUI;

import BLL.chitietdhBLL;
import BLL.hoadonBLL;
import BLL.khachhangBLL;
import BLL.sanphamBLL;
import DAL.chitietdhDAL;
import DBUtils.DBUtils;
import DAL.taikhoanDAL;
import DAL.sanphamDAL;
import DAL.dathangDAL;
import DAL.hoadonDAL;
import DAL.khachhangDAL;
import DTO.chitietdhDTO;
import DTO.hoadonDTO;
import DTO.khachhangDTO;
import DTO.taikhoanDTO;
import DTO.sanphamDTO;
import DTO.sanphamDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class dathangGUI extends javax.swing.JFrame {
    
    DefaultComboBoxModel<sanphamDTO> comboBoxModel = new DefaultComboBoxModel<>();
    DefaultTableModel dskh = new DefaultTableModel();
    DefaultTableModel dsdh = new DefaultTableModel();
    String idKhachhang = "-1";
    int tongtien = 0;
    
    public dathangGUI() {
        initComponents();
        dskh.addColumn("Mã khách hàng");
        dskh.addColumn("Tên khách hàng");
        dskh.addColumn("Trạng thái");
        jtlkhachhang.setModel(dsdh);
        DSkhachhang();
        
        dsdh.addColumn("STT");
        dsdh.addColumn("Tên sản phẩm");
        dsdh.addColumn("Giá");
        dsdh.addColumn("Số lượng");
        dsdh.addColumn("Thành tiền");
        jtldathang.setModel(dsdh);
        DSdathang();
        
        sanphamDTO dssp = new sanphamDTO(-1, "---- Chọn sản phẩm ----");
        comboBoxModel.addElement(dssp);
        cboSanPham.setModel(comboBoxModel);
        loadSanpham();
        
        
        
        
        
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtlkhachhang = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtldathang = new javax.swing.JTable();
        btnPay = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tfTongTien = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        cboSanPham = new javax.swing.JComboBox();
        spnSoluong = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnBack.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/back.png"))); // NOI18N
        btnBack.setText("TRỞ VỀ");
        btnBack.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBack.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jtlkhachhang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtlkhachhang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtlkhachhangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtlkhachhang);

        jtldathang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtldathang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtldathangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtldathang);

        btnPay.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnPay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/payment.png"))); // NOI18N
        btnPay.setText("THANH TOÁN");
        btnPay.setEnabled(false);
        btnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/remove.png"))); // NOI18N
        jButton3.setText("ĐÓNG");
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/exit.png"))); // NOI18N
        jButton4.setText("THOÁT");
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel1.setText("TỔNG TIỀN:");

        tfTongTien.setText("                                                   0");
        tfTongTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTongTienActionPerformed(evt);
            }
        });

        btnThem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/add.png"))); // NOI18N
        btnThem.setText("THÊM");
        btnThem.setEnabled(false);
        btnThem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnThem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        cboSanPham.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cboSanPham.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSanPhamActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/order.png"))); // NOI18N
        jLabel2.setText("ĐẶT HÀNG");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(224, 224, 224)
                        .addComponent(jLabel2))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spnSoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(tfTongTien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(btnPay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)))
                .addGap(0, 2, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(46, 46, 46)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(cboSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(spnSoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnPay)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(43, 43, 43)
                                    .addComponent(tfTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(btnBack, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void loadSanpham() {
                ArrayList<sanphamDTO> sanpham = sanphamDAL.getInstance().getAllsanpham();
                for (sanphamDTO sanphamdto : sanpham) {
                        comboBoxModel.addElement(sanphamdto);
                }
        }
    private void tfTongTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTongTienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTongTienActionPerformed

    private void jtlkhachhangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtlkhachhangMouseClicked
        int row = jtlkhachhang.getSelectedRow();
            btnThem.setEnabled(true);
            if ((jtlkhachhang.getValueAt(row, 2) + "").equals("Chờ thanh toán")) {
                    btnPay.setEnabled(true);
            } else {
                    btnPay.setEnabled(false);
            }
            ArrayList<khachhangDTO> id = khachhangDAL.getInstance().getAllkhachhang();
            idKhachhang = id.get(row).getMakhachhang();
            DSdathang();
        
    }//GEN-LAST:event_jtlkhachhangMouseClicked

    private void jtldathangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtldathangMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jtldathangMouseClicked

    private void cboSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSanPhamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboSanPhamActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        adminmenuGUI qlc = new adminmenuGUI();
        this.setVisible(false);
        qlc.setLocationRelativeTo(qlc);
        qlc.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
            int idhoadon = hoadonDAL.getInstance().getuncheckHoadonByidkhachhang(idKhachhang);
            sanphamDTO sanpham = (sanphamDTO) cboSanPham.getSelectedItem();
            if (idhoadon == -1) {
                    hoadonDAL.getInstance().inserthoadon(idKhachhang);
                    dathangDAL.getInstance().insertdathang(sanpham.getMasanpham(), hoadonDAL.getInstance().GetMaxIdInvoice(), Integer.parseInt(spnSoluong.getValue().toString()));
            } else {
                    dathangDAL.getInstance().insertdathang(sanpham.getMasanpham(), idhoadon, Integer.parseInt(spnSoluong.getValue().toString()));
            }
            khachhangDAL.getInstance().updatethemkhachhang(idKhachhang);
            DSkhachhang();
            DSdathang();
            btnPay.setEnabled(true);
            cboSanPham.setSelectedIndex(0);
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayActionPerformed
        // TODO add your handling code here:
        int idhoadon = hoadonDAL.getInstance().getuncheckHoadonByidkhachhang(idKhachhang);
        hoadonDAL.getInstance().update(idhoadon, tongtien);
        khachhangDAL.getInstance().updatepaykhachhang(idKhachhang);
        DSkhachhang();
        DSdathang();
    }//GEN-LAST:event_btnPayActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int qes;
        qes = JOptionPane.showConfirmDialog(null, "Bạn có muốn tiếp tục không?", "Question", JOptionPane.YES_NO_OPTION);
        if (qes == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dangnhapGUI dangnhap = new dangnhapGUI();
        this.setVisible(false);
        dangnhap.setLocationRelativeTo(dangnhap);
        dangnhap.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(dathangGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dathangGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dathangGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dathangGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dathangGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnPay;
    private javax.swing.JButton btnThem;
    private javax.swing.JComboBox cboSanPham;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtldathang;
    private javax.swing.JTable jtlkhachhang;
    private javax.swing.JSpinner spnSoluong;
    private javax.swing.JTextField tfTongTien;
    // End of variables declaration//GEN-END:variables

    private void DSkhachhang() {
        ArrayList<khachhangDTO> khachhangarr = new ArrayList<>();
        khachhangBLL khachhangbll = new khachhangBLL();
        khachhangarr = khachhangbll.getAllkhachhang();
        khachhangDTO khachhangdto = new khachhangDTO();
        dskh.setRowCount(0);
        for (int i = 0; i < khachhangarr.size(); i++) {
            khachhangdto = khachhangarr.get(i);
            String makhachhang = khachhangdto.getMakhachhang();
            String tenkhachhang = khachhangdto.getTenkhachhang();
            String trangthai = khachhangdto.getTrangthai();
            Object[] row = {makhachhang, tenkhachhang, trangthai};
            dskh.addRow(row);
        }
        jtlkhachhang.setModel(dskh);
    }

    private void DSdathang() {
        dsdh.setRowCount(0);
        List<chitietdhDTO> listMenu = chitietdhDAL.getInstance().getchitietdhByidkhachhang(idKhachhang);
                for (int i = 0; i < listMenu.size(); i++) {
                    chitietdhDTO menu = listMenu.get(i);
                    Object[] dt = {i + 1, menu.getTensanpham(), menu.getGia(), menu.getSoluong(), menu.getThanhtien()};
                    tongtien += menu.getThanhtien();
                    dsdh.addRow(dt);
                }
                tfTongTien.setText(tongtien + "");
    }

}
