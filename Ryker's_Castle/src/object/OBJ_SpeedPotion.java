package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_SpeedPotion extends Entity{
	
	
public OBJ_SpeedPotion(GamePanel gp) {
	
	super(gp);
		
		name = "sPotion";
		down1 = setup("/objects/speed_potion");
	}


}
