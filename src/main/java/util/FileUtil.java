package util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import net.coobird.thumbnailator.Thumbnails;

public class FileUtil {

    public static BufferedImage loadImage(String imagePath) {
        try {
            BufferedImage originalImage = ImageIO.read(new File(imagePath));
            // Làm nét ảnh với kích thước 1000x1000 và chất lượng 1 (100%) với thumbails
            BufferedImage scaledImage = Thumbnails.of(originalImage)
                    .size(1000, 1000)
                    .outputQuality(1)
                    .asBufferedImage();

            return scaledImage;
        } catch (IOException e) {
            Logger.getLogger(FileUtil.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    public static String saveImage(BufferedImage image, String folderName, String savedName) {
        try {
            String srcPath = System.getProperty("user.dir") + "/" + folderName;
            String fileName = savedName +".png";
            File outputFile = new File(srcPath, fileName);

            File parentDir = outputFile.getParentFile();
            if (parentDir != null && !parentDir.exists()) {
                parentDir.mkdirs();
            }
            ImageIO.write(image, "png", outputFile);
            return folderName + "/" + fileName;
        } catch (IOException e) {
            Logger.getLogger(FileUtil.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
}
