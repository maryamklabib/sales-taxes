/** Problem Two: Sales Taxes
 
The rounding rules for sales tax are that for a tax rate of n%, 
a shelf price of p contains (np/100 rounded up to the nearest 0.05) amount of sales tax.

Input:
 
1 imported bottle of perfume at 27.99
1 bottle of perfume at 18.99
1 packet of headache pills at 9.75
1 box of imported chocolates at 11.25
 
Output: 
1 imported bottle of perfume: 32.19
1 bottle of perfume: 20.89
1 packet of headache pills: 9.75
1 imported box of chocolates: 11.85
Sales Taxes: 6.70
Total: 74.68
==========
 **/
import java.io.*;
import java.text.DecimalFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

     public class SalesTaxes 
     {
    	 public static File inputfile;
    	 public static File outputfile;
    	 public static DecimalFormat decim = new DecimalFormat("0.00");
    	 
         public static void main (String[] args) throws IOException
         {        	 
        	 inputfile = new File(args[0]);
        	 outputfile = new File(args[1]);
        	 PrintReceipt(inputfile, outputfile);
         }
         
         public static void PrintReceipt(File textfile, File output) throws FileNotFoundException, IOException
         {
        	 FileWriter writer = new FileWriter(output, true);
        	 
        	 String line;
             BufferedReader in;
             Double alltaxes = 0.0;
             Double allprices = 0.0;
             
             //store names and prices
             //open the file
             in = new BufferedReader(new FileReader(textfile));
             line = in.readLine();
             //read the file
             while(line != null)
             {
            	 	//parse each to figure out name, price, and tax (if applicable)
            	 	Boolean regularTax = true;
            	 	Boolean importTax = false;
            	 	double taxes = 0;
            	 	int quantity = Integer.parseInt(line.substring(0, 1));
            	 	String name = line.substring(1, line.indexOf(" at "));
            	 	double price = Double.parseDouble((line.split(" at ")[1]));            	 	          
            	 	List<String> parsed = new ArrayList<String>(Arrays.asList(line.split(" ")));	
            	 	for (int i = 0; i < parsed.size(); i++) 
            	 	{
            	 	    String word = parsed.get(i);
            	 		//if see word 'imported', additional 5% on all
            	 		if (word.equals("imported") )
            	 		{
            	 			importTax = true;
            	 		}
            	 		//book will say book
            	 		if (word.equals("book") )
            	 		{
            	 			regularTax = false;
            	 		}
            	 		//food will say chocolate
            	 		if (word.equals("chocolate") || word.equals("chocolates"))
            	 		{
            	 			regularTax = false;
            	 		}
            	 		//medical will say pills
            	 		if (word.equals("pills") )
            	 		{
            	 			regularTax = false;
            	 		}

            	 	}
        	 		//if not food, medicine, books, 10% regular sales tax
        	 		if (regularTax == true)
        	 		{
        	 			//sales tax = np/100 rounded up to the nearest 0.05
        	 			double tax = 10 * price/100;
        	 			tax = roundtonearestpointfive(tax);
        	 			taxes = taxes + tax;
						
        	 		}
        	 		
        	 		//if imported, additional 5% sales tax
        	 		if (importTax == true)
        	 		{
        	 			//sales tax = np/100 rounded up to the nearest 0.05
        	 			double tax = 5 * price/100;
        	 			tax = roundtonearestpointfive(tax);
						taxes = taxes + tax;
        	 		}
        	 	
        	 		//add taxes + price
        	 		double total = price + taxes;
        	 		
        	 		//ensuring we have trailing zeros in the printing
        	 		String stotal = decim.format(total);
        	 		writer.write(quantity + name + ": " + stotal + "\n");
            	 	System.out.println(quantity + name + ": " + stotal);
            	 	
            	 	alltaxes += taxes;
            	 	allprices += price + taxes;
                    line = in.readLine();
             }
             //ensuring we have trailing zeros in the printing        
             String salltaxes = decim.format(alltaxes);
             String sallprices = decim.format(allprices);
	 		 
             writer.write("Sales Taxes: " + salltaxes + "\n");
             System.out.println("Sales Taxes: " + salltaxes);
             writer.write("Total: " + sallprices);
     	 	 System.out.println("Total: " + sallprices);
     	 	 System.out.println();
             writer.close();
             in.close();
         }
         
         public static double roundtonearestpointfive(double num) {
        	 //creating the initial two places double
        	 String test = Double.toString(num);
        	 test += "00";
        	 String copy = test.substring(0, test.indexOf('.') + 3);

        	 //getting the last of the current and the next
        	 num = Double.parseDouble(copy);
        	 test = Double.toString(num);
        	 char last = copy.charAt(copy.length() - 1);        	 
        	 char next = copy.charAt(copy.length() - 2);
        	 Double dnext = Double.parseDouble(String.valueOf(next)) + 1;
        	 String snext = String.valueOf(dnext);
        	 char cnext = snext.charAt(0);
        	 next = cnext;
        	 
        	 char[] temp = copy.toCharArray();
        	 switch (last) {
        	 case '0':
        		 break;
        		 
        	 case '1':
        	 case '2':
        	 case '3':
        	 case '4':
        		 temp[copy.length() - 1] = '5';
        		 break;
        		 
        	 case '5':
        		 break;
        		 
        	 case '6':
        	 case '7':
        	 case '8':
        	 case '9':
        		 temp[copy.length() - 2] = next;
        		 temp[copy.length() - 1] = '0';
        		 break;
        	 }
        	 String result = "";
        	 for (int i = 0; i < temp.length; i++) {
        		 result += String.valueOf(temp[i]);
        	 }
        		 
        	 num = Double.parseDouble(result);
        	 return num;
         }
        
    }