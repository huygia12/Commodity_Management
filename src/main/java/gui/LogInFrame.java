package gui;


import com.formdev.flatlaf.FlatLightLaf;
import config.HibernateConfig;
import dao.StoreDAO;
import dao.impl.StoreDAOImpl;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
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
        setDefaultValueToRememberCheckbox();
        clearInputAndWarning();
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
        setResizable(false);

        LogInPanel.setBackground(new java.awt.Color(255, 255, 255));
        LogInPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        LogInPanel.setMaximumSize(new java.awt.Dimension(400, 450));
        LogInPanel.setMinimumSize(new java.awt.Dimension(400, 400));
        LogInPanel.setPreferredSize(new java.awt.Dimension(400, 400));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Đăng nhập tài khoản");

        rememberPasswordCheckBox.setForeground(new java.awt.Color(102, 102, 102));
        rememberPasswordCheckBox.setText("Nhớ mật khẩu");

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
                .addGroup(LogInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(LogInPanelLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(LogInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(LogInPanelLayout.createSequentialGroup()
                                .addComponent(logInEmailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(logInEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(rememberPasswordCheckBox)
                            .addGroup(LogInPanelLayout.createSequentialGroup()
                                .addComponent(logInPasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(logInPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(LogInPanelLayout.createSequentialGroup()
                        .addGap(0, 237, Short.MAX_VALUE)
                        .addComponent(illegalLogInEmailWarning)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(eyeBtn)
                .addGap(33, 33, 33))
            .addGroup(LogInPanelLayout.createSequentialGroup()
                .addGroup(LogInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LogInPanelLayout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jLabel1))
                    .addGroup(LogInPanelLayout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(logInButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        LogInPanelLayout.setVerticalGroup(
            LogInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogInPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(43, 43, 43)
                .addGroup(LogInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logInEmailLabel)
                    .addComponent(logInEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(illegalLogInEmailWarning)
                .addGap(6, 6, 6)
                .addGroup(LogInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LogInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(logInPasswordLabel)
                        .addComponent(logInPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(eyeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(rememberPasswordCheckBox)
                .addGap(114, 114, 114)
                .addComponent(logInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        tabPane.addTab("Đăng nhập", LogInPanel);

        SignUpPanel.setBackground(new java.awt.Color(255, 255, 255));
        SignUpPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        SignUpPanel.setMaximumSize(new java.awt.Dimension(400, 450));
        SignUpPanel.setMinimumSize(new java.awt.Dimension(400, 400));
        SignUpPanel.setPreferredSize(new java.awt.Dimension(400, 400));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setText("Đăng ký tài khoản");

        signInEmailLabel.setText("Email");

        signInPasswordLabel.setText("Mật khẩu");

        signUpButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        signUpButton.setText("Đăng ký");
        signUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpButtonActionPerformed(evt);
            }
        });

        retypeSignInPasswordLabel.setText("Nhập lại mật khẩu");

        passwordWarning.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        passwordWarning.setForeground(new java.awt.Color(255, 0, 51));
        passwordWarning.setText("Mật khẩu không khớp! ");

        illegalSignUpEmailWarning.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        illegalSignUpEmailWarning.setForeground(new java.awt.Color(255, 0, 51));
        illegalSignUpEmailWarning.setText("Email không hợp lệ! ");

        blankSignUpPasswordWarning.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        blankSignUpPasswordWarning.setForeground(new java.awt.Color(255, 0, 51));
        blankSignUpPasswordWarning.setText("Mật khẩu phải chứa ít nhất 6 kí tự! ");

        signInEmailLabel1.setText("Tên cửa hàng");

        illegalStoreNameWarning.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        illegalStoreNameWarning.setForeground(new java.awt.Color(255, 0, 51));
        illegalStoreNameWarning.setText("Không được để trống!");

        javax.swing.GroupLayout SignUpPanelLayout = new javax.swing.GroupLayout(SignUpPanel);
        SignUpPanel.setLayout(SignUpPanelLayout);
        SignUpPanelLayout.setHorizontalGroup(
            SignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SignUpPanelLayout.createSequentialGroup()
                .addGroup(SignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SignUpPanelLayout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jLabel5))
                    .addGroup(SignUpPanelLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(SignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(passwordWarning)
                            .addGroup(SignUpPanelLayout.createSequentialGroup()
                                .addGroup(SignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(signInPasswordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(retypeSignInPasswordLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(SignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(retypePasswordInput)
                                    .addComponent(signupPasswordInput)
                                    .addComponent(blankSignUpPasswordWarning, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(SignUpPanelLayout.createSequentialGroup()
                                .addComponent(signInEmailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(SignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(signupEmailInput, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(illegalSignUpEmailWarning, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(SignUpPanelLayout.createSequentialGroup()
                                .addComponent(signInEmailLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(storeNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(illegalStoreNameWarning)))
                    .addGroup(SignUpPanelLayout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(signUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        SignUpPanelLayout.setVerticalGroup(
            SignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SignUpPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel5)
                .addGap(42, 42, 42)
                .addGroup(SignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(signInEmailLabel)
                    .addComponent(signupEmailInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(illegalSignUpEmailWarning)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(signInEmailLabel1)
                    .addComponent(storeNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(illegalStoreNameWarning)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(signupPasswordInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(signInPasswordLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(blankSignUpPasswordWarning)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(retypePasswordInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(retypeSignInPasswordLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordWarning)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(signUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        tabPane.addTab("Đăng kí", SignUpPanel);

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
        validEmail = ValidateInput.checkEmailFormat(emailStr);
        illegalSignUpEmailWarning.setVisible(!validEmail);

        rightpassword = passwordStr.length() >= 6;
        blankSignUpPasswordWarning.setVisible(!rightpassword);

        validStoreName = !storeNameStr.isBlank();
        illegalStoreNameWarning.setVisible(!validStoreName);
        
        matchPassword = passwordStr.equals(retypePasswordStr);
        passwordWarning.setVisible(!matchPassword);

        if (validEmail && matchPassword && rightpassword && validStoreName) {
            Store newStore = Store.builder().email(emailStr).password(BcryptUtil.hashPassword(passwordStr)).build();
            storeDAO.signup(newStore, hibernateConfig.getEntityManager());
            JOptionPane.showMessageDialog(LogInFrame.this,
                    "Vui lòng trở lại màn hình đăng nhập",
                    "Đăng kí thành công!",
                    JOptionPane.DEFAULT_OPTION);
            clearInputAndWarning();
        }
    }//GEN-LAST:event_signUpButtonActionPerformed


    private void logInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logInButtonActionPerformed
        String email = logInEmail.getText().trim();
        String password = logInPassword.getText().trim();
        if (!ValidateInput.checkEmailFormat(email)) {
            illegalLogInEmailWarning.setVisible(true);
            return;
        }

        Store store = storeDAO.login(email, password, hibernateConfig.getEntityManager());
        if (store == null) {
            showLogInFailMessage();
            return;
        }

        rememberCheck();
        MainFrame mainFrame = new MainFrame(store);
        mainFrame.setVisible(true);
        this.dispose();
//                mainFrame.setVisible(true);
        hibernateConfig.closeConnection();
    }//GEN-LAST:event_logInButtonActionPerformed

    private void showLogInFailMessage() {
        JOptionPane.showMessageDialog(LogInFrame.this,
                "Sai email hoặc mật khẩu!",
                "Đăng nhập thất bại!",
                JOptionPane.WARNING_MESSAGE);
    }

    private void showSignupFailMessage() {
        JOptionPane.showMessageDialog(LogInFrame.this,
                "Thông tin đăng ký không hợp lệ!",
                "Đăng ký thất bại!",
                JOptionPane.WARNING_MESSAGE);
    }

    private void rememberCheck() {
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

    private boolean setDefaultValueToRememberCheckbox() {
        boolean check = false;
        try (BufferedReader br = new BufferedReader(
                Files.newBufferedReader(Path.of(REMEBER_PASSWORD_PATH)))) {
            String[] str = br.readLine().split(",");
            rememberCheck = str[0].equals("true");
            if (rememberCheck) {
                rememberPasswordCheckBox.setSelected(rememberCheck);
                logInEmail.setText(str[1]);
                logInPassword.setText(str[2]);
            }
        } catch (IOException ex) {
            Logger.getLogger(this.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
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
