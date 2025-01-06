package gui;

import config.HibernateConfig;
import dao.ProductDAO;
import java.util.List;
import java.util.UUID;
import java.util.stream.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.entities.Product;
import model.entities.Store;
import util.ProductUtil;

public class RepoPanel extends javax.swing.JPanel {

    public RepoPanel() {
        initComponents();
    }

    public void defaultSettings() {
        invalidPriceLabel.setVisible(false);
        shipmentsButton.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        repoManagementPanel = new javax.swing.JPanel();
        tablePanel = new javax.swing.JPanel();
        searchLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();
        searchTextField = new javax.swing.JTextField();
        IDTextField = new javax.swing.JTextField();
        IDLabel = new javax.swing.JLabel();
        totalQuantityLabel = new javax.swing.JLabel();
        totalQuantityTextField = new javax.swing.JTextField();
        nameLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        manuFacturerLabel = new javax.swing.JLabel();
        manufacturerTextField = new javax.swing.JTextField();
        unitTextField = new javax.swing.JTextField();
        listPriceLabel = new javax.swing.JLabel();
        priceTextField = new javax.swing.JTextField();
        invalidPriceLabel = new javax.swing.JLabel();
        deleteButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        shipmentsButton = new javax.swing.JButton();
        manuFacturerLabel1 = new javax.swing.JLabel();
        refreshBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 204, 255));
        setToolTipText("");
        setMinimumSize(new java.awt.Dimension(1400, 800));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(1400, 800));
        setLayout(new java.awt.BorderLayout());

        repoManagementPanel.setBackground(new java.awt.Color(0, 204, 255));
        repoManagementPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), 2), "REPOSITORY", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 3, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        repoManagementPanel.setMinimumSize(new java.awt.Dimension(1400, 800));
        repoManagementPanel.setPreferredSize(new java.awt.Dimension(1400, 800));
        repoManagementPanel.setLayout(new java.awt.BorderLayout());

        tablePanel.setBackground(new java.awt.Color(0, 204, 255));
        tablePanel.setMinimumSize(new java.awt.Dimension(1350, 620));
        tablePanel.setPreferredSize(new java.awt.Dimension(1350, 620));
        tablePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchLabel.setText("Tìm kiếm:");
        tablePanel.add(searchLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 20, 90, 30));

        productTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Đơn vị", "Nhà sản xuất", "Giá sản phẩm", "Tổng số lượng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        productTable.setMinimumSize(new java.awt.Dimension(90, 500));
        productTable.setName(""); // NOI18N
        productTable.setPreferredSize(new java.awt.Dimension(1000, 500));
        productTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        productTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        productTable.setShowGrid(true);
        productTable.getTableHeader().setReorderingAllowed(false);
        productTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                productTableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(productTable);
        productTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (productTable.getColumnModel().getColumnCount() > 0) {
            productTable.getColumnModel().getColumn(0).setPreferredWidth(5);
            productTable.getColumnModel().getColumn(0).setHeaderValue("Mã SP");
            productTable.getColumnModel().getColumn(1).setHeaderValue("Tên SP");
            productTable.getColumnModel().getColumn(2).setHeaderValue("Đơn vị");
            productTable.getColumnModel().getColumn(3).setHeaderValue("Nhà sản xuất");
            productTable.getColumnModel().getColumn(4).setHeaderValue("Giá sản phẩm");
            productTable.getColumnModel().getColumn(5).setHeaderValue("Tổng số lượng");
        }

        tablePanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 1360, 550));
        tablePanel.add(searchTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 20, 270, 30));
        tablePanel.add(IDTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 170, 30));

        IDLabel.setText("Mã sản phẩm:");
        tablePanel.add(IDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 18, 110, 30));

        totalQuantityLabel.setText("Tổng số lượng:");
        tablePanel.add(totalQuantityLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 118, 110, 30));

        totalQuantityTextField.setEditable(false);
        totalQuantityTextField.setEnabled(false);
        tablePanel.add(totalQuantityTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 170, 30));

        nameLabel.setText("Tên sản phẩm:");
        tablePanel.add(nameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 110, 30));
        tablePanel.add(nameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 170, 30));

        manuFacturerLabel.setText("Đơn vị");
        tablePanel.add(manuFacturerLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, 60, 30));
        tablePanel.add(manufacturerTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, 180, 30));
        tablePanel.add(unitTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, 180, 30));

        listPriceLabel.setText("Giá sản phẩm:");
        tablePanel.add(listPriceLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 100, 30));
        tablePanel.add(priceTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 180, 30));

        invalidPriceLabel.setForeground(new java.awt.Color(255, 51, 51));
        invalidPriceLabel.setText("Giá không hợp lệ!");
        tablePanel.add(invalidPriceLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 30, -1, -1));

        deleteButton.setText("Xóa");
        deleteButton.setMaximumSize(new java.awt.Dimension(117, 23));
        deleteButton.setMinimumSize(new java.awt.Dimension(117, 23));
        deleteButton.setPreferredSize(new java.awt.Dimension(117, 23));
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        tablePanel.add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 110, 90, 40));

        addButton.setText("Thêm");
        addButton.setMaximumSize(new java.awt.Dimension(117, 23));
        addButton.setMinimumSize(new java.awt.Dimension(117, 23));
        addButton.setPreferredSize(new java.awt.Dimension(117, 23));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        tablePanel.add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 110, 90, 40));

        editButton.setText("Sửa");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });
        tablePanel.add(editButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 110, 90, 40));

        shipmentsButton.setText("Xem lô hàng");
        shipmentsButton.setMaximumSize(new java.awt.Dimension(117, 23));
        shipmentsButton.setMinimumSize(new java.awt.Dimension(117, 23));
        shipmentsButton.setPreferredSize(new java.awt.Dimension(117, 23));
        shipmentsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shipmentsButtonActionPerformed(evt);
            }
        });
        tablePanel.add(shipmentsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 110, 118, 40));

        manuFacturerLabel1.setText("Nhà sản xuất:");
        tablePanel.add(manuFacturerLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 118, -1, 30));

        refreshBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageIcon/reload (3).png"))); // NOI18N
        refreshBtn.setBorder(null);
        refreshBtn.setContentAreaFilled(false);
        refreshBtn.setFocusable(false);
        refreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBtnActionPerformed(evt);
            }
        });
        tablePanel.add(refreshBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 130, -1, -1));

        repoManagementPanel.add(tablePanel, java.awt.BorderLayout.PAGE_START);

        add(repoManagementPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        if (!validateRequiredFields()) {
            JOptionPane.showMessageDialog(this, "Hãy nhập đầy đủ thông tin để thêm sản phẩm mới!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String productCode = IDTextField.getText().trim();
        String productName = nameTextField.getText().trim();
        String productUnit = unitTextField.getText().trim();
        String manufacturer = manufacturerTextField.getText().trim();
        int price = Integer.parseInt(priceTextField.getText().trim());

        Product newProduct = Product.builder().productCode(productCode)
                .productName(productName)
                .unit(productUnit)
                .provider(manufacturer)
                .price(price)
                .build();

        boolean result = productDAO.addProduct(newProduct, this.hibernateConfig.getEntityManager());

        if (!result) {
            JOptionPane.showMessageDialog(this, "Thêm thất bại!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        this.store.getProducts().add(newProduct);
        addProductToTable(newProduct);
        clearInputFields();
        JOptionPane.showMessageDialog(this, "Thêm thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_addButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int selectedRowIndex = productTable.getSelectedRow();

        if (selectedRowIndex < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một sản phẩm cần xóa!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int reply = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa sản phẩm này không?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            UUID productId = UUID.fromString((String) productTableModel.getValueAt(selectedRowIndex, 6));

            boolean result = productDAO.deleteProduct(productId, this.hibernateConfig.getEntityManager());
            if (!result) {
                JOptionPane.showMessageDialog(this, "Xóa thất bại!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            this.store.getProducts().removeIf(product -> product.getProductId().equals(productId));

            productTableModel.removeRow(selectedRowIndex);
            JOptionPane.showMessageDialog(this, "Sản phẩm đã được xóa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        int selectedRowIndex = productTable.getSelectedRow();

        if (selectedRowIndex < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một sản phẩm để cập nhật thông tin!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!validateRequiredFields()) {
            JOptionPane.showMessageDialog(this, "Hãy nhập đầy đủ thông tin để cập nhật sản phẩm!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String productCode = IDTextField.getText().trim();
        String productName = nameTextField.getText().trim();
        String productUnit = unitTextField.getText().trim();
        String manufacturer = manufacturerTextField.getText().trim();
        int price = Integer.parseInt(priceTextField.getText().trim());

        int reply = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn chỉnh sửa thông tin sản phẩm này?", "Xác nhận chỉnh sửa", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            UUID productId = UUID.fromString((String) productTableModel.getValueAt(selectedRowIndex, 6));
            Product newProduct = Product.builder().productId(productId)
                    .productCode(productCode)
                    .productName(productName)
                    .unit(productUnit)
                    .provider(manufacturer)
                    .price(price)
                    .build();
            boolean result = productDAO.addProduct(newProduct, this.hibernateConfig.getEntityManager());

            if (!result) {
                JOptionPane.showMessageDialog(this, "Chỉnh sửa thất bại!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            this.store.setProducts(this.store.getProducts().stream().map(product
                    -> (product.getProductId().equals(productId)) ? newProduct : product).collect(Collectors.toList()));

            displayProducts(this.store.getProducts());
            JOptionPane.showMessageDialog(this, "Thông tin sản phẩm đã được cập nhật thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            clearInputFields();
        }
    }//GEN-LAST:event_editButtonActionPerformed

    private void productTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productTableMouseReleased
        clearInputFields();
        int selectedRowIndex = productTable.getSelectedRow();
        if (selectedRowIndex >= 0) {
            shipmentsButton.setEnabled(true);
            
            IDTextField.setText(productTableModel.getValueAt(productTable.getSelectedRow(), 0).toString());
            nameTextField.setText(productTableModel.getValueAt(productTable.getSelectedRow(), 1).toString());
            unitTextField.setText(productTableModel.getValueAt(productTable.getSelectedRow(), 2).toString());
            manufacturerTextField.setText(productTableModel.getValueAt(productTable.getSelectedRow(), 3).toString());
            priceTextField.setText(productTableModel.getValueAt(productTable.getSelectedRow(), 4).toString());
            totalQuantityTextField.setText(productTableModel.getValueAt(productTable.getSelectedRow(), 5).toString());
            selectedProductId =  UUID.fromString((String)productTableModel.getValueAt(productTable.getSelectedRow(), 6));
        }
    }//GEN-LAST:event_productTableMouseReleased

    private void shipmentsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shipmentsButtonActionPerformed
        if(selectedProductId == null){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một sản phẩm trong bảng!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        };
        
        Product product = productDAO.getProduct(selectedProductId, this.hibernateConfig.getEntityManager());
        if(product == null){
            JOptionPane.showMessageDialog(this, "Sản phẩm không tồn tại!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        mf.switchShipmentPanel(product);
    }//GEN-LAST:event_shipmentsButtonActionPerformed

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        displayProducts(this.store.getProducts());
        clearInputFields();
    }//GEN-LAST:event_refreshBtnActionPerformed

    private void displayProducts(List<Product> products) {
        productTableModel.setRowCount(0);

        if (productTableModel.getColumnCount() == 6) {
            productTableModel.addColumn("ProductId");
        }
        for (Product product : products) {
            Object[] rowData = {
                product.getProductCode(),
                product.getProductName(),
                product.getUnit(),
                product.getProvider(),
                product.getPrice(),
                ProductUtil.getTotalQuantity(product),
                product.getProductId(),};
            productTableModel.addRow(rowData);
        }

        productTable.getColumnModel().getColumn(6).setMaxWidth(0);
        productTable.getColumnModel().getColumn(6).setMinWidth(0);
        productTable.getColumnModel().getColumn(6).setPreferredWidth(0);
    }

    private void addProductToTable(Product product) {
        productTableModel.addRow(new Object[]{
            product.getProductCode(),
            product.getProductName(),
            product.getUnit(),
            product.getProvider(),
            product.getPrice(),
            ProductUtil.getTotalQuantity(product),
            product.getProductId()
        });
        productTable.getColumnModel().getColumn(6).setMaxWidth(0);
        productTable.getColumnModel().getColumn(6).setMinWidth(0);
        productTable.getColumnModel().getColumn(6).setPreferredWidth(0);
    }

    private boolean validateRequiredFields() {
        String productCode = IDTextField.getText().trim();
        String productName = nameTextField.getText().trim();
        String productUnit = unitTextField.getText().trim();
        String manufacturer = manufacturerTextField.getText().trim();

        try {
            Integer.valueOf(priceTextField.getText().trim());
        } catch (NumberFormatException e) {
            invalidPriceLabel.setVisible(true);
            return false;
        }

        return !productCode.isBlank() && !productName.isBlank() && !productUnit.isBlank() && !manufacturer.isBlank();
    }

    public void clearInputFields() {
        IDTextField.setText("");
        nameTextField.setText("");
        unitTextField.setText("");
        manufacturerTextField.setText("");
        priceTextField.setText("");
        totalQuantityTextField.setText("");

        invalidPriceLabel.setVisible(false);
    }

    public void setup(HibernateConfig hibernateConfig, Store store, MainFrame mf) {
        this.store = store;
        this.mf = mf;
        this.hibernateConfig = hibernateConfig;
        
        productTableModel = (DefaultTableModel) productTable.getModel();
        defaultSettings();
    }

    private UUID selectedProductId;
    private ProductDAO productDAO;
    private HibernateConfig hibernateConfig;
    private MainFrame mf;
    private Store store;
    public static RepoPanel Instance;
    private DefaultTableModel productTableModel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IDLabel;
    private javax.swing.JTextField IDTextField;
    private javax.swing.JButton addButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel invalidPriceLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel listPriceLabel;
    private javax.swing.JLabel manuFacturerLabel;
    private javax.swing.JLabel manuFacturerLabel1;
    private javax.swing.JTextField manufacturerTextField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JTextField priceTextField;
    private javax.swing.JTable productTable;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JPanel repoManagementPanel;
    private javax.swing.JLabel searchLabel;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JButton shipmentsButton;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JLabel totalQuantityLabel;
    private javax.swing.JTextField totalQuantityTextField;
    private javax.swing.JTextField unitTextField;
    // End of variables declaration//GEN-END:variables
}
