package common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;

public class XlsFileReader {

	public static String[][] getLoginDataFromxmlFile() {
		
		try {
			// TODO Auto-generated method stub
			File file = new File("D:\\book1.xlsx");
			FileInputStream fis = new FileInputStream(file);

			XSSFWorkbook exlbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = exlbook.getSheet("Sheet1");
			XSSFRow row = sheet.getRow(0);
			XSSFCell cell = row.getCell(0);
			
			int columnsCount = row.getLastCellNum() + 1;
			int rowsCount = sheet.getLastRowNum();
			int c=sheet.getLastRowNum();
			System.out.println("row="+c);
			String[][] data = new String[rowsCount][columnsCount];
			XSSFCell Tcell[]=new XSSFCell[rowsCount];

			for (int j = 0; j <rowsCount; j++) {
				for(int i=0;i<columnsCount;i++) {

				XSSFRow row1 = sheet.getRow(j);
			
				 Tcell[i] = row1.getCell(i);
				 

				data[i][j] = Tcell[i].getStringCellValue();
				
				}
			}

			return data;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public static void main(String[] args) {
		String[][] logindata = getLoginDataFromxmlFile();

		for (int j = 0; j < 3; j++) {
			System.out.println(logindata[0][j] + " " + logindata[1][j]+" "+logindata[2][j]);

		}

	}
}
