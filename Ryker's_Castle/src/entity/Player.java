package entity;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;
import main.UtilityTool;

public class Player extends Entity{
	
	KeyHandler keyH;
	
	public final int screenX;
	public final int screenY;
	
	public Player(GamePanel gp,KeyHandler keyH) {
		
		super(gp);
		this.keyH=keyH;
		
		screenX=gp.screenWidth/2-(gp.tileSize/2);
		screenY=gp.screenHeight/2-(gp.tileSize/2);
		
		solidArea = new Rectangle();
			solidArea.x = 8;
			solidArea.y = 16;
			
			solidAreaDefaultX = solidArea.x;
			solidAreaDefaultY = solidArea.y;
			
			solidArea.width = 32;
			solidArea.height = 32;
		
		setDefaultValue();
		getPlayerImage();
	}
	public void setDefaultValue() {
		worldX=gp.tileSize*12;
		worldY=gp.tileSize*2;
		speed=4;
		direction="down";
		
		maxLife = 6;
		life = maxLife;
	}
	public void getPlayerImage() {
		
	idle = setup("/player/tile_0085");	
	up1 = setup("/player/sprite_04");
	up2 = setup("/player/sprite_05");
	down1 = setup("/player/sprite_01");
	down2 = setup("/player/sprite_02");
	left1 = setup("/player/sprite_07");
	left2 = setup("/player/sprite_08");
	right1 = setup("/player/sprite_10");
	right2 = setup("/player/sprite_11");
	
			
	}
	
	
	public void update(){
		
		if(keyH.upPressed==true||keyH.downPressed==true
				||keyH.leftPressed==true||keyH.rightPressed==true) {

		if(keyH.upPressed==true) {
			direction="up";
		}
		else if(keyH.downPressed==true) {
			direction="down";
		}
		else if(keyH.leftPressed==true) {
			direction ="left";
		}
		else if(keyH.rightPressed==true) {
			direction="right";
		}
		
		collisionOn=false;
		gp.cChecker.checkTile(this);
		
		int objIndex = gp.cChecker.checkObject(this, true);
		pickUpObject(objIndex);
		
		//check npc collision
		int npcIndex = gp.cChecker.checkEntity(this, gp.npc);
		interactNPC(npcIndex);
		
		//check monster collision
		int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
		contactMonster(monsterIndex);
		
		//check Event
		gp.eHandler.checkEvent();
		gp.keyH.enterPressed = false;
		
		if(collisionOn==false) {
			switch(direction) {
			case "up": worldY -= speed; break;
			case "down": worldY += speed; break;
			case "left": worldX -=speed; break;
			case "right": worldX +=speed; break;
			}
		}
		
		spriteCounter++;
		if(spriteCounter>10) {
			if(spriteNum==1) {
				spriteNum=2;
			}
			else if(spriteNum==2) {
				spriteNum=1;
			}
			spriteCounter=0;
		}
	}
		if(invincible == true) {
			invincibleCounter++;
			if(invincibleCounter > 60) {
				invincible =false;
				invincibleCounter = 0;
			}
		}
		
}
	public void pickUpObject(int i) {
		
		if(i !=999) {
			
			
		}
		
	}
	public void interactNPC(int i) {
		
		if(i !=999) {
			
			if(gp.keyH.enterPressed == true) {
				
				gp.gameState = gp.dialougeState;
				gp.npc[i].speak();
				
			}
		}
	}
	public void contactMonster(int i) {
		if(i != 999) {
			if(invincible == false) {
				life -= 1;
				invincible = true;
			}
		}
	}
	public void draw(Graphics2D g2) {
	
		BufferedImage image =null;
		switch(direction) {
		case "up":
			if(spriteNum==1) {
				image=up1;
			}
			if(spriteNum==2) {
				image=up2;
			}
			break;
			
		case "down":
			if(spriteNum==1) {
				image=down1;
			}
			if(spriteNum==2) {
				image=down2;
			}
			break;
			
		case "left":
			if(spriteNum==1) {
				image=left1;
			}
			if(spriteNum==2) {
				image=left2;
			}
			break;
			
		case "right":
			if(spriteNum==1) {
				image=right1;
			}
			if(spriteNum==2) {
				image=right2;
			}
			break;	
		}
		if(invincible == true) {
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f));
		}
		g2.drawImage(image, screenX, screenY, null);
		
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));

	}
}
