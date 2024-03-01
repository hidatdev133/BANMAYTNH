/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BLL.nhanvienBLL;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import DAL.taikhoanDAL;
import BLL.taikhoanBLL;
import DTO.taikhoanDTO;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import DTO.nhanvienDTO;
import DAL.nhanvienDAL;

/**
 *
 * @author Acer
 */
public class taikhoanGUI extends javax.swing.JFrame {
    DefaultTableModel dtm = new DefaultTableModel();
    JComboBox cb, cb1;
    DefaultTableModel dsnv = new DefaultTableModel();
    
    public taikhoanGUI() {
        String sex[] = {" ","Nam","Nữ"};
        cb = new JComboBox(sex);
        cb.setBounds(360, 460, 100, 36);
        this.add(cb);
        
        String quyen[] = {" ","admin","nhân viên"}; 
        cb1 = new JComboBox(quyen);
        cb1.setBounds(360, 560, 100, 36);
        this.add(cb1);
        initComponents();
        
        jtmanv.setEditable(false);
        jthotennv.setEditable(false);
        jtdiachi.setEditable(false);
        
        dsnv.addColumn("Mã nhân viên");
        dsnv.addColumn("Họ tên");
        dsnv.addColumn("Giới tính");
        dsnv.addColumn("Địa chỉ");
        jtldsnhanvien.setModel(dsnv);
        
        dtm.addColumn("UserID");
        dtm.addColumn("Tên đăng nhập");
        dtm.addColumn("Mật khẩu");
        dtm.addColumn("Mã nhân viên");
        dtm.addColumn("Họ tên");
        dtm.addColumn("Giới tính");
        dtm.addColumn("Địa chỉ");
        dtm.addColumn("Quyền truy cập");
        jtlDSTaiKhoan.setModel(dtm);
        
        DSnhanvien();
        
        loadTaikhoanList();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jtuserid = new javax.swing.JTextField();
        jtdiachi = new javax.swing.JTextField();
        jthotennv = new javax.swing.JTextField();
        jtmanv = new javax.swing.JTextField();
        jtusername = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtlDSTaiKhoan = new javax.swing.JTable();
        btnSearch = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        btnDong = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jtmatkhau = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtldsnhanvien = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("QUẢN LÝ TÀI KHOẢN");

        jLabel3.setText("UserID:");

        jLabel4.setText("Mật khẩu:");

        jLabel7.setText("Họ tên NV:");

        jLabel8.setText("Giới tính:");

        jLabel9.setText("Địa chỉ:");

        jLabel10.setText("Quyền:");

        jLabel11.setText("Tên đăng nhập:");

        btnBack.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/back.png"))); // NOI18N
        btnBack.setText("TRỞ VỀ");
        btnBack.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBack.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jtlDSTaiKhoan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtlDSTaiKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtlDSTaiKhoanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtlDSTaiKhoan);

        btnSearch.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/search.png"))); // NOI18N
        btnSearch.setText("TÌM KIẾM");
        btnSearch.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSearch.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/delete.png"))); // NOI18N
        btnXoa.setText("XÓA");
        btnXoa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnXoa.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/edit.png"))); // NOI18N
        btnSua.setText("SỬA");
        btnSua.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSua.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnThem.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/add.png"))); // NOI18N
        btnThem.setText("THÊM");
        btnThem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnThem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/lammoi.png"))); // NOI18N
        btnReset.setText("Làm mới");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnThoat.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/exit.png"))); // NOI18N
        btnThoat.setText("THOÁT");
        btnThoat.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnThoat.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        btnDong.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnDong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/remove.png"))); // NOI18N
        btnDong.setText("ĐÓNG");
        btnDong.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDong.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDongActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator4.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator5.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator6.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel1.setText("Mã NV:");

        jtldsnhanvien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtldsnhanvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtldsnhanvienMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtldsnhanvien);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDong, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jtuserid, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jtusername, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jtmatkhau, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jtmanv, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtdiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jthotennv, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(btnReset))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator5)
                    .addComponent(btnThoat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnDong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtuserid, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtusername, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtmatkhau, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jtmanv, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jthotennv, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(53, 53, 53)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(17, 17, 17)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jtdiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(btnReset))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadTaikhoanList() {
        dtm.setRowCount(0);

        ArrayList<taikhoanDTO> taikhoanarr = new ArrayList<>();
        taikhoanBLL taikhoanbll = new taikhoanBLL();
        taikhoanarr = taikhoanbll.getAlltaikhoan();
        taikhoanDTO taikhoandto = new taikhoanDTO();

        for (int i = 0; i < taikhoanarr.size(); i++) {
            taikhoandto = taikhoanarr.get(i);
            String userid = taikhoandto.getUserID();
            String username = taikhoandto.getUsername();
            String password = taikhoandto.getPassword();
            String manhanvien = taikhoandto.getManhanvien();
            String hotennhanvien = taikhoandto.getHotenhanvien();
            String gioitinh = taikhoandto.getGioitinh();
            String diachi = taikhoandto.getDiachi();
            String quyen = taikhoandto.getQuyen();
            Object[] row = {userid, username, password, manhanvien, hotennhanvien, gioitinh, diachi, quyen};
            dtm.addRow(row);
        }
        jtlDSTaiKhoan.setModel(dtm);
    }
    
    private void DSnhanvien() {
        dsnv.setRowCount(0);
        ArrayList<nhanvienDTO> nhanvienarr = new ArrayList<>();
        nhanvienBLL nhanvienbll = new nhanvienBLL();
        nhanvienarr = nhanvienbll.getAllnhanvien();
        nhanvienDTO nhanviendto = new nhanvienDTO();
        for (int i = 0; i < nhanvienarr.size(); i++) {
            nhanviendto = nhanvienarr.get(i);
            String manhanvien = nhanviendto.getManhanvien();
            String hotennhanvien = nhanviendto.getHotennhanvien();
            String gioitinh = nhanviendto.getGioitinh();
            String diachi = nhanviendto.getDiachi();
            Object[] row = {manhanvien, hotennhanvien, gioitinh, diachi};
            dsnv.addRow(row);
        }
        jtldsnhanvien.setModel(dsnv);
    }
    
    private void jtlDSTaiKhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtlDSTaiKhoanMouseClicked
        int i = jtlDSTaiKhoan.getSelectedRow();
        if (i >= 0) {
            jtuserid.setText(dtm.getValueAt(i, 0).toString());
            jtusername.setText(dtm.getValueAt(i, 1).toString());
            jtmatkhau.setText(dtm.getValueAt(i, 2).toString());
            jtmanv.setText(dtm.getValueAt(i, 3).toString());
            jthotennv.setText(dtm.getValueAt(i, 4).toString());
            cb.setSelectedItem(dtm.getValueAt(i, 5).toString());
            jtdiachi.setText(dtm.getValueAt(i, 6).toString());
            cb1.setSelectedItem(dtm.getValueAt(i, 7).toString());
        }
    }//GEN-LAST:event_jtlDSTaiKhoanMouseClicked

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        adminmenuGUI qlc = new adminmenuGUI();
        this.setVisible(false);
        qlc.setLocationRelativeTo(qlc);
        qlc.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (jtuserid.getText().trim().equals("") || jtusername.getText().trim().equals("")
                || jtmatkhau.getText().trim().equals("")|| jtmanv.getText().trim().equals("") || jthotennv.getText().trim().equals("")
                || jtdiachi.getText().trim().equals("")|| cb1.getSelectedItem() == " "
                || cb.getSelectedItem() == " ") {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đủ thông tin");
        } else {
            taikhoanDTO taikhoandto = new taikhoanDTO();
            taikhoandto.setUserID(jtuserid.getText());
            taikhoandto.setUsername(jtusername.getText());
            taikhoandto.setPassword(jtmanv.getText());
            taikhoandto.setManhanvien(jtmanv.getText());
            taikhoandto.setHotenhanvien(jthotennv.getText());
            taikhoandto.setGioitinh(cb.getSelectedItem().toString());
            taikhoandto.setDiachi((jtdiachi.getText()));
            taikhoandto.setQuyen(cb1.getSelectedItem().toString());

            taikhoanBLL taikhoanbll = new taikhoanBLL();
            try {
                int result = taikhoanbll.inserttaikhoan(taikhoandto);
                if (result != 0) {
                    JOptionPane.showMessageDialog(this, "Thêm tài khoản thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                loadTaikhoanList();
                }
                else {
                        JOptionPane.showMessageDialog(this, "Thêm tài khoản thất bại!","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                        }
               
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        };
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if (jtuserid.getText().trim().equals("") || jtusername.getText().trim().equals("")
                || jtmatkhau.getText().trim().equals("")|| jtmanv.getText().trim().equals("") || jthotennv.getText().trim().equals("")
                || cb.getSelectedItem().toString() == " " || jtdiachi.getText().trim().equals("")
                || cb1.getSelectedItem().toString() == " ") {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đủ thông tin");
        }
        else {
        taikhoanDTO taikhoandto = new taikhoanDTO();
        taikhoandto.setUserID(jtuserid.getText());
        taikhoandto.setUsername(jtusername.getText());
        taikhoandto.setPassword(jtmanv.getText());
        taikhoandto.setManhanvien(jtmanv.getText());
        taikhoandto.setHotenhanvien((jthotennv.getText()));
        taikhoandto.setGioitinh(cb.getSelectedItem().toString());
        taikhoandto.setDiachi((jtdiachi.getText()));
        taikhoandto.setQuyen(cb1.getSelectedItem().toString());
        
        taikhoanBLL taikhoanbll = new taikhoanBLL();
        int result = taikhoanbll.updatetaikhoan(taikhoandto);
        if (result != 0) {
            JOptionPane.showMessageDialog(this, "Cập nhật thông tin thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
             loadTaikhoanList();
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        taikhoanDTO taikhoandto = new taikhoanDTO();
        taikhoandto.setUserID(jtuserid.getText());
        taikhoanBLL taikhoanbll = new taikhoanBLL();
        
        int choice = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn xóa dữ liệu!", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            try {
                int result = taikhoanbll.deletetaikhoan(taikhoandto);
                loadTaikhoanList();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed
    
    private void search_taikhoan(String keyword) {
        ArrayList<taikhoanDTO> taikhoanarr = new ArrayList<>();
        DefaultTableModel dtm = (DefaultTableModel) jtlDSTaiKhoan.getModel();
        dtm.setRowCount(0);

        taikhoanBLL taikhoanbll = new taikhoanBLL();

        taikhoanarr = taikhoanbll.search_taikhoan(keyword);

        taikhoanDTO taikhoandto = new taikhoanDTO();
        for (int i = 0; i < taikhoanarr.size(); i++) {
            taikhoandto = taikhoanarr.get(i);
            Object[] row = {taikhoandto.getUserID(), taikhoandto.getUsername(), taikhoandto.getPassword(), taikhoandto.getManhanvien(), taikhoandto.getHotenhanvien(), taikhoandto.getGioitinh(), taikhoandto.getDiachi(), taikhoandto.getQuyen()};
            dtm.addRow(row);

        }
    }
    
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String keyword;
        if (jtuserid.getText().isEmpty() == false) {
            keyword = jtuserid.getText();
            search_taikhoan(keyword);
        } else if (jtusername.getText().isEmpty() == false) {
            keyword = jtusername.getText();
            search_taikhoan(keyword);
        } else if (jtmatkhau.getText().isEmpty() == false) {
            keyword = jtmatkhau.getText();
            search_taikhoan(keyword);
        } else if (jtmanv.getText().isEmpty() == false) {
            keyword = jtmanv.getText();
            search_taikhoan(keyword);
        } else if (jthotennv.getText().isEmpty() == false) {
            keyword = jthotennv.getText();
            search_taikhoan(keyword);
        } else if (cb.getSelectedItem() != null) {
            keyword = cb.getSelectedItem().toString();
            search_taikhoan(keyword);
        } else if (jtdiachi.getText().isEmpty() == false) {
            keyword = jtdiachi.getText();
            search_taikhoan(keyword);
        } else if (cb1.getSelectedItem() != null) {
            keyword = cb.getSelectedItem().toString();
            search_taikhoan(keyword);
        } else {
            loadTaikhoanList();
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
       jtuserid.setText((""));
       jtusername.setText("");
       jtmatkhau.setText("");
       jtmanv.setText("");
       jthotennv.setText("");
       jtdiachi.setText("");
       cb.setSelectedItem(" ");
       cb1.setSelectedItem(" ");
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        int qes;
        qes = JOptionPane.showConfirmDialog(null, "Bạn có muốn tiếp tục không?", "Question", JOptionPane.YES_NO_OPTION);
        if (qes == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDongActionPerformed
        dangnhapGUI dangnhap = new dangnhapGUI();
        this.setVisible(false);
        dangnhap.setLocationRelativeTo(dangnhap);
        dangnhap.setVisible(true);
    }//GEN-LAST:event_btnDongActionPerformed

    private void jtldsnhanvienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtldsnhanvienMouseClicked
        int i = jtldsnhanvien.getSelectedRow();
        if (i >= 0) {
            jtmanv.setText(dsnv.getValueAt(i, 0).toString());
            jthotennv.setText(dsnv.getValueAt(i, 1).toString());
            cb.setSelectedItem(dsnv.getValueAt(i, 2).toString());
            jtdiachi.setText(dsnv.getValueAt(i, 3).toString());
        }
    }//GEN-LAST:event_jtldsnhanvienMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                taikhoanGUI taikhoangui = new taikhoanGUI();
                taikhoangui.setLocationRelativeTo(taikhoangui);
                taikhoangui.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDong;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTextField jtdiachi;
    private javax.swing.JTextField jthotennv;
    private javax.swing.JTable jtlDSTaiKhoan;
    private javax.swing.JTable jtldsnhanvien;
    private javax.swing.JTextField jtmanv;
    private javax.swing.JTextField jtmatkhau;
    private javax.swing.JTextField jtuserid;
    private javax.swing.JTextField jtusername;
    // End of variables declaration//GEN-END:variables

}