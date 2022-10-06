package monster;

import java.util.Random;

import entity.Entity;
import main.GamePanel;

public class MON_Crab extends Entity{

	public MON_Crab(GamePanel gp) {
		super(gp);
		
		type =2;
		name = "crab";
		speed = 2;
		maxLife = 4;
		life = maxLife;
		
		solidArea.x = 8;
		solidArea.y = 16;
		solidArea.width = 32;
		solidArea.height = 32;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		getImage();
		
	}
	public void getImage() {
		
		up1 = setup("/monster/crab_up");
		up2 = setup("/monster/crab_up");
		down1 = setup("/monster/crab_down");
		down2 = setup("/monster/crab_down");
		left1 = setup("/monster/crab_left");
		left2 = setup("/monster/crab_left");
		right1 = setup("/monster/crab_right");
		right2 = setup("/monster/crab_right");
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

}
