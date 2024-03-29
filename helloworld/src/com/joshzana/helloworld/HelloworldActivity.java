package com.joshzana.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class HelloworldActivity extends Activity {
	
	private ListView list;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Cursor cursor = getCursor();
        String[] fields = new String[] {
        		ContactsContract.Contacts._ID,
    			ContactsContract.Contacts.DISPLAY_NAME,
        };

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.listitem, cursor, fields, new int[] {R.id.textView1, R.id.textView2});

        this.list = (ListView)findViewById(R.id.list);
        
        this.list.setOnItemClickListener(new ListView.OnItemClickListener(){

			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				startActivity(new Intent(HelloworldActivity.this, DetailsActivity.class));				
			}
        });
        
       this.list.setAdapter(adapter);
    }
    
    
    private Cursor getCursor() {
    	String[] projection = new String[] {
    			ContactsContract.Contacts._ID,
    			ContactsContract.Contacts.DISPLAY_NAME,
    	};
    	
    	String sortOrder = ContactsContract.Contacts.DISPLAY_NAME + " COLLATE LOCALIZED ASC";
    	return managedQuery(ContactsContract.Contacts.CONTENT_URI, projection, null, null, sortOrder);
    }
}