import java.util.*;
import java.applet.*;
import java.awt.*;
import java.lang.Math;
import java.awt.image.*;
import java.awt.geom.Ellipse2D;

public class texture28 extends Applet {
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
		int n1=1;
		int n2=1;
		int n3=1;
		int n;
		int nn;
		int nnn;
		int c1c;
		int c2c;
		
		Color cc1;
		ii=4;
		px=0;
		cox=this.getAppletContext();
		bitmap1=createVolatileImage(650,300);
		bitmap2=createVolatileImage(650,300);
		bitmap3=createVolatileImage(650,300);
		bitmap4=createVolatileImage(650,300);
		gg=bitmap1.createGraphics();
		gg1=bitmap2.createGraphics();
		gg2=bitmap3.createGraphics();
		gg3=bitmap4.createGraphics();
		poly=new Polygon();
		gg1.setColor(c);
		gg1.fillRect(0,0,650,300);
		nnn=0;
		gg1.setColor(cc);
		c1c=0;
		c2c=0;
		for (n=1;n<300;n=n+50){
			for (nnn=0;nnn<580;nnn=nnn+50){
				if (c1c==0) gg1.drawRect(nnn,n,50,50);
				if (c1c!=0)gg1.fillRect(nnn,n,50,50);
				c1c++;
				if (c1c>1)c1c=0;

			}

			c2c++;
			if (c2c>1)c2c=0;
			c1c=c2c;

		}
		gg2.dispose();




		gg.setColor(c);
		gg2.dispose();
		gg3.dispose();
		setBackground(c);
		t = new Timer("Timer");
		//t.scheduleAtFixedRate(tk,600,600);
	}
	public void destroy(){
		t.cancel();
		ii=230;
		
	}
		
	public void paint (Graphics g) {
			int bn=0;
			int bnn=150;
			int n1=1;
			int n2=1;
			int n3=1;
			int c1c=1;
			int c2c=0;
			int c3c=1;
			n1=300/8;
		for (bn=0;bn<300;bn++){
				bnn=bn;
				c2c=c2c+1;
				n3=300-bn;
				if (c1c>=n1){
					 n1=n1*555/1000;
					 c1c=0;
					c2c=c2c+1;	 
					
				 }
				gg.drawImage(bitmap2,(630/2)-n3,n3,((630/2)+n3)+1,n3+1,0,300-c2c,630,300-c2c+1,null);
				if (c2c>299) bn=500;
				if (n1<2) c2c=c2c+1;
				if (n1<2) c3c=c3c+1;
				c1c=c1c+1;
			}
	
		g.drawImage(bitmap1,0,0,null);
		

		
	}
}
