package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_SpeedPotion extends SuperObject{
	
	GamePanel gp;
	
public OBJ_SpeedPotion(GamePanel gp) {
	
	    this.gp = gp;
		
		name = "sPotion";
		try {
			image =ImageIO.read(getClass().getResourceAsStream("/objects/speed_potion.png"));
			uTool.scaleImage(image, gp.tileSize, gp.tileSize);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}


}
