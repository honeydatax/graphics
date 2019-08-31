import java.util.*;
import java.applet.*;
import java.awt.*;
import java.lang.Math;
import java.awt.image.*;
import java.awt.geom.Ellipse2D;

public class texture25 extends Applet {
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
		for (nnn=0;nnn<580;nnn=nnn+100){
			for (n=1;n<300;n=n+n){
				gg1.fillOval(nnn,n,100,n);
			}
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
			
		for (bn=0;bn<300;bn++){
				bnn=bn;
				gg.drawImage(bitmap2,(630/2)-bn,bnn,((630/2)+bn)+1,bnn+1,0,bn,630,bn+1,null);
			}
	
		g.drawImage(bitmap1,0,0,null);
		

		
	}
}
