package main;

import java.awt.Rectangle;

public class EventHandler {
	
	GamePanel gp;
	EventRect eventRect[][][];
	
	int previousEventX, previousEventY;
	boolean canTouchEvent = true;
	
	public EventHandler(GamePanel gp) {
		this.gp = gp;
		
		eventRect = new EventRect[gp.maxMap][gp.maxWorldCol][gp.maxWorldRow];
		
		int map = 0;
		int col = 0;
		int row = 0;
		while(map < gp.maxMap && col < gp.maxWorldCol && row < gp.maxWorldRow) {
			
			eventRect[map][col][row] = new EventRect();
			eventRect[map][col][row].x = 23;
			eventRect[map][col][row].y = 23;
			eventRect[map][col][row].width = 2;
			eventRect[map][col][row].height = 2;
			eventRect[map][col][row].eventRectDefaultX = eventRect[map][col][row].x;
			eventRect[map][col][row].eventRectDefaultY = eventRect[map][col][row].y;
			
			col++;
			if(col == gp.maxWorldCol) {
				col = 0;
				row++;
				
				if(row == gp.maxWorldRow) {
					
					row = 0;
					map++;
				}
			}
		}
	}
	
	public void checkEvent() {
		
		int xDistance = Math.abs(gp.player.worldX - previousEventX);
		int yDistance = Math.abs(gp.player.worldY - previousEventY);
		int distance = Math.max(xDistance, yDistance);
		if(distance > gp.tileSize) {
			canTouchEvent=true;
		}
		
		if(canTouchEvent == true) {

			if(hit(2,18,45,"any")==true) { Psleep(gp.dialougeState); }
			else if(hit(0,33,15,"any")==true) { teleport(1,24,48); }
			else if(hit(1,24,48,"any")==true) { teleport(0,33,15); }
			else if(hit(1,23,48,"any")==true) { teleport(0,33,15); }
			else if(hit(1,31,41,"any")==true) { teleport(2,30,41); }
			else if(hit(2,30,41,"any")==true) { teleport(1,30,41); }
			else if(hit(0,16,34,"any")==true) { teleport(3,3,47); }
			else if(hit(3,3,47,"any")==true) { teleport(0,16,34); }
			else if(hit(3,3,3,"any")==true) { teleport(4,2,47); }
			else if(hit(4,2,47,"any")==true) { teleport(3,3,3); }
			else if(hit(4,2,2,"any")==true) { teleport(5,2,47); }
			else if(hit(5,2,47,"any")==true) { teleport(4,2,2); }
			else if(hit(5,2,2,"any")==true) { teleport(6,2,47); }
			else if(hit(6,2,47,"any")==true) { teleport(5,2,2); }
			else if(hit(6,3,3,"any")==true) { teleport(7,24,46); }
			else if(hit(7,24,46,"any")==true) { teleport(6,3,3); }
		}
	}
	
	public boolean hit(int map,int col,int row,String reqDirection) {
		
		boolean hit = false;
		
		if(map == gp.currentMap) {
			
			gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
			gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
			eventRect[map][col][row].x = col*gp.tileSize + eventRect[map][col][row].x;
			eventRect[map][col][row].y = row*gp.tileSize + eventRect[map][col][row].y;
			
			if(gp.player.solidArea.intersects(eventRect[map][col][row]) && eventRect[map][col][row].eventDone == false){
				
				if(gp.player.direction.contentEquals(reqDirection) || reqDirection.contains("any")) {
					
					hit = true;
					
					previousEventX = gp.player.worldX;
					previousEventY = gp.player.worldY;
					
				}
			}
			
			gp.player.solidArea.x = gp.player.solidAreaDefaultX;
			gp.player.solidArea.y = gp.player.solidAreaDefaultY;
			eventRect[map][col][row].x = eventRect[map][col][row].eventRectDefaultX;
			eventRect[map][col][row].y = eventRect[map][col][row].eventRectDefaultY;
		}
		
		return hit;
	}
	public void teleport(int map, int col, int row) {
		
		gp.currentMap = map;
		gp.player.worldX = gp.tileSize * col;
		gp.player.worldY = gp.tileSize * row;
		previousEventX = gp.player.worldX;
		previousEventY = gp.player.worldY;
		canTouchEvent = false;
		gp.playSE(13);
	}
	public void damagePit(int gameState) {
		
		gp.gameState = gameState;
		gp.playSE(6);
		gp.ui.currentDialogue = "You fell into a pit!";
		gp.player.life -= 1;
		canTouchEvent = false;
		
	}
	public void healingPool(int gameState) {
		
		if(gp.keyH.enterPressed == true) {
			gp.player.attackCanceled = true;
			gp.playSE(2);
			gp.gameState = gameState;
			gp.ui.currentDialogue = "You recovered your health \nand mana!";
			gp.player.life = gp.player.maxLife;
			gp.player.mana = gp.player.maxMana;
			gp.aSetter.setMonster();
		}
	}
public void Psleep(int gameState) {
		
		if(gp.keyH.enterPressed == true) {
			gp.player.attackCanceled = true;
			gp.playSE(2);
			gp.gameState = gameState;
			gp.ui.currentDialogue = "You slept throught the night \na new surge of engery\npasses through you!";
			gp.player.life = gp.player.maxLife;
			gp.player.mana = gp.player.maxMana;
			gp.aSetter.setMonster();
		}
	}

}
