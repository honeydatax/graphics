import java.util.*;
import java.applet.*;
import java.awt.*;
import java.lang.Math;
import java.awt.image.*;
import java.awt.Image.*;
import java.awt.geom.*;

public class rotate extends Applet {
	int ii=1;
	int x=50;
	int y=50;
	int xx=1;
	int yy=1;
	int deg=0;
	Color c=new Color(230,230,0);
	Color cc=new Color(255,0,0);
	Polygon poly;
	Timer t ;
	BufferedImage bitmap1;
	BufferedImage bitmap2;
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
		bitmap1=new BufferedImage(50,50,5);
		bitmap2=new BufferedImage(580,250,5);
		gg=bitmap1.createGraphics();
		poly=new Polygon();
		gg.setColor(cc);
		gg.fillRect(0,0,50,50);
		gg.setColor(c);
		nnn=0;
		for (n=0;n<254/5;n=n+5){
			cc1=new Color(255,n*5,0);
			gg.setColor(cc1);
			gg.fillRect(n,0,n*+1,50);
		}
		gg.setFont(new Font("mono",Font.PLAIN,13));
		gg.drawString("JAVA",11,11);
		gg.dispose();
		setBackground(c);
		gg=bitmap2.createGraphics();
		gg.setColor(c);
		gg.fillRect(0,0,580,250);
		gg.dispose();
		t = new Timer("Timer");
		t.scheduleAtFixedRate(tk,200,200);
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
		g.drawImage(bitmap2,0,0,null);
		deg=deg +5;
		if (deg > 360) deg=deg-360;
		AffineTransform t1=AffineTransform.getRotateInstance(Math.toRadians(deg),25.00,25.00);
		AffineTransformOp tt1= new AffineTransformOp (t1,AffineTransformOp.TYPE_BILINEAR);
		g.drawImage(tt1.filter(bitmap1,null),50,50,null);
		
	}
}
