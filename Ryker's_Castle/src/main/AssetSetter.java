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
		
		gp.monster[0] = new MON_Crab(gp);
		gp.monster[0].worldX = gp.tileSize*21;
		gp.monster[0].worldY = gp.tileSize*4;
	}
}
