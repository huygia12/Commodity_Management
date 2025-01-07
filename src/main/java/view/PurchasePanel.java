package view;

import config.HibernateConfig;
import dao.InvoiceDAO;
import dao.impl.InvoiceDAOImpl;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
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
        setDefaultOptionToTextField(warningTextField, 12);
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
        warningTextField = new javax.swing.JTextField();
        orderDisplayPanel = new javax.swing.JPanel();
        mainOrderFunctionPanel = new javax.swing.JPanel();
        quantityTextField = new javax.swing.JTextField();
        quantityLabel = new javax.swing.JLabel();
        goodsIDTextField = new javax.swing.JTextField();
        addBtn = new javax.swing.JButton();
        removeBtn = new javax.swing.JButton();
        resetBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        shipmentIDLabel = new javax.swing.JLabel();
        fromLabel = new javax.swing.JLabel();
        toLabel = new javax.swing.JLabel();
        goodsIDLabel = new javax.swing.JLabel();
        shipmentIDTextField = new javax.swing.JTextField();
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
                "Mã SP", "Tên SP", "Nhà SX", "ĐV", "Giá Bán/ĐV", "Mã lô", "Ngày SX", "Hạn SD", "SL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        productTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        productTable.setMaximumSize(new java.awt.Dimension(700, 0));
        productTable.setMinimumSize(new java.awt.Dimension(675, 0));
        productTable.setShowGrid(true);
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
        paymentOptionCombobox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                paymentOptionComboboxItemStateChanged(evt);
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

        warningTextField.setEditable(false);
        warningTextField.setText(" ");
        warningTextField.setAutoscrolls(false);
        warningTextField.setBorder(null);

        javax.swing.GroupLayout mainFeePanelLayout = new javax.swing.GroupLayout(mainFeePanel);
        mainFeePanel.setLayout(mainFeePanelLayout);
        mainFeePanelLayout.setHorizontalGroup(
            mainFeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainFeePanelLayout.createSequentialGroup()
                .addGroup(mainFeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                    .addComponent(changeAmountTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(mainFeePanelLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(warningTextField)))
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
                .addGap(18, 18, 18)
                .addComponent(warningTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                .addGap(18, 18, 18)
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
        mainOrderFunctionPanel.add(quantityTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 120, 140, 40));

        quantityLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        quantityLabel.setText("Nhập Số Lượng:");
        mainOrderFunctionPanel.add(quantityLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, -1, 29));

        goodsIDTextField.setEditable(false);
        goodsIDTextField.setBackground(new java.awt.Color(255, 255, 255));
        goodsIDTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        goodsIDTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        mainOrderFunctionPanel.add(goodsIDTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(808, 10, 180, 33));

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
        mainOrderFunctionPanel.add(addBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 97, 85, 30));

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
        mainOrderFunctionPanel.add(removeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 97, 100, 30));

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
        mainOrderFunctionPanel.add(resetBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 130, 100, 30));

        editBtn.setBackground(new java.awt.Color(0, 255, 0));
        editBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        editBtn.setText("Sửa");
        editBtn.setPreferredSize(new java.awt.Dimension(7284, 27));
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });
        mainOrderFunctionPanel.add(editBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 130, 85, 30));

        shipmentIDLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        shipmentIDLabel.setText("Mã Lô:");
        mainOrderFunctionPanel.add(shipmentIDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 50, -1, 30));

        fromLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fromLabel.setText("Từ:");
        mainOrderFunctionPanel.add(fromLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 70, -1, -1));

        toLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        toLabel.setText("Đến:");
        mainOrderFunctionPanel.add(toLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 111, -1, -1));

        goodsIDLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        goodsIDLabel.setText("Mã SP:");
        mainOrderFunctionPanel.add(goodsIDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 10, -1, 30));

        shipmentIDTextField.setEditable(false);
        shipmentIDTextField.setBackground(new java.awt.Color(255, 255, 255));
        shipmentIDTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        shipmentIDTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        mainOrderFunctionPanel.add(shipmentIDTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(808, 50, 180, 32));

        priceRangeComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        priceRangeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Trống", "< 100.000", "100.000 - 300.000", "300.000 - 500.000", "> 500.000" }));
        priceRangeComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                priceRangeComboBoxItemStateChanged(evt);
            }
        });
        mainOrderFunctionPanel.add(priceRangeComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 8, 300, 43));

        priceRangeLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        priceRangeLabel.setText("Khoảng Giá:");
        mainOrderFunctionPanel.add(priceRangeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 8, -1, 43));

        keyWordLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        keyWordLabel.setText("Nhập từ khóa tìm kiếm : ");
        keyWordLabel.setAutoscrolls(true);
        keyWordLabel.setVerifyInputWhenFocusTarget(false);
        mainOrderFunctionPanel.add(keyWordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, -1, 14));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        mainOrderFunctionPanel.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(427, 0, 10, 170));

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
        mainOrderFunctionPanel.add(keyWordTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, 280, 38));

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
        mainOrderFunctionPanel.add(searchBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 70, 141, 31));

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

        fromDateTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fromDateTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fromDateTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fromDateTextFieldMouseClicked(evt);
            }
        });
        fromDateTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fromDateTextFieldKeyPressed(evt);
            }
        });
        mainOrderFunctionPanel.add(fromDateTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 61, 250, 35));

        toDateTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        toDateTextField.setPreferredSize(new java.awt.Dimension(64, 26));
        toDateTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                toDateTextFieldMouseClicked(evt);
            }
        });
        toDateTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                toDateTextFieldKeyPressed(evt);
            }
        });
        mainOrderFunctionPanel.add(toDateTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 101, 250, 36));

        filterBtn.setBackground(new java.awt.Color(0, 255, 0));
        filterBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        filterBtn.setText("Lọc");
        filterBtn.setPreferredSize(new java.awt.Dimension(104, 27));
        filterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterBtnActionPerformed(evt);
            }
        });
        mainOrderFunctionPanel.add(filterBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 150, -1));

        filterSwitchRadioBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        filterSwitchRadioBtn.setText("Bật Bộ Lọc");
        filterSwitchRadioBtn.setRolloverEnabled(false);
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
        setDefaultOptionToTextField(warningTextField, 12);
        int selectedRow = productTable.getSelectedRow();
        if (selectedRow == -1) {
            return;
        }

        String shipmentId = (String) productTableModel.getValueAt(selectedRow, 5);
        Long productId = Long.valueOf((String) productTable.getValueAt(selectedRow, 9));
        this.selectedProduct = ProductUtil.getProductFrom(productId, this.productList);

        if (this.selectedProduct == null) {
            JOptionPane.showMessageDialog(this, "Sản phẩm không tồn tại!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        shipmentIDTextField.setText(shipmentId);
        keyWordTextField.setText(this.selectedProduct.getProductName());
        goodsIDTextField.setText(this.selectedProduct.getProductCode());
    }//GEN-LAST:event_productTableMouseClicked

    private void invoiceTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invoiceTableMouseClicked
        int selectedRow = invoiceTable.getSelectedRow();
        if (selectedRow == -1) {
            return;
        }

        String shipmentID = (String) invoiceTableModel.getValueAt(selectedRow, 4);
        this.selectedInvoiceProduct = InvoiceUtil.getInvoiceProductFrom(Long.valueOf(shipmentID), this.invoice);

        if (this.selectedInvoiceProduct == null) {
            JOptionPane.showMessageDialog(this, "Sản phẩm không tồn tại trong giỏ hàng!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        shipmentIDTextField.setText(shipmentID);
        keyWordTextField.setText(this.selectedInvoiceProduct.getProductName());
        goodsIDTextField.setText(this.selectedInvoiceProduct.getProductId().toString());
        quantityTextField.setText(String.format("%d", this.selectedInvoiceProduct.getQuantity()));
    }//GEN-LAST:event_invoiceTableMouseClicked

    private void customerMoneyTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerMoneyTextMouseClicked
        if (!customerMoneyWarningCheck) {
            textFieldMouseClick(customerMoneyText, 12);
            return;
        }
        if (customerMoneyText.getText().length() > (customerMoneyText.getSize().getWidth() / 11)) {
            JOptionPane.showMessageDialog(mainFeePanel, feePanel, expirDateTo, HEIGHT, new ImageIcon());
        }
    }//GEN-LAST:event_customerMoneyTextMouseClicked

    private void discountTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_discountTextMouseClicked
        if (!discountWarningCheck) {
            textFieldMouseClick(discountText, 12);
        }
    }//GEN-LAST:event_discountTextMouseClicked

    private void customerMoneyTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_customerMoneyTextKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER
                && invoice.getPaymentMethod().equals(PaymentOption.CASH)) {
            String customerMoneyStr = customerMoneyText.getText();
            if (customerMoneyStr.isBlank()) { // kiểm tra xem textField có trống không
                insertWarningToTextField(customerMoneyText, EMPTY_TEXT_FIELD_WARNING, 12);
                customerMoneyWarningCheck = false;
                return;
            } else if (!ValidateInput.checkIfAValidNumberForGUI(customerMoneyStr)) {// kiểm tra xem có phải số hợp lệ hay không
                insertWarningToTextField(customerMoneyText, INVALID_WARNING, 12);
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
            if (!ValidateInput.checkIfAValidNumberForGUI(discountStr) && !discountStr.isBlank()) {// kiểm tra xem có phải số hợp lệ hay không
                discountWarningCheck = false;
                insertWarningToTextField(discountText, INVALID_WARNING, 12);
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

    private void paymentOptionComboboxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_paymentOptionComboboxItemStateChanged
        boolean editable = true;
        // nếu order là chuyển khoản hoặc thẻ thì không cho nhập customerMoney nữa
        if (paymentOptionCombobox.getSelectedIndex() != 0) {
            invoice.setPaymentMethod(PaymentOption.OTHER);
            editable = false;
        } else {
            invoice.setPaymentMethod(PaymentOption.CASH);
        }
        setDefaultOptionToTextField(customerMoneyText, 12);
        customerMoneyText.setText((invoice.getPaymentMethod() == PaymentOption.CASH) ? "0" : "");
        customerMoneyText.setEditable(editable);
        refreshMainFee();
    }//GEN-LAST:event_paymentOptionComboboxItemStateChanged

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
            } else if (!ValidateInput.checkIfAValidNumberForGUI(customerMoneyStr)) {// kiểm tra xem có phải số hợp lệ hay không
                customerMoneyWarningCheck = false;
                insertWarningToTextField(customerMoneyText, INVALID_WARNING, 12);
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
        if (!ValidateInput.checkIfAValidNumberForGUI(discountStr) && !discountStr.isBlank()) {// kiểm tra xem có phải số hợp lệ hay không
            discountWarningCheck = false;
            insertWarningToTextField(discountText, INVALID_WARNING, 12);
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
        setDefaultOptionToTextField(warningTextField, 12);
        String keyString = keyWordTextField.getText().trim();
        // Kiểm tra điều kiện
        if (this.productList.isEmpty()) {
            insertWarningToTextField(warningTextField, EMPTY_LIST_WARNING, 12);
            return;
        }
        this.searchString = keyString;
        refreshProductTable();
    }//GEN-LAST:event_searchBtnActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        setDefaultOptionToTextField(warningTextField, 12);
        String shipmentId = shipmentIDTextField.getText().trim();
        String quantityAsStr = quantityTextField.getText().trim();
        // kiểm tra điều kiện
        if (shipmentId.isBlank()) { // kiểm tra xem shipment text field có trống không
            insertWarningToTextField(warningTextField, NOTHING_CHOOSEN_WARNING, 12);
            return;
        } else if (selectedInvoiceProduct == null) {// kiểm tra xem có chọn đúng bảng không
            insertWarningToTextField(warningTextField, CHOOSE_IN_GOODSLIST_TABLE, 12);
            return;
        } else if (quantityAsStr.isBlank()) { // kiểm tra xem ô số lượng có trống không
            insertWarningToTextField(quantityTextField, EMPTY_TEXT_FIELD_WARNING, 14);
            return;
        } else if (!ValidateInput.checkIfANumberSequenceForGUI(quantityAsStr)) { // kiểm tra xem có phải là số hợp lệ không
            insertWarningToTextField(quantityTextField, INVALID_WARNING, 14);
            return;
        }

        InvoiceProduct invoiceProduct = InvoiceUtil.getInvoiceProductFrom(Long.valueOf((String)shipmentId), this.invoice);
        int quantityAsInteger = Integer.parseInt(quantityAsStr);
        Product product = ProductUtil.getProductFrom(invoiceProduct.getProductId(), this.productList);
        Shipment shipment = ShipmentUtil.getShipmentFrom(Long.valueOf(shipmentId), product);

        if (ShipmentUtil.isInStock(shipment, invoiceProduct.getQuantity() + quantityAsInteger)) {
            insertWarningToTextField(quantityTextField, NOT_ENOUGH_QUANTITY, 14);
            return;
        }
        // thực hiện chức năng
        InvoiceUtil.updateInvoiceProductQuantity(this.invoice, quantityAsInteger, Long.valueOf(shipmentId));

        setDefaultValuesToComponentsInMainOrderFunctionPanel();
        displayInvoice(this.invoice.getInvoiceProducts());
        refreshMainFee();
    }//GEN-LAST:event_editBtnActionPerformed

    private void resetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBtnActionPerformed
        this.selectedInvoiceProduct = null;
        this.invoice.getInvoiceProducts().clear();

        setDefaultValuesToComponentsInMainFeePanel();
        invoiceTableModel.setRowCount(0);
    }//GEN-LAST:event_resetBtnActionPerformed

    private void removeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeBtnActionPerformed
        setDefaultOptionToTextField(warningTextField, 12);
        String shipmentId = shipmentIDTextField.getText().trim();
        // Kiểm tra điều kiện
        if (shipmentId.isBlank()) {// Kiểm tra xem đã chọn hay chưa
            insertWarningToTextField(warningTextField, NOTHING_CHOOSEN_WARNING, 12);
            return;
        } else if (this.selectedInvoiceProduct == null) { // kiểm tra xem có chọn đúng bảng hay không
            insertWarningToTextField(warningTextField, CHOOSE_IN_GOODSLIST_TABLE, 12);
            return;
        }
        // thực hiện chức năng
        InvoiceUtil.removeInvoiceProduct(this.invoice, Long.valueOf(shipmentId));

        setDefaultValuesToComponentsInMainOrderFunctionPanel();
        displayInvoice(this.invoice.getInvoiceProducts());
        refreshProductTable();
        refreshMainFee();
    }//GEN-LAST:event_removeBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        setDefaultOptionToTextField(warningTextField, 12);
        String shipmentId = shipmentIDTextField.getText().trim();
        String quantity = quantityTextField.getText().trim();
        // kiểm tra điều kiện
        if (shipmentId.isBlank() || this.selectedProduct == null) { // kiểm tra xem shipmentID textField có trống không
            insertWarningToTextField(warningTextField, NOTHING_CHOOSEN_WARNING, 12);
            return;
        } else if (quantity.isBlank()) {// kiểm tra xem quantity có trống không
            insertWarningToTextField(quantityTextField, EMPTY_TEXT_FIELD_WARNING, 14);
            return;
        } else if (!ValidateInput.checkIfANumberSequenceForGUI(quantity)) {// kiểm tra xem có phải số hợp lệ hay không
            insertWarningToTextField(quantityTextField, INVALID_WARNING, 14);
            return;
        } else if (ValidateInput.checkIfNumberEqualZero(new BigDecimal(quantity))) {
            insertWarningToTextField(quantityTextField, INVALID_WARNING, 14);
            return;
        }

        int quantityInInteger = Integer.parseInt(quantity);
        Shipment addedShipment = ShipmentUtil.getShipmentFrom(Long.valueOf(shipmentId), this.selectedProduct);
        if (!ShipmentUtil.isInStock(addedShipment, quantityInInteger)) {
            insertWarningToTextField(quantityTextField, NOT_ENOUGH_QUANTITY, 14);
            return;
        }

        // thực hiện chức năng
        InvoiceUtil.addInvoiceProduct(this.invoice, this.selectedProduct, quantityInInteger, addedShipment);

        setDefaultValuesToComponentsInMainOrderFunctionPanel();
        displayInvoice(this.invoice.getInvoiceProducts());
        refreshMainFee();
    }//GEN-LAST:event_addBtnActionPerformed

    private void quantityTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityTextFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            addBtnActionPerformed(null);
        }
    }//GEN-LAST:event_quantityTextFieldKeyPressed

    private void quantityTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quantityTextFieldMouseClicked
        textFieldMouseClick(quantityTextField, 14);
    }//GEN-LAST:event_quantityTextFieldMouseClicked

    private void priceRangeComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_priceRangeComboBoxItemStateChanged
        int selectedIndex = priceRangeComboBox.getSelectedIndex();
        rangeFilterCheck = (selectedIndex != 0) && (selectedIndex != -1);
    }//GEN-LAST:event_priceRangeComboBoxItemStateChanged

    private void productionDateRadioBtnItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_productionDateRadioBtnItemStateChanged
        fromDateTextField.setEditable(true);
        toDateTextField.setEditable(true);
        if (productionDateRadioBtn.isSelected()) {
            setDefaultOptionToTextField(fromDateTextField, 14);
            setDefaultOptionToTextField(toDateTextField, 14);
            fromDateTextField.setText(productionDateFrom);
            toDateTextField.setText(productionDateTo);
        }
    }//GEN-LAST:event_productionDateRadioBtnItemStateChanged

    private void fromDateTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fromDateTextFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String fromDateStr = fromDateTextField.getText();
            if (productionDateRadioBtn.isSelected()) {
                if (!fromDateStr.isBlank() && !ValidateInput.checkIfValidDate(fromDateStr)) {// kiểm tra dateString có hợp lệ không
                    insertWarningToTextField(fromDateTextField, INVALID_WARNING, 12);
                    productionDateFromValid = false;
                    productionDateFrom = "";
                    return;
                }
                productionDateFrom = fromDateStr;
                productionDateFromValid = true;
            } else if (expirDateRadioBtn.isSelected()) {
                if (!fromDateStr.isBlank() && !ValidateInput.checkIfValidDate(fromDateStr)) {// kiểm tra dateString có hợp lệ không
                    insertWarningToTextField(fromDateTextField, INVALID_WARNING, 12);
                    expirationDateFromValid = false;
                    expirDateFrom = "";
                    return;
                }
                expirDateFrom = fromDateStr;
                expirationDateFromValid = true;
            }
        }
    }//GEN-LAST:event_fromDateTextFieldKeyPressed

    private void toDateTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_toDateTextFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String toDateStr = toDateTextField.getText();
            if (productionDateRadioBtn.isSelected()) {
                if (!toDateStr.isBlank() && !ValidateInput.checkIfValidDate(toDateStr)) {// kiểm tra dateString có hợp lệ không
                    insertWarningToTextField(toDateTextField, INVALID_WARNING, 12);
                    productionDateToValid = false;
                    productionDateTo = "";
                    return;
                }
                productionDateTo = toDateStr;
                productionDateToValid = true;
            } else if (expirDateRadioBtn.isSelected()) {
                if (!toDateStr.isBlank() && !ValidateInput.checkIfValidDate(toDateStr)) {// kiểm tra dateString có hợp lệ không
                    insertWarningToTextField(toDateTextField, INVALID_WARNING, 12);
                    expirationDateToValid = false;
                    expirDateTo = "";
                    return;
                }
                expirDateTo = toDateStr;
                expirationDateToValid = true;
            }
        }
    }//GEN-LAST:event_toDateTextFieldKeyPressed

    private void expirDateRadioBtnItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_expirDateRadioBtnItemStateChanged
        fromDateTextField.setEditable(true);
        toDateTextField.setEditable(true);
        if (expirDateRadioBtn.isSelected()) {
            setDefaultOptionToTextField(fromDateTextField, 14);
            setDefaultOptionToTextField(toDateTextField, 14);
            fromDateTextField.setText(expirDateFrom);
            toDateTextField.setText(expirDateTo);
        }
    }//GEN-LAST:event_expirDateRadioBtnItemStateChanged

    private void fromDateTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fromDateTextFieldMouseClicked
        if (productionDateRadioBtn.isSelected()) {
            if (!productionDateFromValid) {
                textFieldMouseClick(fromDateTextField, 14);
            }
        } else if (expirDateRadioBtn.isSelected()) {
            if (!expirationDateFromValid) {
                textFieldMouseClick(fromDateTextField, 14);
            }
        }
    }//GEN-LAST:event_fromDateTextFieldMouseClicked

    private void toDateTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toDateTextFieldMouseClicked
        if (productionDateRadioBtn.isSelected()) {
            if (!productionDateToValid) {
                textFieldMouseClick(toDateTextField, 14);
            }
        } else if (expirDateRadioBtn.isSelected()) {
            if (!expirationDateToValid) {
                textFieldMouseClick(toDateTextField, 14);
            }
        }
    }//GEN-LAST:event_toDateTextFieldMouseClicked

    private void filterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterBtnActionPerformed
//        filterGoodsList = orderCtr.makeDraftGoodsList(draftGoodsList);
//        if (rangeFilterCheck) {
//            String selectedRange = priceRangeComboBox.getSelectedItem().toString();
//            CustomPair priceRange = settingsCtr.convertFromComparisonOperatorToRange(selectedRange);
//            filterGoodsList = new FilterGoodsList(filterGoodsList)
//                    .withinPriceRange((BigDecimal) priceRange.getK(), (BigDecimal) priceRange.getV());
//        }
//        if (unitFilterCheck) {
//            String selectedUnit = unitComboBox.getSelectedItem().toString();
//            filterGoodsList = new FilterGoodsList(filterGoodsList).withSameUnit(selectedUnit);
//        }
//        if (productionDateFromValid
//                && productionDateToValid
//                && !fromDateTextField.getText().isBlank()
//                && !toDateTextField.getText().isBlank()) {
//            productionDateFrom = fromDateTextField.getText();
//            productionDateTo = toDateTextField.getText();
//            if (ctions.checkIfDateIsBeforeAnotherDate(productionDateFrom, productionDateTo)) {
//                filterGoodsList = new FilterGoodsList(filterGoodsList)
//                        .withinProductionDateRange(
//                                LocalDate.parse(productionDateFrom, DateTimeFormatter.ofPattern(INPUT_DATE_PATTERN)),
//                                LocalDate.parse(productionDateTo, DateTimeFormatter.ofPattern(INPUT_DATE_PATTERN)));
//                productionDateFromValid = true;
//                productionDateToValid = true;
//            } else {
//                if (!ctions.checkIfValidDate(productionDateFrom)) {// kiểm tra dateString có hợp lệ không
//                    productionDateRadioBtn.setSelected(true);
//                    insertWarningToTextField(fromDateTextField, INVALID_WARNING, 12);
//                    productionDateFromValid = false;
//                    productionDateFrom = "";
//                }
//                if (!ctions.checkIfValidDate(productionDateTo)) {// kiểm tra dateString có hợp lệ không
//                    productionDateRadioBtn.setSelected(true);
//                    insertWarningToTextField(toDateTextField, INVALID_WARNING, 12);
//                    productionDateToValid = false;
//                    productionDateTo = "";
//                }
//                return;
//            }
//        }
//        if (expirationDateFromValid
//                && expirationDateToValid
//                && !fromDateTextField.getText().isBlank()
//                && !toDateTextField.getText().isBlank()) {
//            expirDateFrom = fromDateTextField.getText();
//            expirDateTo = toDateTextField.getText();
//            if (ctions.checkIfDateIsBeforeAnotherDate(expirDateFrom, expirDateTo)) {
//                filterGoodsList = new FilterGoodsList(filterGoodsList)
//                        .withinExpirDateRange(
//                                LocalDate.parse(expirDateFrom, DateTimeFormatter.ofPattern(INPUT_DATE_PATTERN)),
//                                LocalDate.parse(expirDateTo, DateTimeFormatter.ofPattern(INPUT_DATE_PATTERN)));
//                expirationDateFromValid = true;
//                expirationDateToValid = true;
//            } else {
//                if (!ctions.checkIfValidDate(expirDateFrom)) {// kiểm tra dateString có hợp lệ không
//                    expirDateRadioBtn.setSelected(true);
//                    insertWarningToTextField(fromDateTextField, INVALID_WARNING, 12);
//                    expirationDateFromValid = false;
//                    expirDateFrom = "";
//                }
//                if (!ctions.checkIfValidDate(expirDateTo)) {// kiểm tra dateString có hợp lệ không
//                    expirDateRadioBtn.setSelected(true);
//                    insertWarningToTextField(toDateTextField, INVALID_WARNING, 12);
//                    expirationDateToValid = false;
//                    expirDateTo = "";
//                }
//                return;
//            }
//        }
//        refreshProductTable(filterGoodsList);
    }//GEN-LAST:event_filterBtnActionPerformed

    private void filterSwitchRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterSwitchRadioBtnActionPerformed
        if (filterSwitchRadioBtn.isSelected()) {
            setEnableFilterPanel(true);
        } else {
            setEnableFilterPanel(false);
        }
    }//GEN-LAST:event_filterSwitchRadioBtnActionPerformed

    private void payBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payBtnActionPerformed
        setDefaultOptionToTextField(warningTextField, 12);
        // xét các điều kiện
        if (this.invoice.getInvoiceProducts().isEmpty()) { // Kiểm tra xem đã chọn sản phẩm nào chưa
            insertWarningToTextField(warningTextField, NOTHING_CHOOSEN_WARNING, 12);
            return;
        } else if (InvoiceUtil.isInsufficient(this.invoice)) {
            insertWarningToTextField(customerMoneyText, INSUFFICIENT_MONEY, 12);
            customerMoneyWarningCheck = false;
            return;
        }
        // thực hiện chức năng
        this.invoice.setShift(this.shift);
        invoiceDAO.addInvoice(this.invoice, this.hibernateConfig.getEntityManager());
        
        initNewOrder();
    }//GEN-LAST:event_payBtnActionPerformed

    private void payAnfPrintBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payAnfPrintBtnActionPerformed
        setDefaultOptionToTextField(warningTextField, 12);
        // xét các điều kiện
        if (this.invoice.getInvoiceProducts().isEmpty()) { // Kiểm tra xem đã chọn sản phẩm nào chưa
            insertWarningToTextField(warningTextField, NOTHING_CHOOSEN_WARNING, 12);
            return;
        } else if (InvoiceUtil.isInsufficient(this.invoice)) { //Kiểm tra xem có thiếu tiền kh
            insertWarningToTextField(customerMoneyText, INSUFFICIENT_MONEY, 12);
            customerMoneyWarningCheck = false;
            return;
        }
        // thực hiện chức năng
        this.invoice.setShift(this.shift);
        invoiceDAO.addInvoice(this.invoice, this.hibernateConfig.getEntityManager());

        PrinterUtil.exportBillToTxtFile(this.invoice, this.store);
        initNewOrder();
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

    private void textFieldMouseClick(javax.swing.JTextField textField, int size) {
        setDefaultOptionToTextField(textField, size);
        textField.setEditable(true);
    }

    private void setDefaultOptionToTextField(javax.swing.JTextField textField, int size) {
        textField.setFont(new java.awt.Font("Segoe UI", 0, size)); // NOI18N
        textField.setForeground(new java.awt.Color(0, 0, 0));
        textField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textField.setText("");
    }

    private void insertWarningToTextField(javax.swing.JTextField textField, String warningText, int size) {
        textField.setFont(new java.awt.Font("Segoe UI", 2, size));
        textField.setForeground(new java.awt.Color(255, 0, 0));
        textField.setText(warningText);
        textField.setEditable(false);
    }

    private void refreshProductTable() {
        productTableModel.setRowCount(0);

        if (productTableModel.getColumnCount() == 9) {
            productTableModel.addColumn("ProductId");
        }
        productList.stream().forEach(product -> {
            List<Shipment> productShipments = product.getShipments();
            if (productShipments.isEmpty()) {
                return;
            }
            
            if(!product.getProductName()
                    .toLowerCase()
                    .contains(this.searchString.toLowerCase())) return;

            Object[] rowData = {
                product.getProductCode(),
                product.getProductName(),
                product.getProvider(),
                product.getUnit(),
                product.getPrice(),
                productShipments.get(0).getShipmentId(),
                productShipments.get(0).getManufacturingDate() != null
                ? FormatOutput.convertLocalDateToString(productShipments.get(0).getManufacturingDate())
                : "_",
                productShipments.get(0).getExpiryDate() != null
                ? FormatOutput.convertLocalDateToString(productShipments.get(0).getExpiryDate())
                : "_",
                productShipments.get(0).getQuantityInStock(),
                product.getProductId()
            };
            productTableModel.addRow(rowData);

            productShipments.stream().skip(1).forEach(shipment -> {
                Object[] innerRowData = {
                    "",
                    "",
                    "",
                    "",
                    "",
                    shipment.getManufacturingDate() != null
                    ? FormatOutput.convertLocalDateToString(productShipments.get(0).getManufacturingDate())
                    : "_",
                    shipment.getExpiryDate() != null
                    ? FormatOutput.convertLocalDateToString(productShipments.get(0).getExpiryDate())
                    : "_",
                    shipment.getQuantityInStock(),
                    product.getProductId()
                };
                productTableModel.addRow(innerRowData);
            });
        });

        productTable.getColumn(9).setMaxWidth(0);
        productTable.getColumn(9).setMinWidth(0);
        productTable.getColumn(9).setPreferredWidth(0);
    }

    private void displayInvoice(List<InvoiceProduct> orderProducts) {
        invoiceTableModel.setRowCount(0);

        orderProducts.stream().forEach(product -> {
            Object[] rowData = {
                product.getProductCode(),
                product.getProductName(),
                product.getUnit(),
                product.getPrice(),
                product.getShipmentId(),
                product.getQuantity(),};
            invoiceTableModel.addRow(rowData);
        });
    }

    private void setDefaultValuesToComponentsInMainOrderFunctionPanel() {
        fromDateTextField.setText("");
        toDateTextField.setText("");
        keyWordTextField.setText("");
        goodsIDTextField.setText("");
        shipmentIDTextField.setText("");
        quantityTextField.setText("");
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
        goodsIDLabel.setEnabled(enable);
        goodsIDTextField.setEnabled(enable);
        shipmentIDLabel.setEnabled(enable);
        shipmentIDTextField.setEnabled(enable);
        addBtn.setEnabled(enable);
        removeBtn.setEnabled(enable);
        editBtn.setEnabled(enable);
        resetBtn.setEnabled(enable);
        warningTextField.setEnabled(enable);
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
        subTotalTextField.setText(InvoiceUtil.getSubTotal(this.invoice));
        discountAmountTextField.setText(InvoiceUtil.getDiscountAmount(this.invoice));
        totalTextField.setText(InvoiceUtil.getTotal(this.invoice));
        changeAmountTextField.setText(InvoiceUtil.getChange(this.invoice));
    }

    private void initNewOrder() {
        invoice = new Invoice();
        // reset lại toàn bộ components theo order mới
        setDefaultValuesToAllComponents();
    }

    public void setup(HibernateConfig hibernateConfig, Store store, Shift shift) {
        this.store = store;
        this.shift = shift;
        this.hibernateConfig = hibernateConfig;
        this.invoiceDAO = new InvoiceDAOImpl();
        this.productList = this.store.getProducts();

        productScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        productScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        productTableModel = (DefaultTableModel) productTable.getModel();
        orderScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        orderScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        invoiceTableModel = (DefaultTableModel) invoiceTable.getModel();
    }

    public void refreshView() {
        if (this.shift.getState().equals(ShiftState.OPENED) && this.invoice == null) {
            initNewOrder();
        }
        productList = this.store.getProducts();
        displayInvoice(this.invoice.getInvoiceProducts());
        refreshProductTable();
        refreshMainFee();
    }

    private HibernateConfig hibernateConfig;
    private Store store;
    private Shift shift;
    private DefaultTableModel invoiceTableModel;
    private DefaultTableModel productTableModel;
    private InvoiceDAO invoiceDAO;

    private List<Product> productList;
    private Invoice invoice;
    private Product selectedProduct;
    private InvoiceProduct selectedInvoiceProduct;
    
    private String searchString;
    private String productionDateFrom;
    private String productionDateTo;
    private String expirDateFrom;
    private String expirDateTo;
    private boolean rangeFilterCheck = false;
    private boolean productionDateFromValid = true;
    private boolean productionDateToValid = true;
    private boolean expirationDateFromValid = false;
    private boolean expirationDateToValid = false;
    private boolean discountWarningCheck = false;
    private boolean customerMoneyWarningCheck = false;

    final String INPUT_DATE_PATTERN = "d/M/y";
    private final String EMPTY_LIST_WARNING = "Danh sách trống!";
    private final String NOTHING_FOUND_WARNING = "Không tìm thấy từ khóa!";
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
    private javax.swing.JLabel goodsIDLabel;
    private javax.swing.JTextField goodsIDTextField;
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
    private javax.swing.JLabel shipmentIDLabel;
    private javax.swing.JTextField shipmentIDTextField;
    private javax.swing.JPanel subFeePanel;
    private javax.swing.JLabel subTotalLabel;
    private javax.swing.JTextField subTotalTextField;
    private javax.swing.JTextField toDateTextField;
    private javax.swing.JLabel toLabel;
    private javax.swing.JLabel totalLabel;
    private javax.swing.JTextField totalTextField;
    private javax.swing.JTextField warningTextField;
    // End of variables declaration//GEN-END:variables
}
