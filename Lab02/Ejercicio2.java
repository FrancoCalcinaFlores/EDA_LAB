package Lab02;

public class Ejercicio2{
    public static void main(String [] args){
        int arr[]={1,2,3,4,5,6,7,8,9};
        int n[]= rotarIZquierda(4,arr);
        Mostrar(n);
    }
    public static int [] rotarIZquierda(int pos, int[]array){
        int nuevaM[]=new int [array.length];
        for (int i=0; i<array.length;i++){
            if(pos < array.length){
                nuevaM[i]=array[pos];
            }
            else if(pos == array.length){
                pos=0;
                nuevaM[i]=array[pos];
            }
            pos=pos +1;
        }
        return nuevaM;
    }
    public static void Mostrar(int []array){
        for (int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }
}