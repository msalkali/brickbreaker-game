package bb;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;

class ObjectAction extends JPanel implements KeyListener {

	ArrayList<Obj> brick = new ArrayList<Obj>();
	ArrayList<Obj> ball = new ArrayList<Obj>();

	Obj paddle;

	int size = 25;
	Thread thread;

	ObjectAction() {

		addKeyListener(this);
		setFocusable(true);
		
		//setting the paddle and positioning it on the frame using the .png provided
		
		paddle = new Obj(175, 480, 36, 150, "paddle.png"); 
		
		//setting the ball and positioning it on the frame
		
		ball.add(new Obj(240, 435, 25, 40, "ball.png"));  
		
		//for loop for aligning the bricks on the frame using the .png provided 

		for (int i = 0; i < 8; i++) {

			//aligning the first (yellow) brick on the frame
			
			brick.add(new Obj((i * 60 + 2), 0, 30, 58, "yellow.png"));

		}

		//aligning the first (red) brick on the frame

		for (int i = 0; i < 8; i++) {

			brick.add(new Obj((i * 60 + 2), 20, 30, 58, "red.png"));

		}
		
		//aligning the second (yellow) brick on the frame

		for (int i = 0; i < 8; i++) {

			brick.add(new Obj((i * 60 + 2), 40, 30, 58, "yellow.png"));

		}

		//aligning the second (red) brick on the frame

		for (int i = 0; i < 8; i++) {

			brick.add(new Obj((i * 60 + 2), 60, 30, 58, "red.png"));

		}

	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		for (Obj br : brick)

			br.draw(g, this);

		for (Obj br : ball)

			br.draw(g, this);

		paddle.draw(g, this);

	}

	public void update() {

		for (Obj bal : ball) {
			bal.x += bal.dx;
			if (bal.x > (getWidth() - size) && bal.dx > 0 || bal.x < 0)
				bal.dx *= -1;
			if (bal.y < 0 || bal.intersects(paddle))
				bal.dy *= -1;///
			bal.y += bal.dy;

			for (Obj br : brick) {
				if (bal.intersects(br) && !br.destroyed) { //the (!) sign enables the ball to hit the bricks
					br.destroyed = true;
					bal.dy *= -1;
				}
				
			}

		}

		repaint();

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {

			Runnable play = new Play(this);
			thread = new Thread(play);
			thread.start();

		}

		if (e.getKeyCode() == KeyEvent.VK_LEFT && paddle.x > 0) {

			paddle.x -= 15;

		}

		if (e.getKeyCode() == KeyEvent.VK_RIGHT && paddle.x < (getWidth() - paddle.width)) {

			paddle.x += 15;

		}

	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}

