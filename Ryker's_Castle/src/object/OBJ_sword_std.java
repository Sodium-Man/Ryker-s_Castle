package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_sword_std extends Entity{

	public OBJ_sword_std(GamePanel gp) {
		super(gp);
		
		type = type_sword;
		name = "Normal sword";
		down1 = setup("/objects/sword",gp.tileSize,gp.tileSize);
		attackValue = 1;
		attackArea.width = 36;
		attackArea.height = 36;
		description = "[" + name + "]\n a reliable weapon";
	}

}
