package com.blogcms.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelDataProvider {
    private static final String TEST_DATA_PATH = "src/test/resources/testdata/TestData.xlsx";
    
    public static Object[][] getTestData(String sheetName) {
        try (FileInputStream fis = new FileInputStream(TEST_DATA_PATH);
             Workbook workbook = new XSSFWorkbook(fis)) {
            
            Sheet sheet = workbook.getSheet(sheetName);
            int rowCount = sheet.getLastRowNum();
            int colCount = sheet.getRow(0).getLastCellNum();
            
            Object[][] data = new Object[rowCount][1];
            
            // Get header row
            Row headerRow = sheet.getRow(0);
            
            // Iterate through data rows
            for (int i = 1; i <= rowCount; i++) {
                Row row = sheet.getRow(i);
                Map<String, String> dataMap = new HashMap<>();
                
                for (int j = 0; j < colCount; j++) {
                    String header = headerRow.getCell(j).getStringCellValue();
                    String value = row.getCell(j).getStringCellValue();
                    dataMap.put(header, value);
                }
                
                data[i-1][0] = dataMap;
            }
            
            return data;
            
        } catch (IOException e) {
            throw new RuntimeException("Failed to read test data", e);
        }
    }
} 