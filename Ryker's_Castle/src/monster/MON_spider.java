package monster;

import java.util.Random;

import entity.Entity;
import main.GamePanel;
import object.OBJ_Coin_Bronze;
import object.OBJ_Heart;
import object.OBJ_ManaCrystal;
import object.OBJ_Rock;

public class MON_spider extends Entity{
	
	GamePanel gp;

	public MON_spider(GamePanel gp) {
		super(gp);
		
		this.gp = gp;
		
		type = type_monster;
		name = "crab";
		speed = 2;
		maxLife = 6;
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
		
		up1 = setup("/monster/spider_up",gp.tileSize,gp.tileSize);
		up2 = setup("/monster/spider_up",gp.tileSize,gp.tileSize);
		down1 = setup("/monster/spider_down",gp.tileSize,gp.tileSize);
		down2 = setup("/monster/spider_down",gp.tileSize,gp.tileSize);
		left1 = setup("/monster/spider_left",gp.tileSize,gp.tileSize);
		left2 = setup("/monster/spider_left",gp.tileSize,gp.tileSize);
		right1 = setup("/monster/spider_right",gp.tileSize,gp.tileSize);
		right2 = setup("/monster/spider_right",gp.tileSize,gp.tileSize);
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
