package com.me.utils;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

public class RandomPic {
	public static BufferedImage createRandomPic(Integer id) {
		Random random=new Random(id);
		BufferedImage image = new BufferedImage(800, 600,
				BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		int rc=random.nextInt(255);
		int gc=random.nextInt(255);
		int bc=random.nextInt(255);
		Color color=new Color(rc, gc, bc);
		for(int x=0;x<400;x+=50) {
			for(int y=0;y<600;y+=50) {
				g.setColor(random.nextInt(2)==0?Color.WHITE:color);
				g.fillRect(x, y, 50, 50);
				g.fillRect(800-x-50, y, 50, 50);
			}
		}
		return image;
	}
}
