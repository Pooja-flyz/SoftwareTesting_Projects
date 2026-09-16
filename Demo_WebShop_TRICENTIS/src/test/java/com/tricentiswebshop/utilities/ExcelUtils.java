package com.tricentiswebshop.utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtils {
	public static Object[][] getTestData(String filepath, String sheetName) throws Exception {

        FileInputStream fis = new FileInputStream(filepath); //read excel path

        XSSFWorkbook workbook = new XSSFWorkbook(fis); //get excel workbook

        XSSFSheet sheet = workbook.getSheet(sheetName); //to get the sheet

        int rows = sheet.getLastRowNum(); //excluding header ie, rows are counting 0
        int cols = sheet.getRow(0).getLastCellNum(); //cells are counting from 1

        Object[][] data = new Object[rows][cols]; //create 2d obj array

        DataFormatter formatter = new DataFormatter();

        for (int i = 1; i <= rows; i++) //start from 1(skip header)
        { 

            for (int j = 0; j < cols; j++) 
            {

//                Cell cell = sheet.getRow(i).getCell(j);

                data[i - 1][j] = formatter.formatCellValue(sheet.getRow(i).getCell(j));
            }
        }

        workbook.close();
        fis.close();

        return data;
    }


}
