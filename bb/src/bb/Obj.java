package bb;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

class Obj extends Rectangle{
	
	Image pic;
	int dx=3;
	int dy=-3;
	
	boolean destroyed = false;
	Obj (int a, int b, int hei, int wid, String s){
		
		x = a;
		y = b;
		height = hei;
		width = wid;
		
		try {
			pic = ImageIO.read(new File("src/"+s));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void draw (Graphics g, Component c) {
		
		if(!destroyed)
		
		g.drawImage(pic, x, y, width,height, c);
	}

}

