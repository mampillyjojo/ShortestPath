package scoreboard.fiddle.com.shortpath;

import android.content.Context;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import scoreboard.fiddle.com.shortpath.Matrix.GridAdapter;
import scoreboard.fiddle.com.shortpath.Matrix.Main;

public class MainActivity extends AppCompatActivity {

    private int defaultArray[][] = {{3,4,1,2,8,6},{6,1,8,2,7,4},{5,9,3,9,9,5},{8,4,1,3,2,6},{3,7,2,8,6,4}};
    private GridView gridView;
    int column = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //loadMatrix();

        initUI();
    }

    public void initUI(){

        Button calcuate = (Button) findViewById(R.id.calculate);
        calcuate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (view != null) {
                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        calculateMatrix(getArray());

                    }
                }, 100);
               // calculateMatrix(getArray());
            }
        });

        Button setGridButton = (Button) findViewById(R.id.setGridViewButton);
        setGridButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText rowsView = (EditText) findViewById(R.id.matrixRows);

                EditText columnView = (EditText) findViewById(R.id.matrixColumn);

                try{
                    int column = Integer.parseInt(columnView.getText().toString());
                    int row = Integer.parseInt(rowsView.getText().toString());

                    dispalyGrid(new int[row][column]);
                }catch(NumberFormatException e){
                    Toast.makeText(MainActivity.this, "Invalid input", Toast.LENGTH_SHORT).show();
                }



            }
        });
        dispalyGrid(defaultArray);
    }

    public void calculateMatrix(Object [][] array){
        Main main = new Main();
        Main.Result result = main.executeTest(array);
        setView(result);

    }
    public void setView(Main.Result result){
        TextView didReachRight = (TextView) findViewById(R.id.result1);
        TextView shortestPath = (TextView) findViewById(R.id.result2);
        TextView resultArray = (TextView) findViewById(R.id.result3);

        // TODO WIll move the String to string.xml
        didReachRight.setText("Did Reach right of Matrix: "+(result.isSuccesFull?"Yes":"No"));
        shortestPath.setText("ShortestPath :"+result.shortestPathValue);

        StringBuilder sb= new StringBuilder();
        if(null != result.resultArray){
            for (int value: result.resultArray) {
                sb.append(value);
                sb.append(" ");
            }
        }

        resultArray.setText("ResultArray  :"+sb.toString());


    }

    public void dispalyGrid( int[][] array){
        //

        Main main = new Main();
        Main.Result result = main.main(null);

        setView(result);

        gridView = (GridView) findViewById(R.id.gridview);
        System.out.println("Rows :: "+array.length);
        System.out.println("Column :: "+array[0].length);

        gridView.setNumColumns(array[0].length);
        GridAdapter adapter = new GridAdapter(this);
        adapter.setArray(array);

        gridView.setAdapter(adapter);


    }

    public Object[][] getArray(){

        System.out.println("Child Count :: "+ gridView.getChildCount());

        int column = gridView.getNumColumns();
        Object [][] array = new Object[(gridView.getCount()/column) ][column];
        for(int i=0; i<gridView.getChildCount(); i++) {
            TextView child = (TextView)gridView.getChildAt(i);
            // do stuff with child view
            System.out.println("i :: "+i+" value :: "+child.getText().toString());
            array[i/column][i%column] = child.getText().toString();
        }

        return array;
    }
}
