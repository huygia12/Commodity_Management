package gui;

import config.HibernateConfig;
import dao.ShiftDAO;
import dao.impl.ShiftDAOImpl;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import model.ComboBoxItem;
import model.entities.Employee;
import model.entities.Shift;
import model.entities.Store;
import model.enums.Gender;
import util.ShiftUtil;
import util.ValidateInput;

public class OpenShiftFrame extends javax.swing.JFrame {

    public OpenShiftFrame() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/ImageIcon/icons8-grocery-store-96.png")).getImage());
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inputPanel = new javax.swing.JPanel();
        openBalanceLabel = new javax.swing.JLabel();
        employeeListLabel = new javax.swing.JLabel();
        cashierLabel = new javax.swing.JLabel();
        openBalanceTextField = new javax.swing.JTextField();
        shiftEmployeeListComboBox = new javax.swing.JComboBox<>();
        cashierComboBox = new javax.swing.JComboBox<>();
        addToEmployeeListComboBox = new javax.swing.JButton();
        removeFromEmployeeListComboBox = new javax.swing.JButton();
        tableAndBtnPanel = new javax.swing.JPanel();
        employeeListScrollPane = new javax.swing.JScrollPane();
        employeeTable = new javax.swing.JTable();
        acceptBtn = new javax.swing.JButton();
        denyBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mở Ca Làm Việc");
        setMinimumSize(new java.awt.Dimension(530, 400));
        setResizable(false);

        openBalanceLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        openBalanceLabel.setText("Số Dư Đầu Ca : ");

        employeeListLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        employeeListLabel.setText("Nhân Viên Trực Ca:");

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

        cashierComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cashierComboBox.setModel(new DefaultComboBoxModel<>(new ComboBoxItem[] { new ComboBoxItem("1", "Cashier 1") }));
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputPanelLayout.createSequentialGroup()
                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(inputPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cashierLabel)
                            .addComponent(employeeListLabel)
                            .addComponent(openBalanceLabel))
                        .addGap(48, 48, 48)
                        .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cashierComboBox, 0, 344, Short.MAX_VALUE)
                            .addComponent(openBalanceTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(shiftEmployeeListComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(inputPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addToEmployeeListComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(removeFromEmployeeListComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        inputPanelLayout.setVerticalGroup(
            inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(openBalanceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(openBalanceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cashierComboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cashierLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(shiftEmployeeListComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(employeeListLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addToEmployeeListComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(removeFromEmployeeListComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        getContentPane().add(inputPanel, java.awt.BorderLayout.PAGE_START);

        tableAndBtnPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách nhân viên cửa hàng"));

        employeeTable.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        employeeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Họ và tên", "Giới tính"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        employeeTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        employeeTable.setMaximumSize(new java.awt.Dimension(530, 360));
        employeeTable.setMinimumSize(new java.awt.Dimension(530, 360));
        employeeTable.setPreferredSize(new java.awt.Dimension(530, 360));
        employeeTable.setShowGrid(true);
        employeeListScrollPane.setViewportView(employeeTable);

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
            .addGroup(tableAndBtnPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tableAndBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tableAndBtnPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(denyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(acceptBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(employeeListScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE))
                .addContainerGap())
        );
        tableAndBtnPanelLayout.setVerticalGroup(
            tableAndBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tableAndBtnPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(employeeListScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tableAndBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(acceptBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(denyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        getContentPane().add(tableAndBtnPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cashierComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cashierComboBoxItemStateChanged
        if (cashierComboBox.getSelectedIndex() != 0) {
            return;
        }

        int selectedRow = employeeTable.getSelectedRow();
        if (selectedRow == -1) { // Kiểm tra xem chọn ở bảng chưa
            refreshCashierComboBoxSelectedItem();
            JOptionPane.showMessageDialog(this, NOTHING_CHOOSEN_FROM_TABLE_WARNING,
                    "Lỗi", JOptionPane.WARNING_MESSAGE);
            return;
        }

        UUID employeeId = UUID.fromString((String) employeeTable.getValueAt(selectedRow, 2));

        Optional<Employee> matchedEmployee = this.store.getEmployees()
                .stream()
                .filter(employee -> employee.getEmployeeId().equals(employeeId))
                .findFirst();

        matchedEmployee.ifPresent(employee -> {
            cashier = employee;
            refreshCashierComboBoxSelectedItem();
            refreshEmployeeTable();
        });
    }//GEN-LAST:event_cashierComboBoxItemStateChanged

    private void shiftEmployeeListComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_shiftEmployeeListComboBoxItemStateChanged
        if (shiftEmployeeListComboBox.getSelectedIndex() == -1
                && shiftEmployeeListComboBox.getItemCount() >= 1) {
            shiftEmployeeListComboBox.setSelectedIndex(0);
        }
    }//GEN-LAST:event_shiftEmployeeListComboBoxItemStateChanged

    private void openBalanceTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_openBalanceTextFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String openBalanceStr = openBalanceTextField.getText();
            if (openBalanceStr.isBlank()) {
                openBalanceTextField.setText("0");
                shiftOpenBalance = 0;
                return;
            }
            if (!ValidateInput.checkIfAValidNumberForGUI(openBalanceStr)) {
                insertWarningToTextField(openBalanceTextField, INVALID_WARNING, 14);
                checkOpenBalance = false;
                return;
            }
            checkOpenBalance = true;
            shiftOpenBalance = Integer.parseInt(openBalanceStr);
            openBalanceTextField.setText(String.format("%d", shiftOpenBalance));
        }
    }//GEN-LAST:event_openBalanceTextFieldKeyPressed

    private void openBalanceTextFieldMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openBalanceTextFieldMouseExited
        String openBalanceStr = openBalanceTextField.getText();
        if (openBalanceStr.isBlank()) {
            openBalanceTextField.setText("0");
            shiftOpenBalance = 0;
            return;
        }
        if (!ValidateInput.checkIfAValidNumberForGUI(openBalanceStr)) {
            insertWarningToTextField(openBalanceTextField, INVALID_WARNING, 14);
            checkOpenBalance = false;
            return;
        }
        checkOpenBalance = true;
        shiftOpenBalance = Integer.parseInt(openBalanceStr);
        openBalanceTextField.setText(String.format("%d", shiftOpenBalance));
    }//GEN-LAST:event_openBalanceTextFieldMouseExited

    private void openBalanceTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openBalanceTextFieldMouseClicked
        if (!checkOpenBalance) {
            setDefaultOptionToTextField(openBalanceTextField, 14);
        }
    }//GEN-LAST:event_openBalanceTextFieldMouseClicked

    private void denyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_denyBtnActionPerformed
        int choice = JOptionPane.showConfirmDialog(this,
                SET_DEFAULT_WARNING, "Cảnh báo", JOptionPane.OK_CANCEL_OPTION);
        if (choice == JOptionPane.OK_OPTION) {
            setDefaultToAllShiftAttributes();
        }
    }//GEN-LAST:event_denyBtnActionPerformed

    private void removeFromEmployeeListComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeFromEmployeeListComboBoxActionPerformed
        int selectedIndex = shiftEmployeeListComboBox.getSelectedIndex();
        ComboBoxItem selectedItem = (ComboBoxItem) shiftEmployeeListComboBox.getSelectedItem();
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(this, NOTHING_CHOOSEN_FROM_COMBOBOX_WARNING,
                    "Lỗi", JOptionPane.WARNING_MESSAGE);
            return;
        }

        shiftEmployees.removeIf(e -> !e.getEmployeeId().equals(selectedItem.getId()));
        shiftEmployeeListComboBox.removeItemAt(selectedIndex);

        refreshEmployeeComboBox();
        refreshEmployeeTable();
    }//GEN-LAST:event_removeFromEmployeeListComboBoxActionPerformed

    private void addToEmployeeListComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToEmployeeListComboBoxActionPerformed
        int selectedRow = employeeTable.getSelectedRow();
        if (selectedRow != -1) {
            JOptionPane.showMessageDialog(this, NOTHING_CHOOSEN_FROM_TABLE_WARNING,
                    "Lỗi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        UUID employeeId = UUID.fromString((String) employeeTable.getValueAt(selectedRow, 2));

        Optional<Employee> matchedEmployee = this.store.getEmployees()
                .stream()
                .filter(employee -> employee.getEmployeeId().equals(employeeId))
                .findFirst();

        matchedEmployee.ifPresent(employee -> {
            this.shiftEmployees.add(employee);
            refreshEmployeeComboBox();
            refreshEmployeeTable();
        });

    }//GEN-LAST:event_addToEmployeeListComboBoxActionPerformed

    private void acceptBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptBtnActionPerformed
        if (this.shiftEmployees.isEmpty()) {
            JOptionPane.showMessageDialog(this, SHIFT_EMPLOYEE_NOT_SELECTED_WARNING,
                    "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        } else if (this.cashier == null) {
            JOptionPane.showMessageDialog(this, CASHIER_NOT_SELECTED_WARNING,
                    "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        } else {
            this.shift.setOpeningBalance(shiftOpenBalance);
            this.shift.setCashierName(cashier.getFullname());
            this.shift.setCashierId(this.cashier.getEmployeeId());

            if (this.creation) {
                boolean result = shiftDAO.openShift(this.shift, this.shiftEmployees, this.hibernateConfig.getEntityManager());
                if (!result) {
                    JOptionPane.showMessageDialog(this, "Mở ca thất bại!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            } else {
                boolean result = shiftDAO.updateShift(this.shift, this.shiftEmployees, this.hibernateConfig.getEntityManager());
                if (!result) {
                    JOptionPane.showMessageDialog(this, "Cập nhật ca thất bại!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            }
        }
        shiftPanel.refreshCurrentShiftView();
        this.dispose();
    }//GEN-LAST:event_acceptBtnActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OpenShiftFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new OpenShiftFrame().setVisible(true);
            }
        });
    }

    private void refreshEmployeeComboBox() {
        shiftEmployeeListComboBox.removeAllItems();
        this.shiftEmployees
                .stream()
                .forEach(e -> shiftEmployeeListComboBox.addItem(new ComboBoxItem(e.getFullname(), e.getEmployeeId())));
    }

    private void refreshCashierComboBox() {
        if (cashierComboBox.getItemCount() == 2) { // nếu đã chọn cashier rồi
            cashierComboBox.setSelectedIndex(-1);
            cashierComboBox.removeItemAt(1);
        }
        if (this.cashier != null) {
            cashierComboBox.insertItemAt(new ComboBoxItem(this.cashier.getFullname(), this.cashier.getEmployeeId()), 1);
            cashierComboBox.setSelectedIndex(1);
        }
    }

    private void refreshCashierComboBoxSelectedItem() {
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
        textField.setFont(new java.awt.Font("Segoe UI", 2, size));
        textField.setForeground(new java.awt.Color(255, 0, 0));
        textField.setText(warningText);
        textField.setEditable(false);
    }

    private void refreshEmployeeTable() {
        employeeTableModel.setRowCount(0);

        if (employeeTableModel.getColumnCount() == 2) {
            employeeTableModel.addColumn("EmployeeId");
        }

        this.store.getEmployees().stream().forEach(e -> {
            if (this.cashier != null && this.cashier.getEmployeeId() == e.getEmployeeId()) {
                return;
            }
            if (this.shiftEmployees.stream()
                    .anyMatch(employee -> employee.getEmployeeId().equals(e.getEmployeeId()))) {
                return;
            }

            employeeTableModel.addRow(new Object[]{
                e.getFullname(),
                e.getGender() == Gender.MALE ? "Nam" : e.getGender() == Gender.FEMALE ? "Nữ" : "Khác",
                e.getEmployeeId()
            });
        });

        employeeTable.getColumnModel().getColumn(2).setMaxWidth(0);
        employeeTable.getColumnModel().getColumn(2).setMinWidth(0);
        employeeTable.getColumnModel().getColumn(2).setPreferredWidth(0);
    }

    private void setDefaultToAllShiftAttributes() {
        //set các giá trị đã lưu của ca thành default
        shiftOpenBalance = 0;
        cashier = null;
        shiftEmployees.clear();
        //set các giá trị component hiển thị thành default
        openBalanceTextField.setText("0");
        refreshCashierComboBox();
        refreshEmployeeComboBox();
        refreshEmployeeTable();
    }

    public void setToCurrentShiftValue() {
        // thành các giá trị của shift hiện tại
        shiftOpenBalance = this.shift.getOpeningBalance();
        Optional<Employee> matchedEmployee = this.store.getEmployees()
                .stream()
                .filter(employee -> employee.getEmployeeId().equals(this.shift.getCashierId()))
                .findFirst();

        matchedEmployee.ifPresent(employee -> {
            this.cashier = employee;
        });
        this.shiftEmployees = ShiftUtil.getEmployees(shift, store);
        checkOpenBalance = true;

        //set các giá trị component hiển thị thành default
        openBalanceTextField.setText(String.format("%d", shiftOpenBalance));
        refreshCashierComboBox();
        refreshEmployeeComboBox();
        refreshEmployeeTable();
        this.creation = false;
    }

    public void setup(HibernateConfig hibernateConfig, Store store, Shift shift, ShiftPanel shiftPanel) {
        this.shiftPanel = shiftPanel;
        this.store = store;
        this.shift = shift;
        this.hibernateConfig = hibernateConfig;
        this.shiftDAO = new ShiftDAOImpl();
        this.creation = true;

        // Table
        employeeListScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        employeeListScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        employeeTableModel = (DefaultTableModel) employeeTable.getModel();
        setDefaultToAllShiftAttributes();
    }

    private boolean checkOpenBalance = false;
    private int shiftOpenBalance;
    private List<Employee> shiftEmployees = new ArrayList();
    private Employee cashier;
    private boolean creation; //true la tao moi, false la sua

    private ShiftDAO shiftDAO;
    private HibernateConfig hibernateConfig;
    private Store store;
    private Shift shift;
    private ShiftPanel shiftPanel;
    private DefaultTableModel employeeTableModel;
    private final String CASHIER_NOT_SELECTED_WARNING = "Thực hiện chọn thu ngân ca!";
    private final String SHIFT_EMPLOYEE_NOT_SELECTED_WARNING = "Thực hiện thêm nhân viên ca!";
    private final String SET_DEFAULT_WARNING = "Đặt lại giá trị ban đầu cho toàn bộ thay đổi?";
    private final String INVALID_WARNING = "Không hợp lệ!";
    private final String NOTHING_CHOOSEN_FROM_TABLE_WARNING = "Thực hiện chọn ở bảng trước!";
    private final String NOTHING_CHOOSEN_FROM_COMBOBOX_WARNING = "Thực hiện chọn ở hộp chọn trước!";
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acceptBtn;
    private javax.swing.JButton addToEmployeeListComboBox;
    private javax.swing.JComboBox<ComboBoxItem> cashierComboBox;
    private javax.swing.JLabel cashierLabel;
    private javax.swing.JButton denyBtn;
    private javax.swing.JLabel employeeListLabel;
    private javax.swing.JScrollPane employeeListScrollPane;
    private javax.swing.JTable employeeTable;
    private javax.swing.JPanel inputPanel;
    private javax.swing.JLabel openBalanceLabel;
    private javax.swing.JTextField openBalanceTextField;
    private javax.swing.JButton removeFromEmployeeListComboBox;
    private javax.swing.JComboBox<ComboBoxItem> shiftEmployeeListComboBox;
    private javax.swing.JPanel tableAndBtnPanel;
    // End of variables declaration//GEN-END:variables
}
