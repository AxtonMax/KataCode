
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;


public class SolutionTest {
    
    @Test
    public void fixedTests() {
        assertEquals(1 , parseInt("one"));
        assertEquals(21 , parseInt("twenty-one"));
        assertEquals(246 , parseInt("two hundred forty-six"));
        assertEquals(94333 , parseInt("ninety-four thousand three hundred thirty-three"));
        //assertEquals(498269 , parseInt("four hundred and ninety-eight thousand two hundred and sixty-nine"));
    }
    
    public static int parseInt(String numStr) {
    	 int total = 0;
         int holder = 0;
         String[] spliter = new String[2];
       System.out.println("Starter "+numStr);
         //String[] number = numStr.toLowerCase().split("[ -]");
         String[] number = numStr.toLowerCase().split("[ ]");
         
     	//System.out.println("Starter "+numStr);
         for (int i = 0; i < number.length; i++) {
 		//System.out.println(total);
        	 if (number[i].contains("-")) {
        		 spliter = number[i].split("-");
        		 //total += Integer.valueOf(String.valueOf(singles(spliter[0]))+String.valueOf(singles(spliter[1])));
        		 System.out.println("HERE "+(singles(spliter[0].substring(0, (spliter[0].length()-2))) * 10)+singles(spliter[1]));
        		 holder= (singles(spliter[0].substring(0, (spliter[0].length()-2))) * 10)+singles(spliter[1]);
        		 total += holder;
        	 }
        	 else if (!number[i].contains("hundred") && !number[i].contains("thousand") && !number[i].contains("million") && !number[i].contains("and")) {
         	holder = singles(number[i]);
         	total += holder;
        	 }
        	 
        	 
         	if(number[i].contains("hundred") || number[i].contains("thousand") || number[i].contains("million")){
         		total -= holder;
         		total += alter(number[i], number[i-1], holder);
         	}
     	
     		if(number[i].contains("ty")){
     			total += singles(number[i].substring(0, (number[i].length()-2))) * 10;
     		}
     		
     		if(number[i].contains("teen")) {
     			total += singles(number[i].substring(0, (number[i].length()-4))) + 10;
     		}
     	
     	
         } 
         System.out.println(total);
         return total;
     }

 	private static int singles(String substring) {
 		int singNum =0;
 		switch (substring) {
 		case "one":
 			singNum = 1;
 			break;
 		case "two":
 			singNum = 2;
 			break;
 		case "twen":
 			singNum = 2;
 			break;
 		case "three":
 			singNum = 3;
 			break;
 		case "thir":
 			singNum = 3;
 			break;
 		case "four":
 			singNum = 4;
 			break;
 		case "for":
 			singNum = 4;
 			break;
 		case "five":
 			singNum = 5;
 			break;
 		case "fif":
 			singNum = 5;
 			break;
 		case "six":
 			singNum = 6;
 			
 			break;
 		case "seven":
 			singNum = 7;
 			
 			break;
 		case "eight":
 			singNum = 8;
 			break;
     case "eigh":
 			singNum = 8;
 			break;
 		case "nine":
 			singNum = 9;
 			
 			break;
 		case "ten":
 			singNum = 10;
 			break;
 		case "eleven":
 			singNum = 11;
 			break;
 		case "twelve":
 			singNum = 12;
 			break;
 		}
 		return singNum;
 	}

 	private static int alter(String string, String String2, int holder2) {
 		int previous = 0;
 		int addup = 0;
 		switch (string) {
 		case "hundred":
 			//System.out.println("why "+holder2);
 			//total -= singles(String2);
 			System.out.println("This is previous "+holder2);
 			//total += Integer.valueOf(String.valueOf(previous)+"00");
 			//total += singles(String2)*100;
 			addup = holder2 * 100;
 			System.out.println("and this is after "+(addup));
 			break;
 		case "thousand":
 			//total +=1000;
 			//total -= singles(String2);
 			
 			//total += Integer.valueOf(String.valueOf(previous)+"000");
 			//total += singles(String2)*1000;
 			
 			addup = holder2 * 1000;
 			break;
 		case "million":
 			//total +=1000000;
 			//total -= singles(String2);
 			//total += Integer.valueOf(String.valueOf(previous)+"000000");
 			//total += singles(String2)*1000000;
 			addup = holder2 * 1000000;
 			break;    			

 		}
 		
 		return addup;
 		
 	}
    
}