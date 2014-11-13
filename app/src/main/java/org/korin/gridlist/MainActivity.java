package org.korin.gridlist;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Resources res;
        res = getResources();

        //get reference to ListView object
        ListView list = (ListView)findViewById(R.id.listview);

        //this is a sample data. This could be in whatever form.
        String[] states = res.getStringArray(R.array.states_array);

        //I just prefer to work with ArrayList objects. Any Array type is fine.
        ArrayList statesList = new ArrayList<String>(Arrays.asList(states));


        //Optimized adapter. See definition of the OptimizedCustomAdapter class, which exends a BaseAdapter
        //pass in a context reference. You get a reference o the context in an Activity class by simply using "this".
        OptimizedCustomAdapter adapter = new OptimizedCustomAdapter(this,statesList);

        //set the adapter to the ListView object.
        list.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
