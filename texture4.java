import java.util.*;
import java.applet.*;
import java.awt.*;
import java.lang.Math;
import java.awt.image.*;

public class texture4 extends Applet {
	int ii=1;
	int x=50;
	int y=50;
	int xx=1;
	int yy=1;
	Color c=new Color(230,230,0);
	Color cc=new Color(255,0,0);
	Polygon poly1;
	Polygon poly2;
	Polygon poly3;
	Polygon poly4;
	Timer t ;
	VolatileImage bitmap1;
	VolatileImage bitmap2;
	VolatileImage bitmap3;
	VolatileImage bitmap4;
	Graphics2D gg1;
	Graphics2D gg2;
	Graphics2D gg3;
	Graphics2D gg4;
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
		bitmap1=createVolatileImage(290,250);
		bitmap2=createVolatileImage(290,250);
		bitmap3=createVolatileImage(580,125);
		bitmap4=createVolatileImage(580,125);
		gg1=bitmap1.createGraphics();
		gg2=bitmap2.createGraphics();
		gg3=bitmap3.createGraphics();
		gg4=bitmap4.createGraphics();
		poly1=new Polygon();
		poly2=new Polygon();
		poly3=new Polygon();
		poly4=new Polygon();
		gg1.setColor(cc);
		gg2.setColor(cc);
		gg3.setColor(c);
		gg4.setColor(c);
		gg1.fillRect(0,0,290,250);
		gg2.fillRect(0,0,290,250);
		gg3.fillRect(0,0,580,125);
		gg4.fillRect(0,0,580,125);
		gg1.setColor(c);
		gg2.setColor(c);
		gg3.setColor(c);
		gg4.setColor(c);
		nnn=0;
		cc1=new Color(255,255,0);
		gg1.setColor(cc1);
		gg2.setColor(cc1);
		gg3.setColor(cc);
		gg4.setColor(cc);
		for (n=1;n<290;n=n+n){
			//vertical
			gg1.drawLine(290-n,0,290-n,250);
			gg2.drawLine(n,0,n,250);
		}
		for (n=0;n<250;n=n+20){
			//horizonte
			gg1.drawLine(0,n,290,125);
			gg2.drawLine(0,125,290,n);
		}
		for (n=1;n<290;n=n+10){
			for(nn=0;nn<250;nn=nn+10){
				gg1.drawLine(n,nn,n,nn+2);
				gg2.drawLine(n,nn,n,nn+2);
			}
		}
		for (n=0;n<580;n=n+20){
			gg3.drawLine(n,0,290,125);
			gg4.drawLine(290,0,n,125);
			for(nn=0;nn<125;nn=nn+10){
				gg3.drawLine(n,nn,n,nn+2);
				gg4.drawLine(n,nn,n,nn+2);
			}

		}
		gg1.dispose();
		gg2.dispose();
		gg3.dispose();
		gg4.dispose();
		setBackground(c);
		t = new Timer("Timer");
		poly1.addPoint(0,0);
		poly1.addPoint(290,125);
		poly1.addPoint(290,125);
		poly1.addPoint(0,250);
		poly2.addPoint(290,125);
		poly2.addPoint(290,125);
		poly2.addPoint(290+290,0);
		poly2.addPoint(290+290,250);
		poly3.addPoint(0,0);
		poly3.addPoint(580,0);
		poly3.addPoint(290,125);
		poly3.addPoint(290,125);
		poly4.addPoint(290,125);
		poly4.addPoint(290,125);
		poly4.addPoint(580,250);
		poly4.addPoint(0,250);

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
		g.setColor(cc);
		g.drawRect(0,0,580,250);
		g.setClip(poly2);
		g.drawImage(bitmap2,290,0,null);
		g.setClip(poly1);
		g.drawImage(bitmap1,0,0,null);
		g.setClip(poly3);
		g.drawImage(bitmap3,0,0,null);
		g.setClip(poly4);
		g.drawImage(bitmap4,0,125,null);

	
	}
}
