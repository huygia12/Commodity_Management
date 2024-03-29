/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import java.util.stream.*;
import Controllers.EmployeeListController;
import Controllers.ShiftController;
import Models.Employee;
import Models.EmployeeList;
import Models.Shift;
import Models.Store;
import Ultility.Cautions;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author FPTSHOP
 */
public class OpenShiftFrame extends javax.swing.JFrame {

    /**
     * Creates new form OpenShiftFrame
     */
    public OpenShiftFrame() {
        initComponents();
        initVariables();
        setUp();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inputPanel = new javax.swing.JPanel();
        openBalanceLabel = new javax.swing.JLabel();
        taxShiftLabel = new javax.swing.JLabel();
        employeeListLabel = new javax.swing.JLabel();
        cashierLabel = new javax.swing.JLabel();
        openBalanceTextField = new javax.swing.JTextField();
        taxTextField = new javax.swing.JTextField();
        shiftEmployeeListComboBox = new javax.swing.JComboBox<>();
        noteScrollPane = new javax.swing.JScrollPane();
        noteArea = new javax.swing.JTextArea();
        cashierComboBox = new javax.swing.JComboBox<>();
        addToEmployeeListComboBox = new javax.swing.JButton();
        removeFromEmployeeListComboBox = new javax.swing.JButton();
        tableAndBtnPanel = new javax.swing.JPanel();
        employeeListScrollPane = new javax.swing.JScrollPane();
        employeeListTable = new javax.swing.JTable();
        acceptBtn = new javax.swing.JButton();
        denyBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mở Ca Làm Việc");
        setMinimumSize(new java.awt.Dimension(530, 400));
        setResizable(false);

        openBalanceLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        openBalanceLabel.setText("Số Dư Đầu Ca : ");

        taxShiftLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        taxShiftLabel.setText("Thuế(VAT-%):");

        employeeListLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        employeeListLabel.setText("NV Trực Ca:");

        cashierLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cashierLabel.setText("Thu Ngân Ca:");

        openBalanceTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        openBalanceTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        openBalanceTextField.setMaximumSize(new java.awt.Dimension(130, 25));
        openBalanceTextField.setMinimumSize(new java.awt.Dimension(130, 25));
        openBalanceTextField.setPreferredSize(new java.awt.Dimension(130, 25));
        openBalanceTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                openBalanceTextFieldMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                openBalanceTextFieldMouseExited(evt);
            }
        });
        openBalanceTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                openBalanceTextFieldKeyPressed(evt);
            }
        });

        taxTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        taxTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        taxTextField.setMaximumSize(new java.awt.Dimension(130, 25));
        taxTextField.setMinimumSize(new java.awt.Dimension(130, 25));
        taxTextField.setPreferredSize(new java.awt.Dimension(130, 25));
        taxTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                taxTextFieldMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                taxTextFieldMouseExited(evt);
            }
        });
        taxTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                taxTextFieldKeyPressed(evt);
            }
        });

        shiftEmployeeListComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        shiftEmployeeListComboBox.setToolTipText("");
        shiftEmployeeListComboBox.setMaximumSize(new java.awt.Dimension(130, 25));
        shiftEmployeeListComboBox.setMinimumSize(new java.awt.Dimension(130, 25));
        shiftEmployeeListComboBox.setPreferredSize(new java.awt.Dimension(130, 25));
        shiftEmployeeListComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                shiftEmployeeListComboBoxItemStateChanged(evt);
            }
        });

        noteArea.setColumns(20);
        noteArea.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        noteArea.setRows(5);
        noteArea.setBorder(javax.swing.BorderFactory.createTitledBorder("Ghi chú ca"));
        noteScrollPane.setViewportView(noteArea);

        cashierComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cashierComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn nhân viên" }));
        cashierComboBox.setSelectedIndex(-1);
        cashierComboBox.setMaximumSize(new java.awt.Dimension(130, 25));
        cashierComboBox.setMinimumSize(new java.awt.Dimension(130, 25));
        cashierComboBox.setName(""); // NOI18N
        cashierComboBox.setPreferredSize(new java.awt.Dimension(130, 25));
        cashierComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cashierComboBoxItemStateChanged(evt);
            }
        });

        addToEmployeeListComboBox.setText("Thêm ");
        addToEmployeeListComboBox.setMaximumSize(new java.awt.Dimension(72, 25));
        addToEmployeeListComboBox.setMinimumSize(new java.awt.Dimension(72, 25));
        addToEmployeeListComboBox.setPreferredSize(new java.awt.Dimension(72, 25));
        addToEmployeeListComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToEmployeeListComboBoxActionPerformed(evt);
            }
        });

        removeFromEmployeeListComboBox.setText("Xóa");
        removeFromEmployeeListComboBox.setMaximumSize(new java.awt.Dimension(72, 25));
        removeFromEmployeeListComboBox.setMinimumSize(new java.awt.Dimension(72, 25));
        removeFromEmployeeListComboBox.setPreferredSize(new java.awt.Dimension(72, 25));
        removeFromEmployeeListComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeFromEmployeeListComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout inputPanelLayout = new javax.swing.GroupLayout(inputPanel);
        inputPanel.setLayout(inputPanelLayout);
        inputPanelLayout.setHorizontalGroup(
            inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inputPanelLayout.createSequentialGroup()
                        .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(openBalanceLabel)
                            .addComponent(taxShiftLabel))
                        .addGap(5, 5, 5)
                        .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(openBalanceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(taxTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(inputPanelLayout.createSequentialGroup()
                        .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cashierLabel)
                            .addComponent(employeeListLabel))
                        .addGap(18, 18, 18)
                        .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputPanelLayout.createSequentialGroup()
                                .addComponent(addToEmployeeListComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(removeFromEmployeeListComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(shiftEmployeeListComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cashierComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(noteScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        inputPanelLayout.setVerticalGroup(
            inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inputPanelLayout.createSequentialGroup()
                        .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(openBalanceLabel)
                            .addComponent(openBalanceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(taxTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(taxShiftLabel))
                        .addGap(6, 6, 6)
                        .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cashierLabel)
                            .addComponent(cashierComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(employeeListLabel)
                            .addComponent(shiftEmployeeListComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(removeFromEmployeeListComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addToEmployeeListComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(noteScrollPane))
                .addContainerGap())
        );

        getContentPane().add(inputPanel, java.awt.BorderLayout.PAGE_START);

        tableAndBtnPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách nhân viên cửa hàng"));

        employeeListTable.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        employeeListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Họ", "Tên", "Giới tính", "SĐT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        employeeListTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        employeeListTable.setMaximumSize(new java.awt.Dimension(530, 360));
        employeeListTable.setMinimumSize(new java.awt.Dimension(530, 360));
        employeeListTable.setPreferredSize(new java.awt.Dimension(530, 360));
        employeeListTable.setShowGrid(true);
        employeeListScrollPane.setViewportView(employeeListTable);

        acceptBtn.setBackground(new java.awt.Color(0, 255, 0));
        acceptBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        acceptBtn.setText("Xác nhận");
        acceptBtn.setMaximumSize(new java.awt.Dimension(83, 25));
        acceptBtn.setMinimumSize(new java.awt.Dimension(83, 25));
        acceptBtn.setPreferredSize(new java.awt.Dimension(83, 25));
        acceptBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptBtnActionPerformed(evt);
            }
        });

        denyBtn.setBackground(new java.awt.Color(255, 0, 0));
        denyBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        denyBtn.setForeground(new java.awt.Color(255, 255, 255));
        denyBtn.setText("Hủy");
        denyBtn.setMaximumSize(new java.awt.Dimension(83, 25));
        denyBtn.setMinimumSize(new java.awt.Dimension(83, 25));
        denyBtn.setPreferredSize(new java.awt.Dimension(83, 25));
        denyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                denyBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tableAndBtnPanelLayout = new javax.swing.GroupLayout(tableAndBtnPanel);
        tableAndBtnPanel.setLayout(tableAndBtnPanelLayout);
        tableAndBtnPanelLayout.setHorizontalGroup(
            tableAndBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tableAndBtnPanelLayout.createSequentialGroup()
                .addContainerGap(326, Short.MAX_VALUE)
                .addComponent(denyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(acceptBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(tableAndBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(tableAndBtnPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(employeeListScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        tableAndBtnPanelLayout.setVerticalGroup(
            tableAndBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tableAndBtnPanelLayout.createSequentialGroup()
                .addGap(0, 159, Short.MAX_VALUE)
                .addGroup(tableAndBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(acceptBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(denyBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(tableAndBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(tableAndBtnPanelLayout.createSequentialGroup()
                    .addComponent(employeeListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 34, Short.MAX_VALUE)))
        );

        getContentPane().add(tableAndBtnPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cashierComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cashierComboBoxItemStateChanged
        if (cashierComboBox.getSelectedIndex() == 0) {
            int selectedRow = employeeListTable.getSelectedRow();
            if (selectedRow == -1) { // Kiểm tra xem chọn ở bảng chưa
                showCashierComboBoxSelectedItem();
                JOptionPane.showMessageDialog(this, NOTHING_CHOOSEN_FROM_TABLE_WARNING,
                        "Lỗi", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String phoneNum = employeeListTable.getValueAt(selectedRow, 3).toString();
            Employee employee = employeeListCtr.containEmployee(store.getEmployeeList(), phoneNum,
                    employeeListCtr.BY_PHONE_NUMBER);
            Employee employeeInShift = employeeListCtr.containEmployee(shiftEmployeeList, phoneNum, 
                    employeeListCtr.BY_PHONE_NUMBER);
            if(employeeInShift != null){
                shiftEmployeeList.getList().remove(employeeInShift);
                passValueToEmployeeListComboBox();
            }
            if (!employee.toString().equals(shiftCashier.toString())) {
                shiftCashier = employee;
                passValueToCashierComboBox();
            }
            showCashierComboBoxSelectedItem();
        }
    }//GEN-LAST:event_cashierComboBoxItemStateChanged

    private void shiftEmployeeListComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_shiftEmployeeListComboBoxItemStateChanged
        if (shiftEmployeeListComboBox.getSelectedIndex() == -1
                && shiftEmployeeListComboBox.getItemCount() >= 1) {
            shiftEmployeeListComboBox.setSelectedIndex(0);
        }
    }//GEN-LAST:event_shiftEmployeeListComboBoxItemStateChanged

    private void taxTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_taxTextFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String taxStr = taxTextField.getText();
            if (taxStr.isBlank()) { //Kiểm tra ô trống
                taxTextField.setText("0");
                shiftTax = 0;
                return;
            }
            if (!ctions.checkIfAValidNumberForGUI(taxStr)) {
                insertWarningToTextField(openBalanceTextField, INVALID_WARNING, 14);
                checkTax = false;
                return;
            }
            checkTax = true;
            shiftTax = Math.min(Integer.parseInt(taxStr), 100);
            taxTextField.setText(shiftTax + "");
            cashierComboBox.requestFocus();
        }
    }//GEN-LAST:event_taxTextFieldKeyPressed

    private void taxTextFieldMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_taxTextFieldMouseExited
        String taxStr = taxTextField.getText();
        if (taxStr.isBlank()) { //Kiểm tra ô trống
            taxTextField.setText("0");
            shiftTax = 0;
            checkTax = false;
            return;
        }
        if (!ctions.checkIfAValidNumberForGUI(taxStr)) {
            insertWarningToTextField(taxTextField, INVALID_WARNING, 14);
            checkTax = false;
            return;
        }
        checkTax = true;
        shiftTax = Math.min(Integer.parseInt(taxStr), 100);
        taxTextField.setText(shiftTax + "");
    }//GEN-LAST:event_taxTextFieldMouseExited

    private void taxTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_taxTextFieldMouseClicked
        if (!checkTax) {
            setDefaultOptionToTextField(taxTextField, 14);
        }
    }//GEN-LAST:event_taxTextFieldMouseClicked

    private void openBalanceTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_openBalanceTextFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String openBalanceStr = openBalanceTextField.getText();
            if (openBalanceStr.isBlank()) { //Kiểm tra ô trống
                openBalanceTextField.setText("0.0");
                shiftOpenBalance = BigDecimal.ZERO;
                return;
            }
            if (!ctions.checkIfAValidNumberForGUI(openBalanceStr)) {
                insertWarningToTextField(openBalanceTextField, INVALID_WARNING, 14);
                checkOpenBalance = false;
                return;
            }
            checkOpenBalance = true;
            shiftOpenBalance = new BigDecimal(openBalanceStr);
            openBalanceTextField.setText(String.format("%.1f", shiftOpenBalance));
            taxTextField.requestFocus();
        }
    }//GEN-LAST:event_openBalanceTextFieldKeyPressed

    private void openBalanceTextFieldMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openBalanceTextFieldMouseExited
        String openBalanceStr = openBalanceTextField.getText();
        if (openBalanceStr.isBlank()) { //Kiểm tra ô trống
            openBalanceTextField.setText("0.0");
            shiftOpenBalance = BigDecimal.ZERO;
            return;
        }
        if (!ctions.checkIfAValidNumberForGUI(openBalanceStr)) {
            insertWarningToTextField(openBalanceTextField, INVALID_WARNING, 14);
            checkOpenBalance = false;
            return;
        }
        checkOpenBalance = true;
        shiftOpenBalance = new BigDecimal(openBalanceStr);
        openBalanceTextField.setText(String.format("%.1f", shiftOpenBalance));
    }//GEN-LAST:event_openBalanceTextFieldMouseExited

    private void openBalanceTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openBalanceTextFieldMouseClicked
        if (!checkOpenBalance) {
            setDefaultOptionToTextField(openBalanceTextField, 14);
        }
    }//GEN-LAST:event_openBalanceTextFieldMouseClicked

    private void denyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_denyBtnActionPerformed
        int choice = JOptionPane.showConfirmDialog(this,
                SET_DEFAULT_WARNING, "Cảnh báo", JOptionPane.OK_CANCEL_OPTION);
        if (choice == 0) {
            setDefaultToAllComponents();
        }
    }//GEN-LAST:event_denyBtnActionPerformed

    private void removeFromEmployeeListComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeFromEmployeeListComboBoxActionPerformed
        int selectedIndex = shiftEmployeeListComboBox.getSelectedIndex();
        if (selectedIndex != -1) {
            String eToString = shiftEmployeeListComboBox.getSelectedItem().toString();
            shiftEmployeeList.setList( shiftEmployeeList.getList()
                    .stream()
                    .filter(e -> !e.toString().equals(eToString)).toList());
            shiftEmployeeListComboBox.removeItemAt(selectedIndex);
            passValueToEmployeeListComboBox();
            showCashierComboBoxSelectedItem();
        } else {
            JOptionPane.showMessageDialog(this, NOTHING_CHOOSEN_FROM_COMBOBOX_WARNING,
                    "Lỗi", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_removeFromEmployeeListComboBoxActionPerformed

    private void addToEmployeeListComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToEmployeeListComboBoxActionPerformed
        int selectedRow = employeeListTable.getSelectedRow();
        if (selectedRow != -1) {
            String phoneNum = employeeListTable.getValueAt(selectedRow, 3).toString();
            if(phoneNum.equals(shiftCashier.getPhoneNumber())){
                showWarningJOptionPane(CURRENTLY_CASHIER_WARNING);
                return;
            }
            if (employeeListCtr.containEmployee(shiftEmployeeList,
                    phoneNum, employeeListCtr.BY_PHONE_NUMBER) == null) {

                Employee e = employeeListCtr.containEmployee(store.getEmployeeList(),
                        phoneNum,
                        employeeListCtr.BY_PHONE_NUMBER);
                shiftEmployeeList.getList().add(e);
                shiftEmployeeListComboBox.addItem(e.toString());
                passValueToEmployeeListComboBox();
            }else{
                showWarningJOptionPane(ALREADY_IN_EMPLOYEELIST_WARNING);
            }
        } else {
            JOptionPane.showMessageDialog(this, NOTHING_CHOOSEN_FROM_TABLE_WARNING,
                    "Lỗi", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_addToEmployeeListComboBoxActionPerformed

    private void acceptBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptBtnActionPerformed
        if (shiftEmployeeList.getList().isEmpty()
                && shiftCashier.toString().equals(new Employee().toString())) {
            JOptionPane.showMessageDialog(this, BOTH_NOT_SELECTED_WARNING,
                    "Lỗi", JOptionPane.WARNING_MESSAGE);
            return;
        } else if (shiftEmployeeList.getList().isEmpty()) {
            JOptionPane.showMessageDialog(this, SHIFT_EMPLOYEE_NOT_SELECTED_WARNING,
                    "Lỗi", JOptionPane.WARNING_MESSAGE);
            return;
        } else if (shiftCashier.toString().equals(new Employee().toString())) {
            JOptionPane.showMessageDialog(this, CASHIER_NOT_SELECTED_WARNING,
                    "Lỗi", JOptionPane.WARNING_MESSAGE);
            return;
        } else {
            shiftCtr.openShift(store, shift, shiftTax,
                    shiftOpenBalance, shiftCashier,
                    shiftEmployeeList, noteArea.getText());
        }
        shiftPanel.reload(shift);
        this.dispose();
    }//GEN-LAST:event_acceptBtnActionPerformed

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
            java.util.logging.Logger.getLogger(OpenShiftFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OpenShiftFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OpenShiftFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OpenShiftFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new OpenShiftFrame().setVisible(true);
            }
        });
    }

    private void passValueToEmployeeListComboBox() {
        shiftEmployeeListComboBox.removeAllItems();
        shiftEmployeeList.getList()
                .stream()
                .forEach(e -> shiftEmployeeListComboBox.addItem(e.toString()));
    }

    private void passValueToCashierComboBox() {
        if (cashierComboBox.getItemCount() == 2) {
            cashierComboBox.setSelectedIndex(-1);
            cashierComboBox.removeItemAt(1);
        }
        if (!shiftCashier.toString().equals(new Employee().toString())) {
            cashierComboBox.insertItemAt(shiftCashier.toString(), 1);
            cashierComboBox.setSelectedIndex(1);
        }
    }

    private void showWarningJOptionPane(String message) {
        JOptionPane.showMessageDialog(this, message,
                "Lỗi", JOptionPane.WARNING_MESSAGE);
    }
    
    private void setUp() {
        setIconImage(new ImageIcon(getClass().getResource("/ImageIcon/icons8-grocery-store-96.png")).getImage());
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void showCashierComboBoxSelectedItem() {
        if (cashierComboBox.getItemCount() == 1) {
            cashierComboBox.setSelectedIndex(-1);
        } else {
            cashierComboBox.setSelectedIndex(1);
        }
    }

    private void setDefaultOptionToTextField(JTextField textField, int size) {
        textField.setEditable(true);
        textField.setFont(new java.awt.Font("Segoe UI", 0, size));
        textField.setForeground(new java.awt.Color(0, 0, 0));
        textField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textField.setText("");
    }

    private void insertWarningToTextField(JTextField textField, String warningText, int size) {
        textField.setFont(new java.awt.Font("Segoe UI", 2, size)); // NOI18N
        textField.setForeground(new java.awt.Color(255, 0, 0));
        textField.setText(warningText);
        textField.setEditable(false);
    }

    private void computeSizeOfEachColumnInEmployeeListTable() {
        for (Employee e : store.getEmployeeList().getList()) {
            if (e.getFirstName().length() + extraLength > employeeFirstNameMaxSize) {
                employeeFirstNameMaxSize = e.getFirstName().length() + extraLength;
            }
            if (e.getLastName().length() + extraLength > employeeLastNameMaxSize) {
                employeeLastNameMaxSize = e.getLastName().length() + extraLength;
            }
            if (e.getGender().toString().length() + extraLength > employeeGenderMaxSize) {
                employeeGenderMaxSize = e.getGender().toString().length() + extraLength;
            }
            if (e.getPhoneNumber().length() + extraLength > employeePhoneNumMaxSize) {
                employeePhoneNumMaxSize = e.getPhoneNumber().length() + extraLength;
            }
        }
        employeeListTable.getColumnModel().getColumn(0).setMinWidth(employeeFirstNameMaxSize);
        employeeListTable.getColumnModel().getColumn(1).setMinWidth(employeeLastNameMaxSize);
        employeeListTable.getColumnModel().getColumn(2).setMinWidth(employeeGenderMaxSize);
        employeeListTable.getColumnModel().getColumn(3).setMinWidth(employeePhoneNumMaxSize);
    }

    private void clearTableModel(DefaultTableModel tableModel) {
        int numberOfRow = tableModel.getRowCount();
        for (int i = 0; i < numberOfRow; i++) {
            tableModel.removeRow(0);
        }
    }
    
    private void insertEmployeeToEmployeeListTable() {
        clearTableModel(employeeListModel);
        store.getEmployeeList().getList().stream().forEach(e -> employeeListModel.addRow(new Object[]{
            e.getFirstName(),
            e.getLastName(),
            e.getGender(),
            e.getPhoneNumber()
        }));
    }

    private void setDefaultToAllComponents(){
        //set các giá trị đã lưu của ca thành default
        shiftOpenBalance = BigDecimal.ZERO;
        shiftTax = 0;
        shiftCashier = new Employee();
        shiftEmployeeList.getList().clear();
        //set các giá trị component hiển thị thành default
        openBalanceTextField.setText("0");
        taxTextField.setText("0");
        passValueToCashierComboBox();
        passValueToEmployeeListComboBox();
    }
    
    public void reload() {
        //set các giá trị đã lưu của ca thành default
        shiftOpenBalance = shift.getOpeningBalance();
        shiftTax = shift.getTax();
        shiftCashier = (shift.getCashier() == null) ? new Employee() : shift.getCashier();
        shiftEmployeeList = shift.getEmployeeOfThisShift();
        checkOpenBalance = true;
        checkTax = true;
        //set các giá trị component hiển thị thành default
        openBalanceTextField.setText(String.format("%.1f", shiftOpenBalance));
        taxTextField.setText(shiftTax+"");
        passValueToCashierComboBox();
        passValueToEmployeeListComboBox();
        computeSizeOfEachColumnInEmployeeListTable();
        insertEmployeeToEmployeeListTable();
    }

    private void initVariables() {
        // Table
        employeeListModel = (DefaultTableModel) employeeListTable.getModel();
        employeeListScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        employeeListScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        // 
        noteScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        noteScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        // Bien Khac
        employeeListCtr = new EmployeeListController();
        shiftCtr = new ShiftController();
        ctions = new Cautions();
        store = new Store();
    }

    public void passData(Store store, Shift shift, ShiftPanel shiftPanel) {
        this.shiftPanel = shiftPanel;
        this.store = store;
        this.shift = shift;
    }

    private Shift shift;
    private boolean checkOpenBalance = false;
    private boolean checkTax = false;
    private BigDecimal shiftOpenBalance;
    private int shiftTax;
    private EmployeeList shiftEmployeeList;
    private Employee shiftCashier;
    private Store store;
    private EmployeeListController employeeListCtr;
    private ShiftController shiftCtr;
    private final int extraLength = 100;
    private int employeeFirstNameMaxSize = "Ho".length();
    private int employeeLastNameMaxSize = "Ten".length();
    private int employeeGenderMaxSize = "Gioi tinh".length();
    private int employeePhoneNumMaxSize = "SDT".length();
    private ShiftPanel shiftPanel;
    private DefaultTableModel employeeListModel;
    private Cautions ctions;
    private final String CASHIER_NOT_SELECTED_WARNING = "Thực hiện chọn thu ngân ca!";
    private final String SHIFT_EMPLOYEE_NOT_SELECTED_WARNING = "Thực hiện thêm nhân viên ca!";
    private final String BOTH_NOT_SELECTED_WARNING = "Thực hiện thêm nhân viên và thu ngân ca!";
    private final String SET_DEFAULT_WARNING = "Đặt lại giá trị ban đầu cho toàn bộ thay đổi?";
    private final String INVALID_WARNING = "Không hợp lệ!";
    private final String ALREADY_IN_EMPLOYEELIST_WARNING = "Danh sách nhân viên trực đã tồn tại người này!";
    private final String CURRENTLY_CASHIER_WARNING = "Người này đang là thu ngân!";
    private final String NOTHING_CHOOSEN_FROM_TABLE_WARNING = "Thực hiện chọn ở bảng trước!";
    private final String NOTHING_CHOOSEN_FROM_COMBOBOX_WARNING = "Thực hiện chọn ở hộp chọn trước!";
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acceptBtn;
    private javax.swing.JButton addToEmployeeListComboBox;
    private javax.swing.JComboBox<String> cashierComboBox;
    private javax.swing.JLabel cashierLabel;
    private javax.swing.JButton denyBtn;
    private javax.swing.JLabel employeeListLabel;
    private javax.swing.JScrollPane employeeListScrollPane;
    private javax.swing.JTable employeeListTable;
    private javax.swing.JPanel inputPanel;
    private javax.swing.JTextArea noteArea;
    private javax.swing.JScrollPane noteScrollPane;
    private javax.swing.JLabel openBalanceLabel;
    private javax.swing.JTextField openBalanceTextField;
    private javax.swing.JButton removeFromEmployeeListComboBox;
    private javax.swing.JComboBox<String> shiftEmployeeListComboBox;
    private javax.swing.JPanel tableAndBtnPanel;
    private javax.swing.JLabel taxShiftLabel;
    private javax.swing.JTextField taxTextField;
    // End of variables declaration//GEN-END:variables
}
