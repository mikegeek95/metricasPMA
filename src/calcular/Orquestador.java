package calcular;

import ClasesTipo.Clase;
import ClasesTipo.objetoRespuesta;
import Metricas.EjeMetricas;
import java.io.IOException;
import java.util.ArrayList;

public class Orquestador {
    
 
    public static void main (String [] args) throws IOException {
    	
    	  ManejoArchivos oMArchivos = new ManejoArchivos();
    	  OclasesDerivadas rm2 = new OclasesDerivadas(); 
    	  ArrayList<Clase> listaC = new ArrayList<>();
    	  EjeMetricas metricas = new EjeMetricas();
    	    
    	    
          oMArchivos.seleccionar_archivos();
          objetoRespuesta obj = new objetoRespuesta();
          listaC = (ArrayList<Clase>) oMArchivos.listaClases.clone();
          listaC= rm2.obtenerClasesDerivadas(listaC);
          metricas.ProteccionMoular(listaC);
    }
    
  
    
}
