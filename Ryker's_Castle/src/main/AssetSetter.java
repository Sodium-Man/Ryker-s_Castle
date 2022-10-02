package main;

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
		
		gp.obj[0] = new OBJ_RKey();
		gp.obj[0].worldX = 17*gp.tileSize;
		gp.obj[0].worldY = 6*gp.tileSize;
		
		gp.obj[1] = new OBJ_door();
		gp.obj[1].worldX = 14*gp.tileSize;
		gp.obj[1].worldY = 8*gp.tileSize;
		
		gp.obj[2] = new OBJ_Chest();
		gp.obj[2].worldX = 13*gp.tileSize;
		gp.obj[2].worldY = 11*gp.tileSize;
		
		gp.obj[3] = new OBJ_SpeedPotion();
		gp.obj[3].worldX = 7*gp.tileSize;
		gp.obj[3].worldY = 8*gp.tileSize;
	}
}
