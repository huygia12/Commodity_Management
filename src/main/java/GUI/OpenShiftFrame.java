/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Controllers.EmployeeListController;
import Models.Employee;
import Models.EmployeeList;
import Models.Shift;
import Ultility.Cautions;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
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
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        tableAndBtnPanel = new javax.swing.JPanel();
        employeeListScrollPane = new javax.swing.JScrollPane();
        employeeListTable = new javax.swing.JTable();
        acceptBtn = new javax.swing.JButton();
        denyBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mở Ca Làm Việc");
        setMinimumSize(new java.awt.Dimension(530, 420));
        setPreferredSize(new java.awt.Dimension(530, 420));
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
        openBalanceTextField.setMinimumSize(new java.awt.Dimension(130, 22));
        openBalanceTextField.setPreferredSize(new java.awt.Dimension(130, 22));
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
        taxTextField.setMinimumSize(new java.awt.Dimension(130, 22));
        taxTextField.setPreferredSize(new java.awt.Dimension(130, 22));
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
        shiftEmployeeListComboBox.setSelectedIndex(-1);
        shiftEmployeeListComboBox.setToolTipText("");
        shiftEmployeeListComboBox.setMinimumSize(new java.awt.Dimension(130, 22));
        shiftEmployeeListComboBox.setPreferredSize(new java.awt.Dimension(130, 22));
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
        cashierComboBox.setMinimumSize(new java.awt.Dimension(130, 22));
        cashierComboBox.setName(""); // NOI18N
        cashierComboBox.setPreferredSize(new java.awt.Dimension(130, 22));
        cashierComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cashierComboBoxItemStateChanged(evt);
            }
        });

        jButton2.setText("Thêm ");

        jButton3.setText("Xóa");

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
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addGap(10, 10, 10)
                        .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(taxTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(taxShiftLabel))
                        .addGap(10, 10, 10)
                        .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cashierLabel)
                            .addComponent(cashierComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(employeeListLabel)
                            .addComponent(shiftEmployeeListComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton2))
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
        employeeListTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                employeeListTableMouseClicked(evt);
            }
        });
        employeeListScrollPane.setViewportView(employeeListTable);

        acceptBtn.setBackground(new java.awt.Color(0, 255, 0));
        acceptBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        acceptBtn.setText("Xác nhận");

        denyBtn.setBackground(new java.awt.Color(255, 0, 0));
        denyBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        denyBtn.setText("Hủy");
        denyBtn.setMaximumSize(new java.awt.Dimension(83, 23));
        denyBtn.setMinimumSize(new java.awt.Dimension(83, 23));
        denyBtn.setPreferredSize(new java.awt.Dimension(83, 23));
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
                .addContainerGap(314, Short.MAX_VALUE)
                .addComponent(denyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(acceptBtn)
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
                .addGap(153, 153, 153)
                .addGroup(tableAndBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(denyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(acceptBtn)))
            .addGroup(tableAndBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(tableAndBtnPanelLayout.createSequentialGroup()
                    .addComponent(employeeListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 31, Short.MAX_VALUE)))
        );

        getContentPane().add(tableAndBtnPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void employeeListTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeeListTableMouseClicked
        int selectedRow = employeeListTable.getSelectedRow();
        if(selectedRow!=-1){
            String phoneNum = employeeListTable.getValueAt(selectedRow, 3).toString();
            Employee e = employeeListCtr.containEmployee(employeeList, 
                            phoneNum, 
                            employeeListCtr.BY_PHONE_NUMBER);
            if(checkShiftEmployeeList 
                    && employeeListCtr.containEmployee(shiftEmployeeList, 
                            phoneNum, 
                            employeeListCtr.BY_PHONE_NUMBER) == null){
                // nêu đang chọn thêm nhân viên ca và danh sách nhân viên ca chưa có nhân viên này
                // thực hiện thêm 
                shiftEmployeeList.getList().add(e);
                passValueToCashierComboBox();
            }
            else if(checkCashier && !shiftCashier.toString().equals(e.toString())){
                // nêu đang chọn thu ngân ca
                // thực hiện thêm hoặc thay đổi nhân viên nếu đã tồn tại
                shiftCashier = e;
                passValueToCashierComboBox();
            }
        }
    }//GEN-LAST:event_employeeListTableMouseClicked

    private void cashierComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cashierComboBoxItemStateChanged
        int selectedIndex = cashierComboBox.getSelectedIndex();
        int selectedRow = employeeListTable.getSelectedRow();
        if(selectedRow == -1){
            checkCashier = false;
            cashierComboBox.insertItemAt(, WIDTH);
        }
        if(selectedIndex == 0){
            String phoneNum = employeeListTable.getValueAt(selectedRow, 3).toString();
            Employee e = employeeListCtr.containEmployee(employeeList, phoneNum, 
                    employeeListCtr.BY_PHONE_NUMBER);
            if(!e.toString().equals(shiftCashier.toString())){
                shiftCashier = e;
                passValueToCashierComboBox();
                cashierComboBox.setSelectedIndex(1);
            }
        }
    }//GEN-LAST:event_cashierComboBoxItemStateChanged

    private void shiftEmployeeListComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_shiftEmployeeListComboBoxItemStateChanged
        int selectedIndex = shiftEmployeeListComboBox.getSelectedIndex();
        int selectedRow = employeeListTable.getSelectedRow();
        if(selectedIndex == 0 && selectedRow != -1){
            checkShiftEmployeeList = true;
            // chọn nhân viên ca thì thôi chọn thu ngân
            checkCashier = false;
            shiftEmployeeListComboBox.setSelectedIndex(-1);
        }
    }//GEN-LAST:event_shiftEmployeeListComboBoxItemStateChanged

    private void taxTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_taxTextFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String taxStr = taxTextField.getText();
            if (taxStr.isBlank()) { //Kiểm tra ô trống
                insertWarningToTextField(openBalanceTextField, EMPTY_TEXT_FIELD_WARNING, 14);
                checkTax = false;
                return;
            }
            if (!ctions.checkIfAValidNumberForGUI(taxStr)) {
                insertWarningToTextField(openBalanceTextField, NOTHING_CHOOSEN_WARNING, 14);
                checkTax = false;
                return;
            }
            checkTax = true;
            shiftTax = Integer.parseInt(taxStr);
            shiftEmployeeListComboBox.requestFocus();
        }
    }//GEN-LAST:event_taxTextFieldKeyPressed

    private void taxTextFieldMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_taxTextFieldMouseExited
        String taxStr = taxTextField.getText();
        if (taxStr.isBlank()) { //Kiểm tra ô trống
            insertWarningToTextField(taxTextField, EMPTY_TEXT_FIELD_WARNING, 14);
            checkTax = false;
            return;
        }
        if (!ctions.checkIfAValidNumberForGUI(taxStr)) {
            insertWarningToTextField(taxTextField, NOTHING_CHOOSEN_WARNING, 14);
            checkTax = false;
            return;
        }
        checkTax = true;
        shiftTax = Integer.parseInt(taxStr);
    }//GEN-LAST:event_taxTextFieldMouseExited

    private void taxTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_taxTextFieldMouseClicked
        if(!checkTax){
            setDefaultOptionToTextField(taxTextField, 14);
        }
    }//GEN-LAST:event_taxTextFieldMouseClicked

    private void openBalanceTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_openBalanceTextFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String openBalanceStr = openBalanceTextField.getText();
            if (openBalanceStr.isBlank()) { //Kiểm tra ô trống
                insertWarningToTextField(openBalanceTextField, EMPTY_TEXT_FIELD_WARNING, 14);
                checkOpenBalance = false;
                return;
            }
            if (!ctions.checkIfAValidNumberForGUI(openBalanceStr)) {
                insertWarningToTextField(openBalanceTextField, NOTHING_CHOOSEN_WARNING, 14);
                checkOpenBalance = false;
                return;
            }
            checkOpenBalance = true;
            shiftOpenBalance = new BigDecimal(openBalanceStr);
            taxTextField.requestFocus();
        }
    }//GEN-LAST:event_openBalanceTextFieldKeyPressed

    private void openBalanceTextFieldMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openBalanceTextFieldMouseExited
        String openBalanceStr = openBalanceTextField.getText();
        if (openBalanceStr.isBlank()) { //Kiểm tra ô trống
            insertWarningToTextField(openBalanceTextField, EMPTY_TEXT_FIELD_WARNING, 14);
            checkOpenBalance = false;
            return;
        }
        if (!ctions.checkIfAValidNumberForGUI(openBalanceStr)) {
            insertWarningToTextField(openBalanceTextField, NOTHING_CHOOSEN_WARNING, 14);
            checkOpenBalance = false;
            return;
        }
        checkOpenBalance = true;
        shiftOpenBalance = new BigDecimal(openBalanceStr);
    }//GEN-LAST:event_openBalanceTextFieldMouseExited

    private void openBalanceTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openBalanceTextFieldMouseClicked
        if (!checkOpenBalance) {
            setDefaultOptionToTextField(openBalanceTextField, 14);
        }
    }//GEN-LAST:event_openBalanceTextFieldMouseClicked

    private void denyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_denyBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_denyBtnActionPerformed

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new OpenShiftFrame().setVisible(true);
            }
        });
    }

    private void passValueToEmployeeListComboBox(){
        shiftEmployeeList.getList()
                .stream()
                .forEach(e->shiftEmployeeListComboBox.addItem(e.toString()));
    }
    
    private void passValueToCashierComboBox(){
        if(cashierComboBox.getItemCount() == 2){
            cashierComboBox.removeItemAt(1);
        }
        cashierComboBox.insertItemAt(shiftCashier.toString(), 1);
    }
    
    private void setUp(){
        setIconImage(new ImageIcon(IMAGE_FOLDER + SEPARATOR + "icons8-grocery-store-96.png").getImage());
        this.setLocationRelativeTo(null);
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
        for (Employee e : employeeList.getList()) {
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

    private void insertWarningToComboBox(JComboBox<String> comboBox, String warningText){
        comboBox.addItem(warningText);
        comboBox.setFont(new java.awt.Font("Segoe UI", 0, 14));
        comboBox.setForeground(Color.red);
        comboBox.setSelectedIndex(comboBox.getItemCount()-1);
        comboBox.setEnabled(false);
    }
    
    private void insertEmployeeToEmployeeListTable() {
        employeeList.getList().stream().forEach(e -> employeeListModel.addRow(new Object[]{
            e.getFirstName(),
            e.getLastName(),
            e.getGender(),
            e.getPhoneNumber()
        }));
    }

    public void passData(EmployeeList employeeList, Shift shift) {
        this.employeeList = employeeList;
        this.shift = shift;
        initVariables(employeeList);
    }

    private void initVariables(EmployeeList employeeList) {
        this.employeeList = employeeList;
        // Table
        employeeListModel = (DefaultTableModel) employeeListTable.getModel();
        employeeListScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        employeeListScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        computeSizeOfEachColumnInEmployeeListTable();
        insertEmployeeToEmployeeListTable();
        // 
        noteScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        noteScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        // Bien Khac
        employeeListCtr = new EmployeeListController();
        ctions = new Cautions();
        shiftOpenBalance = BigDecimal.ZERO;
        shiftTax = 0;
        shiftEmployeeList = new EmployeeList(new ArrayList<>());
        shiftCashier = new Employee();
        shiftNote = "";
    }

    private boolean checkOpenBalance = false;
    private boolean checkTax = false;
    private boolean checkShiftEmployeeList = false;
    private boolean checkCashier = false;
    private BigDecimal shiftOpenBalance;
    private int shiftTax;
    private EmployeeList shiftEmployeeList;
    private Employee shiftCashier;
    private String shiftNote;
    private EmployeeListController employeeListCtr;
    private final int extraLength = 100;
    private int employeeFirstNameMaxSize = "Ho".length();
    private int employeeLastNameMaxSize = "Ten".length();
    private int employeeGenderMaxSize = "Gioi tinh".length();
    private int employeePhoneNumMaxSize = "SDT".length();
    private EmployeeList employeeList;
    private Shift shift;
    private DefaultTableModel employeeListModel;
    private Cautions ctions;
    private final String EMPTY_TEXT_FIELD_WARNING = "Ô nhập trống!";
    private final String INVALID_WARNING = "Không hợp lệ!";
    private final String NOTHING_CHOOSEN_WARNING = "Chọn ở bảng!";
    private static final String HOME = System.getProperty("user.dir");
    private static final String SEPARATOR = File.separator;
    private static final String IMAGE_FOLDER = HOME + SEPARATOR + "src" + SEPARATOR + "main" + SEPARATOR + "java" + SEPARATOR + "ImageIcon";
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acceptBtn;
    private javax.swing.JComboBox<String> cashierComboBox;
    private javax.swing.JLabel cashierLabel;
    private javax.swing.JButton denyBtn;
    private javax.swing.JLabel employeeListLabel;
    private javax.swing.JScrollPane employeeListScrollPane;
    private javax.swing.JTable employeeListTable;
    private javax.swing.JPanel inputPanel;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JTextArea noteArea;
    private javax.swing.JScrollPane noteScrollPane;
    private javax.swing.JLabel openBalanceLabel;
    private javax.swing.JTextField openBalanceTextField;
    private javax.swing.JComboBox<String> shiftEmployeeListComboBox;
    private javax.swing.JPanel tableAndBtnPanel;
    private javax.swing.JLabel taxShiftLabel;
    private javax.swing.JTextField taxTextField;
    // End of variables declaration//GEN-END:variables
}