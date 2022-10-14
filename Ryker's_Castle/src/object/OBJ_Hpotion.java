package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Hpotion extends Entity{

	GamePanel gp;
	int value = 5;
	
	public OBJ_Hpotion(GamePanel gp) {
		super(gp);
		
		this.gp =gp;
		
		type = type_consumable;
		name = "Health Potion";
		down1 = setup("/objects/health_potion",gp.tileSize,gp.tileSize);
		description = "[" + name + "]\nIncrease health by" + value + ".";
	}
	public void use(Entity entity) {
		
		gp.gameState = gp.dialougeState;
		gp.ui.currentDialogue = "You drank the "+ name + "!\n"
				+"life recovered by "+value+".";
		entity.life += value;
		if(gp.player.life > gp.player.maxLife) {
			gp.player.life = gp.player.maxLife;
		}
		gp.playSE(2);
	}

}
