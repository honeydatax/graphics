import java.util.*;
import java.applet.*;
import java.awt.*;
import java.lang.Math;
import java.awt.image.*;
import java.awt.event.*;

public class texture8 extends Applet implements KeyListener{
	int bii=0;
	int ii=0;
	int iii=0;
	int iiii=0;
	int x=50;
	int y=50;
	int xx=1;
	int yy=1;
	int zzz=1;
	int zzzz=0;
	int p2z=0;
	int pz2=0;
	Color c=new Color(230,230,0);
	Color cc=new Color(255,0,0);
	Polygon poly;
	Polygon[] polys=new  Polygon[2000];
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
		bitmap1=createVolatileImage(650,300);
		bitmap2=createVolatileImage(650,300);
		bitmap3=createVolatileImage(650,300);
		gg=bitmap1.createGraphics();
		gg1=bitmap2.createGraphics();
		gg2=bitmap3.createGraphics();
		poly=new Polygon();
		for (n=0;n<2000;n++){
			polys[n]=new Polygon();
			//p0
			polys[n].addPoint(0,300);
			//p1
			polys[n].addPoint(centerX(zzz)+getCurve(zzz),centerY(zzz)+getCurve(zzz));
			//p2
			polys[n].addPoint(centerX(zzz)+getCurve(zzz)*2,centerY(zzz));
			//p3
			polys[n].addPoint(getCCurve(zzz),centerY(zzz));
			//p4
			polys[n].addPoint(getCCurve(zzz),getZZ(zzz));
			//p5
			polys[n].addPoint((centerX(zzz)+getCurve(zzz)*2)+zzz,getZZ(zzz));
			//p6
			polys[n].addPoint(650,300);

			zzz=getZ(zzz);
			zzzz=n;
			if (zzz>280)n=3000;
		}

		p2z=zzz/2;
		for (n=zzzz;n<2000;n++){
			polys[n]=new Polygon();
			//p0
			polys[n].addPoint(0,300);
			//p1
			polys[n].addPoint(centerX(p2z)+getCurve(p2z),centerY(p2z)+getCurve(p2z));
			//p2
			polys[n].addPoint(centerX(p2z)+getCurve(p2z)*2,centerY(p2z));
			//p3
			polys[n].addPoint(getCCurve(zzz),centerY(zzz));
			//p4
			polys[n].addPoint(getCCurve(zzz),getZZ(zzz));
			//p5
			polys[n].addPoint(650,300);
			//p6
			polys[n].addPoint(650,300);

			zzz=backZ(zzz);
			zzzz=n;
			if (zzz<2)n=3000;
		}


		pz2=650;
		for (n=zzzz;n<2000;n++){
			polys[n]=new Polygon();
			//p0
			polys[n].addPoint(0,300);
			//p1
			polys[n].addPoint(pz2,0);
			//p2
			polys[n].addPoint(pz2,0);
			//p3
			polys[n].addPoint(pz2,0);
			//p4
			polys[n].addPoint(pz2,0);
			//p5
			polys[n].addPoint(pz2,0);
			//p6
			polys[n].addPoint(650,300);

			pz2=pz2-(pz2/10);
			zzzz=n;
			if (pz2<400)n=3000;
		}






		gg.setColor(cc);
		gg1.setColor(cc);
		gg.fillRect(0,0,650,300);
		gg1.fillRect(0,0,650,300);
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
		addKeyListener(this);
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
		gg2.fillRect(0,0,650,300);
		//ii=ii+iiii;
		//iiii=0;
		ii++;
		if (ii>zzzz) ii=0;
		if (ii<0) ii=0;
		gg2.setClip(polys[ii]);
		if (iii==1) gg2.drawImage(bitmap1,0,0,null);
		if (iii!=1) gg2.drawImage(bitmap2,0,0,null);
		g.drawImage(bitmap3,0,0,null);
		if (bii==0)this.requestFocusInWindow();		
		bii=1;
	}

	public void keyTyped (KeyEvent e) {
				
	}

	public void keyPressed (KeyEvent e) {
	}
	
	public void keyReleased (KeyEvent e) {
			//if(e.getKeyCode()==37) iiii=-1;
			//if(e.getKeyCode()==39) iiii=1;
			cox.showStatus("key press" + Integer.toString(e.getKeyCode()));
	}

	public int getZ(int z){
		int zz=z+z;
		return zz;
	}	
	public int centerX(int z){
		int zz=(650-z)/2;
		return zz;
	}
	public int centerY(int z){
		int zz=z/2;
		return zz;
	}
	
	public int getZZ(int z){
		int zz=(z*1000)/666;
		return zz;
	}
	
	public int getCurve(int z){
		int zz=(z/4);
		return zz;
	}
	public int getCCurve(int z){
		int zz=650;
		if (z < 3) zz=650/2+z;
		return zz;
	}

	public int backZ(int z){
		int zz=z/2;
		return zz;
	}	
	

}
