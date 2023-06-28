/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Controllers.StoreController;
import Models.Store;
import Models.StoreShortedCut;
import Ultility.IDGenerator;
import Ultility.JsonDataFile;
import com.formdev.flatlaf.FlatLightLaf;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Chi Cute
 */
public class LogInFrame extends javax.swing.JFrame {

    /**
     * Creates new form LogInFrame
     *
     */
    public LogInFrame() {
        initComponents();
        setUp();
        initVariable();
        loadData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabPane = new javax.swing.JTabbedPane();
        LogInPanel = new javax.swing.JPanel();
        logInEmail = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        rememberPasswordCheckBox = new javax.swing.JCheckBox();
        forgotPasswordButton = new javax.swing.JButton();
        logInPassword = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        logInButton = new javax.swing.JButton();
        illegalLogInEmailWarning = new javax.swing.JLabel();
        SignUpPanel = new javax.swing.JPanel();
        signUpEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        signUpPassword = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        signUpButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        retypePassword = new javax.swing.JPasswordField();
        passwordWarning = new javax.swing.JLabel();
        illegalSignUpEmailWarning = new javax.swing.JLabel();
        blankSignUpPasswordWarning = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lí bán hàng");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(500, 150));
        setResizable(false);

        tabPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabPaneMouseClicked(evt);
            }
        });

        LogInPanel.setBackground(new java.awt.Color(255, 255, 255));
        LogInPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        LogInPanel.setMaximumSize(new java.awt.Dimension(400, 450));
        LogInPanel.setMinimumSize(new java.awt.Dimension(400, 400));
        LogInPanel.setPreferredSize(new java.awt.Dimension(400, 400));

        logInEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logInEmailActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Đăng nhập tài khoản");

        rememberPasswordCheckBox.setForeground(new java.awt.Color(102, 102, 102));
        rememberPasswordCheckBox.setText("Nhớ mật khẩu");
        rememberPasswordCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rememberPasswordCheckBoxActionPerformed(evt);
            }
        });

        forgotPasswordButton.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        forgotPasswordButton.setForeground(new java.awt.Color(0, 102, 255));
        forgotPasswordButton.setText("Quên mật khẩu?");
        forgotPasswordButton.setBorder(null);
        forgotPasswordButton.setContentAreaFilled(false);
        forgotPasswordButton.setFocusable(false);
        forgotPasswordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forgotPasswordButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Email");

        jLabel3.setText("Mật khẩu");

        logInButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        logInButton.setText("Đăng nhập");
        logInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logInButtonActionPerformed(evt);
            }
        });

        illegalLogInEmailWarning.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        illegalLogInEmailWarning.setForeground(new java.awt.Color(255, 0, 51));
        illegalLogInEmailWarning.setText("Email không hợp lệ");

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
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(logInEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(LogInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, LogInPanelLayout.createSequentialGroup()
                                    .addComponent(rememberPasswordCheckBox)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(forgotPasswordButton))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, LogInPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(logInPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(LogInPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(illegalLogInEmailWarning)))
                .addGap(60, 60, 60))
            .addGroup(LogInPanelLayout.createSequentialGroup()
                .addGroup(LogInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LogInPanelLayout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jLabel1))
                    .addGroup(LogInPanelLayout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(logInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        LogInPanelLayout.setVerticalGroup(
            LogInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogInPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(43, 43, 43)
                .addGroup(LogInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(logInEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(illegalLogInEmailWarning)
                .addGap(6, 6, 6)
                .addGroup(LogInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(logInPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(LogInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(forgotPasswordButton)
                    .addComponent(rememberPasswordCheckBox))
                .addGap(114, 114, 114)
                .addComponent(logInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );

        tabPane.addTab("Đăng nhập", LogInPanel);

        SignUpPanel.setBackground(new java.awt.Color(255, 255, 255));
        SignUpPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        SignUpPanel.setMaximumSize(new java.awt.Dimension(400, 450));
        SignUpPanel.setMinimumSize(new java.awt.Dimension(400, 400));
        SignUpPanel.setPreferredSize(new java.awt.Dimension(400, 400));

        signUpEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpEmailActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setText("Đăng ký tài khoản");

        jLabel6.setText("Email");

        jLabel7.setText("Mật khẩu");

        signUpButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        signUpButton.setText("Đăng ký");
        signUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpButtonActionPerformed(evt);
            }
        });

        jLabel8.setText("Nhập lại mật khẩu");

        retypePassword.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                retypePasswordInputMethodTextChanged(evt);
            }
        });
        retypePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retypePasswordActionPerformed(evt);
            }
        });

        passwordWarning.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        passwordWarning.setForeground(new java.awt.Color(255, 0, 51));
        passwordWarning.setText("Mật khẩu không khớp");

        illegalSignUpEmailWarning.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        illegalSignUpEmailWarning.setForeground(new java.awt.Color(255, 0, 51));
        illegalSignUpEmailWarning.setText("Email không hợp lệ");

        blankSignUpPasswordWarning.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        blankSignUpPasswordWarning.setForeground(new java.awt.Color(255, 0, 51));
        blankSignUpPasswordWarning.setText("Mật khẩu phải chứa ít nhất 4 kí tự");

        javax.swing.GroupLayout SignUpPanelLayout = new javax.swing.GroupLayout(SignUpPanel);
        SignUpPanel.setLayout(SignUpPanelLayout);
        SignUpPanelLayout.setHorizontalGroup(
            SignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SignUpPanelLayout.createSequentialGroup()
                .addGroup(SignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SignUpPanelLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(SignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(passwordWarning)
                            .addGroup(SignUpPanelLayout.createSequentialGroup()
                                .addGroup(SignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(SignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(retypePassword, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                                    .addComponent(signUpPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                                    .addComponent(signUpEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                                    .addComponent(illegalSignUpEmailWarning, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(blankSignUpPasswordWarning, javax.swing.GroupLayout.Alignment.TRAILING)))))
                    .addGroup(SignUpPanelLayout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jLabel5))
                    .addGroup(SignUpPanelLayout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(signUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        SignUpPanelLayout.setVerticalGroup(
            SignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SignUpPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel5)
                .addGap(42, 42, 42)
                .addGroup(SignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(signUpEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(illegalSignUpEmailWarning)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(signUpPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(blankSignUpPasswordWarning)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(retypePassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordWarning)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(signUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );

        tabPane.addTab("Đăng kí", SignUpPanel);

        getContentPane().add(tabPane, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void forgotPasswordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forgotPasswordButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_forgotPasswordButtonActionPerformed

    private void logInEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logInEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_logInEmailActionPerformed

    private void rememberPasswordCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rememberPasswordCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rememberPasswordCheckBoxActionPerformed

    private void signUpEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_signUpEmailActionPerformed

    private void signUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpButtonActionPerformed
        String emailStr = signUpEmail.getText();
        String passwordStr = signUpPassword.getText();
        String retypePasswordStr = retypePassword.getText();

        if (storeCtr.containEmail(storeList, emailStr) != null) {
            JOptionPane.showMessageDialog(LogInFrame.this,
                    "Email đã tồn tại!",
                    "Đăng kí thất bại!",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        boolean validEmail, matchPassword, rightpassword;
        if (!checkValidEmail(emailStr)) {
            illegalSignUpEmailWarning.setVisible(true);
            signUpEmail.setText("");
            validEmail = false;
        } else {
            validEmail = true;
        }

        if (passwordStr.length() < 4) {
            blankSignUpPasswordWarning.setVisible(true);
            signUpPassword.setText("");
            rightpassword = false;
        } else {
            rightpassword = true;
        }

        if (!passwordStr.equals(retypePasswordStr)) {
            passwordWarning.setVisible(true);
            retypePassword.setText("");
            signUpPassword.setText("");
            matchPassword = false;
        } else {
            matchPassword = true;
        }

        if (validEmail && matchPassword && rightpassword) {
            // tao store moi
            Store newStore = new Store();
            newStore.setID(storeIDGenerator.generateID(Store.class.getName(), 6));
            newStore.setEmail(emailStr);
            newStore.setPassWord(passwordStr);
            myData.save(Path.of(STORE_DATA_FOLDER + newStore.getID() + ".json"), newStore);
            // tao storeShortedCut moi
            StoreShortedCut storeShortCut = new StoreShortedCut(newStore.getID(), emailStr, passwordStr);
            storeList.add(storeShortCut);
            myData.save(Path.of(STORE_ID_BUCKET_PATH), storeIDGenerator);
            myData.save(Path.of(LIST_STORE_PATH), storeList);
            JOptionPane.showMessageDialog(LogInFrame.this,
                    "Vui lòng trở lại màn hình đăng nhập",
                    "Đăng kí thành công!",
                    JOptionPane.DEFAULT_OPTION);
            setProperties();
        }
    }//GEN-LAST:event_signUpButtonActionPerformed

    private void retypePasswordInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_retypePasswordInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_retypePasswordInputMethodTextChanged

    private void retypePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retypePasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_retypePasswordActionPerformed

    private StoreShortedCut checkExistingEmail() {
        String inputEmail = logInEmail.getText();
        String loginPassword = logInPassword.getText();
        StoreShortedCut userStore = null;
        Boolean checkIfEmailExisted = false;
        if (!storeList.isEmpty()) {
            for (StoreShortedCut store : storeList) {
                System.out.println(store.getEmail());
                System.out.println(store.getPassword());
                if (store.getEmail().equals(inputEmail)) {
                    if (!loginPassword.equals(store.getPassword())) {
                        showLogInFailMessage();
                    } else {
                        userStore = store;
                    }
                    checkIfEmailExisted = true;
                    break;
                }
            }
        }
        if (!checkIfEmailExisted) {
            showNoneExistEmailWarning();
        }
        setProperties();
        return userStore;
    }

    private void showNoneExistEmailWarning() {
        JOptionPane.showMessageDialog(this,
                "Email chưa được đăng kí!",
                "Đăng nhập thất bại!",
                JOptionPane.WARNING_MESSAGE);
    }

    private void showLogInFailMessage() {
        JOptionPane.showMessageDialog(LogInFrame.this,
                "Sai email hoặc mật khẩu!",
                "Đăng nhập thất bại!",
                JOptionPane.WARNING_MESSAGE);
    }

    private void logInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logInButtonActionPerformed
        if (!checkValidEmail(logInEmail.getText())) {
            illegalLogInEmailWarning.setVisible(true);
            logInEmail.setText("");
        } else {
            StoreShortedCut userStore = checkExistingEmail();
            if (userStore != null) {
                MainFrame mainFrame = new MainFrame();
                mainFrame.setUserStore(userStore);
                mainFrame.setVisible(true);
                this.dispose();
            }
        }
    }//GEN-LAST:event_logInButtonActionPerformed

    private void tabPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabPaneMouseClicked
        setProperties();
    }//GEN-LAST:event_tabPaneMouseClicked

    private boolean checkValidEmail(String regex) {
        pattern = Pattern.compile(EMAIL_REGEX);
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    private void setUp() {
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass()
                .getResource("/ImageIcon/icons8-grocery-store-96.png")).getImage());
    }

    private void setProperties() {
        passwordWarning.setVisible(false);
        illegalSignUpEmailWarning.setVisible(false);
        blankSignUpPasswordWarning.setVisible(false);
        illegalLogInEmailWarning.setVisible(false);
        logInPassword.setText("");
        signUpPassword.setText("");
        retypePassword.setText("");
        logInEmail.setText("");
        signUpEmail.setText("");
    }

    private void initVariable() {
        storeCtr = new StoreController();
        EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
        setProperties();
    }

    private void loadData() {
        this.storeList = myData
                .load(Path.of(LIST_STORE_PATH), new TypeToken<List<StoreShortedCut>>() {
                }.getType(), storeList);
        this.storeIDGenerator = (IDGenerator) myData
                .load(Path.of(STORE_ID_BUCKET_PATH), IDGenerator.class, storeList);
    }

    /**
     * @param args the command line arguments
     * @throws javax.swing.UnsupportedLookAndFeelException
     */
    public static void main(String args[]) throws UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(new FlatLightLaf());
        java.awt.EventQueue.invokeLater(() -> {
            new LogInFrame().setVisible(true);
        });
    }

    private Pattern pattern;
    private Matcher matcher;
    private String EMAIL_REGEX;
    private IDGenerator storeIDGenerator;
    private List<StoreShortedCut> storeList;
    private StoreController storeCtr;
    private static final JsonDataFile myData = new JsonDataFile();
    private static final String HOME = System.getProperty("user.dir");
    private static final String SEPARATOR = File.separator;
    private static final String DATA_FOLDER = HOME + SEPARATOR + "data" + SEPARATOR;
    private static final String STORE_DATA_FOLDER = DATA_FOLDER + "storeData" + SEPARATOR;
    private static final String STORE_ID_BUCKET_PATH = DATA_FOLDER + "storeIDBucket.json";
    private static final String LIST_STORE_PATH = DATA_FOLDER + "storeList.json";
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LogInPanel;
    private javax.swing.JPanel SignUpPanel;
    private javax.swing.JLabel blankSignUpPasswordWarning;
    private javax.swing.JButton forgotPasswordButton;
    private javax.swing.JLabel illegalLogInEmailWarning;
    private javax.swing.JLabel illegalSignUpEmailWarning;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JButton logInButton;
    private javax.swing.JTextField logInEmail;
    private javax.swing.JPasswordField logInPassword;
    private javax.swing.JLabel passwordWarning;
    private javax.swing.JCheckBox rememberPasswordCheckBox;
    private javax.swing.JPasswordField retypePassword;
    private javax.swing.JButton signUpButton;
    private javax.swing.JTextField signUpEmail;
    private javax.swing.JPasswordField signUpPassword;
    private javax.swing.JTabbedPane tabPane;
    // End of variables declaration//GEN-END:variables
}
