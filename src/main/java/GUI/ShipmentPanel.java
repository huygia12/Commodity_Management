/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import Models.Goods;

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
        returnButton = new javax.swing.JButton();
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

        importPriceLabel.setText("Giá nhập hàng:");

        quantityLabel.setText("Số lượng: ");

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

        returnButton.setText("Trở lại");

        javax.swing.GroupLayout shipmentControlPanelLayout = new javax.swing.GroupLayout(shipmentControlPanel);
        shipmentControlPanel.setLayout(shipmentControlPanelLayout);
        shipmentControlPanelLayout.setHorizontalGroup(
            shipmentControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shipmentControlPanelLayout.createSequentialGroup()
                .addGroup(shipmentControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(shipmentControlPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(shipmentControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(shipmentControlPanelLayout.createSequentialGroup()
                                .addGroup(shipmentControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(importPriceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                                    .addComponent(shipmentIDLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(quantityLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(shipmentControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(quantityTextField)
                                    .addGroup(shipmentControlPanelLayout.createSequentialGroup()
                                        .addGroup(shipmentControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(importPriceTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                            .addComponent(shipmentIDTextField, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(shipmentControlPanelLayout.createSequentialGroup()
                                .addComponent(doesExpiredToggleBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(doesExpiredLabel))
                            .addGroup(shipmentControlPanelLayout.createSequentialGroup()
                                .addGroup(shipmentControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(HSDLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(NSXLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(shipmentControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(shipmentControlPanelLayout.createSequentialGroup()
                                        .addComponent(NSXDayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(NSXMonthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(NSXYearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(shipmentControlPanelLayout.createSequentialGroup()
                                        .addGroup(shipmentControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(DayLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(HSDDayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(shipmentControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(shipmentControlPanelLayout.createSequentialGroup()
                                                .addComponent(HSDMonthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(MonthLabel))
                                        .addGroup(shipmentControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(shipmentControlPanelLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(HSDYearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, shipmentControlPanelLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(YearLabel)
                                                .addGap(15, 15, 15))))))))
                    .addGroup(shipmentControlPanelLayout.createSequentialGroup()
                        .addGroup(shipmentControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(shipmentControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(editButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(shipmentControlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(returnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        shipmentControlPanelLayout.setVerticalGroup(
            shipmentControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shipmentControlPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(shipmentControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(shipmentIDLabel)
                    .addComponent(shipmentIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(shipmentControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(importPriceLabel)
                    .addComponent(importPriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(shipmentControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quantityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantityLabel))
                .addGap(18, 18, 18)
                .addGroup(shipmentControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(doesExpiredLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(doesExpiredToggleBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(shipmentControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NSXLabel)
                    .addComponent(NSXDayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(NSXMonthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(NSXYearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(shipmentControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HSDLabel)
                    .addComponent(HSDDayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(HSDMonthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(HSDYearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(shipmentControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DayLabel)
                    .addComponent(MonthLabel)
                    .addComponent(YearLabel))
                .addGap(18, 18, 18)
                .addGroup(shipmentControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(editButton))
                .addGap(18, 18, 18)
                .addGroup(shipmentControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteButton)
                    .addComponent(cancelButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                .addComponent(returnButton)
                .addGap(14, 14, 14))
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

    private void NSXDayTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NSXDayTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NSXDayTextFieldActionPerformed
    
    public void attachGood (Goods good) {
        this.attachedGood = good;
    }
    
    // Custom variables declaration
    private Goods attachedGood;
    
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
    private javax.swing.JButton returnButton;
    private javax.swing.JPanel shipmentControlPanel;
    private javax.swing.JLabel shipmentIDLabel;
    private javax.swing.JTextField shipmentIDTextField;
    private javax.swing.JPanel shipmentTablePanel;
    // End of variables declaration//GEN-END:variables
}
