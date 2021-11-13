import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.Color;
import javax.swing.JFrame;
import java.awt.event.*;

public class Jogo extends Canvas implements Runnable, MouseListener{

	public static int WIDTH = 640, HEIGHT = 480;
	public static int contador = 100;
	public static int pontuacao = 0;
	public static int mx,my;
	public static boolean clicado = false;
	
	public Spawner spawner;
	
	public boolean gameOver = false;
	
	public Jogo() {
		Dimension dimension = new Dimension(WIDTH, HEIGHT);
		this.setPreferredSize(dimension);
		this.addMouseListener(this);
		spawner = new Spawner();
	}
	
	public void update() {
		if(gameOver == false) {
			spawner.update();
			if(contador <= 0) {
				contador = 100;
				gameOver = true;
			}
	    }
	}
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		if(gameOver == false) {
			g.setColor(Color.green);
			g.fillRect(Jogo.WIDTH/2 - 100 - 50, 20, contador*3, 20);
			g.setColor(Color.white);
			g.drawRect(Jogo.WIDTH/2 - 100 - 50, 20, 300, 20);
	
			spawner.render(g);
			
		}else {
			g.setColor(Color.white);
			g.setFont(new Font("Calibri", Font.BOLD, 30));
			g.drawString("Game Over!", WIDTH/2 - 75, HEIGHT/2 - 50);
			g.drawString("Your Final Score Was: "+ this.pontuacao, WIDTH/2 - 150, HEIGHT/2 + 80 - 50);
		}
		bs.show();
	}
	
	public static void main(String[] args) {
		Jogo jogo = new Jogo();
		JFrame jframe = new JFrame("Dash Game");
		jframe.add(jogo);
		jframe.setLocationRelativeTo(null);
		jframe.pack();
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jframe.setVisible(true);
		
		new Thread(jogo).start();
	}
	
	@Override
	public void run() {
		while(true) {
			update();
			render();
			try {
				Thread.sleep(1000/60);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		clicado = true;
		mx = e.getX();
		my = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}	
}
