package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import ca.ualberta.cs.lonelytwitter.data.GsonDataManager;
import ca.ualberta.cs.lonelytwitter.data.IDataManager;

public class LonelyTwitterActivity extends Activity {

	private IDataManager dataManager;

	private EditText bodyText;

	private ListView oldTweetsList;

	private ArrayList<Tweet> tweets;

	private ArrayAdapter<Tweet> tweetsViewAdapter;
	
	private Summary mySummary;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main);

		dataManager = new GsonDataManager(this);

		bodyText = (EditText) findViewById(R.id.body);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);
		
		mySummary = new Summary();
	}

	@Override
	protected void onStart() {
		super.onStart();

		tweets = dataManager.loadTweets();
		tweetsViewAdapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweets);
		oldTweetsList.setAdapter(tweetsViewAdapter);
	}

	public void save(View v) {

		String text = bodyText.getText().toString();

		Tweet tweet = new Tweet(new Date(), text);
		tweets.add(tweet);

		tweetsViewAdapter.notifyDataSetChanged();

		bodyText.setText("");
		dataManager.saveTweets(tweets);
	}

	public void clear(View v) {

		tweets.clear();
		tweetsViewAdapter.notifyDataSetChanged();
		dataManager.saveTweets(tweets);
	}
	
	public void summary(View v) {
		createSummary();
		
		Intent intent = new Intent(this, SummaryActivity.class);
		intent.putExtra("key", mySummary);
		intent.putExtra("num", Integer.toString(mySummary.getNumberOfTweets()));
		intent.putExtra("num2", Double.toString(mySummary.getAvgLenOfTweets()));
		startActivity(intent);
	}
	
	private void createSummary() {
		mySummary.setAvgLatOfTweets(getAvgLatency());
		mySummary.setAvgLenOfTweets(getAvgLength());
		mySummary.setNumberOfTweets(getNumTweets());
	}
	
	private double getAvgLength() {
		double sum = 0;
		for (Tweet t : tweets) {
			sum += t.getTweetBody().toString().length();
		}
		
		return sum/tweets.size();
	}
	
	private int getNumTweets() {
		return tweets.size();
	}
	
	private long getAvgLatency(){
		return 0;
	}
	
	
	
	
}