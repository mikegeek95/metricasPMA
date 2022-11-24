package Metricas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import ClasesTipo.Clase;

public class PMAPr extends PMA{
	
		private ArrayList<ArrayList<Clase>> jerarquias=new ArrayList<ArrayList<Clase>>();
		private ArrayList<Clase> jerarquia=new ArrayList<Clase>();
		private ArrayList<Clase> clasesBaseP =new ArrayList<Clase>();
	    private ArrayList<Clase> cHijas = new ArrayList<Clase>();

	    
	    private double TACp;
	    
	    
	    public double calcular() {
			
			obtenerClasesBase();
			
			buscarniveles();
			
			for(ArrayList<Clase> j: jerarquias) {
				for (Clase cA:j) {
					if(!cA.getEsInterfaz() && cA.getVariables().size()!=0) {
						for(Map.Entry<String, String> var:cA.getVar_b().entrySet()) {
							for(String varcalif: cA.getVariables()) {
								if(buscarPalabra(obtenernombre(var.getKey()),varcalif) && valifcalif(varcalif).equals("protected")) {
									TVPr++;						
								}
							}
						}
						TACp=TACp+cA.getVar_b().size();				
				
					}	
				}
			}
			PMAPr=TVPr/TACp;
				
		System.out.println("Nivel de protección modular protected de la jerarquia :"+TVPr+"/"+TACp+"="+(TVPr/TACp));
		//TVPrC=0;
			
			conteomodular();
			
			return PMAPr;
	    }

	
	private void obtenerClasesBase() {
	    for (Clase cP : listaC) {
	    	for(Clase cH: listaC) {
	    		if((cH.getHeredaDeClase() )&& cH.getClasePadre().equals(cP.getNombre())) {
	    			cHijas.add(cH);
	    			clasesBaseP.add(cP);
	    		}
	    	}
	    }

	    limpiarlista(clasesBaseP);
	    lastgeneration();
	}
	


	private void buscarniveles() {
		for(Clase h: cHijas) {	
			jerarquia.add(h);
			bucarpadre(h);
			jerarquias.add(new ArrayList<Clase>(jerarquia));
			jerarquia.clear();
		}
		
		
		
	}





	private void bucarpadre(Clase h) {
		for(Clase cp: clasesBaseP) {
			if(h.getClasePadre().equals(cp.getNombre()) && ((h.getPaquete().equals(cp.getPaquete()) && !buscarEnImportaciones(cp,h))||( !h.getPaquete().equals(cp.getPaquete()) && buscarEnImportaciones(cp,h) ) ) ){
				if(!comprobacion(cp,jerarquia)) {
				jerarquia.add(cp);
				if(cp.getHeredaDeClase()) {
					bucarpadre(cp);
				}
				}
			}
		}
		
	}



	private boolean comprobacion(Clase cp, ArrayList<Clase> array) {
		boolean verif= false;
		for(Clase c: array) {
			if(c.equals(cp)) {
				verif=true;
			}
		}
		return verif;
	}



	private void limpiarlista(ArrayList<Clase> array) {
		
		for(int x=0;x<array.size();x++) {
			if( x<array.size()-1){
				if (array.get(x)==array.get(x+1)) {
					array.remove(x);
			}
			}
		}
		
		
	}


	private void lastgeneration() {
		
		for(int x=0;x<cHijas.size();x++) {
			for(int y=0;y<clasesBaseP.size();y++) {
				if(cHijas.get(x).equals(clasesBaseP.get(y))){
					cHijas.remove(x);
				}
			}
		}
		
		
	}
	
	public void conteomodular() {
		TVPrC=0;
		for (Clase cA:listaC) {
			if(!cA.getEsInterfaz() && cA.getVariables().size()!=0) {
				for(Map.Entry<String, String> var:cA.getVar_b().entrySet()) {
					
					for(String varcalif: cA.getVariables()) {
						
						if(buscarPalabra(obtenernombre(var.getKey()),varcalif) && valifcalif(varcalif).equals("protected")) {
							TVPrC++;
						}
					}
				}
			}
		}
		System.out.println("TOTAL ATRIBUTOS PROTEGIDOS "+TVPrC);
	}


}
