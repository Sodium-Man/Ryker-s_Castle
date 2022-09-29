package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_RKey extends SuperObject {
	
	public OBJ_RKey() {
		
		name = "key";
		try {
			image =ImageIO.read(getClass().getResourceAsStream("/objects/ryker_key.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
