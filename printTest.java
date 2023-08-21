public class printTest {
    int rows = 5;
    int columns = 3;

    public static void print(){
    int[][] array = new int[5][3];

    for (int i = 0; i<5; i++)
        for (int j = 0; j<3; j++)
            array[i][j] = 69;

    for (int i = 0; i<5; i++) {
        for (int j = 0; j<3; j++) {
            System.out.print(array[i][j]);
        }
        System.out.println();
    }
    }

    public static void main(String[] args) {
        print();
        
       
        
    }
}
