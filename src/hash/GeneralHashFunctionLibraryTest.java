
package hash;

import junit.framework.TestCase;
import static hash.GeneralHashFunctionLibrary.*;



public class GeneralHashFunctionLibraryTest extends TestCase
{
    private String key;

    protected void setUp()
    {
	key = "abcdefghijklmnopqrstuvwxyz123456789";
    }

    public void testRSHash()
    {
      System.out.println(RSHash(key));
    }

    public void testJSHash() 
    {
    	System.out.println(JSHash(key));
    }

    public void testPJWHash()
    {
    	System.out.println(PJWHash(key));
    }

    public void testELFHash()
    {
    	System.out.println(ELFHash(key));
    }

    public void testBKDRHash()
    {
    	System.out.println(BKDRHash(key));
    }

    public void testSDBMHash()
    {
    	System.out.println(SDBMHash(key));
    }

    public void testDJBHash()
    {
    	System.out.println(DJBHash(key));
    }

    public void testDEKHash()
    {
    	System.out.println(DEKHash(key));
    }

    public void testBPHash()
    {
    	System.out.println(BPHash(key));
    }

    public void testFNVHHash()
    {
    	System.out.println(FNVHash(key));
    }

    public void testAPHash()
    {
    	System.out.println(APHash(key));
    }
}
