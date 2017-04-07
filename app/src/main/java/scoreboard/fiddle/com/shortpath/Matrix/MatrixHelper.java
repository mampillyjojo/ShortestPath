package scoreboard.fiddle.com.shortpath.Matrix;

/**
 * Created by jojomampilly on 3/30/17.
 */
public class MatrixHelper {

    public class ResultNode{

        public int value;
      //  public boolean didReachLimit;

    }

    int valueOfLastNode = 0;
    boolean isLimitReached = false;

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

    public void printResultNode( ResultNode[][] array){
            System.out.println("------ result Array -------");
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    System.out.print(array[i][j].value+"  ");
                }
                System.out.println("");
            }


    }

    public int[][] convertToIntArray(Object [][] array) {

        int [][] integerArray = new int[array.length][array[0].length];

        for(int i = 0;i< array.length;i++){
            for(int j=0;j< array[i].length;j++){
                if(array[i][j] instanceof Integer){
                    integerArray[i][j] = (Integer) array[i][j];
                }else  if(array[i][j] instanceof String){

                    integerArray[i][j] = Integer.parseInt((String) array[i][j]);
                }else{
                    System.out.println("Fail i:"+i+" j: "+j+array[i][j]);
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
    public ResultNode[][] getResultArray(int [][] array){
        System.out.println("------  New Array -------");


        ResultNode[][] newArray = new ResultNode[array.length][array[0].length];

        for (int i=0;i<array.length;i++){
            for (int j = 0; j <array[0].length ; j++) {
                ResultNode node = new ResultNode();
                node.value = array[i][j];


//                if(array[i][j] > Main.MAX_LIMIT){
//                    node.didReachLimit = true;
//                }
                newArray[i][j] = node;
            }
        }

        for (int j = 0; j <array[0].length ; j++) {
            boolean isBloacked = true;
            for (int i = 0; i < array.length; i++) {

 //               int min = 0;
//
//                if(getNode(newArray,i-1,j-1).value <= Main.MAX_LIMIT && getNode(newArray,i-1,j-1).value <= Main.MAX_LIMIT){
//
//                    min  = Math.min(getValue(newArray,i-1,j-1),getValue(newArray,i,j-1));
//                }else if((getNode(newArray,i-1,j-1).value <= Main.MAX_LIMIT)){
//                    min = getValue(newArray,i,j-1);
//                }else if((getNode(newArray,i,j-1).value <= Main.MAX_LIMIT)){
//                    min = getValue(newArray,i-1,j-1);
//                }
//
//                if((getNode(newArray,i+1,j-1).value <= Main.MAX_LIMIT)){
//                    min = Math.min(min, getValue(newArray, i + 1, j - 1));
//                }
//
                if(j == 0){
                    if(array[i][j] < Main.MAX_LIMIT){
                        isBloacked = false;
                    }
                }else{
                    int min  = Math.min(getValue(newArray,i-1,j-1),getValue(newArray,i,j-1));
                    min = Math.min(min, getValue(newArray, i + 1, j - 1));

                    int value = min+array[i][j];
                    if(value < Main.MAX_LIMIT) {
                        newArray[i][j].value = min + array[i][j];
                        isBloacked = false;
                    }
//                    }else{
//                        newArray[i][j].didReachLimit = true;
//
//                    }
                }






            }

            if(isBloacked){
                valueOfLastNode = j-1;
                isLimitReached = true;
                break;
            }
            System.out.println("");

            //printArray(newArray);
        }

        printResultNode(newArray);
        return  newArray;
    }

    public ResultNode getNode(ResultNode [][] a,int i, int j){
        i = correctValue(a, i);
        return  a[i][j];
    }
    public int getValue(ResultNode [][] a,int i, int j){

        i = correctValue(a, i);
        int value = a[i][j].value;
        return value;
    }

    /**
     * Find the smallest element in the Right Column
     * @param array
     * @return
     */
    public int findTheSmallestPath(ResultNode [][] array){

       // int lastColumn = array[0].length-1;
       // int lastColumn = (valueOfLastNode > 0)? valueOfLastNode:array[0].length-1;
      //  int lastColumn = valueOfLastNode;

        int lastColumn = getEndOfResultArray(array);
        int min = array[0][lastColumn].value;
        int smallestIndex = 0;


        for (int i=0;i< array.length;i++){
            if(min > array[i][lastColumn].value){
                min = array[i][lastColumn].value;
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
    public int[] findPath(ResultNode [][] array,int smallestIndex){
      //  int [] resultArray = new int[array[0].length];

        int min = 0;
        int i = smallestIndex;
       // int l = array[0].length-1;
        //int l = (valueOfLastNode > 0)? valueOfLastNode:array[0].length-1;
        int l = getEndOfResultArray(array);
        int [] resultArray = new int[l+1];

        resultArray[l] = smallestIndex+1;


        for (int j = l+1; j > 0; j--){

            boolean secondNumberIsSmaller = false;
            boolean firstNumberIsSmaller = false;

            if(getValue(array,i,j-1) <= getValue(array,i+1,j-1)){
                min = getValue(array,i,j-1);
                firstNumberIsSmaller = true;

            }else if ( getValue(array,i+1,j-1) <= getValue(array,i,j-1)){
                min = getValue(array,i+1,j-1);
                secondNumberIsSmaller = true;
            }

            if(getValue(array,i-1,j-1) < min){
                min = getValue(array,i-1,j-1);
                i= correctValue(array,i-1);
                resultArray[l] = i+1;
            }else if(secondNumberIsSmaller){
                i= correctValue(array,i+1);
                resultArray[l] = i+1;

            }else if(firstNumberIsSmaller){
                i= correctValue(array,i);
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
    public int  correctValue(ResultNode [][] a,int  i){
        if(i == -1){
            i=a.length-1;
        }else

        if(i < 0 ){
            i = a.length-1 + i;
        }else if(i >= a.length){
            i = i - a.length;
        }

        return  i;
    }

    public int getEndOfResultArray(ResultNode [][] array){
       return (isLimitReached)? valueOfLastNode:array[0].length-1;
    }
}
