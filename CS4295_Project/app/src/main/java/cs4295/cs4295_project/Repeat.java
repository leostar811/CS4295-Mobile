package cs4295.cs4295_project;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;


public class Repeat extends Dialog {
    private ArrayList<String> mList;
    private Context mContext;
    private Spinner mSpinner;




    public Repeat( ){
        super(null);
    }



    public Repeat(Context context,  DialogListener readyListener) {
        super(context);
        mReadyListener = readyListener;
        mContext = context;
        mList = new ArrayList<String>();
        mList.add("0");
        mList.add("1");
        mList.add("2");
        mList.add("3");
        mList.add("4");
        mList.add("5");
        mList.add("6");
        mList.add("7");
        mList.add("8");
        mList.add("9");
        mList.add("10");

    }




    public interface DialogListener {
        public void ready(int n);
        public void cancelled();
    }

    private DialogListener mReadyListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_dialog);

        mSpinner = (Spinner) findViewById (R.id.dialog_spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String> (mContext, android.R.layout.simple_spinner_dropdown_item, mList);
        mSpinner.setAdapter(adapter);

        Button buttonOK = (Button) findViewById(R.id.dialogOK);
        Button buttonCancel = (Button) findViewById(R.id.dialogCancel);
        buttonOK.setOnClickListener(new android.view.View.OnClickListener(){
            public void onClick(View v) {
                int n = mSpinner.getSelectedItemPosition();
                mReadyListener.ready(n);
                Repeat.this.dismiss();
            }
        });
        buttonCancel.setOnClickListener(new android.view.View.OnClickListener(){
            public void onClick(View v) {
                mReadyListener.cancelled();
                Repeat.this.dismiss();
            }
        });
    }
    }





