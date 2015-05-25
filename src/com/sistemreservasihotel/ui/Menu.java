/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemreservasihotel.ui;

import java.awt.Point;
import com.sistemreservasihotel.lib.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author user
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form FrontEnd
     *
     * @param oldLocation
     */
    public Menu(Point oldLocation) {
        initComponents();
        this.setLocation(oldLocation);
        initMember();
        populateComponent();
    }

    private void initMember() {
        account = new Account();

        checkInDatePicker.setFormats(new String[]{"yyyy-MM-dd"});
        checkOutDatePicker.setFormats(new String[]{"yyyy-MM-dd"});
        
        // Bold all table Header
        bookingListTbl.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        paymentListTbl.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        roomListTbl.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        costumerListTbl.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        userListTbl.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
    }

    private void populateComponent() {
        // Check wheter user type Admin or User
        if (account.getAccountType().equals("User")) {
            hotelTabbedPane.remove(userManPnl);
            hotelMenuBar.remove(managementMenu);
        }

        // Create popup menu for userListTbl and bookingListTbl
        createPopupMenu();

        // Populate list for booking, payment, costumer and room list
        try {
            bookingListTbl.setModel(booking.updateBookingList());
            paymentListTbl.setModel(payment.updatePaymentList());
            costumerListTbl.setModel(costumer.updateCostumerList());
            roomListTbl.setModel(room.updateRoomList());
            userListTbl.setModel(account.updateAccountList());
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void createPopupMenu() {
        // Enable delete data on bookingListTbl and userListTbl 
        JPopupMenu popupMenuBooking = new JPopupMenu();
        JPopupMenu popupMenuAccount = new JPopupMenu();
        JMenuItem deleteBooking = new JMenuItem("Delete Booking");
        JMenuItem deleteAccount = new JMenuItem("Delete User");
        JMenuItem emptyPassword = new JMenuItem("Empty Password");
        deleteBooking.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRowIndex = bookingListTbl.getSelectedRow();
                if (selectedRowIndex != -1) {
                    costumer.deleteCostumer(costumer.getCostumerID((String) bookingListTbl.getValueAt(selectedRowIndex, 2)));
                    booking.deleteBooking(bookingListTbl.getValueAt(selectedRowIndex, 0).toString());
                    bookingListTbl.setModel(booking.updateBookingList());
                }
            }
        });
        deleteAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRowIndex = userListTbl.getSelectedRow();
                if (selectedRowIndex != -1) {
                    account.deleteAccount(userListTbl.getValueAt(selectedRowIndex, 0).toString());
                    try {
                        userListTbl.setModel(account.updateAccountList());
                    } catch (SQLException ex) {
                        Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        emptyPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRowIndex = userListTbl.getSelectedRow();
                if (selectedRowIndex != -1) {
                    account.emptyAccountPassword(userListTbl.getValueAt(selectedRowIndex, 0).toString());
                    try {
                        userListTbl.setModel(account.updateAccountList());
                    } catch (SQLException ex) {
                        Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        popupMenuBooking.add(deleteBooking);
        bookingListTbl.setComponentPopupMenu(popupMenuBooking);
        popupMenuAccount.add(deleteAccount);
        popupMenuAccount.add(emptyPassword);
        userListTbl.setComponentPopupMenu(popupMenuAccount);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        hotelTabbedPane = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        costBooNamekLbl = new javax.swing.JLabel();
        costBookNameTxtField = new javax.swing.JTextField();
        genderLbl = new javax.swing.JLabel();
        genderComBox = new javax.swing.JComboBox();
        addressLbl = new javax.swing.JLabel();
        addressTxtScrollPnl = new javax.swing.JScrollPane();
        addressTxtArea = new javax.swing.JTextArea();
        contactLbl = new javax.swing.JLabel();
        contactTxtField = new javax.swing.JFormattedTextField();
        emailLbl = new javax.swing.JLabel();
        emailTxtField = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        bookingPnl = new javax.swing.JPanel();
        roomNoLbl = new javax.swing.JPanel();
        checkInLbl = new javax.swing.JLabel();
        checkInDatePicker = new org.jdesktop.swingx.JXDatePicker();
        checkOutLbl = new javax.swing.JLabel();
        checkOutDatePicker = new org.jdesktop.swingx.JXDatePicker();
        bookingSaveBtn = new javax.swing.JButton();
        roomLbl = new javax.swing.JLabel();
        roomNoTxtField = new javax.swing.JTextField();
        listEmptyRoomBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        roomNoTxtField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        paymentPnl = new javax.swing.JPanel();
        paymentForm = new javax.swing.JPanel();
        costPayNameLbl = new javax.swing.JLabel();
        bookingLbl = new javax.swing.JLabel();
        totalPaymentLbl = new javax.swing.JLabel();
        payDateLbl = new javax.swing.JLabel();
        payDatePicker = new org.jdesktop.swingx.JXDatePicker();
        paySaveBtn = new javax.swing.JButton();
        listBookingBtn = new javax.swing.JButton();
        costPayNameTxtField = new javax.swing.JFormattedTextField();
        bookingTxtField = new javax.swing.JFormattedTextField();
        totalPayTxtField = new javax.swing.JFormattedTextField();
        costImageViewer = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        calculatePaymentBtn = new javax.swing.JButton();
        bookingListPnl = new javax.swing.JPanel();
        bookingListScroll = new javax.swing.JScrollPane();
        bookingListTbl = new javax.swing.JTable();
        paymentListPnl = new javax.swing.JPanel();
        paymentListScroll = new javax.swing.JScrollPane();
        paymentListTbl = new javax.swing.JTable();
        costumerListPnl = new javax.swing.JPanel();
        costumerListScroll = new javax.swing.JScrollPane();
        costumerListTbl = new javax.swing.JTable();
        roomListPnl = new javax.swing.JPanel();
        roomListScroll = new javax.swing.JScrollPane();
        roomListTbl = new javax.swing.JTable();
        userManPnl = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        userListTbl = new javax.swing.JTable();
        hotelMenuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        logoutMenuItem = new javax.swing.JMenuItem();
        changePassMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        clearAllTextMenuItem = new javax.swing.JMenuItem();
        managementMenu = new javax.swing.JMenu();
        registerUserItem = new javax.swing.JMenuItem();
        manageRoomItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("System Reservasi Hotel");
        setLocationByPlatform(isLocationByPlatform());
        setPreferredSize(new java.awt.Dimension(1000, 700));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        hotelTabbedPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hotelTabbedPaneMouseClicked(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Input Costumer Data"));

        costBooNamekLbl.setText("Costumer Name:");

        genderLbl.setText("Gender");

        genderComBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pria", "Wanita" }));

        addressLbl.setText("Address:");

        addressTxtArea.setColumns(20);
        addressTxtArea.setRows(5);
        addressTxtScrollPnl.setViewportView(addressTxtArea);

        contactLbl.setText("Contact No:");

        emailLbl.setText("Email:");

        jButton1.setText("Save");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(costBooNamekLbl)
                    .addComponent(genderLbl)
                    .addComponent(addressLbl)
                    .addComponent(contactLbl)
                    .addComponent(emailLbl))
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(genderComBox, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(costBookNameTxtField, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                            .addComponent(contactTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailTxtField))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(addressTxtScrollPnl, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(costBooNamekLbl)
                    .addComponent(costBookNameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(genderLbl)
                    .addComponent(genderComBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(addressLbl)
                        .addGap(134, 134, 134))
                    .addComponent(addressTxtScrollPnl))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contactLbl)
                    .addComponent(contactTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(emailLbl)
                    .addComponent(emailTxtField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(155, 155, 155)
                .addComponent(jButton1))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        hotelTabbedPane.addTab("Costumer", jPanel1);

        roomNoLbl.setBorder(javax.swing.BorderFactory.createTitledBorder("Input Booking Data"));

        checkInLbl.setText("Checkin Date:");

        checkOutLbl.setText("Checkout Date:");

        bookingSaveBtn.setText("Save");
        bookingSaveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookingSaveBtnActionPerformed(evt);
            }
        });

        roomLbl.setText("Room:");

        listEmptyRoomBtn.setText("Empty Room");
        listEmptyRoomBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listEmptyRoomBtnActionPerformed(evt);
            }
        });

        jLabel2.setText("Costumer No:");

        jButton2.setText("List Costumer");

        javax.swing.GroupLayout roomNoLblLayout = new javax.swing.GroupLayout(roomNoLbl);
        roomNoLbl.setLayout(roomNoLblLayout);
        roomNoLblLayout.setHorizontalGroup(
            roomNoLblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomNoLblLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roomNoLblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roomNoLblLayout.createSequentialGroup()
                        .addGroup(roomNoLblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkInLbl)
                            .addComponent(checkOutLbl))
                        .addGap(21, 21, 21)
                        .addGroup(roomNoLblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(checkInDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkOutDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(roomNoLblLayout.createSequentialGroup()
                        .addGroup(roomNoLblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(roomLbl)
                            .addComponent(jLabel2))
                        .addGap(34, 34, 34)
                        .addGroup(roomNoLblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(roomNoLblLayout.createSequentialGroup()
                                .addComponent(roomNoTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(listEmptyRoomBtn))
                            .addGroup(roomNoLblLayout.createSequentialGroup()
                                .addComponent(roomNoTxtField1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2)))
                        .addContainerGap(341, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roomNoLblLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(bookingSaveBtn))
        );
        roomNoLblLayout.setVerticalGroup(
            roomNoLblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomNoLblLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roomNoLblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(roomNoTxtField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roomNoLblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roomLbl)
                    .addComponent(roomNoTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(listEmptyRoomBtn))
                .addGap(8, 8, 8)
                .addGroup(roomNoLblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkInLbl)
                    .addComponent(checkInDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roomNoLblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkOutLbl)
                    .addComponent(checkOutDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 301, Short.MAX_VALUE)
                .addComponent(bookingSaveBtn))
        );

        javax.swing.GroupLayout bookingPnlLayout = new javax.swing.GroupLayout(bookingPnl);
        bookingPnl.setLayout(bookingPnlLayout);
        bookingPnlLayout.setHorizontalGroup(
            bookingPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bookingPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roomNoLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        bookingPnlLayout.setVerticalGroup(
            bookingPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookingPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roomNoLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        hotelTabbedPane.addTab("Booking", bookingPnl);

        paymentForm.setBorder(javax.swing.BorderFactory.createTitledBorder("Form Payment"));

        costPayNameLbl.setText("Costumer Name:");

        bookingLbl.setText("Booking ID:");

        totalPaymentLbl.setText("Total Payment:");

        payDateLbl.setText("Payment Date:");

        paySaveBtn.setText("Save");
        paySaveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paySaveBtnActionPerformed(evt);
            }
        });

        listBookingBtn.setText("List Booking");
        listBookingBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listBookingBtnActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/sistemreservasihotel/ext/hotel-icon.png"))); // NOI18N

        javax.swing.GroupLayout costImageViewerLayout = new javax.swing.GroupLayout(costImageViewer);
        costImageViewer.setLayout(costImageViewerLayout);
        costImageViewerLayout.setHorizontalGroup(
            costImageViewerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(costImageViewerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                .addContainerGap())
        );
        costImageViewerLayout.setVerticalGroup(
            costImageViewerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(costImageViewerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                .addContainerGap())
        );

        calculatePaymentBtn.setText("Calculate");
        calculatePaymentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculatePaymentBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paymentFormLayout = new javax.swing.GroupLayout(paymentForm);
        paymentForm.setLayout(paymentFormLayout);
        paymentFormLayout.setHorizontalGroup(
            paymentFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paymentFormLayout.createSequentialGroup()
                .addGroup(paymentFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalPaymentLbl)
                    .addComponent(payDateLbl)
                    .addComponent(bookingLbl)
                    .addComponent(costPayNameLbl))
                .addGap(20, 20, 20)
                .addGroup(paymentFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paymentFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(paymentFormLayout.createSequentialGroup()
                            .addGap(140, 140, 140)
                            .addComponent(paySaveBtn))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paymentFormLayout.createSequentialGroup()
                            .addComponent(bookingTxtField, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addGap(7, 7, 7)
                            .addComponent(listBookingBtn)
                            .addGap(46, 46, 46)))
                    .addComponent(costPayNameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(payDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(paymentFormLayout.createSequentialGroup()
                        .addComponent(totalPayTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(calculatePaymentBtn)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(costImageViewer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        paymentFormLayout.setVerticalGroup(
            paymentFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paymentFormLayout.createSequentialGroup()
                .addGroup(paymentFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paymentFormLayout.createSequentialGroup()
                        .addGroup(paymentFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(costPayNameLbl)
                            .addComponent(costPayNameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(paymentFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bookingLbl)
                            .addComponent(listBookingBtn)
                            .addComponent(bookingTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(paymentFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(totalPaymentLbl)
                            .addComponent(totalPayTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(calculatePaymentBtn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(paymentFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(payDateLbl)
                            .addComponent(payDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(paySaveBtn))
                    .addComponent(costImageViewer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout paymentPnlLayout = new javax.swing.GroupLayout(paymentPnl);
        paymentPnl.setLayout(paymentPnlLayout);
        paymentPnlLayout.setHorizontalGroup(
            paymentPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paymentPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(paymentForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        paymentPnlLayout.setVerticalGroup(
            paymentPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paymentPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(paymentForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(289, Short.MAX_VALUE))
        );

        hotelTabbedPane.addTab("Payment", paymentPnl);

        bookingListTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Room No.", "Costumer", "Checkin", "Checkout", "Booking Date", "Receiver", "Duration"
            }
        ));
        bookingListScroll.setViewportView(bookingListTbl);

        javax.swing.GroupLayout bookingListPnlLayout = new javax.swing.GroupLayout(bookingListPnl);
        bookingListPnl.setLayout(bookingListPnlLayout);
        bookingListPnlLayout.setHorizontalGroup(
            bookingListPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookingListPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bookingListScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
                .addContainerGap())
        );
        bookingListPnlLayout.setVerticalGroup(
            bookingListPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookingListPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bookingListScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                .addContainerGap())
        );

        hotelTabbedPane.addTab("Booking List", bookingListPnl);

        paymentListTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Booking ID", "Costumer Name", "Booking Date", "Payment Date"
            }
        ));
        paymentListTbl.setEnabled(false);
        paymentListScroll.setViewportView(paymentListTbl);
        if (paymentListTbl.getColumnModel().getColumnCount() > 0) {
            paymentListTbl.getColumnModel().getColumn(0).setPreferredWidth(15);
            paymentListTbl.getColumnModel().getColumn(1).setPreferredWidth(25);
            paymentListTbl.getColumnModel().getColumn(2).setResizable(false);
            paymentListTbl.getColumnModel().getColumn(2).setPreferredWidth(25);
            paymentListTbl.getColumnModel().getColumn(3).setResizable(false);
            paymentListTbl.getColumnModel().getColumn(3).setPreferredWidth(25);
        }

        javax.swing.GroupLayout paymentListPnlLayout = new javax.swing.GroupLayout(paymentListPnl);
        paymentListPnl.setLayout(paymentListPnlLayout);
        paymentListPnlLayout.setHorizontalGroup(
            paymentListPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paymentListPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(paymentListScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
                .addContainerGap())
        );
        paymentListPnlLayout.setVerticalGroup(
            paymentListPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paymentListPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(paymentListScroll)
                .addGap(27, 27, 27))
        );

        hotelTabbedPane.addTab("Payment List", paymentListPnl);

        costumerListTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Address", "Contact", "Email", "Gender", "Payment Status"
            }
        ));
        costumerListTbl.setEnabled(false);
        costumerListScroll.setViewportView(costumerListTbl);

        javax.swing.GroupLayout costumerListPnlLayout = new javax.swing.GroupLayout(costumerListPnl);
        costumerListPnl.setLayout(costumerListPnlLayout);
        costumerListPnlLayout.setHorizontalGroup(
            costumerListPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(costumerListPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(costumerListScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
                .addContainerGap())
        );
        costumerListPnlLayout.setVerticalGroup(
            costumerListPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(costumerListPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(costumerListScroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        hotelTabbedPane.addTab("Costumer List", costumerListPnl);

        roomListTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Room Type", "Status", "Price", "Facilities"
            }
        ));
        roomListTbl.setEnabled(false);
        roomListScroll.setViewportView(roomListTbl);

        javax.swing.GroupLayout roomListPnlLayout = new javax.swing.GroupLayout(roomListPnl);
        roomListPnl.setLayout(roomListPnlLayout);
        roomListPnlLayout.setHorizontalGroup(
            roomListPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomListPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roomListScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
                .addContainerGap())
        );
        roomListPnlLayout.setVerticalGroup(
            roomListPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomListPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roomListScroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        hotelTabbedPane.addTab("Room List", roomListPnl);

        userListTbl.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(userListTbl);

        javax.swing.GroupLayout userManPnlLayout = new javax.swing.GroupLayout(userManPnl);
        userManPnl.setLayout(userManPnlLayout);
        userManPnlLayout.setHorizontalGroup(
            userManPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userManPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
                .addContainerGap())
        );
        userManPnlLayout.setVerticalGroup(
            userManPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userManPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        hotelTabbedPane.addTab("User List", userManPnl);

        getContentPane().add(hotelTabbedPane);

        fileMenu.setText("File");

        logoutMenuItem.setText("Logout");
        logoutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(logoutMenuItem);

        changePassMenuItem.setText("Change Password");
        changePassMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePassMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(changePassMenuItem);

        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        hotelMenuBar.add(fileMenu);

        editMenu.setText("Edit");

        clearAllTextMenuItem.setText("Clear All Text");
        clearAllTextMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearAllTextMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(clearAllTextMenuItem);

        hotelMenuBar.add(editMenu);

        managementMenu.setText("Management");

        registerUserItem.setText("Register User");
        registerUserItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerUserItemActionPerformed(evt);
            }
        });
        managementMenu.add(registerUserItem);

        manageRoomItem.setText("Manage Room");
        manageRoomItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageRoomItemActionPerformed(evt);
            }
        });
        managementMenu.add(manageRoomItem);

        hotelMenuBar.add(managementMenu);

        helpMenu.setText("Help");

        aboutMenuItem.setText("About");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutMenuItem);

        hotelMenuBar.add(helpMenu);

        setJMenuBar(hotelMenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void logoutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutMenuItemActionPerformed
        // TODO add your handling code here:
        Login login = new Login(null, true);
        login.setLocationRelativeTo(this);
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutMenuItemActionPerformed

    private void hotelTabbedPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hotelTabbedPaneMouseClicked
        // TODO add your handling code here:
        try {
            costumerListTbl.setModel(costumer.updateCostumerList());
            paymentListTbl.setModel(payment.updatePaymentList());
            bookingListTbl.setModel(booking.updateBookingList());
            roomListTbl.setModel(room.updateRoomList());
            userListTbl.setModel(account.updateAccountList());
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_hotelTabbedPaneMouseClicked

    private void bookingSaveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookingSaveBtnActionPerformed
        // TODO add your handling code here:
        String costumerName = costBookNameTxtField.getText();
        String jenisKelamin = genderComBox.getSelectedItem().toString();
        String costumerAddress = addressTxtArea.getText();
        String contactNo = contactTxtField.getText();
        String email = emailTxtField.getText();
        String roomNo = roomNoTxtField.getText();
        Date checkinDate = checkInDatePicker.getDate();
        Date checkoutDate = checkOutDatePicker.getDate();

        // Checking empty and whitespace
        Vector<String> variableCheckStr = new Vector<String>();
        Vector<Date> variableCheckDate = new Vector<Date>();
        variableCheckStr.add(costumerName);
        variableCheckStr.add(jenisKelamin);
        variableCheckStr.add(costumerAddress);
        variableCheckStr.add(contactNo);
        variableCheckStr.add(email);
        variableCheckStr.add(roomNo);
        variableCheckDate.add(checkinDate);
        variableCheckDate.add(checkoutDate);
        boolean strOk = true;
        for (String data : variableCheckStr) {
            if (data == "" || data.matches("^\\s*$")) {
                strOk = false;
            }
        }
        for (Date data : variableCheckDate) {
            if (data == null) {
                strOk = false;
            }
        }

        // If not empty and white space add to database
        if (strOk) {
            if (room.checkRoom(roomNo)) {
                costumer.addCostumer(costumerName, costumerAddress, contactNo, email, jenisKelamin);
                booking.addBooking(account.getEmployeeNo(), roomNo, costumer.getCostumerID(costumerName), checkinDate, checkoutDate);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Please use empty room!!!");
            }
        }
    }//GEN-LAST:event_bookingSaveBtnActionPerformed

    private void listEmptyRoomBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listEmptyRoomBtnActionPerformed
        JTable emptyRoomTbl = new JTable(room.viewEmptyRoom());
        emptyRoomTbl.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        JOptionPane.showMessageDialog(this, new JScrollPane(emptyRoomTbl));

    }//GEN-LAST:event_listEmptyRoomBtnActionPerformed

    private void paySaveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paySaveBtnActionPerformed
        // TODO add your handling code here:
        String costumerName = costPayNameTxtField.getText();
        String bookingID = bookingTxtField.getText();
        double totalPayment = 0;
        Date paymentDate = payDatePicker.getDate();

        // Checking empty and whitespace
        Vector<String> variableCheckStr = new Vector<String>();
        variableCheckStr.add(costumerName);
        variableCheckStr.add(bookingID);
        boolean strOk = true;
        if (paymentDate == null) {
            strOk = false;
        }
        if (totalPayTxtField.getText() == "" || totalPayTxtField.getText().matches("^\\s*$")) {
            strOk = false;
        } else {
            totalPayment = Double.parseDouble(totalPayTxtField.getText());
        }
        for (String data : variableCheckStr) {
            if (data == "" || data.matches("^\\s*$")) {
                strOk = false;
            }
        }

        // If not empty and white space add to database
        if (strOk) {
            if (costumer.checkCostumer(costumerName)) {
                payment.addPayment(costumer.getCostumerID(costumerName), bookingID, account.getEmployeeNo(), totalPayment, paymentDate);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Costumer Not Found!!!");
            }
        }
    }//GEN-LAST:event_paySaveBtnActionPerformed

    private void listBookingBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listBookingBtnActionPerformed
        JTable bookingListTbl = new JTable(booking.viewBooking());
        bookingListTbl.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        JOptionPane.showMessageDialog(this, new JScrollPane(bookingListTbl));
    }//GEN-LAST:event_listBookingBtnActionPerformed

    private void changePassMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePassMenuItemActionPerformed
        // TODO add your handling code here:
        ChangePassword changePassword = new ChangePassword(null, true);
        changePassword.setLocationRelativeTo(this);
        changePassword.setVisible(true);
    }//GEN-LAST:event_changePassMenuItemActionPerformed

    private void registerUserItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerUserItemActionPerformed
        // TODO add your handling code here:
        RegisterUser registerUser = new RegisterUser(null, true);
        registerUser.setLocationRelativeTo(this);
        registerUser.setVisible(true);
    }//GEN-LAST:event_registerUserItemActionPerformed

    private void manageRoomItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageRoomItemActionPerformed
        // TODO add your handling code here:
        ManageRoom manageRoom = new ManageRoom(null, true);
        manageRoom.setLocationRelativeTo(this);
        manageRoom.setVisible(true);
    }//GEN-LAST:event_manageRoomItemActionPerformed

    private void clearAllTextMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearAllTextMenuItemActionPerformed
        // TODO add your handling code here:
        costBookNameTxtField.setText("");
        addressTxtArea.setText("");
        contactTxtField.setText("");
        contactTxtField.setText("");
        emailTxtField.setText("");
        roomNoTxtField.setText("");
        checkInDatePicker.setDate(null);
        checkOutDatePicker.setDate(null);
        costPayNameTxtField.setText("");
        bookingTxtField.setText("");
        totalPayTxtField.setText("");
    }//GEN-LAST:event_clearAllTextMenuItemActionPerformed

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "To be add: \n- Jasper report. \n- Formatted input. \n- Row not aligned center.");
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void calculatePaymentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculatePaymentBtnActionPerformed
        // TODO add your handling code here:
        double totalPayment = 0;
        double price = room.getRoomPrice(String.valueOf(booking.getRoomNo(bookingTxtField.getText())));
        int day = booking.getStayDuration(bookingTxtField.getText());
        totalPayment = price * day;
        totalPayTxtField.setText(String.valueOf(totalPayment));
    }//GEN-LAST:event_calculatePaymentBtnActionPerformed

    private Account account;
    private Booking booking;
    private Payment payment;
    private Costumer costumer;
    private Room room;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JLabel addressLbl;
    private javax.swing.JTextArea addressTxtArea;
    private javax.swing.JScrollPane addressTxtScrollPnl;
    private javax.swing.JLabel bookingLbl;
    private javax.swing.JPanel bookingListPnl;
    private javax.swing.JScrollPane bookingListScroll;
    private javax.swing.JTable bookingListTbl;
    private javax.swing.JPanel bookingPnl;
    private javax.swing.JButton bookingSaveBtn;
    private javax.swing.JFormattedTextField bookingTxtField;
    private javax.swing.JButton calculatePaymentBtn;
    private javax.swing.JMenuItem changePassMenuItem;
    private org.jdesktop.swingx.JXDatePicker checkInDatePicker;
    private javax.swing.JLabel checkInLbl;
    private org.jdesktop.swingx.JXDatePicker checkOutDatePicker;
    private javax.swing.JLabel checkOutLbl;
    private javax.swing.JMenuItem clearAllTextMenuItem;
    private javax.swing.JLabel contactLbl;
    private javax.swing.JFormattedTextField contactTxtField;
    private javax.swing.JLabel costBooNamekLbl;
    private javax.swing.JTextField costBookNameTxtField;
    private javax.swing.JPanel costImageViewer;
    private javax.swing.JLabel costPayNameLbl;
    private javax.swing.JFormattedTextField costPayNameTxtField;
    private javax.swing.JPanel costumerListPnl;
    private javax.swing.JScrollPane costumerListScroll;
    private javax.swing.JTable costumerListTbl;
    private javax.swing.JMenu editMenu;
    private javax.swing.JLabel emailLbl;
    private javax.swing.JFormattedTextField emailTxtField;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JComboBox genderComBox;
    private javax.swing.JLabel genderLbl;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuBar hotelMenuBar;
    private javax.swing.JTabbedPane hotelTabbedPane;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton listBookingBtn;
    private javax.swing.JButton listEmptyRoomBtn;
    private javax.swing.JMenuItem logoutMenuItem;
    private javax.swing.JMenuItem manageRoomItem;
    private javax.swing.JMenu managementMenu;
    private javax.swing.JLabel payDateLbl;
    private org.jdesktop.swingx.JXDatePicker payDatePicker;
    private javax.swing.JButton paySaveBtn;
    private javax.swing.JPanel paymentForm;
    private javax.swing.JPanel paymentListPnl;
    private javax.swing.JScrollPane paymentListScroll;
    private javax.swing.JTable paymentListTbl;
    private javax.swing.JPanel paymentPnl;
    private javax.swing.JMenuItem registerUserItem;
    private javax.swing.JLabel roomLbl;
    private javax.swing.JPanel roomListPnl;
    private javax.swing.JScrollPane roomListScroll;
    private javax.swing.JTable roomListTbl;
    private javax.swing.JPanel roomNoLbl;
    private javax.swing.JTextField roomNoTxtField;
    private javax.swing.JTextField roomNoTxtField1;
    private javax.swing.JFormattedTextField totalPayTxtField;
    private javax.swing.JLabel totalPaymentLbl;
    private javax.swing.JTable userListTbl;
    private javax.swing.JPanel userManPnl;
    // End of variables declaration//GEN-END:variables
}
