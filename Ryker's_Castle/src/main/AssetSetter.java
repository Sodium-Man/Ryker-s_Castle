package main;

import object.OBJ_RKey;
import object.OBJ_door;

public class AssetSetter {
	
	GamePanel gp;
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}

	public void setObject() {
		
		gp.obj[0] = new OBJ_RKey();
		gp.obj[0].worldX = 13*gp.tileSize;
		gp.obj[0].worldY = 11*gp.tileSize;
		
		gp.obj[1] = new OBJ_door();
		gp.obj[1].worldX = 14*gp.tileSize;
		gp.obj[1].worldY = 8*gp.tileSize;
		
	}
}
