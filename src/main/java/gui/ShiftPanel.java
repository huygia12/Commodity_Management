package gui;

import config.HibernateConfig;
import dao.InvoiceDAO;
import dao.ShiftDAO;
import dao.impl.InvoiceDAOImpl;
import dao.impl.ShiftDAOImpl;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import model.entities.Invoice;
import model.entities.Shift;
import model.entities.Store;
import model.enums.ShiftState;
import util.FormatOutput;
import util.InvoiceUtil;
import util.PrinterUtil;
import util.ShiftUtil;
import util.ValidateInput;

public class ShiftPanel extends javax.swing.JPanel {

    public ShiftPanel() {
        initComponents();
        customUI();
    }

    private void customUI() {
        tb = (TitledBorder) currentShiftOverViewPanel.getBorder();
        tb.setTitleFont(new java.awt.Font("Segoe UI", 1, 14));
        tb.setTitleJustification(TitledBorder.DEFAULT_POSITION);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ordersAndShipsHistoryPanel = new javax.swing.JPanel();
        searchAndTablePanel = new javax.swing.JPanel();
        searchPanel = new javax.swing.JPanel();
        orderIDLabel = new javax.swing.JLabel();
        orderIDTextField = new javax.swing.JTextField();
        fromLabel = new javax.swing.JLabel();
        fromHourTextField = new javax.swing.JTextField();
        toLabel = new javax.swing.JLabel();
        searchBtn = new javax.swing.JButton();
        fromMinuteTextField = new javax.swing.JTextField();
        separatorLabel4 = new javax.swing.JLabel();
        toHourTextField = new javax.swing.JTextField();
        toMinuteTextField = new javax.swing.JTextField();
        separatorLabel2 = new javax.swing.JLabel();
        orderDateTextField = new javax.swing.JTextField();
        orderDateLabel = new javax.swing.JLabel();
        refreshBtn = new javax.swing.JButton();
        orderListJScrollPane = new javax.swing.JScrollPane();
        orderTable = new javax.swing.JTable();
        otherFunctionPanel = new javax.swing.JPanel();
        currentShiftOverViewPanel = new javax.swing.JPanel();
        openBalanceLabel = new javax.swing.JLabel();
        openBalanceTextField = new javax.swing.JTextField();
        surchargeLabel = new javax.swing.JLabel();
        shiftEmployeeListLabel = new javax.swing.JLabel();
        surchargeTextField = new javax.swing.JTextField();
        shiftEmployeeListComboBox = new javax.swing.JComboBox<>();
        shiftCashierLabel = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        grossRevenueLabel = new javax.swing.JLabel();
        netRevenueLabel = new javax.swing.JLabel();
        numberOfOrderLabel = new javax.swing.JLabel();
        numberOfOrderTextField = new javax.swing.JTextField();
        netRevenueTextField = new javax.swing.JTextField();
        grossRevenueTextField = new javax.swing.JTextField();
        endShiftBtn = new javax.swing.JButton();
        editShiftBtn = new javax.swing.JButton();
        shiftCashierTextField = new javax.swing.JTextField();
        orderDetailJScrollPane = new javax.swing.JScrollPane();
        orderDetailTable = new javax.swing.JTable();

        setMinimumSize(new java.awt.Dimension(1400, 800));
        setPreferredSize(new java.awt.Dimension(1400, 800));
        setLayout(new java.awt.BorderLayout(10, 0));

        ordersAndShipsHistoryPanel.setPreferredSize(new java.awt.Dimension(350, 595));
        ordersAndShipsHistoryPanel.setLayout(new java.awt.BorderLayout(10, 0));

        searchAndTablePanel.setPreferredSize(new java.awt.Dimension(350, 562));
        searchAndTablePanel.setLayout(new java.awt.BorderLayout(0, 10));

        searchPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm Kiếm"));
        searchPanel.setMinimumSize(new java.awt.Dimension(0, 234));
        searchPanel.setPreferredSize(new java.awt.Dimension(350, 234));

        orderIDLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        orderIDLabel.setText("Mã HĐ: ");

        orderIDTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        orderIDTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        fromLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fromLabel.setText("Từ:");

        fromHourTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fromHourTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fromHourTextField.setText("00");
        fromHourTextField.setMaximumSize(new java.awt.Dimension(64, 26));
        fromHourTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                fromHourTextFieldMouseExited(evt);
            }
        });
        fromHourTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fromHourTextFieldKeyPressed(evt);
            }
        });

        toLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        toLabel.setText("Đến:");

        searchBtn.setBackground(new java.awt.Color(0, 255, 0));
        searchBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        searchBtn.setText("Tìm Kiếm");
        searchBtn.setMaximumSize(new java.awt.Dimension(107, 27));
        searchBtn.setMinimumSize(new java.awt.Dimension(107, 27));
        searchBtn.setPreferredSize(new java.awt.Dimension(107, 27));
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        fromMinuteTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fromMinuteTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fromMinuteTextField.setText("00");
        fromMinuteTextField.setMaximumSize(new java.awt.Dimension(64, 26));
        fromMinuteTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                fromMinuteTextFieldMouseExited(evt);
            }
        });
        fromMinuteTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fromMinuteTextFieldKeyPressed(evt);
            }
        });

        separatorLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        separatorLabel4.setText(":");

        toHourTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        toHourTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        toHourTextField.setText("00");
        toHourTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                toHourTextFieldMouseExited(evt);
            }
        });
        toHourTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                toHourTextFieldKeyPressed(evt);
            }
        });

        toMinuteTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        toMinuteTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        toMinuteTextField.setText("00");
        toMinuteTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                toMinuteTextFieldMouseExited(evt);
            }
        });
        toMinuteTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                toMinuteTextFieldKeyPressed(evt);
            }
        });

        separatorLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        separatorLabel2.setText(":");

        orderDateTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        orderDateTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        orderDateLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        orderDateLabel.setText("Ngày lập HĐ:");

        refreshBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageIcon/reload (3).png"))); // NOI18N
        refreshBtn.setBorder(null);
        refreshBtn.setContentAreaFilled(false);
        refreshBtn.setFocusable(false);
        refreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(searchPanelLayout.createSequentialGroup()
                        .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(orderDateLabel)
                            .addComponent(orderIDLabel))
                        .addGap(21, 21, 21)
                        .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(orderDateTextField)
                            .addComponent(orderIDTextField)))
                    .addGroup(searchPanelLayout.createSequentialGroup()
                        .addComponent(fromLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fromHourTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(separatorLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fromMinuteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(searchPanelLayout.createSequentialGroup()
                                .addComponent(toLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(toHourTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(separatorLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(toMinuteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(searchPanelLayout.createSequentialGroup()
                                .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(refreshBtn)))))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchPanelLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(orderIDLabel))
                    .addComponent(orderIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(orderDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(orderDateLabel))
                .addGap(18, 18, 18)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(toLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fromLabel)
                        .addComponent(fromHourTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(separatorLabel4)
                        .addComponent(fromMinuteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(separatorLabel2)
                        .addComponent(toMinuteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(toHourTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchPanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(refreshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(searchPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        searchAndTablePanel.add(searchPanel, java.awt.BorderLayout.PAGE_START);

        orderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã HĐ", "Ngày lập HĐ", "Tổng tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        orderTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        orderTable.setShowGrid(true);
        orderTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                orderTableMouseClicked(evt);
            }
        });
        orderListJScrollPane.setViewportView(orderTable);

        searchAndTablePanel.add(orderListJScrollPane, java.awt.BorderLayout.CENTER);

        ordersAndShipsHistoryPanel.add(searchAndTablePanel, java.awt.BorderLayout.CENTER);

        add(ordersAndShipsHistoryPanel, java.awt.BorderLayout.LINE_START);

        otherFunctionPanel.setLayout(new java.awt.BorderLayout(0, 10));

        currentShiftOverViewPanel.setBackground(new java.awt.Color(0, 153, 255));
        currentShiftOverViewPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        currentShiftOverViewPanel.setFocusable(false);
        currentShiftOverViewPanel.setOpaque(false);
        currentShiftOverViewPanel.setPreferredSize(new java.awt.Dimension(617, 234));

        openBalanceLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        openBalanceLabel.setText("Số Dư Đầu Ca : ");

        openBalanceTextField.setEditable(false);
        openBalanceTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        openBalanceTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        surchargeLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        surchargeLabel.setText("Chi Tiêu Trong Ca : ");

        shiftEmployeeListLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        shiftEmployeeListLabel.setText("Nhân Viên Trực Ca:");

        surchargeTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        surchargeTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        surchargeTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                surchargeTextFieldMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                surchargeTextFieldMouseExited(evt);
            }
        });
        surchargeTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                surchargeTextFieldKeyPressed(evt);
            }
        });

        shiftEmployeeListComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        shiftEmployeeListComboBox.setAutoscrolls(true);

        shiftCashierLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        shiftCashierLabel.setText("Thu Ngân Ca:");

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        grossRevenueLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        grossRevenueLabel.setText("Doanh Thu Hiện Tại: ");

        netRevenueLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        netRevenueLabel.setText("Lợi Nhuận Ròng:");

        numberOfOrderLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        numberOfOrderLabel.setText("Tổng Số Hóa Đơn:");

        numberOfOrderTextField.setEditable(false);
        numberOfOrderTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        numberOfOrderTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        netRevenueTextField.setEditable(false);
        netRevenueTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        netRevenueTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        grossRevenueTextField.setEditable(false);
        grossRevenueTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        grossRevenueTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        endShiftBtn.setBackground(new java.awt.Color(255, 0, 0));
        endShiftBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        endShiftBtn.setForeground(new java.awt.Color(255, 255, 255));
        endShiftBtn.setText("Chốt Ca");
        endShiftBtn.setMaximumSize(new java.awt.Dimension(107, 27));
        endShiftBtn.setMinimumSize(new java.awt.Dimension(107, 27));
        endShiftBtn.setPreferredSize(new java.awt.Dimension(107, 27));
        endShiftBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endShiftBtnActionPerformed(evt);
            }
        });

        editShiftBtn.setBackground(new java.awt.Color(0, 255, 0));
        editShiftBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        editShiftBtn.setText("Sửa Ca");
        editShiftBtn.setMaximumSize(new java.awt.Dimension(107, 27));
        editShiftBtn.setMinimumSize(new java.awt.Dimension(107, 27));
        editShiftBtn.setPreferredSize(new java.awt.Dimension(107, 27));
        editShiftBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editShiftBtnActionPerformed(evt);
            }
        });

        shiftCashierTextField.setEditable(false);
        shiftCashierTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        shiftCashierTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout currentShiftOverViewPanelLayout = new javax.swing.GroupLayout(currentShiftOverViewPanel);
        currentShiftOverViewPanel.setLayout(currentShiftOverViewPanelLayout);
        currentShiftOverViewPanelLayout.setHorizontalGroup(
            currentShiftOverViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(currentShiftOverViewPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(currentShiftOverViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, currentShiftOverViewPanelLayout.createSequentialGroup()
                        .addComponent(editShiftBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(endShiftBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, currentShiftOverViewPanelLayout.createSequentialGroup()
                        .addGroup(currentShiftOverViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(surchargeLabel)
                            .addComponent(shiftEmployeeListLabel)
                            .addComponent(shiftCashierLabel)
                            .addComponent(openBalanceLabel))
                        .addGap(25, 25, 25)
                        .addGroup(currentShiftOverViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(currentShiftOverViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(shiftEmployeeListComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, 332, Short.MAX_VALUE)
                                .addComponent(shiftCashierTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(openBalanceTextField, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(surchargeTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(39, 39, 39)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(currentShiftOverViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(numberOfOrderLabel)
                    .addGroup(currentShiftOverViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(grossRevenueLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(netRevenueLabel)))
                .addGap(18, 18, 18)
                .addGroup(currentShiftOverViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(grossRevenueTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                    .addComponent(numberOfOrderTextField)
                    .addComponent(netRevenueTextField))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        currentShiftOverViewPanelLayout.setVerticalGroup(
            currentShiftOverViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(currentShiftOverViewPanelLayout.createSequentialGroup()
                .addGroup(currentShiftOverViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(currentShiftOverViewPanelLayout.createSequentialGroup()
                        .addGroup(currentShiftOverViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(currentShiftOverViewPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(openBalanceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(openBalanceTextField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(currentShiftOverViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(shiftCashierTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                            .addComponent(shiftCashierLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6)
                        .addGroup(currentShiftOverViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(shiftEmployeeListComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(shiftEmployeeListLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(currentShiftOverViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(surchargeTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                            .addComponent(surchargeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(currentShiftOverViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(endShiftBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                            .addComponent(editShiftBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jSeparator2))
                .addContainerGap())
            .addGroup(currentShiftOverViewPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(currentShiftOverViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numberOfOrderTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numberOfOrderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(currentShiftOverViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(grossRevenueTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(grossRevenueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(currentShiftOverViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(netRevenueTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(netRevenueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        otherFunctionPanel.add(currentShiftOverViewPanel, java.awt.BorderLayout.PAGE_START);

        orderDetailTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "ĐV", "Đơn Giá/ĐV", "Mã Lô", "SL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        orderDetailTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        orderDetailTable.setShowGrid(true);
        orderDetailJScrollPane.setViewportView(orderDetailTable);

        otherFunctionPanel.add(orderDetailJScrollPane, java.awt.BorderLayout.CENTER);

        add(otherFunctionPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void endShiftBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endShiftBtnActionPerformed
        String surcharge = surchargeTextField.getText().trim();
        if (!checkSurcharge) {
            JOptionPane.showMessageDialog(this, "Khoản chi tiêu không hợp lệ!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        this.shift.setSurcharge(Integer.valueOf(surcharge));
        boolean result = shiftDAO.closeShift(this.shift, this.hibernateConfig.getEntityManager());

        if (!result) {
            JOptionPane.showMessageDialog(this, "Đóng ca thất bại!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        int choice = JOptionPane.showConfirmDialog(this, "In báo cáo tổng kết cuối ca?",
                "Đóng ca hoàn tất", JOptionPane.OK_CANCEL_OPTION);
        if (choice == JOptionPane.OK_OPTION) {
            PrinterUtil.exportShiftToTxtFile(store, shift);
        }
    }//GEN-LAST:event_endShiftBtnActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        String invoiceID = orderIDTextField.getText().trim();
        String orderDate = orderDateTextField.getText().trim();
        String orderTimeFrom = fromHourTextField.getText().trim() + ":" + fromMinuteTextField.getText().trim();
        String orderTimeTo = toHourTextField.getText().trim() + ":" + toMinuteTextField.getText().trim();

        this.searchingInvoiceId = invoiceID;
        this.filterDate = FormatOutput.convertStringToLocalDateTime(orderDate);
        this.filterDateTimeFrom = FormatOutput.convertStringToLocalDateTime(orderDate, orderTimeFrom);
        this.filterDateTimeTo = FormatOutput.convertStringToLocalDateTime(orderDate, orderTimeTo);
        refreshOrderTable();
    }//GEN-LAST:event_searchBtnActionPerformed

    private void editShiftBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editShiftBtnActionPerformed
        openShiftFrame = new OpenShiftFrame();
        popupOpenShiftFrame();
    }//GEN-LAST:event_editShiftBtnActionPerformed

    private void surchargeTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_surchargeTextFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String surchargeStr = surchargeTextField.getText();
            if (surchargeStr.isBlank()) { //Kiểm tra ô trống
                surchargeTextField.setText("0");
                shift.setSurcharge(0);
                return;
            }
            if (!ValidateInput.checkIfAValidNumberForGUI(surchargeStr)) {
                insertWarningToTextField(surchargeTextField, INVALID_WARNING, 14);
                checkSurcharge = false;
                return;
            }
            checkSurcharge = true;
            surchargeTextField.setText(String.format("%d", shift.getSurcharge()));
        }
    }//GEN-LAST:event_surchargeTextFieldKeyPressed

    private void surchargeTextFieldMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_surchargeTextFieldMouseExited
        if (!surchargeTextField.isEnabled()) {
            return;
        }
        String surchargeStr = surchargeTextField.getText();
        if (surchargeStr.isBlank()) {
            surchargeTextField.setText("0");
            shift.setSurcharge(0);
            return;
        }
        if (!ValidateInput.checkIfAValidNumberForGUI(surchargeStr)) {
            insertWarningToTextField(surchargeTextField, INVALID_WARNING, 14);
            checkSurcharge = false;
            return;
        }
        checkSurcharge = true;
        surchargeTextField.setText(String.format("%d", shift.getSurcharge()));
    }//GEN-LAST:event_surchargeTextFieldMouseExited

    private void surchargeTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_surchargeTextFieldMouseClicked
        if (!checkSurcharge) {
            setDefaultOptionToTextField(surchargeTextField, 14);
        }
    }//GEN-LAST:event_surchargeTextFieldMouseClicked

    private void fromHourTextFieldMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fromHourTextFieldMouseExited
        if (!fromHourTextField.isEnabled()) {
            return;
        }
        String text = fromHourTextField.getText();
        if (!ValidateInput.checkIfValidHours(text)) {
            fromHourTextField.setText("00");
        }
    }//GEN-LAST:event_fromHourTextFieldMouseExited

    private void fromMinuteTextFieldMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fromMinuteTextFieldMouseExited
        if (!fromMinuteTextField.isEnabled()) {
            return;
        }
        String text = fromMinuteTextField.getText();
        if (!ValidateInput.checkIfValidMinute(text)) {
            fromMinuteTextField.setText("00");
        }
    }//GEN-LAST:event_fromMinuteTextFieldMouseExited

    private void toHourTextFieldMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toHourTextFieldMouseExited
        if (!toHourTextField.isEnabled()) {
            return;
        }
        String text = toHourTextField.getText();
        if (!ValidateInput.checkIfValidHours(text)) {
            toHourTextField.setText("00");
        }
    }//GEN-LAST:event_toHourTextFieldMouseExited

    private void toMinuteTextFieldMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toMinuteTextFieldMouseExited
        if (!toMinuteTextField.isEnabled()) {
            return;
        }
        String text = toMinuteTextField.getText();
        if (!ValidateInput.checkIfValidMinute(text)) {
            toMinuteTextField.setText("00");
        }
    }//GEN-LAST:event_toMinuteTextFieldMouseExited

    private void fromHourTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fromHourTextFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String text = fromHourTextField.getText();
            if (!ValidateInput.checkIfValidHours(text)) {
                fromHourTextField.setText("00");
            } else {
                fromMinuteTextField.requestFocus();
            }
        }
    }//GEN-LAST:event_fromHourTextFieldKeyPressed

    private void fromMinuteTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fromMinuteTextFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String text = fromMinuteTextField.getText();
            if (!ValidateInput.checkIfValidMinute(text)) {
                fromMinuteTextField.setText("00");
            }
        }
    }//GEN-LAST:event_fromMinuteTextFieldKeyPressed

    private void toHourTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_toHourTextFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String text = toHourTextField.getText();
            if (!ValidateInput.checkIfValidHours(text)) {
                toHourTextField.setText("00");
            } else {
                toMinuteTextField.requestFocus();
            }
        }
    }//GEN-LAST:event_toHourTextFieldKeyPressed

    private void toMinuteTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_toMinuteTextFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String text = toMinuteTextField.getText();
            if (!ValidateInput.checkIfValidMinute(text)) {
                toMinuteTextField.setText("00");
            }
        }
    }//GEN-LAST:event_toMinuteTextFieldKeyPressed

    private void orderTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_orderTableMouseClicked
        int selectedRow = orderTable.getSelectedRow();
        if (selectedRow != -1) {
            UUID invoiceId = UUID.fromString(orderTable.getValueAt(selectedRow, 0).toString());
            Invoice invoice = invoiceDAO.getInvoice(invoiceId, this.hibernateConfig.getEntityManager());

            displayOrderDetail(invoice);
            orderIDTextField.setText(invoice.getInvoiceId().toString());
            orderDateTextField.setText(FormatOutput.convertLocalDateTimeToString(invoice.getCreatedAt()));
        }
    }//GEN-LAST:event_orderTableMouseClicked

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        this.searchingInvoiceId = null;
        this.filterDate = null;
        this.filterDateTimeFrom = null;
        this.filterDateTimeTo = null;
        refreshCurrentShiftView();
    }//GEN-LAST:event_refreshBtnActionPerformed

    private void popupOpenShiftFrame() {
        openShiftFrame = new OpenShiftFrame();
        openShiftFrame.setVisible(true);
        openShiftFrame.setup(this.hibernateConfig, store, shift, this);
        openShiftFrame.setToCurrentShiftValue();
    }

    private void refreshEmployeesCombobox() {
        shiftEmployeeListComboBox.removeAllItems();
        this.shift.getEmployees().stream().forEach(
                e -> shiftEmployeeListComboBox.addItem(e.getEmployeeName()));
        if (shiftEmployeeListComboBox.getItemCount() > 0) {
            shiftEmployeeListComboBox.setSelectedIndex(0);
        } else {
            shiftEmployeeListComboBox.setSelectedIndex(-1);
        }
    }

    private void setDefaultOptionToTextField(JTextField textField, int size) {
        textField.setFont(new java.awt.Font("Segoe UI", 0, size));
        textField.setForeground(new java.awt.Color(0, 0, 0));
        textField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textField.setText("");
    }

    private void setDeafaultToSearchPanel() {
        orderIDTextField.setText("");
        orderDateTextField.setText("");
        fromHourTextField.setText("00");
        fromMinuteTextField.setText("00");
        toHourTextField.setText("00");
        toMinuteTextField.setText("00");
    }

    private void setDeafaultToCurrentShiftOverViewPanel() {
        tb.setTitle(null);
        openBalanceTextField.setText("");
        shiftCashierTextField.setText("");
        shiftEmployeeListComboBox.removeAllItems();
        surchargeTextField.setText("");
        numberOfOrderTextField.setText("");
        netRevenueTextField.setText("");
        grossRevenueTextField.setText("");
    }

    private void setDefaultToAllComponents() {
        setDeafaultToCurrentShiftOverViewPanel();
        setDeafaultToSearchPanel();
        refreshOrderTable();
        orderDetailTableModel.setRowCount(0);
    }

    private void insertWarningToTextField(JTextField textField, String warningText, int size) {
        textField.setFont(new java.awt.Font("Segoe UI", 2, size)); // NOI18N
        textField.setForeground(new java.awt.Color(255, 0, 0));
        textField.setText(warningText);
        textField.setEditable(false);
    }

    private void displayOrderDetail(Invoice invoice) {
        orderDetailTableModel.setRowCount(0);

        invoice.getInvoiceProducts().stream().forEach(p -> {
            orderDetailTableModel.addRow(new Object[]{
                p.getProductCode(),
                p.getProductName(),
                p.getUnit(),
                p.getPrice(),
                p.getShipmentId(),
                p.getQuantity()
            });
        });
    }

    private void refreshOrderTable() { //TO DO
        orderTableModel.setRowCount(0);

        this.shift.getInvoices().stream().forEach(i -> {
            if (this.searchingInvoiceId != null 
                    && !i.getInvoiceId()
                    .toString()
                    .contains(this.searchingInvoiceId)) return;
//            if(this.filterDate != null
//                    && i.getCreatedAt().is)
            
            orderTableModel.addRow(new Object[]{
                i.getInvoiceId(),
                FormatOutput.convertLocalDateTimeToString(i.getCreatedAt()),
                InvoiceUtil.getTotal(i),});
        }
        );
    }

    private void setEnableComponentsInSearchPanel(boolean enable) {
        orderIDLabel.setEnabled(enable);
        orderIDTextField.setEnabled(enable);
        orderDateLabel.setEnabled(enable);
        orderDateTextField.setEnabled(enable);
        fromLabel.setEnabled(enable);
        fromHourTextField.setEnabled(enable);
        fromMinuteTextField.setEnabled(enable);
        toLabel.setEnabled(enable);
        toHourTextField.setEnabled(enable);
        toMinuteTextField.setEnabled(enable);
        separatorLabel2.setEnabled(enable);
        separatorLabel4.setEnabled(enable);
        searchBtn.setEnabled(enable);
        refreshBtn.setEnabled(enable);
    }

    private void setEnableComponentsInCurrentShiftOverViewPanel(boolean enable) {
        openBalanceLabel.setEnabled(enable);
        openBalanceTextField.setEnabled(enable);
        shiftEmployeeListLabel.setEnabled(enable);
        shiftEmployeeListComboBox.setEnabled(enable);
        shiftCashierTextField.setEnabled(enable);
        shiftCashierLabel.setEnabled(enable);
        surchargeLabel.setEnabled(enable);
        surchargeTextField.setEnabled(enable);
        endShiftBtn.setEnabled(enable);
        editShiftBtn.setEnabled(enable);
        //
        numberOfOrderLabel.setEnabled(enable);
        numberOfOrderTextField.setEnabled(enable);
        grossRevenueLabel.setEnabled(enable);
        grossRevenueTextField.setEnabled(enable);
        netRevenueLabel.setEnabled(enable);
        netRevenueTextField.setEnabled(enable);
    }

    public void setEnableAllComponents(boolean enable) {
        setEnableComponentsInCurrentShiftOverViewPanel(enable);
        setEnableComponentsInSearchPanel(enable);
        orderTable.setEnabled(enable);
        orderDetailTable.setEnabled(enable);
    }

    public void refreshCurrentShiftView() {
        boolean checkOpenShift = this.shift.getState().equals(ShiftState.OPENED);
        setEnableAllComponents(checkOpenShift);
        tb.setTitle((!checkOpenShift) ? "" : "  Mã Ca - " + this.shift.getShiftId());
        if (checkOpenShift) { // nếu đã mở ca thì refresh lại các thông số ca
            //right
            numberOfOrderTextField.setText(String.format("%d", this.shift.getInvoices().size()));
            grossRevenueTextField.setText(ShiftUtil.getGrossRevenue(shift));
            netRevenueTextField.setText(ShiftUtil.getNetRevenue(shift));
            //left
            openBalanceTextField.setText(String.format("%d", shift.getOpeningBalance()));
            shiftCashierTextField.setText(this.shift.getCashierName());
            surchargeTextField.setText(String.format("%d", shift.getSurcharge()));
            refreshEmployeesCombobox();
            refreshOrderTable();
        } else {
            popupOpenShiftFrame();
        }
    }

    public void setup(HibernateConfig hibernateConfig, Store store, Shift shift, MainFrame mainFrame) {
        this.store = store;
        this.shift = shift;
        this.mf = mainFrame;
        this.hibernateConfig = hibernateConfig;
        this.shiftDAO = new ShiftDAOImpl();
        this.invoiceDAO = new InvoiceDAOImpl();

        //table
        orderListJScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        orderListJScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        orderTableModel = (DefaultTableModel) orderTable.getModel();
        orderDetailJScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        orderDetailJScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        orderDetailTableModel = (DefaultTableModel) orderDetailTable.getModel();
    }

    private String searchingInvoiceId;
    private LocalDateTime filterDate;
    private LocalDateTime filterDateTimeFrom;
    private LocalDateTime filterDateTimeTo;
    private ShiftDAO shiftDAO;
    private InvoiceDAO invoiceDAO;
    private HibernateConfig hibernateConfig;
    private Store store;
    private Shift shift;
    private MainFrame mf;
    private OpenShiftFrame openShiftFrame;
    private DefaultTableModel orderDetailTableModel;
    private DefaultTableModel orderTableModel;

    private TitledBorder tb;
    private boolean checkSurcharge = false;

    private final String INVALID_WARNING = "Không hợp lệ!";
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel currentShiftOverViewPanel;
    private javax.swing.JButton editShiftBtn;
    private javax.swing.JButton endShiftBtn;
    private javax.swing.JTextField fromHourTextField;
    private javax.swing.JLabel fromLabel;
    private javax.swing.JTextField fromMinuteTextField;
    private javax.swing.JLabel grossRevenueLabel;
    private javax.swing.JTextField grossRevenueTextField;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel netRevenueLabel;
    private javax.swing.JTextField netRevenueTextField;
    private javax.swing.JLabel numberOfOrderLabel;
    private javax.swing.JTextField numberOfOrderTextField;
    private javax.swing.JLabel openBalanceLabel;
    private javax.swing.JTextField openBalanceTextField;
    private javax.swing.JLabel orderDateLabel;
    private javax.swing.JTextField orderDateTextField;
    private javax.swing.JScrollPane orderDetailJScrollPane;
    private javax.swing.JTable orderDetailTable;
    private javax.swing.JLabel orderIDLabel;
    private javax.swing.JTextField orderIDTextField;
    private javax.swing.JScrollPane orderListJScrollPane;
    private javax.swing.JTable orderTable;
    private javax.swing.JPanel ordersAndShipsHistoryPanel;
    private javax.swing.JPanel otherFunctionPanel;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JPanel searchAndTablePanel;
    private javax.swing.JButton searchBtn;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JLabel separatorLabel2;
    private javax.swing.JLabel separatorLabel4;
    private javax.swing.JLabel shiftCashierLabel;
    private javax.swing.JTextField shiftCashierTextField;
    private javax.swing.JComboBox<String> shiftEmployeeListComboBox;
    private javax.swing.JLabel shiftEmployeeListLabel;
    private javax.swing.JLabel surchargeLabel;
    private javax.swing.JTextField surchargeTextField;
    private javax.swing.JTextField toHourTextField;
    private javax.swing.JLabel toLabel;
    private javax.swing.JTextField toMinuteTextField;
    // End of variables declaration//GEN-END:variables
}
