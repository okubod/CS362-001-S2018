
package finalprojectB;
import junit.framework.TestCase;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!

class Pairs{
	public String x;
	public boolean y;
	public Pairs(String name, boolean type){
		x = name;
		y = type;
	}
}


public class UrlValidatorTest extends TestCase {


   public UrlValidatorTest(String testName) {
      super(testName);
   }

   
   
    public void testManualTest()
   {
//You can use this function to implement your manual testing	 
	   //String[] schemes = {"http", "https", "ftp"};
	   UrlValidator urlVal = new UrlValidator();
	  // assertEquals("Test 8.8.8.8", true, urlVal.isValid("8.8.8.8"));
	   assertEquals("Test oregonstate.edu", false, urlVal.isValid("oregonstate.edu"));
	   assertEquals("Test ://1.2.3.4.5/..?action=view", false, urlVal.isValid("://1.2.3.4.5/..?action=view"));
	   assertEquals("Test a", false, urlVal.isValid("a"));
	   assertEquals("Test https://google", false, urlVal.isValid("https://google"));
	   assertEquals("Test \"\"", false, urlVal.isValid(""));
	   assertEquals("Test Null", false, urlVal.isValid(null));
	   assertEquals("Test www.google.com", true, urlVal.isValid("https://www.google.com"));
	   assertEquals("Test ftp://foo.bar.com", true, urlVal.isValid("ftp://foo.bar.com"));
	   
   } 
    
   
     public void testYourFirstPartition()
   {
	 //You can use this function to implement your First Partition testing	 
	 String base = "https://www.google";
	 UrlValidator urlVal = new UrlValidator();
	 assertEquals("Test .meow", false, urlVal.isValid(base+".meow"));
	 assertEquals("Test long extension", false, urlVal.isValid(base+".123456789123456789123456789123456789123456789123456789123456789123456789"));
	 assertEquals("Test //................//", false, urlVal.isValid(base+"//................//"));
	 assertEquals("Test //..", false, urlVal.isValid(base+"//.."));
	 assertEquals("Test ,", false, urlVal.isValid(base+","));
	 assertEquals("Test //:sptth", false, urlVal.isValid(base+"//:sptth"));
	 assertEquals("Test .com\\cutecat.jpg", false, urlVal.isValid(base+".com\\cutecat.jpg"));
	 assertEquals("Test .com/cutecat.jpg", true, urlVal.isValid(base+".com/cutecat.jpg"));
	 assertEquals("Test .com", true, urlVal.isValid(base+".com"));
	 assertEquals("Test .edu", true, urlVal.isValid(base+".edu"));
	 assertEquals("Test .gov", true, urlVal.isValid(base+".gov"));

   }
   
   public void testYourSecondPartition(){
		 //You can use this function to implement your Second Partition testing
		 String base = ".com";
		 UrlValidator urlVal = new UrlValidator();
		 assertEquals("Test 1.2.3.4.", false, urlVal.isValid("1.2.3.4."+base));
		 assertEquals("Test yahoo", false, urlVal.isValid("yahoo"+base));
		 assertEquals("Test .com", false, urlVal.isValid(".com"+base));
		 assertEquals("Test www.8.8.8.8", false, urlVal.isValid("wwww.8.8.8.8"+base));
		 assertEquals("Test http://", false, urlVal.isValid("http://"+base));
		 assertEquals("Test cutecat.jpg", false, urlVal.isValid("cutecat.jpg"+base));
		 assertEquals("Test /cutecat.jpg", false, urlVal.isValid("/cutecat.jpg"+base));
		 assertEquals("Test http://wwww", true, urlVal.isValid("http://wwww"+base));
		 assertEquals("Test https://www.google", true, urlVal.isValid("https://www.google"+base));
		 assertEquals("Test ftp://foo.bar", true, urlVal.isValid("ftp://foo.bar"+base));
		 

   }
   //You need to create more test cases for your Partitions if you need to 




   
   public void testIsValid()
   {
	   //You can use this function for programming based testing
		UrlValidator urlVal = new UrlValidator();
	   
	   
	   Pairs[] schemes = {new Pairs("https://", true),new Pairs("http://", true), new Pairs("ftp://", true), new Pairs("http:/", false), new Pairs("sptth://", false), new Pairs("://", false), new Pairs("", false)};
	   Pairs[] bases = {new Pairs("www.google.com", true),new Pairs("www.oregonstate.com", true), new Pairs("www.yahoo.com", true),new Pairs("WWW.GOOGLE.COM", true),new Pairs("WWW.OREGONSTATE.EDU", true), new Pairs("WWW.YAHOO.COM", true), new Pairs("www.lala.lalala.com", true), new Pairs("/cutecats/cutecats", false), new Pairs("0.0.0.0", true), new Pairs("", false) , new Pairs("321.321.2321.312", false) , new Pairs("nyan.cat", true) , new Pairs(".oranges", false) ,new Pairs("www.not~valid.com",false), new Pairs("....moc.elgoog.www..", false), new Pairs("N", false), new Pairs("sand.everywhere.org", true),new Pairs("www.123456789123456789123456789123456789123456789123456789123456789123456789asdnenlkjbkljasdljkebajhbgdakjbhfujkalksjdflbbtuiyoiuqyewqrbflkjabsdlkjfhueayweufoasuibdfblkjahsdlbfuieoaiuebasdflbhui7829736478ebaeltikjubaiosiubdfuioeausbf89123456789123456789123456789123456789asdnenlkjbkljasdljkebajhbgdakjbhfujkalksjdflbbtuiyoiuqyewqrbflkjabsdlkjfhueayweufoasuibdfblkjahsdlbfu928716234798447356179832874698327465lkajbsdlfhkjebaeltikjubaiosiubdfuioeausbf89123456789123456789123456789123456789asdnenlkjbkljasdljkebajhbgdakjbhfujkalksjdflbbtuiyoiuqyewqrbflkjabsdlkjfhu123456789123456789123456789123456789123456789asdnenlkjbkljasdljkebajhbgdakjbhfujkalksjdflbbtuiyoiuqyewqrbflkjabsdlkjfhueayweufoasuibdfblkjahsdlbfuieoaiuebasdflbhui7829736478ebaeltikjubaiosiubdfuioeausbf89123456789123456789123456789123456789asdnenlkjbkljasdljkebajhbgdakjbhfujkalksjdflbbtuiyoiuqyewqrbflkjabsdlkjfhueayweufoasuibdfblkjahseayweufoasuibdfblkjahsdlbfuieoaiuebasdflbhui7829736478928716234798447356179832874698327465lkajbsdlfhk.com", false), new Pairs("ns2.dns.nic.xn--rovu88b",true)};
	  // Pairs[] extensions = {new Pairs("", true)};
	   Pairs[] paths = {new Pairs("/cutecats/", true),new Pairs("/test/", true), new Pairs("/cuteKittens/", true), new Pairs("", true) , new Pairs("//..", false) , new Pairs("//test//test//fail", false), new Pairs("/short/medium/long/longer/longest", true)};
	  Pairs[] queries = {new Pairs("", true),new Pairs("?action=1", true), new Pairs("?action=1&background=4", true)};
	   
	   for(int j=0;j<7;j++){
		 for(int k=0;k<17;k++){
			for(int m=0;m<7;m++){
				for(int n=0;n<3;n++){
			//	 try{
					 if(schemes[j].y && bases[k].y && paths[m].y && queries[n].y){
						 assertEquals("Test " + schemes[j].x + bases[k].x + paths[m].x + queries[n].x, true, urlVal.isValid(schemes[j].x + bases[k].x + paths[m].x + queries[n].x));
					 }else{
						 assertEquals("Test " + schemes[j].x + bases[k].x +paths[m].x + queries[n].x, false, urlVal.isValid(schemes[j].x + bases[k].x + paths[m].x + queries[n].x));
						 
					 }
				// }
				// catch(exception e){
				//	 System.out.println("Test " + schemes[j].x + bases[k].x + extensions[i].x);
				// }
				}
			}
		 }
	  }
   

   } 
   
 

}
