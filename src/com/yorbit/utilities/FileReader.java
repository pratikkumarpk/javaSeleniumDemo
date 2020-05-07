package com.yorbit.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class FileReader {
	

	/**
	 * Reads the csv file with first row as header and returns map of the key values based on the index.
	 * @param fileName
	 * @param row
	 * @return
	 * @throws IOException
	 */
	public static Map<String, String> readExcel(String fileName, int row) throws IOException {

		List<Map<String, String>> allValues = new ArrayList<Map<String, String>>();
		try {
			Reader reader = Files.newBufferedReader(Paths.get(fileName));
			CSVParser csvParser = new CSVParser(reader,
					CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
			for (CSVRecord csvRecord : csvParser) {
				// csvRecord.get("app")
				Map<String, String> dataMap = new HashedMap<String, String>();
				dataMap.putAll(csvRecord.toMap());
				allValues.add(dataMap);
			}
			return allValues.get(row);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
	/**
	 * Reads property file and returns the string value of a property.
	 * @param fileName
	 * @param property
	 * @return
	 * @throws IOException
	 */
	public static String readPropertiesFile(String fileName,String property) throws IOException {
	      FileInputStream fis = null;
	      Properties prop = null;
	      try {
	         fis = new FileInputStream(fileName);
	         prop = new Properties();
	         prop.load(fis);
	      } catch(FileNotFoundException fnfe) {
	         fnfe.printStackTrace();
	      } catch(IOException ioe) {
	         ioe.printStackTrace();
	      } finally {
	         fis.close();
	      }
	      return prop.get(property).toString();
	   }

}
