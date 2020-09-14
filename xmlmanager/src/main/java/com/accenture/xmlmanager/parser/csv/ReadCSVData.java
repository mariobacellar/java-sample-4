package com.accenture.xmlmanager.parser.csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import com.accenture.xmlmanager.XmlManagerApplication;
import com.opencsv.*; 

public class ReadCSVData { 

	//private static final String CSV_FILE_PATH = "\\src\\main\\resources\\data\\input\\csv\\osb-request.csv"; 
	private static final String CSV_FILE_CUSTOM_SEPERATOR = ".\\src\\main\\resources\\data\\input\\csv\\osb-request.csv"; 

	public static void main(String[] args)  { 
		System.out.println("->"); 
		parser();
		System.out.println("<-"); 

	} 

	public static void readDataLineByLine(String file) { 

		try { 

			// Create an object of filereader class 
			// with CSV file as a parameter. 
			FileReader filereader = new FileReader(file); 

			// create csvReader object passing  filereader as parameter 
			CSVReader csvReader = new CSVReader(filereader); 
			String[] nextRecord; 

			// we are going to read data line by line 
			while ((nextRecord = csvReader.readNext()) != null) { 
				for (String cell : nextRecord) { 
					System.out.print(cell + "\t"); 
				} 
				System.out.println(); 
			} 
		} 
		catch (Exception e) { 
			e.printStackTrace(); 
		} 
	} 

	public static void readAllDataAtOnce(String file) 
	{ 
		try { 

			// Create an object of filereader class 
			// with CSV file as a parameter. 
			FileReader filereader = new FileReader(file); 

			// create csvReader object 
			// and skip first Line 
			CSVReader csvReader = new CSVReaderBuilder(filereader) 
									.withSkipLines(1) 
									.build(); 
			List<String[]> allData = csvReader.readAll(); 

			// print Data 
			for (String[] row : allData) { 
				for (String cell : row) { 
					System.out.print(cell + "\t"); 
				} 
				System.out.println(); 
			} 
		} 
		catch (Exception e) { 
			e.printStackTrace(); 
		} 
	} 

	
	
	
	public static void readDataFromCustomSeperator(String file)  { 
		try { 

			// Create object of filereader class with csv file as parameter. 
			FileReader filereader = new FileReader(file); 

			// create csvParser object with 
			// custom seperator semi-colon 
			CSVParser parser = new CSVParserBuilder().withSeparator(';').build(); 

			// create csvReader object with 
			// parameter filereader and parser 
			CSVReader csvReader = new CSVReaderBuilder(filereader) 
									.withCSVParser(parser) 
									.build(); 

			// Read all data at once 
			List<String[]> allData = csvReader.readAll(); 

			// print Data 
			for (String[] row : allData) { 
				for (String cell : row) { 
					System.out.print(cell + "\t"); 
				} 
				System.out.println(); 
			} 
		} 
		catch (Exception e) { 
			e.printStackTrace(); 
		} 
	} 
	
	
    public static void parser() {

        String csvFile		= CSV_FILE_CUSTOM_SEPERATOR;
        String line   		= "";
        String cvsSplitBy	= ";";

        
        try 
        	(BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
        		
        		int i = 0;
        		
        		CSVData allCSV = new CSVData();
        		CSVData oneCSV = null;
        		
        		while ((line = br.readLine()) != null) {
	                i++;
	                //if (i==1)continue;
        			//System.out.println("Line [ " + line + "]");
	                String[] rec = line.split(cvsSplitBy);
	                oneCSV =  CSVData.factor(rec);
	                allCSV.add(oneCSV);
//	                for (String string : rec) {
		                //System.out.println("\tRecord [ " + string + "]");
	//				}
	            }

                for (CSVData csv: allCSV.ltCSVData) {
	                System.out.println("- CSVData[ " + csv+ "]");
				}

        		
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	
} 
