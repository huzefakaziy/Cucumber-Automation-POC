package utilities;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelReader {
	
	/* Author: Huzefa Kazi
	 * Logic steps:
	 * Create object of XSSFWorkbook to get hold of excel file
	 * Get access to sheet	 
	 * Get access to all rows of sheet
	 * Get access to all header rows
	 * Get all headers from excel and put into ArrayList
	 * Get access to specific row
	 * Get access to all cells of rows
	 * Get cell data and put data to Map collection
	 */	
	public static Map<String, String> getTestData(String excelFileName, String excelWorkSheetName, String testCaseName) throws IOException
	{
		String CurrentDir = "Resources/";
		ArrayList<String> headerList = new ArrayList<String>();
		Map<String, String> dataMap = new LinkedHashMap<String, String>();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		// Create object of XSSFWorkbook to get hold of excel file		
		FileInputStream fis = new FileInputStream(CurrentDir + excelFileName);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		try
		{
		int noOfSheets = workbook.getNumberOfSheets();
		for(int i=0; i<noOfSheets; i++)
			{
				
				if(workbook.getSheetName(i).equalsIgnoreCase(excelWorkSheetName))
				{
					//Get access to sheet
					XSSFSheet sheet = workbook.getSheetAt(i);
					
					//Get access to all rows of sheet
					Iterator<Row> rows = sheet.iterator();
					
					Row headerRow = rows.next();
					Iterator<Cell> headerCells = headerRow.cellIterator();
					while(headerCells.hasNext())
					{
						headerList.add(headerCells.next().getStringCellValue());
					}
					
					// Get access to specific row
					while(rows.hasNext())
					{
						Row dataRow = rows.next();
						
						if(dataRow.getCell(0).getStringCellValue().equalsIgnoreCase(testCaseName))
						{
							
							//Get access to collection of cells of the identified rows
							Iterator<Cell> dataCells = dataRow.cellIterator();
							
							//loop through all the cells of the row and add cell data to arraylist.
							while(dataCells.hasNext())
							{
								Cell dataCell = dataCells.next();
															
								if(dataCell.getCellType()==CellType.STRING)
								{	
									//arrList.add(dataCell.getStringCellValue());
									dataMap.put(headerList.get(dataCell.getColumnIndex()), dataCell.getStringCellValue());
								}
								else if(dataCell.getCellType()==CellType.NUMERIC)
								{	
									if(DateUtil.isCellDateFormatted(dataCell))
									{
										//arrList.add(df.format(dataCell.getDateCellValue()));
										dataMap.put(headerList.get(dataCell.getColumnIndex()), df.format(dataCell.getDateCellValue()));
									}
									else
									{
										//arrList.add(NumberToTextConverter.toText(dataCell.getNumericCellValue()));
										dataMap.put(headerList.get(dataCell.getColumnIndex()), NumberToTextConverter.toText(dataCell.getNumericCellValue()));
									}
								}
								else if(dataCell.getCellType()==CellType.BOOLEAN)
								{	
									//arrList.add(Boolean.toString(dataCell.getBooleanCellValue()));
									dataMap.put(headerList.get(dataCell.getColumnIndex()), Boolean.toString(dataCell.getBooleanCellValue()));
								}
																
							}
						}
					}
				}
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			if(workbook!=null)
				workbook.close();
			if(fis!=null)
				fis.close();	
		}
		
		return dataMap;
		
	}

	

}
