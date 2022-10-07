package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JPanel;

import entity.Entity;
import entity.Player;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable{
	
	final int originalTileSize = 16;
	final int scale = 3;
	
	public final int tileSize = originalTileSize * scale;
	public final int maxScreenCol = 16;
	public final int maxScreenRow = 12;
	public final int screenWidth = tileSize*maxScreenCol;
	public final int screenHeight = tileSize*maxScreenRow;
	
	
	//world settings
	public final int maxWorldCol = 50;
	public final int maxWorldRow = 50;

	
	//FPS
	int FPS=60;
	
	TileManager tileM =new TileManager(this);
	public KeyHandler keyH=new KeyHandler(this);
	Sound music = new Sound();
	Sound se = new Sound();
	public CollisionChecker cChecker = new CollisionChecker(this);
	public AssetSetter aSetter = new AssetSetter(this);
	public UI ui = new UI(this);
	public EventHandler eHandler = new EventHandler(this);
	Thread gameThread;
	
	public Player player=new Player(this,keyH);
	public Entity obj[] = new Entity[10];
	public Entity npc[] = new Entity[10];
	public Entity monster[] = new Entity[20];
	ArrayList<Entity> entityList = new ArrayList<>();
	
	//gameState
	public int gameState;
	public final int titleState = 0;
	public final int playState = 1;
	public final int pauseState = 2;
	public final int dialougeState = 3;
	
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}
	
	public void setupGame() {
		
		aSetter.setObject();
		aSetter.setNPC();
		aSetter.setMonster();
		playMusic(0);
		//stopMusic();
		gameState = titleState;
		
	}
	
	public void startGameThread() {
		gameThread= new Thread(this);
		gameThread.start();
	}
	
	@Override
	public void run() {
		double drawInterval = 1000000000/FPS;
		double delta=0;
		long lastTime= System.nanoTime();
		long currentTime;
		long timer=0;
		int drawCount=0;
		
		while(gameThread!=null) {
			
			currentTime=System.nanoTime();
			delta+=(currentTime-lastTime)/drawInterval;
			timer +=(currentTime-lastTime);
			lastTime=currentTime;
			
			if(delta>=1) {
				update();
				repaint();
				delta--;
				drawCount++;
			}
		}
	}
	public void update() {
		
		if(gameState == playState) {
			player.update();
			
			for(int i=0; i < npc.length; i++) {
				if(npc[i] !=null) {
					npc[i].update();
				}
				
			}
			for(int i=0; i < monster.length; i++) {
				if(monster[i] != null) {
					monster[i].update();
				}
			}
		}
		if(gameState == pauseState) {
			
		}
		
	}
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D)g;
		
		//debug
		long drawStart = 0;
		if(keyH.checkDrawTime == true) {
			drawStart = System.nanoTime();
		}
		if(gameState == titleState) {
			ui.draw(g2);
		}
		else {
			//Tile
			tileM.draw(g2);
			
			entityList.add(player);
			
			for(int i = 0; i<npc.length;i++) {
				if(npc[i] != null) {
					entityList.add(npc[i]);
				}
			}
			for(int i = 0; i < obj.length;i++) {
				if(obj[i] != null) {
					entityList.add(obj[i]);
				}
			}
			for(int i = 0; i < monster.length;i++) {
				if(monster[i] != null) {
					entityList.add(monster[i]);
				}
			}
			
			Collections.sort(entityList, new Comparator<Entity> () {

				@Override
				public int compare(Entity e1, Entity e2) {
					
					int result = Integer.compare(e1.worldY, e2.worldY);
					return result;
				}});
			
			//draw entities
			for(int i = 0; i < entityList.size(); i++) {
				entityList.get(i).draw(g2);
			}
			entityList.clear();
			
			
			//UI
			ui.draw(g2);
		}
		
		
		
		//debug
		if(keyH.checkDrawTime == true) {
			long drawEnd = System.nanoTime();
			long passed =drawEnd - drawStart;
			g2.setColor(Color.white);
			g2.drawString("drawTime:"+passed, 10, 400);
			System.out.println("drawTime:"+passed);
		}
		
		g2.dispose();
	}
	public void playMusic(int i) {
		
		music.setFile(i);
		music.play();
		music.loop();
		
	}
	public void stopMusic() {
		
		music.stop();
		
	}
	public void playSE(int i) {
		
		se.setFile(i);
		se.play();
		
	}

}