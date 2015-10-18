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
         public static void main (String[] args) throws IOException
         {        	 
        	 PrintReceipt("/Users/lababib/Documents/eclipsecode/ThoughtWorks/src/example1.txt");
        	 PrintReceipt("/Users/lababib/Documents/eclipsecode/ThoughtWorks/src/example2.txt");
        	 PrintReceipt("/Users/lababib/Documents/eclipsecode/ThoughtWorks/src/example3.txt");
         }
         
         public static void PrintReceipt (String textfilename) throws FileNotFoundException, IOException 
         {
        	 String line;
             BufferedReader in;
             Double alltaxes = 0.0;
             Double allprices = 0.0;
             DecimalFormat decim = new DecimalFormat("0.00");
             //store names and prices
             //open the file
             in = new BufferedReader(new FileReader(textfilename));
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
        	 			//System.out.println(name);
        	 			double tax = .10 * price;
        	 			//tax = tax/100;
						taxes = taxes + tax;
						
        	 		}
        	 		
        	 		//if imported, additional 5% sales tax
        	 		//if not food, medicine, books, 10% regular sales tax
        	 		if (importTax == true)
        	 		{
        	 			//sales tax = np/100 rounded up to the nearest 0.05
        	 			//System.out.println(name);
        	 			double tax = .05 * price;
        	 			//tax = tax/100;
						taxes = taxes + tax;
        	 		}
        	 	
        	 		
        	 		double roundedto5 = Math.round(taxes * 20.0) / 20.0;
        	 		double total = price + roundedto5;
        	 		total = Math.round(total * 100.0) / 100.0;
        	 		
        	 		//ensuring we have trailing zeros
        	 		String stotal = decim.format(total);
            	 	System.out.println(quantity + name + ": " + stotal);
            	 	
            	 	alltaxes += taxes;
            	 	allprices += price + taxes;
                    line = in.readLine();
             }
             //ensuring we have trailing zeros
             alltaxes = Math.round(alltaxes * 100.0) / 100.0;
             allprices = Math.round(allprices * 100.0) / 100.0;             
             String salltaxes = decim.format(alltaxes);
             String sallprices = decim.format(allprices);
	 		 
             System.out.println("Sales Taxes: " + salltaxes);
             System.out.println("Total: " + sallprices);
             System.out.println();
             in.close();

         }

    }