import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

public class  createInvoice
{

    public createInvoice(String[][] students) throws IOException
    {
        XSSFWorkbook workBook = new XSSFWorkbook();
        FileOutputStream output = new FileOutputStream("test4.xlsx");
        XSSFSheet sheet = workBook.createSheet("test4");
        XSSFRow rowHeader = sheet.createRow(0);
        XSSFCell cell0 = rowHeader.createCell(0);
        cell0.setCellValue("Name");
        XSSFCell cell1 = rowHeader.createCell(1);
        cell1.setCellValue("Age");
        XSSFCell cell2 = rowHeader.createCell(1);
        cell2.setCellValue("Total_Marks");

        for (int rowIndex=0;rowIndex<students.length;rowIndex++)
        {
            XSSFRow row = sheet.createRow(rowIndex+1);
            for (int cellIndex=0;cellIndex<students[0].length;cellIndex++)
            {
                    XSSFCell cell = row.createCell(cellIndex);
                    cell.setCellValue(students[rowIndex][cellIndex]);
                    System.out.print(students[rowIndex][cellIndex]+"           ");

                }
            System.out.println();


            }
        workBook.write(output);
        output.close();
        workBook.close();
        }

    }


    // row=sheet.createRow(0)

