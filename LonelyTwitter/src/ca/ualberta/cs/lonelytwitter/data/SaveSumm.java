package ca.ualberta.cs.lonelytwitter.data;

import java.util.List;

import ca.ualberta.cs.lonelytwitter.Summary;
import ca.ualberta.cs.lonelytwitter.Tweet;


public interface SaveSumm extends IDataManager
{
	public Summary loadSummary();	
	public void saveSummary(Summary summ);
}
