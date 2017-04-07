package scoreboard.fiddle.com.shortpath.Matrix;

import android.content.Context;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

/**
 * Created by jojomampilly on 4/6/17.
 */

public class GridAdapter extends BaseAdapter {

    private Context mContext;
    private int array[][];


    public void setArray(int[][] array) {
        this.array = array;
    }

    public GridAdapter(Context context){
        this.mContext = context;
    }

    @Override
    public int getCount() {

        return (array.length)*(array[0].length);
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        EditText textView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            textView = new EditText(mContext);
            textView.setLayoutParams(new GridView.LayoutParams(85, 85));
            textView.setPadding(8, 8, 8, 8);
        } else {
            textView = (EditText) convertView;
        }

        textView.setText(getValueFromMatrix(position)+"");
        textView.setInputType(InputType.TYPE_NUMBER_FLAG_SIGNED);

        return textView;
    }

    public int getValueFromMatrix(int position){
        int i = position/ (array[0].length);
        int j= position% (array[0].length);

        System.out.println("row::"+i+" column::"+j);

        return array[i][j];
    }


}
