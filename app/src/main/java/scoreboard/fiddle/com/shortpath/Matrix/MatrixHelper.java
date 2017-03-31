package scoreboard.fiddle.com.shortpath.Matrix;

/**
 * Created by jojomampilly on 3/30/17.
 */
public class MatrixHelper {

    public int [][] getInputArray(int m,int n){
        int [][] array = new int[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = count;
                count++;
            }
        }

        return  array;
    }

    public int [][] printArray(int[][] array){
        System.out.println("------ Array -------");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]+"  ");
            }
            System.out.println("");
        }

        return  array;
    }

    public int[][] convertToIntArray(Object [][] array) {

        int [][] integerArray = new int[array.length][array[0].length];

        for(int i = 0;i< array.length;i++){
            for(int j=0;j< array[i].length;j++){
                if(array[i][j] instanceof Integer){
                    integerArray[i][j] = (Integer) array[i][j];
                }else {
                    throw new IllegalArgumentException("Invalid Input");
                }
            }
        }

        return integerArray;
    }


    /**
     * Generate a result 2D array having minimum cost to traverse through an input Array
     * @param array
     * @return
     */
    public int[][] getResultArray(int [][] array){
        System.out.println("------  New Array -------");


        int [][] newArray = array.clone();

        for (int j = 1; j <array[0].length ; j++) {
            for (int i = 0; i < array.length; i++) {


                int min  = Math.min(getValue(newArray,i-1,j-1),getValue(newArray,i,j-1));
                min = Math.min(min, getValue(newArray, i + 1, j - 1));
                newArray[i][j] = min+ array[i][j];


            }
            System.out.println("");

            printArray(newArray);
        }
        return  newArray;
    }

    public int getValue(int [][] a,int i, int j){

        i = correctValue(a, i);
        return a[i][j];
    }

    /**
     * Find the smallest element in the Right Column
     * @param array
     * @return
     */
    public int findTheSmallestPath(int [][] array){

        int lastColumn = array[0].length-1;
        int min = array[0][lastColumn];
        int smallestIndex = 0;


        for (int i=0;i< array.length;i++){
            if(min > array[i][lastColumn]){
                min = array[i][lastColumn];
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

    /**
     * Find the shortest Path from right of array to left of Array
     * @param array
     * @param smallestIndex
     * @return
     */
    public int[] findPath(int [][] array,int smallestIndex){
        int [] resultArray = new int[array[0].length];

        int min = 0;
        int i = smallestIndex;
        int l = array[0].length-1;

        resultArray[l] = smallestIndex+1;


        for (int j = array[0].length; j > 0; j--){

            if(getValue(array,i,j-1) <= getValue(array,i+1,j-1)){
                min = getValue(array,i,j-1);
                resultArray[l] = i+1;
            }else if ( getValue(array,i+1,j-1) <= getValue(array,i-1,j-1)){
                min = getValue(array,i+1,j-1);
                i= correctValue(array,i+1);
                resultArray[l] = i+1;
            }

            if(getValue(array,i-1,j-1) < min){
                min = getValue(array,i-1,j-1);
                i= correctValue(array,i-1);
                resultArray[l] = i+1;
            }
            l--;


        }

        return resultArray;
    }

    /**
     * Correct the indrx to make the matrix Cylic
     * @param a
     * @param i
     * @return
     */
    public int  correctValue(int[][] a,int  i){
        if(i == -1){
            i=0;
        }else if(i < 0 ){
            i = a.length-1 + i;
        }else if(i >= a.length){
            i = i - a.length;
        }

        return  i;
    }
}
