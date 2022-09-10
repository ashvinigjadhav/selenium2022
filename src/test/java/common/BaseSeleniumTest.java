package common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;


public class BaseSeleniumTest extends BaseSeleniumDataProviderExcelReader {
	
	@DataProvider(name = "LoginDataProviderFromxlsFile")
	public  String[][] getLoginDataFromXlsFile() {
		
		
		try {
			return (getExcelTableArray("D:\\book1.xlsx","Sheet1") );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}


/*
	// data provider
	@DataProvider(name = "LoginDataProviderArray")
	public String[][] getLoginData() {

		String loginData[][] = { { "Admin", "admin123", "Welcome Paul" }, { "Adm", "admin123", "Welcome Adm" },
				{ "ESS", "admin123", "Welcome ESS" }, { "ESS", "admin123", "Welcome ESS" }

		};
		return loginData;
	}

	
	
	
	@DataProvider(name = "LoginDataProviderFromFile",parallel=true)
	public  String[][] getLoginDataFromFile() throws IOException {
		File file = new File("D:\\selenium notes\\MYFILE.txt");
		FileReader read = new FileReader(file);
		BufferedReader br = new BufferedReader(read);

		// BufferedReader br=new BufferedReader(new FileReader(new File("D:\\selenium
		// notes\\MYFILE.txt")));

		String line;
		
		int numberLine = getline();
		int numberRow = getNumberrow();
		String row[] = new String[numberRow];
		String[][] logindata = new String[numberLine+1][numberRow];
		int j = 0;
		while ((line = br.readLine()) != null) {

			row = line.split(" ");
			
			logindata[j] = row;

			j++;

		}
		br.close();
		return logindata;
	}

	public  int getline() throws IOException {
		File file = new File("D:\\selenium notes\\MYFILE.txt");
		FileReader read = new FileReader(file);
		BufferedReader br = new BufferedReader(read);
		int line = 0;
		String row;
		while ((row = br.readLine()) != null) {

			line++;
		}
		br.close();
		return line;
	}

	public  int getNumberrow() throws IOException {
		File file = new File("D:\\selenium notes\\MYFILE.txt");
		FileReader read = new FileReader(file);
		BufferedReader br = new BufferedReader(read);
		int line = 0;
		String row;
		if ((row = br.readLine()) != null) {

			String s[] = row.split(" ");
			br.close();
			return s.length;
		} else {
			br.close();
			return 0;
		}
	}
	
	@DataProvider(name = "LoginDataProviderFromxlsFile")
	public  String[][] getLoginDataFromXlsFile() throws IOException {
	/*
			try {
				// TODO Auto-generated method stub
				File file = new File("D:\\book1.xlsx");
				FileInputStream fis = new FileInputStream(file);

				XSSFWorkbook exlbook = new XSSFWorkbook(fis);
				XSSFSheet sheet = exlbook.getSheet("Sheet1");
				XSSFRow row = sheet.getRow(0);
				XSSFCell cell = row.getCell(0);
				int columnsCount = row.getLastCellNum() + 1;
				int rowsCount = 3;
				String[][] data = new String[3][columnsCount];

				for (int j = 0; j < columnsCount; j++) {

					XSSFRow row1 = sheet.getRow(j);
					XSSFRow row2 = sheet.getRow(j);
					XSSFCell cell1 = row1.getCell(0);
					XSSFCell cell2 = row1.getCell(1);
					XSSFCell cell3 = row1.getCell(2);

					data[0][j] = cell1.getStringCellValue();
					data[1][j] = cell2.getStringCellValue();
					data[2][j] = cell2.getStringCellValue();
				}

				return data;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}*/
		



