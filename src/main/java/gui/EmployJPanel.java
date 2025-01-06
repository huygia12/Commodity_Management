package gui;

import config.HibernateConfig;
import dao.EmployeeDAO;
import dao.impl.EmployeeDAOImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.entities.Employee;
import model.entities.Store;
import model.enums.Gender;
import util.FormatOutput;

/**
 *
 * @author DTuyen16
 */
public class EmployJPanel extends javax.swing.JPanel {

    public EmployJPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        genderbuttonGroup = new javax.swing.ButtonGroup();
        inputInfoPanel = new javax.swing.JPanel();
        inputLastNameLabel = new javax.swing.JLabel();
        fullnameInput = new javax.swing.JTextField();
        inputGenderLabel = new javax.swing.JLabel();
        maleButton = new javax.swing.JRadioButton();
        femaleRadioButton = new javax.swing.JRadioButton();
        otherRadioButton = new javax.swing.JRadioButton();
        functionPanel = new javax.swing.JPanel();
        searchButton = new javax.swing.JButton();
        searchIDTextField = new javax.swing.JTextField();
        quantityEmployLabel = new javax.swing.JLabel();
        quantityEmploytextField = new javax.swing.JTextField();
        refreshBtn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        addButton = new javax.swing.JButton();
        changeButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        displayPanel = new javax.swing.JPanel();
        displayScrollPane = new javax.swing.JScrollPane();
        displayTable = new javax.swing.JTable();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "THÔNG TIN NHÂN VIÊN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 18))); // NOI18N
        setMinimumSize(new java.awt.Dimension(1400, 800));
        setPreferredSize(new java.awt.Dimension(1400, 800));

        inputLastNameLabel.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        inputLastNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        inputLastNameLabel.setText("Họ và tên:");

        fullnameInput.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fullnameInputMouseClicked(evt);
            }
        });

        inputGenderLabel.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        inputGenderLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        inputGenderLabel.setText("Giới tính:");

        genderbuttonGroup.add(maleButton);
        maleButton.setSelected(true);
        maleButton.setText("MALE");
        maleButton.setAutoscrolls(true);

        genderbuttonGroup.add(femaleRadioButton);
        femaleRadioButton.setText("FEMALE");

        genderbuttonGroup.add(otherRadioButton);
        otherRadioButton.setText("OTHER");

        searchButton.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        searchButton.setText("TÌM KIẾM");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        quantityEmployLabel.setText("Số lượng nhân viên hiện tại: ");

        quantityEmploytextField.setEditable(false);

        refreshBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageIcon/reload (3).png"))); // NOI18N
        refreshBtn.setBorder(null);
        refreshBtn.setContentAreaFilled(false);
        refreshBtn.setFocusable(false);
        refreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBtnActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout functionPanelLayout = new javax.swing.GroupLayout(functionPanel);
        functionPanel.setLayout(functionPanelLayout);
        functionPanelLayout.setHorizontalGroup(
            functionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(functionPanelLayout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(functionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, functionPanelLayout.createSequentialGroup()
                        .addComponent(quantityEmployLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(quantityEmploytextField, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(refreshBtn))
                    .addGroup(functionPanelLayout.createSequentialGroup()
                        .addComponent(searchIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(searchButton)
                        .addGap(0, 278, Short.MAX_VALUE)))
                .addContainerGap())
        );
        functionPanelLayout.setVerticalGroup(
            functionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(functionPanelLayout.createSequentialGroup()
                .addGap(222, 222, 222)
                .addComponent(refreshBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
            .addGroup(functionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, functionPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(functionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(functionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quantityEmployLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantityEmploytextField, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        addButton.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        addButton.setText("THÊM");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        changeButton.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        changeButton.setText("SỬA");
        changeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeButtonActionPerformed(evt);
            }
        });

        removeButton.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        removeButton.setText("XÓA");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        cancelButton.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cancelButton.setText("HỦY");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout inputInfoPanelLayout = new javax.swing.GroupLayout(inputInfoPanel);
        inputInfoPanel.setLayout(inputInfoPanelLayout);
        inputInfoPanelLayout.setHorizontalGroup(
            inputInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputInfoPanelLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(inputInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inputInfoPanelLayout.createSequentialGroup()
                        .addComponent(inputLastNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fullnameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(inputInfoPanelLayout.createSequentialGroup()
                        .addComponent(inputGenderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(113, 113, 113)
                        .addGroup(inputInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(otherRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(femaleRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(maleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(inputInfoPanelLayout.createSequentialGroup()
                                .addComponent(addButton)
                                .addGap(18, 18, 18)
                                .addComponent(changeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 33, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(functionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        inputInfoPanelLayout.setVerticalGroup(
            inputInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputInfoPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(inputInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputLastNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fullnameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(inputInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maleButton)
                    .addComponent(inputGenderLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(femaleRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(otherRadioButton)
                .addGap(28, 28, 28)
                .addGroup(inputInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(changeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addComponent(functionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        displayTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên", "Giới tính", "Thời gian tạo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        displayTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                displayTableMouseClicked(evt);
            }
        });
        displayScrollPane.setViewportView(displayTable);

        javax.swing.GroupLayout displayPanelLayout = new javax.swing.GroupLayout(displayPanel);
        displayPanel.setLayout(displayPanelLayout);
        displayPanelLayout.setHorizontalGroup(
            displayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1378, Short.MAX_VALUE)
            .addGroup(displayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(displayPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(displayScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 912, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        displayPanelLayout.setVerticalGroup(
            displayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 497, Short.MAX_VALUE)
            .addGroup(displayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(displayPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(displayScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(inputInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(displayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(inputInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(displayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        if (!validateRequiredFields()) {
            JOptionPane.showMessageDialog(this, "Hãy nhập đầy đủ thông tin cơ bản trước khi thêm nhân viên mới!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String fullname = fullnameInput.getText().trim();
        Gender gender = maleButton.isSelected() ? Gender.MALE : femaleRadioButton.isSelected() ? Gender.FEMALE : Gender.OTHER;

        Employee newEmployee = Employee.builder().fullname(fullname).gender(gender).build();
        boolean result = employeeDAO.addEmployee(newEmployee, this.hibernateConfig.getEntityManager());

        if (!result) {
            JOptionPane.showMessageDialog(this, "Thêm thất bại!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        this.store.getEmployees().add(newEmployee);

        displayEmployees(this.store.getEmployees());
        clearInputFields();
        JOptionPane.showMessageDialog(this, "Chào mừng nhân viên mới", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        updateEmployeeCounter(this.store.getEmployees().size());
    }//GEN-LAST:event_addButtonActionPerformed

    private void changeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeButtonActionPerformed
        int selectedRowIndex = displayTable.getSelectedRow();

        if (selectedRowIndex < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một nhân viên để cập nhật thông tin!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String fullname = fullnameInput.getText().trim();
        Gender gender = maleButton.isSelected() ? Gender.MALE : femaleRadioButton.isSelected() ? Gender.FEMALE : Gender.OTHER;

        if (!validateRequiredFields()) {
            JOptionPane.showMessageDialog(this, "Hãy sửa đầy đủ thông tin cơ bản!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int reply = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn chỉnh sửa thông tin nhân viên?", "Xác nhận chỉnh sửa", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            DefaultTableModel model = (DefaultTableModel) displayTable.getModel();
            UUID employeeId = UUID.fromString((String) model.getValueAt(selectedRowIndex, 3));
            Employee newEmployee = Employee.builder().employeeId(employeeId).fullname(fullname).gender(gender).build();
            boolean result = employeeDAO.addEmployee(newEmployee, this.hibernateConfig.getEntityManager());

            if (!result) {
                JOptionPane.showMessageDialog(this, "Chỉnh sửa thất bại!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            this.store.setEmployees(this.store.getEmployees().stream().map(employee -> 
                (employee.getEmployeeId().equals(employeeId)) ? newEmployee : employee).collect(Collectors.toList()));

            displayEmployees(this.store.getEmployees());
            JOptionPane.showMessageDialog(this, "Thông tin nhân viên đã được cập nhật thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            clearInputFields();
            updateEmployeeCounter(this.store.getEmployees().size());
        }
    }//GEN-LAST:event_changeButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        int selectedRowIndex = displayTable.getSelectedRow();

        if (selectedRowIndex < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một nhân viên cần xóa!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int reply = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa nhân viên này không?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            DefaultTableModel model = (DefaultTableModel) displayTable.getModel();
            UUID employeeId = UUID.fromString((String) model.getValueAt(selectedRowIndex, 3));

            boolean result = employeeDAO.deleteEmployee(employeeId, this.hibernateConfig.getEntityManager());
            if (!result) {
                JOptionPane.showMessageDialog(this, "Xóa thất bại!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            this.store.getEmployees().removeIf(employee -> employee.getEmployeeId().equals(employeeId));

            model.removeRow(selectedRowIndex);
            JOptionPane.showMessageDialog(this, "Nhân viên đã được xóa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            updateEmployeeCounter(this.store.getEmployees().size());
        }
    }//GEN-LAST:event_removeButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        String searchValue = searchIDTextField.getText().trim();

        if (searchValue.isBlank()) {
            JOptionPane.showMessageDialog(this, "Bạn cần nhập tên nhân viên tại thanh tìm kiếm");
            return;
        }
        
        List<Employee> searchResult = new ArrayList();
        this.store.getEmployees().forEach(employee -> {
            if(employee.getFullname().toLowerCase().contains(searchValue)){
                searchResult.add(employee);
            }
        });

        if (!searchResult.isEmpty()) {
            displayEmployees(searchResult);
        } else {
            JOptionPane.showMessageDialog(null, "Không tìm thấy nhân viên có thông tin tương ứng");
        }

    }//GEN-LAST:event_searchButtonActionPerformed

    private List<Integer> getRowsForFieldValue(String fieldValue) {
        DefaultTableModel model = (DefaultTableModel) displayTable.getModel();
        int rowCount = model.getRowCount();
        List<Integer> resultRows = new ArrayList<>();

        for (int i = 0; i < rowCount; i++) {
            String firstName = model.getValueAt(i, 0) != null ? model.getValueAt(i, 0).toString() : "";
            String lastName = model.getValueAt(i, 1) != null ? model.getValueAt(i, 1).toString() : "";
            String cccd = model.getValueAt(i, 6) != null ? model.getValueAt(i, 6).toString() : "";
            if (firstName.toLowerCase().contains(fieldValue.toLowerCase()) || lastName.toLowerCase().contains(fieldValue.toLowerCase()) || cccd.contains(fieldValue)) {
                resultRows.add(i);
            }
        }

        return resultRows;
    }

    private void displayTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_displayTableMouseClicked
        clearInputFields();
        int selectedRowIndex = displayTable.getSelectedRow();

        if (selectedRowIndex >= 0) {
            DefaultTableModel model = (DefaultTableModel) displayTable.getModel();

            String fullname = model.getValueAt(selectedRowIndex, 0) != null ? model.getValueAt(selectedRowIndex, 0).toString().trim() : "";
            String gender = model.getValueAt(selectedRowIndex, 1) != null ? model.getValueAt(selectedRowIndex, 1).toString().trim() : "";

            fullnameInput.setText(fullname);

            switch (gender) {
                case "MALE" -> maleButton.setSelected(true);
                case "FEMALE" -> femaleRadioButton.setSelected(true);
                default -> otherRadioButton.setSelected(true);
            }
        }
    }//GEN-LAST:event_displayTableMouseClicked

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        clearInputFields();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void fullnameInputMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fullnameInputMouseClicked
        if (!fullnameInput.isEditable()) {
            textFieldMouseClick(fullnameInput);
        }
    }//GEN-LAST:event_fullnameInputMouseClicked

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        displayEmployees(this.store.getEmployees());
    }//GEN-LAST:event_refreshBtnActionPerformed


    private void displayEmployees(List<Employee> employees) {
        DefaultTableModel model = (DefaultTableModel) displayTable.getModel();
        model.setRowCount(0);

        if (model.getColumnCount() == 3) {
            model.addColumn("EmployeeId");
        }
        for (Employee employee : employees) {
            Object[] rowData = {employee.getFullname(),
                employee.getGender() == Gender.MALE ? "Nam" : employee.getGender() == Gender.FEMALE ?"Nữ" : "Khác",
                FormatOutput.convertLocalDateTimeToString(employee.getCreatedAt()),
                employee.getEmployeeId()};
            model.addRow(rowData);
        }

        displayTable.getColumnModel().getColumn(3).setMaxWidth(0);
        displayTable.getColumnModel().getColumn(3).setMinWidth(0);
        displayTable.getColumnModel().getColumn(3).setPreferredWidth(0);
    }

    private void clearInputFields() {
        setTextFieldProperties(fullnameInput);
        fullnameInput.setText("");
    }

    private void textFieldMouseClick(javax.swing.JTextField textField) {
        textField.setFont(new java.awt.Font("Segoe UI", 0, DEFAULT_TEXT_SIZE));
        textField.setForeground(new java.awt.Color(0, 0, 0));
        textField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textField.setText("");
        textField.setEditable(true);
    }

    private void updateEmployeeCounter(int size) {
        quantityEmploytextField.setText(Integer.toString(size));
    }

    private boolean validateRequiredFields() {
        if (fullnameInput.getText().isBlank()) {
            insertWarningToTextField(fullnameInput, REQUIRED_INPUT);
        }

        return !fullnameInput.getText().isBlank();
    }

    private void insertWarningToTextField(javax.swing.JTextField textField, String warningText) {
        textField.setFont(new java.awt.Font("Segoe UI", java.awt.Font.ITALIC, DEFAULT_TEXT_SIZE));
        textField.setForeground(new java.awt.Color(255, 0, 0));
        textField.setText(warningText);
        textField.setEditable(false);
    }

    private void setTextFieldProperties(javax.swing.JTextField textField) {
        textField.setFont(new java.awt.Font("Segoe UI", 0, DEFAULT_TEXT_SIZE));
        textField.setForeground(new java.awt.Color(0, 0, 0));
        textField.setEditable(true);
    }
    
    public void setup(HibernateConfig hibernateConfig, Store store) {
        this.store = store;
        this.hibernateConfig = hibernateConfig;
        this.employeeDAO = new EmployeeDAOImpl();

        displayEmployees(this.store.getEmployees());
        updateEmployeeCounter(this.store.getEmployees().size());
    }

    private EmployeeDAO employeeDAO;
    private HibernateConfig hibernateConfig;
    private Store store;
    private final String REQUIRED_INPUT = "Không được để trống!";
    private final int DEFAULT_TEXT_SIZE = 11;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton changeButton;
    private javax.swing.JPanel displayPanel;
    private javax.swing.JScrollPane displayScrollPane;
    private javax.swing.JTable displayTable;
    private javax.swing.JRadioButton femaleRadioButton;
    private javax.swing.JTextField fullnameInput;
    private javax.swing.JPanel functionPanel;
    private javax.swing.ButtonGroup genderbuttonGroup;
    private javax.swing.JLabel inputGenderLabel;
    private javax.swing.JPanel inputInfoPanel;
    private javax.swing.JLabel inputLastNameLabel;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton maleButton;
    private javax.swing.JRadioButton otherRadioButton;
    private javax.swing.JLabel quantityEmployLabel;
    private javax.swing.JTextField quantityEmploytextField;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchIDTextField;
    // End of variables declaration//GEN-END:variables
}
