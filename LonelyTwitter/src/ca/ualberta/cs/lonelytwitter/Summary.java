package ca.ualberta.cs.lonelytwitter;

import java.io.Serializable;


public class Summary implements Serializable
{
	private int numberOfTweets;
	private long avgLatOfTweets;
	private double avgLenOfTweets;
		
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

	
	public double getAvgLatOfTweets()
	{
	
		return avgLatOfTweets;
	}

	
	public void setAvgLatOfTweets(long avgLatOfTweets)
	{
	
		this.avgLatOfTweets = avgLatOfTweets;
	}

	
	public double getAvgLenOfTweets()
	{
	
		return avgLenOfTweets;
	}

	
	public void setAvgLenOfTweets(double avgLenOfTweets)
	{
	
		this.avgLenOfTweets = avgLenOfTweets;
	}
	
	
	
}
