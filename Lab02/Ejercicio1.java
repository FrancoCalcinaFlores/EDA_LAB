package Lab02;

public class Ejercicio1 {
    public static void main(String []args){

        int n[]={1,5,6,9,4,8};
        Mostrar(invertirArray(n));


    }
    public static int [] invertirArray (int[]array){
        int nuevaM[]=new int [array.length];
        int aux=0;
        for(int i=array.length-1;i>=0;i--){
            nuevaM[aux]=array[i];
            aux++;
        }
        return nuevaM;

    }
    public static void Mostrar(int []array){
        for (int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }
    
}
