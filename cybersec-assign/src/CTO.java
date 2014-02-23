import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;



public class CTO {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException {
		
		//read the file into String array
		String ct = new Scanner(new File("src/files/ct2.txt")).useDelimiter("\\Z").next();
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
			
			if (checkIfEnglish(pt_t)){
				System.out.println("Key:    " + key + "\n" + "Decrypted:  \n"+pt_t+"\n");
			}
		
		}
	}
	
	
	public static boolean checkIfEnglish(String text){
		ArrayList<String> wordList = new ArrayList<String>();
		String[] split = text.split(" ");
		for (String string : split) {
			wordList.add(string);
		}
		
		if(wordList.contains("the") || wordList.contains("be") || wordList.contains("to") || wordList.contains("of") || wordList.contains("and")){
			
			return true;

		}
		else return false;
		
	}
	
	
	
}
