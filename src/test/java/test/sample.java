package test;

import org.testng.annotations.Test;

public class sample 
{
	@Test(priority=1)
	public void sampleO()
	{
		System.err.println("Test Method");
	}
	
	@Test(priority=2)
	public void sampleT()
	{
		System.err.println("Test Method");
	}
	
	@Test(priority=0)
	public void sampleP()
	{
		System.err.println("Test Method");
	}
	
	@Test(priority=-1)
	public void sampleR()
	{
		System.err.println("Test Method3");
	}
}
