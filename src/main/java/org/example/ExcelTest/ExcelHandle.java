package org.example.ExcelTest;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.lang.reflect.Field;


/**
 * @author TWAVE
 * @date 2023/8/15 11:59
 */
public class ExcelHandle {
    public static void main(String[] args) {
        String path = "E:\\Desktop\\工作簿1.xlsx";
        XSSFWorkbook xssfWorkbook = null;
        try {
            xssfWorkbook = new XSSFWorkbook(new File(path));
        } catch (Exception e) {
            System.out.println("Excel data file cannot be found!");
        }
        // 定义工作表
        XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
        try {
            Field field = ExcelEntity.class.getDeclaredField("orderId");
        } catch (NoSuchFieldException e) {
            System.out.println("No such field!");
        }

        // // 循环获取每一行的数据
        // for (Row row : xssfSheet) {
        //     // 获取每一行的数据
        //     for (Cell cell : row) {
        //         // 获取列号
        //         int columnIndex = cell.getColumnIndex();
        //         CellType cellType = cell.getCellType();
        //         if (cellType == CellType.NUMERIC) {
        //             System.out.print(cell.getNumericCellValue() + " ");
        //         } else if (cellType == CellType.STRING) {
        //             System.out.print(cell.getStringCellValue() + " ");
        //         }
        //     }
        //     System.out.println();
        // }

    }
}
