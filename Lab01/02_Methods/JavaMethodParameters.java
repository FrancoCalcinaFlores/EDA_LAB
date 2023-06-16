package ejercicios;

public class JavaMethodParameters {
	
	  static void checkAge(int age) {

	    
	    if (age < 18) {
	      System.out.println("Acceso denegado - no cumples los requisitos"); 
	      
	    
	    } else {
	      System.out.println("Acceso concedido - cumples los requisitos"); 
	    }
	    
	  } 

	  public static void main(String[] args) { 
	    checkAge(20); 
	  } 

}
