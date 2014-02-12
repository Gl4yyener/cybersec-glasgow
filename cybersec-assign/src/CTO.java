import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import FormatIO.EofX;
import FormatIO.FileIn;
import FormatIO.FileOut;


public class CTO {
	
	
	public static void toText(){
		FileIn fin  = new FileIn("outputs/pt2.txt");
        FileOut fout = new FileOut("outputs/pt2_text.txt");
        
        
        try {
    		for (;;)
    		{
    			String s;
					s = fin.readWord();
    			int	i = Hex16.convert(s);
    			int	c0 = i / 256;
    			int	c1 = i % 256;
    			fout.print((char)c0);
    			if (c1 != 0)
    			fout.print((char)c1);
    		}
        	} catch (EofX e) {
        	}
    	}
	
	//most frquent letters in english e, t, a, o, i, n, s
	
	public static int[] countLetters(String text) throws IOException{
	   
	    ArrayList<String> letterPos= new ArrayList<String>();
	    String temp[] = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z", " "};
	    for (String tmp : temp) {
			letterPos.add(tmp);
		}
	    int[] letterCounts = new int[28];
	    for (int i = 0; i < 27; i++) {
	    	letterCounts[i]=0;
		}
	    
	    
	    
	    for (int i = 0; i < text.length() ; i++) {	
		 
	    	
	    	if(letterPos.contains((""+text.charAt(i)).toLowerCase())){
	    		
	    		letterCounts[letterPos.indexOf((""+text.charAt(i)).toLowerCase())]++;
	    	}else{
	    		letterCounts[27]++;
	    	}
	    	
	    	
	    }
	    
		return letterCounts;
		
	}
	
	

	
	
	public static void main(String[] args) throws FileNotFoundException {
		
		
		String ct = new Scanner(new File("inputs/ct1.txt")).useDelimiter("\\Z").next();
		String[] lines = ct.split(System.getProperty("line.separator"));
		
		
		int len = ct.split(System.getProperty("line.separator")).length;
		for (int key = 0; key < 65536; key++) {
			key = 36460;
			String pt="";
			for (int i = 0; i < len; i++) {
					String	s = lines[i];
					int	c = Hex16.convert(s);
					int	p = Coder.decrypt(key, c);
					String	out = String.format("0x%04x", p);
					pt+="\n"+out;
				
			}
			
			String pt_t="";
			
			String[] lines_pt = pt.split(System.getProperty("line.separator"));
			int len2 = pt.split(System.getProperty("line.separator")).length;
			
			for (int i = 0; i < len2; i++) {
				String s = lines_pt[i];
				int	c = Hex16.convert(s);
				int	c0 = c / 256;
				int	c1 = c % 256;
				pt_t+="\n"+(char)c0;
				
				if (c1 != 0)
					pt_t+="\n"+(char)c1;
			}
			
		System.out.println(pt_t);
			
//			ArrayList<Integer> freq = new ArrayList<>();
//			
//			try {
//				int[] count = countLetters(pt_t);
//				count[27]=0;
//				//most frquent letters in english e, t, a, o, i, n, s
//				//{"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z
//				for (int k = 0; k < 20; k++) {
//					
//					int maxIndex = 0;
//					for (int i = 1; i < count.length; i++){
//						int newnumber = count[i];
//						if ((newnumber > count[maxIndex])){
//							maxIndex = i;
//						}
//					} 
//					freq.add(maxIndex);
//					count[maxIndex]=0;
//				
//					
//				}
//				
//				if(freq.get(0)==4 && freq.get(1)==19  && freq.get(2)==0){
//				System.out.println("This is the key:   " + key);
//				}
//				
//				
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
		}
		

			
		
	
	}
	
}
