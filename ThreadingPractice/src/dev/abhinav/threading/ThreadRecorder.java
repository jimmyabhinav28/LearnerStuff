package dev.abhinav.threading;

import java.util.HashMap;

public class ThreadRecorder {
	
	private static HashMap<String, Thread> threadRecord=new HashMap<String, Thread>();
	
	private static Object commonObject=new Object();
	
	public static Object getCommonObject()
	{
		return commonObject;
	}
	public static void addThreadToRecorder(String threadName,Thread t)
	{
		threadRecord.put(threadName, t);
	}
	
	public static void removeThreadFromRecorder(String threadName)
	{
		threadRecord.remove(threadName);
	}
	
	public static Thread getThreadByName(String threadName)
	{
		if(threadRecord.containsKey(threadName))
			return threadRecord.get(threadName);
		return null;
	}

}
