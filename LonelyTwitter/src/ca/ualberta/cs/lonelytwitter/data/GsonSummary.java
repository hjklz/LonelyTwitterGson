package ca.ualberta.cs.lonelytwitter.data;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ca.ualberta.cs.lonelytwitter.Summary;
import ca.ualberta.cs.lonelytwitter.Tweet;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import android.content.Context;
import android.util.Log;


public class GsonSummary implements SaveSumm
{
	private static final String FILENAME = "gsonSum.sav";

	private Gson gson;
	private Context ctx;

	public GsonSummary(Context ctx) {
		this.ctx = ctx;
		gson = new Gson();
	}
	
	public Summary loadSummary() {
		Summary summ = new Summary();

		try {
			BufferedReader input = new BufferedReader(new InputStreamReader(ctx.openFileInput(FILENAME)));
			String line;
			StringBuffer fileContent = new StringBuffer();

			while ((line = input.readLine()) != null) {
				fileContent.append(line);
			}

			Type collectionType = new TypeToken<Serializable>() {}.getType();
			summ = gson.fromJson(fileContent.toString(), collectionType);

		} catch (Exception e) {
			Log.i("LonelyTwitter", "Error getting summary");
			e.printStackTrace();
		}

		return summ;
	}

	public void saveSummary(Summary summ) {
		try {
			FileOutputStream fos = ctx.openFileOutput(FILENAME, Context.MODE_PRIVATE);

			String jsonTweetList = gson.toJson(summ);
			fos.write(jsonTweetList.getBytes());
			fos.close();
			
			Log.i("Persistence", "Saved: " + jsonTweetList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Tweet> loadTweets()
	{

		// TODO Auto-generated method stub
		return null;
	}

	public void saveTweets(List<Tweet> lts)
	{

		// TODO Auto-generated method stub
		
	}

}
