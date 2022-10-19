package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;

public class TileManager {
	
	GamePanel gp;
	public Tile[] tile;
	public int mapTileNum[][];
	
	public TileManager(GamePanel gp) {
		
		this.gp=gp;
		tile=new Tile[200];
		mapTileNum= new int[gp.maxWorldCol][gp.maxWorldRow];
		
		getTileImage();
		loadMap("/maps/Village.txt");
	}
	
	public void getTileImage() {
		
		setup(0, "water", true);
		setup(1, "water", true);
		setup(2, "water", true);
		setup(3, "water", true);
		setup(4, "water", true);
		setup(5, "water", true);
		setup(6, "water", true);
		setup(7, "water", true);
		setup(8, "water", true);
		setup(9, "water", true);
		setup(10, "beach_bottm_left_10", false);
		setup(11, "beach_bottom_11", false);
		setup(12, "beach_bottom_right_12", false);
		setup(13, "beach_13", false);
		setup(14, "beach_dirt_14", false);
		setup(15, "curve_path_15", false);
		setup(16, "curve_path_16", false);
		setup(17, "curve_path_17", false);
		setup(18, "curve_path_18", false);
		setup(19, "dirt_grass_19", false);
		setup(20, "grass_20", false);
		setup(21, "path_continuous_horizontal_21", false);
		setup(22, "path_continuous_vertical_22", false);
		setup(23, "path_down_23", false);
		setup(24, "path_left_24", false);
		setup(25, "path_right_25", false);
		setup(26, "path_up_26", false);
		setup(27, "water", false);
		setup(28, "water", true);
		setup(29, "water", false);
		setup(30, "water", false);
		setup(31, "water", false);
		setup(32, "water", false);
		setup(33, "tree_bottom_33", true);
		setup(34, "tree_top_34", true);
		setup(35, "water", false);
		setup(36, "right_dirt_grass_36", false);
		setup(37, "left_dirt_grass_37", false);
		setup(38, "left_beach_dirt_38", false);
		setup(39, "right_beach_dirt_39", false);
		setup(40, "small_tree_40", false);
		setup(41, "three_way_up_41", false);
		setup(42, "three_way_left_42", false);
		setup(43, "pond_43", true);
		setup(44, "pond_44", true);
		setup(45, "pond_45", true);
		setup(46, "pond_46", true);
		setup(47, "pond_47", true);
		setup(48, "pond_48", true);
		setup(49, "pond_49", true);
		setup(50, "pond_50", true);
		setup(51, "pond_51", true);
		setup(52, "wizard_close_door_52", false);
		setup(53, "wizard_open_door_53", false);
		setup(54, "jail_close_54", false);
		setup(55, "jail_open_55", false);
		setup(56, "mini_boss_1_close_door_56", false);
		setup(57, "mini_boss_1_open_door_57", false);
		setup(58, "below_roof_left_58", true);
		setup(59, "below_roof_right_59", true);
		setup(60, "below_roof_middle_60", true);
		setup(61, "left_middle_wall_61", true);
		setup(62, "middle_middle_wall_62", true);
		setup(63, "right_middle_wall_63", true);
		setup(64, "base_left_wall_64", true);
		setup(65, "base_centre_wall_65", true);
		setup(66, "base_right_wall_66", true);
		setup(67, "left_roof_67", true);
		setup(68, "right_roof_68", true);
		setup(69, "behind_left_roof_69", true);
		setup(70, "behind_right_roof_70", true);
		setup(71, "back_left_roof_71", true);
		setup(72, "back_right_roof_72", true);
		setup(73, "hero_house_close_door_73", false);
		setup(74, "hero_house_open_door_74", false);
		setup(75, "water", false);
		setup(76, "middle_roof_76", true);
		setup(77, "middle_front_roof_77", true);
		setup(78, "window_78", false);
		setup(79, "back_roof_middle_79", true);
		setup(80, "blue_flower_80", false);
		setup(81, "red_flower_81", false);
		setup(82, "purple_flower_82", false);
		setup(83, "white_flower_83", false);
		setup(84, "front_left_roof_84", true);
		setup(85, "front_middle_roof_85", true);
		setup(86, "front_right_roof_86", true);
		setup(87, "water", false);
		setup(88, "water", false);
		setup(89, "back_right_roof_89", true);
		setup(90, "back_left_roof_90", true);
		setup(91, "back_middle_roof_91", true);
		setup(92, "middle_middle_roof_92", true);
		setup(93, "middle_left_roof_93", true);
		setup(94, "middle_right_roof_94", true);
		setup(95, "trader_shop_close_door_95", false);
		setup(96, "trader_shop_open_door_96", false);
		setup(97, "wooden_sign_97", true);
		setup(98, "potion_shop_front_left_roof_98", true);
		setup(99, "potion_shop_front_middle_roof_99", true);
		setup(100, "potion_shop_front_right_roof_100", true);
		setup(101, "potion_shop_middle_left_roof_101", true);
		setup(102, "poton_shop_middle_right_roof_102", true);
		setup(103, "potion_shop_back_right_roof_103", true);
		setup(104, "potion_shop_back_left_roof_104", true);
		setup(105, "potion-shop_back_middle_roof_105", true);
		setup(106, "potion_shop_middle_middle_roof_106", true);
		setup(107, "potion_shop_close_door_107", false);
		setup(108, "potion_shop_open_door_108", false);
		setup(109, "orange_bush_109", true);
		setup(110, "blue_bush_110", true);
		setup(111, "purple_bush_111", true);
		setup(112, "black_bush_112", true);
		setup(113, "four_way_113", false);
		setup(114, "three_way_down_114", false);
		setup(115, "three_way_right_115", false);
		setup(116, "water", false);
		setup(117, "water", false);
		setup(118, "water", false);
		setup(119, "water", false);
		setup(120, "grass_120", false);
		setup(121, "big_white_flower_121", false);
		setup(122, "close_portal_122", false);
		setup(123, "water", false);
		setup(124, "wall 124", false);
		setup(125, "path 125", false);
		setup(126, "full crack wall 126", false);
		setup(127, "half crack wall 127", false);
		setup(128, "wall 128", false);
		setup(129, "path 129", false);
		setup(130, "full crack wall 130", false);
		setup(131, "half crack wall 131", false);
		setup(132, "wall 132", false);
		setup(133, "full crack wall 133", false);
		setup(134, "half crack wall 134", false);
		setup(135, "wall 135", false);
		setup(136, "water", false);
		setup(137, "statue bottom 137", true);
		setup(138, "statue up 138", true);
		setup(139, "floor 139", false);
		setup(140, "bed 140", false);
		setup(141, "bookshelf 141", false);
		setup(142, "cupboard 142", false);
		setup(143, "top left carpet 143", false);
		setup(144, "top right carpet 144", false);
		setup(145, "bottom left carpet 145", false);
		setup(146, "bottom right carpet 146", false);
		setup(147, "left carpet 147", false);
		setup(148, "right carpet 148", false);
		setup(149, "upper carpet 149", false);
		setup(150, "bottom carpet 150", false);
		setup(151, "wooden tv 151", false);
		setup(152, "water", false);
		setup(153, "wall down 153", false);
		setup(154, "wall up 154", false);
		setup(155, "water", false);
		setup(156, "water", false);
		setup(157, "water", false);
		setup(158, "water", false);
		setup(159, "water", false);
		setup(160, "bottom mirror 160", false);
		setup(161, "upper mirror 161", false);
		setup(162, "green frame 162", false);
		setup(163, "plant 163", false);
		setup(164, "blue frame 164", false);
		setup(165, "orange carpet 165", false);
		setup(166, "stair 166", false);
		setup(167, "blue carpet 167", false);
		setup(168, "dinning left 168", false);
		setup(169, "dinning right 169", false);
		setup(170, "dinning middle 170", false);
		setup(171, "right facing chair 171", false);
		setup(172, "left facing chair 172", false);
		setup(173, "stove left 173", false);
		setup(174, "stove right 174", false);
		setup(175, "stove middle 175", false);
		
	}
	public void setup(int index, String imageName, boolean collision) {
		
		UtilityTool uTool = new UtilityTool();
		
		try {
			tile[index] = new Tile();
			tile[index].image = ImageIO.read(getClass().getResourceAsStream("/tiles/"+imageName+".png"));
			tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
			tile[index].collision = collision;
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void loadMap(String filePath) {
		try {
			InputStream is =getClass().getResourceAsStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col=0;
			int row=0;
			while(col < gp.maxWorldCol && row < gp.maxWorldRow) {
				
				String line = br.readLine();
				
				while(col < gp.maxWorldCol) {
					
					String numbers[] = line.split(" ");
					
					int num = Integer.parseInt(numbers[col]);
					
					mapTileNum[col][row] = num;
					col++;	
				}
				if(col == gp.maxWorldCol) {
					col=0;
					row++;
				}
			}
			br.close();
			
		}catch(Exception e) {
			
		}
	}
	public void draw(Graphics2D g2) {
		
		int worldCol= 0;
		int worldRow=0;

		
		while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
			
			int tileNum= mapTileNum[worldCol][worldRow];
			
			int worldX = worldCol *gp.tileSize;
			int worldY = worldRow *gp.tileSize;
			int screenX = worldX - gp.player.worldX + gp.player.screenX;
			int screenY = worldY - gp.player.worldY + gp.player.screenY;
			
			if(worldX +gp.tileSize > gp.player.worldX - gp.player.screenX &&
					worldX -gp.tileSize < gp.player.worldX + gp.player.screenX &&
					worldY +gp.tileSize > gp.player.worldY - gp.player.screenY &&
					worldY -gp.tileSize < gp.player.worldY + gp.player.screenY) {
				
				g2.drawImage(tile[tileNum].image,screenX,screenY,null);
			}
			
			worldCol++;

			
			if(worldCol==gp.maxWorldCol) {
				worldCol=0;
				worldRow++;
			}
		}
	}

}
