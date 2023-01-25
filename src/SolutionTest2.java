import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;


public class SolutionTest2 {
    
    @Test
    public void fixedTests() {
    	assertEquals(12 , parseInt("twelve"));
    	assertEquals(100 , parseInt("one hundred"));
    	assertEquals(101 , parseInt("one hundred one"));
        assertEquals(16 , parseInt("sixteen"));
        assertEquals(20 , parseInt("twenty"));
        assertEquals(246 , parseInt("two hundred forty-six"));
        assertEquals(94333 , parseInt("ninety-four thousand three hundred thirty-three"));
        assertEquals(498269 , parseInt("four hundred ninety-eight thousand two hundred sixty-nine"));
        assertEquals(658633 , parseInt("six hundred and fifty-eight thousand six hundred and thirty-three"));
    }
    
    public static int parseInt(String numStr) {
    
    	StringBuilder Tally = new StringBuilder();
    	String[] TheNum = numStr.toLowerCase().replaceAll(" and", "").split("million | thousand | hundred");
    	//System.out.println(TheNum.length);
    	//String[] TheNum = numStr.toLowerCase().split("million | thousand | hundred");
    	for (String string : TheNum) {
//    		System.out.println(string.strip().substring(0, 2));
//    		System.out.println(singledigit(string).strip());
    		//System.out.println("original "+string);
			Tally.append(singledigit(string.strip()));
		}
    	
    	
    	
    	if (numStr.contains("million") && Integer.valueOf(Tally.toString()) < 1000000) {
    		Tally.append("000000");
    	}
    	if (numStr.contains("thousand") && Integer.valueOf(Tally.toString()) < 1000) {
    		Tally.append("000");
    	}
    	if (numStr.contains("hundred") && Integer.valueOf(Tally.toString()) < 100) {
    		Tally.append("00");
    	}
    	System.out.println(Tally.toString());
    	return Integer.valueOf(Tally.toString());
    }
    private static String singledigit(String stringer) {
    	//System.out.println("Here is "+stringer);
 		StringBuilder sb = new StringBuilder();
    	int counter = 1;
    	String[] singNum = new String[2];
    	if (stringer.contains("-")) {
    		counter = 2;
    		singNum = stringer.split("-");
    		//System.out.println("double");
    	}
    	else if (!stringer.contains("-")) {
    		counter = 1;
    		singNum[0] = stringer.substring(0, 2);
    		//System.out.println("single");
    		
    		if(stringer.charAt(stringer.length()-1)=='y') {
    			//System.out.println("woah!");
    			singNum[1] = "ze";
    			counter = 2;
    		}
    		else if (stringer.contains("teen")) {
    			singNum[0] = "on";
    			singNum[1] = stringer.substring(0, 2);
    			counter = 2;
    			}
    		else if (stringer.contains("twelve")) {
    			//System.out.println("stringer "+stringer);
    			singNum[0] = "tv";
    			counter = 1;
    			}
    	}
    	
    	for (int b=0; b<counter; b++) {
    	String value = null;
    	//String Target = stringer.substring(0, 2);
 		switch (singNum[b].substring(0, 2)) {
 		case "ze":
 			value = "0";
 			break;
 		case "on":
 			value = "1";
 			break;
 		case "tw":
 			value = "2";
 			break;
 		case "th":
 			value = "3";
 			break;
 		case "fo":
 			value = "4";
 			break;
 		case "fi":
 			value = "5";
 			break;
 		case "si":
 			value = "6";
 			break;
 		case "se":
 			value = "7";
 			break;
 		case "ei":
 			value = "8";
 			break;
 		case "ni":
 			value = "9";
 			break;
 		case "te":
 			return "10";
 		case "el":
 			return "11";
 		case "tv":
 			return "12";
 		}
// 		System.out.println("before "+singNum[b].substring(0, 2));
// 		System.out.println("after "+value);
 		sb.append(value);
    	}
    	
    	
 		return sb.toString();  	
    }
    	
    	
}

    