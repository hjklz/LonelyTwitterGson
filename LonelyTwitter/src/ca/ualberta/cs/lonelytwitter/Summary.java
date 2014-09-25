package ca.ualberta.cs.lonelytwitter;

import java.io.Serializable;


public class Summary implements Serializable
{
	private int numberOfTweets;
	private long avgLatOfTweets;
	private long avgLenOfTweets;
		
	public Summary(){
		
	}

	
	public int getNumberOfTweets()
	{
	
		return numberOfTweets;
	}

	
	public void setNumberOfTweets(int numberOfTweets)
	{
	
		this.numberOfTweets = numberOfTweets;
	}

	
	public long getAvgLatOfTweets()
	{
	
		return avgLatOfTweets;
	}

	
	public void setAvgLatOfTweets(long avgLatOfTweets)
	{
	
		this.avgLatOfTweets = avgLatOfTweets;
	}

	
	public long getAvgLenOfTweets()
	{
	
		return avgLenOfTweets;
	}

	
	public void setAvgLenOfTweets(long avgLenOfTweets)
	{
	
		this.avgLenOfTweets = avgLenOfTweets;
	}
	
	
	
}
