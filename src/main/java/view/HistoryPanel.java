package view;

import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import config.HibernateConfig;
import dao.InvoiceDAO;
import dao.impl.InvoiceDAOImpl;
import java.awt.Component;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import model.ComboBoxItem;
import model.ImportedProduct;
import model.StaticalProduct;
import model.entities.Invoice;
import model.entities.InvoiceProduct;
import model.entities.Product;
import model.entities.Store;
import util.FormatOutput;
import util.InvoiceUtil;
import util.PrinterUtil;
import util.ProductUtil;

public class HistoryPanel extends javax.swing.JPanel {

    public HistoryPanel() {
        initComponents();
        customUI();
    }

    public final void customUI() {
        errorDateLabel.setVisible(false);
        importErrorDateLabel.setVisible(false);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setVerticalTextPosition(SwingConstants.CENTER);
        centerRenderer.setHorizontalTextPosition(SwingConstants.CENTER);
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        centerRenderer.setVerticalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < invoiceHistoryTable.getColumnCount(); i++) {
            invoiceHistoryTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        JTableHeader header = invoiceHistoryTable.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 14));

        for (int i = 0; i < invoiceDetailTable.getColumnCount(); i++) {
            invoiceDetailTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        header = invoiceDetailTable.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 14));

        for (int i = 0; i < productReportTable.getColumnCount(); i++) {
            productReportTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        header = productReportTable.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 14));

        for (int i = 0; i < importDetailTable.getColumnCount(); i++) {
            importDetailTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        header = importDetailTable.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 14));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        historyTabPane = new javax.swing.JTabbedPane();
        orderHistoryPanel = new javax.swing.JPanel();
        searchOrderPanel = new javax.swing.JPanel();
        orderIDToSearchLabel = new javax.swing.JLabel();
        searchOrderIDTextField = new javax.swing.JTextField();
        cashierPhoneNumLable1 = new javax.swing.JLabel();
        fromLabel1 = new javax.swing.JLabel();
        fromDayTextField = new javax.swing.JTextField();
        fromMonthTextField = new javax.swing.JTextField();
        separatorLabel7 = new javax.swing.JLabel();
        separatorLabel8 = new javax.swing.JLabel();
        searchCashierComboBox = new javax.swing.JComboBox<>();
        toLabel2 = new javax.swing.JLabel();
        toDayTextField = new javax.swing.JTextField();
        separatorLabel9 = new javax.swing.JLabel();
        toMonthTextField = new javax.swing.JTextField();
        separatorLabel10 = new javax.swing.JLabel();
        fromYearTextField = new javax.swing.JTextField();
        searchOrderBtn = new javax.swing.JButton();
        toYearTextField = new javax.swing.JTextField();
        refreshBtn = new javax.swing.JButton();
        errorDateLabel = new javax.swing.JLabel();
        orderListPanel = new javax.swing.JPanel();
        amountOfOrderLabel = new javax.swing.JLabel();
        totalProceedsLabel = new javax.swing.JLabel();
        totalInvoiceQuantityLabel = new javax.swing.JLabel();
        totalNetRevenueLabel = new javax.swing.JLabel();
        overViewJScrollPane = new javax.swing.JScrollPane();
        invoiceHistoryTable = new javax.swing.JTable();
        orderDetailPanel = new javax.swing.JPanel();
        orderDetailJScrollPane = new javax.swing.JScrollPane();
        invoiceDetailTable = new javax.swing.JTable();
        reprintBtn = new javax.swing.JButton();
        totalPayment = new javax.swing.JLabel();
        totalPaymentLabel = new javax.swing.JLabel();
        statisticGoodsPanel = new javax.swing.JPanel();
        totalLabel = new javax.swing.JLabel();
        totalReportProcessLabel = new javax.swing.JLabel();
        goodsReportScrollPane = new javax.swing.JScrollPane();
        productReportTable = new javax.swing.JTable();
        printStaticalGoodsToExcelBtn = new javax.swing.JButton();
        importHistoryPanel = new javax.swing.JPanel();
        searchShipmentPanel = new javax.swing.JPanel();
        fromLabel = new javax.swing.JLabel();
        fromImportDayTextField = new javax.swing.JTextField();
        toImportMonthTextField = new javax.swing.JTextField();
        separatorLabel11 = new javax.swing.JLabel();
        fromImportMonthTextField = new javax.swing.JTextField();
        fromImportYearTextField = new javax.swing.JTextField();
        toImportYearTextField = new javax.swing.JTextField();
        separatorLabel12 = new javax.swing.JLabel();
        separatorLabel13 = new javax.swing.JLabel();
        orderDateLabel = new javax.swing.JLabel();
        toLabel = new javax.swing.JLabel();
        toImportDayTextField = new javax.swing.JTextField();
        separatorLabel14 = new javax.swing.JLabel();
        goodsNameLabel = new javax.swing.JLabel();
        searchImportHistoryBtn = new javax.swing.JButton();
        goodsNameTextField = new javax.swing.JTextField();
        refreshImportTableLabel = new javax.swing.JButton();
        importErrorDateLabel = new javax.swing.JLabel();
        displayShipmentPanel = new javax.swing.JPanel();
        importDetailJScrollPane = new javax.swing.JScrollPane();
        importDetailTable = new javax.swing.JTable();
        printImportReportBtn = new javax.swing.JButton();
        staticShipmentsPanel = new javax.swing.JPanel();
        numberOfImportLabel = new javax.swing.JLabel();
        totalOfImportLabel = new javax.swing.JLabel();
        displayNumberOfImportLabel = new javax.swing.JLabel();
        displayTotalOfImportLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1400, 800));
        setPreferredSize(new java.awt.Dimension(1400, 800));

        historyTabPane.setBackground(new java.awt.Color(255, 255, 255));

        orderHistoryPanel.setBackground(new java.awt.Color(255, 255, 255));
        orderHistoryPanel.setMinimumSize(new java.awt.Dimension(960, 0));
        orderHistoryPanel.setPreferredSize(new java.awt.Dimension(978, 554));

        searchOrderPanel.setBackground(new java.awt.Color(255, 255, 255));
        searchOrderPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm Kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        searchOrderPanel.setMaximumSize(new java.awt.Dimension(32767, 214));
        searchOrderPanel.setMinimumSize(new java.awt.Dimension(315, 214));
        searchOrderPanel.setPreferredSize(new java.awt.Dimension(315, 214));
        searchOrderPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        orderIDToSearchLabel.setText("Mã HĐ: ");
        searchOrderPanel.add(orderIDToSearchLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 28, -1, 37));

        searchOrderIDTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        searchOrderPanel.add(searchOrderIDTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 25, 245, 42));

        cashierPhoneNumLable1.setText("Thu Ngân:");
        searchOrderPanel.add(cashierPhoneNumLable1, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 92, -1, 40));

        fromLabel1.setText("Từ:");
        searchOrderPanel.add(fromLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 25, 29, 45));

        fromDayTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fromDayTextField.setText("00");
        fromDayTextField.setMaximumSize(new java.awt.Dimension(64, 26));
        fromDayTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fromDayTextFieldKeyReleased(evt);
            }
        });
        searchOrderPanel.add(fromDayTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, 38, 45));

        fromMonthTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fromMonthTextField.setText("00");
        fromMonthTextField.setMaximumSize(new java.awt.Dimension(64, 26));
        fromMonthTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fromMonthTextFieldKeyReleased(evt);
            }
        });
        searchOrderPanel.add(fromMonthTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 20, 36, 45));

        separatorLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        separatorLabel7.setText("/");
        searchOrderPanel.add(separatorLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, 10, 40));

        separatorLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        separatorLabel8.setText("/");
        searchOrderPanel.add(separatorLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 20, 10, 45));

        searchCashierComboBox.setModel(new DefaultComboBoxModel<>(new ComboBoxItem[] { new ComboBoxItem("Tất cả", "0") }));
        searchCashierComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchCashierComboBoxActionPerformed(evt);
            }
        });
        searchOrderPanel.add(searchCashierComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 91, 245, 43));

        toLabel2.setText("Đến:");
        searchOrderPanel.add(toLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, -1, -1));

        toDayTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        toDayTextField.setText("00");
        toDayTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                toDayTextFieldKeyReleased(evt);
            }
        });
        searchOrderPanel.add(toDayTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 90, 36, 43));

        separatorLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        separatorLabel9.setText(" /");
        searchOrderPanel.add(separatorLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(615, 87, -1, 50));

        toMonthTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        toMonthTextField.setText("00");
        toMonthTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                toMonthTextFieldKeyReleased(evt);
            }
        });
        searchOrderPanel.add(toMonthTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 90, 37, 43));

        separatorLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        separatorLabel10.setText(" /");
        searchOrderPanel.add(separatorLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 90, -1, 46));

        fromYearTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fromYearTextField.setText("2023");
        fromYearTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fromYearTextFieldKeyReleased(evt);
            }
        });
        searchOrderPanel.add(fromYearTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 20, 63, 45));

        searchOrderBtn.setBackground(new java.awt.Color(0, 255, 0));
        searchOrderBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        searchOrderBtn.setText("Tìm Kiếm");
        searchOrderBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchOrderBtnActionPerformed(evt);
            }
        });
        searchOrderPanel.add(searchOrderBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, 125, 43));

        toYearTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        toYearTextField.setText("2023");
        toYearTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                toYearTextFieldKeyReleased(evt);
            }
        });
        searchOrderPanel.add(toYearTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 90, -1, 43));

        refreshBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageIcon/reload (3).png"))); // NOI18N
        refreshBtn.setBorder(null);
        refreshBtn.setContentAreaFilled(false);
        refreshBtn.setFocusable(false);
        refreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBtnActionPerformed(evt);
            }
        });
        searchOrderPanel.add(refreshBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(733, 195, -1, -1));

        errorDateLabel.setForeground(new java.awt.Color(255, 51, 51));
        errorDateLabel.setText("Thời gian không hợp lệ!");
        searchOrderPanel.add(errorDateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 150, -1, 30));

        orderListPanel.setBackground(new java.awt.Color(255, 255, 255));
        orderListPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        amountOfOrderLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        amountOfOrderLabel.setText("Số hóa đơn:");

        totalProceedsLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        totalProceedsLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        totalProceedsLabel.setText("Tổng tiền:");

        totalInvoiceQuantityLabel.setFont(new java.awt.Font("Noto Sans Mono", 2, 15)); // NOI18N
        totalInvoiceQuantityLabel.setForeground(new java.awt.Color(255, 0, 0));
        totalInvoiceQuantityLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        totalInvoiceQuantityLabel.setText(" ");
        totalInvoiceQuantityLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        totalNetRevenueLabel.setFont(new java.awt.Font("Noto Sans Mono", 2, 15)); // NOI18N
        totalNetRevenueLabel.setForeground(new java.awt.Color(255, 0, 0));
        totalNetRevenueLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        totalNetRevenueLabel.setText(" ");

        overViewJScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        invoiceHistoryTable.setModel(new javax.swing.table.DefaultTableModel(
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
        invoiceHistoryTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        invoiceHistoryTable.setShowGrid(true);
        invoiceHistoryTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                invoiceHistoryTableMouseClicked(evt);
            }
        });
        overViewJScrollPane.setViewportView(invoiceHistoryTable);

        javax.swing.GroupLayout orderListPanelLayout = new javax.swing.GroupLayout(orderListPanel);
        orderListPanel.setLayout(orderListPanelLayout);
        orderListPanelLayout.setHorizontalGroup(
            orderListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderListPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(amountOfOrderLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalInvoiceQuantityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(totalProceedsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalNetRevenueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(orderListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(orderListPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(overViewJScrollPane)
                    .addContainerGap()))
        );
        orderListPanelLayout.setVerticalGroup(
            orderListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, orderListPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(orderListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalProceedsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalInvoiceQuantityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(amountOfOrderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalNetRevenueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(orderListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(orderListPanelLayout.createSequentialGroup()
                    .addComponent(overViewJScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 51, Short.MAX_VALUE)))
        );

        orderDetailPanel.setBackground(new java.awt.Color(255, 255, 255));
        orderDetailPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi tiết hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        orderDetailJScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        invoiceDetailTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "ĐVT", "Đơn giá", "Mã lô", "SL hàng", "Tiền hàng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        invoiceDetailTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        invoiceDetailTable.setShowGrid(true);
        orderDetailJScrollPane.setViewportView(invoiceDetailTable);

        reprintBtn.setBackground(new java.awt.Color(153, 255, 255));
        reprintBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageIcon/icons8-print-30.png"))); // NOI18N
        reprintBtn.setText("IN LẠI HĐ");
        reprintBtn.setFocusable(false);
        reprintBtn.setMaximumSize(new java.awt.Dimension(120, 34));
        reprintBtn.setMinimumSize(new java.awt.Dimension(120, 34));
        reprintBtn.setPreferredSize(new java.awt.Dimension(120, 34));
        reprintBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reprintBtnActionPerformed(evt);
            }
        });

        totalPayment.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        totalPayment.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        totalPayment.setText("Tổng thanh toán:");

        totalPaymentLabel.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        totalPaymentLabel.setForeground(new java.awt.Color(255, 0, 0));
        totalPaymentLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        totalPaymentLabel.setText("0.0");
        totalPaymentLabel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout orderDetailPanelLayout = new javax.swing.GroupLayout(orderDetailPanel);
        orderDetailPanel.setLayout(orderDetailPanelLayout);
        orderDetailPanelLayout.setHorizontalGroup(
            orderDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderDetailPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(orderDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(orderDetailJScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(orderDetailPanelLayout.createSequentialGroup()
                        .addComponent(reprintBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(107, 107, 107)
                        .addComponent(totalPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalPaymentLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        orderDetailPanelLayout.setVerticalGroup(
            orderDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderDetailPanelLayout.createSequentialGroup()
                .addComponent(orderDetailJScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(orderDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reprintBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(totalPayment, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(totalPaymentLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        statisticGoodsPanel.setBackground(new java.awt.Color(255, 255, 255));
        statisticGoodsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Báo cáo theo mặt hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        statisticGoodsPanel.setMaximumSize(new java.awt.Dimension(32767, 214));
        statisticGoodsPanel.setMinimumSize(new java.awt.Dimension(661, 214));
        statisticGoodsPanel.setPreferredSize(new java.awt.Dimension(661, 214));

        totalLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        totalLabel.setText("Tổng doanh thu(Gross):");

        totalReportProcessLabel.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        totalReportProcessLabel.setForeground(new java.awt.Color(255, 0, 0));
        totalReportProcessLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        totalReportProcessLabel.setText("0.0 ");
        totalReportProcessLabel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        goodsReportScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        productReportTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Nhà sx", "SL", "Doanh Thu", "Tỉ lệ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        productReportTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        productReportTable.setShowGrid(true);
        goodsReportScrollPane.setViewportView(productReportTable);

        printStaticalGoodsToExcelBtn.setBackground(new java.awt.Color(153, 255, 255));
        printStaticalGoodsToExcelBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageIcon/icons8-excel-30.png"))); // NOI18N
        printStaticalGoodsToExcelBtn.setText("XUẤT FILE EXCEL");
        printStaticalGoodsToExcelBtn.setFocusable(false);
        printStaticalGoodsToExcelBtn.setMaximumSize(new java.awt.Dimension(153, 34));
        printStaticalGoodsToExcelBtn.setMinimumSize(new java.awt.Dimension(153, 34));
        printStaticalGoodsToExcelBtn.setPreferredSize(new java.awt.Dimension(153, 34));
        printStaticalGoodsToExcelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printStaticalGoodsToExcelBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout statisticGoodsPanelLayout = new javax.swing.GroupLayout(statisticGoodsPanel);
        statisticGoodsPanel.setLayout(statisticGoodsPanelLayout);
        statisticGoodsPanelLayout.setHorizontalGroup(
            statisticGoodsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statisticGoodsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(printStaticalGoodsToExcelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(totalLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalReportProcessLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(statisticGoodsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(statisticGoodsPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(goodsReportScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(50, Short.MAX_VALUE)))
        );
        statisticGoodsPanelLayout.setVerticalGroup(
            statisticGoodsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statisticGoodsPanelLayout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addGroup(statisticGoodsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalReportProcessLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(totalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(printStaticalGoodsToExcelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(statisticGoodsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(statisticGoodsPanelLayout.createSequentialGroup()
                    .addComponent(goodsReportScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 49, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout orderHistoryPanelLayout = new javax.swing.GroupLayout(orderHistoryPanel);
        orderHistoryPanel.setLayout(orderHistoryPanelLayout);
        orderHistoryPanelLayout.setHorizontalGroup(
            orderHistoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderHistoryPanelLayout.createSequentialGroup()
                .addGroup(orderHistoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(orderListPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchOrderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(orderHistoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(orderDetailPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statisticGoodsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(3, 3, 3))
        );
        orderHistoryPanelLayout.setVerticalGroup(
            orderHistoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderHistoryPanelLayout.createSequentialGroup()
                .addGroup(orderHistoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(statisticGoodsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                    .addComponent(searchOrderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(orderHistoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(orderListPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(orderDetailPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        historyTabPane.addTab("Lịch sử bán hàng", orderHistoryPanel);

        importHistoryPanel.setBackground(new java.awt.Color(255, 255, 255));
        importHistoryPanel.setMinimumSize(new java.awt.Dimension(982, 558));
        importHistoryPanel.setPreferredSize(new java.awt.Dimension(982, 558));

        searchShipmentPanel.setBackground(new java.awt.Color(255, 255, 255));
        searchShipmentPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        fromLabel.setText("Từ:");

        fromImportDayTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fromImportDayTextField.setMaximumSize(new java.awt.Dimension(64, 26));
        fromImportDayTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fromImportDayTextFieldKeyReleased(evt);
            }
        });

        toImportMonthTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        toImportMonthTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                toImportMonthTextFieldKeyReleased(evt);
            }
        });

        separatorLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        separatorLabel11.setText("/");

        fromImportMonthTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fromImportMonthTextField.setMaximumSize(new java.awt.Dimension(64, 26));
        fromImportMonthTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fromImportMonthTextFieldKeyReleased(evt);
            }
        });

        fromImportYearTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fromImportYearTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fromImportYearTextFieldKeyReleased(evt);
            }
        });

        toImportYearTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        toImportYearTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                toImportYearTextFieldKeyReleased(evt);
            }
        });

        separatorLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        separatorLabel12.setText("/");

        separatorLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        separatorLabel13.setText("/");

        orderDateLabel.setText("Ngày nhập:");

        toLabel.setText("Đến:");

        toImportDayTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        toImportDayTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                toImportDayTextFieldKeyReleased(evt);
            }
        });

        separatorLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        separatorLabel14.setText("/");

        goodsNameLabel.setText("Tên mặt hàng:");

        searchImportHistoryBtn.setBackground(new java.awt.Color(0, 255, 0));
        searchImportHistoryBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        searchImportHistoryBtn.setText("Tìm Kiếm");
        searchImportHistoryBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchImportHistoryBtnActionPerformed(evt);
            }
        });

        goodsNameTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        refreshImportTableLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageIcon/reload (3).png"))); // NOI18N
        refreshImportTableLabel.setBorder(null);
        refreshImportTableLabel.setContentAreaFilled(false);
        refreshImportTableLabel.setFocusable(false);
        refreshImportTableLabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshImportTableLabelActionPerformed(evt);
            }
        });

        importErrorDateLabel.setForeground(new java.awt.Color(255, 51, 51));
        importErrorDateLabel.setText("Thời gian không hợp lệ!");

        javax.swing.GroupLayout searchShipmentPanelLayout = new javax.swing.GroupLayout(searchShipmentPanel);
        searchShipmentPanel.setLayout(searchShipmentPanelLayout);
        searchShipmentPanelLayout.setHorizontalGroup(
            searchShipmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchShipmentPanelLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(searchShipmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(searchShipmentPanelLayout.createSequentialGroup()
                        .addComponent(orderDateLabel)
                        .addGap(38, 38, 38)
                        .addComponent(fromLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fromImportDayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(separatorLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fromImportMonthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(separatorLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fromImportYearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, searchShipmentPanelLayout.createSequentialGroup()
                        .addComponent(goodsNameLabel)
                        .addGap(18, 18, 18)
                        .addComponent(goodsNameTextField)))
                .addGroup(searchShipmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchShipmentPanelLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(toLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(toImportDayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(separatorLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(toImportMonthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(separatorLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(toImportYearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                        .addComponent(searchImportHistoryBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(refreshImportTableLabel)
                        .addContainerGap())
                    .addGroup(searchShipmentPanelLayout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(importErrorDateLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        searchShipmentPanelLayout.setVerticalGroup(
            searchShipmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchShipmentPanelLayout.createSequentialGroup()
                .addGroup(searchShipmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchShipmentPanelLayout.createSequentialGroup()
                        .addGroup(searchShipmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(searchShipmentPanelLayout.createSequentialGroup()
                                .addGroup(searchShipmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(goodsNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(goodsNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchShipmentPanelLayout.createSequentialGroup()
                                .addComponent(importErrorDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(searchShipmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(searchShipmentPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(searchShipmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fromImportYearTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fromImportMonthTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(searchShipmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(orderDateLabel)
                                        .addComponent(fromLabel)
                                        .addComponent(fromImportDayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(separatorLabel12)
                                        .addComponent(separatorLabel13))))
                            .addComponent(searchImportHistoryBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(searchShipmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(toImportYearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(separatorLabel11)
                                .addComponent(toImportMonthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(separatorLabel14)
                                .addComponent(toImportDayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(toLabel))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchShipmentPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(refreshImportTableLabel)))
                .addContainerGap())
        );

        displayShipmentPanel.setBackground(new java.awt.Color(255, 255, 255));
        displayShipmentPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Báo cáo chi tiết", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        importDetailTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Nhà sản xuất", "Ngày nhập", "ĐVT", "Mã lô", "Giá nhập", "SL", "Tiền hàng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        importDetailTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        importDetailTable.setShowGrid(true);
        importDetailJScrollPane.setViewportView(importDetailTable);

        printImportReportBtn.setBackground(new java.awt.Color(153, 255, 255));
        printImportReportBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageIcon/icons8-excel-30.png"))); // NOI18N
        printImportReportBtn.setText("XUẤT FILE EXCEL");
        printImportReportBtn.setFocusable(false);
        printImportReportBtn.setMaximumSize(new java.awt.Dimension(153, 34));
        printImportReportBtn.setMinimumSize(new java.awt.Dimension(153, 34));
        printImportReportBtn.setPreferredSize(new java.awt.Dimension(153, 34));
        printImportReportBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printImportReportBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout displayShipmentPanelLayout = new javax.swing.GroupLayout(displayShipmentPanel);
        displayShipmentPanel.setLayout(displayShipmentPanelLayout);
        displayShipmentPanelLayout.setHorizontalGroup(
            displayShipmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(importDetailJScrollPane)
            .addGroup(displayShipmentPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(printImportReportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        displayShipmentPanelLayout.setVerticalGroup(
            displayShipmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displayShipmentPanelLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(importDetailJScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(printImportReportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        staticShipmentsPanel.setBackground(new java.awt.Color(255, 255, 255));
        staticShipmentsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Báo cáo chung", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        numberOfImportLabel.setText("Số lần nhập hàng:");

        totalOfImportLabel.setText("Tổng tiền hàng:");

        displayNumberOfImportLabel.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        displayNumberOfImportLabel.setForeground(new java.awt.Color(255, 0, 0));
        displayNumberOfImportLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        displayNumberOfImportLabel.setText("0");

        displayTotalOfImportLabel.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        displayTotalOfImportLabel.setForeground(new java.awt.Color(255, 0, 0));
        displayTotalOfImportLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        displayTotalOfImportLabel.setText("0");

        javax.swing.GroupLayout staticShipmentsPanelLayout = new javax.swing.GroupLayout(staticShipmentsPanel);
        staticShipmentsPanel.setLayout(staticShipmentsPanelLayout);
        staticShipmentsPanelLayout.setHorizontalGroup(
            staticShipmentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(staticShipmentsPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(staticShipmentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(totalOfImportLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(numberOfImportLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(staticShipmentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(displayNumberOfImportLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(displayTotalOfImportLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        staticShipmentsPanelLayout.setVerticalGroup(
            staticShipmentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(staticShipmentsPanelLayout.createSequentialGroup()
                .addGroup(staticShipmentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(staticShipmentsPanelLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(displayNumberOfImportLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(staticShipmentsPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(numberOfImportLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(staticShipmentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalOfImportLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(displayTotalOfImportLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout importHistoryPanelLayout = new javax.swing.GroupLayout(importHistoryPanel);
        importHistoryPanel.setLayout(importHistoryPanelLayout);
        importHistoryPanelLayout.setHorizontalGroup(
            importHistoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(importHistoryPanelLayout.createSequentialGroup()
                .addGroup(importHistoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(importHistoryPanelLayout.createSequentialGroup()
                        .addComponent(searchShipmentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(staticShipmentsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(displayShipmentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        importHistoryPanelLayout.setVerticalGroup(
            importHistoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(importHistoryPanelLayout.createSequentialGroup()
                .addGroup(importHistoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(staticShipmentsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(importHistoryPanelLayout.createSequentialGroup()
                        .addComponent(searchShipmentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(displayShipmentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        historyTabPane.addTab("Lịch sử nhập hàng", importHistoryPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(historyTabPane))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(historyTabPane, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void reprintBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reprintBtnActionPerformed
        int selectedRow = invoiceHistoryTable.getSelectedRow();
        if (selectedRow == -1 || this.selecetedInvoice == null) {
            JOptionPane.showMessageDialog(this, NOTHING_CHOOSEN_WARNING, "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        PrinterUtil.exportBillToTxtFile(this.selecetedInvoice, this.store);
        JOptionPane.showMessageDialog(this,
                "HĐ: " + this.selecetedInvoice.getInvoiceId() + " in lại thành công!",
                "Thông báo",
                JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_reprintBtnActionPerformed

    private void printImportReportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printImportReportBtnActionPerformed
        try (PrintWriter pw = new PrintWriter(Files.newBufferedWriter(Path.of(IMPORT_GOODS_LIST_FILE),
                StandardOpenOption.CREATE,
                StandardOpenOption.WRITE,
                StandardOpenOption.TRUNCATE_EXISTING), true)) {
            StatefulBeanToCsv<ImportedProduct> writer = new StatefulBeanToCsvBuilder<ImportedProduct>(pw).build();
            pw.println("Ma SP,Ten SP,Nha SX,Ngay nhap,DVT,Ma lo,Gia nhap,SL,Tien hang");
            writer.write(this.importedProducts.values().stream().flatMap(List::stream).collect(Collectors.toList()));
            JOptionPane.showMessageDialog(this,
                    "Xuất File excel thành công!",
                    "Thông báo",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException ex) {
            JOptionPane.showMessageDialog(this, CANNOT_PRINT_TO_EXCEL, "Cảnh báo", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_printImportReportBtnActionPerformed

    private void printStaticalGoodsToExcelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printStaticalGoodsToExcelBtnActionPerformed
        try (PrintWriter pw = new PrintWriter(Files.newBufferedWriter(Path.of(REPORT_GOODS_LIST_FILE),
                StandardOpenOption.CREATE,
                StandardOpenOption.WRITE,
                StandardOpenOption.TRUNCATE_EXISTING), true)) {
            StatefulBeanToCsv<StaticalProduct> writer = new StatefulBeanToCsvBuilder<StaticalProduct>(pw).build();
            pw.println("Ma San Pham,Ten San Pham,Nha San Xuat,So Luong,Doanh Thu,Ti Le");
            writer.write(staticalProducts.values().stream().collect(Collectors.toList()));
            JOptionPane.showMessageDialog(this,
                    "Xuất File excel thành công!",
                    "Thông báo",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException ex) {
            JOptionPane.showMessageDialog(this, CANNOT_PRINT_TO_EXCEL, "Cảnh báo", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_printStaticalGoodsToExcelBtnActionPerformed

    private void searchOrderBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchOrderBtnActionPerformed
        if (!fromDay.isBlank() || !fromMonth.isBlank() || !fromYear.isBlank()
                || !toDay.isBlank() || !toMonth.isBlank() || !toYear.isBlank()) {
            filterDateTimeFrom = FormatOutput.convertStringToLocalDate(fromDay + "/" + fromMonth + "/" + fromYear);
            if (filterDateTimeFrom == null) {
                errorDateLabel.setVisible(true);
                return;
            }

            filterDateTimeTo = FormatOutput.convertStringToLocalDate(toDay + "/" + toMonth + "/" + toYear);
            if (filterDateTimeTo == null) {
                errorDateLabel.setVisible(true);
                return;
            }
        } else {
            filterDateTimeFrom = null;
            filterDateTimeTo = null;
        }

        errorDateLabel.setVisible(false);
        List<Invoice> filterdInvoices = filteringInvoices(this.invoices);
        displayInvoiceTable(filterdInvoices);
        displayInvoiceReportTable(filterdInvoices);
        invoiceDetailTableModel.setRowCount(0);
        totalPaymentLabel.setText("");
    }//GEN-LAST:event_searchOrderBtnActionPerformed

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        setDefaultValueToAllComponentInOrderHistoryPanel();
        fromDay = "";
        fromMonth = "";
        fromYear = "";
        toDay = "";
        toMonth = "";
        toYear = "";
        filterDateTimeFrom = null;
        filterDateTimeTo = null;
        refreshOrderHistoryPanel();
    }//GEN-LAST:event_refreshBtnActionPerformed

    private void invoiceHistoryTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invoiceHistoryTableMouseClicked
        int selectedRow = invoiceHistoryTable.getSelectedRow();
        if (selectedRow != -1) {
            Long invoiceID = (Long) invoiceTableModel.getValueAt(selectedRow, 0);
            this.selecetedInvoice = InvoiceUtil.getInvoiceFrom(invoiceID, this.invoices);

            if (this.selecetedInvoice == null) {
                JOptionPane.showMessageDialog(this, "Không tìm thấy hóa đơn", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                return;
            }

            refreshInvoiceDetailTable();
        }
    }//GEN-LAST:event_invoiceHistoryTableMouseClicked

    private void refreshImportTableLabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshImportTableLabelActionPerformed
        setDefaultValueToAllComponentInImportProductHistoryPanel();
        importFromDay = "";
        importFromMonth = "";
        importFromYear = "";
        importToDay = "";
        importToMonth = "";
        importToYear = "";
        importFilterDateTimeFrom = null;
        importFilterDateTimeTo = null;
        displayImportedProductHistory(this.store.getProducts());
    }//GEN-LAST:event_refreshImportTableLabelActionPerformed

    private void searchImportHistoryBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchImportHistoryBtnActionPerformed
        if (!importFromDay.isBlank() || !importFromMonth.isBlank() || !importFromYear.isBlank()
                || !importToDay.isBlank() || !importToMonth.isBlank() || !importToYear.isBlank()) {
            importFilterDateTimeFrom = FormatOutput.convertStringToLocalDate(importFromDay + "/" + importFromMonth + "/" + importFromYear);
            if (importFilterDateTimeFrom == null) {
                importErrorDateLabel.setVisible(true);
                return;
            }

            importFilterDateTimeTo = FormatOutput.convertStringToLocalDate(importToDay + "/" + importToMonth + "/" + importToYear);
            if (importFilterDateTimeTo == null) {
                importErrorDateLabel.setVisible(true);
                return;
            }
        } else {
            importFilterDateTimeFrom = null;
            importFilterDateTimeTo = null;
        }

        importErrorDateLabel.setVisible(false);
        displayImportedProductHistory(this.store.getProducts());
    }//GEN-LAST:event_searchImportHistoryBtnActionPerformed

    private void fromDayTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fromDayTextFieldKeyReleased
        fromDay = dateCheck(fromDayTextField, fromMonthTextField, fromDay, 2);
    }//GEN-LAST:event_fromDayTextFieldKeyReleased

    private void fromMonthTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fromMonthTextFieldKeyReleased
        fromMonth = dateCheck(fromMonthTextField, fromYearTextField, fromMonth, 2);
    }//GEN-LAST:event_fromMonthTextFieldKeyReleased

    private void fromYearTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fromYearTextFieldKeyReleased
        fromYear = dateCheck(fromYearTextField, toDayTextField, fromYear, 4);
    }//GEN-LAST:event_fromYearTextFieldKeyReleased

    private void toDayTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_toDayTextFieldKeyReleased
        toDay = dateCheck(toDayTextField, toMonthTextField, toDay, 2);
    }//GEN-LAST:event_toDayTextFieldKeyReleased

    private void toMonthTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_toMonthTextFieldKeyReleased
        toMonth = dateCheck(toMonthTextField, toYearTextField, toMonth, 2);
    }//GEN-LAST:event_toMonthTextFieldKeyReleased

    private void toYearTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_toYearTextFieldKeyReleased
        toYear = dateCheck(toYearTextField, searchOrderBtn, toYear, 4);
    }//GEN-LAST:event_toYearTextFieldKeyReleased

    private void searchCashierComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchCashierComboBoxActionPerformed
        ComboBoxItem<Long> selectedItem = (ComboBoxItem) searchCashierComboBox.getSelectedItem();
        int rowIndex = searchCashierComboBox.getSelectedIndex();
        if (rowIndex > 0) {
            selectedEmployeeId = selectedItem.getId();
        } else {
            selectedEmployeeId = null;
        }
    }//GEN-LAST:event_searchCashierComboBoxActionPerformed

    private void fromImportDayTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fromImportDayTextFieldKeyReleased
        importFromDay = importDateCheck(fromImportDayTextField, fromImportMonthTextField, importFromDay, 2);
    }//GEN-LAST:event_fromImportDayTextFieldKeyReleased

    private void fromImportMonthTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fromImportMonthTextFieldKeyReleased
        importFromMonth = importDateCheck(fromImportMonthTextField, fromImportYearTextField, importFromMonth, 2);
    }//GEN-LAST:event_fromImportMonthTextFieldKeyReleased

    private void fromImportYearTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fromImportYearTextFieldKeyReleased
        importFromYear = importDateCheck(fromImportYearTextField, toImportDayTextField, importFromYear, 4);
    }//GEN-LAST:event_fromImportYearTextFieldKeyReleased

    private void toImportDayTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_toImportDayTextFieldKeyReleased
        importToDay = importDateCheck(toImportDayTextField, toImportMonthTextField, importToDay, 2);
    }//GEN-LAST:event_toImportDayTextFieldKeyReleased

    private void toImportMonthTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_toImportMonthTextFieldKeyReleased
        importToMonth = importDateCheck(toImportMonthTextField, toImportYearTextField, importToMonth, 2);
    }//GEN-LAST:event_toImportMonthTextFieldKeyReleased

    private void toImportYearTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_toImportYearTextFieldKeyReleased
        importToYear = importDateCheck(toImportYearTextField, searchImportHistoryBtn, importToYear, 4);
    }//GEN-LAST:event_toImportYearTextFieldKeyReleased

    private String importDateCheck(JTextField textField, Component nextField, String time, int maxLength) {
        if (textField.getText().isBlank()) {
            importErrorDateLabel.setVisible(false);
            return "";
        }
        String currentText;
        if ((currentText = textField.getText()).length() > maxLength) {
            textField.setText(currentText.substring(0, maxLength));
        }
        try {
            Integer.valueOf(textField.getText());
            time = textField.getText();
            importErrorDateLabel.setVisible(false);
        } catch (NumberFormatException nfe) {
            importErrorDateLabel.setVisible(true);
        }
        if (textField.getText().length() == maxLength) {
            nextField.requestFocusInWindow();
        }
        return time;
    }

    private String dateCheck(JTextField textField, Component nextField, String time, int maxLength) {
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

    private void refreshCashierComboBox() {
        searchCashierComboBox.removeAllItems();
        searchCashierComboBox.addItem(new ComboBoxItem("Tất cả", 0));
        this.store.getEmployees()
                .stream()
                .forEach(e -> searchCashierComboBox
                .addItem(new ComboBoxItem(e.getFullname(), e.getEmployeeId())));
        searchCashierComboBox.setSelectedIndex(0);
    }

    private void refreshInvoiceDetailTable() {
        invoiceDetailTableModel.setRowCount(0);
        if (this.selecetedInvoice == null) {
            return;
        }

        for (InvoiceProduct p : selecetedInvoice.getInvoiceProducts()) {
            invoiceDetailTableModel.addRow(new Object[]{
                p.getProductCode(),
                p.getProductName(),
                p.getUnit(),
                FormatOutput.formatToMoneyAmountForm(String.format("%d", p.getPrice())),
                p.getShipmentId(),
                p.getQuantity(),
                FormatOutput.formatToMoneyAmountForm(InvoiceUtil.getTotalAmountPerProduct(p))
            });
        }

        totalPaymentLabel.setText(FormatOutput.formatToMoneyAmountForm(InvoiceUtil.getTotal(selecetedInvoice)));
    }

    private boolean isInvoiceStatisfyFilter(Invoice invoice) {
        String invoiceID = searchOrderIDTextField.getText().trim();
        if (!invoiceID.isBlank()
                && !String.valueOf(invoice.getInvoiceId()).equals(invoiceID)) {
            return false;
        }

        if (selectedEmployeeId != null && !invoice.getShift().getCashierId().equals(selectedEmployeeId)) {
            return false;
        }

        if (filterDateTimeFrom != null && filterDateTimeTo != null) {
            if (invoice.getCreatedAt().toLocalDate().isAfter(filterDateTimeTo)
                    || invoice.getCreatedAt().toLocalDate().isBefore(filterDateTimeFrom)) {
                return false;
            }
        }

        return true;
    }

    private List<Invoice> filteringInvoices(List<Invoice> invoicesToFilter) {
        List<Invoice> bucket = new ArrayList<>();
        invoicesToFilter.forEach(i -> {
            if (!isInvoiceStatisfyFilter(i)) {
                return;
            }
            bucket.add(i);
        });

        return bucket;
    }

    private void displayInvoiceTable(List<Invoice> invoices) {
        invoiceTableModel.setRowCount(0);
        int counter = 0;
        BigInteger sum = BigInteger.ZERO;

        for (Invoice i : invoices) {
            String invoiceTotal = InvoiceUtil.getTotal(i);
            invoiceTableModel.addRow(new Object[]{
                i.getInvoiceId(),
                FormatOutput.convertLocalDateTimeToString(i.getCreatedAt()),
                FormatOutput.formatToMoneyAmountForm(invoiceTotal)
            });
            counter++;
            sum = sum.add(new BigInteger(invoiceTotal));
        }

        totalInvoiceQuantityLabel.setText(String.format("%d", counter));
        totalNetRevenueLabel.setText(FormatOutput.formatToMoneyAmountForm(sum.toString()));
    }

    private void displayInvoiceReportTable(List<Invoice> invoices) {
        productReportTableModel.setRowCount(0);
        staticalProducts = InvoiceUtil.getStaticalProducts(invoices);

        for (Map.Entry<Long, StaticalProduct> entry : staticalProducts.entrySet()) {
            StaticalProduct staticalProduct = entry.getValue();
            productReportTableModel.addRow(new Object[]{
                staticalProduct.getProductId(),
                staticalProduct.getProductName(),
                staticalProduct.getProvider(),
                staticalProduct.getQuantity(),
                FormatOutput.formatToMoneyAmountForm(staticalProduct.getRevenue()),
                staticalProduct.getRatio()
            });
        }
    }

    private boolean isImpporedProductSatifyFilters(ImportedProduct product) {
        String searchingKey = goodsNameTextField.getText().trim();
        if (!product.getProductName().toLowerCase().contains(searchingKey.toLowerCase())) {
            return false;
        }

        if (importFilterDateTimeFrom != null && importFilterDateTimeTo != null) {
            if (product.getCreatedAt().toLocalDate().isAfter(importFilterDateTimeTo)
                    || product.getCreatedAt().toLocalDate().isBefore(importFilterDateTimeFrom)) {
                return false;
            }
        }

        return true;
    }

    private void displayImportedProductHistory(List<Product> products) {
        importDetailModel.setRowCount(0);
        importedProducts = ProductUtil.getImportedProduct(products);
        BigInteger total = BigInteger.ZERO;

        for (Map.Entry<LocalDate, List<ImportedProduct>> entry : importedProducts.entrySet()) {
            List<ImportedProduct> list = entry.getValue();
            for (ImportedProduct i : list) {
                if (!isImpporedProductSatifyFilters(i)) {
                    continue;
                }

                importDetailModel.addRow(new Object[]{
                    i.getProductId().toString(),
                    i.getProductName(),
                    i.getProvider(),
                    FormatOutput.convertLocalDateTimeToString(i.getCreatedAt()),
                    i.getUnit(),
                    i.getShipmentId().toString(),
                    FormatOutput.formatToMoneyAmountForm(i.getImportPrice() + ""),
                    i.getQuantity(),
                    FormatOutput.formatToMoneyAmountForm(i.getCostValue() + "")
                });

                total = total.add(new BigInteger(i.getCostValue()));
            }
        }

        displayNumberOfImportLabel.setText(importDetailTable.getRowCount() + "");
        displayTotalOfImportLabel.setText(FormatOutput.formatToMoneyAmountForm(total.toString()));
    }

    private void setDefaultValueToAllComponentInImportProductHistoryPanel() {
        goodsNameTextField.setText("");
        fromImportDayTextField.setText("");
        fromImportMonthTextField.setText("");
        fromImportYearTextField.setText("");
        toImportDayTextField.setText("");
        toImportMonthTextField.setText("");
        toImportYearTextField.setText("");
        displayNumberOfImportLabel.setText("0");
        displayTotalOfImportLabel.setText("0");
        importErrorDateLabel.setVisible(false);
    }

    private void setDefaultValueToAllComponentInOrderHistoryPanel() {
        searchOrderIDTextField.setText("");
        searchCashierComboBox.setSelectedIndex(0);
        fromDayTextField.setText("");
        fromMonthTextField.setText("");
        fromYearTextField.setText("");
        toDayTextField.setText("");
        toMonthTextField.setText("");
        toYearTextField.setText("");
        totalReportProcessLabel.setText("0.0");
        totalPaymentLabel.setText("0.0");
        errorDateLabel.setVisible(false);
    }

    private void refreshOrderHistoryPanel() {
        refreshCashierComboBox();
        setDefaultValueToAllComponentInOrderHistoryPanel();
        displayInvoiceTable(this.invoices);
        displayInvoiceReportTable(this.invoices);
    }

    public void refreshView() {
        this.invoices = this.invoiceDAO.getInvoicesFromStore(this.store.getStoreId(), this.hibernateConfig.getEntityManager());
        refreshOrderHistoryPanel();
        displayImportedProductHistory(this.store.getProducts());
    }

    public void setup(HibernateConfig hibernateConfig, Store store) {
        this.store = store;
        this.hibernateConfig = hibernateConfig;
        this.invoiceDAO = new InvoiceDAOImpl();
        // Table 
        invoiceTableModel = (DefaultTableModel) invoiceHistoryTable.getModel();
        overViewJScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        overViewJScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        invoiceDetailTableModel = (DefaultTableModel) invoiceDetailTable.getModel();
        orderDetailJScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        orderDetailJScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        productReportTableModel = (DefaultTableModel) productReportTable.getModel();
        goodsReportScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        goodsReportScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        importDetailModel = (DefaultTableModel) importDetailTable.getModel();
    }

    private String importFromDay = "";
    private String importFromMonth = "";
    private String importFromYear = "";
    private String importToDay = "";
    private String importToMonth = "";
    private String importToYear = "";
    private LocalDate importFilterDateTimeFrom;
    private LocalDate importFilterDateTimeTo;

    private Long selectedEmployeeId;
    private String fromDay = "";
    private String fromMonth = "";
    private String fromYear = "";
    private String toDay = "";
    private String toMonth = "";
    private String toYear = "";
    private LocalDate filterDateTimeFrom;
    private LocalDate filterDateTimeTo;
    Map<LocalDate, List<ImportedProduct>> importedProducts;
    Map<Long, StaticalProduct> staticalProducts;
    private List<Invoice> invoices;

    private HibernateConfig hibernateConfig;
    private InvoiceDAO invoiceDAO;
    private Invoice selecetedInvoice;
    private Store store;
    private DefaultTableModel invoiceTableModel;
    private DefaultTableModel productReportTableModel;
    private DefaultTableModel invoiceDetailTableModel;
    private DefaultTableModel importDetailModel;

    private final String NOTHING_CHOOSEN_WARNING = "Bạn chưa chọn hoá đơn nào!";
    private final String CANNOT_PRINT_TO_EXCEL = "Không thể thực hiện xuất danh sách!";
    private final String HOME = System.getProperty("user.dir");
    private final String SEPARATOR = File.separator;
    private final String REPORT_GOODS_LIST_FILE = HOME + SEPARATOR + "output" + SEPARATOR + "staticalGoodsList.csv";
    private final String IMPORT_GOODS_LIST_FILE = HOME + SEPARATOR + "output" + SEPARATOR + "importGoodsList.csv";
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel amountOfOrderLabel;
    private javax.swing.JLabel cashierPhoneNumLable1;
    private javax.swing.JLabel displayNumberOfImportLabel;
    private javax.swing.JPanel displayShipmentPanel;
    private javax.swing.JLabel displayTotalOfImportLabel;
    private javax.swing.JLabel errorDateLabel;
    private javax.swing.JTextField fromDayTextField;
    private javax.swing.JTextField fromImportDayTextField;
    private javax.swing.JTextField fromImportMonthTextField;
    private javax.swing.JTextField fromImportYearTextField;
    private javax.swing.JLabel fromLabel;
    private javax.swing.JLabel fromLabel1;
    private javax.swing.JTextField fromMonthTextField;
    private javax.swing.JTextField fromYearTextField;
    private javax.swing.JLabel goodsNameLabel;
    private javax.swing.JTextField goodsNameTextField;
    private javax.swing.JScrollPane goodsReportScrollPane;
    private javax.swing.JTabbedPane historyTabPane;
    private javax.swing.JScrollPane importDetailJScrollPane;
    private javax.swing.JTable importDetailTable;
    private javax.swing.JLabel importErrorDateLabel;
    private javax.swing.JPanel importHistoryPanel;
    private javax.swing.JTable invoiceDetailTable;
    private javax.swing.JTable invoiceHistoryTable;
    private javax.swing.JLabel numberOfImportLabel;
    private javax.swing.JLabel orderDateLabel;
    private javax.swing.JScrollPane orderDetailJScrollPane;
    private javax.swing.JPanel orderDetailPanel;
    private javax.swing.JPanel orderHistoryPanel;
    private javax.swing.JLabel orderIDToSearchLabel;
    private javax.swing.JPanel orderListPanel;
    private javax.swing.JScrollPane overViewJScrollPane;
    private javax.swing.JButton printImportReportBtn;
    private javax.swing.JButton printStaticalGoodsToExcelBtn;
    private javax.swing.JTable productReportTable;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JButton refreshImportTableLabel;
    private javax.swing.JButton reprintBtn;
    private javax.swing.JComboBox<ComboBoxItem> searchCashierComboBox;
    private javax.swing.JButton searchImportHistoryBtn;
    private javax.swing.JButton searchOrderBtn;
    private javax.swing.JTextField searchOrderIDTextField;
    private javax.swing.JPanel searchOrderPanel;
    private javax.swing.JPanel searchShipmentPanel;
    private javax.swing.JLabel separatorLabel10;
    private javax.swing.JLabel separatorLabel11;
    private javax.swing.JLabel separatorLabel12;
    private javax.swing.JLabel separatorLabel13;
    private javax.swing.JLabel separatorLabel14;
    private javax.swing.JLabel separatorLabel7;
    private javax.swing.JLabel separatorLabel8;
    private javax.swing.JLabel separatorLabel9;
    private javax.swing.JPanel staticShipmentsPanel;
    private javax.swing.JPanel statisticGoodsPanel;
    private javax.swing.JTextField toDayTextField;
    private javax.swing.JTextField toImportDayTextField;
    private javax.swing.JTextField toImportMonthTextField;
    private javax.swing.JTextField toImportYearTextField;
    private javax.swing.JLabel toLabel;
    private javax.swing.JLabel toLabel2;
    private javax.swing.JTextField toMonthTextField;
    private javax.swing.JTextField toYearTextField;
    private javax.swing.JLabel totalInvoiceQuantityLabel;
    private javax.swing.JLabel totalLabel;
    private javax.swing.JLabel totalNetRevenueLabel;
    private javax.swing.JLabel totalOfImportLabel;
    private javax.swing.JLabel totalPayment;
    private javax.swing.JLabel totalPaymentLabel;
    private javax.swing.JLabel totalProceedsLabel;
    private javax.swing.JLabel totalReportProcessLabel;
    // End of variables declaration//GEN-END:variables
}
