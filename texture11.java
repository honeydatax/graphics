import java.util.*;
import java.applet.*;
import java.awt.*;
import java.lang.Math;
import java.awt.image.*;

public class texture11 extends Applet {
	int ii=4;
	int x=50;
	int y=50;
	int px=0;
	int py=0;
	int pw=650;
	int ph=300;
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
		bitmap1=createVolatileImage(650,20);
		gg=bitmap1.createGraphics();
		poly=new Polygon();
		gg.setColor(c);
		gg.fillRect(0,0,650,20);
		
		nnn=0;
		gg.setColor(cc);
		for (n=0;n<650;n=n+10){
				gg.drawLine(n,nnn,n,20);
				nnn=nnn+10;
				if (nnn>11)nnn=0;
		}

		gg.setColor(c);
		gg.dispose();
		setBackground(c);
		t = new Timer("Timer");
		t.scheduleAtFixedRate(tk,600,600);
	}
	public void destroy(){
		t.cancel();
		ii=230;
		
	}
		
	public void paint (Graphics g) {
		int n=(int) Math.round(Math.random()*350.00);;
		int nn=(int) Math.round(Math.random()*290.00);;
		int nnn=0;
		int nnnn=0;
		
		poly.addPoint(n,nn);
		poly.addPoint(650,nn);
		poly.addPoint(650,nn+20);
		poly.addPoint(n,nn+20);

		g.setClip(poly);
		g.drawImage(bitmap1,n,nn,null);
		poly.reset();
		//poly=new Polygon();		
		
	}
}
