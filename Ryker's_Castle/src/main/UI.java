package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;

import entity.Entity;
import object.OBJ_Heart;
import object.OBJ_RKey;

public class UI {
	
	GamePanel gp;
	Graphics2D g2;
	Font purisaB;
	BufferedImage heart_full,heart_half,heart_blank;
	public boolean messageOn = false;
	public String message = "";
	int messageCounter = 0;
	public boolean gameFinished = false;
	public String currentDialogue = "";
	public int commandNum = 0;
	
	
	public UI(GamePanel gp) {
		this.gp = gp;
		
		
		try {
			InputStream is = getClass().getResourceAsStream("/font/Purisa Bold.ttf");
			purisaB = Font.createFont(Font.TRUETYPE_FONT, is);
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Entity heart = new OBJ_Heart(gp);
		heart_full = heart.image;
		heart_half = heart.image2;
		heart_blank = heart.image3;
	}
	public void showMessage(String text) {
		
		message = text;
		messageOn = true;
		
	}
	public void draw(Graphics2D g2) {
		
		this.g2 = g2;
		
		g2.setFont(purisaB);
		g2.setColor(Color.white);
		
		if(gp.gameState == gp.titleState) {
			drawTitleScreen();
		}
		if(gp.gameState == gp.playState) {
			drawPlayerLife();
		}
		if(gp.gameState == gp.pauseState) {
			drawPlayerLife();
			drawPauseScreen();
		}
		if(gp.gameState == gp.dialougeState) {
			drawPlayerLife();
			drawDialogueScreen();
		}
		
	}
	public void drawPlayerLife() {
		
		int x = gp.tileSize/2;
		int y = gp.tileSize/2;
		int i = 0;
		
		while(i < gp.player.maxLife/2) {
			g2.drawImage(heart_blank, x, y, null);
			i++;
			x += gp.tileSize;
		}
		
		x = gp.tileSize/2;
		y = gp.tileSize/2;
		i = 0;
		
		while(i < gp.player.life) {
			g2.drawImage(heart_half,x, y, null);
			i++;
			if(i < gp.player.life) {
				g2.drawImage(heart_full,x, y, null);
			}
			i++;
			x += gp.tileSize;
		}
		
	}
	public void drawTitleScreen() {
		
		g2.setFont(g2.getFont().deriveFont(Font.BOLD,80F));
		String text = "Ryker's Castle";
		int x = getXforCenteredText(text);
		int y = gp.tileSize*3;
		
		//shadow
		g2.setColor(Color.gray);
		g2.drawString(text, x+5, y+5);
		
		//main title		
		g2.setColor(Color.white);
		g2.drawString(text, x, y);
		
		//character
		x = gp.screenWidth/2 - gp.tileSize;
		y += gp.tileSize*2;
		g2.drawImage(gp.player.idle, x, y, gp.tileSize*2, gp.tileSize*2,null);
		
		//Menu
		g2.setFont(g2.getFont().deriveFont(Font.BOLD,40F));
		
		text ="New Game";
		x = getXforCenteredText(text);
		y += gp.tileSize*3;
		g2.drawString(text, x, y);
		if(commandNum == 0) {
			g2.drawString(">", x-gp.tileSize, y);
		}
		
		text ="Load Game";
		x = getXforCenteredText(text);
		y += gp.tileSize;
		g2.drawString(text, x, y);
		if(commandNum == 1) {
			g2.drawString(">", x-gp.tileSize, y);
		}
		
		text ="Quit";
		x = getXforCenteredText(text);
		y += gp.tileSize;
		g2.drawString(text, x, y);
		if(commandNum == 2) {
			g2.drawString(">", x-gp.tileSize, y);
		}
	}
	public void drawPauseScreen() {
		
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN,60F));
		String text ="Paused";
		int x = getXforCenteredText(text);
		int y = gp.screenHeight/2;
		
		g2.drawString(text, x, y);
	}
	public void drawDialogueScreen(){
		
		int x = gp.tileSize*2;
		int y = gp.tileSize/2;
		int width = gp.screenWidth - (gp.tileSize*4);
		int height = gp.tileSize*4;
		drawSubWindow(x, y, width, height);
		
		x += gp.tileSize;
		y += gp.tileSize;
		
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN,25F));
		for(String line: currentDialogue.split("\n")) {
			g2.drawString(line, x, y);
			y += 40;
		}
	}
	public void drawSubWindow(int x, int y, int width, int height) {
		
		Color c = new Color(0,0,0,210);
		g2.setColor(c);
		g2.fillRoundRect(x, y, width, height, 35, 35);
		
		c = new Color(255,255,255);
		g2.setColor(c);
		g2.setStroke(new BasicStroke(5));
		g2.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);
		
	}
	
	public int getXforCenteredText(String text) {
		
		int length =(int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();	
		int x = gp.screenWidth/2 - length/2;
		return x;
		
	}

}
