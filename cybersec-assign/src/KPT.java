import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;




public class KPT {
			
	

	@SuppressWarnings("static-access")
	public static String readFile(String pathname) throws FileNotFoundException {
		Hex16 hex16 = new Hex16();

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
	
	
	
	
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		
		Hex16 hex16 = new Hex16();
		DecryptAllBlocks decryptAll = new DecryptAllBlocks();
		
        try {
			String pt1 = readFile("inputs/pt1.txt");
			String ct1= readFileToInts("inputs/ct1.txt");
			
			
			
			
			for (int i = 0; i < 65536; i++) {
				int encrypted = Coder.encrypt(i, hex16.convert(pt1));
				if (encrypted==5402) {
					System.out.println(i);
				}
			}
			 
			
			
			
			
			
			
			
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	

}


