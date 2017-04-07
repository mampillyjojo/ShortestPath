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
        }catch (Exception e){
            result.arrayInvalid = true;
        }

        if(!result.arrayInvalid){
            matrixHelper.printArray(integerArray);

            // creates a new 2d array with all the costs
            MatrixHelper.ResultNode[][] resultArray = matrixHelper.getResultArray(integerArray);

            matrixHelper.printResultNode(resultArray);


            result.isSuccesFull = !matrixHelper.isLimitReached;

            if(matrixHelper.valueOfLastNode >= 0 ){
                result.indexOfSmallesItem = matrixHelper.findTheSmallestPath(resultArray);
                result.shortestPathValue = resultArray[ result.indexOfSmallesItem][matrixHelper.getEndOfResultArray(resultArray)].value;

                System.out.println("SmallestIndex :: "+result.indexOfSmallesItem);

                result.resultArray = matrixHelper.findPath(resultArray,result.indexOfSmallesItem);
            }else{
                // negative case, cant reach the first column
                result.indexOfSmallesItem = -1;
                result.shortestPathValue =-1;

               // System.out.println("SmallestIndex :: "+result.indexOfSmallesItem);

                result.resultArray = new int[]{};
            }


//            if(result.shortestPathValue < MAX_LIMIT){
//                result.isSuccesFull = true;
//            }else{
//                result.isSuccesFull = false;
//            }




        }



        return result;
    }
}
