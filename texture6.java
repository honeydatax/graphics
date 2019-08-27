import java.util.*;
import java.applet.*;
import java.awt.*;
import java.lang.Math;
import java.awt.image.*;

public class texture6 extends Applet {
	int ii=0;
	int iii=0;
	int x=50;
	int y=50;
	int xx=1;
	int yy=1;
	Color c=new Color(230,230,0);
	Color cc=new Color(255,0,0);
	Polygon poly;
	Polygon[] polys=new  Polygon[126];
	Timer t ;
	VolatileImage bitmap1;
	VolatileImage bitmap2;
	VolatileImage bitmap3;
	Graphics2D gg;
	Graphics2D gg1;
	Graphics2D gg2;
	AppletContext cox;
	
	TimerTask tk =new TimerTask(){
			public void run(){
				Graphics g =getGraphics();
				if (ii < 230){
					iii++;
					if (iii>1) iii=0;
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
		cox=this.getAppletContext();
		bitmap1=createVolatileImage(600,300);
		bitmap2=createVolatileImage(600,300);
		bitmap3=createVolatileImage(600,300);
		gg=bitmap1.createGraphics();
		gg1=bitmap2.createGraphics();
		gg2=bitmap3.createGraphics();
		poly=new Polygon();
		for (n=0;n<126;n++){
			polys[n]=new Polygon();
			polys[n].addPoint(-300+n*5,300);
			polys[n].addPoint(n*5,5);
			polys[n].addPoint(300+n*5,300);

		}

		gg.setColor(cc);
		gg1.setColor(cc);
		gg.fillRect(0,0,600,300);
		gg1.fillRect(0,0,600,300);
		gg.setColor(c);
		gg1.setColor(c);
		nnn=0;
		cc1=new Color(255,255,64);
		gg.setColor(cc1);
		gg1.setColor(cc1);
		for (n=0;n<600;n=n+15){
			for (nn=0;nn<300;nn=nn+15){
			gg.drawLine(n,nn,n,nn+1);
			gg1.drawLine(n,nn+7,n,nn+8);
			}
		}
		gg.dispose();
		gg1.dispose();
		setBackground(c);
		t = new Timer("Timer");
		
		t.scheduleAtFixedRate(tk,500,500);
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
		gg2.setColor(c);
		gg2.fillRect(0,0,600,300);
		ii++;
		if (ii>124) ii=0;
		gg2.setClip(polys[ii]);
		if (iii==1) gg2.drawImage(bitmap1,0,0,null);
		if (iii!=1) gg2.drawImage(bitmap2,0,0,null);
		g.drawImage(bitmap3,0,0,null);

		
	}
}
