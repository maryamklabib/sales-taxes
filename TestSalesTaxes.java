import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import org.apache.commons.io.FileUtils;

public class TestSalesTaxes {

	@Test
	public void test() {
		
		//Saving the files and paths we're testing
		
		String inputpath1 = "/Users/lababib/Documents/eclipsecode/ThoughtWorks/src/example1.txt";
		String inputpath2 = "/Users/lababib/Documents/eclipsecode/ThoughtWorks/src/example2.txt";
		String inputpath3 = "/Users/lababib/Documents/eclipsecode/ThoughtWorks/src/example3.txt";
		
		File output1 = new File("/Users/lababib/Documents/eclipsecode/ThoughtWorks/src/output1.txt");
		File output2 = new File("/Users/lababib/Documents/eclipsecode/ThoughtWorks/src/output2.txt");
		File output3 = new File("/Users/lababib/Documents/eclipsecode/ThoughtWorks/src/output3.txt");
		
		String testpath1 = "/Users/lababib/Documents/eclipsecode/ThoughtWorks/src/test1.txt";
		String testpath2 = "/Users/lababib/Documents/eclipsecode/ThoughtWorks/src/test2.txt";
		String testpath3 = "/Users/lababib/Documents/eclipsecode/ThoughtWorks/src/test3.txt";
		File test1 = new File("/Users/lababib/Documents/eclipsecode/ThoughtWorks/src/test1.txt");
		File test2 = new File("/Users/lababib/Documents/eclipsecode/ThoughtWorks/src/test2.txt");
		File test3 = new File("/Users/lababib/Documents/eclipsecode/ThoughtWorks/src/test3.txt");

		
		//call method with the file path passed in
		try {
			
			//Testing first example
			String[] args = new String[2];
			args[0] = inputpath1;
			args[1] = testpath1;
			SalesTaxes.main(args);
						
			//Testing second example
			args = new String[2];
			args[0] = inputpath2;
			args[1] = testpath2;
			SalesTaxes.main(args);

			
			//Testing third example
			args = new String[2];
			args[0] = inputpath3;
			args[1] = testpath3;
			SalesTaxes.main(args);
				
		
			//Confirm the output
		
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
