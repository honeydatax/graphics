import java.util.*;
import java.applet.*;
import java.awt.*;
import java.lang.Math;
import java.awt.image.*;

public class texture3 extends Applet {
	int ii=1;
	int x=50;
	int y=50;
	int xx=1;
	int yy=1;
	Color c=new Color(230,230,0);
	Color cc=new Color(255,0,0);
	Polygon poly;
	Timer t ;
	VolatileImage bitmap1;
	Graphics2D gg;
	AppletContext cox;
	
	TimerTask tk =new TimerTask(){
			public void run(){
				Graphics g =getGraphics();
				if (ii < 230){
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
		ii=1;
		cox=this.getAppletContext();
		bitmap1=createVolatileImage(580,250);
		gg=bitmap1.createGraphics();
		poly=new Polygon();
		gg.setColor(cc);
		gg.fillRect(0,0,580,250);
		gg.setColor(c);
		nnn=0;
		cc1=new Color(255,255,0);
		gg.setColor(cc1);
		for (n=0;n<250;n=n+20){
			gg.drawLine(0,n,580,100+(n/5));
		}
		for (n=1;n<580;n=n+n){
			gg.drawLine(580-n,0,580-n,250);
		}

		gg.dispose();
		setBackground(c);
		t = new Timer("Timer");
		poly.addPoint(0,0);
		poly.addPoint(580,100);
		poly.addPoint(580,150);
		poly.addPoint(0,250);
		//t.scheduleAtFixedRate(tk,100,200);
	}
	public void destroy(){
		t.cancel();
		ii=230;
	}
		
	public void paint (Graphics g) {
		int n=0;
		int nn=0;
		int nnn=0;
		int nnnn=0;
		g.setClip(poly);
		g.drawImage(bitmap1,0,0,null);

		
	}
}
