import java.util.*;
import java.applet.*;
import java.awt.*;
import java.lang.Math;
import java.awt.image.*;

public class texture5 extends Applet {
	int ii=0;
	int x=50;
	int y=50;
	int xx=1;
	int yy=1;
	Color c=new Color(230,230,0);
	Color cc=new Color(255,0,0);
	Polygon poly;
	Timer t ;
	VolatileImage bitmap1;
	VolatileImage bitmap2;
	Graphics2D gg;
	Graphics2D gg1;
	AppletContext cox;
	
	TimerTask tk =new TimerTask(){
			public void run(){
				Graphics g =getGraphics();
				if (ii < 230){
					ii++;
					if (ii>1) ii=0;
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
		bitmap1=createVolatileImage(600,300);
		bitmap2=createVolatileImage(600,300);
		gg=bitmap1.createGraphics();
		gg1=bitmap2.createGraphics();
		poly=new Polygon();
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
		poly.addPoint(0,300);
		poly.addPoint(300,150);
		poly.addPoint(600,300);
		
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
		g.setClip(poly);
		if (ii==0) g.drawImage(bitmap1,0,0,null);
		if (ii!=0) g.drawImage(bitmap2,0,0,null);

		
	}
}
