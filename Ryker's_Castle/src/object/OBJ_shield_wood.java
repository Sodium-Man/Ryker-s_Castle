package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_shield_wood extends Entity{

	public OBJ_shield_wood(GamePanel gp) {
		super(gp);
		
		type = type_shield;
		name = "Wood shield";
		down1 = setup("/objects/shield",gp.tileSize,gp.tileSize);
		defenseValue = 1;
		description = "[" + name + "]\n standard sheild";

	}

}
