package monster;

import java.util.Random;

import entity.Entity;
import main.GamePanel;
import object.OBJ_Coin_Bronze;
import object.OBJ_Heart;
import object.OBJ_ManaCrystal;
import object.OBJ_Rock;

public class MON_Ryker extends Entity{
	
	GamePanel gp;

	public MON_Ryker(GamePanel gp) {
		super(gp);
		
		this.gp = gp;
		
		type = type_monster;
		name = "crab";
		speed = 2;
		maxLife = 20;
		life = maxLife;
		attack = 4;
		defense = 0;
		exp = 2;
		projectile = new OBJ_Rock(gp);
		
		solidArea.x = 8;
		solidArea.y = 16;
		solidArea.width = 32;
		solidArea.height = 32;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		getImage();
		
	}
	public void getImage() {
		
		up1 = setup("/monster/ryker_up1",gp.tileSize,gp.tileSize);
		up2 = setup("/monster/ryker_up2",gp.tileSize,gp.tileSize);
		down1 = setup("/monster/ryker_down1",gp.tileSize,gp.tileSize);
		down2 = setup("/monster/ryker_down2",gp.tileSize,gp.tileSize);
		left1 = setup("/monster/ryker_left1",gp.tileSize,gp.tileSize);
		left2 = setup("/monster/ryker_left2",gp.tileSize,gp.tileSize);
		right1 = setup("/monster/ryker_right1",gp.tileSize,gp.tileSize);
		right2 = setup("/monster/ryker_right2",gp.tileSize,gp.tileSize);
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
		
		int i = new Random().nextInt(100)+1;
		if(i > 99 && projectile.alive == false && shotAvailableCounter == 30) {
			
			projectile.set(worldX, worldY, direction, true, this);
			gp.projectileList.add(projectile);
			shotAvailableCounter = 0;
		}
		
	}
	public void damageReaction() {
		
		actionLockCounter = 0;
		direction = gp.player.direction;
	}
	public void checkDrop() {
		
		int i = new Random().nextInt(100)+1;
		
		if(i <50) {
			dropItem(new OBJ_Coin_Bronze(gp));
		}
		if(i >= 50 && i < 75) {
			dropItem(new OBJ_Heart(gp));
		}
		if(i >= 75 && i < 100) {
			dropItem(new OBJ_ManaCrystal(gp));
		}
	}

}
