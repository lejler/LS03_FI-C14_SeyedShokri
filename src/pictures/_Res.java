package pictures;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class _Res {
    public static Image image(String name){
        return new ImageIcon(_Res.class.getResource(name)).getImage();
    }
    public static BufferedImage bimage(String name){
        try {
            return ImageIO.read(_Res.class.getResource(name));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
