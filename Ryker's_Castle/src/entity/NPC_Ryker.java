package entity;


import java.util.Random;

import main.GamePanel;

public class NPC_Ryker extends Entity{
	
	public NPC_Ryker(GamePanel gp) {
		
		super(gp);
		
		direction = "down";
		speed = 3;
		
		getImage();
	}
	public void getImage() {
		
		
		up1 = setup("/npc/ryker_up1");
		up2 = setup("/npc/ryker_up2");
		down1 = setup("/npc/ryker_down1");
		down2 = setup("/npc/ryker_down2");
		left1 = setup("/npc/ryker_left1");
		left2 = setup("/npc/ryker_left2");
		right1 = setup("/npc/ryker_right1");
		right2 = setup("/npc/ryker_right2");
		
				
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
