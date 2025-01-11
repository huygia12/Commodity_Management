package view;

import com.formdev.flatlaf.FlatLightLaf;
import config.HibernateConfig;
import dao.StoreDAO;
import dao.impl.StoreDAOImpl;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import model.entities.Store;
import util.BcryptUtil;
import util.ValidateInput;

public class LogInFrame extends javax.swing.JFrame {

    public LogInFrame() {
        initComponents();
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass()
                .getResource("/ImageIcon/icons8-grocery-store-96.png")).getImage());
        initVariableValue();
        clearInputAndWarning();
        loadRememberedCredentials();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabPane = new javax.swing.JTabbedPane();
        LogInPanel = new javax.swing.JPanel();
        logInEmail = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        rememberPasswordCheckBox = new javax.swing.JCheckBox();
        eyeBtn = new javax.swing.JButton();
        logInPassword = new javax.swing.JPasswordField();
        logInEmailLabel = new javax.swing.JLabel();
        logInPasswordLabel = new javax.swing.JLabel();
        logInButton = new javax.swing.JButton();
        illegalLogInEmailWarning = new javax.swing.JLabel();
        SignUpPanel = new javax.swing.JPanel();
        signupEmailInput = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        signupPasswordInput = new javax.swing.JPasswordField();
        signInEmailLabel = new javax.swing.JLabel();
        signInPasswordLabel = new javax.swing.JLabel();
        signUpButton = new javax.swing.JButton();
        retypeSignInPasswordLabel = new javax.swing.JLabel();
        retypePasswordInput = new javax.swing.JPasswordField();
        passwordWarning = new javax.swing.JLabel();
        illegalSignUpEmailWarning = new javax.swing.JLabel();
        blankSignUpPasswordWarning = new javax.swing.JLabel();
        storeNameInput = new javax.swing.JTextField();
        signInEmailLabel1 = new javax.swing.JLabel();
        illegalStoreNameWarning = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lí bán hàng");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(500, 150));
        setMinimumSize(new java.awt.Dimension(600, 600));
        setResizable(false);

        LogInPanel.setBackground(new java.awt.Color(255, 255, 255));
        LogInPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        LogInPanel.setMaximumSize(new java.awt.Dimension(600, 570));
        LogInPanel.setMinimumSize(new java.awt.Dimension(600, 570));
        LogInPanel.setPreferredSize(new java.awt.Dimension(600, 570));

        logInEmail.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Đăng nhập tài khoản");

        rememberPasswordCheckBox.setForeground(new java.awt.Color(102, 102, 102));
        rememberPasswordCheckBox.setText("Nhớ mật khẩu");
        rememberPasswordCheckBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rememberPasswordCheckBoxMouseClicked(evt);
            }
        });

        eyeBtn.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        eyeBtn.setForeground(new java.awt.Color(0, 102, 255));
        eyeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageIcon/icons8-eyesClosed-15.png"))); // NOI18N
        eyeBtn.setBorder(null);
        eyeBtn.setContentAreaFilled(false);
        eyeBtn.setFocusable(false);
        eyeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eyeBtnActionPerformed(evt);
            }
        });

        logInPassword.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N

        logInEmailLabel.setText("Email");

        logInPasswordLabel.setText("Mật khẩu");

        logInButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        logInButton.setText("Đăng nhập");
        logInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logInButtonActionPerformed(evt);
            }
        });

        illegalLogInEmailWarning.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        illegalLogInEmailWarning.setForeground(new java.awt.Color(255, 0, 51));
        illegalLogInEmailWarning.setText("Email không hợp lệ! ");

        javax.swing.GroupLayout LogInPanelLayout = new javax.swing.GroupLayout(LogInPanel);
        LogInPanel.setLayout(LogInPanelLayout);
        LogInPanelLayout.setHorizontalGroup(
            LogInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LogInPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(LogInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(logInButton)
                    .addGroup(LogInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addGroup(LogInPanelLayout.createSequentialGroup()
                            .addGroup(LogInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(logInEmailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(logInPasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(32, 32, 32)
                            .addGroup(LogInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(LogInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(rememberPasswordCheckBox)
                                    .addComponent(logInEmail)
                                    .addComponent(logInPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(illegalLogInEmailWarning)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(eyeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );
        LogInPanelLayout.setVerticalGroup(
            LogInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogInPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(LogInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(logInEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logInEmailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(illegalLogInEmailWarning)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LogInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(LogInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(logInPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(logInPasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(eyeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(rememberPasswordCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 178, Short.MAX_VALUE)
                .addComponent(logInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93))
        );

        tabPane.addTab("Đăng nhập", LogInPanel);

        SignUpPanel.setBackground(new java.awt.Color(255, 255, 255));
        SignUpPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        SignUpPanel.setMaximumSize(new java.awt.Dimension(600, 570));
        SignUpPanel.setMinimumSize(new java.awt.Dimension(600, 570));
        SignUpPanel.setPreferredSize(new java.awt.Dimension(600, 570));
        SignUpPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        signupEmailInput.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        SignUpPanel.add(signupEmailInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 280, 37));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setText("Đăng ký tài khoản");
        SignUpPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 25, -1, 38));

        signupPasswordInput.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        SignUpPanel.add(signupPasswordInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, 280, 37));

        signInEmailLabel.setText("Email");
        SignUpPanel.add(signInEmailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 116, 37));

        signInPasswordLabel.setText("Mật khẩu");
        SignUpPanel.add(signInPasswordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 143, 28));

        signUpButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        signUpButton.setText("Đăng ký");
        signUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpButtonActionPerformed(evt);
            }
        });
        SignUpPanel.add(signUpButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(378, 458, 126, 43));

        retypeSignInPasswordLabel.setText("Nhập lại mật khẩu");
        SignUpPanel.add(retypeSignInPasswordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, -1, 30));

        retypePasswordInput.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        SignUpPanel.add(retypePasswordInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, 280, 36));

        passwordWarning.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        passwordWarning.setForeground(new java.awt.Color(255, 0, 51));
        passwordWarning.setText("Mật khẩu không khớp! ");
        SignUpPanel.add(passwordWarning, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 340, -1, -1));

        illegalSignUpEmailWarning.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        illegalSignUpEmailWarning.setForeground(new java.awt.Color(255, 0, 51));
        illegalSignUpEmailWarning.setText("Email không hợp lệ! ");
        SignUpPanel.add(illegalSignUpEmailWarning, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, -1, -1));

        blankSignUpPasswordWarning.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        blankSignUpPasswordWarning.setForeground(new java.awt.Color(255, 0, 51));
        blankSignUpPasswordWarning.setText("Mật khẩu phải chứa ít nhất 6 kí tự! ");
        SignUpPanel.add(blankSignUpPasswordWarning, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, -1, -1));

        storeNameInput.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        SignUpPanel.add(storeNameInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 280, 40));

        signInEmailLabel1.setText("Tên cửa hàng");
        SignUpPanel.add(signInEmailLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 116, 30));

        illegalStoreNameWarning.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        illegalStoreNameWarning.setForeground(new java.awt.Color(255, 0, 51));
        illegalStoreNameWarning.setText("Không được để trống!");
        SignUpPanel.add(illegalStoreNameWarning, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 200, -1, -1));

        tabPane.addTab("Đăng ký", SignUpPanel);

        getContentPane().add(tabPane, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void eyeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eyeBtnActionPerformed
        eyesClickCounter++;
        if (eyesClickCounter % 2 == 0) {
            eyeBtn.setIcon(new ImageIcon(getClass()
                    .getResource("/ImageIcon/icons8-eyesClosed-15.png")));
            logInPassword.setEchoChar(echoChar);
        } else {
            eyeBtn.setIcon(new ImageIcon(getClass()
                    .getResource("/ImageIcon/icons8-eyes-15.png")));
            logInPassword.setEchoChar((char) 0);
        }
    }//GEN-LAST:event_eyeBtnActionPerformed

    private void signUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpButtonActionPerformed
        String emailStr = signupEmailInput.getText().trim();
        String storeNameStr = storeNameInput.getText().trim();
        String passwordStr = signupPasswordInput.getText().trim();
        String retypePasswordStr = retypePasswordInput.getText().trim();

        boolean validEmail, matchPassword, rightpassword, validStoreName;
        validEmail = ValidateInput.isValidEmail(emailStr);
        illegalSignUpEmailWarning.setVisible(!validEmail);

        rightpassword = passwordStr.length() >= 6;
        blankSignUpPasswordWarning.setVisible(!rightpassword);

        validStoreName = !storeNameStr.isBlank();
        illegalStoreNameWarning.setVisible(!validStoreName);

        matchPassword = passwordStr.equals(retypePasswordStr);
        passwordWarning.setVisible(!matchPassword);

        if (validEmail && matchPassword && rightpassword && validStoreName) {
            Store newStore = Store.builder()
                    .email(emailStr)
                    .password(BcryptUtil.hashPassword(passwordStr))
                    .storeName(storeNameStr)
                    .products(new ArrayList<>())
                    .employees(new ArrayList<>())
                    .shifts(new ArrayList<>())
                    .build();

            boolean result = storeDAO.signup(newStore, hibernateConfig.getEntityManager());

            if (!result) {
                JOptionPane.showMessageDialog(LogInFrame.this,
                        "Đăng ký thât bại!");
                return;
            }

            JOptionPane.showMessageDialog(LogInFrame.this,
                    "Vui lòng trở lại màn hình đăng nhập",
                    "Đăng ký thành công!",
                    JOptionPane.DEFAULT_OPTION);
            clearInputAndWarning();
        }
    }//GEN-LAST:event_signUpButtonActionPerformed


    private void logInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logInButtonActionPerformed
        String email = logInEmail.getText().trim();
        String password = logInPassword.getText().trim();
        if (!ValidateInput.isValidEmail(email)) {
            illegalLogInEmailWarning.setVisible(true);
            return;
        }

        Store store = storeDAO.login(email, password, hibernateConfig.getEntityManager());
        if (store == null) {
            showLogInFailMessage();
            return;
        }

        if (rememberCheck) {
            rememberCredentials();
        }
        MainFrame mainFrame = new MainFrame(store);
        mainFrame.setVisible(true);
        this.dispose();
        hibernateConfig.closeConnection();
    }//GEN-LAST:event_logInButtonActionPerformed

    private void rememberPasswordCheckBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rememberPasswordCheckBoxMouseClicked
        rememberCheck = true;
    }//GEN-LAST:event_rememberPasswordCheckBoxMouseClicked

    private void showLogInFailMessage() {
        JOptionPane.showMessageDialog(LogInFrame.this,
                "Sai email hoặc mật khẩu!",
                "Đăng nhập thất bại!",
                JOptionPane.WARNING_MESSAGE);
    }

    private void rememberCredentials() {
        try (PrintWriter pw = new PrintWriter(Files.newBufferedWriter(Path.of(REMEBER_PASSWORD_PATH),
                StandardOpenOption.CREATE,
                StandardOpenOption.WRITE,
                StandardOpenOption.TRUNCATE_EXISTING))) {
            pw.print(rememberPasswordCheckBox.isSelected() + ","
                    + logInEmail.getText() + ","
                    + logInPassword.getText());
        } catch (IOException ex) {
            Logger.getLogger(this.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadRememberedCredentials() {
        try {
            Path path = Path.of(REMEBER_PASSWORD_PATH);
            if (Files.exists(path)) {
                List<String> lines = Files.readAllLines(path);
                if (!lines.isEmpty()) {
                    String[] data = lines.get(0).split(",");
                    if (data.length == 3) {
                        rememberPasswordCheckBox.setSelected(Boolean.parseBoolean(data[0]));
                        logInEmail.setText(data[1]);
                        logInPassword.setText(data[2]);
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(this.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void clearInputAndWarning() {
        passwordWarning.setVisible(false);
        illegalSignUpEmailWarning.setVisible(false);
        blankSignUpPasswordWarning.setVisible(false);
        illegalLogInEmailWarning.setVisible(false);
        illegalStoreNameWarning.setVisible(false);
        logInPassword.setText("");
        signupPasswordInput.setText("");
        retypePasswordInput.setText("");
        storeNameInput.setText("");
        logInEmail.setText("");
        signupEmailInput.setText("");
    }

    private void initVariableValue() {
        rememberCheck = false;
        echoChar = logInPassword.getEchoChar();
        storeDAO = new StoreDAOImpl();
        hibernateConfig = new HibernateConfig();
    }

    public static void main(String args[]) throws UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(new FlatLightLaf());
        java.awt.EventQueue.invokeLater(() -> {
            new LogInFrame().setVisible(true);
        });
    }

    private StoreDAO storeDAO;
    private HibernateConfig hibernateConfig;
    private char echoChar;
    private int eyesClickCounter = 0;
    private boolean rememberCheck;
    private static final String HOME = System.getProperty("user.dir");
    private static final String SEPARATOR = File.separator;
    private static final String DATA_FOLDER = HOME + SEPARATOR + "data" + SEPARATOR;
    private static final String REMEBER_PASSWORD_PATH = DATA_FOLDER + "rememberPass.csv";
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LogInPanel;
    private javax.swing.JPanel SignUpPanel;
    private javax.swing.JLabel blankSignUpPasswordWarning;
    private javax.swing.JButton eyeBtn;
    private javax.swing.JLabel illegalLogInEmailWarning;
    private javax.swing.JLabel illegalSignUpEmailWarning;
    private javax.swing.JLabel illegalStoreNameWarning;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton logInButton;
    private javax.swing.JTextField logInEmail;
    private javax.swing.JLabel logInEmailLabel;
    private javax.swing.JPasswordField logInPassword;
    private javax.swing.JLabel logInPasswordLabel;
    private javax.swing.JLabel passwordWarning;
    private javax.swing.JCheckBox rememberPasswordCheckBox;
    private javax.swing.JPasswordField retypePasswordInput;
    private javax.swing.JLabel retypeSignInPasswordLabel;
    private javax.swing.JLabel signInEmailLabel;
    private javax.swing.JLabel signInEmailLabel1;
    private javax.swing.JLabel signInPasswordLabel;
    private javax.swing.JButton signUpButton;
    private javax.swing.JTextField signupEmailInput;
    private javax.swing.JPasswordField signupPasswordInput;
    private javax.swing.JTextField storeNameInput;
    private javax.swing.JTabbedPane tabPane;
    // End of variables declaration//GEN-END:variables
}
