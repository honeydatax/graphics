import java.util.*;
import java.applet.*;
import java.awt.*;
import java.lang.Math;
import java.awt.image.*;
import java.awt.geom.Ellipse2D;

public class texture13 extends Applet {
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
	Ellipse2D ovo =new Ellipse2D.Float(0,0,300,300);
	Timer t ;
	VolatileImage bitmap1;
	VolatileImage bitmap2;
	VolatileImage bitmap3;
	VolatileImage bitmap4;
	Graphics2D gg;
	Graphics2D gg1;
	Graphics2D gg2;
	Graphics2D gg3;
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
		int n1;
		int n;
		int nn;
		int nnn;
		Color cc1;
		ii=4;
		px=0;
		cox=this.getAppletContext();
		bitmap1=createVolatileImage(650,300);
		bitmap2=createVolatileImage(300,300);
		bitmap3=createVolatileImage(1000,300);
		bitmap4=createVolatileImage(3000,300);
		gg=bitmap1.createGraphics();
		gg1=bitmap2.createGraphics();
		gg2=bitmap3.createGraphics();
		gg3=bitmap4.createGraphics();
		poly=new Polygon();
		gg2.setColor(cc);
		gg2.fillRect(0,0,1000,300);
		gg.setColor(c);
		gg.fillRect(0,0,650,300);
		nnn=0;
		gg2.setColor(c);
		for (n=0;n<942;n=n+(942/24)){
				if (nnn!=24) gg2.drawString(Integer.toString(nnn),n,140);
				nnn=nnn+1;
		}


		for (n=0;n<3;n++){
			poly.addPoint(943*n,0);
			poly.addPoint(943*n+943,0);
			poly.addPoint(943*n+943,300);
			poly.addPoint(943*n,300);
			gg3.setClip(poly);
			gg3.drawImage(bitmap3,943*n,0,null);
			poly.reset();
		}

		gg.setClip(ovo);
		gg.setColor(c);
		gg2.dispose();
		gg3.dispose();
		setBackground(c);
		t = new Timer("Timer");
		t.scheduleAtFixedRate(tk,600,600);
	}
	public void destroy(){
		t.cancel();
		ii=230;
		
	}
		
	public void paint (Graphics g) {


			poly.addPoint(-px,0);
			poly.addPoint(300,0);
			poly.addPoint(300,300);
			poly.addPoint(-px,300);
			gg1.setClip(poly);
			gg1.drawImage(bitmap4,-px,0,null);
			poly.reset();

			gg.drawImage(bitmap2,0,0,null);
		
		g.drawImage(bitmap1,0,0,null);
		px=px+10;
		if (px>944) px=px-943;
		//poly.reset();
		//poly=new Polygon();		
		
	}
}
