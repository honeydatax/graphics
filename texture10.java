import java.util.*;
import java.applet.*;
import java.awt.*;
import java.lang.Math;
import java.awt.image.*;

public class texture10 extends Applet {
	int ii=4;
	int x=50;
	int y=50;
	int xx=1;
	int yy=1;
	Color c=new Color(255,255,255);
	Color cc=new Color(0,0,0);
	Polygon poly;
	Timer t ;
	VolatileImage bitmap1;
	Graphics2D gg;
	AppletContext cox;
	
	TimerTask tk =new TimerTask(){
			public void run(){
				Graphics g =getGraphics();
				if (ii < 230){
					ii=ii+5;
					if (ii>100) ii=4;
					paint(g);
				}
				if (ii > 230) t.cancel();
				
				
			}
		};

	
	public void init(){
		int n;
		int nn;
		int nnn;
		Color cc1;
		ii=4;
		cox=this.getAppletContext();
		bitmap1=createVolatileImage(650,300);
		gg=bitmap1.createGraphics();
		poly=new Polygon();
		gg.setColor(c);
		setBackground(c);
		t = new Timer("Timer");
		poly.addPoint(0,0);
		poly.addPoint(580,100);
		poly.addPoint(580,150);
		poly.addPoint(0,250);
		t.scheduleAtFixedRate(tk,600,600);
	}
	public void destroy(){
		t.cancel();
		ii=230;
		gg.dispose();
	}
		
	public void paint (Graphics g) {
		int n=0;
		int nn=0;
		int nnn=0;
		int nnnn=0;
		gg.setColor(c);
		gg.fillRect(0,0,650,300);
		
		nnn=0;
		gg.setColor(cc);
		for (n=0;n<650;n=n+ii){
			for (nn=0;nn<300;nn=nn+ii){
				gg.drawOval(n,nn,ii,ii);
			}
		}

		g.setClip(poly);
		g.drawImage(bitmap1,0,0,null);

		
	}
}
