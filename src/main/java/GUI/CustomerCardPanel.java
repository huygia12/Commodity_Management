/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import Controllers.CustomerCardListController;
import Models.Customer;
import Models.CustomerCard;
import Models.CustomerCardList;
import Models.Gender;
import Models.History;
import Ultility.Cautions;
import Ultility.IDGenerator;
import java.math.BigInteger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Chi Cute
 */
public class CustomerCardPanel extends javax.swing.JPanel {

    /**
     * Creates new form CustomerCardPanel
     */
    public CustomerCardPanel() {
        initComponents();
        customerModel = (DefaultTableModel) customerTable.getModel();
    }

    private boolean checkString(String str) {
        if (str.isBlank()) {
            return false;
        }
        return true;
    }

    private boolean checkInteger(String str) {
        if (str.isBlank()) {
            return false;
        } else if (cautions.checkIfANumberSequenceForGUI(str)) {
            return true;
        }
        return false;
    }

    private boolean checkDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean checkInputPayment() {
        if (!checkInteger(copperPay.getText())) {
            return false;
        }

        if (!checkInteger(silvePay.getText())) {
            return false;
        }

        if (!checkInteger(goldenPay.getText())) {
            return false;
        }

        if (!checkInteger(diamondPay.getText())) {
            return false;
        }
        return true;
    }

    private boolean checkInputCondition() {
        if (!checkInteger(copperCondition.getText())) {
            return false;
        }

        if (!checkInteger(silveCondition.getText())) {
            return false;
        }

        if (!checkInteger(goldenCondition.getText())) {
            return false;
        }

        if (!checkInteger(diamondCondition.getText())) {
            return false;
        }
        return true;
    }

    private boolean checkInputDiscount() {
        if (!checkDouble(copperDiscount.getText())) {
            return false;
        }

        if (!checkDouble(silveDiscount.getText())) {
            return false;
        }

        if (!checkDouble(goldenDiscount.getText())) {
            return false;
        }

        if (!checkDouble(diamondDiscount.getText())) {
            return false;
        }
        return true;
    }

    private void createNewMemberCard() {
        CustomerCard newCard = new CustomerCard();
        newCard.setID(idGenerator.generateID(CustomerCard.class.getName(), 6));
        Gender newCustomerGender = castStringToGender(memberGenderComboBox.getSelectedItem().toString());
        newCard.setCustomer(new Customer(
                memberFirstNameTextField.getText(),
                memberLastNameTextField.getText(),
                memberPhoneNumberTextField.getText(),
                memberAddressTextPane.getText(),
                Integer.parseInt(memberAgeTextField.getText()),
                newCustomerGender));
        customerCardList.getList().add(newCard);
    }

    private Gender castStringToGender(String str) {
        switch (str) {
            case "Nam":
                return Gender.MALE;
            case "Khác":
                return Gender.OTHER;
        }
        return Gender.FEMALE;
    }

    private String valueOfGenderEnum(Gender g) {
        switch (g) {
            case MALE:
                return "Nam";
            case FEMALE:
                return "Nữ";
        }
        return "Khác";
    }

    private void addAllCustomerCardToTable() {
        clearTableModel(customerModel);
        for (int i = 0; i < customerCardList.getList().size(); i++) {
            addNewCustomerCardToTable(customerCardList.getList().get(i));
        }
    }

    private void addNewCustomerCardToTable(CustomerCard customerCard) {
        String customerGender = valueOfGenderEnum(customerCard.getCustomer().getGender());
        customerModel.addRow(new Object[]{
            customerCard.getID(),
            customerCard.getCustomer().getFirstName(),
            customerCard.getCustomer().getLastName(),
            customerCard.getCustomer().getAge(),
            customerGender,
            customerCard.getCustomer().getPhoneNumber(),
            customerCard.getCustomer().getAddress()
        });
    }

    private void clearTableModel(DefaultTableModel tableModel) {
        int numberOfRow = tableModel.getRowCount();
        for (int i = 0; i < numberOfRow; i++) {
            tableModel.removeRow(0);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel20 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        CustomerInforPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        memberCardIDTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        memberAddressTextPane = new javax.swing.JTextPane();
        DeleteCardButton = new javax.swing.JButton();
        UpdateCustomerDateButton = new javax.swing.JButton();
        CardInforPanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        memberTotalPayTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        memberUsagePointTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        memberUsedPointTextField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        memberCardRankTextField = new javax.swing.JTextField();
        needMore = new javax.swing.JLabel();
        toNextRank = new javax.swing.JLabel();
        morePayToNextRank = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        memberFirstNameTextField = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        memberLastNameTextField = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        memberAgeTextField = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        memberPhoneNumberTextField = new javax.swing.JTextField();
        memberGenderComboBox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        CreateNewCardButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        ToolsPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        SearchTextField = new javax.swing.JTextField();
        SearchButton = new javax.swing.JButton();
        ShowCardListButton = new javax.swing.JButton();
        MainPanel = new javax.swing.JPanel();
        CustomerCardTable = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        customerTable = new javax.swing.JTable();
        searchResultQuantity = new javax.swing.JLabel();
        totalQuantity = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        copperCondition = new javax.swing.JTextField();
        copperDiscount = new javax.swing.JTextField();
        copperPay = new javax.swing.JTextField();
        silveCondition = new javax.swing.JTextField();
        silveDiscount = new javax.swing.JTextField();
        silvePay = new javax.swing.JTextField();
        goldenCondition = new javax.swing.JTextField();
        goldenDiscount = new javax.swing.JTextField();
        goldenPay = new javax.swing.JTextField();
        diamondCondition = new javax.swing.JTextField();
        diamondDiscount = new javax.swing.JTextField();
        diamondPay = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        changePolicyButton = new javax.swing.JButton();
        agreeWithNewPolicy = new javax.swing.JButton();
        cancelPolicyChange = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();

        jLabel20.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel20.setText("Bạc");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(153, 153, 153));
        jLabel25.setText("(từ 30M)");

        jLabel18.setText("VNĐ");

        setPreferredSize(new java.awt.Dimension(970, 560));
        setLayout(new java.awt.BorderLayout());

        CustomerInforPanel.setBackground(new java.awt.Color(255, 255, 255));
        CustomerInforPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin khách hàng", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        jLabel1.setText("Mã khách/Mã thẻ:");

        memberCardIDTextField.setEditable(false);
        memberCardIDTextField.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        memberCardIDTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        memberCardIDTextField.setFocusable(false);

        jLabel6.setText("Địa chỉ:");

        memberAddressTextPane.setPreferredSize(new java.awt.Dimension(62, 48));
        jScrollPane1.setViewportView(memberAddressTextPane);

        DeleteCardButton.setBackground(new java.awt.Color(255, 51, 0));
        DeleteCardButton.setForeground(new java.awt.Color(255, 255, 255));
        DeleteCardButton.setText("XÓA THẺ");
        DeleteCardButton.setFocusable(false);
        DeleteCardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteCardButtonActionPerformed(evt);
            }
        });

        UpdateCustomerDateButton.setBackground(new java.awt.Color(153, 255, 0));
        UpdateCustomerDateButton.setText("CẬP NHẬT");
        UpdateCustomerDateButton.setFocusable(false);
        UpdateCustomerDateButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UpdateCustomerDateButtonMouseClicked(evt);
            }
        });
        UpdateCustomerDateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateCustomerDateButtonActionPerformed(evt);
            }
        });

        CardInforPanel.setBackground(new java.awt.Color(255, 255, 255));
        CardInforPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin thẻ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        jLabel7.setText("Điểm khả dụng:");

        memberTotalPayTextField.setEditable(false);
        memberTotalPayTextField.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        memberTotalPayTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        memberTotalPayTextField.setFocusable(false);
        memberTotalPayTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memberTotalPayTextFieldActionPerformed(evt);
            }
        });

        jLabel8.setText("Điểm đã quy đổi:");

        memberUsagePointTextField.setEditable(false);
        memberUsagePointTextField.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        memberUsagePointTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        memberUsagePointTextField.setFocusable(false);
        memberUsagePointTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memberUsagePointTextFieldActionPerformed(evt);
            }
        });

        jLabel9.setText("Tổng chi tiêu:");

        memberUsedPointTextField.setEditable(false);
        memberUsedPointTextField.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        memberUsedPointTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        memberUsedPointTextField.setFocusable(false);
        memberUsedPointTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memberUsedPointTextFieldActionPerformed(evt);
            }
        });

        jLabel10.setText("Thứ hạng thẻ:");

        memberCardRankTextField.setEditable(false);
        memberCardRankTextField.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        memberCardRankTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        memberCardRankTextField.setFocusable(false);
        memberCardRankTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memberCardRankTextFieldActionPerformed(evt);
            }
        });

        needMore.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        needMore.setForeground(new java.awt.Color(153, 153, 153));
        needMore.setText("Chi tiêu thêm");

        toNextRank.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        toNextRank.setForeground(new java.awt.Color(153, 153, 153));
        toNextRank.setText("để lên thứ hạng tiếp theo");

        morePayToNextRank.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        morePayToNextRank.setForeground(new java.awt.Color(153, 153, 153));
        morePayToNextRank.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        morePayToNextRank.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout CardInforPanelLayout = new javax.swing.GroupLayout(CardInforPanel);
        CardInforPanel.setLayout(CardInforPanelLayout);
        CardInforPanelLayout.setHorizontalGroup(
            CardInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CardInforPanelLayout.createSequentialGroup()
                .addGroup(CardInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CardInforPanelLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(CardInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(10, 10, 10)
                        .addGroup(CardInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(memberUsedPointTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                            .addComponent(memberTotalPayTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(memberCardRankTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(memberUsagePointTextField))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(CardInforPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(needMore)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(morePayToNextRank, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(toNextRank)))
                .addContainerGap())
        );
        CardInforPanelLayout.setVerticalGroup(
            CardInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CardInforPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(CardInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(memberUsagePointTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(CardInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(memberUsedPointTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(CardInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(memberTotalPayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(CardInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(memberCardRankTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(CardInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CardInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(needMore)
                        .addComponent(toNextRank))
                    .addComponent(morePayToNextRank, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jLabel36.setText("Họ:");

        memberFirstNameTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel37.setText("Tên:");

        memberLastNameTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel38.setText("Tuổi:");

        memberAgeTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel39.setText("SĐT:");

        memberPhoneNumberTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        memberGenderComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", "Khác" }));

        jLabel3.setText("Giới tính:");

        CreateNewCardButton.setBackground(new java.awt.Color(153, 255, 255));
        CreateNewCardButton.setText("TẠO THẺ");
        CreateNewCardButton.setFocusable(false);
        CreateNewCardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateNewCardButtonActionPerformed(evt);
            }
        });

        refreshButton.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        refreshButton.setForeground(new java.awt.Color(0, 153, 255));
        refreshButton.setText("Làm mới");
        refreshButton.setBorderPainted(false);
        refreshButton.setContentAreaFilled(false);
        refreshButton.setFocusPainted(false);
        refreshButton.setFocusable(false);
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CustomerInforPanelLayout = new javax.swing.GroupLayout(CustomerInforPanel);
        CustomerInforPanel.setLayout(CustomerInforPanelLayout);
        CustomerInforPanelLayout.setHorizontalGroup(
            CustomerInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CardInforPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CustomerInforPanelLayout.createSequentialGroup()
                .addGroup(CustomerInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(CustomerInforPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6))
                    .addGroup(CustomerInforPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(CustomerInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(CustomerInforPanelLayout.createSequentialGroup()
                                .addGroup(CustomerInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel38)
                                    .addComponent(jLabel39)
                                    .addComponent(jLabel36))
                                .addGap(12, 12, 12)
                                .addGroup(CustomerInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(CustomerInforPanelLayout.createSequentialGroup()
                                        .addComponent(memberAgeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(19, 19, 19)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(memberGenderComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(CustomerInforPanelLayout.createSequentialGroup()
                                        .addComponent(memberPhoneNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(CustomerInforPanelLayout.createSequentialGroup()
                                        .addComponent(memberFirstNameTextField)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel37)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(memberLastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, CustomerInforPanelLayout.createSequentialGroup()
                                .addGroup(CustomerInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, CustomerInforPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(memberCardIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(refreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, CustomerInforPanelLayout.createSequentialGroup()
                                        .addComponent(DeleteCardButton)
                                        .addGap(18, 18, 18)
                                        .addComponent(CreateNewCardButton)
                                        .addGap(18, 18, 18)
                                        .addComponent(UpdateCustomerDateButton)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        CustomerInforPanelLayout.setVerticalGroup(
            CustomerInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CustomerInforPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(CustomerInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(memberCardIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(refreshButton))
                .addGap(18, 18, 18)
                .addGroup(CustomerInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(memberFirstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37)
                    .addComponent(memberLastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(CustomerInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CustomerInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(memberGenderComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CustomerInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel38)
                        .addComponent(memberAgeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(CustomerInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(memberPhoneNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(CustomerInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(CustomerInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DeleteCardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CreateNewCardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UpdateCustomerDateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(CardInforPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(CustomerInforPanel, java.awt.BorderLayout.LINE_END);

        jPanel6.setLayout(new java.awt.BorderLayout());

        ToolsPanel.setBackground(new java.awt.Color(255, 255, 255));
        ToolsPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("ID/SĐT/Tên khách hàng:");
        ToolsPanel.add(jLabel4);

        SearchTextField.setPreferredSize(new java.awt.Dimension(160, 26));
        ToolsPanel.add(SearchTextField);

        SearchButton.setBackground(new java.awt.Color(153, 255, 255));
        SearchButton.setText("Tìm kiếm");
        SearchButton.setFocusable(false);
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });
        ToolsPanel.add(SearchButton);

        ShowCardListButton.setBackground(new java.awt.Color(153, 255, 255));
        ShowCardListButton.setText("Hiển thị toàn bộ danh sách");
        ShowCardListButton.setFocusable(false);
        ShowCardListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowCardListButtonActionPerformed(evt);
            }
        });
        ToolsPanel.add(ShowCardListButton);

        jPanel6.add(ToolsPanel, java.awt.BorderLayout.PAGE_START);

        MainPanel.setBackground(new java.awt.Color(255, 255, 255));
        MainPanel.setPreferredSize(new java.awt.Dimension(652, 557));

        CustomerCardTable.setBackground(new java.awt.Color(255, 255, 255));

        customerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã khách/Mã thẻ", "Họ", "Tên", "Tuổi", "Giới tính", "SĐT", "Địa chỉ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        customerTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        customerTable.setFocusable(false);
        customerTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customerTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(customerTable);

        searchResultQuantity.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        searchResultQuantity.setForeground(new java.awt.Color(0, 153, 255));

        totalQuantity.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        totalQuantity.setForeground(new java.awt.Color(0, 153, 255));
        totalQuantity.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout CustomerCardTableLayout = new javax.swing.GroupLayout(CustomerCardTable);
        CustomerCardTable.setLayout(CustomerCardTableLayout);
        CustomerCardTableLayout.setHorizontalGroup(
            CustomerCardTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CustomerCardTableLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CustomerCardTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
                    .addGroup(CustomerCardTableLayout.createSequentialGroup()
                        .addComponent(searchResultQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(totalQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        CustomerCardTableLayout.setVerticalGroup(
            CustomerCardTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CustomerCardTableLayout.createSequentialGroup()
                .addGroup(CustomerCardTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchResultQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
                    .addComponent(totalQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cài đặt chính sách", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        jLabel2.setText("Tổng chi tiêu tối thiểu:");

        jLabel5.setText("Ưu đãi giảm giá:");

        jLabel11.setText("Điều kiện nhận ưu đãi:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 102, 0));
        jLabel12.setText("Đồng");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(153, 153, 153));
        jLabel13.setText("Bạc");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 204, 0));
        jLabel14.setText("Vàng");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(153, 255, 255));
        jLabel15.setText("Kim cương");

        copperCondition.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        copperCondition.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        copperCondition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copperConditionActionPerformed(evt);
            }
        });

        copperDiscount.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        copperDiscount.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        copperPay.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        copperPay.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        silveCondition.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        silveCondition.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        silveDiscount.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        silveDiscount.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        silvePay.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        silvePay.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        goldenCondition.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        goldenCondition.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        goldenDiscount.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        goldenDiscount.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        goldenPay.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        goldenPay.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        diamondCondition.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        diamondCondition.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        diamondDiscount.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        diamondDiscount.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        diamondPay.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        diamondPay.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel16.setText("VNĐ");

        jLabel17.setText("VNĐ");

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("%");

        changePolicyButton.setBackground(new java.awt.Color(153, 255, 255));
        changePolicyButton.setText("CHỈNH SỬA CHÍNH SÁCH");
        changePolicyButton.setFocusable(false);
        changePolicyButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changePolicyButtonMouseClicked(evt);
            }
        });
        changePolicyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePolicyButtonActionPerformed(evt);
            }
        });

        agreeWithNewPolicy.setBackground(new java.awt.Color(153, 255, 0));
        agreeWithNewPolicy.setText("ĐỒNG Ý");
        agreeWithNewPolicy.setFocusable(false);
        agreeWithNewPolicy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agreeWithNewPolicyActionPerformed(evt);
            }
        });

        cancelPolicyChange.setBackground(new java.awt.Color(255, 51, 0));
        cancelPolicyChange.setForeground(new java.awt.Color(255, 255, 255));
        cancelPolicyChange.setText("HỦY");
        cancelPolicyChange.setFocusable(false);
        cancelPolicyChange.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelPolicyChangeMouseClicked(evt);
            }
        });
        cancelPolicyChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelPolicyChangeActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(153, 153, 153));
        jLabel21.setText("(Áp dụng cho HĐ đạt giá trị tối thiểu)");

        jLabel22.setText("(Gồm ưu đãi của thứ hạng liền trước và thứ hạng hiện tại)");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(copperDiscount, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                            .addComponent(copperPay, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(silveDiscount, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                            .addComponent(silvePay, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(goldenDiscount, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                            .addComponent(goldenPay, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(diamondDiscount, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                            .addComponent(diamondPay, javax.swing.GroupLayout.Alignment.LEADING)))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(silveCondition, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(17, 17, 17)
                                        .addComponent(goldenCondition, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(diamondCondition, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(2, 2, 2)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel16)))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addComponent(jLabel22))))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(copperCondition, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(234, 234, 234))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addGap(288, 288, 288)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel12)
                        .addGap(80, 80, 80)
                        .addComponent(jLabel13)
                        .addGap(75, 75, 75)
                        .addComponent(jLabel14)
                        .addGap(57, 57, 57)
                        .addComponent(jLabel15)
                        .addGap(44, 44, 44))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(changePolicyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(agreeWithNewPolicy)
                        .addGap(18, 18, 18)
                        .addComponent(cancelPolicyChange, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(copperPay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(copperDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(silvePay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(silveDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(goldenPay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(goldenDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(diamondPay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(diamondDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(diamondCondition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(goldenCondition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(silveCondition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(copperCondition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelPolicyChange, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(agreeWithNewPolicy, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(changePolicyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CustomerCardTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CustomerCardTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.add(MainPanel, java.awt.BorderLayout.CENTER);

        add(jPanel6, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void DeleteCardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteCardButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = customerTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(CustomerCardPanel.this,
                    "Bạn chưa chọn khách hàng!");
            return;
        } else {
            int response = JOptionPane.showConfirmDialog(CustomerCardPanel.this,
                    "Bạn muốn xóa thẻ?",
                    "Xác nhận",
                    JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                customerModel.removeRow(selectedRow);
                customerCardList.getList().remove(selectedRow);
                resetMemberCardValue();
                setSearchResult();
            } else {
                return;
            }
        }

    }//GEN-LAST:event_DeleteCardButtonActionPerformed

    private void setPolicy(boolean b) {
        copperPay.setEditable(b);
        copperDiscount.setEditable(b);
        copperCondition.setEditable(b);
        silveCondition.setEditable(b);
        silvePay.setEditable(b);
        silveDiscount.setEditable(b);
        goldenCondition.setEditable(b);
        goldenDiscount.setEditable(b);
        goldenPay.setEditable(b);
        diamondCondition.setEditable(b);
        diamondDiscount.setEditable(b);
        diamondPay.setEditable(b);
        agreeWithNewPolicy.setEnabled(b);
        cancelPolicyChange.setEnabled(b);
    }

    private void setPolicy(String cp, String cd, String cc,
            String sp, String sd, String sc,
            String gp, String gd, String gc,
            String dp, String dc, String dd) {
        copperPay.setText(cp);
        copperCondition.setText(cc);
        copperDiscount.setText(cd);
        silveCondition.setText(sc);
        silveDiscount.setText(sd);
        silvePay.setText(sp);
        goldenCondition.setText(gc);
        goldenDiscount.setText(gd);
        goldenPay.setText(gp);
        diamondCondition.setText(dc);
        diamondDiscount.setText(dd);
        diamondPay.setText(dp);
    }

    private void resetMemberCardValue() {
        memberAddressTextPane.setText("");
        memberAgeTextField.setText("");
        memberCardIDTextField.setText("");
        memberFirstNameTextField.setText("");
        memberGenderComboBox.setSelectedIndex(0);
        memberLastNameTextField.setText("");
        memberPhoneNumberTextField.setText("");
        memberUsagePointTextField.setText("");
        memberTotalPayTextField.setText("");
        memberUsedPointTextField.setText("");
        memberCardRankTextField.setText("");
        setVisibleNeedPay(false);
    }

    private boolean checkInformation(String firstName, String lastName, String age, String phone, String address) {
        if (!(checkString(firstName) || checkString(lastName))) {
            JOptionPane.showMessageDialog(CustomerCardPanel.this,
                    "Thông tin họ tên không hợp lệ!\nVui lòng thử lại.",
                    "Đăng kí thất bại!",
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (!checkInteger(age)) {
            JOptionPane.showMessageDialog(CustomerCardPanel.this,
                    "Thông tin tuổi không hợp lệ!\nVui lòng thử lại.",
                    "Đăng kí thất bại!",
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (!checkPhoneNumber(phone)) {
            JOptionPane.showMessageDialog(CustomerCardPanel.this,
                    "Thông tin số điện thoại không hợp lệ!\nVui lòng thử lại.",
                    "Đăng kí thất bại!",
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (!checkString(address)) {
            JOptionPane.showMessageDialog(CustomerCardPanel.this,
                    "Thông tin địa chỉ không hợp lệ!\nVui lòng thử lại.",
                    "Đăng kí thất bại!",
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    private void CreateNewCardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateNewCardButtonActionPerformed
        // TODO add your handling code here:
        if (checkInformation(
                memberFirstNameTextField.getText(),
                memberLastNameTextField.getText(),
                memberAgeTextField.getText(),
                memberPhoneNumberTextField.getText(),
                memberAddressTextPane.getText())) {
            if (existedPhoneNumber(memberPhoneNumberTextField.getText())) {
                JOptionPane.showMessageDialog(CustomerCardPanel.this,
                        "Số điện thoại đã được đăng kí!");
                return;
            }
            JOptionPane.showMessageDialog(CustomerCardPanel.this,
                    "Đăng kí thành công!");
            createNewMemberCard();
            resetMemberCardValue();
            addAllCustomerCardToTable();
        }
    }//GEN-LAST:event_CreateNewCardButtonActionPerformed

    private void ShowCardListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowCardListButtonActionPerformed
        // TODO add your handling code here:
        SearchTextField.setText("");
        resetMemberCardValue();
        searchResultQuantity.setText("");
        if (customerCardList.getList().isEmpty()) {
            JOptionPane.showMessageDialog(CustomerCardPanel.this,
                    "Danh sách trống!");
        } else {
            clearTableModel(customerModel);
            addAllCustomerCardToTable();
        }
    }//GEN-LAST:event_ShowCardListButtonActionPerformed

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed

        String searchingKey = SearchTextField.getText().toLowerCase();
        boolean found = false;
        if (searchingKey.isBlank()) {
            return;
        } else {
            if (customerCardList.getList().isEmpty()) {
                JOptionPane.showMessageDialog(CustomerCardPanel.this,
                        "Danh sách trống!");
            } else {
                clearTableModel(customerModel);
                for (int i = 0; i < customerCardList.getList().size(); i++) {
                    if (customerCardList.getList().get(i).getID().equals(searchingKey)
                            || customerCardList.getList().get(i).getCustomer().getFirstName().toLowerCase().contains(searchingKey)
                            || customerCardList.getList().get(i).getCustomer().getLastName().toLowerCase().contains(searchingKey)) {
                        CustomerCard card = customerCardList.getList().get(i);
                        addNewCustomerCardToTable(card);
                        setSearchResult();
                        found = true;
                    }
                }
                if (!found) {
                    setSearchResult();
                    JOptionPane.showMessageDialog(CustomerCardPanel.this,
                            "Không tìm thấy!");
                    SearchTextField.setText("");
                } else {
                }
            }
        }
    }//GEN-LAST:event_SearchButtonActionPerformed

    private String cardRank(BigInteger pay) {
        int copper = pay.compareTo(BigInteger.valueOf(10000000));
        int silve = pay.compareTo(BigInteger.valueOf(30000000));
        int golden = pay.compareTo(BigInteger.valueOf(70000000));

        if (copper == -1) {
            return "Đồng";
        } else if (silve == -1) {
            return "Bạc";
        } else if (golden == -1) {
            return "Vàng";
        }
        return "Kim Cương";
    }

    private void setSearchResult() {
        searchResultQuantity.setText("Kết quả phù hợp: " + customerModel.getRowCount());
    }

    private void setVisibleNeedPay(boolean b) {
        needMore.setVisible(b);
        toNextRank.setVisible(b);
        morePayToNextRank.setVisible(b);
    }

    private boolean checkPhoneNumber(String str) {
        if (str.isBlank()) {
            return false;
        } else {
            String reg = "^(0|\\+84)(\\s|\\.)?((3[0-9])|(5[0-9])|(7[0-9])|(8[0-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
            if (!str.matches(reg)) {
                return false;
            }
        }
        return true;
    }

    private void showPoint() {

        long copperPay, silvePay, goldenPay;
        copperPay = Long.parseLong(this.copperPay.getText());
        silvePay = Long.parseLong(this.silvePay.getText());
        goldenPay = Long.parseLong(this.goldenPay.getText());

        int rowIndex = customerTable.getSelectedRow();

        CustomerCard cc = customerCardList.getList().get(rowIndex);
        BigInteger usedPoint = BigInteger.valueOf(0);
        BigInteger pay = BigInteger.valueOf(0);
        BigInteger usagePoint = cc.getPoint().subtract(usedPoint);
        String rank = cardRank(cc.getPoint());
        BigInteger needPay;

        memberCardRankTextField.setText(rank);
        memberUsagePointTextField.setText(usagePoint.toString());
        memberUsedPointTextField.setText(usedPoint.toString());
        memberTotalPayTextField.setText(pay.toString());

        switch (rank) {
            case "Đồng":
                needPay = BigInteger.valueOf(copperPay).subtract(pay);
                morePayToNextRank.setText(needPay.toString());
                setVisibleNeedPay(true);
                break;
            case "Bạc":
                needPay = BigInteger.valueOf(silvePay).subtract(pay);
                morePayToNextRank.setText(needPay.toString());
                setVisibleNeedPay(true);
                break;
            case "Vàng":
                needPay = BigInteger.valueOf(goldenPay).subtract(pay);
                morePayToNextRank.setText(needPay.toString());
                setVisibleNeedPay(true);
                break;
            case "Kim Cương":
                setVisibleNeedPay(false);
        }
    }

    private void customerTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerTableMouseClicked
        // TODO add your handling code here:
        int rowIndex = customerTable.getSelectedRow();

        memberCardIDTextField.setText(customerModel.getValueAt(rowIndex, 0).toString());
        memberFirstNameTextField.setText(customerModel.getValueAt(rowIndex, 1).toString());
        memberLastNameTextField.setText(customerModel.getValueAt(rowIndex, 2).toString());
        memberAgeTextField.setText(customerModel.getValueAt(rowIndex, 3).toString());
        memberGenderComboBox.setSelectedItem(customerModel.getValueAt(rowIndex, 4).toString());
        memberPhoneNumberTextField.setText(customerModel.getValueAt(rowIndex, 5).toString());
        memberAddressTextPane.setText(customerModel.getValueAt(rowIndex, 6).toString());

        showPoint();

    }//GEN-LAST:event_customerTableMouseClicked

    private boolean existedPhoneNumber(String str) {
        for (int i = 0; i < customerCardList.getList().size(); i++) {
            if (str.equals(customerCardList.getList().get(i).getCustomer().getPhoneNumber())) {
                return true;
            }
        }
        return false;
    }

    private void UpdateCustomerDateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateCustomerDateButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = customerTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(CustomerCardPanel.this,
                    "Bạn chưa chọn khách hàng!");
        } else {
            String firstName = memberFirstNameTextField.getText();
            String lastName = memberLastNameTextField.getText();
            String ageStr = memberAgeTextField.getText();
            String genderStr = memberGenderComboBox.getSelectedItem().toString();
            Gender genderEnum = castStringToGender(genderStr);
            String phoneNo = memberPhoneNumberTextField.getText();
            String address = memberAddressTextPane.getText();

            int age = Integer.parseInt(ageStr);
            if (firstName.equalsIgnoreCase(customerCardList.getList().get(selectedRow).getCustomer().getFirstName())
                    && lastName.equalsIgnoreCase(customerCardList.getList().get(selectedRow).getCustomer().getLastName())
                    && age == customerCardList.getList().get(selectedRow).getCustomer().getAge()
                    && genderEnum.equals(customerCardList.getList().get(selectedRow).getCustomer().getGender())
                    && phoneNo.equals(customerCardList.getList().get(selectedRow).getCustomer().getPhoneNumber())
                    && address.equals(customerCardList.getList().get(selectedRow).getCustomer().getAddress())) {
                JOptionPane.showMessageDialog(CustomerCardPanel.this,
                        "Bạn chưa thay đổi bất kì thông tin nào!");
                return;
            }
            if (checkInformation(firstName, lastName, ageStr, phoneNo, address)) {
                String phone = customerCardList.getList().get(selectedRow).getCustomer().getPhoneNumber();
                customerCardList.getList().get(selectedRow).getCustomer().setPhoneNumber("0000000000");
                if (existedPhoneNumber(phoneNo)) {
                    JOptionPane.showMessageDialog(CustomerCardPanel.this,
                            "Số điện thoại đã được đăng kí!");
                    customerCardList.getList().get(selectedRow).getCustomer().setPhoneNumber(phone);
                    memberPhoneNumberTextField.setText("");
                    return;
                }
                int response = JOptionPane.showConfirmDialog(CustomerCardPanel.this,
                        "Bạn muốn thay đổi thông tin khách hàng?",
                        "Xác nhận",
                        JOptionPane.YES_NO_OPTION);

                if (response == JOptionPane.YES_OPTION) {
                    customerCardList.getList().get(selectedRow).getCustomer().setFirstName(firstName);
                    customerCardList.getList().get(selectedRow).getCustomer().setLastName(lastName);
                    customerCardList.getList().get(selectedRow).getCustomer().setAge(age);
                    customerCardList.getList().get(selectedRow).getCustomer().setGender(genderEnum);
                    customerCardList.getList().get(selectedRow).getCustomer().setPhoneNumber(phoneNo);
                    customerCardList.getList().get(selectedRow).getCustomer().setAddress(address);
                    addAllCustomerCardToTable();
                    resetMemberCardValue();
                }

            }
        }
    }//GEN-LAST:event_UpdateCustomerDateButtonActionPerformed

    private void UpdateCustomerDateButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateCustomerDateButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateCustomerDateButtonMouseClicked

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        // TODO add your handling code here:
        resetMemberCardValue();
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void memberCardRankTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memberCardRankTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_memberCardRankTextFieldActionPerformed

    private void memberUsedPointTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memberUsedPointTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_memberUsedPointTextFieldActionPerformed

    private void memberUsagePointTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memberUsagePointTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_memberUsagePointTextFieldActionPerformed

    private void memberTotalPayTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memberTotalPayTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_memberTotalPayTextFieldActionPerformed

    private void copperConditionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copperConditionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_copperConditionActionPerformed

    private void changePolicyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePolicyButtonActionPerformed
        // TODO add your handling code here:
        setPolicy(true);

    }//GEN-LAST:event_changePolicyButtonActionPerformed

    private void agreeWithNewPolicyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agreeWithNewPolicyActionPerformed
        // TODO add your handling code here:
        boolean check = true;
        if (!checkInputPayment()) {
            JOptionPane.showMessageDialog(CustomerCardPanel.this,
                    "Thông tin <Chi tiêu tối thiểu> phải là một số nguyên.",
                    "Không hợp lệ!",
                    JOptionPane.WARNING_MESSAGE);
            check = false;
            return;
        }
        if (!checkInputCondition()) {
            JOptionPane.showMessageDialog(CustomerCardPanel.this,
                    "Thông tin <Điều kiện nhận ưu đãi> phải là một số nguyên.",
                    "Không hợp lệ!",
                    JOptionPane.WARNING_MESSAGE);
            check = false;
            return;
        }
        if (!checkInputDiscount()) {
            JOptionPane.showMessageDialog(CustomerCardPanel.this,
                    "Thông tin <Ưu đãi giảm giá> phải là một số.",
                    "Không hợp lệ!",
                    JOptionPane.WARNING_MESSAGE);
            check = false;
            return;
        }
        if (check) {
            int response = JOptionPane.showConfirmDialog(CustomerCardPanel.this,
                    "Bạn có chắc muốn thay đổi chính sách ưu đãi?",
                    "Xác nhận thao tác",
                    JOptionPane.YES_NO_OPTION);

            if (response == JOptionPane.YES_OPTION) {
                getPolicy();
                setPolicy(String.valueOf(Long.parseLong(copperPayment)),
                        String.valueOf(Double.parseDouble(copperDis)),
                        String.valueOf(Long.parseLong(copperCon)),
                        String.valueOf(Long.parseLong(silvePayment)),
                        String.valueOf(Double.parseDouble(silveDis)),
                        String.valueOf(Long.parseLong(silveCon)),
                        String.valueOf(Long.parseLong(goldenPayment)),
                        String.valueOf(Double.parseDouble(goldenDis)),
                        String.valueOf(Long.parseLong(goldenCon)),
                        String.valueOf(Long.parseLong(diamondPayment)),
                        String.valueOf(Long.parseLong(diamondCon)),
                        String.valueOf(Double.parseDouble(diamondDis)));
                setPolicy(false);
                JOptionPane.showMessageDialog(CustomerCardPanel.this,
                        "Thay đổi chính sách ưu đãi thành công!");
            }
        }
    }//GEN-LAST:event_agreeWithNewPolicyActionPerformed

    private void cancelPolicyChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelPolicyChangeActionPerformed
        // TODO add your handling code here:
        int response = JOptionPane.showConfirmDialog(CustomerCardPanel.this,
                "Bạn có chắc muốn hủy thao tác?",
                "Xác nhận thao tác",
                JOptionPane.YES_NO_OPTION);

        if (response == JOptionPane.YES_OPTION) {
            setPolicy(copperPayment, copperDis, copperCon,
                    silvePayment, silveDis, silveCon,
                    goldenPayment, goldenDis, goldenCon,
                    diamondPayment, diamondCon, diamondDis);
            setPolicy(false);
        }
    }//GEN-LAST:event_cancelPolicyChangeActionPerformed

    private void cancelPolicyChangeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelPolicyChangeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelPolicyChangeMouseClicked

    private void changePolicyButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changePolicyButtonMouseClicked
        // TODO add your handling code here:
        getPolicy();
    }//GEN-LAST:event_changePolicyButtonMouseClicked

    private void getPolicy() {
        copperCon = copperCondition.getText();
        copperDis = copperDiscount.getText();
        copperPayment = copperPay.getText();
        silveCon = silveCondition.getText();
        silveDis = silveDiscount.getText();
        silvePayment = silvePay.getText();
        goldenCon = goldenCondition.getText();
        goldenDis = goldenDiscount.getText();
        goldenPayment = goldenPay.getText();
        diamondCon = diamondCondition.getText();
        diamondDis = diamondDiscount.getText();
        diamondPayment = diamondPay.getText();
    }

    public void passData(CustomerCardList customerCardList, IDGenerator idGenerator, History history) {
        this.customerCardList = customerCardList;
        this.idGenerator = idGenerator;
        this.history = history;
        addAllCustomerCardToTable();
        setVisibleNeedPay(false);
        totalQuantity.setText(String.valueOf("Tổng số: " + customerCardList.getList().size()));
        setPolicy(false);
        setPolicy("0", "0.0", "0",
                "0", "0.0", "0",
                "0", "0.0", "0",
                "0", "0", "0.0");
    }
    private CustomerCardList customerCardList;
    private IDGenerator idGenerator;
    private History history;
    private Cautions cautions = new Cautions();
    private DefaultTableModel customerModel;
    private CustomerCardListController customerCardListCtl;
    private String copperPayment;
    private String copperDis;
    private String copperCon;
    private String silvePayment;
    private String silveDis;
    private String silveCon;
    private String goldenPayment;
    private String goldenDis;
    private String goldenCon;
    private String diamondPayment;
    private String diamondDis;
    private String diamondCon;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CardInforPanel;
    private javax.swing.JButton CreateNewCardButton;
    private javax.swing.JPanel CustomerCardTable;
    private javax.swing.JPanel CustomerInforPanel;
    private javax.swing.JButton DeleteCardButton;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JButton SearchButton;
    private javax.swing.JTextField SearchTextField;
    private javax.swing.JButton ShowCardListButton;
    private javax.swing.JPanel ToolsPanel;
    private javax.swing.JButton UpdateCustomerDateButton;
    private javax.swing.JButton agreeWithNewPolicy;
    private javax.swing.JButton cancelPolicyChange;
    private javax.swing.JButton changePolicyButton;
    private javax.swing.JTextField copperCondition;
    private javax.swing.JTextField copperDiscount;
    private javax.swing.JTextField copperPay;
    private javax.swing.JTable customerTable;
    private javax.swing.JTextField diamondCondition;
    private javax.swing.JTextField diamondDiscount;
    private javax.swing.JTextField diamondPay;
    private javax.swing.JTextField goldenCondition;
    private javax.swing.JTextField goldenDiscount;
    private javax.swing.JTextField goldenPay;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane memberAddressTextPane;
    private javax.swing.JTextField memberAgeTextField;
    private javax.swing.JTextField memberCardIDTextField;
    private javax.swing.JTextField memberCardRankTextField;
    private javax.swing.JTextField memberFirstNameTextField;
    private javax.swing.JComboBox<String> memberGenderComboBox;
    private javax.swing.JTextField memberLastNameTextField;
    private javax.swing.JTextField memberPhoneNumberTextField;
    private javax.swing.JTextField memberTotalPayTextField;
    private javax.swing.JTextField memberUsagePointTextField;
    private javax.swing.JTextField memberUsedPointTextField;
    private javax.swing.JLabel morePayToNextRank;
    private javax.swing.JLabel needMore;
    private javax.swing.JButton refreshButton;
    private javax.swing.JLabel searchResultQuantity;
    private javax.swing.JTextField silveCondition;
    private javax.swing.JTextField silveDiscount;
    private javax.swing.JTextField silvePay;
    private javax.swing.JLabel toNextRank;
    private javax.swing.JLabel totalQuantity;
    // End of variables declaration//GEN-END:variables
}
