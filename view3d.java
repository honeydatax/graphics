import java.util.*;
import java.applet.*;
import java.awt.*;
import java.io.*;
import java.lang.Math;
import java.io.FilePermission;
import java.awt.image.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;


public class view3d extends Applet implements MouseListener{
	double pii=3.1415927;
	double [] rpi= new double[]{0.00,1.00,2.00,4.00,8.00,16.00,16.00};
	int ii=1;
	int x=50;
	int y=50;
	int xx=1;
	int yy=1;
	int zz=24*12;
	double degrees=0.00;
	double divisions=32.00;
	int gridv=1;
	int [] maps= new int[8*8*8+6]; 
	int [] maps2= new int[16*16*16]; 
	int [] maps3= new int[8*8+1]; 
	Color c=new Color(0,0,0);
	Color [] colors=new Color[16];
	int colorss=1;
	Color cc=new Color(255,255,255);
	Polygon poly1;
	Timer t ;
	VolatileImage bitmap1;
	Graphics2D gg1;
	AppletContext cox;
	
	TimerTask tk =new TimerTask(){
			public void run(){
				Graphics g =getGraphics();
				if (ii < 230){
					degrees=degrees+1.00;
					if (degrees>divisions)degrees=0.00;
					dataClear();
					dataRun();
					paint(g);
				}
				if (ii > 230) t.cancel();
				
				
			}
		};


	public void init(){
		int n;
		Color cc1;
		cox=this.getAppletContext();
		bitmap1=createVolatileImage(600,300);
		gg1=bitmap1.createGraphics();
		gg1.setColor(cc);
		gg1.fillRect(0,0,600,300);
		gg1.setColor(c);
		maps[0]=51;
		maps[1]=68;
		maps[2]=8;
		maps[4]=8;
		maps[5]=8;
		for (n=6;n<(8*8*8+6);n++){
			maps[n]=0;
		}
		dataClear();
		colors[0]=new Color(255,255,255);
		colors[1]=new Color(0,0,0);
		colors[2]=new Color(0,0,255);
		colors[3]=new Color(0,255,0);
		colors[4]=new Color(255,0,0);
		colors[5]=new Color(255,255,0);
		colors[6]=new Color(255,0,255);
		colors[7]=new Color(0,255,255);
		colors[8]=new Color(128,128,128);
		colors[10]=new Color(128,128,255);
		colors[11]=new Color(128,255,128);
		colors[12]=new Color(255,128,128);
		colors[13]=new Color(255,255,128);
		colors[14]=new Color(255,128,255);
		colors[15]=new Color(255,255,255);
		setBackground(cc);
		t = new Timer("Timer");
		addMouseListener(this);
		cox.showStatus("paint");
		t.scheduleAtFixedRate(tk,1000,1000);
		dataLoad();
		dataClear();
		dataRun();

	}
	public void destroy(){
		t.cancel();
		ii=230;
		gg1.dispose();
	}


		public int center(int maxxy,int z){
			return ((maxxy-z)/2);
		}

		
	public void paint (Graphics g) {
		drawinto((zz/6));
		g.drawImage(bitmap1,0,0,null);
	}
		public void mouseClicked(MouseEvent e){

			}

		public void mouseExited(MouseEvent ee){
			}
		public void mouseEntered(MouseEvent ee){

			}
		public void mousePressed(MouseEvent ee){

			}
		public void mouseReleased(MouseEvent ee){

			}
			


		
		public void setxyz(int x,int y, int z,int colorss){
				int n=z*256+y*16+x;
				maps2[n]=colorss;
				
		}
		public int getxyz(int x,int y, int z){
				int n=z*64+y*8+x+6;
				return maps[n];
				
		}

		public void drawinto(int z){
			int nx=0;
			int ny=0;
			int nz=0;
			int zzz=zz-1;
			gg1.setColor(cc);
			gg1.fillRect(0,0,600,300);

			gg1.setColor(c);
			for (nz=(24-16);nz<24;nz=nz+1){
				for (ny=0;ny<16;ny=ny+1){
					for (nx=0;nx<16;nx=nx+1){
						zz=nz*6;
						if (maps2[(nz-(24-16))*256+ny*16+nx] != 0 ) gg1.setColor(colors[maps2[(nz-(24-16))*256+ny*16+nx]]);
						if (maps2[(nz-(24-16))*256+ny*16+nx] != 0 ) gg1.fillRect((center(600,zz)+(nx*(zz/4))-150),(center(300,zz)+(ny*(zz/4))-50),(zz/4),(zz/4));
						if (maps2[(nz-(24-16))*256+ny*16+nx] == 15 ) gg1.setColor(c);
						if (maps2[(nz-(24-16))*256+ny*16+nx] != 15 ) gg1.setColor(cc);
						if (maps2[(nz-(24-16))*256+ny*16+nx] != 0 ) gg1.drawRect((center(600,zz)+(nx*(zz/4))-150),(center(300,zz)+(ny*(zz/4))-50),(zz/4),(zz/4));

				}
				
			}
			if (zz>=zzz) nz=60;
		}
	}
	public void dataLoad(){
		int n=0;
		int nn0=0;
		int nn1=0;
		int nn2=0;
		int nn3=0;
		int nn4=0;
		int nn5=0;

		FileInputStream f1 =null;
			try{
			f1 = new FileInputStream("avatar.3d");
			nn0=f1.read();
			nn1=f1.read();
			nn2=f1.read();
			nn3=f1.read();
			nn4=f1.read();
			nn5=f1.read();

			if (nn0==maps[0] && nn1==maps[1] && nn2==maps[2] && nn3==maps[3] && nn4==maps[4] && nn5==maps[5]){
				for (n=0;n<(8*8*8);n++){
					maps[n+6]=f1.read();
				}
			}
			f1.close();
		}catch(IOException e){

		}

	}
	
	public void dataCopy(){
		int nx=0;
		int ny=0;
		int nz=0;

		for (nz=0;nz<8;nz++){
			for (ny=0;ny<8;ny++){
				for (nx=0;nx<8;nx++){
					setxyz(nx+4,ny+4,nz+4,getxyz(nx,ny,nz));
				}
			}
		}
	}
	public void dataClear(){
		int n=0;
		for (n=0;n<(16*16*16);n++){
			maps2[n]=0;
			if (n<8*8) maps3[n]=0;
		}

	}
	public void dataRun(){
		double radius=0;
		double degs=0;		
		double rr=0;
		double rr1=0;
		int rrr=0;
		int nx=0;
		int ny=0;
		int nz=0;
		int colorc=0;
		int nnx=0;
		int nny=0;
		int nnnz=0;
		int nnnx=0;
		int nnny=0;
		int nnz=0;
		
		for (radius=1.00;radius<8.00;radius++){
			for (degs=0.00;degs<divisions;degs++){
				nnnx=(int) ((4.00)+radius*Math.sin(degs/(divisions/2)*Math.PI));
				nnnz=(int) ((4.00)+radius*Math.cos(degs/(divisions/2)*Math.PI));
				nnx=(int) ((8.00)+radius*Math.sin((degs+degrees)/(divisions/2)*Math.PI));
				nnz=(int) ((8.00)+radius*Math.cos((degs+degrees)/(divisions/2)*Math.PI));
				if (nnnx>-1 && nnnx<8 && nnnz>-1 && nnnz<8){
					if(maps3[nnnz*8+nnnx]==0){
						maps3[nnnz*8+nnnx]=1;
						if (nnx>-1 && nnx<16 && nnz>-1 && nnz<16){
							for (ny=0;ny<8;ny++){
								colorc=getxyz(nnnx,ny,nnnz);
								if  (colorc!=0 && colorc<16) setxyz(nnx,ny,nnz,colorc);

							}
						}
					}
		
				}		
			}
		}
	}

}
