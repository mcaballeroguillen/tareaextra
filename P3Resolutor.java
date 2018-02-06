package tareaextra;

import java.util.ArrayList;
import java.util.HashMap;

public class P3Resolutor {
	ArrayList<ArrayList<Integer>> matris;
	ArrayList<ArrayList<Integer>> columnas;
	HashMap<Integer, ArrayList<ArrayList<Integer>>> potencias;
	
	public P3Resolutor(){
		this.matris= new ArrayList<ArrayList<Integer>>();
		this.columnas =  new ArrayList<ArrayList<Integer>>();
		this.potencias = new HashMap<Integer, ArrayList<ArrayList<Integer>>>(); 
	}
	//Metodo que sirver para cargar la matris input.
	public void setMatris(ArrayList<ArrayList<Integer>> matris){
		this.matris=matris;
	}
	//Como trabajamos con una arreglo de arreglos, y vamos a hacer muchas multiplicaciones,
	//este método lo que hace es extraer las columnas en otra matriz, para hasi recorrer la matris.
	// solo una ves.
	public void cargarcolumnas(ArrayList<ArrayList<Integer>> matris){
		this.columnas.clear();
		int x,y;
		for(x=0;x<matris.size();x++){
			ArrayList<Integer> columna = new ArrayList<Integer>(); 
			Integer valor=0;
			for(y=0;y<matris.size();y++){
				valor= matris.get(y).get(x);
				columna.add(valor);
			}
			this.columnas.add(columna);
		}
		
	}
	// Este metodo lo que hace es devoler el escalar de multiplicar una fila por una columna.
	public Integer multcomfi(ArrayList<Integer> fila, ArrayList<Integer>columna){
		Integer resp=0;
		int x;
		for(x=0;x<fila.size();x++){
			resp= resp + fila.get(x)*columna.get(x);
		}
		
		return resp;
	}
	//Este método lo que hace es multiplicar dos matrices, La matriA por la matrizB
	public ArrayList<ArrayList<Integer>> multmatris(ArrayList<ArrayList<Integer>> matrizA,ArrayList<ArrayList<Integer>> matrizB ){
		this.cargarcolumnas(matrizB);
		int x,y;
		ArrayList<ArrayList<Integer>> resp= new ArrayList<ArrayList<Integer>>(); 
		for(x=0;x<matrizA.size();x++){
			ArrayList<Integer> fila = new ArrayList<Integer>();
			for(y=0;y<matrizA.size();y++){
				fila.add(this.multcomfi(matrizA.get(x), this.columnas.get(y)));
				}
			resp.add(fila);
		}
		return resp;
	}
	
	public Integer caminos(ArrayList<ArrayList<Integer>> matriz, Integer k, Integer u, Integer v){
		this.potencias.clear();
		this.potencias.put(1, matriz);
		Integer potencia=2;
		ArrayList<ArrayList<Integer>> matrisproducto= matriz;
		while(potencia<=k){
			potencia= 2*potencia;
			matrisproducto=  this.multmatris(matrisproducto,matrisproducto);
			
			//vamos guardando el producto de la potencias, por si la necesitamos para,
			//alcanzar el valor k.
			this.potencias.put(potencia, matrisproducto);
			
		}
		//Dividimos entre 2 por el while hace una multiplación de más , para salir del mismos.		
		potencia=potencia/2;
		System.out.println(matrisproducto);
		if(potencia==k){return matrisproducto.get(u).get(v);}
		//Lo que resta para llegar a k
		
		Integer resto= k-potencia;
		//Buscamos la potencia de 2 mayor que es menor al resto.
		while(potencia>resto){potencia=potencia/2;}
		
		matrisproducto= this.multmatris(matrisproducto, potencias.get(potencia));
		//si aun queda para llegar, puede ser que este resto sea 1 o 0.
		resto= resto-1;
		
		if(resto==1){matrisproducto= this.multmatris(matrisproducto, potencias.get(1));}
		
		System.out.println(matrisproducto);
		
		return matrisproducto.get(u).get(v);
		
		
	}
	
	
}
