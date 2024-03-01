package GUI;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import BLL.hoadonBLL;
import BLL.sanphamBLL;
import DTO.hoadonDTO;
import DTO.sanphamDTO;
import DAL.sanphamDAL;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class hoadonGUI extends javax.swing.JFrame implements ActionListener{
    
    JComboBox cb;
    DefaultTableModel dssp = new DefaultTableModel();
    DefaultTableModel dshd = new DefaultTableModel();
    int tongtien =0;
    
    public hoadonGUI() {
        String[] loaisanpham = {"Loại", "Laptop", "Màn hình", "Chuột", "Bàn phím"};
        cb = new JComboBox(loaisanpham);
        cb.setBounds(750, 50, 113, 35);
        cb.addActionListener(this);
        this.add(cb);

        initComponents();
        
        jttensanpham.setEditable(false);
        jtgiasanpham.setEditable(false);
        jtthanhtien.setEditable(false);
        
        
        dssp.addColumn("Mã sản phẩm");
        dssp.addColumn("Tên sản phẩm");
        dssp.addColumn("Loại sản phẩm");
        dssp.addColumn("Giá sản phẩm");
        dssp.addColumn("Số lượng tồn");
        jtldssanpham.setModel(dssp);
        
        dshd.addColumn("Mã hóa đơn");
        dshd.addColumn("Mã khách hàng");
        dshd.addColumn("Tên khách hàng");
        dshd.addColumn("Số lượng");
        dshd.addColumn("Tên sản phẩm");
        dshd.addColumn("Giá sản phẩm");
        dshd.addColumn("Số lượng tồn");
        dshd.addColumn("Thành tiền");
        jtldsshoadon.setModel(dshd);
        
        DSsanpham();
        loadHoadonList();

    }
    
    public void loadHoadonList() {
        ArrayList<hoadonDTO> hoadonarr = new ArrayList<>();
        hoadonBLL hoadonbll = new hoadonBLL();
        hoadonarr = hoadonbll.getAllhoadon();
        hoadonDTO hoadondto = new hoadonDTO();
        dshd.setRowCount(0);
        for (int i = 0; i < hoadonarr.size(); i++) {
            hoadondto = hoadonarr.get(i);
            int mahoadon = hoadondto.getMahoadon();
            String makhachhang = hoadondto.getMakhachhang();
            String tenkhachhang = hoadondto.getTenkhachhang();
            int soluong = hoadondto.getSoluong();
            String tensanpham = hoadondto.getTensanpham();
            int giasanpham = hoadondto.getGiasanpham();
            int thanhtien = hoadondto.getSoluong()* hoadondto.getGiasanpham();
            Object[] row = {mahoadon, makhachhang, tenkhachhang, soluong, tensanpham, giasanpham, thanhtien };
            tongtien += thanhtien;
            
            dshd.addRow(row);
        }
        jtldsshoadon.setModel(dshd);
        jttongtien.setText(tongtien + " ");
    }

    private void DSsanpham() {
        dssp.setRowCount(0);

        ArrayList<sanphamDTO> sanphamarr = new ArrayList<>();
        sanphamBLL sanphambll = new sanphamBLL();
        sanphamarr = sanphambll.getAllsanpham();
        sanphamDTO sanphamdto = new sanphamDTO();
        for (int i = 0; i < sanphamarr.size(); i++) {
            sanphamdto = sanphamarr.get(i);
            int masanpham = sanphamdto.getMasanpham();
            String tensanpham = sanphamdto.getTensanpham();
            String loaisanpham = sanphamdto.getLoaisanpham();
            int giasanpham = sanphamdto.getGiasanpham();
            Object[] row = {masanpham, tensanpham, loaisanpham, giasanpham};
            dssp.addRow(row);
        }
        jtldssanpham.setModel(dssp);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnPay = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jttongtien = new javax.swing.JTextField();
        jtmakhachhang = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jttenkhachhang = new javax.swing.JTextField();
        jttensanpham = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtldssanpham = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtldsshoadon = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jtmahoadon = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnsearchhd = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jtthanhtien = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jtgiasanpham = new javax.swing.JTextField();
        jtsoluong = new javax.swing.JTextField();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("QUẢN LÝ ĐẶT HÀNG");

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/back.png"))); // NOI18N
        btnBack.setText("Trở về");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/order.png"))); // NOI18N
        jLabel1.setText("QUẢN LÝ HÓA ĐƠN");

        btnPay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/payment.png"))); // NOI18N
        btnPay.setText("THANH TOÁN");
        btnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("TỔNG TIỀN:");

        jttongtien.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jttongtien.setText("0");
        jttongtien.setEnabled(false);

        jLabel3.setText("Mã KH:");

        jLabel4.setText("Tên khách hàng:");

        jtldssanpham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtldssanpham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtldssanphamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtldssanpham);

        jtldsshoadon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtldsshoadon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtldsshoadonMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jtldsshoadon);

        jLabel8.setText("Tên sản phẩm:");

        jLabel9.setText("Số lượng:");

        jLabel11.setText("Mã HD:");

        jLabel13.setText("DANH SÁCH SẢN PHẨM:");

        jLabel12.setText("DANH SÁCH HÓA ĐƠN:");

        btnsearchhd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/search.png"))); // NOI18N
        btnsearchhd.setText("Tìm kiếm");
        btnsearchhd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchhdActionPerformed(evt);
            }
        });

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/edit.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/add.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/delete.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        jLabel14.setText("Thành tiền:");

        jtthanhtien.setEditable(false);
        jtthanhtien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtthanhtienActionPerformed(evt);
            }
        });

        jLabel15.setText("Giá sản phẩm:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel9))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jtmakhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jttenkhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jtsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel15)
                                                .addGap(18, 18, 18)
                                                .addComponent(jtgiasanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel14)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jtthanhtien, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jtmahoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(jttensanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 18, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnSua)
                                .addGap(36, 36, 36)
                                .addComponent(btnXoa)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(798, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnThem)
                        .addGap(316, 316, 316)
                        .addComponent(btnsearchhd))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1082, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(btnPay)
                            .addComponent(jttongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBack)
                                .addGap(44, 44, 44))
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(jtmahoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)
                                    .addComponent(jttensanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtmakhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15)
                                    .addComponent(jtgiasanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jttenkhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel14)
                                    .addComponent(jtthanhtien, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnThem)
                                        .addComponent(btnSua)
                                        .addComponent(btnXoa))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(btnsearchhd)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnPay)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jttongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        adminmenuGUI qlc = new adminmenuGUI();
        this.setVisible(false);
        qlc.setLocationRelativeTo(qlc);
        qlc.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if (jtmahoadon.getText().trim().equals("") || jtmakhachhang.getText().trim().equals("")
                || jttenkhachhang.getText().trim().equals("") || jttensanpham.getText().trim().equals("") 
                || jtsoluong.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đủ thông tin");
        } else {
            hoadonDTO hoadondto = new hoadonDTO();
            hoadondto.setMahoadon(Integer.parseInt(jtmahoadon.getText()));
            hoadondto.setMakhachhang(jtmakhachhang.getText());
            hoadondto.setTenkhachhang(jttenkhachhang.getText());
            hoadondto.setSoluong(Integer.parseInt(jtsoluong.getText().toString()));
            
            hoadonBLL hoadonbll = new hoadonBLL();
            int result = hoadonbll.updatehoadon(hoadondto);
            if (result != 0) {
                JOptionPane.showMessageDialog(this, "Cập nhật hóa đơn thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
            loadHoadonList();
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void search_hoadon(String keyword) {
        ArrayList<hoadonDTO> hoadonarr = new ArrayList<>();
        DefaultTableModel dtm = (DefaultTableModel) jtldsshoadon.getModel();
        dtm.setRowCount(0);

        hoadonBLL hoadonbll = new hoadonBLL();

        hoadonarr = hoadonbll.search_hoadon(keyword);

        hoadonDTO hoadondto = new hoadonDTO();
        for (int i = 0; i < hoadonarr.size(); i++) {
            hoadondto = hoadonarr.get(i);
            Object[] row = {hoadondto.getMahoadon(), hoadondto.getMakhachhang(), hoadondto.getTenkhachhang(), hoadondto.getSoluong()};
            dtm.addRow(row);
        }
    }

    private void btnsearchhdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchhdActionPerformed
        String keyword;
        if (jtmahoadon.getText().isEmpty() == false) {
            keyword = jtmahoadon.getText();
            search_hoadon(keyword);
        } else if (jtmakhachhang.getText().isEmpty() == false) {
            keyword = jtmakhachhang.getText();
            search_hoadon(keyword);
        } else if (jttenkhachhang.getText().isEmpty() == false) {
            keyword = jttenkhachhang.getText();
            search_hoadon(keyword);
        } else if (jtsoluong.getText() != null) {
            keyword = jtsoluong.getText().toString();
            search_hoadon(keyword);
        } else {
            loadHoadonList();
        }
    }//GEN-LAST:event_btnsearchhdActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
         if (jtmahoadon.getText().trim().equals("") || jtmakhachhang.getText().trim().equals("")
                || jttenkhachhang.getText().trim().equals("") || jttensanpham.getText().trim().equals("") 
                || jtsoluong.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đủ thông tin");
        } else {
           hoadonDTO hoadondto = new hoadonDTO();
            hoadondto.setMahoadon(Integer.parseInt(jtmahoadon.getText()));
            hoadondto.setMakhachhang(jtmakhachhang.getText());
            hoadondto.setTenkhachhang(jttenkhachhang.getText());
            hoadondto.setSoluong(Integer.parseInt(jtsoluong.getText().toString()));
            hoadondto.setTensanpham((jttensanpham.getText()));
            hoadondto.setGiasanpham(Integer.parseInt(jtgiasanpham.getText()));
            
            hoadonBLL hoadonbll = new hoadonBLL();
            try {
                int result = hoadonbll.inserthoadon(hoadondto);
                if (result != 0) {
                    JOptionPane.showMessageDialog(this, "Thêm hóa đơn thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    
                    loadHoadonList();
                } else {
                    JOptionPane.showMessageDialog(this, "Hóa đơn đã tồn tại!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        hoadonDTO hoadondto = new hoadonDTO();
        hoadondto.setMahoadon(Integer.parseInt(jtmahoadon.getText()));
        hoadonBLL hoadonbll = new hoadonBLL();

        int choice = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn xóa dữ liệu!", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            try {
                int result = hoadonbll.deletehoadon(hoadondto);
               
                loadHoadonList();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void jtldssanphamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtldssanphamMouseClicked
        int i = jtldssanpham.getSelectedRow();
        if (i >= 0) {
            jttensanpham.setText(dssp.getValueAt(i, 1).toString());
            jtgiasanpham.setText(dssp.getValueAt(i, 3).toString());
        }
    }//GEN-LAST:event_jtldssanphamMouseClicked

    private void jtldsshoadonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtldsshoadonMouseClicked
        int i = jtldsshoadon.getSelectedRow();
        if (i >= 0) {
            jtmahoadon.setText(dshd.getValueAt(i, 0).toString());
            jtmakhachhang.setText(dshd.getValueAt(i, 1).toString());
            jttenkhachhang.setText(dshd.getValueAt(i, 2).toString());
            jtsoluong.setText(dshd.getValueAt(i, 3).toString());
            jttensanpham.setText(dshd.getValueAt(i, 4).toString());
            jtgiasanpham.setText(dshd.getValueAt(i, 5).toString());
            jtthanhtien.setText(dshd.getValueAt(i, 6).toString());
        }
    }//GEN-LAST:event_jtldsshoadonMouseClicked

    private void jtthanhtienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtthanhtienActionPerformed
        
    }//GEN-LAST:event_jtthanhtienActionPerformed

    private void btnPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayActionPerformed
        
    }//GEN-LAST:event_btnPayActionPerformed

    private void search_sanpham(String keyword) {
        ArrayList<sanphamDTO> sanphamarr = new ArrayList<>();
        DefaultTableModel dtm = (DefaultTableModel) jtldssanpham.getModel();
        dtm.setRowCount(0);

        sanphamBLL sanphambll = new sanphamBLL();

        sanphamarr = sanphambll.search_sanpham(keyword);

        sanphamDTO sanphamdto = new sanphamDTO();
        for (int i = 0; i < sanphamarr.size(); i++) {
            sanphamdto = sanphamarr.get(i);
            Object[] row = {sanphamdto.getMasanpham(), sanphamdto.getTensanpham(), sanphamdto.getLoaisanpham(), sanphamdto.getGiasanpham()};
            dtm.addRow(row);

        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String keyword = cb.getSelectedItem().toString();
        if (cb.getSelectedItem() == "Loại") {
            DSsanpham();
        } else {
            search_sanpham(keyword);
        }
    }

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
            java.util.logging.Logger.getLogger(hoadonGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(hoadonGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(hoadonGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(hoadonGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new hoadonGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnPay;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnsearchhd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jtgiasanpham;
    private javax.swing.JTable jtldssanpham;
    private javax.swing.JTable jtldsshoadon;
    private javax.swing.JTextField jtmahoadon;
    private javax.swing.JTextField jtmakhachhang;
    private javax.swing.JTextField jtsoluong;
    private javax.swing.JTextField jttenkhachhang;
    private javax.swing.JTextField jttensanpham;
    private javax.swing.JTextField jtthanhtien;
    private javax.swing.JTextField jttongtien;
    // End of variables declaration//GEN-END:variables


}
