package view;

import util.FileUtil;
import config.HibernateConfig;
import dao.StoreDAO;
import dao.impl.StoreDAOImpl;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.entities.Store;
import util.BcryptUtil;
import util.ValidateInput;

public class SettingsPanel extends javax.swing.JPanel {

    public SettingsPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inputchangeInfoPanel = new javax.swing.JPanel();
        inputchangeInfoStorePanel = new javax.swing.JPanel();
        inputNameLabel = new javax.swing.JLabel();
        inputEmailLabel = new javax.swing.JLabel();
        inputNameTextField = new javax.swing.JTextField();
        inputEmailTextField = new javax.swing.JTextField();
        changeInfoButton = new javax.swing.JButton();
        inputPassWord1 = new javax.swing.JLabel();
        oldPassword = new javax.swing.JPasswordField();
        inputPassword2 = new javax.swing.JLabel();
        newPassword = new javax.swing.JPasswordField();
        changePassBtn = new javax.swing.JButton();
        fileButton = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(1400, 800));
        setPreferredSize(new java.awt.Dimension(1400, 800));
        setLayout(new java.awt.BorderLayout());

        inputchangeInfoPanel.setBackground(new java.awt.Color(255, 255, 255));
        inputchangeInfoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        inputchangeInfoPanel.setForeground(new java.awt.Color(255, 255, 255));
        inputchangeInfoPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        inputchangeInfoStorePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin cửa hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        inputNameLabel.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        inputNameLabel.setText("Tên:");

        inputEmailLabel.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        inputEmailLabel.setText("Email:");

        inputNameTextField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        inputEmailTextField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        changeInfoButton.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        changeInfoButton.setText("Sửa thông tin");
        changeInfoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeInfoButtonActionPerformed(evt);
            }
        });

        inputPassWord1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        inputPassWord1.setText("Nhập mật khẩu cũ:");

        oldPassword.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        oldPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        inputPassword2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        inputPassword2.setText("Nhập mật khẩu mới:");

        newPassword.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        newPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        changePassBtn.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        changePassBtn.setText("Sửa mật khẩu");
        changePassBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePassBtnActionPerformed(evt);
            }
        });

        fileButton.setText("Thay đổi avatar đại diện");
        fileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout inputchangeInfoStorePanelLayout = new javax.swing.GroupLayout(inputchangeInfoStorePanel);
        inputchangeInfoStorePanel.setLayout(inputchangeInfoStorePanelLayout);
        inputchangeInfoStorePanelLayout.setHorizontalGroup(
            inputchangeInfoStorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputchangeInfoStorePanelLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(inputchangeInfoStorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, inputchangeInfoStorePanelLayout.createSequentialGroup()
                        .addComponent(inputPassWord1)
                        .addGap(18, 18, 18)
                        .addComponent(oldPassword))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, inputchangeInfoStorePanelLayout.createSequentialGroup()
                        .addGroup(inputchangeInfoStorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputEmailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(386, 386, 386))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, inputchangeInfoStorePanelLayout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addGroup(inputchangeInfoStorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputNameTextField)
                            .addComponent(inputEmailTextField)))
                    .addGroup(inputchangeInfoStorePanelLayout.createSequentialGroup()
                        .addComponent(inputPassword2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(inputchangeInfoStorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fileButton)
                            .addComponent(newPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(50, 50, 50)
                .addGroup(inputchangeInfoStorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(changeInfoButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(changePassBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
                .addContainerGap(657, Short.MAX_VALUE))
        );
        inputchangeInfoStorePanelLayout.setVerticalGroup(
            inputchangeInfoStorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputchangeInfoStorePanelLayout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addGroup(inputchangeInfoStorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(inputchangeInfoStorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputEmailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputEmailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(changeInfoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(inputchangeInfoStorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputPassWord1)
                    .addComponent(oldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(inputchangeInfoStorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputPassword2)
                    .addComponent(newPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(changePassBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82)
                .addComponent(fileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(291, Short.MAX_VALUE))
        );

        inputchangeInfoPanel.add(inputchangeInfoStorePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 8, 1400, 860));

        add(inputchangeInfoPanel, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void fileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileButtonActionPerformed
        JFileChooser fileChooser = new JFileChooser();

        FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("Hình ảnh", "jpg", "png");
        fileChooser.setFileFilter(imageFilter);

        fileChooser.setMultiSelectionEnabled(false);

        int x = fileChooser.showDialog(this, "Chọn file");

        if (x == JFileChooser.APPROVE_OPTION) {
            File f = fileChooser.getSelectedFile();
            BufferedImage originalImage = FileUtil.loadImage(f.getAbsolutePath());

            String savedImagePath = FileUtil.saveImage(originalImage, "/data/avatar");

            if (savedImagePath == null) {
                JOptionPane.showMessageDialog(this, "Lưu ảnh thất bại!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                return;
            }

            boolean result = this.storeDAO.updateStoreAvatar(this.store.getStoreId(), savedImagePath, this.hibernateConfig.getEntityManager());
            
            if (!result) {
                JOptionPane.showMessageDialog(this, "Cập nhật ảnh thất bại!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                return;
            }
            JOptionPane.showMessageDialog(this, "Cập nhật ảnh thành công!");
            // Hiển thị hình ảnh trong changeLabel của Header
            this.header.setChangeLabelImage(originalImage);
        }
    }//GEN-LAST:event_fileButtonActionPerformed

    private void changePassBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePassBtnActionPerformed
        String oldPass = oldPassword.getText().trim();
        String newPass = newPassword.getText().trim();
        if (oldPass.isBlank() || newPass.isBlank()) {
            JOptionPane.showMessageDialog(this, "Mật khẩu mới và mật khẩu cũ không được bỏ trống!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (newPass.length() < 6) {
            JOptionPane.showMessageDialog(this, "Mật khẩu mới phải chứa tối thiểu 6 ký tự!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (!BcryptUtil.checkPassword(oldPass, this.store.getPassword())) {
            JOptionPane.showMessageDialog(this, "Mật khẩu cũ không khớp!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        boolean result = this.storeDAO.updateStorePassword(this.store.getStoreId(), newPass, this.hibernateConfig.getEntityManager());
        if (!result) {
            JOptionPane.showMessageDialog(this, "Cập nhật mật khẩu thất bại!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(this, "Cập nhật mật khẩu thành công!");
    }//GEN-LAST:event_changePassBtnActionPerformed

    private void changeInfoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeInfoButtonActionPerformed
        String name = inputNameTextField.getText().trim();
        String email = inputEmailTextField.getText().trim();

        if (name.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Hãy nhập đầy đủ thông tin cho tài khoản cửa hàng của bạn!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (!ValidateInput.checkEmailFormat(email)) {
            JOptionPane.showMessageDialog(this, "Email không hợp lệ!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Store storeHolder = this.storeDAO.getStoreWithEmail(this.store.getEmail(), this.hibernateConfig.getEntityManager());
        if (storeHolder != null && !storeHolder.getStoreId().equals(this.store.getStoreId())) {
            JOptionPane.showMessageDialog(this, "Email đã được sử dụng!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        };

        boolean result = this.storeDAO.updateStore(Store.builder().storeName(name).email(email).build(), this.hibernateConfig.getEntityManager());
        if (!result) {
            JOptionPane.showMessageDialog(this, "Cập nhật thông tin thất bại!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(this, "Các thay đổi đã được lưu!");
    }//GEN-LAST:event_changeInfoButtonActionPerformed

    public void defaultSettings() {
        inputNameTextField.setText(store.getStoreName());
        inputEmailTextField.setText(store.getEmail());
    }

    public void setup(HibernateConfig hibernateConfig, Store store, Header header) {
        this.store = store;
        this.header = header;
        this.storeDAO = new StoreDAOImpl();
        this.hibernateConfig = hibernateConfig;

        //Cập nhật thông tin hiện có
        defaultSettings();
    }

    private StoreDAO storeDAO;
    private HibernateConfig hibernateConfig;
    private Header header;
    private Store store;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton changeInfoButton;
    private javax.swing.JButton changePassBtn;
    private javax.swing.JButton fileButton;
    private javax.swing.JLabel inputEmailLabel;
    private javax.swing.JTextField inputEmailTextField;
    private javax.swing.JLabel inputNameLabel;
    private javax.swing.JTextField inputNameTextField;
    private javax.swing.JLabel inputPassWord1;
    private javax.swing.JLabel inputPassword2;
    private javax.swing.JPanel inputchangeInfoPanel;
    private javax.swing.JPanel inputchangeInfoStorePanel;
    private javax.swing.JPasswordField newPassword;
    private javax.swing.JPasswordField oldPassword;
    // End of variables declaration//GEN-END:variables
}
