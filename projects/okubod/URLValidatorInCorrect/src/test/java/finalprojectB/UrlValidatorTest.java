
package finalprojectB;

import junit.framework.TestCase;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!


public class Pairs{
			public string x;
			public bool y;
			public Pairs(int name, bool type){
				x = name;
				type = y;
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
	   //assertEquals("Test 8.8.8.8", true, urlVal.isValid("8.8.8.8"));
	   assertEquals("Test https://www.google.com", true, urlVal.isValid("https://www.google.com"));
	   assertEquals("Test oregonstate.edu", true, urlVal.isValid("oregonstate.edu"));
	   assertEquals("Test ftp://foo.bar.com", true, urlVal.isValid("ftp://foo.bar.com"));
	   assertEquals("Test ://1.2.3.4.5/..?action=view", false, urlVal.isValid("://1.2.3.4.5/..?action=view"));
	   assertEquals("Test a", false, urlVal.isValid("a"));
	   assertEquals("Test https://google", false, urlVal.isValid("https://google"));
	   assertEquals("Test \"\"", false, urlVal.isValid(""));
   }
   
   
/*   public void testYourFirstPartition()
   {
	 //You can use this function to implement your First Partition testing	 
	 String base = "https://www.google";
	 UrlValidator urlVal = new UrlValidator();
	 assertEquals("Test .com", true, urlVal.isValid(base+".com"));
	 assertEquals("Test .edu", true, urlVal.isValid(base+".edu"));
	 assertEquals("Test .gov", true, urlVal.isValid(base+".gov"));
	 assertEquals("Test .meow", true, urlVal.isValid(base+".meow"));
	 assertEquals("Test .com/cutecat.jpg", true, urlVal.isValid(base+".com/cutecat.jpg"));
	 assertEquals("Test long extension", false, urlVal.isValid(base+".123456789123456789123456789123456789123456789123456789123456789123456789"));
	 assertEquals("Test .", false, urlVal.isValid(base+"."));
	 assertEquals("Test ..", false, urlVal.isValid(base+".."));
	 assertEquals("Test ,", false, urlVal.isValid(base+","));
	 assertEquals("Test //:sptth", false, urlVal.isValid(base+"//:sptth"));
	 assertEquals("Test .com\\cutecat.jpg", false, urlVal.isValid(base+".com\\cutecat.jpg"));
	 

   }
   
   public void testYourSecondPartition(){
		 //You can use this function to implement your Second Partition testing
		 String base = ".com";
		 UrlValidator urlVal = new UrlValidator();
		 assertEquals("Test https://www.google", true, urlVal.isValid("https://www.google"+base));
		 assertEquals("Test www.google", true, urlVal.isValid("www.google"+base));
		 assertEquals("Test 1.2.3.4.", false, urlVal.isValid("1.2.3.4."+base));
		 assertEquals("Test yahoo", true, urlVal.isValid("yahoo"+base));
		 assertEquals("Test .com", false, urlVal.isValid(".com"+base));
		 assertEquals("Test www.8.8.8.8", false, urlVal.isValid("wwww.8.8.8.8"+base));
		 assertEquals("Test http://", false, urlVal.isValid("http://"+base));
		 assertEquals("Test ftp://foo.bar", true, urlVal.isValid("ftp://foo.bar"+base));
		 assertEquals("Test cutecat.jpg", true, urlVal.isValid("cutecat.jpg"+base));
		 assertEquals("Test /cutecat.jpg", false, urlVal.isValid("/cutecat.jpg"+base));
		 assertEquals("Test http://wwww", false, urlVal.isValid("http://wwww"+base));
		 

   }
   //You need to create more test cases for your Partitions if you need to 
 */  
   public void testIsValid()
   {
	   //You can use this function for programming based testing
	   //String[] Ext = {".edu", ".com", ".gov", ".meow", "....", "",".123456789123456789123456789123456789123456789123456789123456789123456789"};
	   //String[] Scheme = {"https://", "http://", "ftp://", "http:/", "sptth://", "://", ""};
	   //String[] Bases = {"www.google", "www.oregonstate", "www.yahoo", "lala.lalala", "/cutecats/cutecats", "0.0.0.0", ""};
	   
	   UrlValidator urlVal = new UrlValidator();
	   	   
/*for(int i=0;i<7;i++){
		   for(int j=0;j<7;j++){
			 for(int k=0;k<7;k++){
				 if(urlVal.isValid(Scheme[i]+Bases[j]+Ext[k])){
					 System.out.println(Scheme[i]+Bases[j]+Ext[k] + " is valid.");
				 }else{
					 System.out.println(Scheme[i]+Bases[j]+Ext[k] + " is  not valid.");
				 }
				 
			 }
		   }
	   }*/
	   
	   /*public class Pairs{
			public string x;
			public bool y;
	   }*/
	   
	   Pairs[] extensions = {new Pair(".edu", true),new Pair( ".com", true), new Pair(".gov",true), new Pair(".meow",false),new Pair("....",false), new Pair(".123456789123456789123456789123456789123456789123456789123456789123456789", false), new Pair("", false)};
	   Pairs[] schemes = {new Pair("https://", true),new Pair("http://", true), new Pair("ftp://", true), new Pair("http:/", false), new Pair("sptth://", false), new Pair("://", false), new Pair("", false)};
	   Pairs[] bases = {new Pair("www.google", true),new Pair("www.oregonstate", true), new Pair("www.yahoo", true), new Pair("lala.lalala", false), new Pair("/cutecats/cutecats", false), new Pair("0.0.0.0", false), new Pair("", false)};
	   //Pairs[] paths = {new Pair("https://", true),new Pair("http://", true), new Pair("ftp://", true), new Pair("http:/", false), new Pair("sptth://", false), new Pair("://", false), new Pair("", false)};
	   //Pairs[] queries = {new Pair("https://", true),new Pair("http://", true), new Pair("ftp://", true), new Pair("http:/", false), new Pair("sptth://", false), new Pair("://", false), new Pair("", false)};
	   for(int i=0;i<7;i++){
		   for(int j=0;j<7;j++){
			 for(int k=0;k<7;k++){
				 if(extensions[i].y && schemes[j].y && bases[k].y){
					 assertEquals("Test " + schemes[j].x + bases[k].x + extensions[i].x, true, urlVal.isValid(schemes[j].x + bases[k].x + extensions[i].x));
				 }else{
					 assertEquals("Test " + schemes[j].x + bases[k].x + extensions[i].x, false, urlVal.isValid(schemes[j].x + bases[k].x + extensions[i].x));
					 
				 }
				 
			 }
		   }
	   }


	   

   }
   


}
