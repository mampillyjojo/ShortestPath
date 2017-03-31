package scoreboard.fiddle.com.shortpath;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import scoreboard.fiddle.com.shortpath.Matrix.Main;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadMatrix();
    }

    public void loadMatrix(){
        Main main = new Main();
        Main.Result result = main.main(null);
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
        for (int value: result.resultArray) {
            sb.append(value);
            sb.append(" ");
        }
        resultArray.setText("ResultArray  :"+sb.toString());


    }
}
