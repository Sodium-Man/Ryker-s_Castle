package main;

import entity.NPC_Ryker;
import monster.MON_Crab;
import object.OBJ_Axe;
import object.OBJ_Chest;
import object.OBJ_Coin_Bronze;
import object.OBJ_Hpotion;
import object.OBJ_Mshield;
import object.OBJ_RKey;
import object.OBJ_SpeedPotion;
import object.OBJ_door;
import tile_interactive.IT_BrTree;

public class AssetSetter {
	
	GamePanel gp;
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}

	public void setObject() {
		
		int i = 0;
		gp.obj[i] = new OBJ_RKey(gp);
		gp.obj[i].worldX = gp.tileSize * 10;
		gp.obj[i].worldY = gp.tileSize * 8;
		i++;
		gp.obj[i] = new OBJ_Coin_Bronze(gp);
		gp.obj[i].worldX = gp.tileSize * 9;
		gp.obj[i].worldY = gp.tileSize * 7;
		i++;
		gp.obj[i] = new OBJ_Axe(gp);
		gp.obj[i].worldX = gp.tileSize * 12;
		gp.obj[i].worldY = gp.tileSize * 5;
		i++;
		gp.obj[i] = new OBJ_Mshield(gp);
		gp.obj[i].worldX = gp.tileSize * 15;
		gp.obj[i].worldY = gp.tileSize * 6;
		i++;
		gp.obj[i] = new OBJ_Hpotion(gp);
		gp.obj[i].worldX = gp.tileSize * 15;
		gp.obj[i].worldY = gp.tileSize * 7;
		i++;
	}
	public void setNPC() {
		
		gp.npc[0] = new NPC_Ryker(gp);
		gp.npc[0].worldX = gp.tileSize*7;
		gp.npc[0].worldY = gp.tileSize*8;
	}
	public void setMonster() {
		
		int i = 0;
		
		gp.monster[i] = new MON_Crab(gp);
		gp.monster[i].worldX = gp.tileSize*21;
		gp.monster[i].worldY = gp.tileSize*4;
		i++;
		gp.monster[i] = new MON_Crab(gp);
		gp.monster[i].worldX = gp.tileSize*22;
		gp.monster[i].worldY = gp.tileSize*5;
		i++;
		gp.monster[i] = new MON_Crab(gp);
		gp.monster[i].worldX = gp.tileSize*23;
		gp.monster[i].worldY = gp.tileSize*4;
		i++;
		gp.monster[i] = new MON_Crab(gp);
		gp.monster[i].worldX = gp.tileSize*25;
		gp.monster[i].worldY = gp.tileSize*3;
		i++;
	}
	public void setInteractiveTile() {
		
		int i = 0;
		gp.iTile[i] = new IT_BrTree(gp,6,2);i++;
	}
}
