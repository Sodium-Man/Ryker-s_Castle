package main;

import entity.NPC_Ryker;
import monster.MON_Crab;
import monster.MON_ghost_temp;
import object.OBJ_Axe;
import object.OBJ_Chest;
import object.OBJ_Coin_Bronze;
import object.OBJ_Hpotion;
import object.OBJ_Mshield;
import object.OBJ_RKey;
import object.OBJ_SpeedPotion;
import object.OBJ_door;
import tile_interactive.IT_BrTree;
import tile_interactive.IT_Portal;

public class AssetSetter {
	
	GamePanel gp;
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}

	public void setObject() {
		
		int mapNum = 0;
		int i = 0;
		
		i++;
	}
	public void setNPC() {
		
		int mapNum = 0;
		
	}
	public void setMonster() {
		
		int mapNum = 0;
		int i = 0;
		
		gp.monster[mapNum][i] = new MON_ghost_temp(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*37;
		gp.monster[mapNum][i].worldY = gp.tileSize*7;
		i++;
	}
	public void setInteractiveTile() {
		
		int mapNum = 0;
		int i = 0;
		gp.iTile[mapNum][i] = new IT_Portal(gp,16,34);i++;
	}
}
