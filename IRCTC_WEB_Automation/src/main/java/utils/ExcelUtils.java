package utils;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {
    private static Workbook workbook;
    private static Sheet sheet;

    public static void loadExcel(String filePath, String sheetName) {
        try {
            FileInputStream fis = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet(sheetName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getRowCount() {
        return sheet.getPhysicalNumberOfRows();
    }

    public static int getColCount() {
        return sheet.getRow(0).getPhysicalNumberOfCells();
    }

    public static String getCellData(int row, int col) {
        DataFormatter formatter = new DataFormatter();
        Row r = sheet.getRow(row);
        if (r == null) return ""; // null row
        Cell cell = r.getCell(col);
        if (cell == null) return ""; // blank cell
        return formatter.formatCellValue(cell).trim();
    }

    public static Object[][] getTestData() {
        int rowCount = getRowCount();
        int colCount = getColCount();

        List<Object[]> dataList = new ArrayList<>();

        // skip header row, start from 1
        for (int i = 1; i < rowCount; i++) {
            boolean isRowEmpty = true;
            Object[] rowData = new Object[colCount];

            for (int j = 0; j < colCount; j++) {
                String value = getCellData(i, j);
                rowData[j] = value;
                if (!value.isEmpty()) {
                    isRowEmpty = false;
                }
            }

            if (!isRowEmpty) {
                dataList.add(rowData); // only add active rows
            }
        }

        return dataList.toArray(new Object[0][0]);
    }
}
