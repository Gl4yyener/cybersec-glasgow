import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import FormatIO.EofX;
import FormatIO.FileIn;
import FormatIO.FileOut;

public class KPT {

	public static String readFile(String pathname) throws FileNotFoundException {
	    File file = new File(pathname);
	    StringBuilder fileContents = new StringBuilder((int)file.length());
	    Scanner scanner = new Scanner(file);
	    String lineSeparator = System.getProperty("line.separator");

	    try {
	        while(scanner.hasNextLine()) {        
	            fileContents.append(scanner.nextLine() + lineSeparator);
	        }
	        return fileContents.toString();
	    } finally {
	        scanner.close();
	    }
	}
	
	
	@SuppressWarnings("static-access")
	public static String readFileToInts(String pathname) throws FileNotFoundException {
		Hex16 hex16 = new Hex16();

	    File file = new File(pathname);
	    StringBuilder fileContents = new StringBuilder((int)file.length());
	    Scanner scanner = new Scanner(file);
	    String lineSeparator = System.getProperty("line.separator");

	    try {
	        while(scanner.hasNextLine()) {        
	            fileContents.append(hex16.convert(scanner.nextLine() ) + lineSeparator);
	        }
	        return fileContents.toString();
	    } finally {
	        scanner.close();
	    }
	}
	
	
	public static int findKey(String pt, String ct) throws FileNotFoundException{
	
		
		//read first block of the cipher text and convert it to int
		String first_ct_block = readFileToInts(ct);
		int first_ct_block_int = Integer.parseInt(first_ct_block.split("\n")[0]);
		
		
		int keyInt = 0;
		
        try {
			String pt1 = readFile(pt);
			//find the key
			for (int i = 0; i < 65536; i++) {
				int encrypted = Coder.encrypt(i, Hex16.convert(pt1));
				if (encrypted==first_ct_block_int) {
					keyInt=i;
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return keyInt;	
	}

	public static void readEncryptFile() {
		
		// open files
        FileIn	fin  = new FileIn("inputs/ct1.txt");
        FileOut fout = new FileOut("outputs/enc1.txt");
	
        // read blocks, encrypt and output blocks
        	int key;
			try {
				key = findKey("inputs/pt1.txt", "inputs/ct1.txt");
				
				for (;;)
				{
					
					String	s = fin.readWord();
					int	c = Hex16.convert(s);
					int	p = Coder.decrypt(key, c);
					String	out = String.format("0x%04x", p);
					fout.println(out);
					
				}
			} catch (FileNotFoundException | EofX e) {
			}
        	
        
        }
	
	public static void toText(){
		FileIn fin  = new FileIn("outputs/enc1.txt");
        FileOut fout = new FileOut("outputs/enc1_text.txt");
        
        
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
		
	
	
	
	
	
	public static void printFile(){
    		BufferedReader br;
			try {
				br = new BufferedReader(new FileReader("outputs/enc1_text.txt"));
				String line = null;
				while ((line = br.readLine()) != null) {
					System.out.println(line);
				}
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
	public static void main(String[] args) {
        

			readEncryptFile();
			toText(); 
			printFile();
			
		
       
        

        
        
		}
	

}


