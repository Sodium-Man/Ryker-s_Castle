package object;


import entity.Entity;
import main.GamePanel;

public class OBJ_RKey extends Entity {
	
	
	public OBJ_RKey(GamePanel gp) {
		super(gp);
		
		name = "Rkey";
		down1 = setup("/objects/ryker_key");
	}

}
