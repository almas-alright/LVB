package com.alright.plastic.dailyex;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.widget.SimpleCursorAdapter;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
//import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.List;

public class StatusActivity extends AppCompatActivity {

    DataHandler db = new DataHandler(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);
        makeList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_status, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




    public void addClick(View v){

        EditText EtItemName = (EditText) findViewById(R.id.itemName);
        EditText EtItemVal = (EditText) findViewById(R.id.itemValue);
        String theName = EtItemName.getText().toString();
        String theValue = EtItemVal.getText().toString();


        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;

        if(this.chceckField(theName) || this.chceckField(theValue))
        {            //EditText is empty

            Toast empToast = Toast.makeText(context,"Fucking Empty Field",duration);
            empToast.show();
        }
        else
        {

            db.addItem(new Item(theName,theValue));

            // Reading all contacts
            Log.d("Reading: ", "Reading all contacts..");
            List<Item> contacts = db.getAllItems();

            for (Item itm : contacts) {
                String log = "Id: "+itm.get_id()+" ,Name: " + itm.get_item_name() + " ,Item: " + itm.get_item_val();
                // Writing Contacts to log
                Log.d("Name: ", log);
            }
            Toast fuckToast = Toast.makeText(context,"saved",duration);
            fuckToast.show();
            EtItemName.setText("");
            EtItemVal.setText("");
            this.makeList();
        }
    }

    public boolean chceckField(String value){
        if(value.isEmpty() || value.length() == 0 || value.equals("") || value == null)
        {           //EditText is empty
            return true;
        }
        else
        {
            return false;
        }
    }

    public void makeList()
    {
        Cursor cursor = db.getAllRows();
        String[] fromField = new String[]{"item_name", "item_name"};
        int[] toView = new int[]{R.id.tvName, R.id.tvVal};
        SimpleCursorAdapter sca = new SimpleCursorAdapter(this,R.layout.content_layout,cursor,fromField,toView,0);
        ListView lv = (ListView) findViewById(R.id.listView8);
        lv.setAdapter(sca);
    }
}
