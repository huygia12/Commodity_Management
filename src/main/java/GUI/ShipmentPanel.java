/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import Models.Goods;
import Models.Shipment;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ms Linh
 */
public class ShipmentPanel extends javax.swing.JPanel {

    /**
     * Creates new form ShipmentPanel
     */
    public ShipmentPanel() {
        initComponents();

        defaultSettings();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        goodsInfoPanel = new javax.swing.JPanel();
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
        errorIDLabel = new javax.swing.JLabel();
        errorPriceLabel = new javax.swing.JLabel();
        errorQuantityLabel = new javax.swing.JLabel();
        errorDateLabel = new javax.swing.JLabel();
        shipmentTablePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(0, 204, 255));
        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), 2), "SHIPMENT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        setMaximumSize(new java.awt.Dimension(980, 620));
        setMinimumSize(new java.awt.Dimension(980, 620));
        setPreferredSize(new java.awt.Dimension(980, 620));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        goodsInfoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin sản phẩm"));

        javax.swing.GroupLayout goodsInfoPanelLayout = new javax.swing.GroupLayout(goodsInfoPanel);
        goodsInfoPanel.setLayout(goodsInfoPanelLayout);
        goodsInfoPanelLayout.setHorizontalGroup(
            goodsInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 660, Short.MAX_VALUE)
        );
        goodsInfoPanelLayout.setVerticalGroup(
            goodsInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 127, Short.MAX_VALUE)
        );

        add(goodsInfoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 670, 150));

        shipmentControlPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lô hàng", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        shipmentIDLabel.setText("Mã lô hàng:");

        shipmentIDTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                shipmentIDTextFieldKeyReleased(evt);
            }
        });

        importPriceLabel.setText("Giá nhập hàng:");

        quantityLabel.setText("Số lượng: ");

        doesExpiredToggleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doesExpiredToggleBtnActionPerformed(evt);
            }
        });

        doesExpiredLabel.setText("Có ngày sản xuất, hạn sử dụng?");

        NSXLabel.setText("Ngày sản xuất:");

        NSXDayTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NSXDayTextFieldActionPerformed(evt);
            }
        });

        jLabel2.setText("/");

        jLabel3.setText("/");

        HSDLabel.setText("Hạn sử dụng:");

        jLabel5.setText("/");

        jLabel6.setText("/");

        DayLabel.setText("Ngày");

        MonthLabel.setText("Tháng");

        YearLabel.setText("Năm");

        addButton.setText("Thêm");

        deleteButton.setText("Xóa");

        editButton.setText("Sửa");

        cancelButton.setText("Hủy");

        errorIDLabel.setForeground(new java.awt.Color(255, 51, 51));
        errorIDLabel.setText("Mã không hợp lệ!");

        errorPriceLabel.setForeground(new java.awt.Color(255, 51, 51));
        errorPriceLabel.setText("Giá không hợp lệ!");

        errorQuantityLabel.setForeground(new java.awt.Color(255, 51, 51));
        errorQuantityLabel.setText("Số lượng không hợp lệ!");

        errorDateLabel.setForeground(new java.awt.Color(255, 51, 51));
        errorDateLabel.setText("Ngày không hợp lệ!");

        javax.swing.GroupLayout shipmentControlPanelLayout = new javax.swing.GroupLayout(shipmentControlPanel);
        shipmentControlPanel.setLayout(shipmentControlPanelLayout);
        shipmentControlPanelLayout.setHorizontalGroup(
            shipmentControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shipmentControlPanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(shipmentIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(shipmentControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(errorIDLabel)
                    .addComponent(shipmentIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, shipmentControlPanelLayout.createSequentialGroup()
                .addGroup(shipmentControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(shipmentControlPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(importPriceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(importPriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(shipmentControlPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(doesExpiredToggleBtn)
                        .addGap(12, 12, 12)
                        .addComponent(doesExpiredLabel))
                    .addGroup(shipmentControlPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(NSXLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(NSXDayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2)
                        .addGap(6, 6, 6)
                        .addComponent(NSXMonthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3)
                        .addGap(6, 6, 6)
                        .addComponent(NSXYearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(shipmentControlPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(HSDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(HSDDayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel5)
                        .addGap(6, 6, 6)
                        .addComponent(HSDMonthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel6)
                        .addGap(6, 6, 6)
                        .addComponent(HSDYearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(shipmentControlPanelLayout.createSequentialGroup()
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(shipmentControlPanelLayout.createSequentialGroup()
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(shipmentControlPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(quantityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(shipmentControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(errorPriceLabel)
                            .addComponent(quantityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(errorQuantityLabel)))
                    .addGroup(shipmentControlPanelLayout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(shipmentControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(errorDateLabel)
                            .addGroup(shipmentControlPanelLayout.createSequentialGroup()
                                .addComponent(DayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addComponent(MonthLabel)
                                .addGap(30, 30, 30)
                                .addComponent(YearLabel)))))
                .addContainerGap())
        );
        shipmentControlPanelLayout.setVerticalGroup(
            shipmentControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shipmentControlPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(shipmentControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(shipmentControlPanelLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(shipmentIDLabel))
                    .addComponent(shipmentIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorIDLabel)
                .addGap(15, 15, 15)
                .addGroup(shipmentControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(shipmentControlPanelLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(importPriceLabel))
                    .addComponent(importPriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(errorPriceLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(shipmentControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(shipmentControlPanelLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(quantityLabel))
                    .addComponent(quantityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(errorQuantityLabel)
                .addGap(12, 12, 12)
                .addGroup(shipmentControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(doesExpiredToggleBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(doesExpiredLabel))
                .addGap(12, 12, 12)
                .addGroup(shipmentControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NSXDayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NSXMonthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NSXYearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(shipmentControlPanelLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(shipmentControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NSXLabel)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))))
                .addGap(18, 18, 18)
                .addGroup(shipmentControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(HSDDayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HSDMonthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HSDYearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(shipmentControlPanelLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(shipmentControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(HSDLabel)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))))
                .addGap(6, 6, 6)
                .addGroup(shipmentControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DayLabel)
                    .addComponent(MonthLabel)
                    .addComponent(YearLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(errorDateLabel)
                .addGap(9, 9, 9)
                .addGroup(shipmentControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addButton)
                    .addComponent(editButton))
                .addGap(18, 18, 18)
                .addGroup(shipmentControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deleteButton)
                    .addComponent(cancelButton))
                .addGap(118, 118, 118))
        );

        add(shipmentControlPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 260, 560));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
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
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout shipmentTablePanelLayout = new javax.swing.GroupLayout(shipmentTablePanel);
        shipmentTablePanel.setLayout(shipmentTablePanelLayout);
        shipmentTablePanelLayout.setHorizontalGroup(
            shipmentTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
        );
        shipmentTablePanelLayout.setVerticalGroup(
            shipmentTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shipmentTablePanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        add(shipmentTablePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 200, 670, 400));
    }// </editor-fold>//GEN-END:initComponents

    public void defaultSettings() {
        Instance = this;
        shipmentTableModel = (DefaultTableModel) jTable1.getModel();
        updateStatus();
        errorDateLabel.setVisible(false);
        errorIDLabel.setVisible(false);
        errorPriceLabel.setVisible(false);
        errorQuantityLabel.setVisible(false);
        setVisibleDate(false);
    }

    private void setVisibleDate(Boolean isVisible) {
        NSXLabel.setVisible(isVisible);
        NSXDayTextField.setVisible(isVisible);
        NSXMonthTextField.setVisible(isVisible);
        NSXYearTextField.setVisible(isVisible);

        HSDLabel.setVisible(isVisible);
        HSDDayTextField.setVisible(isVisible);
        HSDMonthTextField.setVisible(isVisible);
        HSDYearTextField.setVisible(isVisible);

        jLabel2.setVisible(isVisible);
        jLabel3.setVisible(isVisible);
        jLabel5.setVisible(isVisible);
        jLabel6.setVisible(isVisible);

        DayLabel.setVisible(isVisible);
        MonthLabel.setVisible(isVisible);
        YearLabel.setVisible(isVisible);
    }
    private void NSXDayTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NSXDayTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NSXDayTextFieldActionPerformed

    private void shipmentIDTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_shipmentIDTextFieldKeyReleased
        // TODO add your handling code here:
        long dupedID = shipments.stream().filter(x -> x.getID().equalsIgnoreCase(shipmentIDTextField.getText())).count();
        if (shipmentIDTextField.getText().isEmpty()) {
            errorIDLabel.setVisible(false);
        }
        boolean dupedIDOnTable = true;
        try {
            dupedIDOnTable = shipmentIDTextField.getText().equals(shipmentTableModel.getValueAt(jTable1.getSelectedRow(), 0).toString());
        } catch (ArrayIndexOutOfBoundsException aioobe) {

        } catch (NullPointerException npe) {

        }
        if (dupedID == 0 || (dupedIDOnTable && jTable1.getSelectedRow() != -1)) {
            shipmentID = shipmentIDTextField.getText();
            addCheck();
            errorIDLabel.setVisible(false);
        } else {
            errorIDLabel.setVisible(true);
        }
    }//GEN-LAST:event_shipmentIDTextFieldKeyReleased

    private void doesExpiredToggleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doesExpiredToggleBtnActionPerformed
        // TODO add your handling code here:
        Boolean isOn;
        if (doesExpiredToggleBtn.getSelectedObjects() == null) {
            isOn = false;
        } else {
            isOn = true;
        }

        setVisibleDate(isOn);
    }//GEN-LAST:event_doesExpiredToggleBtnActionPerformed

    private void addCheck() {

    }

    public void setOpenButton(Boolean isSelected) {
        doesExpiredToggleBtn.setSelected(isSelected);
    }

    public void reloadTable(List<Shipment> shipments) {
        int rowToRemove = shipmentTableModel.getRowCount();
        for (int i = 0; i < rowToRemove; i++) {
            shipmentTableModel.removeRow(0);
        }
        try {
            for (Shipment shipment : shipments) {
                if (shipment.getNsx() == null) {
                    shipmentTableModel.addRow(new Object[]{
                        shipment.getID(),
                        shipment.getImportPrice(),
                        shipment.getQuantity(),
                        "", "",
                        shipment.calculateStatus()
                    });
                } else {
                    shipmentTableModel.addRow(new Object[]{
                        shipment.getID(),
                        shipment.getImportPrice(),
                        shipment.getQuantity(),
                        shipment.getNsx(),
                        shipment.getHsd(),
                        shipment.calculateStatus()
                    });
                }
            }
        } catch (NullPointerException npe) {

        }
    }

    private void updateStatus() {
        new Thread() {
            @Override
            public void run() {
                try {
                    while (true) {
                        try {
                            reloadTable(shipments);
                        } catch (NullPointerException npe) {

                        }
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException ex) {

                }
            }
        }.start();
    }

    public void attachGood(Goods good) {
        this.attachedGood = good;
        this.shipments = good.getShipments();
    }

    // Custom variables declaration
    private Goods attachedGood;
    private List<Shipment> shipments;

    private String shipmentID = "";
    private BigDecimal shipmentPrice = BigDecimal.ZERO;
    private BigDecimal shipmentQuantity = BigDecimal.ZERO;
    private LocalDate manufacturerDate;
    private LocalDate expiredDate;

    public static ShipmentPanel Instance;
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
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel doesExpiredLabel;
    private javax.swing.JToggleButton doesExpiredToggleBtn;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel errorDateLabel;
    private javax.swing.JLabel errorIDLabel;
    private javax.swing.JLabel errorPriceLabel;
    private javax.swing.JLabel errorQuantityLabel;
    private javax.swing.JPanel goodsInfoPanel;
    private javax.swing.JLabel importPriceLabel;
    private javax.swing.JTextField importPriceTextField;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel quantityLabel;
    private javax.swing.JTextField quantityTextField;
    private javax.swing.JPanel shipmentControlPanel;
    private javax.swing.JLabel shipmentIDLabel;
    private javax.swing.JTextField shipmentIDTextField;
    private javax.swing.JPanel shipmentTablePanel;
    // End of variables declaration//GEN-END:variables
}
