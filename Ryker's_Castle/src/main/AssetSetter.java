package main;

import entity.NPC_Ryker;
import monster.MON_Crab;
import object.OBJ_Chest;
import object.OBJ_RKey;
import object.OBJ_SpeedPotion;
import object.OBJ_door;

public class AssetSetter {
	
	GamePanel gp;
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}

	public void setObject() {
		
		
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
}
