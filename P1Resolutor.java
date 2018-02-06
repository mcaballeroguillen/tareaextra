package tareaextra;

import java.util.ArrayList;

public class P1Resolutor {
	ArrayList<Integer> primosmenores;
	
	public P1Resolutor(){
		this.primosmenores = new ArrayList<Integer>();
		
	}
	
	private void CargarPrimos(Integer k){
		ArrayList<Integer> numeros= new ArrayList<Integer>();
		//Cargamos los números de 1 a K
		int x;
		for(x=1;x<=k;x++){numeros.add(x); }
		//Ahora usaramos el método de la criba de Eratosteles, solo que iremos 
		//borrando los números compuestos y en el arreglo solo quedaran los primos.
		for(x=2;x<=k;x++){
			if(numeros.contains(x)){
				Integer y=x;
				while(y<=k){
					y=y+x;
					if(numeros.contains(y)){numeros.remove(y);}
				}
			}else{
				//Contiuamos con el siguiente número, si ya hemos borrado este número 
				continue;
				
			}
		}
		this.primosmenores=numeros;
	}
	
	
	
	public ArrayList<Integer> descom(Integer n){
		this.CargarPrimos(n);
		ArrayList<Integer>desc= new ArrayList<Integer>();
		Integer x=n;
		//Comenzamos de 1 ya que 0 es el número 1.
		int indice=1;
		while(x>1){
			Integer primo = this.primosmenores.get(indice);
			if((x%primo)==0){
				x= x/primo;
				desc.add(primo);
				indice=1;
			}else{
				indice=indice+1;
			}
			
		}
		return desc;
	}
	
	public float fununcioEuler(Integer N){
		ArrayList<Integer>desco= this.descom(N);
		//Arreglo donde vamos a almacenar los primos de la descomposición
		//ya vistos.
		ArrayList<Integer> primya= new ArrayList<Integer>();
		int x;
		float resp=1;
		for(x=0;x<desco.size();x++){
			Integer primo = desco.get(x);
			if(primya.contains(primo)){continue;}else{
				float factor=1- (1/(float)primo);
				resp=resp*factor;
				primya.add(primo);
				}
		}
		
		return (float)resp*N;
	}
	
	public void calcular(Integer x){
		this.CargarPrimos(x);
		ArrayList<Integer> desc= this.descom(x);
		System.out.println("Los primos menores son:" + this.primosmenores.toString());
		System.out.println("La descomposición prima del número es"+ desc.toString());
		System.out.println("La cantidad posibles de tiros ganadores es:"+ this.fununcioEuler(x));
	}
	

}
