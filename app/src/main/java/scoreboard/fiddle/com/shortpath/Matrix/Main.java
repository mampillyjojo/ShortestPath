package scoreboard.fiddle.com.shortpath.Matrix;

/**
 * Created by jojomampilly on 3/30/17.
 */
public class Main {

    public static final int MAX_LIMIT = 50;

    public  class Result{
        public int indexOfSmallesItem = -1;
        public boolean isSuccesFull;
        public int resultArray [];
        public int shortestPathValue;
        public boolean arrayInvalid;

    }

    public  Result main(String[]  args){

        Integer inputArray[][] = {{3,4,1,2,8,6},{6,1,8,2,7,4},{5,9,3,9,9,5},{8,4,1,3,2,6},{3,7,2,8,6,4}};
        return executeTest(inputArray);
    }

    public   Result executeTest(Object [][] inputArray){

        MatrixHelper matrixHelper = new MatrixHelper();
        Result result = new Result();

        int [][] integerArray = new int[0][0];

        // Convert Object array to int array
        try {
             integerArray = matrixHelper.convertToIntArray(inputArray);
        }catch (IllegalArgumentException e){
            result.arrayInvalid = true;
        }

        if(!result.arrayInvalid){
            matrixHelper.printArray(integerArray);

            // creates a new 2d array with all the costs
            int [][] resultArray = matrixHelper.getResultArray(integerArray);

            matrixHelper.printArray(resultArray);

            //finds the smallest value in the right most coulumn of result Matrix
            result.indexOfSmallesItem = matrixHelper.findTheSmallestPath(resultArray);
            result.shortestPathValue = resultArray[ result.indexOfSmallesItem][resultArray[0].length-1];

            if(result.shortestPathValue < MAX_LIMIT){
                result.isSuccesFull = true;
            }else{
                result.isSuccesFull = false;
            }

            System.out.println("SmallestIndex :: "+result.indexOfSmallesItem);

            result.resultArray = matrixHelper.findPath(resultArray,result.indexOfSmallesItem);

        }



        return result;
    }
}
