
package UrlShortern;

/**
 *
 * @author nikhil.agrawal
 */
public class TinyUrlShortern {
    
    public static final int base = 66;
    
     public static void main(String[] args) {
        int n = 200;
        String shortendUrl=idToShortUrl(n);
//        String shortendUrl2="geeksforgeeks";
        
        System.out.println("shortend url :: " + shortendUrl);
        System.out.println("Integer id from shortend url :: " + shortUrltoID(shortendUrl));
         
    }
     
     public static String idToShortUrl(int n)
     {
         // Converting base 10 to base 62 
         String s = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?#!.";
         char map[]= s.toCharArray();
         String shortUrl="";
//         System.out.println("Before processing :: " + n);
         
         while(n>=0)
         {
            
             if(shortUrl.isEmpty())
             {
                shortUrl +=  map[n%base]; 
             }
             else
             {
                 shortUrl= map[n%base] + shortUrl;
             }
//              System.out.println("n before = " + n + " shorturl = " + shortUrl);
             n=n/base;
//             System.out.println("n after = " + n+ " shorturl = " + shortUrl);
             if(n==0)
              break;
         }
         return shortUrl;
//         return new StringBuilder(shortUrl).reverse().toString();
     }
     
     public static int shortUrltoID(String shortUrl)
     {
         
         if(shortUrl==null || shortUrl.isEmpty()) 
             return -1;
         
         char[] shorturl = shortUrl.toCharArray();
         
         int id=0;
         
         for(char c : shorturl)
         {
             if(c>='a' && c<='z')
             {
                 id=(id*base) + c-'a';
             }
             else if(c>='A' && c<='Z')
             {
                 id=(id*base) + c-'A' +26;
             }
             else if(c>='0' && c<='9')
             {
                 id=(id*base) + c-'0' +52;
             }
             else if(c>'9')
             {
                 id=(id*base) + c-'?' +62;
             }
         }
         return id;
         
         
     }
     
     
     


}
