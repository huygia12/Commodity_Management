package view;

import com.formdev.flatlaf.FlatLightLaf;
import config.HibernateConfig;
import dao.ShiftDAO;
import dao.impl.ShiftDAOImpl;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.WindowEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaswingdev.drawer.Drawer;
import javaswingdev.drawer.DrawerController;
import javaswingdev.drawer.DrawerItem;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import model.entities.Product;
import model.entities.Shift;
import model.entities.Store;
import model.enums.ShiftState;
import util.AppImage;

public class MainFrame extends javax.swing.JFrame {

    public MainFrame(Store store) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(this.getName()).log(Level.SEVERE, null, ex);
        }
        this.hibernateConfig = new HibernateConfig();
        this.shiftDAO = new ShiftDAOImpl();
        this.store = store;
        fetchLatestShift();
        initComponents();
        initSideBar();
        this.cardLayout = (CardLayout) displayPanel.getLayout();

        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (showCloseMessage()) {
                    System.exit(0);
                }
            }
        });
        setIconImage(new ImageIcon(getClass()
                .getResource(AppImage.APP_ICON)).getImage());
        this.setLocationRelativeTo(null);

        realTimeClock();
        setupPanels();
        switchRepoPanel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toolBarPanel = new javax.swing.JPanel();
        shiftIDLabel = new javax.swing.JLabel();
        dateTimeSeparator = new javax.swing.JSeparator();
        dateLabel = new javax.swing.JLabel();
        timeLabel = new javax.swing.JLabel();
        dateTextField = new javax.swing.JFormattedTextField();
        timeTextField = new javax.swing.JFormattedTextField();
        openSideBarLabel = new javax.swing.JLabel();
        displayPanel = new javax.swing.JPanel();
        settingsPanel1 = new view.SettingsPanel();
        shiftPanel1 = new view.ShiftPanel();
        purchasePanel1 = new view.PurchasePanel();
        historyPanel1 = new view.HistoryPanel();
        employJPanel1 = new view.EmployJPanel();
        repoPanel1 = new view.RepoPanel();
        shipmentPanel1 = new view.ShipmentPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Phần mềm quản lý bán hàng");
        setAutoRequestFocus(false);
        setFocusable(false);
        setMinimumSize(new java.awt.Dimension(1400, 870));
        setPreferredSize(new java.awt.Dimension(1400, 870));
        setResizable(false);

        toolBarPanel.setBackground(new java.awt.Color(255, 255, 255));
        toolBarPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        toolBarPanel.setMinimumSize(new java.awt.Dimension(1000, 35));
        toolBarPanel.setOpaque(false);
        toolBarPanel.setPreferredSize(new java.awt.Dimension(1000, 35));

        shiftIDLabel.setFont(new java.awt.Font("MTO Telephone", 1, 16)); // NOI18N

        dateTimeSeparator.setOrientation(javax.swing.SwingConstants.VERTICAL);

        dateLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        dateLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageIcon/icons8-calender-30.png"))); // NOI18N
        dateLabel.setText("Lịch:");
        dateLabel.setFocusable(false);
        dateLabel.setMinimumSize(new java.awt.Dimension(73, 20));
        dateLabel.setPreferredSize(new java.awt.Dimension(73, 20));

        timeLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        timeLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageIcon/icons8-history-30.png"))); // NOI18N
        timeLabel.setText("Giờ :");
        timeLabel.setFocusable(false);
        timeLabel.setMinimumSize(new java.awt.Dimension(34, 20));
        timeLabel.setPreferredSize(new java.awt.Dimension(34, 20));

        dateTextField.setEditable(false);
        dateTextField.setBorder(null);
        dateTextField.setFocusable(false);
        dateTextField.setPreferredSize(new java.awt.Dimension(126, 22));

        timeTextField.setEditable(false);
        timeTextField.setBorder(null);
        timeTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance())));
        timeTextField.setFocusable(false);
        timeTextField.setPreferredSize(new java.awt.Dimension(126, 22));

        openSideBarLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageIcon/icons8-menu-40.png"))); // NOI18N
        openSideBarLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                openSideBarLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout toolBarPanelLayout = new javax.swing.GroupLayout(toolBarPanel);
        toolBarPanel.setLayout(toolBarPanelLayout);
        toolBarPanelLayout.setHorizontalGroup(
            toolBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(toolBarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(openSideBarLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(shiftIDLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 885, Short.MAX_VALUE)
                .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateTimeSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(timeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(timeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        toolBarPanelLayout.setVerticalGroup(
            toolBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(toolBarPanelLayout.createSequentialGroup()
                .addGroup(toolBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(toolBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(dateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(toolBarPanelLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(shiftIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(openSideBarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(toolBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(dateTimeSeparator, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, toolBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(timeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(timeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(7, 7, 7))
        );

        getContentPane().add(toolBarPanel, java.awt.BorderLayout.PAGE_START);

        displayPanel.setFocusable(false);
        displayPanel.setMaximumSize(new java.awt.Dimension(2147483647, 630));
        displayPanel.setMinimumSize(new java.awt.Dimension(1000, 580));
        displayPanel.setOpaque(false);
        displayPanel.setPreferredSize(new java.awt.Dimension(1000, 580));
        displayPanel.setLayout(new java.awt.CardLayout());
        displayPanel.add(settingsPanel1, "card2");
        displayPanel.add(shiftPanel1, "card3");
        displayPanel.add(purchasePanel1, "card4");
        displayPanel.add(historyPanel1, "card5");
        displayPanel.add(employJPanel1, "card6");
        displayPanel.add(repoPanel1, "card7");
        displayPanel.add(shipmentPanel1, "card8");

        getContentPane().add(displayPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openSideBarLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openSideBarLabelMouseClicked
        if (drawerCtr.isShow()) {
            drawerCtr.hide();
        } else {
            drawerCtr.show();
        }
    }//GEN-LAST:event_openSideBarLabelMouseClicked

    private void fetchLatestShift() {
        this.shift = shiftDAO.getLatestShift(this.hibernateConfig.getEntityManager());
        if (this.shift == null) {
            this.shift = shiftDAO.addShift(store, this.hibernateConfig.getEntityManager());
        }
    }

    private void setupPanels() {
        purchasePanel1.setup(hibernateConfig, store);
        employJPanel1.setup(hibernateConfig, store);
        repoPanel1.setup(hibernateConfig, store, this);
        shipmentPanel1.setup(hibernateConfig, store, this);
        shiftPanel1.setup(hibernateConfig, store, this);
        settingsPanel1.setup(hibernateConfig, store, header);
        historyPanel1.setup(hibernateConfig, store);
        header.setStoreInfor();
    }

    private void initSideBar() {
        DrawerItem productDrawerItem = new DrawerItem("Sản phẩm").icon(new ImageIcon(getClass().getResource("/ImageIcon/icons8-product-35.png"))).build();
        productDrawerItem.setFont(new java.awt.Font("Segoe UI", 1, 16));
        productDrawerItem.setHorizontalAlignment(JButton.LEADING);
        productDrawerItem.setFocusable(false);
        DrawerItem purchaseDrawerItem = new DrawerItem("Bán hàng").icon(new ImageIcon(getClass().getResource("/ImageIcon/icons8-add-basket-35.png"))).build();
        purchaseDrawerItem.setFont(new java.awt.Font("Segoe UI", 1, 16));
        purchaseDrawerItem.setHorizontalAlignment(JButton.LEADING);
        purchaseDrawerItem.setFocusable(false);
        DrawerItem shiftDrawerItem = new DrawerItem("Ca hiện tại").icon(new ImageIcon(getClass().getResource("/ImageIcon/icons8-static-35.png"))).build();
        shiftDrawerItem.setFont(new java.awt.Font("Segoe UI", 1, 16));
        shiftDrawerItem.setHorizontalAlignment(JButton.LEADING);
        shiftDrawerItem.setFocusable(false);
        DrawerItem employeeDrawerItem = new DrawerItem("Nhân viên").icon(new ImageIcon(getClass().getResource("/ImageIcon/icons8-name-tag-35.png"))).build();
        employeeDrawerItem.setFont(new java.awt.Font("Segoe UI", 1, 16));
        employeeDrawerItem.setHorizontalAlignment(JButton.LEADING);
        employeeDrawerItem.setFocusable(false);
        DrawerItem historyDrawerItem = new DrawerItem("Lịch sử").icon(new ImageIcon(getClass().getResource("/ImageIcon/icons8-history-35.png"))).build();
        historyDrawerItem.setFont(new java.awt.Font("Segoe UI", 1, 16));
        historyDrawerItem.setHorizontalAlignment(JButton.LEADING);
        historyDrawerItem.setFocusable(false);
        DrawerItem settingsDrawerItem = new DrawerItem("Cài đặt").icon(new ImageIcon(getClass().getResource("/ImageIcon/icons8-settings-35.png"))).build();
        settingsDrawerItem.setFont(new java.awt.Font("Segoe UI", 1, 16));
        settingsDrawerItem.setHorizontalAlignment(JButton.LEADING);
        settingsDrawerItem.setFocusable(false);
        DrawerItem logoutDrawerItem = new DrawerItem("Đăng xuất").icon(new ImageIcon(getClass().getResource("/ImageIcon/icons8-logout-30.png"))).build();
        logoutDrawerItem.setFocusable(false);
        header = new Header(store);

        drawerCtr = Drawer.newDrawer(this)
                .header(header)
                .separator(2, Color.LIGHT_GRAY)
                .space(10)
                .duration(300)
                .backgroundTransparent(0.3f)
                .drawerWidth(230)
                .addChild(productDrawerItem)
                .addChild(purchaseDrawerItem)
                .addChild(shiftDrawerItem)
                .addChild(employeeDrawerItem)
                .addChild(historyDrawerItem)
                .addChild(settingsDrawerItem)
                .addFooter(logoutDrawerItem)
                .event((int i, DrawerItem di) -> {
                    switchPanel(i);
                })
                .build();
    }

    private void switchPanel(int i) {
        switch (i) {
            case 0 -> {
                if (repoPanelStateCheck) {
                    displayPanel.add(repoPanel1, "repo");
                    cardLayout.show(displayPanel, "repo");
                    drawerCtr.hide();
                    repoPanel1.refreshView();
                } else {
                    displayPanel.add(shipmentPanel1, "shipment");
                    cardLayout.show(displayPanel, "shipment");
                    drawerCtr.hide();
                    shipmentPanel1.refreshView();
                }
            }
            case 1 -> {
                displayPanel.add(purchasePanel1, "purchase");
                cardLayout.show(displayPanel, "purchase");
                drawerCtr.hide();
                purchasePanel1.setEnableToAllPanel(shift.getState().equals(ShiftState.OPENED));
                if (shift.getState().equals(ShiftState.OPENED)) {
                    purchasePanel1.refreshView(this.shift);
                } else {
                    showShiftNotOpenWarning();
                }
            }
            case 2 -> {
                displayPanel.add(shiftPanel1, "shift");
                cardLayout.show(displayPanel, "shift");
                drawerCtr.hide();
                shiftPanel1.refreshView(this.shift);
            }
            case 3 -> {
                displayPanel.add(employJPanel1, "employee");
                cardLayout.show(displayPanel, "employee");
                drawerCtr.hide();
            }
            case 4 -> {
                displayPanel.add(historyPanel1, "history");
                cardLayout.show(displayPanel, "history");
                drawerCtr.hide();
                historyPanel1.refresh();
            }
            case 5 -> {
                displayPanel.add(settingsPanel1, "settings");
                cardLayout.show(displayPanel, "settings");
                drawerCtr.hide();
            }
            case 6 -> {
                if (showCloseMessage()) {
                    LogInFrame lgf = new LogInFrame();
                    lgf.setVisible(true);
                    this.dispose();
                }
            }
        }
    }

    private void realTimeClock() {
        new Thread() {
            @Override
            public void run() {
                try {
                    while (true) {
                        LocalDateTime curDateTime = LocalDateTime.now();
                        timeTextField.setText(curDateTime.format(DateTimeFormatter.ofPattern("HH:mm:ss a")));
                        dateTextField.setText(curDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(PurchasePanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.start();
    }

    private boolean showCloseMessage() {
        int choice = JOptionPane.showConfirmDialog(null,
                "Bạn chắc chắn muốn đóng chương trình?",
                "Đóng chương trình?",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        return choice == JOptionPane.YES_OPTION;
    }

    public void showShiftNotOpenWarning() {
        int choice = JOptionPane.showConfirmDialog(displayPanel, "Thực hiện mở ca ngay?",
                "Không có ca hiện tại!", JOptionPane.WARNING_MESSAGE);
        if (choice == JOptionPane.OK_OPTION) {
            switchPanel(2);
        }
    }

    public void switchShipmentPanel(Product product) {
        shipmentPanel1.setProduct(product);
        shipmentPanel1.defaultInputNButtonSetting();
        repoPanelStateCheck = false;
        switchPanel(0);
    }

    public void switchRepoPanel() {
        repoPanelStateCheck = true;
        switchPanel(0);
    }
    
    public void switchShiftPanel() {
        this.shift = shiftDAO.addShift(store, this.hibernateConfig.getEntityManager());
        switchPanel(2);
    }

    private final ShiftDAO shiftDAO;
    private final HibernateConfig hibernateConfig;
    private Shift shift;
    private final Store store;
    private boolean repoPanelStateCheck = true;
    private Header header;
    private final CardLayout cardLayout;
    private DrawerController drawerCtr;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dateLabel;
    private javax.swing.JFormattedTextField dateTextField;
    private javax.swing.JSeparator dateTimeSeparator;
    private javax.swing.JPanel displayPanel;
    private view.EmployJPanel employJPanel1;
    private view.HistoryPanel historyPanel1;
    private javax.swing.JLabel openSideBarLabel;
    private view.PurchasePanel purchasePanel1;
    private view.RepoPanel repoPanel1;
    private view.SettingsPanel settingsPanel1;
    private javax.swing.JLabel shiftIDLabel;
    private view.ShiftPanel shiftPanel1;
    private view.ShipmentPanel shipmentPanel1;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JFormattedTextField timeTextField;
    private javax.swing.JPanel toolBarPanel;
    // End of variables declaration//GEN-END:variables
}
