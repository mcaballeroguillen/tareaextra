package tareaextra;

import java.util.ArrayList;

public class MainP3 {

	public static void main(String[] args){
		P3Resolutor respuesta= new P3Resolutor();
		ArrayList<Integer> fila1= new ArrayList<Integer>();
		fila1.add(0); fila1.add(1);fila1.add(0);fila1.add(0);
		ArrayList<Integer> fila2= new ArrayList<Integer>();
		fila2.add(0); fila2.add(0);fila2.add(1);fila2.add(0);
		ArrayList<Integer> fila3= new ArrayList<Integer>();
		fila3.add(0); fila3.add(0);fila3.add(0); fila3.add(1);
		ArrayList<Integer> fila4= new ArrayList<Integer>();
		fila4.add(0); fila4.add(0);fila4.add(0); fila4.add(0);
		ArrayList<ArrayList<Integer>> matris= new ArrayList<ArrayList<Integer>>();
		matris.add(fila1);matris.add(fila2); matris.add(fila3);matris.add(fila4);
		respuesta.setMatris(matris);
		
		System.out.println(respuesta.caminos(matris,1 , 0, 0));
	}
	
	
}
