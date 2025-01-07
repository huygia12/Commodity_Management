package view;

import model.entities.Store;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public final class Header extends javax.swing.JPanel {

    public Header(Store store) {
        initComponents();
        this.store = store;
        setStoreInfor();
        // Kiểm tra nếu có tệp avatar.png trong thư mục gốc của dự án, thì tải hình ảnh lên
        File avatarFile = new File("data/avatar.png");
        if (avatarFile.exists()) {
            try {
                BufferedImage avatarImage = ImageIO.read(avatarFile);
                setChangeLabelImage(avatarImage);
            } catch (IOException e) {
                Logger.getLogger(this.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    public void setStoreInfor() {
        this.storeNameLabel.setText(store.getStoreName());
        this.storeEmailLabel.setText("Email: " + store.getEmail());

    }

    public void setChangeLabelImage(BufferedImage image) {
        if (image != null) {
            // Lưu trữ hình ảnh gốc vào biến scaledImage
            this.scaledImage = image;
            // Vẽ lại panel khi hình ảnh thay đổi
            repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (scaledImage != null) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Tạo vùng cắt hình tròn
            Ellipse2D.Double circle = new Ellipse2D.Double(60, 10, 100, 100);
            g2d.clip(circle);

            // Vẽ scaledImage trong vùng cắt hình tròn
            g2d.drawImage(scaledImage, 60, 10, 100, 100, null);
            g2d.dispose();

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        storeNameLabel = new javax.swing.JLabel();
        storeEmailLabel = new javax.swing.JLabel();
        changeLabel = new javax.swing.JLabel();

        storeNameLabel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        storeNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        storeNameLabel.setText(" ");

        storeEmailLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        storeEmailLabel.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(storeEmailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(changeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(storeNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(changeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(storeNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(storeEmailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public BufferedImage scaledImage;
    private Store store;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel changeLabel;
    private javax.swing.JLabel storeEmailLabel;
    private javax.swing.JLabel storeNameLabel;
    // End of variables declaration//GEN-END:variables
}
