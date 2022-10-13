package monster;

import java.util.Random;

import entity.Entity;
import main.GamePanel;

public class MON_Crab extends Entity{
	
	GamePanel gp;

	public MON_Crab(GamePanel gp) {
		super(gp);
		
		this.gp = gp;
		
		type =2;
		name = "crab";
		speed = 2;
		maxLife = 4;
		life = maxLife;
		attack = 4;
		defense = 0;
		exp = 2;
		
		solidArea.x = 8;
		solidArea.y = 16;
		solidArea.width = 32;
		solidArea.height = 32;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		getImage();
		
	}
	public void getImage() {
		
		up1 = setup("/monster/crab_up",gp.tileSize,gp.tileSize);
		up2 = setup("/monster/crab_up",gp.tileSize,gp.tileSize);
		down1 = setup("/monster/crab_down",gp.tileSize,gp.tileSize);
		down2 = setup("/monster/crab_down",gp.tileSize,gp.tileSize);
		left1 = setup("/monster/crab_left",gp.tileSize,gp.tileSize);
		left2 = setup("/monster/crab_left",gp.tileSize,gp.tileSize);
		right1 = setup("/monster/crab_right",gp.tileSize,gp.tileSize);
		right2 = setup("/monster/crab_right",gp.tileSize,gp.tileSize);
	}
	public void setAction() {
		
actionLockCounter++;
		
		if(actionLockCounter == 120) {
			

			Random random = new Random();
			int i = random.nextInt(100)+1;
			
			if(i <= 25) {
				direction ="up";
			}
			if(i>25 && i<=50) {
				direction = "down";
			}
			if(i>50 && i<=75) {
				direction = "left";
			}
			if(i>75 && i<=100) {
				direction = "right";
			}
			
			actionLockCounter =0;
			
		}
		
	}
	public void damageReaction() {
		
		actionLockCounter = 0;
		direction = gp.player.direction;
	}

}
