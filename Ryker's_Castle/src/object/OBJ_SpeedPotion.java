package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_SpeedPotion extends SuperObject{
	
public OBJ_SpeedPotion() {
		
		name = "sPotion";
		try {
			image =ImageIO.read(getClass().getResourceAsStream("/objects/speed_potion.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}


}
