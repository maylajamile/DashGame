import java.awt.Rectangle;
import java.util.Random;
import java.awt.Color;

public class RectObj extends Rectangle{
	
	public Color color;
	public int speed = 0;
	public int rotation = 0;
	
	public RectObj(int x, int y, int width, int height) {
		super(x,y,width,height);
		
		color = new Color(new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255));
		speed = new Random().nextInt(8-6)+6;
	}
	
	public void update() {
		x+=speed;
		rotation+=4;
		if(rotation >= 360) {
			rotation = 0;
		}
	}
}
