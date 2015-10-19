import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import org.apache.commons.io.FileUtils;

public class TestSalesTaxes {

	@Test
	public void test() {
		
		//Saving the file paths we're testing
		File example1 = new File("/Users/lababib/Documents/eclipsecode/ThoughtWorks/src/example1.txt");
		File example2 = new File("/Users/lababib/Documents/eclipsecode/ThoughtWorks/src/example2.txt");
		File example3 = new File("/Users/lababib/Documents/eclipsecode/ThoughtWorks/src/example3.txt");
		File output1 = new File("/Users/lababib/Documents/eclipsecode/ThoughtWorks/src/output1.txt");
		File output2 = new File("/Users/lababib/Documents/eclipsecode/ThoughtWorks/src/output2.txt");
		File output3 = new File("/Users/lababib/Documents/eclipsecode/ThoughtWorks/src/output3.txt");
		File test1 = new File("/Users/lababib/Documents/eclipsecode/ThoughtWorks/src/test1");
		File test2 = new File("/Users/lababib/Documents/eclipsecode/ThoughtWorks/src/test2");
		File test3 = new File("/Users/lababib/Documents/eclipsecode/ThoughtWorks/src/test3");
		
		//call method with the file path passed in
		try {
//			String inputpath = "/Users/lababib/Documents/eclipsecode/ThoughtWorks/src/example1.txt";
//			String outputpath = "/Users/lababib/Documents/eclipsecode/ThoughtWorks/src/test1";
//			String[] args = new String[2];
//			args[0] = inputpath;
//			args[1] = outputpath;
			SalesTaxes.TestPrintReceipt(example1, test1);
			SalesTaxes.TestPrintReceipt(example2, test2);
			SalesTaxes.TestPrintReceipt(example3, test3);
		} catch (IOException e) {
			// couldn't find file
			e.printStackTrace();
		}
		
		//AFTER assert that the file is then equal to the output file
			try {
				boolean compare1 = FileUtils.contentEquals(output1, test1);
				System.out.println("Are output1 and test1 the same? " + compare1);
				
				boolean compare2 = FileUtils.contentEquals(output2, test2);
				System.out.println("Are output2 and test2 the same? " + compare2);
				
				boolean compare3 = FileUtils.contentEquals(output3, test3);
				System.out.println("Are output3 and test3 the same? " + compare3);
			} catch (IOException e) {
				e.printStackTrace();
			}


	}
}
