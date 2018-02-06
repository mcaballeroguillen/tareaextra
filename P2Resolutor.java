package tareaextra;

import java.util.ArrayList;

public class P2Resolutor {
	ArrayList<Integer> cocientes;
	Integer mcd;
	Integer x,y;
	
	public P2Resolutor(){
		this.cocientes= new ArrayList<Integer>();
		mcd=x=y=0;
		
	}
	//Calculamos el mcd de a y b y vamos guardando su cociente.
	private void calcularmcd(Integer a, Integer b){
		if(a==0){ 
			calcularconstantes(0,1,cocientes.size()-1);
			this.mcd=b;
			return;
		}
		if(b==0){ 
			calcularconstantes(1,1,cocientes.size()-1);
			this.mcd=a;
			return;
		}
		cocientes.add(a/b);
		this.calcularmcd(b, a%b);
		
	}
	//Calculamos la cosntantes
	private void calcularconstantes(int i, int j, int indice) {
		Integer x1,y1;
		Integer k= cocientes.get(indice);
		
		y1=i-k*j;
		x1=j;
		
		if(indice>0){this.calcularconstantes(x1, y1, indice-1);}
		else{x=x1; y=y1; return;}
		
	}
	//Imprimimos la cantidad de tazas necesarias. 
	public void calculartasa(Integer a, Integer b, Integer c){
		this.calcularmcd(a, b);
		Integer k= c/mcd;
		System.out.println("El mcd de a y b es "+ mcd);
		System.out.println("Se necesitan " + k*x + " de tazas de tamaño " +a);
		System.out.println("Se necesitan " + k*y +" de tazas de tamaño " + b );
	}
}
