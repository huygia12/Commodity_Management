package GUI;

import Controllers.GoodsListController;
import Models.Goods;
import Models.GoodsList;
import Models.Shipment;
import Models.Store;
import Models.Units;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.animation.timing.Animator;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
/**
 *
 * @author s1rja
 */
public class RepoPanel extends javax.swing.JPanel {

    /**
     * Creates new form RepoPanel
     */
    public RepoPanel() {
        initComponents();
        
        defaultSettings();

    }
    
    public void defaultSettings() {
        unitComboBox.setPrototypeDisplayValue("                           ");
        invalidPriceLabel.setVisible(false);
        invalidIDLabel.setVisible(false);
        addButton.setEnabled(false);
        deleteButton.setEnabled(false);
        editButton.setEnabled(false);
        shipmentsButton.setEnabled(true);
        cancelCheck();
        goodTableModel = (DefaultTableModel) jTable1.getModel();
        Instance = this;
        shipmentsButton.setEnabled(false);
    }
    
    public void externalRefresh() {
        defaultSettings();
        reloadTable(goodsList);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        repoManagementPanel = new javax.swing.JPanel();
        controllerPanel = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        manuFacturerLabel = new javax.swing.JLabel();
        manufacturerTextField = new javax.swing.JTextField();
        listPriceLabel = new javax.swing.JLabel();
        listPriceTextField = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        shipmentsButton = new javax.swing.JButton();
        IDLabel = new javax.swing.JLabel();
        IDTextField = new javax.swing.JTextField();
        totalQuantityLabel = new javax.swing.JLabel();
        totalQuantityTextField = new javax.swing.JTextField();
        unitComboBox = new javax.swing.JComboBox<>();
        invalidPriceLabel = new javax.swing.JLabel();
        invalidIDLabel = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();
        tablePanel = new javax.swing.JPanel();
        searchLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        searchTextField = new javax.swing.JTextField();

        setBackground(new java.awt.Color(0, 204, 255));
        setToolTipText("");
        setPreferredSize(new java.awt.Dimension(970, 560));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        repoManagementPanel.setBackground(new java.awt.Color(0, 204, 255));
        repoManagementPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), 2), "REPOSITORY", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 3, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        repoManagementPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        controllerPanel.setBackground(new java.awt.Color(0, 204, 255));
        controllerPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nameLabel.setText("Tên sản phẩm:");
        controllerPanel.add(nameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(302, 3, 89, -1));

        nameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextFieldActionPerformed(evt);
            }
        });
        nameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nameTextFieldKeyReleased(evt);
            }
        });
        controllerPanel.add(nameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(403, 0, 153, -1));

        manuFacturerLabel.setText("Nhà sản xuất:");
        controllerPanel.add(manuFacturerLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(302, 59, -1, -1));

        manufacturerTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                manufacturerTextFieldKeyReleased(evt);
            }
        });
        controllerPanel.add(manufacturerTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(403, 56, 153, -1));

        listPriceLabel.setText("Giá sản phẩm:");
        controllerPanel.add(listPriceLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(711, 3, 89, -1));

        listPriceTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                listPriceTextFieldKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                listPriceTextFieldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                listPriceTextFieldKeyTyped(evt);
            }
        });
        controllerPanel.add(listPriceTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(812, 0, 153, -1));

        addButton.setText("Thêm hàng");
        addButton.setMaximumSize(new java.awt.Dimension(117, 23));
        addButton.setMinimumSize(new java.awt.Dimension(117, 23));
        addButton.setPreferredSize(new java.awt.Dimension(117, 23));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        controllerPanel.add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(712, 50, 117, -1));

        editButton.setText("Sửa hàng/đơn vị");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });
        controllerPanel.add(editButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(712, 79, -1, -1));

        deleteButton.setText("Xóa hàng/đon vị");
        deleteButton.setMaximumSize(new java.awt.Dimension(117, 23));
        deleteButton.setMinimumSize(new java.awt.Dimension(117, 23));
        deleteButton.setPreferredSize(new java.awt.Dimension(117, 23));
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        controllerPanel.add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(841, 50, -1, -1));

        shipmentsButton.setText("Xem lô hàng");
        shipmentsButton.setMaximumSize(new java.awt.Dimension(117, 23));
        shipmentsButton.setMinimumSize(new java.awt.Dimension(117, 23));
        shipmentsButton.setPreferredSize(new java.awt.Dimension(117, 23));
        shipmentsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shipmentsButtonActionPerformed(evt);
            }
        });
        controllerPanel.add(shipmentsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(841, 79, 118, -1));

        IDLabel.setText("Mã sản phẩm:");
        controllerPanel.add(IDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 3, 89, -1));

        IDTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDTextFieldActionPerformed(evt);
            }
        });
        IDTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                IDTextFieldKeyReleased(evt);
            }
        });
        controllerPanel.add(IDTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 0, 153, -1));

        totalQuantityLabel.setText("Tổng số lượng:");
        controllerPanel.add(totalQuantityLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 59, 89, -1));

        totalQuantityTextField.setEditable(false);
        totalQuantityTextField.setEnabled(false);
        controllerPanel.add(totalQuantityTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 153, -1));

        unitComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thêm đơn vị" }));
        unitComboBox.setSelectedIndex(-1);
        unitComboBox.setLightWeightPopupEnabled(false);
        unitComboBox.setMaximumSize(new java.awt.Dimension(100, 22));
        unitComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                unitComboBoxItemStateChanged(evt);
            }
        });
        unitComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unitComboBoxActionPerformed(evt);
            }
        });
        controllerPanel.add(unitComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(574, 0, -1, -1));

        invalidPriceLabel.setForeground(new java.awt.Color(255, 51, 51));
        invalidPriceLabel.setText("Giá không hợp lệ!");
        controllerPanel.add(invalidPriceLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(812, 28, -1, -1));

        invalidIDLabel.setBackground(new java.awt.Color(255, 51, 51));
        invalidIDLabel.setForeground(new java.awt.Color(255, 51, 51));
        invalidIDLabel.setText("Mã hàng không hợp lệ!");
        controllerPanel.add(invalidIDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 28, -1, -1));

        cancelButton.setText("Hủy");
        cancelButton.setMaximumSize(new java.awt.Dimension(117, 23));
        cancelButton.setMinimumSize(new java.awt.Dimension(117, 23));
        cancelButton.setPreferredSize(new java.awt.Dimension(117, 23));
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        controllerPanel.add(cancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(582, 79, 118, -1));

        repoManagementPanel.add(controllerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 32, 950, 100));

        tablePanel.setBackground(new java.awt.Color(0, 204, 255));
        tablePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchLabel.setText("Tìm kiếm:");
        tablePanel.add(searchLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 90, 20));

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Đơn vị", "Nhà sản xuất", "Giá sản phẩm", "Tổng số lượng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setColumnSelectionAllowed(true);
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(5);
            jTable1.getColumnModel().getColumn(0).setHeaderValue("Mã SP");
            jTable1.getColumnModel().getColumn(1).setHeaderValue("Tên SP");
            jTable1.getColumnModel().getColumn(2).setHeaderValue("Đơn vị");
            jTable1.getColumnModel().getColumn(3).setHeaderValue("Nhà sản xuất");
            jTable1.getColumnModel().getColumn(4).setHeaderValue("Giá sản phẩm");
            jTable1.getColumnModel().getColumn(5).setHeaderValue("Tổng số lượng");
        }

        tablePanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 940, 410));

        searchTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTextFieldKeyReleased(evt);
            }
        });
        tablePanel.add(searchTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 153, -1));

        repoManagementPanel.add(tablePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 129, 940, 440));

        add(repoManagementPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 3, 970, 610));
    }// </editor-fold>//GEN-END:initComponents

    private void nameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextFieldActionPerformed

    private void IDTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDTextFieldActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        if(dupedGoodCheck()) {
            goodTableModel.addRow(new Object[] {
                goodID,
                goodName,
                goodUnit,
                goodManufacturer,
                goodListedPrice,
                0
            });
            goodsList.getList().add(new Goods(goodName, goodManufacturer, goodListedPrice, goodID, goodUnit));
            resetVariables();
            reloadTable(goodsList);
        } else {
            JOptionPane.showMessageDialog(null, "Mặt hàng đã tồn tại!", "Oh no!", JOptionPane.WARNING_MESSAGE);
        }
        addCheck();
        deleteCheck();
        editCheck();
        cancelCheck();
    }//GEN-LAST:event_addButtonActionPerformed
    
    private void unitComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unitComboBoxActionPerformed
        // TODO add your handling code here:
        if ((deleteButton.isEnabled()&&jTable1.getSelectedRow()==-1) || unitComboBox.getSelectedItem() == null || isReloadingUnits) {
            return;
        }
        if (unitComboBox.getSelectedIndex() == 0) {
            unitComboBox.setSelectedIndex(-1);
            String unit = JOptionPane.showInputDialog(null, "Vui lòng thêm một đơn vị mới:", "Thêm đơn vị", JOptionPane.QUESTION_MESSAGE);
            if (unit == null) {
                return;
            }
            if (unitsList.getBucket().isEmpty()) {
                if (unit.isBlank()) {
                    JOptionPane.showMessageDialog(null, "Invalid Unit!", "Oh no!", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                unitsList.getBucket().add(unit);
                unitComboBox.addItem(unit);
                unitComboBox.setPrototypeDisplayValue("                           ");
            } else {
                long similar = unitsList.getBucket().stream().filter(x -> x.equalsIgnoreCase(unit)).count();
                if (similar == 0) {
                    unitsList.getBucket().add(unit);
                    unitComboBox.addItem(unit);
                    unitComboBox.setPrototypeDisplayValue("                           ");
                } else if (similar != 0 && unit.isBlank()) {
                    JOptionPane.showMessageDialog(null, "Invalid Unit!", "Oh no!", JOptionPane.WARNING_MESSAGE);
                }
            }
        } else {
            goodUnit = unitComboBox.getSelectedItem().toString();
            deleteCheck();
            addCheck();
            editCheck();
        }
        cancelCheck();
        addCheck();
        editCheck();
        deleteCheck();
    }//GEN-LAST:event_unitComboBoxActionPerformed

    private void unitComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_unitComboBoxItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_unitComboBoxItemStateChanged

    private void listPriceTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listPriceTextFieldKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_listPriceTextFieldKeyTyped

    private void listPriceTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listPriceTextFieldKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_listPriceTextFieldKeyPressed

    private void listPriceTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listPriceTextFieldKeyReleased
        // TODO add your handling code here:
        try {
            String input = listPriceTextField.getText();
            if (input.length() == 0) {
                invalidPriceLabel.setVisible(false);
                addButton.setEnabled(false);
                return;
            }
            double check = Double.parseDouble(input);
            if (check < 0) {
                invalidPriceLabel.setVisible(true);
                addButton.setEnabled(false);
            } else {
                invalidPriceLabel.setVisible(false);
                goodListedPrice = BigDecimal.valueOf(check);
                addCheck();
            }
        } catch (NumberFormatException nfe) {
            invalidPriceLabel.setVisible(true);
            addButton.setEnabled(false);
        }
        cancelCheck();
        addCheck();
        deleteCheck();
        editCheck();
    }//GEN-LAST:event_listPriceTextFieldKeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void nameTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameTextFieldKeyReleased
        // TODO add your handling code here:
        goodName = nameTextField.getText();
        addCheck();
        cancelCheck();
    }//GEN-LAST:event_nameTextFieldKeyReleased

    private void manufacturerTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_manufacturerTextFieldKeyReleased
        // TODO add your handling code here:
        goodManufacturer = manufacturerTextField.getText();
        addCheck();
        cancelCheck();
    }//GEN-LAST:event_manufacturerTextFieldKeyReleased

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        if (jTable1.getSelectedRow() != -1) {
            String deletedGoodID = jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 0).toString();
            goodsList.setGoodsList(goodsList.getList().stream().filter(x->!x.getID().equals(deletedGoodID)).collect(Collectors.toList()));
            reloadTable(goodsList);
            resetVariables();
        } else {
            unitsList.setBucket(unitsList.getBucket().stream().filter(x->!x.equalsIgnoreCase(unitComboBox.getSelectedItem().toString())).collect(Collectors.toList()));
            unitComboBox.removeItem(unitComboBox.getSelectedItem());
            unitComboBox.setSelectedIndex(-1);
            deleteButton.setEnabled(false);
        }
        addCheck();
        deleteCheck();
        editCheck();
        cancelCheck();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void IDTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IDTextFieldKeyReleased
        // TODO add your handling code here:
        long dupedID = goodsList.getList().stream().filter(x->x.getID().equalsIgnoreCase(IDTextField.getText())).count();
        if (IDTextField.getText().isEmpty()) {
            invalidIDLabel.setVisible(false);
        }
        boolean dupedIDOnTable = true;
        try {
            dupedIDOnTable = IDTextField.getText().equals(goodTableModel.getValueAt(jTable1.getSelectedRow(), 0).toString());
        } catch (ArrayIndexOutOfBoundsException aioobe) {

        }
        if (dupedID == 0 || (dupedIDOnTable && jTable1.getSelectedRow() != -1)) {
            goodID = IDTextField.getText();
            addCheck();
            invalidIDLabel.setVisible(false);
        }  else {
            invalidIDLabel.setVisible(true);
        }
        cancelCheck();
    }//GEN-LAST:event_IDTextFieldKeyReleased

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // TODO add your handling code here:
        if (jTable1.getSelectedRow() != -1) {
            Goods editedGood = goodsList.getList().get(findGoodsIndex(goodTableModel.getValueAt(jTable1.getSelectedRow(), 0).toString()));
            String editedGoodsIDBefore = editedGood.getID();
            List<Shipment> editedGoodShipments = goodsList.getList().get(findGoodsIndex(goodTableModel.getValueAt(jTable1.getSelectedRow(), 0).toString())).getShipments();
            goodsList.getList().set(findGoodsIndex(goodTableModel.getValueAt(jTable1.getSelectedRow(), 0).toString()), new Goods("", "", BigDecimal.ZERO, editedGood.getID(), ""));
            if (dupedGoodCheck() || editedGood.getID().equals(IDTextField.getText())) {
                String newID = goodsList.getList().set(findGoodsIndex(editedGood.getID()), new Goods(nameTextField.getText(), manufacturerTextField.getText(), new BigDecimal(listPriceTextField.getText()), IDTextField.getText(),unitComboBox.getSelectedItem().toString())).getID();
                goodsList.getList().get(findGoodsIndex(newID)).setTotalQuantity(new BigDecimal(totalQuantityTextField.getText()));
                goodsList.getList().get(findGoodsIndex(newID)).setShipments(editedGoodShipments);
                reloadTable(goodsList);
                resetVariables();
                //
                editImportGoodsInHistory(editedGoodsIDBefore, goodsList.getList().get(findGoodsIndex(newID)));
                //
            } else {
                JOptionPane.showMessageDialog(null, "Mặt hàng đã tồn tại!", "Oh no!", JOptionPane.WARNING_MESSAGE);
                goodsList.getList().set(findGoodsIndex(editedGood.getID()), editedGood);
            }
        } else {
            String unitChanged = JOptionPane.showInputDialog(null, "Vui lòng nhập tên đơn vị:", "Thay đổi đơn vị", JOptionPane.QUESTION_MESSAGE);
            unitsList.getBucket().set(unitComboBox.getSelectedIndex()-1, unitChanged);
            reloadUnitList();
            unitComboBox.setSelectedIndex(-1);
        }
        addCheck();
        deleteCheck();
        editCheck();
        cancelCheck();
        
    }//GEN-LAST:event_editButtonActionPerformed

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        // TODO add your handling code here:
        if (jTable1.getSelectedRow() == -1) {
        } else {
            shipmentsButton.setEnabled(true);
            if (findUnit((String) goodTableModel.getValueAt(jTable1.getSelectedRow(), 2)) == 0) {
                JOptionPane.showMessageDialog(null, "Đơn vị không tồn tại. Tiến hành thêm dơn vị...", "Uh oh!", JOptionPane.ERROR_MESSAGE);
                unitsList.getBucket().add((String) goodTableModel.getValueAt(jTable1.getSelectedRow(), 2));
                unitComboBox.addItem((String) goodTableModel.getValueAt(jTable1.getSelectedRow(), 2));
                unitComboBox.setSelectedItem((String) goodTableModel.getValueAt(jTable1.getSelectedRow(), 2));
            } else {
                unitComboBox.setSelectedItem((String) goodTableModel.getValueAt(jTable1.getSelectedRow(), 2));
            }
            IDTextField.setText((String) goodTableModel.getValueAt(jTable1.getSelectedRow(), 0));
            nameTextField.setText((String) goodTableModel.getValueAt(jTable1.getSelectedRow(), 1));
            manufacturerTextField.setText((String) goodTableModel.getValueAt(jTable1.getSelectedRow(), 3));
            listPriceTextField.setText(goodTableModel.getValueAt(jTable1.getSelectedRow(), 4).toString());
            totalQuantityTextField.setText(goodTableModel.getValueAt(jTable1.getSelectedRow(), 5).toString());
            goodID = (String) goodTableModel.getValueAt(jTable1.getSelectedRow(), 0);
            goodListedPrice = (BigDecimal) goodTableModel.getValueAt(jTable1.getSelectedRow(), 4);
            goodManufacturer = (String) goodTableModel.getValueAt(jTable1.getSelectedRow(), 3);
            goodTotalQuantity = new BigDecimal(goodTableModel.getValueAt(jTable1.getSelectedRow(), 5).toString());
            goodUnit = (String) goodTableModel.getValueAt(jTable1.getSelectedRow(), 2);
            goodName = (String) goodTableModel.getValueAt(jTable1.getSelectedRow(), 1);
        }
        addCheck();
        cancelCheck();
        editCheck();
        deleteCheck();
    }//GEN-LAST:event_jTable1MouseReleased

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        reloadTable(goodsList);
        resetVariables();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void searchTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextFieldKeyReleased
        // TODO add your handling code here:
        GoodsList<Goods> goodsListToSearch = new GoodsList<>();
        Object searchedObject = glc.searchGoodsForGUI(searchTextField.getText(), goodsList);
        if (searchedObject == null) {
            int rowToRemove = goodTableModel.getRowCount();
            for (int i = 0; i < rowToRemove; i++) {
                goodTableModel.removeRow(0);
            }            
            return;
        } else if (searchedObject instanceof Goods goods) {
            goodsListToSearch.getList().add(goods);
        } else if (searchedObject instanceof GoodsList) {
            goodsListToSearch = (GoodsList<Goods>) searchedObject;
        }
        reloadTable(goodsListToSearch);
    }//GEN-LAST:event_searchTextFieldKeyReleased

    private void shipmentsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shipmentsButtonActionPerformed
        // TODO add your handling code here:
        Goods selectedGood = null;
        for (Goods good : goodsList.getList()) {
            if (goodTableModel.getValueAt(jTable1.getSelectedRow(), 0).toString().equals(good.getID())) {
                selectedGood = good;
            }
        }
        
        try {
            PopupShipment shipmentPanel = new PopupShipment();
            shipmentPanel.setVisible(true);
            shipmentPanel.getShipmentPanel().attachGood(selectedGood, store);
            shipmentPanel.getShipmentPanel().reloadTable(selectedGood.getShipments());
            shipmentPanel.setDefaultCloseOperation(PopupShipment.DISPOSE_ON_CLOSE);
            reloadTable(goodsList);
            jTable1.setRowSelectionInterval(findGoodsIndex(selectedGood.getID()), findGoodsIndex(selectedGood.getID()));
        } catch (NullPointerException npe) {
            
        }
    }//GEN-LAST:event_shipmentsButtonActionPerformed

    private void editImportGoodsInHistory(String goodsIDBefore, Goods editedGoods){
        for (Goods goods : store.getHistory().getImportGoodsList()) {
            if(goods.getID().equals(goodsIDBefore)){
                goods.setGoodsName(editedGoods.getGoodsName());
                goods.setID(editedGoods.getID());
                goods.setManufacture(editedGoods.getManufacture());
                goods.setListPrice(editedGoods.getListPrice());
                goods.setUnit(editedGoods.getUnit());
            }
        }
    }
    
    public void addCheck () {
        if(!nameTextField.getText().isBlank() && unitComboBox.getSelectedIndex()!=-1 && !listPriceTextField.getText().isBlank() && !IDTextField.getText().isBlank() && !goodID.isBlank() && goodListedPrice != BigDecimal.valueOf(-1)) {
            addButton.setEnabled(true);
        } else {
            addButton.setEnabled(false);
        }
    }
    
    public void deleteCheck() {
        if (jTable1.getSelectedRow() != -1 || unitComboBox.getSelectedIndex() != -1) {
            deleteButton.setEnabled(true);
        } else {
            deleteButton.setEnabled(false);
        }
    }
    
    public void editCheck() {
        if (jTable1.getSelectedRow() != -1 || unitComboBox.getSelectedIndex() != -1) {
            editButton.setEnabled(true);
        } else {
            editButton.setEnabled(false);
        }
    }
    
    public void cancelCheck() {
        if (jTable1.getSelectedRow() != -1 || !nameTextField.getText().isBlank() || !manufacturerTextField.getText().isBlank() || unitComboBox.getSelectedIndex()!=-1 || !listPriceTextField.getText().isBlank() || !IDTextField.getText().isBlank()) {
            cancelButton.setEnabled(true);
        } else {
            cancelButton.setEnabled(false);
        }
    }
    
    public boolean dupedGoodCheck() {
        long dupedGood = goodsList.getList().stream().filter(x->x.getGoodsName().equalsIgnoreCase(goodName)&&
                                                                      x.getManufacture().equals(goodManufacturer)&&
                                                                        x.getUnit().equals(goodUnit)).count();
        long dupedID = goodsList.getList().stream().filter(x->x.getID().equals(goodID)).count();
        return dupedGood == 0 && dupedID == 0;
    }
    
    public void resetVariables() {
        IDTextField.setText("");
        nameTextField.setText("");
        unitComboBox.setSelectedIndex(-1);
        manufacturerTextField.setText("");
        listPriceTextField.setText("");
        totalQuantityTextField.setText("");
        
        invalidIDLabel.setVisible(false);
        invalidPriceLabel.setVisible(false);
        
        goodID = "";
        goodListedPrice = BigDecimal.valueOf(-1);
        goodManufacturer = "";
        goodName = "";
        goodUnit = "";
        
        addButton.setEnabled(false);
        deleteButton.setEnabled(false);
        editButton.setEnabled(false);
        shipmentsButton.setEnabled(false);
        cancelButton.setEnabled(false);
    }
    
    public void reloadUnitList() {
        isReloadingUnits = true;
        unitComboBox.removeAllItems();
        unitComboBox.addItem("Thêm đơn vị");
        unitsList.getBucket().stream().forEach(x->unitComboBox.addItem(x));
        unitComboBox.setSelectedIndex(-1);
        isReloadingUnits = false;
    }
    
    public void reloadTable(GoodsList<Goods> list) {
        int rowToRemove = goodTableModel.getRowCount();
        for (int i = 0; i < rowToRemove; i++) {
            goodTableModel.removeRow(0);
        }
        for (Goods good : list.getList()) {
            goodTableModel.addRow(new Object[] {
                good.getID(),
                good.getGoodsName(),
                good.getUnit(),
                good.getManufacture(),
                good.getListPrice(),
                good.getTotalQuantity()
            });
        }
    }
    
    public void passData(Store store){
        this.store = store;
        setGoodsList(store.getRepository());
        setUnitsList(store.getUnits());
    }
    
    private void setGoodsList(GoodsList<Goods> goodsList) {
        this.goodsList = goodsList;
        reloadTable(goodsList);
    }

    private void setUnitsList(Units unitsList) {
        this.unitsList = unitsList;
        reloadUnitList();
    }
    
    public int findUnit(String unit) {
        return (int) unitsList.getBucket().stream().filter(x->x.equals(unit)).count();
    }
    
    public void findSelectedGood (String ID, List<Shipment> shipments) {
        for (Goods goods : goodsList.getList()) {
            if (ID.equals(goods.getID())) {
                goods.setShipments(shipments);
                reloadTable(goodsList);
                return;
            }
        }
    }
    
    private int findGoodsIndex (String ID) {
        for (Goods goods : goodsList.getList()) {
            if (ID.equals(goods.getID())) {
                return goodsList.getList().indexOf(goods);
            }
        }
        return -1;
    }

    private Store store;
    private GoodsList<Goods> goodsList;
    private Units unitsList;
    private GoodsListController glc = new GoodsListController();
    private boolean isReloadingUnits = false;
    public static RepoPanel Instance;
    
    private Animator animator;
    private Animator animator2;
    
    private String goodName = "";
    private String goodUnit = "";
    private String goodManufacturer = "";
    private String goodID = "";
    private BigDecimal goodListedPrice = BigDecimal.valueOf(-1);
    private BigDecimal goodTotalQuantity = BigDecimal.valueOf(-1);
    private DefaultTableModel goodTableModel;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IDLabel;
    private javax.swing.JTextField IDTextField;
    private javax.swing.JButton addButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel controllerPanel;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel invalidIDLabel;
    private javax.swing.JLabel invalidPriceLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel listPriceLabel;
    private javax.swing.JTextField listPriceTextField;
    private javax.swing.JLabel manuFacturerLabel;
    private javax.swing.JTextField manufacturerTextField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JPanel repoManagementPanel;
    private javax.swing.JLabel searchLabel;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JButton shipmentsButton;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JLabel totalQuantityLabel;
    private javax.swing.JTextField totalQuantityTextField;
    private javax.swing.JComboBox<String> unitComboBox;
    // End of variables declaration//GEN-END:variables
}
