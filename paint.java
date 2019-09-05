import java.util.*;
import java.applet.*;
import java.awt.*;
import java.lang.Math;
import java.awt.image.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class paint extends Applet implements MouseListener{
	int ii=1;
	int x=50;
	int y=50;
	int xx=1;
	int yy=1;
	int zz=300;
	Color c=new Color(0,0,0);
	Color cc=new Color(255,255,255);
	Polygon poly1;
	Timer t ;
	VolatileImage bitmap1;
	Graphics2D gg1;
	AppletContext cox;
	
	TimerTask tk =new TimerTask(){
			public void run(){
			/*	Graphics g =getGraphics();
				if (ii < 230){
					paint(g);
				}
				if (ii > 230) t.cancel();
				
			*/	
			}
		};

	
	public void init(){
		Color cc1;
		cox=this.getAppletContext();
		bitmap1=createVolatileImage(600,300);
		gg1=bitmap1.createGraphics();
		gg1.setColor(cc);
		gg1.fillRect(0,0,600,300);
		gg1.setColor(c);
		setBackground(cc);
		//t = new Timer("Timer");
		addMouseListener(this);
		cox.showStatus("paint");
		//t.scheduleAtFixedRate(tk,100,200);
	}
	public void destroy(){
		//t.cancel();
		ii=230;
		gg1.dispose();
	}


		public int center(int maxxy,int z){
			return ((maxxy-z)/2);
		}

		
	public void paint (Graphics g) {
		grid(300);
		g.drawImage(bitmap1,0,0,null);
	}
		public void mouseClicked(MouseEvent e){
			int xp =e.getX();
			int yp =e.getY();
			int door=-1;
			
			if ( xp>center(600,zz) && yp>center(300,zz) && xp<(center(600,zz)+zz) && yp<(center(300,zz)+zz)) door=0;
			if (door == 0 ) {
				xp=(xp-center(600,zz))/(zz/8);
				yp=(yp-center(300,zz))/(zz/8);
				System.out.println(Integer.toString(xp)+" , "+Integer.toString(yp));
				gg1.setColor(c);
				gg1.fillRect(center(600,zz)+(xp*(zz/8)),center(300,zz)+(yp*(zz/8)),(zz/8),(zz/8));
				repaint();
			}

			}

		public void mouseExited(MouseEvent ee){
			}
		public void mouseEntered(MouseEvent ee){

			}
		public void mousePressed(MouseEvent ee){

			}
		public void mouseReleased(MouseEvent ee){

			}
			
		public void grid(int z){
			int n;	
			gg1.setColor(c);
			for (n=0;n<z;n=n+z/8){
			
				gg1.drawLine(center(600,z)+n,center(300,z),center(600,z)+n,center(300,z)+z);
				if (n<300) gg1.drawLine(center(600,z),center(300,z)+n,center(600,z)+z,center(300,z)+n);
			}


		}
}
