package com.joshzana.helloworld;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class DetailsActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);
        
        
        ((Button)findViewById(R.id.button1)).setOnClickListener(
        		new Button.OnClickListener() {
		        	public void onClick(View arg0)
		        	{
		        		Log.i("HELLOWORLD", "I got a click!");
		        		
		        		SampleTask task = new SampleTask();
		        		task.execute("Josh");
		        	}
		        }
        );
    }
    
    
    public class SampleTask extends AsyncTask<String, Void, String>
    {

		@Override
		protected String doInBackground(String... params) {
			try
			{
				Thread.sleep(1000);
			}
			catch(InterruptedException e) 
			{
			}
			
			return "Async Task Complete, " + params[0];
		}
		
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			((Button)findViewById(R.id.button1)).setText("Working...");
		}
		
		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			((Button)findViewById(R.id.button1)).setText(result);
			
		}
    }
}