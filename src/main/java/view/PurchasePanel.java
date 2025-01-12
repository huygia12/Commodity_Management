package view;

import config.HibernateConfig;
import dao.InvoiceDAO;
import dao.ProductDAO;
import dao.impl.InvoiceDAOImpl;
import dao.impl.ProductDAOImpl;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import model.entities.Invoice;
import model.entities.InvoiceProduct;
import model.entities.Product;
import model.entities.Shift;
import model.entities.Shipment;
import model.entities.Store;
import model.enums.PaymentOption;
import model.enums.ShiftState;
import util.FormatOutput;
import util.InvoiceUtil;
import util.PrinterUtil;
import util.ProductUtil;
import util.ShipmentUtil;
import util.ValidateInput;

public class PurchasePanel extends javax.swing.JPanel {

    public PurchasePanel() {
        initComponents();
        customUI();
    }

    public final void customUI() {
        priceRangeComboBox.setEnabled(false);
        productionDateRadioBtn.setEnabled(false);
        expirDateRadioBtn.setEnabled(false);
        fromDateTextField.setEditable(false);
        toDateTextField.setEditable(false);
        filterBtn.setEnabled(false);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setVerticalTextPosition(SwingConstants.CENTER);
        centerRenderer.setHorizontalTextPosition(SwingConstants.CENTER);
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        centerRenderer.setVerticalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < productTable.getColumnCount(); i++) {
            productTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        JTableHeader header = productTable.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 14));

        for (int i = 0; i < invoiceTable.getColumnCount(); i++) {
            invoiceTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        header = invoiceTable.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 14));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        proAndExpirDateBtnGroup = new javax.swing.ButtonGroup();
        aboutGoodsAndCusPanel = new javax.swing.JPanel();
        goodsPanel = new javax.swing.JPanel();
        productScrollPane = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();
        aboutOrderPanel = new javax.swing.JPanel();
        feePanel = new javax.swing.JPanel();
        subFeePanel = new javax.swing.JPanel();
        customerMoneyLabel = new javax.swing.JLabel();
        discountLabel = new javax.swing.JLabel();
        customerMoneyText = new javax.swing.JTextField();
        discountText = new javax.swing.JTextField();
        paymentOptionLabel = new javax.swing.JLabel();
        paymentOptionCombobox = new javax.swing.JComboBox<>();
        mainFeePanel = new javax.swing.JPanel();
        subTotalLabel = new javax.swing.JLabel();
        discountAmountLabel = new javax.swing.JLabel();
        totalLabel = new javax.swing.JLabel();
        changeAmountLabel = new javax.swing.JLabel();
        subTotalTextField = new javax.swing.JTextField();
        discountAmountTextField = new javax.swing.JTextField();
        totalTextField = new javax.swing.JTextField();
        changeAmountTextField = new javax.swing.JTextField();
        payAnfPrintBtn = new javax.swing.JButton();
        payBtn = new javax.swing.JButton();
        orderDisplayPanel = new javax.swing.JPanel();
        mainOrderFunctionPanel = new javax.swing.JPanel();
        quantityTextField = new javax.swing.JTextField();
        quantityLabel = new javax.swing.JLabel();
        addBtn = new javax.swing.JButton();
        removeBtn = new javax.swing.JButton();
        resetBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        fromLabel = new javax.swing.JLabel();
        toLabel = new javax.swing.JLabel();
        priceRangeComboBox = new javax.swing.JComboBox<>();
        priceRangeLabel = new javax.swing.JLabel();
        keyWordLabel = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        productionDateRadioBtn = new javax.swing.JRadioButton();
        keyWordTextField = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        expirDateRadioBtn = new javax.swing.JRadioButton();
        jSeparator3 = new javax.swing.JSeparator();
        fromDateTextField = new javax.swing.JTextField();
        toDateTextField = new javax.swing.JTextField();
        filterBtn = new javax.swing.JButton();
        filterSwitchRadioBtn = new javax.swing.JRadioButton();
        orderScrollPane = new javax.swing.JScrollPane();
        invoiceTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setMaximumSize(new java.awt.Dimension(2147483647, 900));
        setMinimumSize(new java.awt.Dimension(1400, 800));
        setPreferredSize(new java.awt.Dimension(1400, 800));
        setLayout(new java.awt.BorderLayout());

        aboutGoodsAndCusPanel.setMinimumSize(new java.awt.Dimension(985, 190));
        aboutGoodsAndCusPanel.setPreferredSize(new java.awt.Dimension(968, 190));
        aboutGoodsAndCusPanel.setLayout(new java.awt.BorderLayout(5, 0));

        goodsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin sản phẩm"));
        goodsPanel.setMaximumSize(new java.awt.Dimension(800, 190));
        goodsPanel.setMinimumSize(new java.awt.Dimension(700, 180));
        goodsPanel.setOpaque(false);

        productTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Nhà SX", "ĐV", "Giá Bán/ĐV", "Mã lô", "Ngày SX", "Hạn SD", "SL", "ProductId"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        productTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        productTable.setMaximumSize(new java.awt.Dimension(700, 0));
        productTable.setMinimumSize(new java.awt.Dimension(675, 0));
        productTable.setShowGrid(false);
        productTable.setShowHorizontalLines(true);
        productTable.setShowVerticalLines(true);
        productTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productTableMouseClicked(evt);
            }
        });
        productScrollPane.setViewportView(productTable);
        productTable.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout goodsPanelLayout = new javax.swing.GroupLayout(goodsPanel);
        goodsPanel.setLayout(goodsPanelLayout);
        goodsPanelLayout.setHorizontalGroup(
            goodsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(goodsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(productScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1376, Short.MAX_VALUE)
                .addContainerGap())
        );
        goodsPanelLayout.setVerticalGroup(
            goodsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(goodsPanelLayout.createSequentialGroup()
                .addComponent(productScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 5, Short.MAX_VALUE))
        );

        aboutGoodsAndCusPanel.add(goodsPanel, java.awt.BorderLayout.CENTER);

        add(aboutGoodsAndCusPanel, java.awt.BorderLayout.PAGE_START);

        aboutOrderPanel.setMinimumSize(new java.awt.Dimension(36, 390));
        aboutOrderPanel.setPreferredSize(new java.awt.Dimension(965, 390));
        aboutOrderPanel.setLayout(new java.awt.BorderLayout());

        feePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Chi tiết hóa đơn"));
        feePanel.setLayout(new java.awt.BorderLayout(0, 10));

        subFeePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        subFeePanel.setAutoscrolls(true);
        subFeePanel.setFocusable(false);
        subFeePanel.setMaximumSize(new java.awt.Dimension(32767, 170));
        subFeePanel.setOpaque(false);
        subFeePanel.setPreferredSize(new java.awt.Dimension(316, 170));

        customerMoneyLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        customerMoneyLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageIcon/cashMoney.png"))); // NOI18N
        customerMoneyLabel.setText("Tiền mặt khách:");

        discountLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        discountLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageIcon/icons8-discount-24.png"))); // NOI18N
        discountLabel.setText("Chiết khấu(%): ");

        customerMoneyText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        customerMoneyText.setMaximumSize(new java.awt.Dimension(2147483647, 20));
        customerMoneyText.setMinimumSize(new java.awt.Dimension(64, 20));
        customerMoneyText.setPreferredSize(new java.awt.Dimension(64, 20));
        customerMoneyText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customerMoneyTextMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                customerMoneyTextMouseExited(evt);
            }
        });
        customerMoneyText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                customerMoneyTextKeyPressed(evt);
            }
        });

        discountText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        discountText.setMaximumSize(new java.awt.Dimension(2147483647, 20));
        discountText.setPreferredSize(new java.awt.Dimension(64, 20));
        discountText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                discountTextMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                discountTextMouseExited(evt);
            }
        });
        discountText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                discountTextKeyPressed(evt);
            }
        });

        paymentOptionLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        paymentOptionLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageIcon/icons8-payment-method-24.png"))); // NOI18N
        paymentOptionLabel.setText("PT thanh toán:");

        paymentOptionCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiền Mặt", "Chuyển Khoản" }));
        paymentOptionCombobox.setMaximumSize(new java.awt.Dimension(32767, 20));
        paymentOptionCombobox.setMinimumSize(new java.awt.Dimension(72, 20));
        paymentOptionCombobox.setPreferredSize(new java.awt.Dimension(72, 20));
        paymentOptionCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentOptionComboboxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout subFeePanelLayout = new javax.swing.GroupLayout(subFeePanel);
        subFeePanel.setLayout(subFeePanelLayout);
        subFeePanelLayout.setHorizontalGroup(
            subFeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subFeePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(subFeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(customerMoneyLabel)
                    .addComponent(paymentOptionLabel)
                    .addComponent(discountLabel))
                .addGap(18, 18, 18)
                .addGroup(subFeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(discountText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(paymentOptionCombobox, 0, 206, Short.MAX_VALUE)
                    .addComponent(customerMoneyText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        subFeePanelLayout.setVerticalGroup(
            subFeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subFeePanelLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(subFeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(paymentOptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(paymentOptionCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(subFeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(customerMoneyLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(customerMoneyText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(subFeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(discountLabel)
                    .addComponent(discountText, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );

        feePanel.add(subFeePanel, java.awt.BorderLayout.PAGE_START);

        mainFeePanel.setBackground(new java.awt.Color(255, 255, 255));
        mainFeePanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(51, 51, 51), new java.awt.Color(153, 153, 153), new java.awt.Color(51, 51, 51)));
        mainFeePanel.setEnabled(false);
        mainFeePanel.setFocusable(false);
        mainFeePanel.setOpaque(false);

        subTotalLabel.setFont(new java.awt.Font("MTO Telephone", 1, 14)); // NOI18N
        subTotalLabel.setText("THÀNH TIỀN:");

        discountAmountLabel.setFont(new java.awt.Font("MTO Telephone", 1, 14)); // NOI18N
        discountAmountLabel.setText("KHOẢN CHIẾT KHẤU:");

        totalLabel.setFont(new java.awt.Font("MTO Telephone", 1, 14)); // NOI18N
        totalLabel.setText("TỔNG THANH TOÁN:");

        changeAmountLabel.setFont(new java.awt.Font("MTO Telephone", 1, 14)); // NOI18N
        changeAmountLabel.setText("TIỀN THỪA KHÁCH: ");

        subTotalTextField.setEditable(false);
        subTotalTextField.setBackground(new java.awt.Color(255, 255, 255));
        subTotalTextField.setFont(new java.awt.Font("MTO Telephone", 1, 14)); // NOI18N
        subTotalTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        subTotalTextField.setText("0.0");
        subTotalTextField.setBorder(null);
        subTotalTextField.setMaximumSize(new java.awt.Dimension(2147483647, 20));
        subTotalTextField.setMinimumSize(new java.awt.Dimension(64, 20));
        subTotalTextField.setPreferredSize(new java.awt.Dimension(64, 20));
        subTotalTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                subTotalTextFieldMouseClicked(evt);
            }
        });

        discountAmountTextField.setEditable(false);
        discountAmountTextField.setBackground(new java.awt.Color(255, 255, 255));
        discountAmountTextField.setFont(new java.awt.Font("MTO Telephone", 1, 14)); // NOI18N
        discountAmountTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        discountAmountTextField.setText("0.0");
        discountAmountTextField.setBorder(null);
        discountAmountTextField.setMaximumSize(new java.awt.Dimension(2147483647, 20));
        discountAmountTextField.setMinimumSize(new java.awt.Dimension(64, 20));
        discountAmountTextField.setPreferredSize(new java.awt.Dimension(64, 20));
        discountAmountTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                discountAmountTextFieldMouseClicked(evt);
            }
        });

        totalTextField.setEditable(false);
        totalTextField.setBackground(new java.awt.Color(255, 255, 255));
        totalTextField.setFont(new java.awt.Font("MTO Telephone", 1, 14)); // NOI18N
        totalTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        totalTextField.setText("0.0");
        totalTextField.setBorder(null);
        totalTextField.setMaximumSize(new java.awt.Dimension(2147483647, 20));
        totalTextField.setMinimumSize(new java.awt.Dimension(64, 20));
        totalTextField.setPreferredSize(new java.awt.Dimension(64, 20));
        totalTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                totalTextFieldMouseClicked(evt);
            }
        });

        changeAmountTextField.setEditable(false);
        changeAmountTextField.setBackground(new java.awt.Color(255, 255, 255));
        changeAmountTextField.setFont(new java.awt.Font("MTO Telephone", 1, 14)); // NOI18N
        changeAmountTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        changeAmountTextField.setText("0.0");
        changeAmountTextField.setActionCommand("<Not Set>");
        changeAmountTextField.setBorder(null);
        changeAmountTextField.setMaximumSize(new java.awt.Dimension(2147483647, 20));
        changeAmountTextField.setMinimumSize(new java.awt.Dimension(64, 20));
        changeAmountTextField.setPreferredSize(new java.awt.Dimension(64, 20));
        changeAmountTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changeAmountTextFieldMouseClicked(evt);
            }
        });

        payAnfPrintBtn.setBackground(new java.awt.Color(204, 204, 204));
        payAnfPrintBtn.setFont(new java.awt.Font("MTO Telephone", 1, 14)); // NOI18N
        payAnfPrintBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageIcon/icons8-print-30.png"))); // NOI18N
        payAnfPrintBtn.setText("THANH TOÁN & IN ");
        payAnfPrintBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 102, 102), new java.awt.Color(51, 51, 51), new java.awt.Color(102, 102, 102), new java.awt.Color(51, 51, 51)));
        payAnfPrintBtn.setFocusable(false);
        payAnfPrintBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payAnfPrintBtnActionPerformed(evt);
            }
        });

        payBtn.setBackground(new java.awt.Color(204, 204, 204));
        payBtn.setFont(new java.awt.Font("MTO Telephone", 1, 14)); // NOI18N
        payBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageIcon/icons8-paid-bill-30.png"))); // NOI18N
        payBtn.setText("THANH TOÁN ");
        payBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 102, 102), new java.awt.Color(51, 51, 51), new java.awt.Color(102, 102, 102), new java.awt.Color(51, 51, 51)));
        payBtn.setFocusable(false);
        payBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainFeePanelLayout = new javax.swing.GroupLayout(mainFeePanel);
        mainFeePanel.setLayout(mainFeePanelLayout);
        mainFeePanelLayout.setHorizontalGroup(
            mainFeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainFeePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainFeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainFeePanelLayout.createSequentialGroup()
                        .addComponent(payAnfPrintBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(payBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
                    .addGroup(mainFeePanelLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(mainFeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(totalLabel)
                            .addComponent(discountAmountLabel)
                            .addComponent(changeAmountLabel)
                            .addComponent(subTotalLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainFeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(subTotalTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(discountAmountTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(totalTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(changeAmountTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        mainFeePanelLayout.setVerticalGroup(
            mainFeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainFeePanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(mainFeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(subTotalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subTotalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(mainFeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(discountAmountTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(discountAmountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(mainFeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(totalTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(totalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(mainFeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(changeAmountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(changeAmountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addGroup(mainFeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(payAnfPrintBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(payBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        feePanel.add(mainFeePanel, java.awt.BorderLayout.LINE_START);

        aboutOrderPanel.add(feePanel, java.awt.BorderLayout.LINE_END);

        orderDisplayPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Bộ lọc & Tìm kiếm"));
        orderDisplayPanel.setPreferredSize(new java.awt.Dimension(639, 400));
        orderDisplayPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainOrderFunctionPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 102, 102), new java.awt.Color(51, 51, 51), new java.awt.Color(102, 102, 102), new java.awt.Color(51, 51, 51)));
        mainOrderFunctionPanel.setEnabled(false);
        mainOrderFunctionPanel.setFocusable(false);
        mainOrderFunctionPanel.setMaximumSize(new java.awt.Dimension(630, 170));
        mainOrderFunctionPanel.setOpaque(false);
        mainOrderFunctionPanel.setPreferredSize(new java.awt.Dimension(629, 170));
        mainOrderFunctionPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        quantityTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        quantityTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        quantityTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quantityTextFieldMouseClicked(evt);
            }
        });
        quantityTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                quantityTextFieldKeyPressed(evt);
            }
        });
        mainOrderFunctionPanel.add(quantityTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 120, 200, 40));

        quantityLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        quantityLabel.setText("Nhập Số Lượng:");
        mainOrderFunctionPanel.add(quantityLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, -1, 40));

        addBtn.setBackground(new java.awt.Color(0, 255, 0));
        addBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addBtn.setText("Thêm");
        addBtn.setMinimumSize(new java.awt.Dimension(84, 27));
        addBtn.setPreferredSize(new java.awt.Dimension(84, 27));
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });
        mainOrderFunctionPanel.add(addBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 90, 85, 30));

        removeBtn.setBackground(new java.awt.Color(255, 0, 0));
        removeBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        removeBtn.setForeground(new java.awt.Color(255, 255, 255));
        removeBtn.setText("Xóa");
        removeBtn.setPreferredSize(new java.awt.Dimension(84, 27));
        removeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeBtnActionPerformed(evt);
            }
        });
        mainOrderFunctionPanel.add(removeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 90, 100, 30));

        resetBtn.setBackground(new java.awt.Color(51, 51, 51));
        resetBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        resetBtn.setForeground(new java.awt.Color(255, 255, 255));
        resetBtn.setText("Làm mới");
        resetBtn.setOpaque(true);
        resetBtn.setPreferredSize(new java.awt.Dimension(72, 27));
        resetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBtnActionPerformed(evt);
            }
        });
        mainOrderFunctionPanel.add(resetBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 130, 100, 30));

        editBtn.setBackground(new java.awt.Color(0, 255, 0));
        editBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        editBtn.setText("Sửa");
        editBtn.setPreferredSize(new java.awt.Dimension(7284, 27));
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });
        mainOrderFunctionPanel.add(editBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 130, 85, 30));

        fromLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fromLabel.setText("Từ:");
        mainOrderFunctionPanel.add(fromLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 70, -1, -1));

        toLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        toLabel.setText("Đến:");
        mainOrderFunctionPanel.add(toLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 111, -1, -1));

        priceRangeComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        priceRangeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Trống", "< 100.000", "100.000 - 300.000", "300.000 - 500.000", "> 500.000" }));
        mainOrderFunctionPanel.add(priceRangeComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 8, 240, 43));

        priceRangeLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        priceRangeLabel.setText("Khoảng Giá:");
        mainOrderFunctionPanel.add(priceRangeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 8, -1, 43));

        keyWordLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        keyWordLabel.setText("Từ khóa tìm kiếm : ");
        keyWordLabel.setAutoscrolls(true);
        keyWordLabel.setVerifyInputWhenFocusTarget(false);
        mainOrderFunctionPanel.add(keyWordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, -1, 40));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        mainOrderFunctionPanel.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 10, 170));

        proAndExpirDateBtnGroup.add(productionDateRadioBtn);
        productionDateRadioBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        productionDateRadioBtn.setText("Ngày SX");
        productionDateRadioBtn.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                productionDateRadioBtnItemStateChanged(evt);
            }
        });
        mainOrderFunctionPanel.add(productionDateRadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        keyWordTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        keyWordTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        keyWordTextField.setOpaque(true);
        mainOrderFunctionPanel.add(keyWordTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 200, 40));

        searchBtn.setBackground(new java.awt.Color(0, 255, 0));
        searchBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        searchBtn.setText("Tìm kiếm");
        searchBtn.setMaximumSize(new java.awt.Dimension(90, 27));
        searchBtn.setMinimumSize(new java.awt.Dimension(85, 15));
        searchBtn.setOpaque(true);
        searchBtn.setPreferredSize(new java.awt.Dimension(88, 22));
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });
        mainOrderFunctionPanel.add(searchBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(531, 60, 200, 31));

        proAndExpirDateBtnGroup.add(expirDateRadioBtn);
        expirDateRadioBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        expirDateRadioBtn.setText("Hạn SD  ");
        expirDateRadioBtn.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                expirDateRadioBtnItemStateChanged(evt);
            }
        });
        mainOrderFunctionPanel.add(expirDateRadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, 23));

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        mainOrderFunctionPanel.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 10, 70));

        fromDateTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fromDateTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fromDateTextFieldKeyReleased(evt);
            }
        });
        mainOrderFunctionPanel.add(fromDateTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 61, 190, 35));

        toDateTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        toDateTextField.setPreferredSize(new java.awt.Dimension(64, 26));
        toDateTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                toDateTextFieldKeyReleased(evt);
            }
        });
        mainOrderFunctionPanel.add(toDateTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 101, 190, 36));

        filterBtn.setBackground(new java.awt.Color(0, 255, 0));
        filterBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        filterBtn.setText("Lọc");
        filterBtn.setPreferredSize(new java.awt.Dimension(104, 27));
        filterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterBtnActionPerformed(evt);
            }
        });
        mainOrderFunctionPanel.add(filterBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 180, -1));

        filterSwitchRadioBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        filterSwitchRadioBtn.setText("Bật Bộ Lọc");
        filterSwitchRadioBtn.setRolloverEnabled(false);
        filterSwitchRadioBtn.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                filterSwitchRadioBtnItemStateChanged(evt);
            }
        });
        filterSwitchRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterSwitchRadioBtnActionPerformed(evt);
            }
        });
        mainOrderFunctionPanel.add(filterSwitchRadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 140, -1, -1));

        orderDisplayPanel.add(mainOrderFunctionPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 20, 998, -1));

        orderScrollPane.setPreferredSize(new java.awt.Dimension(452, 216));

        invoiceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "ĐV", "Giá Bán/ĐV", "Mã Lô", "SL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        invoiceTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        invoiceTable.setMaximumSize(new java.awt.Dimension(700, 0));
        invoiceTable.setShowGrid(true);
        invoiceTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                invoiceTableMouseClicked(evt);
            }
        });
        orderScrollPane.setViewportView(invoiceTable);

        orderDisplayPanel.add(orderScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 200, 998, 403));

        aboutOrderPanel.add(orderDisplayPanel, java.awt.BorderLayout.CENTER);

        add(aboutOrderPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void productTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productTableMouseClicked
        int selectedRow = productTable.getSelectedRow();
        if (selectedRow == -1) {
            return;
        }

        Long productId = (Long) productTable.getValueAt(selectedRow, 9);
        this.selectedProduct = ProductUtil.getProductFrom(productId, this.store.getProducts());

        if (this.selectedProduct == null) {
            JOptionPane.showMessageDialog(this, "Sản phẩm không tồn tại!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
    }//GEN-LAST:event_productTableMouseClicked

    private void invoiceTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invoiceTableMouseClicked
        int selectedRow = invoiceTable.getSelectedRow();
        if (selectedRow == -1) {
            return;
        }

        Long shipmentID = (Long) invoiceTableModel.getValueAt(selectedRow, 4);
        this.selectedInvoiceProduct = InvoiceUtil.getInvoiceProductFrom(shipmentID, this.invoice);

        if (this.selectedInvoiceProduct == null) {
            JOptionPane.showMessageDialog(this, "Sản phẩm không tồn tại trong giỏ hàng!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        quantityTextField.setText(String.format("%d", this.selectedInvoiceProduct.getQuantity()));
    }//GEN-LAST:event_invoiceTableMouseClicked

    private void customerMoneyTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerMoneyTextMouseClicked
        if (!customerMoneyWarningCheck) {
            textFieldMouseClick(customerMoneyText);
        }
    }//GEN-LAST:event_customerMoneyTextMouseClicked

    private void discountTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_discountTextMouseClicked
        if (!discountWarningCheck) {
            textFieldMouseClick(discountText);
        }
    }//GEN-LAST:event_discountTextMouseClicked

    private void customerMoneyTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_customerMoneyTextKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER
                && invoice.getPaymentMethod().equals(PaymentOption.CASH)) {
            String customerMoneyStr = customerMoneyText.getText();
            if (customerMoneyStr.isBlank()) { // kiểm tra xem textField có trống không
                insertWarningToTextField(customerMoneyText, EMPTY_TEXT_FIELD_WARNING);
                customerMoneyWarningCheck = false;
                return;
            } else if (!ValidateInput.isAPositiveNumber(customerMoneyStr)) {// kiểm tra xem có phải số hợp lệ hay không
                insertWarningToTextField(customerMoneyText, INVALID_WARNING);
                customerMoneyWarningCheck = false;
                return;
            }
            customerMoneyWarningCheck = true;
            int customerMoney = Integer.parseInt(customerMoneyStr);
            invoice.setCustomerMoney(customerMoney);
            customerMoneyText.setText(String.format("%d", invoice.getCustomerMoney()));
            discountText.requestFocus();
            refreshMainFee();
        }
    }//GEN-LAST:event_customerMoneyTextKeyPressed

    private void discountTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_discountTextKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String discountStr = discountText.getText();
            if (!ValidateInput.isAPositiveNumber(discountStr) && !discountStr.isBlank()) {// kiểm tra xem có phải số hợp lệ hay không
                discountWarningCheck = false;
                insertWarningToTextField(discountText, INVALID_WARNING);
                return;
            }
            if (discountStr.isBlank()) {
                discountText.setText("0");
                invoice.setDiscount(0);
                return;
            }
            invoice.setDiscount(Math.min(100, Integer.parseInt(discountStr)));
            discountText.setText(String.format("%d", invoice.getDiscount()));
            discountWarningCheck = true;
            refreshMainFee();
        }
    }//GEN-LAST:event_discountTextKeyPressed

    private void customerMoneyTextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerMoneyTextMouseExited
        if (!customerMoneyText.isEnabled()) {
            return;
        }
        if (invoice.getPaymentMethod().equals(PaymentOption.CASH)) {
            String customerMoneyStr = customerMoneyText.getText();
            if (customerMoneyStr.isBlank()) { // kiểm tra xemD textField có trống không
                customerMoneyText.setText("0");
                customerMoneyWarningCheck = false;
                return;
            } else if (!ValidateInput.isAPositiveNumber(customerMoneyStr)) {// kiểm tra xem có phải số hợp lệ hay không
                customerMoneyWarningCheck = false;
                insertWarningToTextField(customerMoneyText, INVALID_WARNING);
                return;
            }
            customerMoneyWarningCheck = true;
            int customerMoney = Integer.parseInt(customerMoneyStr);
            invoice.setCustomerMoney(customerMoney);
            customerMoneyText.setText(String.format("%d", invoice.getCustomerMoney()));
            refreshMainFee();
        }
    }//GEN-LAST:event_customerMoneyTextMouseExited

    private void discountTextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_discountTextMouseExited
        if (!discountText.isEnabled()) {
            return;
        }
        String discountStr = discountText.getText();
        if (!ValidateInput.isAPositiveNumber(discountStr) && !discountStr.isBlank()) {// kiểm tra xem có phải số hợp lệ hay không
            discountWarningCheck = false;
            insertWarningToTextField(discountText, INVALID_WARNING);
            return;
        }
        if (discountStr.isBlank()) {
            invoice.setDiscount(0);
            discountText.setText("0");
            return;
        }
        invoice.setDiscount(Math.min(100, Integer.parseInt(discountStr)));
        discountText.setText(String.format("%d", invoice.getDiscount()));
        discountWarningCheck = true;
        refreshMainFee();
        payBtn.requestFocus();
    }//GEN-LAST:event_discountTextMouseExited

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        if (this.store.getProducts().isEmpty()) {
            JOptionPane.showMessageDialog(this, EMPTY_LIST_WARNING, "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!validateFilterDate()) {
            return;
        }

        refreshProductTable();
    }//GEN-LAST:event_searchBtnActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        int rowIndex = invoiceTable.getSelectedRow();
        if (rowIndex == -1 || selectedInvoiceProduct == null) {
            JOptionPane.showMessageDialog(this, CHOOSE_IN_GOODSLIST_TABLE, "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String quantityAsStr = quantityTextField.getText().trim();
        if (quantityAsStr.isBlank()) { // kiểm tra xem ô số lượng có trống không
            insertWarningToTextField(quantityTextField, EMPTY_TEXT_FIELD_WARNING);
            return;
        } else if (!ValidateInput.isAPositiveInteger(quantityAsStr)
                || ValidateInput.isEqualZero(quantityAsStr)) { // kiểm tra xem có phải là số hợp lệ không
            insertWarningToTextField(quantityTextField, INVALID_WARNING);
            return;
        }

        Long shipmentId = (Long) invoiceTableModel.getValueAt(rowIndex, 4);
        InvoiceProduct invoiceProduct = InvoiceUtil.getInvoiceProductFrom(shipmentId, this.invoice);
        int quantityAsInteger = Integer.parseInt(quantityAsStr);

        Product product = ProductUtil.getProductFrom(invoiceProduct.getProductId(), this.store.getProducts());
        Shipment shipment = ShipmentUtil.getShipmentFrom(shipmentId, product);

        if (!ShipmentUtil.isInStock(shipment, quantityAsInteger)) {
            insertWarningToTextField(quantityTextField, NOT_ENOUGH_QUANTITY);
            return;
        }
        // thực hiện chức năng
        InvoiceUtil.updateInvoiceProductQuantity(this.invoice, quantityAsInteger, shipmentId);
        
        quantityTextField.setText("");
        refreshInvoiceTable();
        refreshMainFee();
        selectedInvoiceProduct = null;
    }//GEN-LAST:event_editBtnActionPerformed

    private void resetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBtnActionPerformed
        invoice.getInvoiceProducts().clear();
        selectedInvoiceProduct = null;
        selectedProduct = null;
        productionDateFrom = "";
        productionDateTo = "";
        expirDateFrom = "";
        expirDateTo = "";
        
        setDefaultValuesToAllComponents();
        refreshInvoiceTable();
        refreshProductTable();
    }//GEN-LAST:event_resetBtnActionPerformed

    private void removeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeBtnActionPerformed
        int rowIndex = invoiceTable.getSelectedRow();
        if (rowIndex == -1 || selectedInvoiceProduct == null) {
            JOptionPane.showMessageDialog(this, CHOOSE_IN_GOODSLIST_TABLE, "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Long shipmentId = (Long) invoiceTableModel.getValueAt(rowIndex, 4);
        // thực hiện chức năng
        InvoiceUtil.removeInvoiceProduct(this.invoice, shipmentId);

        quantityTextField.setText("");
        refreshInvoiceTable();
        refreshMainFee();
        selectedInvoiceProduct = null;
    }//GEN-LAST:event_removeBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        int rowIndex = productTable.getSelectedRow();
        if (rowIndex == -1 || selectedProduct == null) {
            JOptionPane.showMessageDialog(this, CHOOSE_IN_GOODSLIST_TABLE, "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String quantity = quantityTextField.getText().trim();
        if (quantity.isBlank()) {// kiểm tra xem quantity có trống không
            insertWarningToTextField(quantityTextField, EMPTY_TEXT_FIELD_WARNING);
            return;
        } else if (!ValidateInput.isAPositiveInteger(quantity)
                || ValidateInput.isEqualZero(quantity)) {// kiểm tra xem có phải số hợp lệ hay không
            insertWarningToTextField(quantityTextField, INVALID_WARNING);
            return;
        }

        int quantityInInteger = Integer.parseInt(quantity);

        Long shipmentId = (Long) productTable.getValueAt(rowIndex, 5);
        Shipment addedShipment = ShipmentUtil.getShipmentFrom(shipmentId, selectedProduct);
        if (!ShipmentUtil.isInStock(addedShipment, quantityInInteger)) {
            insertWarningToTextField(quantityTextField, NOT_ENOUGH_QUANTITY);
            return;
        }

        // thực hiện chức năng
        InvoiceUtil.addInvoiceProduct(invoice, selectedProduct, quantityInInteger, addedShipment);

        quantityTextField.setText("");
        refreshInvoiceTable();
        refreshMainFee();
    }//GEN-LAST:event_addBtnActionPerformed

    private void quantityTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityTextFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            addBtnActionPerformed(null);
        }
    }//GEN-LAST:event_quantityTextFieldKeyPressed

    private void quantityTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quantityTextFieldMouseClicked
        textFieldMouseClick(quantityTextField);
    }//GEN-LAST:event_quantityTextFieldMouseClicked

    private void productionDateRadioBtnItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_productionDateRadioBtnItemStateChanged
        fromDateTextField.setEditable(true);
        toDateTextField.setEditable(true);
        if (productionDateRadioBtn.isSelected()) {
            fromDateTextField.setText(productionDateFrom);
            toDateTextField.setText(productionDateTo);
        }
    }//GEN-LAST:event_productionDateRadioBtnItemStateChanged

    private void expirDateRadioBtnItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_expirDateRadioBtnItemStateChanged
        fromDateTextField.setEditable(true);
        toDateTextField.setEditable(true);
        if (expirDateRadioBtn.isSelected()) {
            fromDateTextField.setText(expirDateFrom);
            toDateTextField.setText(expirDateTo);
        }
    }//GEN-LAST:event_expirDateRadioBtnItemStateChanged

    private void filterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterBtnActionPerformed
        if (!validateFilterDate()) {
            return;
        }
        refreshProductTable();
    }//GEN-LAST:event_filterBtnActionPerformed

    private void filterSwitchRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterSwitchRadioBtnActionPerformed
        if (filterSwitchRadioBtn.isSelected()) {
            setEnableFilterPanel(true);
        } else {
            setEnableFilterPanel(false);
        }
    }//GEN-LAST:event_filterSwitchRadioBtnActionPerformed

    private void payBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payBtnActionPerformed
        if (invoice.getInvoiceProducts().isEmpty()) { // Kiểm tra xem đã chọn sản phẩm nào chưa
            JOptionPane.showMessageDialog(this, NOTHING_CHOOSEN_WARNING, "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        } else if (invoice.getPaymentMethod().equals(PaymentOption.CASH)
                && InvoiceUtil.isInsufficient(invoice)) {
            insertWarningToTextField(customerMoneyText, INSUFFICIENT_MONEY);
            customerMoneyWarningCheck = false;
            return;
        }
        // thực hiện chức năng
        invoice.setShift(shift);

        boolean result = invoiceDAO.addInvoice(invoice, hibernateConfig.getEntityManager());
        if (!result) {
            JOptionPane.showMessageDialog(this, "Thanh toán thất bại!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        shift.getInvoices().add(invoice);
        store.setProducts(productDAO.getProductsInStore(store.getStoreId(), hibernateConfig.getEntityManager()));
        initNewOrder();
        refreshProductTable();
        refreshInvoiceTable();
        JOptionPane.showMessageDialog(this, "Thanh toán thành công!");
    }//GEN-LAST:event_payBtnActionPerformed

    private void payAnfPrintBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payAnfPrintBtnActionPerformed
        if (invoice.getInvoiceProducts().isEmpty()) { // Kiểm tra xem đã chọn sản phẩm nào chưa
            JOptionPane.showMessageDialog(this, NOTHING_CHOOSEN_WARNING, "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        } else if (invoice.getPaymentMethod().equals(PaymentOption.CASH)
                && InvoiceUtil.isInsufficient(invoice)) { //Kiểm tra xem có thiếu tiền kh
            insertWarningToTextField(customerMoneyText, INSUFFICIENT_MONEY);
            customerMoneyWarningCheck = false;
            return;
        }
        // thực hiện chức năng
        invoice.setShift(shift);
        boolean result = invoiceDAO.addInvoice(invoice, hibernateConfig.getEntityManager());
        if (!result) {
            JOptionPane.showMessageDialog(this, "Thanh toán thất bại!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        shift.getInvoices().add(invoice);
        store.setProducts(productDAO.getProductsInStore(this.store.getStoreId(), hibernateConfig.getEntityManager()));
        PrinterUtil.exportBillToTxtFile(invoice, store);
        initNewOrder();
        refreshProductTable();
        refreshInvoiceTable();
        JOptionPane.showMessageDialog(this, "Thanh toán thành công!");
    }//GEN-LAST:event_payAnfPrintBtnActionPerformed

    private void changeAmountTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changeAmountTextFieldMouseClicked
        if (changeAmountTextField.getText().length() > (changeAmountTextField.getSize().getWidth() / 9)) {
            JOptionPane.showMessageDialog(this,
                    changeAmountTextField.getText(), "Tiền Thừa Khách",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_changeAmountTextFieldMouseClicked

    private void totalTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_totalTextFieldMouseClicked
        if (totalTextField.getText().length() > (totalTextField.getSize().getWidth() / 9)) {
            JOptionPane.showMessageDialog(this,
                    totalTextField.getText(), "Tổng Thanh Toán",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_totalTextFieldMouseClicked

    private void discountAmountTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_discountAmountTextFieldMouseClicked
        if (discountAmountTextField.getText().length() > (discountAmountTextField.getSize().getWidth() / 9)) {
            JOptionPane.showMessageDialog(this,
                    discountAmountTextField.getText(), "Khoản Chiết Khấu Tay",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_discountAmountTextFieldMouseClicked

    private void subTotalTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subTotalTextFieldMouseClicked
        if (subTotalTextField.getText().length() > (subTotalTextField.getSize().getWidth() / 9)) {
            JOptionPane.showMessageDialog(this,
                    subTotalTextField.getText(), "Thành Tiền",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_subTotalTextFieldMouseClicked

    private void paymentOptionComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentOptionComboboxActionPerformed
        boolean editable = true;
        // nếu order là chuyển khoản hoặc thẻ thì không cho nhập customerMoney nữa
        if (paymentOptionCombobox.getSelectedIndex() != 0) {
            invoice.setCustomerMoney(0);
            invoice.setPaymentMethod(PaymentOption.OTHER);
            editable = false;
        } else {
            invoice.setPaymentMethod(PaymentOption.CASH);
        }
        setDefaultOptionToTextField(customerMoneyText);
        customerMoneyText.setText((invoice.getPaymentMethod() == PaymentOption.CASH) ? "0" : "");
        customerMoneyText.setEditable(editable);
        refreshMainFee();
    }//GEN-LAST:event_paymentOptionComboboxActionPerformed

    private void fromDateTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fromDateTextFieldKeyReleased
        if (productionDateRadioBtn.isSelected()) {
            productionDateFrom = fromDateTextField.getText().trim();
        } else if (expirDateRadioBtn.isSelected()) {
            expirDateFrom = fromDateTextField.getText().trim();
        }
    }//GEN-LAST:event_fromDateTextFieldKeyReleased

    private void toDateTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_toDateTextFieldKeyReleased
        if (productionDateRadioBtn.isSelected()) {
            productionDateTo = toDateTextField.getText().trim();
        } else if (expirDateRadioBtn.isSelected()) {
            expirDateTo = toDateTextField.getText().trim();
        }
    }//GEN-LAST:event_toDateTextFieldKeyReleased

    private void filterSwitchRadioBtnItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_filterSwitchRadioBtnItemStateChanged
        if (filterSwitchRadioBtn.isSelected()) {
            setEnableFilterPanel(true);
        } else {
            setEnableFilterPanel(false);
        }
    }//GEN-LAST:event_filterSwitchRadioBtnItemStateChanged

    private boolean validateFilterDate() {
        if (filterSwitchRadioBtn.isSelected()) {
            if (!productionDateFrom.isBlank()
                    && FormatOutput.convertStringToLocalDate(productionDateFrom) == null) { //biên trái của nsx không hợp lệ
                JOptionPane.showMessageDialog(this, "Ngày sản xuất ở bộ lọc không hợp lệ!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                return false;
            } else if (!productionDateFrom.isBlank()
                    && productionDateTo.isBlank()) { //biên trái của nsx hợp lệ nhưng biên phải không hợp lệ
                JOptionPane.showMessageDialog(this, "Ngày sản xuất ở bộ lọc không hợp lệ!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                return false;
            }

            if (!productionDateTo.isBlank()
                    && FormatOutput.convertStringToLocalDate(productionDateTo) == null) { //biên phải của nsx không hợp lệ
                JOptionPane.showMessageDialog(this, "Ngày sản xuất ở bộ lọc không hợp lệ!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                return false;
            } else if (!productionDateTo.isBlank()
                    && productionDateFrom.isBlank()) { //biên phải của nsx hợp lệ nhưng biên trái không hợp lệ
                JOptionPane.showMessageDialog(this, "Ngày sản xuất ở bộ lọc không hợp lệ!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                return false;
            }

            if (!expirDateFrom.isBlank()
                    && FormatOutput.convertStringToLocalDate(expirDateFrom) == null) { //biên trái của nsx không hợp lệ
                JOptionPane.showMessageDialog(this, "Ngày hết hạn ở bộ lọc không hợp lệ!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                return false;
            } else if (!expirDateFrom.isBlank()
                    && expirDateTo.isBlank()) { //biên trái của nsx hợp lệ nhưng biên phải không hợp lệ
                JOptionPane.showMessageDialog(this, "Ngày hết hạn ở bộ lọc không hợp lệ!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                return false;
            }

            if (!expirDateTo.isBlank()
                    && FormatOutput.convertStringToLocalDate(expirDateTo) == null) { //biên phải của nsx không hợp lệ
                JOptionPane.showMessageDialog(this, "Ngày hết hạn ở bộ lọc không hợp lệ!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                return false;
            } else if (!expirDateTo.isBlank()
                    && expirDateFrom.isBlank()) { //biên phải của nsx hợp lệ nhưng biên trái không hợp lệ
                JOptionPane.showMessageDialog(this, "Ngày hết hạn ở bộ lọc không hợp lệ!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        }

        return true;
    }

    private void textFieldMouseClick(javax.swing.JTextField textField) {
        setDefaultOptionToTextField(textField);
        textField.setEditable(true);
    }

    private void setDefaultOptionToTextField(javax.swing.JTextField textField) {
        textField.setForeground(new java.awt.Color(0, 0, 0));
        textField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textField.setText("");
    }

    private void insertWarningToTextField(javax.swing.JTextField textField, String warningText) {
        textField.setForeground(new java.awt.Color(255, 0, 0));
        textField.setText(warningText);
        textField.setEditable(false);
    }

    private boolean isProductSatisfyFilters(Product product) {
        if (!product.getProductName()
                .toLowerCase()
                .contains(keyWordTextField.getText().trim().toLowerCase())) { // loc theo keysearch
            return false;
        }

        if (filterSwitchRadioBtn.isSelected()) { // loc theo gia
            if (priceRangeComboBox.getSelectedIndex() == 1
                    && product.getPrice() >= 100000) {
                return false;
            } else if (priceRangeComboBox.getSelectedIndex() == 2
                    && (product.getPrice() < 100000
                    || product.getPrice() > 300000)) {
                return false;
            } else if (priceRangeComboBox.getSelectedIndex() == 3
                    && (product.getPrice() < 300000
                    || product.getPrice() > 500000)) {
                return false;
            } else if (priceRangeComboBox.getSelectedIndex() == 4
                    && product.getPrice() <= 500000) {
                return false;
            }
        }

        return true;
    }

    private boolean isShipmentSatisfyFilters(Shipment shipment) {
        if (filterSwitchRadioBtn.isSelected()) {
            if (!productionDateFrom.isBlank()
                    && !productionDateTo.isBlank()) { // loc theo nsx
                if (shipment.getManufacturingDate() == null) {
                    return false;
                }
                if (FormatOutput.convertStringToLocalDate(productionDateFrom).isAfter(shipment.getManufacturingDate())
                        || FormatOutput.convertStringToLocalDate(productionDateTo).isBefore(shipment.getManufacturingDate())) {
                    return false;
                }
            }

            if (!expirDateFrom.isBlank()
                    && !expirDateTo.isBlank()) { // loc theo hsd
                if (shipment.getExpiryDate() == null) {
                    return false;
                }
                if (FormatOutput.convertStringToLocalDate(expirDateFrom).isAfter(shipment.getExpiryDate())
                        || FormatOutput.convertStringToLocalDate(expirDateTo).isBefore(shipment.getExpiryDate())) {
                    return false;
                }
            }
        }

        return true;
    }

    private void refreshProductTable() {
        productTableModel.setRowCount(0);

        this.store.getProducts().stream().forEach(product -> {
            List<Shipment> productShipments = product.getShipments();
            if (productShipments.isEmpty()
                    || !isProductSatisfyFilters(product)) {
                return;
            }
            int counter = 0;
            int len = productShipments.size();
            while(counter < len && !isShipmentSatisfyFilters(productShipments.get(counter))){
                counter++;
            }
            if(counter == len)return; //duyet het shipments nhung khong co cai nao thoa man

            Object[] rowData = {
                product.getProductCode(),
                product.getProductName(),
                product.getProvider(),
                product.getUnit(),
                FormatOutput.formatToMoneyAmountForm(product.getPrice() + ""),
                productShipments.get(counter).getShipmentId(),
                productShipments.get(counter).getManufacturingDate() != null
                ? FormatOutput.convertLocalDateToString(productShipments.get(counter).getManufacturingDate())
                : "-",
                productShipments.get(counter).getExpiryDate() != null
                ? FormatOutput.convertLocalDateToString(productShipments.get(counter).getExpiryDate())
                : "-",
                productShipments.get(counter).getQuantityInStock(),
                product.getProductId()
            };
            productTableModel.addRow(rowData);

            productShipments.stream().skip(counter + 1).forEach(shipment -> {
                if (!isShipmentSatisfyFilters(shipment)) {
                    return;
                }

                Object[] innerRowData = {
                    "",
                    "",
                    "",
                    "",
                    "",
                    shipment.getShipmentId(),
                    shipment.getManufacturingDate() != null
                    ? FormatOutput.convertLocalDateToString(shipment.getManufacturingDate())
                    : "-",
                    shipment.getExpiryDate() != null
                    ? FormatOutput.convertLocalDateToString(shipment.getExpiryDate())
                    : "-",
                    shipment.getQuantityInStock(),
                    product.getProductId()
                };
                productTableModel.addRow(innerRowData);
            });
        });

        productTable.getColumnModel().getColumn(9).setMaxWidth(0);
        productTable.getColumnModel().getColumn(9).setMinWidth(0);
        productTable.getColumnModel().getColumn(9).setPreferredWidth(0);
    }

    private void refreshInvoiceTable() {
        invoiceTableModel.setRowCount(0);

        this.invoice.getInvoiceProducts().stream().forEach(product -> {
            Object[] rowData = {
                product.getProductCode(),
                product.getProductName(),
                product.getUnit(),
                FormatOutput.formatToMoneyAmountForm(product.getPrice() + ""),
                product.getShipmentId(),
                product.getQuantity(),};
            invoiceTableModel.addRow(rowData);
        });
    }

    private void setDefaultValuesToComponentsInMainOrderFunctionPanel() {
        fromDateTextField.setText("");
        toDateTextField.setText("");
        keyWordTextField.setText("");
        quantityTextField.setText("");
        priceRangeComboBox.setSelectedIndex(0);
        filterSwitchRadioBtn.setSelected(false);
    }

    private void setDefaultValuesToComponentsInSubFeePanel() {
        paymentOptionCombobox.setSelectedIndex(0);
        customerMoneyText.setText("0");
        discountText.setText("0");
    }

    private void setDefaultValuesToComponentsInMainFeePanel() {
        subTotalTextField.setText("0");
        discountAmountTextField.setText("0");
        totalTextField.setText("0.0");
        changeAmountTextField.setText("0");
    }

    private void setDefaultValuesToAllComponents() {
        setDefaultValuesToComponentsInMainOrderFunctionPanel();
        setDefaultValuesToComponentsInSubFeePanel();
        setDefaultValuesToComponentsInMainFeePanel();
    }

    private void setEnableFilterPanel(boolean enable) {
        priceRangeLabel.setEnabled(enable);
        priceRangeComboBox.setEnabled(enable);
        productionDateRadioBtn.setEnabled(enable);
        expirDateRadioBtn.setEnabled(enable);
        fromLabel.setEnabled(enable);
        toLabel.setEnabled(enable);
        fromDateTextField.setEnabled(enable);
        toDateTextField.setEnabled(enable);
        filterBtn.setEnabled(enable);
    }

    private void setEnableToMainOrderFunctionPanel(boolean enable) {
        if (!enable) {
            setEnableFilterPanel(enable);
        }
        filterSwitchRadioBtn.setEnabled(enable);
        keyWordLabel.setEnabled(enable);
        keyWordTextField.setEnabled(enable);
        searchBtn.setEnabled(enable);
        quantityLabel.setEnabled(enable);
        quantityTextField.setEnabled(enable);
        addBtn.setEnabled(enable);
        removeBtn.setEnabled(enable);
        editBtn.setEnabled(enable);
        resetBtn.setEnabled(enable);
    }

    private void setEnableToSubFeePanel(boolean enable) {
        paymentOptionLabel.setEnabled(enable);
        paymentOptionCombobox.setEnabled(enable);
        customerMoneyLabel.setEnabled(enable);
        customerMoneyText.setEnabled(enable);
        discountLabel.setEnabled(enable);
        discountText.setEnabled(enable);
    }

    private void setEnableToMainFeePanel(boolean enable) {
        totalLabel.setEnabled(enable);
        totalTextField.setEnabled(enable);
        discountAmountLabel.setEnabled(enable);
        discountAmountTextField.setEnabled(enable);
        subTotalLabel.setEnabled(enable);
        subTotalTextField.setEnabled(enable);
        changeAmountLabel.setEnabled(enable);
        changeAmountTextField.setEnabled(enable);
        payBtn.setEnabled(enable);
        payAnfPrintBtn.setEnabled(enable);
    }

    public void setEnableToAllPanel(boolean enable) {
        setEnableToMainOrderFunctionPanel(enable);
        setEnableToSubFeePanel(enable);
        setEnableToMainFeePanel(enable);
        productTable.setEnabled(enable);
        invoiceTable.setEnabled(enable);
    }

    private void refreshMainFee() {
        subTotalTextField.setText(FormatOutput.formatToMoneyAmountForm(InvoiceUtil.getSubTotal(this.invoice)));
        discountAmountTextField.setText(FormatOutput.formatToMoneyAmountForm(InvoiceUtil.getDiscountAmount(this.invoice)));
        totalTextField.setText(FormatOutput.formatToMoneyAmountForm(InvoiceUtil.getTotal(this.invoice)));
        changeAmountTextField.setText(FormatOutput.formatToMoneyAmountForm(InvoiceUtil.getChange(this.invoice)));
    }

    private void initNewOrder() {
        invoice = Invoice.builder()
                .shift(this.shift)
                .invoiceProducts(new ArrayList<>())
                .paymentMethod(PaymentOption.CASH)
                .customerMoney(0)
                .build();
        // reset lại toàn bộ components theo order mới
        setDefaultValuesToAllComponents();
    }

    public void setup(HibernateConfig hibernateConfig, Store store) {
        this.store = store;
        this.hibernateConfig = hibernateConfig;
        this.invoiceDAO = new InvoiceDAOImpl();
        this.productDAO = new ProductDAOImpl();

        productScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        productScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        productTableModel = (DefaultTableModel) productTable.getModel();
        orderScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        orderScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        invoiceTableModel = (DefaultTableModel) invoiceTable.getModel();
    }

    public void refreshView(Shift shift) {
        if(this.shift == null || !shift.getShiftId().equals(this.shift.getShiftId())){
            this.shift = shift;
        }
        if (this.shift.getState().equals(ShiftState.OPENED) && this.invoice == null) {
            initNewOrder();
        }
        this.store.setProducts(productDAO.getProductsInStore(this.store.getStoreId(), this.hibernateConfig.getEntityManager()));
        refreshInvoiceTable();
        refreshProductTable();
        refreshMainFee();
    }

    private HibernateConfig hibernateConfig;
    private Store store;
    private Shift shift;
    private DefaultTableModel invoiceTableModel;
    private DefaultTableModel productTableModel;
    private InvoiceDAO invoiceDAO;
    private ProductDAO productDAO;

    private Invoice invoice;
    private Product selectedProduct;
    private InvoiceProduct selectedInvoiceProduct;
    private String productionDateFrom = "";
    private String productionDateTo = "";
    private String expirDateFrom = "";
    private String expirDateTo = "";

    private boolean discountWarningCheck = false;
    private boolean customerMoneyWarningCheck = false;

    private final String EMPTY_LIST_WARNING = "Danh sách trống!";
    private final String NOTHING_CHOOSEN_WARNING = "Bạn chưa chọn mặt hàng nào!";
    private final String EMPTY_TEXT_FIELD_WARNING = "Ô nhập Trống!";
    private final String INVALID_WARNING = "Không hợp lệ!";
    private final String NOT_ENOUGH_QUANTITY = "Không đủ số lượng!";
    private final String CHOOSE_IN_GOODSLIST_TABLE = "Chọn ở bảng hóa đơn!";
    private final String INSUFFICIENT_MONEY = "Số dư âm!";
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel aboutGoodsAndCusPanel;
    private javax.swing.JPanel aboutOrderPanel;
    private javax.swing.JButton addBtn;
    private javax.swing.JLabel changeAmountLabel;
    private javax.swing.JTextField changeAmountTextField;
    private javax.swing.JLabel customerMoneyLabel;
    private javax.swing.JTextField customerMoneyText;
    private javax.swing.JLabel discountAmountLabel;
    private javax.swing.JTextField discountAmountTextField;
    private javax.swing.JLabel discountLabel;
    private javax.swing.JTextField discountText;
    private javax.swing.JButton editBtn;
    private javax.swing.JRadioButton expirDateRadioBtn;
    private javax.swing.JPanel feePanel;
    private javax.swing.JButton filterBtn;
    private javax.swing.JRadioButton filterSwitchRadioBtn;
    private javax.swing.JTextField fromDateTextField;
    private javax.swing.JLabel fromLabel;
    private javax.swing.JPanel goodsPanel;
    private javax.swing.JTable invoiceTable;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel keyWordLabel;
    private javax.swing.JTextField keyWordTextField;
    private javax.swing.JPanel mainFeePanel;
    private javax.swing.JPanel mainOrderFunctionPanel;
    private javax.swing.JPanel orderDisplayPanel;
    private javax.swing.JScrollPane orderScrollPane;
    private javax.swing.JButton payAnfPrintBtn;
    private javax.swing.JButton payBtn;
    private javax.swing.JComboBox<String> paymentOptionCombobox;
    private javax.swing.JLabel paymentOptionLabel;
    private javax.swing.JComboBox<String> priceRangeComboBox;
    private javax.swing.JLabel priceRangeLabel;
    private javax.swing.ButtonGroup proAndExpirDateBtnGroup;
    private javax.swing.JScrollPane productScrollPane;
    private javax.swing.JTable productTable;
    private javax.swing.JRadioButton productionDateRadioBtn;
    private javax.swing.JLabel quantityLabel;
    private javax.swing.JTextField quantityTextField;
    private javax.swing.JButton removeBtn;
    private javax.swing.JButton resetBtn;
    private javax.swing.JButton searchBtn;
    private javax.swing.JPanel subFeePanel;
    private javax.swing.JLabel subTotalLabel;
    private javax.swing.JTextField subTotalTextField;
    private javax.swing.JTextField toDateTextField;
    private javax.swing.JLabel toLabel;
    private javax.swing.JLabel totalLabel;
    private javax.swing.JTextField totalTextField;
    // End of variables declaration//GEN-END:variables
}
