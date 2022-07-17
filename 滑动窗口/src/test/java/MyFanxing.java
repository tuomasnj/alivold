
public class MyFanxing {
    public static void main(String[] args) {
        Integer[] intArray={5,5,6,8,9,10,56};
        Character[] chArray={'l','d','f','g'};
        printArr(intArray);
        printArr(chArray);
        int a=0;
        switch (a){
            case 0:
                System.out.println(0);
                break;
            case 1:
                System.out.println(1);
        }
    }
    public static<T> void printArr(T[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}

