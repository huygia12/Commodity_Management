package view;

import config.HibernateConfig;
import dao.ShipmentDAO;
import java.awt.Component;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.entities.Product;
import model.entities.Shipment;
import model.entities.Store;
import util.FormatOutput;
import util.ShipmentUtil;

public class ShipmentPanel extends javax.swing.JPanel {

    public ShipmentPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        goodsInfoPanel = new javax.swing.JPanel();
        filterCategories = new javax.swing.JComboBox<>();
        filterExtraOption = new javax.swing.JComboBox<>();
        filterBtn = new javax.swing.JButton();
        shipmentControlPanel = new javax.swing.JPanel();
        shipmentIDLabel = new javax.swing.JLabel();
        shipmentIDTextField = new javax.swing.JTextField();
        importPriceLabel = new javax.swing.JLabel();
        importPriceTextField = new javax.swing.JTextField();
        quantityLabel = new javax.swing.JLabel();
        quantityTextField = new javax.swing.JTextField();
        doesExpiredToggleBtn = new javax.swing.JToggleButton();
        doesExpiredLabel = new javax.swing.JLabel();
        NSXLabel = new javax.swing.JLabel();
        NSXDayTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        NSXMonthTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        NSXYearTextField = new javax.swing.JTextField();
        HSDLabel = new javax.swing.JLabel();
        HSDDayTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        HSDMonthTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        HSDYearTextField = new javax.swing.JTextField();
        DayLabel = new javax.swing.JLabel();
        MonthLabel = new javax.swing.JLabel();
        YearLabel = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        errorPriceLabel = new javax.swing.JLabel();
        errorQuantityLabel = new javax.swing.JLabel();
        errorDateLabel = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        shipmentTablePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        shipmentTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(0, 204, 255));
        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), 2), "SHIPMENT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        setMaximumSize(new java.awt.Dimension(1400, 800));
        setMinimumSize(new java.awt.Dimension(1400, 800));
        setPreferredSize(new java.awt.Dimension(1400, 800));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        goodsInfoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Bộ lọc"));

        filterCategories.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Số lượng", "Giá nhập hàng", "Ngày", "Tình trạng" }));
        filterCategories.setSelectedIndex(-1);
        filterCategories.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterCategoriesActionPerformed(evt);
            }
        });

        filterExtraOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterExtraOptionActionPerformed(evt);
            }
        });

        filterBtn.setText("Lọc");
        filterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout goodsInfoPanelLayout = new javax.swing.GroupLayout(goodsInfoPanel);
        goodsInfoPanel.setLayout(goodsInfoPanelLayout);
        goodsInfoPanelLayout.setHorizontalGroup(
            goodsInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(goodsInfoPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(filterCategories, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(filterExtraOption, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(353, Short.MAX_VALUE))
            .addGroup(goodsInfoPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(filterBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        goodsInfoPanelLayout.setVerticalGroup(
            goodsInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(goodsInfoPanelLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(goodsInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filterCategories, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filterExtraOption, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(filterBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(goodsInfoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, 890, 150));

        shipmentControlPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lô hàng", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        shipmentControlPanel.setMinimumSize(new java.awt.Dimension(261, 540));
        shipmentControlPanel.setPreferredSize(new java.awt.Dimension(261, 540));
        shipmentControlPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        shipmentIDLabel.setText("Mã lô hàng:");
        shipmentControlPanel.add(shipmentIDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 39, 104, 40));

        shipmentIDTextField.setEditable(false);
        shipmentControlPanel.add(shipmentIDTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 230, 40));

        importPriceLabel.setText("Giá nhập hàng:");
        shipmentControlPanel.add(importPriceLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 104, 40));

        importPriceTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                importPriceTextFieldKeyReleased(evt);
            }
        });
        shipmentControlPanel.add(importPriceTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 230, 40));

        quantityLabel.setText("Số lượng: ");
        shipmentControlPanel.add(quantityLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 104, 40));

        quantityTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                quantityTextFieldKeyReleased(evt);
            }
        });
        shipmentControlPanel.add(quantityTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 230, 36));

        doesExpiredToggleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doesExpiredToggleBtnActionPerformed(evt);
            }
        });
        shipmentControlPanel.add(doesExpiredToggleBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 290, -1, 20));

        doesExpiredLabel.setText("Có ngày sản xuất, hạn sử dụng?");
        shipmentControlPanel.add(doesExpiredLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 278, -1, 40));

        NSXLabel.setText("Ngày sản xuất:");
        shipmentControlPanel.add(NSXLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 120, 40));

        NSXDayTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                NSXDayTextFieldKeyReleased(evt);
            }
        });
        shipmentControlPanel.add(NSXDayTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(212, 330, 40, 40));

        jLabel2.setText("/");
        shipmentControlPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 340, -1, -1));

        NSXMonthTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                NSXMonthTextFieldKeyReleased(evt);
            }
        });
        shipmentControlPanel.add(NSXMonthTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(272, 330, 40, 40));

        jLabel3.setText("/");
        shipmentControlPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 340, -1, -1));

        NSXYearTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                NSXYearTextFieldKeyReleased(evt);
            }
        });
        shipmentControlPanel.add(NSXYearTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 330, 80, 40));

        HSDLabel.setText("Hạn sử dụng:");
        shipmentControlPanel.add(HSDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 130, 40));

        HSDDayTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                HSDDayTextFieldKeyReleased(evt);
            }
        });
        shipmentControlPanel.add(HSDDayTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(212, 380, 40, 40));

        jLabel5.setText("/");
        shipmentControlPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 390, -1, -1));

        HSDMonthTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                HSDMonthTextFieldKeyReleased(evt);
            }
        });
        shipmentControlPanel.add(HSDMonthTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(272, 380, 40, 40));

        jLabel6.setText("/");
        shipmentControlPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 390, -1, -1));

        HSDYearTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                HSDYearTextFieldKeyReleased(evt);
            }
        });
        shipmentControlPanel.add(HSDYearTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 380, 80, 40));

        DayLabel.setText("Ngày");
        shipmentControlPanel.add(DayLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 430, 40, -1));

        MonthLabel.setText("Tháng");
        shipmentControlPanel.add(MonthLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 430, -1, -1));

        YearLabel.setText("Năm");
        shipmentControlPanel.add(YearLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 430, -1, -1));

        addButton.setText("Thêm");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        shipmentControlPanel.add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 630, 120, 40));

        deleteButton.setText("Xóa");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        shipmentControlPanel.add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 690, 120, 40));

        editButton.setText("Sửa");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });
        shipmentControlPanel.add(editButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 630, 130, 40));

        cancelButton.setText("Hủy");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        shipmentControlPanel.add(cancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 690, 130, 41));

        errorPriceLabel.setForeground(new java.awt.Color(255, 51, 51));
        errorPriceLabel.setText("Giá không hợp lệ!");
        shipmentControlPanel.add(errorPriceLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, -1, -1));

        errorQuantityLabel.setForeground(new java.awt.Color(255, 51, 51));
        errorQuantityLabel.setText("Số lượng không hợp lệ!");
        shipmentControlPanel.add(errorQuantityLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, -1, 20));

        errorDateLabel.setForeground(new java.awt.Color(255, 51, 51));
        errorDateLabel.setText("Ngày không hợp lệ!");
        shipmentControlPanel.add(errorDateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 460, -1, 30));

        backBtn.setText("Quay lại");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        shipmentControlPanel.add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 690, 116, 40));

        add(shipmentControlPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 450, 750));

        shipmentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã lô hàng", "Giá nhập hàng", "Số lượng", "Ngày sản xuất", "Hạn sử dụng", "Tình trạng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        shipmentTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        shipmentTable.setShowGrid(true);
        shipmentTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                shipmentTableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(shipmentTable);

        javax.swing.GroupLayout shipmentTablePanelLayout = new javax.swing.GroupLayout(shipmentTablePanel);
        shipmentTablePanel.setLayout(shipmentTablePanelLayout);
        shipmentTablePanelLayout.setHorizontalGroup(
            shipmentTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE)
        );
        shipmentTablePanelLayout.setVerticalGroup(
            shipmentTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
        );

        add(shipmentTablePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 190, 890, 590));
    }// </editor-fold>//GEN-END:initComponents

    public void defaultSettings() {
        errorDateLabel.setVisible(false);
        errorPriceLabel.setVisible(false);
        errorQuantityLabel.setVisible(false);
        setVisibleDate(false, false);
        doesExpiredToggleBtn.setSelected(false);
        filterExtraOption.setVisible(false);
        filterCategories.setSelectedIndex(-1);

        addButton.setEnabled(false);
        deleteButton.setEnabled(false);
        editButton.setEnabled(false);
        cancelButton.setEnabled(false);
        filterBtn.setEnabled(false);

        shipmentIDTextField.setText("");
        importPriceTextField.setText("");
        quantityTextField.setText("");

        NSXDay = "";
        NSXMonth = "";
        NSXYear = "";
        HSDDay = "";
        HSDMonth = "";
        HSDYear = "";

        shipmentPrice = 0;
        shipmentQuantity = 0;
    }

    private void setVisibleDate(Boolean isVisible, Boolean isError) {
        NSXLabel.setVisible(isVisible);
        NSXDayTextField.setVisible(isVisible);
        NSXMonthTextField.setVisible(isVisible);
        NSXYearTextField.setVisible(isVisible);
        NSXDayTextField.setText("");
        NSXMonthTextField.setText("");
        NSXYearTextField.setText("");

        HSDLabel.setVisible(isVisible);
        HSDDayTextField.setVisible(isVisible);
        HSDMonthTextField.setVisible(isVisible);
        HSDYearTextField.setVisible(isVisible);
        HSDDayTextField.setText("");
        HSDMonthTextField.setText("");
        HSDYearTextField.setText("");

        jLabel2.setVisible(isVisible);
        jLabel3.setVisible(isVisible);
        jLabel5.setVisible(isVisible);
        jLabel6.setVisible(isVisible);

        DayLabel.setVisible(isVisible);
        MonthLabel.setVisible(isVisible);
        YearLabel.setVisible(isVisible);

        if (isVisible) {
            if (isError) {
                errorDateLabel.setVisible(true);
            } else {
                errorDateLabel.setVisible(false);
            }
        } else {
            errorDateLabel.setVisible(false);
        }
    }

    private void saveDateData(boolean isToggled) {
        if (isToggled) {
            NSXDayTextField.setText(NSXDay);
            NSXMonthTextField.setText(NSXMonth);
            NSXYearTextField.setText(NSXYear);
            HSDDayTextField.setText(HSDDay);
            HSDMonthTextField.setText(HSDMonth);
            HSDYearTextField.setText(HSDYear);
            errorDateLabel.setVisible(false);
        } else {
            NSXDay = NSXDayTextField.getText();
            NSXMonth = NSXMonthTextField.getText();
            NSXYear = NSXYearTextField.getText();
            HSDDay = HSDDayTextField.getText();
            HSDMonth = HSDMonthTextField.getText();
            HSDYear = HSDYearTextField.getText();
        }
    }

    private void shipmentTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_shipmentTableMouseReleased
        if (shipmentTable.getSelectedRow() != -1) {
            shipmentIDTextField.setText((String) shipmentTableModel.getValueAt(shipmentTable.getSelectedRow(), 0));
            importPriceTextField.setText(shipmentTableModel.getValueAt(shipmentTable.getSelectedRow(), 1).toString());
            quantityTextField.setText(shipmentTableModel.getValueAt(shipmentTable.getSelectedRow(), 2).toString());
            shipmentQuantity = Integer.parseInt(shipmentTableModel.getValueAt(shipmentTable.getSelectedRow(), 2).toString());
            shipmentPrice = Integer.parseInt(shipmentTableModel.getValueAt(shipmentTable.getSelectedRow(), 1).toString());
            if (!(shipmentTableModel.getValueAt(shipmentTable.getSelectedRow(), 3)).toString().isEmpty()) {
                doesExpiredToggleBtn.setSelected(true);
                setVisibleDate(true, false);
                saveDateData(false);
                NSXDayTextField.setText(NSXDay = shipmentTableModel.getValueAt(shipmentTable.getSelectedRow(), 3).toString().substring(0, 2));
                NSXMonthTextField.setText(NSXMonth = shipmentTableModel.getValueAt(shipmentTable.getSelectedRow(), 3).toString().substring(3, 5));
                NSXYearTextField.setText(NSXYear = shipmentTableModel.getValueAt(shipmentTable.getSelectedRow(), 3).toString().substring(6, 10));
                HSDDayTextField.setText(HSDDay = shipmentTableModel.getValueAt(shipmentTable.getSelectedRow(), 4).toString().substring(0, 2));
                HSDMonthTextField.setText(HSDMonth = shipmentTableModel.getValueAt(shipmentTable.getSelectedRow(), 4).toString().substring(3, 5));
                HSDYearTextField.setText(HSDYear = shipmentTableModel.getValueAt(shipmentTable.getSelectedRow(), 4).toString().substring(6, 10));
            }
        }
        deleteCheck();
        cancelCheck();
        addCheck();
        editCheck();
    }//GEN-LAST:event_shipmentTableMouseReleased

    private void filterCategoriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterCategoriesActionPerformed
        filterExtraOption.setVisible(true);
        filterExtraOption.removeAllItems();
        switch (filterCategories.getSelectedIndex()) {
            case 0:
            case 1:
                filterExtraOption.addItem("Từ nhiều nhất tới ít nhất");
                filterExtraOption.addItem("Từ ít nhất tới nhiều nhất");
                break;
            case 2:
                filterExtraOption.addItem("Ngày sản xuất gần với hiện tại nhất");
                filterExtraOption.addItem("Hạn sử dụng sắp hết");
                break;
            case 3:
                filterExtraOption.addItem("Còn hạn");
                filterExtraOption.addItem("Hết hạn");
                filterExtraOption.addItem("Không có hạn");
                break;
            default:
        }
        cancelCheck();
    }//GEN-LAST:event_filterCategoriesActionPerformed

    private void filterExtraOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterExtraOptionActionPerformed
        filterBtn.setEnabled(true);
        cancelCheck();
    }//GEN-LAST:event_filterExtraOptionActionPerformed

    private void filterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterBtnActionPerformed
//        List<Shipment> shipmentFilterList = new ArrayList<>();
//        switch (filterCategories.getSelectedIndex()) {
//            case 0:
//                switch (filterExtraOption.getSelectedIndex()) {
//                    case 0:
//                        reloadTable(shipments.stream().sorted((s1, s2) -> -s1.getQuantity().compareTo(s2.getQuantity())).collect(Collectors.toList()));
//                        break;
//                    case 1:
//                        reloadTable(shipments.stream().sorted((s1, s2) -> s1.getQuantity().compareTo(s2.getQuantity())).collect(Collectors.toList()));
//                        break;
//                }
//                break;
//            case 1:
//                switch (filterExtraOption.getSelectedIndex()) {
//                    case 0:
//                        reloadTable(shipments.stream().sorted((s1, s2) -> -s1.getImportPrice().compareTo(s2.getImportPrice())).collect(Collectors.toList()));
//                        break;
//                    case 1:
//                        reloadTable(shipments.stream().sorted((s1, s2) -> s1.getImportPrice().compareTo(s2.getImportPrice())).collect(Collectors.toList()));
//                        break;
//                }
//                break;
//            case 2:
//                switch (filterExtraOption.getSelectedIndex()) {
//                    case 0:
//                        shipmentFilterList = shipments.stream().filter(x -> x.getNsx() != null).toList();
//                        reloadTable(shipmentFilterList.stream().sorted((s1, s2) -> (-1) * (s1.getNsx().compareTo(s2.getNsx()))).collect(Collectors.toList()));
//                        break;
//                    case 1:
//                        shipmentFilterList = shipments.stream().filter(x -> x.getHsd() != null).toList();
//                        reloadTable(shipmentFilterList.stream().sorted((s1, s2) -> (-1) * (s1.getHsd().compareTo(s2.getHsd()))).collect(Collectors.toList()));
//                        break;
//                }
//                break;
//            case 3:
//                switch (filterExtraOption.getSelectedIndex()) {
//                    case 0:
//                        for (Models.Shipment shipment1 : shipments) {
//                            if (shipment1.getHsd() != null && shipment1.getHsd().isAfter(LocalDate.now())) {
//                                shipmentFilterList.add(shipment1);
//                            }
//                        }
//                        reloadTable(shipmentFilterList);
//                        break;
//                    case 1:
//                        for (Models.Shipment shipment1 : shipments) {
//                            if (shipment1.getHsd() != null && shipment1.getHsd().isBefore(LocalDate.now())) {
//                                shipmentFilterList.add(shipment1);
//                            }
//                        }
//                        reloadTable(shipmentFilterList);
//                        break;
//                    case 2:
//                        reloadTable(shipments.stream().filter(x -> x.getHsd() == null).toList());
//                        break;
//                }
//                break;
//
//        }
//        cancelCheck();
//        errorDateLabel.setVisible(false);
//        errorPriceLabel.setVisible(false);
//        errorQuantityLabel.setVisible(false);
//        setVisibleDate(false, false);
//        doesExpiredToggleBtn.setSelected(false);
//        shipmentIDTextField.setText("");
//        importPriceTextField.setText("");
//        quantityTextField.setText("");
//
//        NSXDay = "";
//        NSXMonth = "";
//        NSXYear = "";
//        HSDDay = "";
//        HSDMonth = "";
//        HSDYear = "";
//
//        shipmentPrice = 0;
//        shipmentQuantity = 0;
    }//GEN-LAST:event_filterBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        mf.switchRepoPanel();
    }//GEN-LAST:event_backBtnActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        displayShipments(this.product.getShipments());
        defaultSettings();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        //        if (doesExpiredToggleBtn.isSelected()) {
            //            if (LocalDate.of(Integer.parseInt(NSXYearTextField.getText()), Integer.parseInt(NSXMonthTextField.getText()), Integer.parseInt(NSXDayTextField.getText())).isAfter(LocalDate.of(Integer.parseInt(HSDYearTextField.getText()), Integer.parseInt(HSDMonthTextField.getText()), Integer.parseInt(HSDDayTextField.getText())))) {
                //                JOptionPane.showMessageDialog(null, "Ngày sản xuất không thể trước hạn sử dụng!", "Cảnh báo!", JOptionPane.WARNING_MESSAGE);
                //                return;
                //            }
            //        }
        //        LocalDate importedDate = shipments.get(findShipmentIndex(shipmentTableModel.getValueAt(shipmentTable.getSelectedRow(), 0).toString())).getImportedDate();
        ////        String shipmentIDBeforeEdit = shipments.get(findShipmentIndex(shipmentTableModel.getValueAt(jTable1.getSelectedRow(), 0).toString())).getID();
        //
        //        shipments.set(findShipmentIndex(shipmentTableModel.getValueAt(shipmentTable.getSelectedRow(), 0).toString()), new Shipment(BigDecimal.ZERO, BigDecimal.ZERO, null, null, shipmentIDTextField.getText(), null));
        //        shipments.set(shipmentTable.getSelectedRow(), new Shipment(new BigDecimal(quantityTextField.getText()),
            //                new BigDecimal(importPriceTextField.getText()),
            //                null, null, shipmentIDTextField.getText(), importedDate));
    //        if (doesExpiredToggleBtn.isSelected()) {
        //            shipments.get(findShipmentIndex(shipmentIDTextField.getText())).setNsx(LocalDate.of(Integer.parseInt(NSXYearTextField.getText()), Integer.parseInt(NSXMonthTextField.getText()), Integer.parseInt(NSXDayTextField.getText())));
        //            shipments.get(findShipmentIndex(shipmentIDTextField.getText())).setHsd(LocalDate.of(Integer.parseInt(HSDYearTextField.getText()), Integer.parseInt(HSDMonthTextField.getText()), Integer.parseInt(HSDDayTextField.getText())));
        //        }
        //        reloadTable(shipments);

        addCheck();
        deleteCheck();
        editCheck();
        cancelCheck();
        defaultSettings();
    }//GEN-LAST:event_editButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int selectedRowIndex = shipmentTable.getSelectedRow();

        if (selectedRowIndex < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một lô hàng cần xóa!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int reply = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa lô hàng này không?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            Long shipmentId = Long.valueOf((String)shipmentTableModel.getValueAt(selectedRowIndex, 6));

            boolean result = shipmentDAO.deleteShipment(shipmentId, this.hibernateConfig.getEntityManager());
            if (!result) {
                JOptionPane.showMessageDialog(this, "Xóa thất bại!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            this.product.getShipments().removeIf(shipment -> shipment.getShipmentId().equals(shipmentId));

            shipmentTableModel.removeRow(selectedRowIndex);
            JOptionPane.showMessageDialog(this, "Lô hàng đã được xóa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            defaultSettings();
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        if (doesExpiredToggleBtn.isSelected()) {
            try {
                if (LocalDate.of(Integer.parseInt(NSXYear), Integer.parseInt(NSXMonth), Integer.parseInt(NSXDay))
                    .isBefore(LocalDate.of(Integer.parseInt(HSDYear), Integer.parseInt(HSDMonth), Integer.parseInt(HSDDay)))
                    || LocalDate.of(Integer.parseInt(NSXYear), Integer.parseInt(NSXMonth), Integer.parseInt(NSXDay))
                    .isAfter(LocalDate.now())) {

                    Shipment newShipment = Shipment.builder()
                    .importPrice(shipmentPrice)
                    .quantity(shipmentQuantity)
                    .quantityInStock(shipmentQuantity)
                    .manufacturingDate(LocalDate.of(Integer.parseInt(NSXYear), Integer.parseInt(NSXMonth), Integer.parseInt(NSXDay)))
                    .expiryDate(LocalDate.of(Integer.parseInt(HSDYear), Integer.parseInt(HSDMonth), Integer.parseInt(HSDDay)))
                    .storeId(this.store.getStoreId())
                    .product(this.product)
                    .build();

                    boolean result = shipmentDAO.addShipment(newShipment, this.hibernateConfig.getEntityManager());

                    if (!result) {
                        JOptionPane.showMessageDialog(this, "Thêm thất bại!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }

                    this.product.getShipments().add(newShipment);
                    addShipmentToTable(newShipment);

                } else {
                    JOptionPane.showMessageDialog(null, "Ngày sản xuất không thể trước hạn sử dụng!", "Cảnh báo!", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            } catch (DateTimeException dte) {
                JOptionPane.showMessageDialog(null, "Ngày không hợp lệ!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } else {
            Shipment newShipment = Shipment.builder()
            .importPrice(shipmentPrice)
            .quantity(shipmentQuantity)
            .storeId(this.store.getStoreId())
            .product(this.product)
            .build();

            boolean result = shipmentDAO.addShipment(newShipment, this.hibernateConfig.getEntityManager());

            if (!result) {
                JOptionPane.showMessageDialog(this, "Thêm thất bại!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            this.product.getShipments().add(newShipment);
            addShipmentToTable(newShipment);
        }

        JOptionPane.showMessageDialog(this, "Thêm thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        defaultSettings();
    }//GEN-LAST:event_addButtonActionPerformed

    private void HSDYearTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_HSDYearTextFieldKeyReleased
        HSDYear = dateCheck(HSDYearTextField, HSDYearTextField, HSDYear, 4);
    }//GEN-LAST:event_HSDYearTextFieldKeyReleased

    private void HSDMonthTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_HSDMonthTextFieldKeyReleased
        HSDMonth = dateCheck(HSDMonthTextField, HSDYearTextField, HSDMonth, 2);
    }//GEN-LAST:event_HSDMonthTextFieldKeyReleased

    private void HSDDayTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_HSDDayTextFieldKeyReleased
        HSDDay = dateCheck(HSDDayTextField, HSDMonthTextField, HSDDay, 2);
    }//GEN-LAST:event_HSDDayTextFieldKeyReleased

    private void NSXYearTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NSXYearTextFieldKeyReleased
        NSXYear = dateCheck(NSXYearTextField, HSDDayTextField, NSXYear, 4);
    }//GEN-LAST:event_NSXYearTextFieldKeyReleased

    private void NSXMonthTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NSXMonthTextFieldKeyReleased
        NSXMonth = dateCheck(NSXMonthTextField, NSXYearTextField, NSXMonth, 2);
    }//GEN-LAST:event_NSXMonthTextFieldKeyReleased

    private void NSXDayTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NSXDayTextFieldKeyReleased
        NSXDay = dateCheck(NSXDayTextField, NSXMonthTextField, NSXDay, 2);
    }//GEN-LAST:event_NSXDayTextFieldKeyReleased

    private void doesExpiredToggleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doesExpiredToggleBtnActionPerformed
        Boolean isOn;
        isOn = doesExpiredToggleBtn.getSelectedObjects() != null;
        if (!isOn) {
            saveDateData(false);
        }
        setVisibleDate(isOn, false);
        if (isOn) {
            saveDateData(true);
        }
        addCheck();
        deleteCheck();
        editCheck();
        cancelCheck();
    }//GEN-LAST:event_doesExpiredToggleBtnActionPerformed

    private void quantityTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityTextFieldKeyReleased
        try {
            String input = quantityTextField.getText();
            if (input.length() == 0) {
                errorQuantityLabel.setVisible(false);
                addButton.setEnabled(false);
                return;
            }
            int check = Integer.parseInt(input);
            if (check < 0) {
                errorQuantityLabel.setVisible(true);
                addButton.setEnabled(false);
            } else {
                errorQuantityLabel.setVisible(false);
                shipmentQuantity = check;
                addCheck();
            }
        } catch (NumberFormatException nfe) {
            errorQuantityLabel.setVisible(true);
            addButton.setEnabled(false);
        }
        cancelCheck();
        deleteCheck();
        editCheck();
        addCheck();
    }//GEN-LAST:event_quantityTextFieldKeyReleased

    private void importPriceTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_importPriceTextFieldKeyReleased
        try {
            String input = importPriceTextField.getText();
            if (input.length() == 0) {
                errorPriceLabel.setVisible(false);
                addButton.setEnabled(false);
                return;
            }
            int check = Integer.parseInt(input);
            if (check < 0) {
                errorPriceLabel.setVisible(true);
                addButton.setEnabled(false);
            } else {
                errorPriceLabel.setVisible(false);
                shipmentPrice = check;
                addCheck();
            }
        } catch (NumberFormatException nfe) {
            errorPriceLabel.setVisible(true);
            addButton.setEnabled(false);
        }
        deleteCheck();
        editCheck();
        cancelCheck();
        addCheck();
    }//GEN-LAST:event_importPriceTextFieldKeyReleased

    private void addShipmentToTable(Shipment shipment) {
        shipmentTableModel.addRow(new Object[]{
            shipment.getShipmentId(),
            shipment.getImportPrice(),
            shipment.getQuantity(),
            shipment.getManufacturingDate() != null
            ? FormatOutput.convertLocalDateToString(shipment.getManufacturingDate()) : "_",
            shipment.getExpiryDate() != null
            ? FormatOutput.convertLocalDateToString(shipment.getExpiryDate()) : "_",
            ShipmentUtil.calculateStatus(shipment),
            shipment.getShipmentId()
        });
        shipmentTable.getColumnModel().getColumn(6).setMaxWidth(0);
        shipmentTable.getColumnModel().getColumn(6).setMinWidth(0);
        shipmentTable.getColumnModel().getColumn(6).setPreferredWidth(0);
    }

    private void addCheck() {
        if (doesExpiredToggleBtn.isSelected()) {
            if (!shipmentIDTextField.getText().isEmpty()
                    && !importPriceTextField.getText().isEmpty()
                    && !quantityTextField.getText().isEmpty()
                    && !errorPriceLabel.isVisible()
                    && !errorQuantityLabel.isVisible()
                    && !NSXDayTextField.getText().isEmpty()
                    && !NSXMonthTextField.getText().isEmpty()
                    && !NSXYearTextField.getText().isEmpty()
                    && !HSDDayTextField.getText().isEmpty()
                    && !HSDMonthTextField.getText().isEmpty()
                    && !HSDYearTextField.getText().isEmpty()
                    && !errorDateLabel.isVisible()) {
                addButton.setEnabled(true);
            } else {
                addButton.setEnabled(false);
            }
        } else {
            if (!shipmentIDTextField.getText().isEmpty()
                    && !importPriceTextField.getText().isEmpty()
                    && !quantityTextField.getText().isEmpty()
                    && !errorPriceLabel.isVisible()
                    && !errorQuantityLabel.isVisible()) {
                addButton.setEnabled(true);
            } else {
                addButton.setEnabled(false);
            }
        }
    }

    private void editCheck() {
        if (shipmentTable.getSelectedRow() != -1
                && !errorPriceLabel.isVisible()
                && !errorQuantityLabel.isVisible()
                && !errorDateLabel.isVisible()) {
            editButton.setEnabled(true);
        } else {
            editButton.setEnabled(false);
        }
    }

    private void deleteCheck() {
        if (shipmentTable.getSelectedRow() != -1) {
            deleteButton.setEnabled(true);
        } else {
            deleteButton.setEnabled(false);
        }
    }

    public void cancelCheck() {
        if (shipmentTable.getSelectedRow() != -1
                || !shipmentIDTextField.getText().isEmpty()
                || !importPriceTextField.getText().isEmpty()
                || !quantityTextField.getText().isEmpty()
                || !NSXDayTextField.getText().isEmpty()
                || !NSXMonthTextField.getText().isEmpty() || ! !NSXYearTextField.getText().isEmpty()
                || !HSDDayTextField.getText().isEmpty()
                || !HSDMonthTextField.getText().isEmpty()
                || !HSDYearTextField.getText().isEmpty()
                || filterCategories.getSelectedIndex() != -1) {
            cancelButton.setEnabled(true);
        } else {
            cancelButton.setEnabled(false);
        }
    }

    private String dateCheck(JTextField textField, Component nextField, String date, int maxLength) {
        if (textField.getText().length() == 0) {
            errorDateLabel.setVisible(false);
            return "";
        }
        String currentText;
        if ((currentText = textField.getText()).length() > maxLength) {
            textField.setText(currentText.substring(0, maxLength));
        }
        try {
            Integer.valueOf(textField.getText());
            date = textField.getText();
            errorDateLabel.setVisible(false);
        } catch (NumberFormatException nfe) {
            errorDateLabel.setVisible(true);
        }
        if (textField.getText().length() == maxLength) {
            nextField.requestFocusInWindow();
        }
        addCheck();
        deleteCheck();
        editCheck();
        cancelCheck();
        return date;
    }

    public void setOpenButton(Boolean isSelected) {
        doesExpiredToggleBtn.setSelected(isSelected);
    }

    private void displayShipments(List<Shipment> shipments) {
        shipmentTableModel.setRowCount(0);

        if (shipmentTableModel.getColumnCount() == 6) {
            shipmentTableModel.addColumn("ShipmentId");
        }
        for (Shipment shipment : shipments) {
            Object[] rowData = {
                shipment.getShipmentId(),
                shipment.getImportPrice(),
                shipment.getQuantity(),
                shipment.getManufacturingDate() != null
                ? FormatOutput.convertLocalDateToString(shipment.getManufacturingDate()) : "_",
                shipment.getExpiryDate() != null
                ? FormatOutput.convertLocalDateToString(shipment.getExpiryDate()) : "_",
                ShipmentUtil.calculateStatus(shipment),
                shipment.getShipmentId()
            };
            shipmentTableModel.addRow(rowData);
        }

        shipmentTable.getColumn(6).setMaxWidth(0);
        shipmentTable.getColumn(6).setMinWidth(0);
        shipmentTable.getColumn(6).setPreferredWidth(0);
    }

    public void setup(HibernateConfig hibernateConfig, Store store, MainFrame mf) {
        this.store = store;
        this.mf = mf;
        this.hibernateConfig = hibernateConfig;
        this.shipmentTableModel = (DefaultTableModel) shipmentTable.getModel();
    }
    
    public void setProduct(Product product){
        this.product = product;
    }

    private ShipmentDAO shipmentDAO;
    private HibernateConfig hibernateConfig;
    private MainFrame mf;

    private Product product;
    private Store store;
    private int shipmentPrice = 0;
    private int shipmentQuantity = 0;
    private String NSXDay;
    private String NSXMonth;
    private String NSXYear;
    private String HSDDay;
    private String HSDMonth;
    private String HSDYear;
    private DefaultTableModel shipmentTableModel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DayLabel;
    private javax.swing.JTextField HSDDayTextField;
    private javax.swing.JLabel HSDLabel;
    private javax.swing.JTextField HSDMonthTextField;
    private javax.swing.JTextField HSDYearTextField;
    private javax.swing.JLabel MonthLabel;
    private javax.swing.JTextField NSXDayTextField;
    private javax.swing.JLabel NSXLabel;
    private javax.swing.JTextField NSXMonthTextField;
    private javax.swing.JTextField NSXYearTextField;
    private javax.swing.JLabel YearLabel;
    private javax.swing.JButton addButton;
    private javax.swing.JButton backBtn;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel doesExpiredLabel;
    private javax.swing.JToggleButton doesExpiredToggleBtn;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel errorDateLabel;
    private javax.swing.JLabel errorPriceLabel;
    private javax.swing.JLabel errorQuantityLabel;
    private javax.swing.JButton filterBtn;
    private javax.swing.JComboBox<String> filterCategories;
    private javax.swing.JComboBox<String> filterExtraOption;
    private javax.swing.JPanel goodsInfoPanel;
    private javax.swing.JLabel importPriceLabel;
    private javax.swing.JTextField importPriceTextField;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel quantityLabel;
    private javax.swing.JTextField quantityTextField;
    private javax.swing.JPanel shipmentControlPanel;
    private javax.swing.JLabel shipmentIDLabel;
    private javax.swing.JTextField shipmentIDTextField;
    private javax.swing.JTable shipmentTable;
    private javax.swing.JPanel shipmentTablePanel;
    // End of variables declaration//GEN-END:variables
}
