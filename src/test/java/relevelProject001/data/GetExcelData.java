package relevelProject001.data;

import com.relevelProject.qa.testComponents.baseTest;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class GetExcelData extends baseTest {
    static DataFormatter formatter = new DataFormatter();
    public static List<Map<String, String>> getTestdatInMap() throws IOException {
        List<Map<String, String>> testDataallrows = null;
        Map<String, String > testData = null;
        try {                                                          //System.getProperty("user.dir")+
            FileInputStream fileInputStream = new FileInputStream( "C:\\Users\\rg030\\IdeaProjects\\relevelProject001 2\\relevelProject001 2\\dataprovider.xlsx");
            Workbook workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0);
            int lastRowNumber = sheet.getLastRowNum();
            int lastColNumber = sheet.getRow(0).getLastCellNum();

            List list = new ArrayList();
            for (int i = 0; i < lastColNumber; i++) {
                Row row = sheet.getRow(0);
                Cell cell = row.getCell(i);
                String rowHeader = cell.getStringCellValue().trim();//formatter.formatCellValue(cell);
                list.add(rowHeader);
            }
            testDataallrows = new ArrayList<Map<String, String>>();
            for (int j = 1; j <= lastRowNumber; j++) {
                Row row = sheet.getRow(j);
                testData = new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);
                for (int k = 0; k < lastColNumber; k++) {
                    Cell cell = row.getCell(k);
                    String colValue = formatter.formatCellValue(cell).trim();//cell.getStringCellValue().trim();
                    testData.put((String) list.get(k), colValue);
                }
                testDataallrows.add(testData);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return testDataallrows;
    }
}



