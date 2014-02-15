import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;



public class CTO {
	
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
		
		//read the file into String array
		String ct = new Scanner(new File("inputs/ct2.txt")).useDelimiter("\\Z").next();
		String[] lines = ct.split(System.getProperty("line.separator"));

		
		int len = ct.split(System.getProperty("line.separator")).length;
		//itterate through all possible keys
		for (int key = 0; key < 65536; key++) {
			String pt="";
			
			//decrypt the cipher text
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
			
			//convert into text
			for (int l = 1; l< len2; l++) {
				String s = lines_pt[l];
				int	c = Hex16.convert(s);
				int	c0 = c / 256;
				int	c1 = c % 256;
				pt_t+=(char)c0;
				
				if (c1 != 0)
					pt_t+=(char)c1;
			}
			

			
			
			
			//method 2
			ArrayList<String> wordList = new ArrayList<String>();
			String[] split = pt_t.split(" ");
			for (String string : split) {
				wordList.add(string);
			}
			
			if(wordList.contains("the")){
				
				System.out.println("Decrypted:  \n"+pt_t+"\n");

			}
			

//			//method1
//			ArrayList<Integer> freq = new ArrayList<>();
//			try {
//				int[] count = countLetters(pt_t);
//				count[27]=0;
//				//most frquent letters in english e, t, a, o, i, n, s
//				//{"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z
//				for (int k = 0; k < 6; k++) {
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
//				}
//				
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			if(freq.contains(0) && freq.contains(26) &&  freq.contains(19) && freq.contains(4) ){
//				System.out.println(pt_t+"\n--------------------");
//			}
			
		
		}
	}
}
