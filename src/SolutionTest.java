
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.runners.JUnit4;


public class SolutionTest {
    
    @Test
    public void fixedTests() {
    	assertEquals(498269 , parseIntPro("four hundred ninety-eight thousand two hundred sixty-nine"));
    	assertEquals(100000 , parseIntPro("one hundred thousand"));
        assertEquals(21 , parseIntPro("twenty-one"));
        assertEquals(246 , parseIntPro("two hundred forty-six"));
        assertEquals(94333 , parseIntPro("ninety-four thousand three hundred thirty-three"));
        
    }
    
    public static int parseInt(String numStr) {
    	StringBuilder Tally = new StringBuilder();
    	StringBuilder Beginning = new StringBuilder();
    	 
    	Beginning.append(numStr.toLowerCase().replaceAll(" and", ""));
    	if (Beginning.toString().contains("million")) {
    		Tally.append("1000000");
    	}
    	
    	else if (Beginning.toString().contains("thousand")) {
    		Tally.append(thousandare(Beginning.toString()));
    	}

    	else if (Beginning.toString().contains("hundred")) {
    		Tally.append(hundredare(Beginning.toString()));
    		if (Beginning.toString().contains("thousand")) {
        		Tally.append(thousandare(Beginning.toString()));
        	}
    	}
    	else {
    		
    		Tally.append(singledigit(Beginning.toString()));
    		if (Beginning.toString().contains("hundred")) {
        		Tally.append(hundredare(Beginning.toString()));
        	if (Beginning.toString().contains("thousand")) {
            		Tally.append(thousandare(Beginning.toString()));
            	}
        	}
    		}

    	System.out.println("final: "+Tally.toString());
    	return Integer.valueOf(Tally.toString());
    }
    
    private static String thousandare (String huns1) {
    	int holder1 = 0;
    	StringBuilder Tally1 = new StringBuilder();
    	String[] THOU = huns1.toString().split("thousand");
		for (int i = 0; i < THOU.length; i++) {
			
			if(i == 0){
				if (THOU[i].contains("hundred")) {Tally1.append(hundredare(THOU[i]));}
				else {Tally1.append(singledigit(THOU[i]));}
				Tally1.append("000");
				}
			else if (!THOU[i].strip().isEmpty()){
				if (THOU[i].contains("hundred")) {holder1 = Integer.valueOf(Tally1.toString())+Integer.valueOf(hundredare(THOU[i]));}
				else{holder1 = Integer.valueOf(Tally1.toString())+Integer.valueOf(singledigit(THOU[i].strip()));}
				 Tally1.setLength(0);
				 Tally1.append(String.valueOf(holder1));
				 holder1 = 0;
				}
			
		}
    	
    	return Tally1.toString();
    }
    
    private static String hundredare (String huns) {
    	int holder2 = 0;
    	StringBuilder Tally2 = new StringBuilder();
    	String[] HUND = huns.split("hundred");
		for (int j = 0; j < HUND.length; j++) {
			if(j == 0){
				
				Tally2.append(singledigit(HUND[j].strip()));
				Tally2.append("00");
				
				}
			else if (!HUND[j].strip().isEmpty()){
				 holder2 = Integer.valueOf(Tally2.toString())+Integer.valueOf(singledigit(HUND[j].strip()));
				 Tally2.setLength(0);
				 Tally2.append(String.valueOf(holder2));
				 holder2 = 0;
			}
		}
    	
    	return Tally2.toString();
    }
    
    private static String singledigit(String stringer) {
 		StringBuilder sb = new StringBuilder();
    	int counter = 1;
    	String[] singNum = new String[2];
    	if (stringer.contains("-")) {
    		counter = 2;
    		singNum = stringer.split("-");
    		
    	}
    	else if (!stringer.contains("-")) {
    		counter = 1;
    		singNum[0] = stringer.substring(0, 2);
    		
    		if(stringer.charAt(stringer.length()-1)=='y') {
    			singNum[1] = "ze";
    			counter = 2;
    		}
    		else if (stringer.contains("teen")) {
    			singNum[0] = "on";
    			singNum[1] = stringer.substring(0, 2);
    			counter = 2;
    			}
    		else if (stringer.contains("twelve")) {
    			singNum[0] = "tv";
    			counter = 1;
    			}
    	}
    	
    	for (int b=0; b<counter; b++) {
    	String value = null;
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

 		sb.append(value);
    	}
    	
 		return sb.toString();  	
    } 	
    
    
    public static int parseIntPro(String numStr) {
        String[] numArray = numStr.split("[ |-]");
        int number = 0;
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        map.put("ten", 10);
        map.put("eleven", 11);
        map.put("twelve", 12);
        map.put("thirteen", 13);
        map.put("fourteen", 14);
        map.put("fifteen", 15);
        map.put("sixteen", 16);
        map.put("seventeen", 17);
        map.put("eighteen", 18);
        map.put("nineteen", 19);
        map.put("twenty", 20);
        map.put("thirty", 30);
        map.put("forty", 40);
        map.put("fifty", 50);
        map.put("sixty", 60);
        map.put("seventy", 70);
        map.put("eighty", 80);
        map.put("ninety", 90);
        map.put("hundred", 100);
        map.put("thousand", 1000);
        map.put("million", 1000000);
        
        for (int i = 0; i < numArray.length; i++) {
            for (String key : map.keySet()) {
                if (numArray[i].toLowerCase().equals(key)) {
                    if (map.get(key) == 100) {
                        int temp = number % 100;
                        number -= temp;
                        number += temp * (map.get(key));
                    }
                    else if (map.get(key) > 100)
                        number *= (map.get(key));
                    else
                        number += map.get(key);
                      break;
                }
            }
        }
        return number;
    }
    
}