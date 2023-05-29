package Lab02;

public class Ejercicio3 {
    public static void main(String []args){
        trianguloRecursivo(16);
    }

    public static void trianguloRecursivo(int n){
        for(int i=1; i<=n;i++ ){
            for (int j=0;j<1;j++){
                System.out.print("&");
            }
            System.out.println();
        }
    }


    
}
