
public class object{
public static String [] labels= new String[50];
	public static void main(String[] args){
		int i=0;
		String argvs="";
		for (i=0;i<args.length;i++){
			argvs=argvs+args[i];
		}
		System.out.println(argvs);
		i=lists(argvs);

		PrintList(i);
	}

	static int lists(String s){
		int i=0;
		int ii=0;
		int iii=0;
		int iiii=0;
		int ti=0;
		char [] ss=s.toCharArray();
		for (i=0;i<ss.length;i++){
			if (ss[i]=='+' || ss[i]=='-' || ss[i]=='*' || ss[i]=='/' || ss[i]=='\\' || ss[i]=='(' || ss[i]==')'){
				if (i!=0 && iiii!=1) {
					if (labels[ii]==null)labels[ii]="";
					ii++;
				}
				if (labels[ii]==null)labels[ii]="";
				labels[ii]=labels[ii]+ss[i];
				ii++;
			}else{
				if (labels[ii]==null)labels[ii]="";
				labels[ii]=labels[ii]+ss[i];
				iii++;
				iiii=0;
				ti++;

			}
			
		}
		ii++;

		return ii;
	}

	static void PrintList(int size){
		int i=0;
		int ppi=0;
		double d=0.00;
		double dd=0.00;


		for (i=0;i<size;i++){
			if (labels[i]!=""){
				if(labels[i].charAt(0)>47 && labels[i].charAt(0)<58){
					if (i==0) {
						d=Double.parseDouble(labels[i]);
					}}else{
						if (labels[i].charAt(0)=='+'){
							dd=d;
							d=sums(d,Double.parseDouble(labels[i+1]));	
							System.out.println(Double.toString(dd)+" + "+labels[i+1]+" = "+Double.toString(d));
							ppi=1;
						}else{
							if (labels[i].charAt(0)=='-'){
								dd=d;
								d=subs(d,Double.parseDouble(labels[i+1]));	
								System.out.println(Double.toString(dd)+" + "+labels[i+1]+" = "+Double.toString(d));
								ppi=1;
							}else{
								if (labels[i].charAt(0)=='/'){
									dd=d;
									d=divs(d,Double.parseDouble(labels[i+1]));	
									System.out.println(Double.toString(dd)+" + "+labels[i+1]+" = "+Double.toString(d));
									ppi=1;
								}else{
									if (labels[i].charAt(0)=='\\'){
										dd=d;
										d=divs(d,Double.parseDouble(labels[i+1]));	
										System.out.println(Double.toString(dd)+" + "+labels[i+1]+" = "+Double.toString(d));
										ppi=1;
									}else{
										if (labels[i].charAt(0)=='*'){
											dd=d;
											d=muls(d,Double.parseDouble(labels[i+1]));	
											System.out.println(Double.toString(dd)+" + "+labels[i+1]+" = "+Double.toString(d));
											ppi=1;
										}
									}
								}
							}
						}
				}

			}
			i=i+ppi;
			ppi=0;
	
		}
		System.out.println(" = "+Double.toString(d));
	}
	static double sums(double d1,double d2){
		return d1+d2;
	}	

	static double subs(double d1,double d2){
		return d1-d2;
	}	
	static double muls(double d1,double d2){
		return d1*d2;
	}	
	static double divs(double d1,double d2){
		return d1/d2;
	}	

}

