package pkgCore;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

import pkgHelper.Util;

public class DictionaryLab2Test {

	@Test
	public void TestMatch1()
	{
		Util.PrintStart(new Throwable().getStackTrace()[0].getMethodName());
        
		String str1 = "JAVA";
		String str2 = "JAVA";
		boolean isMatch;
		Dictionary d = new Dictionary();
		
		isMatch = this.match(d,str1,str2);
		
		assertTrue(isMatch);
		Util.PrintEnd(new Throwable().getStackTrace()[0].getMethodName());

	}

	@Test
	public void TestMatch2()
	{
		Util.PrintStart(new Throwable().getStackTrace()[0].getMethodName());

		String str1 = "JAVA";
		String str2 = "JAVX";
		boolean isMatch;
		Dictionary d = new Dictionary();
		
		isMatch = this.match(d,str1,str2);
		
		assertFalse(isMatch);

		Util.PrintEnd(new Throwable().getStackTrace()[0].getMethodName());
	}

	@Test
	public void TestMatch3()
	{
		Util.PrintStart(new Throwable().getStackTrace()[0].getMethodName());

		String str1 = "JAV?";
		String str2 = "JAVA";
		boolean isMatch;
		Dictionary d = new Dictionary();
		
		isMatch = this.match(d,str1,str2);
		
		assertTrue(isMatch);

		Util.PrintEnd(new Throwable().getStackTrace()[0].getMethodName());
	}
	
	@Test
	public void TestMatch4()
	{
		Util.PrintStart(new Throwable().getStackTrace()[0].getMethodName());

		String str1 = "JAV?";
		String str2 = "JAXA";
		boolean isMatch;
		Dictionary d = new Dictionary();
		
		isMatch = this.match(d,str1,str2);
		
		assertFalse(isMatch);

		Util.PrintEnd(new Throwable().getStackTrace()[0].getMethodName());
	}	
	
	@Test
	public void TestMatch5()
	{
		Util.PrintStart(new Throwable().getStackTrace()[0].getMethodName());

		String str1 = "JA*";
		String str2 = "JAXA";
		boolean isMatch;
		Dictionary d = new Dictionary();
		
		isMatch = this.match(d,str1,str2);
		
		assertTrue(isMatch);

		Util.PrintEnd(new Throwable().getStackTrace()[0].getMethodName());
	}	
	
	@Test
	public void TestMatch6()
	{
		Util.PrintStart(new Throwable().getStackTrace()[0].getMethodName());

		String str1 = "JA*";
		String str2 = "JXAA";
		boolean isMatch;
		Dictionary d = new Dictionary();
		
		isMatch = this.match(d,str1,str2);
		
		assertFalse(isMatch);

		Util.PrintEnd(new Throwable().getStackTrace()[0].getMethodName());
	}	
	
	@Test
	public void TestMatch7()
	{
		Util.PrintStart(new Throwable().getStackTrace()[0].getMethodName());

		String str1 = "????";
		String str2 = "JAVA";
		boolean isMatch;
		Dictionary d = new Dictionary();
		
		isMatch = this.match(d,str1,str2);
		
		assertTrue(isMatch);

		Util.PrintEnd(new Throwable().getStackTrace()[0].getMethodName());
	}	
	@Test
	public void TestMatch8()
	{
		Util.PrintStart(new Throwable().getStackTrace()[0].getMethodName());

		String str1 = "*";
		String str2 = "JAVA";
		boolean isMatch;
		Dictionary d = new Dictionary();
		
		isMatch = this.match(d,str1,str2);
		assertTrue(isMatch);
		
		assertTrue(this.match(d, str1, "FIRE"));
		assertTrue(this.match(d, str1, "TESTME"));

		Util.PrintEnd(new Throwable().getStackTrace()[0].getMethodName());
	}	
	@Test
	public void TestMatch9()
	{
		Util.PrintStart(new Throwable().getStackTrace()[0].getMethodName());

		String str1 = "????";
		String str2 = "BRANCH";
		boolean isMatch;
		Dictionary d = new Dictionary();
		
		isMatch = this.match(d,str1,str2);
		assertFalse(isMatch);
		

		Util.PrintEnd(new Throwable().getStackTrace()[0].getMethodName());
	}	
	
	@Test
	public void TestMatch10()
	{
		Util.PrintStart(new Throwable().getStackTrace()[0].getMethodName());

		String str1 = "J*VA";
		String str2 = "JAVA";
		boolean isMatch;
		Dictionary d = new Dictionary();
		
		isMatch = this.match(d,str1,str2);
		assertTrue(isMatch);
		

		Util.PrintEnd(new Throwable().getStackTrace()[0].getMethodName());
	}		
	/**
	 * @author BRG
	 * @version Lab #2
	 * @since Lab #2
	 * 
	 *        match - match - will invoke the 'match' method with java reflections
	 */
	private boolean match(Dictionary d, String str1, String str2) {
		boolean isMatch = false;
		
		try {

			// Consume the Deck class
			Class<?> c = Class.forName("pkgCore.Dictionary");
			// Find the match method			
			Method mMatch = c.getDeclaredMethod("match", String.class, String.class);
			// Set the method accessible
			mMatch.setAccessible(true);
			// Invoke the method, return the results
			isMatch = (boolean) mMatch.invoke(d, str1, str2);

		} catch (ClassNotFoundException x) {
			x.printStackTrace();
		} catch (IllegalAccessException x) {
			x.printStackTrace();
		} catch (NoSuchMethodException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		// Return the results
		return isMatch;
	}
}
