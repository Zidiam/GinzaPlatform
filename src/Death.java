import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

/*
 * 
 */
public class Death {
	GinzaPanel env;
	int x, y, d1, d2, d3, d4, d5, d6, d7, d8, dCounter;
	GinzaImages Images = new GinzaImages();
	
	public static ArrayList<Point> deathBlocksRight = new ArrayList<Point>();
	public static ArrayList<Point> deathBlocksLeft = new ArrayList<Point>();
	public static ArrayList<Point> deathBlocksUp = new ArrayList<Point>();
	public static ArrayList<Point> deathBlocksDown = new ArrayList<Point>();
	
	private ArrayList<ArrayList> allBlocks = new ArrayList<ArrayList>();
	//deathBlocksRight.add(new Point(x, y));
	
	public Death(GinzaPanel environment, int x, int y, ArrayList<ArrayList> allBlocks) {
		d1 = d2 = d3 = d4 = d5 = d6 = d7 = d8 = 20;
		dCounter = 0;
		env = environment;
		this.allBlocks = allBlocks;
		this.x = x;
		this.y = y;
		findDeath();
	}
	
	public void findDeath() {
		for(int i = 0; i < allBlocks.size(); i++) {
			for(int z = 0; z < Images.getSolidBlockNames().size(); z++) {
				if(allBlocks.get(i).get(2).toString().equals(Images.getSolidBlockNames().get(z).toString())) {
					int tempx = Integer.parseInt((String) allBlocks.get(i).get(0));
					int tempy = Integer.parseInt((String)allBlocks.get(i).get(1));
					int distance = (int) Math.sqrt(Math.pow(tempx - x, 2) + Math.pow(tempy - y, 2));
					if(distance < 144) {
						deathBlocksRight.add(new Point(tempx, tempy));
					}
				}
			}
		}
	}
	
	public void update(Graphics g) {
		dCounter ++;
		if(dCounter < d1 && d1 != 0) {
			dCounter = 0;
			d1 = 0;
			Images.bloodSpatter1.paintIcon(env, g, (int) x, (int) y);
		}
		else if(dCounter < d2 && d2 != 0) {
			dCounter = 0;
			d2 = 0;
			Images.bloodSpatter2.paintIcon(env, g, (int) x - 6, (int) y - 6);
		}
		else if(dCounter < d3 && d3 != 0) {
			dCounter = 0;
			d3 = 0;
			Images.bloodSpatter3.paintIcon(env, g, (int) x - 12, (int) y - 12);
		}
		else if(dCounter < d4 && d4 != 0) {
			dCounter = 0;
			d4 = 0;
			Images.bloodSpatter4.paintIcon(env, g, (int) x - 18, (int) y - 18);
		}
		else if(dCounter < d5 && d5 != 0) {
			dCounter = 0;
			d5 = 0;
			Images.bloodSpatter5.paintIcon(env, g, (int) x - 30, (int) y - 30);
		}
		else if(dCounter < d6 && d6 != 0) {
			dCounter = 0;
			d6 = 0;
			Images.bloodSpatter6.paintIcon(env, g, (int) x - 42, (int) y - 42);
		}
		else if(dCounter < d7 && d7 != 0) {
			dCounter = 0;
			d7 = 0;
			Images.bloodSpatter7.paintIcon(env, g, (int) x - 66, (int) y - 66);
		}
		else if(dCounter < d8 && d8 != 0) {
			dCounter = 0;
			d8 = 0;
			Images.bloodSpatter8.paintIcon(env, g, (int) x - 90, (int) y - 90);
		}
		
	}
	
	public boolean isDead() {
		return (d8 == 0);
	}
}







































//code if I want to slow down the way the blood drops...
/*
public class Death {
	GinzaPanel env;
	int x, y, d1, d2, d3, d4, d5, d6, d7, d8, dCounter;
	GinzaImages Images = new GinzaImages();
	public Death(GinzaPanel environment, int x, int y) {
		d1 = d2 = d3 = d4 = d5 = d6 = d7 = d8 = 1;
		dCounter = 0;
		env = environment;
		this.x = x;
		this.y = y;
	}
	
	public void update(Graphics g) {
		dCounter ++;
		System.out.println(dCounter);
		if(dCounter > d1 && d1 != 0) {
			System.out.println("test");
			dCounter = 0;
			d1 = 0;
		}
		else if(dCounter > d2 && d2 != 0) {
			dCounter = 0;
			d2 = 0;
		}
		else if(dCounter > d3 && d3 != 0) {
			dCounter = 0;
			d3 = 0;
		}
		else if(dCounter > d4 && d4 != 0) {
			dCounter = 0;
			d4 = 0;
		}
		else if(dCounter > d5 && d5 != 0) {
			dCounter = 0;
			d5 = 0;
		}
		else if(dCounter > d6 && d6 != 0) {
			dCounter = 0;
			d6 = 0;
		}
		else if(dCounter > d7 && d7 != 0) {
			dCounter = 0;
			d7 = 0;
		}
		else if(dCounter > d8 && d8 != 0) {
			dCounter = 0;
			d8 = 0;
		}
		if(dCounter < d1 && d1 != 0) {
			Images.bloodSpatter1.paintIcon(env, g, (int) x, (int) y);
		}
		else if(dCounter < d2 && d2 != 0) {
			Images.bloodSpatter2.paintIcon(env, g, (int) x - 6, (int) y - 6);
		}
		else if(dCounter < d3 && d3 != 0) {
			Images.bloodSpatter3.paintIcon(env, g, (int) x - 12, (int) y - 12);
		}
		else if(dCounter < d4 && d4 != 0) {
			Images.bloodSpatter4.paintIcon(env, g, (int) x - 18, (int) y - 18);
		}
		else if(dCounter < d5 && d5 != 0) {
			Images.bloodSpatter5.paintIcon(env, g, (int) x - 30, (int) y - 30);
		}
		else if(dCounter < d6 && d6 != 0) {
			Images.bloodSpatter6.paintIcon(env, g, (int) x - 42, (int) y - 42);
		}
		else if(dCounter < d7 && d7 != 0) {
			Images.bloodSpatter7.paintIcon(env, g, (int) x - 66, (int) y - 66);
		}
		else if(dCounter < d8 && d8 != 0) {
			Images.bloodSpatter8.paintIcon(env, g, (int) x - 90, (int) y - 90);
		}
		
	}
	
	public boolean isDead() {
		return (d8 == 0);
	}
}
*/
