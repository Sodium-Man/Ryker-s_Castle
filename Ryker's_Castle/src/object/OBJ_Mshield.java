package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Mshield extends Entity{

	public OBJ_Mshield(GamePanel gp) {
		super(gp);
		
		type = type_shield;
		name = "Metal shield";
		down1 = setup("/objects/metal_sheild",gp.tileSize,gp.tileSize);
		defenseValue = 5;
		description = "[" + name + "]\nstrong metal sheild";
	}

}
