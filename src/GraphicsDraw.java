
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class GraphicsDraw {
	//private int Xcord = 50;
	//private int Ycord = 50;
	public static final int IMAGEWIDTH = 118;
	public static final int IMAGEHEIGHT = 167;
	GraphicsDraw(){
	}
	public static JLabel importImage(String fileLocation){ //importing an image
		BufferedImage loadImage = null;
		try {
    		loadImage = ImageIO.read(new File(fileLocation));
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	JLabel cardImage = new JLabel(new ImageIcon(loadImage));
    	cardImage.setBounds(0, 0, IMAGEWIDTH, IMAGEHEIGHT);
    	return cardImage;
	}
	



  }
