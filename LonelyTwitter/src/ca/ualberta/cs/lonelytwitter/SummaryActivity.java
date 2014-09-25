package ca.ualberta.cs.lonelytwitter;

import java.io.Serializable;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class SummaryActivity extends Activity
{
	private TextView a, b ,c;
	Summary summ;
	

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_summary);
		
		a = (TextView) findViewById(R.id.numTweets);
		b = (TextView) findViewById(R.id.avglength);
		c = (TextView) findViewById(R.id.avgLatency);
		//summ = (Summary)getIntent().getSerializableExtra("key");
		
		a.setText(getIntent().getCharSequenceExtra("num"));
		b.setText(getIntent().getCharSequenceExtra("num2"));
		
		//b.setText(Long.toString(summ.getAvgLenOfTweets()));
		//c.setText(Long.toString(summ.getAvgLatOfTweets()));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.summary, menu);
		return true;
	}

}
