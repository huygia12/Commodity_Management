/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import Models.Store;
import Models.StoreShortedCut;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author FPTSHOP
 */
public class SettingsPanel extends javax.swing.JPanel {

    /**
     * Creates new form SettingsPanel
     */
    public SettingsPanel() {
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

        inputchangeInfoPanel = new javax.swing.JPanel();
        inputchangeInfoStorePanel = new javax.swing.JPanel();
        inputNameLabel = new javax.swing.JLabel();
        inputPhoneNumberLabel = new javax.swing.JLabel();
        inputAndressLabel = new javax.swing.JLabel();
        inputEmailLabel = new javax.swing.JLabel();
        inputNameTextField = new javax.swing.JTextField();
        inputPhoneNumberTextField = new javax.swing.JTextField();
        inputEmailTextField = new javax.swing.JTextField();
        changeInfoButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        inputAndressTextPane = new javax.swing.JTextPane();
        inputchangeScorePanel = new javax.swing.JPanel();
        amountForOnePointLabel = new javax.swing.JLabel();
        pointsForOneVNDLabel = new javax.swing.JLabel();
        pointsForOneVNDTextField = new javax.swing.JTextField();
        amountForOnePointTextField = new javax.swing.JTextField();
        inputchangeScoreButton = new javax.swing.JButton();
        settingIntroductionPanel = new javax.swing.JPanel();

        setMinimumSize(new java.awt.Dimension(1015, 670));
        setPreferredSize(new java.awt.Dimension(1000, 645));
        setLayout(new java.awt.BorderLayout());

        inputchangeInfoPanel.setBackground(new java.awt.Color(255, 51, 51));
        inputchangeInfoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        inputchangeInfoPanel.setForeground(new java.awt.Color(255, 51, 51));
        inputchangeInfoPanel.setLayout(new java.awt.BorderLayout());

        inputchangeInfoStorePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin cửa hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        inputNameLabel.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        inputNameLabel.setText("Tên:");

        inputPhoneNumberLabel.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        inputPhoneNumberLabel.setText("SĐT:");

        inputAndressLabel.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        inputAndressLabel.setText("Địa chỉ:");

        inputEmailLabel.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        inputEmailLabel.setText("Email:");

        inputNameTextField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        inputNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNameTextFieldActionPerformed(evt);
            }
        });

        inputPhoneNumberTextField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        inputEmailTextField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        inputEmailTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputEmailTextFieldActionPerformed(evt);
            }
        });

        changeInfoButton.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        changeInfoButton.setText("Xác nhận");
        changeInfoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeInfoButtonActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(inputAndressTextPane);

        javax.swing.GroupLayout inputchangeInfoStorePanelLayout = new javax.swing.GroupLayout(inputchangeInfoStorePanel);
        inputchangeInfoStorePanel.setLayout(inputchangeInfoStorePanelLayout);
        inputchangeInfoStorePanelLayout.setHorizontalGroup(
            inputchangeInfoStorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputchangeInfoStorePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inputchangeInfoStorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputPhoneNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputEmailLabel)
                    .addComponent(inputAndressLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(inputchangeInfoStorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(inputPhoneNumberTextField)
                    .addComponent(inputNameTextField)
                    .addComponent(inputEmailTextField)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(changeInfoButton)
                .addGap(55, 55, 55))
        );
        inputchangeInfoStorePanelLayout.setVerticalGroup(
            inputchangeInfoStorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputchangeInfoStorePanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(inputchangeInfoStorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(changeInfoButton)
                    .addComponent(inputNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputNameLabel))
                .addGap(18, 18, 18)
                .addGroup(inputchangeInfoStorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputPhoneNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputPhoneNumberLabel))
                .addGap(18, 18, 18)
                .addGroup(inputchangeInfoStorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputEmailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputEmailLabel))
                .addGap(18, 18, 18)
                .addGroup(inputchangeInfoStorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputAndressLabel))
                .addContainerGap(121, Short.MAX_VALUE))
        );

        inputchangeInfoPanel.add(inputchangeInfoStorePanel, java.awt.BorderLayout.LINE_START);

        inputchangeScorePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cơ chế đổi điểm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        amountForOnePointLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        amountForOnePointLabel.setText("? VNĐ/Điểm:");

        pointsForOneVNDLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        pointsForOneVNDLabel.setText("Điểm/1VNĐ:");

        inputchangeScoreButton.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        inputchangeScoreButton.setText("Xác nhận");
        inputchangeScoreButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputchangeScoreButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout inputchangeScorePanelLayout = new javax.swing.GroupLayout(inputchangeScorePanel);
        inputchangeScorePanel.setLayout(inputchangeScorePanelLayout);
        inputchangeScorePanelLayout.setHorizontalGroup(
            inputchangeScorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputchangeScorePanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(inputchangeScorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputchangeScoreButton)
                    .addGroup(inputchangeScorePanelLayout.createSequentialGroup()
                        .addGroup(inputchangeScorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pointsForOneVNDLabel)
                            .addComponent(amountForOnePointLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(inputchangeScorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(amountForOnePointTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pointsForOneVNDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(224, Short.MAX_VALUE))
        );
        inputchangeScorePanelLayout.setVerticalGroup(
            inputchangeScorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputchangeScorePanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(inputchangeScorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(amountForOnePointLabel)
                    .addComponent(amountForOnePointTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(inputchangeScorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pointsForOneVNDLabel)
                    .addComponent(pointsForOneVNDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(inputchangeScoreButton)
                .addContainerGap(203, Short.MAX_VALUE))
        );

        inputchangeInfoPanel.add(inputchangeScorePanel, java.awt.BorderLayout.CENTER);

        add(inputchangeInfoPanel, java.awt.BorderLayout.PAGE_START);

        settingIntroductionPanel.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout settingIntroductionPanelLayout = new javax.swing.GroupLayout(settingIntroductionPanel);
        settingIntroductionPanel.setLayout(settingIntroductionPanelLayout);
        settingIntroductionPanelLayout.setHorizontalGroup(
            settingIntroductionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1015, Short.MAX_VALUE)
        );
        settingIntroductionPanelLayout.setVerticalGroup(
            settingIntroductionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 282, Short.MAX_VALUE)
        );

        add(settingIntroductionPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void changeInfoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeInfoButtonActionPerformed
        // TODO add your handling code here:

        // Lấy giá trị từ các JTextField
        String name = inputNameTextField.getText().trim();
        String address = inputAndressTextPane.getText().trim();
        //phoneNumber và điều kiện xét cho phoneNumber
        String phoneNumber = inputPhoneNumberTextField.getText().trim();
        String reg = "^(0|\\+84)\\d{9}$"; // Điều kiện để kiểm tra số điện thoại nhập vào
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(phoneNumber);
        //Email và điều kiện xét cho Email
        String email = inputEmailTextField.getText().trim();
        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        Pattern emailPattern = Pattern.compile(emailRegex);
        Matcher emailMatcher = emailPattern.matcher(email);

        /*
        // Cập nhật thông tin vào đối tượng Store trong đối tượng Settings
        Store store = settings.getStore();
        store.setName(name);
        store.setPhoneNumber(phoneNumber);
        store.setAddress(address);
        
        // Gọi phương thức hiển thị thông tin mới trên Header
        header.setStoreInfor();
         */
        // Kiểm tra các trường nhập liệu có bị bỏ trống hay không và điều kiện cho SĐT
        if (name.isEmpty() || phoneNumber.isEmpty() || address.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Hãy nhập thông tin cho cửa hàng của bạn.");
            return;
        } else if (!matcher.matches()) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ.");
            return;
        } else if (email.isEmpty() || !emailMatcher.matches()) {
            JOptionPane.showMessageDialog(this, "Email không hợp lệ.");
            return;
        } else {
            for (StoreShortedCut storeShortedCut : storeList) {
                if (storeShortedCut.getEmail().equals(email)) {
                    JOptionPane.showMessageDialog(this, "Email đã được sử dụng.");
                    return;
                }
            }
        }
        // Cập nhật trong storeShortCutList
        for (StoreShortedCut storeShortedCut : storeList) {
            if (storeShortedCut.getId().compareTo(store.getID()) == 0) {
                storeShortedCut.setEmail(email);
            }
        }

        // Cập nhật đối tượng Store
        store.setName(name);
        store.setPhoneNumber(phoneNumber);
        store.setAddress(address);

        // Cập nhật Header với tên cửa hàng mới
        header.setTitle(name, phoneNumber, address, email);

        // Hiển thị thông báo cho người dùng thông báo rằng các thay đổi đã được lưu
        JOptionPane.showMessageDialog(this, "Các thay đổi đã được lưu.");
    }//GEN-LAST:event_changeInfoButtonActionPerformed

    private void inputEmailTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputEmailTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputEmailTextFieldActionPerformed

    private void inputNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputNameTextFieldActionPerformed

    private void inputchangeScoreButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputchangeScoreButtonActionPerformed
        // TODO add your handling code here:
        try {
            // Lấy giá trị mới nhập vào từ amountForOnePointTextField và chuyển đổi thành BigDecimal
            BigDecimal amountForOnePoint = new BigDecimal(amountForOnePointTextField.getText().trim());
            // Kiểm tra giá trị mới của amountForOnePoint có âm không
            if (amountForOnePoint.compareTo(BigDecimal.ZERO) <= 0) {
                throw new NumberFormatException();
            }

            // Lấy giá trị mới nhập vào từ pointsForOneVNDTextField và chuyển đổi thành BigInteger
            BigInteger pointsForOneVND = new BigInteger(pointsForOneVNDTextField.getText().trim());
            // Kiểm tra giá trị mới của pointsForOneVND có âm không
            if (pointsForOneVND.compareTo(BigInteger.ZERO) <= 0) {
                throw new NumberFormatException();
            }

            // Cập nhật giá trị mới cho store
            store.setAmountForOnePoint(amountForOnePoint);
            store.setPointsForOneVND(pointsForOneVND);

            // Lưu lại cài đặt mới
            store.getSettings().save();

            // Hiển thị thông báo thành công
            JOptionPane.showMessageDialog(this, "Cập nhật thông số thành công!");
        } catch (NumberFormatException ex) {
            // Hiển thị thông báo lỗi nếu giá trị nhập vào không hợp lệ
            JOptionPane.showMessageDialog(this, "Vui lòng nhập giá trị hợp lệ cho các thông số!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_inputchangeScoreButtonActionPerformed

    public void passData(Store store, Header header, List<StoreShortedCut> storeList) {
        this.store = store;
        this.header = header;
        this.storeList = storeList;
        //Cập nhật thông tin hiện có
        inputNameTextField.setText(store.getName());
        inputPhoneNumberTextField.setText(store.getPhoneNumber());
        inputAndressTextPane.setText(store.getAddress());
        inputEmailTextField.setText(store.getEmail());
        BigDecimal amountForOnePoint = store.getAmountForOnePoint();
        amountForOnePointTextField.setText(amountForOnePoint.toString());
        BigInteger pointsForOneVND = store.getPointsForOneVND();
        pointsForOneVNDTextField.setText(pointsForOneVND.toString());
    }

    private List<StoreShortedCut> storeList;
    private Header header;
    private Store store;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel amountForOnePointLabel;
    private javax.swing.JTextField amountForOnePointTextField;
    private javax.swing.JButton changeInfoButton;
    private javax.swing.JLabel inputAndressLabel;
    private javax.swing.JTextPane inputAndressTextPane;
    private javax.swing.JLabel inputEmailLabel;
    private javax.swing.JTextField inputEmailTextField;
    private javax.swing.JLabel inputNameLabel;
    private javax.swing.JTextField inputNameTextField;
    private javax.swing.JLabel inputPhoneNumberLabel;
    private javax.swing.JTextField inputPhoneNumberTextField;
    private javax.swing.JPanel inputchangeInfoPanel;
    private javax.swing.JPanel inputchangeInfoStorePanel;
    private javax.swing.JButton inputchangeScoreButton;
    private javax.swing.JPanel inputchangeScorePanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel pointsForOneVNDLabel;
    private javax.swing.JTextField pointsForOneVNDTextField;
    private javax.swing.JPanel settingIntroductionPanel;
    // End of variables declaration//GEN-END:variables
}
