package view;

import config.HibernateConfig;
import dao.InvoiceDAO;
import dao.ShiftDAO;
import dao.impl.InvoiceDAOImpl;
import dao.impl.ShiftDAOImpl;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
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
        errorDateLabel.setVisible(false);
        tb = (TitledBorder) currentShiftOverViewPanel.getBorder();
        tb.setTitleFont(new java.awt.Font("Segoe UI", 1, 14));
        tb.setTitleJustification(TitledBorder.DEFAULT_POSITION);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setVerticalTextPosition(SwingConstants.CENTER);
        centerRenderer.setHorizontalTextPosition(SwingConstants.CENTER);
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        centerRenderer.setVerticalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < invoiceTable.getColumnCount(); i++) {
            invoiceTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        JTableHeader header = invoiceTable.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 14));

        for (int i = 0; i < invoiceDetailTable.getColumnCount(); i++) {
            invoiceDetailTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        header = invoiceDetailTable.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 14));
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
        errorDateLabel = new javax.swing.JLabel();
        orderListJScrollPane = new javax.swing.JScrollPane();
        invoiceTable = new javax.swing.JTable();
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
        invoiceDetailTable = new javax.swing.JTable();

        setMinimumSize(new java.awt.Dimension(1400, 800));
        setPreferredSize(new java.awt.Dimension(1400, 800));
        setLayout(new java.awt.BorderLayout(10, 0));

        ordersAndShipsHistoryPanel.setPreferredSize(new java.awt.Dimension(450, 595));
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
        fromHourTextField.setMaximumSize(new java.awt.Dimension(64, 26));
        fromHourTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fromHourTextFieldKeyReleased(evt);
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
        fromMinuteTextField.setMaximumSize(new java.awt.Dimension(64, 26));
        fromMinuteTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fromMinuteTextFieldKeyReleased(evt);
            }
        });

        separatorLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        separatorLabel4.setText(":");

        toHourTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        toHourTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        toHourTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                toHourTextFieldKeyReleased(evt);
            }
        });

        toMinuteTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        toMinuteTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        toMinuteTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                toMinuteTextFieldKeyReleased(evt);
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

        errorDateLabel.setForeground(new java.awt.Color(255, 51, 51));
        errorDateLabel.setText("Thời gian không hợp lệ!");

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, searchPanelLayout.createSequentialGroup()
                        .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(orderDateLabel)
                            .addComponent(orderIDLabel))
                        .addGap(21, 21, 21)
                        .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(orderIDTextField)
                            .addComponent(orderDateTextField)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, searchPanelLayout.createSequentialGroup()
                        .addComponent(fromLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(searchPanelLayout.createSequentialGroup()
                                .addComponent(errorDateLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(searchPanelLayout.createSequentialGroup()
                                .addComponent(fromHourTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(separatorLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fromMinuteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(toLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(toHourTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(separatorLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(toMinuteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(refreshBtn)
                .addGap(15, 15, 15))
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchPanelLayout.createSequentialGroup()
                        .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(orderIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(orderIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(orderDateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                            .addComponent(orderDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(fromLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(fromHourTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(separatorLabel4)
                                .addComponent(fromMinuteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(separatorLabel2)
                                .addComponent(toMinuteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(toHourTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(toLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(errorDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(refreshBtn)))
                .addGap(19, 19, 19))
        );

        searchAndTablePanel.add(searchPanel, java.awt.BorderLayout.PAGE_START);

        invoiceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã HĐ", "Thời gian lập HĐ", "Tổng tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        invoiceTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        invoiceTable.setShowGrid(true);
        invoiceTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                invoiceTableMouseClicked(evt);
            }
        });
        orderListJScrollPane.setViewportView(invoiceTable);

        searchAndTablePanel.add(orderListJScrollPane, java.awt.BorderLayout.CENTER);

        ordersAndShipsHistoryPanel.add(searchAndTablePanel, java.awt.BorderLayout.CENTER);

        add(ordersAndShipsHistoryPanel, java.awt.BorderLayout.LINE_START);

        otherFunctionPanel.setPreferredSize(new java.awt.Dimension(550, 646));
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
                    .addComponent(surchargeLabel)
                    .addComponent(shiftEmployeeListLabel)
                    .addComponent(shiftCashierLabel)
                    .addComponent(openBalanceLabel))
                .addGap(25, 25, 25)
                .addGroup(currentShiftOverViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(currentShiftOverViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(currentShiftOverViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(shiftEmployeeListComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, 249, Short.MAX_VALUE)
                            .addComponent(shiftCashierTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(openBalanceTextField, javax.swing.GroupLayout.Alignment.LEADING))
                        .addComponent(surchargeTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(currentShiftOverViewPanelLayout.createSequentialGroup()
                        .addComponent(editShiftBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(endShiftBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(currentShiftOverViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(numberOfOrderLabel)
                    .addGroup(currentShiftOverViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(grossRevenueLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(netRevenueLabel)))
                .addGap(18, 18, 18)
                .addGroup(currentShiftOverViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(grossRevenueTextField)
                    .addComponent(numberOfOrderTextField)
                    .addComponent(netRevenueTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        currentShiftOverViewPanelLayout.setVerticalGroup(
            currentShiftOverViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(currentShiftOverViewPanelLayout.createSequentialGroup()
                .addGroup(currentShiftOverViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(currentShiftOverViewPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(currentShiftOverViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(openBalanceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
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
                    .addComponent(jSeparator2)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        otherFunctionPanel.add(currentShiftOverViewPanel, java.awt.BorderLayout.PAGE_START);

        invoiceDetailTable.setModel(new javax.swing.table.DefaultTableModel(
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
        invoiceDetailTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        invoiceDetailTable.setShowGrid(true);
        orderDetailJScrollPane.setViewportView(invoiceDetailTable);

        otherFunctionPanel.add(orderDetailJScrollPane, java.awt.BorderLayout.CENTER);

        add(otherFunctionPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void endShiftBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endShiftBtnActionPerformed
        String surcharge = surchargeTextField.getText().trim();
        if (!ValidateInput.isAPositiveInteger(surcharge)) {
            JOptionPane.showMessageDialog(this, "Khoản chi tiêu không hợp lệ!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        int choice = JOptionPane.showConfirmDialog(this, "Bạn muốn đóng ca?", "Thông báo", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (choice == JOptionPane.YES_OPTION) {
            this.shift.setSurcharge(Integer.valueOf(surcharge));
            boolean result = shiftDAO.closeShift(this.shift, this.hibernateConfig.getEntityManager());
            if (!result) {
                JOptionPane.showMessageDialog(this, "Đóng ca thất bại!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            choice = JOptionPane.showConfirmDialog(this, "In báo cáo tổng kết cuối ca?",
                    "Đóng ca hoàn tất", JOptionPane.OK_CANCEL_OPTION);

            if (choice == JOptionPane.OK_OPTION) {
                PrinterUtil.exportShiftToTxtFile(store, shift);
            }
            this.shift = null;
            mf.switchShiftPanel();
            setDefaultToAllComponents();
        }
    }//GEN-LAST:event_endShiftBtnActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        String orderDate = orderDateTextField.getText().trim();
        String hourFrom = fromHourTextField.getText().trim();
        String minuteFrom = fromMinuteTextField.getText().trim();
        String hourTo = toHourTextField.getText().trim();
        String minuteTo = toMinuteTextField.getText().trim();

        if (!orderDate.isBlank()) {
            filterDate = FormatOutput.convertStringToLocalDateTime(orderDate);
            if (filterDate == null) {
                errorDateLabel.setVisible(true);
                return;
            }
        } else {
            filterDate = null;
        }

        if (!hourFrom.isBlank() || !minuteFrom.isBlank()
                || !hourTo.isBlank() || !minuteTo.isBlank()) {

            filterDate = FormatOutput.convertStringToLocalDateTime(orderDate);
            if (filterDate == null) {
                errorDateLabel.setVisible(true);
                return;
            }

            String orderTimeFrom = hourFrom + ":" + minuteFrom;
            filterDateTimeFrom = FormatOutput.convertStringToLocalDateTime(orderDate, orderTimeFrom);
            if (filterDateTimeFrom == null) {
                errorDateLabel.setVisible(true);
                return;
            }

            String orderTimeTo = hourTo + ":" + minuteTo;
            filterDateTimeTo = FormatOutput.convertStringToLocalDateTime(orderDate, orderTimeTo);
            if (filterDateTimeTo == null) {
                errorDateLabel.setVisible(true);
                return;
            }
        } else {
            filterDateTimeFrom = null;
            filterDateTimeTo = null;
        }

        errorDateLabel.setVisible(false);
        refreshOrderTable();
    }//GEN-LAST:event_searchBtnActionPerformed

    private void editShiftBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editShiftBtnActionPerformed
        popupOpenShiftFrame();
        openShiftFrame.setToUpdateMode();
    }//GEN-LAST:event_editShiftBtnActionPerformed

    private void invoiceTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invoiceTableMouseClicked
        int selectedRow = invoiceTable.getSelectedRow();
        if (selectedRow != -1) {
            Long invoiceId = Long.valueOf(invoiceTable.getValueAt(selectedRow, 0).toString());
            Invoice invoice = invoiceDAO.getInvoice(invoiceId, this.hibernateConfig.getEntityManager());

            displayOrderDetail(invoice);
            orderIDTextField.setText(invoice.getInvoiceId().toString());
            orderDateTextField.setText(FormatOutput.convertLocalDateToString(invoice.getCreatedAt().toLocalDate()));
        }
    }//GEN-LAST:event_invoiceTableMouseClicked

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        this.filterDate = null;
        this.filterDateTimeFrom = null;
        this.filterDateTimeTo = null;
        setDefaultToAllComponents();
        refreshView(this.shift);
    }//GEN-LAST:event_refreshBtnActionPerformed

    private void fromHourTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fromHourTextFieldKeyReleased
        fromHour = timeCheck(fromHourTextField, fromMinuteTextField, fromHour, 2);
    }//GEN-LAST:event_fromHourTextFieldKeyReleased

    private void fromMinuteTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fromMinuteTextFieldKeyReleased
        fromMinute = timeCheck(fromMinuteTextField, toHourTextField, fromMinute, 2);
    }//GEN-LAST:event_fromMinuteTextFieldKeyReleased

    private void toHourTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_toHourTextFieldKeyReleased
        toHour = timeCheck(toHourTextField, toMinuteTextField, toHour, 2);
    }//GEN-LAST:event_toHourTextFieldKeyReleased

    private void toMinuteTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_toMinuteTextFieldKeyReleased
        toMinute = timeCheck(toMinuteTextField, searchBtn, toMinute, 2);
    }//GEN-LAST:event_toMinuteTextFieldKeyReleased

    private String timeCheck(JTextField textField, Component nextField, String time, int maxLength) {
        if (textField.getText().isBlank()) {
            errorDateLabel.setVisible(false);
            return "";
        }
        String currentText;
        if ((currentText = textField.getText()).length() > maxLength) {
            textField.setText(currentText.substring(0, maxLength));
        }
        try {
            Integer.valueOf(textField.getText());
            time = textField.getText();
            errorDateLabel.setVisible(false);
        } catch (NumberFormatException nfe) {
            errorDateLabel.setVisible(true);
        }
        if (textField.getText().length() == maxLength) {
            nextField.requestFocusInWindow();
        }
        return time;
    }

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

    private void setDeafaultToSearchPanel() {
        orderIDTextField.setText("");
        orderDateTextField.setText("");
        fromHourTextField.setText("");
        fromMinuteTextField.setText("");
        toHourTextField.setText("");
        toMinuteTextField.setText("");
        errorDateLabel.setVisible(false);
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

    private void displayOrderDetail(Invoice invoice) {
        orderDetailTableModel.setRowCount(0);

        invoice.getInvoiceProducts().stream().forEach(p -> {
            orderDetailTableModel.addRow(new Object[]{
                p.getProductCode(),
                p.getProductName(),
                p.getUnit(),
                FormatOutput.formatToMoneyAmountForm(p.getPrice() + ""),
                p.getShipmentId(),
                p.getQuantity()
            });
        });
    }

    private boolean isInvoiceStatisfyFilter(Invoice invoice) {
        String invoiceID = orderIDTextField.getText().trim();
        if (!invoiceID.isBlank()
                && !String.valueOf(invoice.getInvoiceId()).equals(invoiceID)) {
            return false;
        }

        if (filterDate != null
                && !invoice.getCreatedAt().toLocalDate().isEqual(filterDate.toLocalDate())) {
            return false;
        }

        if (filterDateTimeFrom != null && filterDateTimeTo != null) {
            if (invoice.getCreatedAt().isAfter(filterDateTimeTo)
                    || invoice.getCreatedAt().isBefore(filterDateTimeFrom)) {
                return false;
            }
        }

        return true;
    }

    private void refreshOrderTable() { //TO DO
        orderTableModel.setRowCount(0);

        this.shift.getInvoices().stream().forEach(i -> {
            if (!isInvoiceStatisfyFilter(i)) {
                return;
            }

            orderTableModel.addRow(new Object[]{
                i.getInvoiceId(),
                FormatOutput.convertLocalDateTimeToString(i.getCreatedAt()),
                FormatOutput.formatToMoneyAmountForm(InvoiceUtil.getTotal(i))
            });
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
        invoiceTable.setEnabled(enable);
        invoiceDetailTable.setEnabled(enable);
    }

    public void refreshView(Shift shift) {
        if (this.shift == null || !shift.getShiftId().equals(this.shift.getShiftId())) {
            this.shift = shift;
        }
        boolean checkOpenShift = this.shift.getState().equals(ShiftState.OPENED);
        setEnableAllComponents(checkOpenShift);
        tb.setTitle((!checkOpenShift) ? "" : "  Mã Ca - " + this.shift.getShiftId());
        if (checkOpenShift) { // nếu đã mở ca thì refresh lại các thông số ca
            //right
            numberOfOrderTextField.setText(String.format("%d", this.shift.getInvoices().size()));
            grossRevenueTextField.setText(FormatOutput.formatToMoneyAmountForm(ShiftUtil.getGrossRevenue(shift)));
            netRevenueTextField.setText(FormatOutput.formatToMoneyAmountForm(ShiftUtil.getNetRevenue(shift)));
            //left
            openBalanceTextField.setText(FormatOutput.formatToMoneyAmountForm(shift.getOpeningBalance() + ""));
            shiftCashierTextField.setText(this.shift.getCashierName());
            surchargeTextField.setText(String.format("%d", shift.getSurcharge()));
            refreshEmployeesCombobox();
            refreshOrderTable();
        } else {
            popupOpenShiftFrame();
            openShiftFrame.setToAddMode();
        }
    }

    public void setup(HibernateConfig hibernateConfig, Store store, MainFrame mainFrame) {
        this.store = store;
        this.mf = mainFrame;
        this.hibernateConfig = hibernateConfig;
        this.shiftDAO = new ShiftDAOImpl();
        this.invoiceDAO = new InvoiceDAOImpl();

        //table
        orderListJScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        orderListJScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        orderTableModel = (DefaultTableModel) invoiceTable.getModel();
        orderDetailJScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        orderDetailJScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        orderDetailTableModel = (DefaultTableModel) invoiceDetailTable.getModel();
    }

    private LocalDateTime filterDate;
    private LocalDateTime filterDateTimeFrom;
    private LocalDateTime filterDateTimeTo;
    private String fromHour = "";
    private String fromMinute = "";
    private String toHour = "";
    private String toMinute = "";

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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel currentShiftOverViewPanel;
    private javax.swing.JButton editShiftBtn;
    private javax.swing.JButton endShiftBtn;
    private javax.swing.JLabel errorDateLabel;
    private javax.swing.JTextField fromHourTextField;
    private javax.swing.JLabel fromLabel;
    private javax.swing.JTextField fromMinuteTextField;
    private javax.swing.JLabel grossRevenueLabel;
    private javax.swing.JTextField grossRevenueTextField;
    private javax.swing.JTable invoiceDetailTable;
    private javax.swing.JTable invoiceTable;
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
    private javax.swing.JLabel orderIDLabel;
    private javax.swing.JTextField orderIDTextField;
    private javax.swing.JScrollPane orderListJScrollPane;
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
