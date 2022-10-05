package Utilities;

import io.cucumber.java.Scenario;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ExcelUtility {
    //kendisine verilen path deli excelin , istenilen sheetindeki
    // verilen kolon kadar bilgisini okuyup ArrayList formatında geri döndüren fonksiyonu yazacağız.
    public static void main(String[] args) {


        getListData("src/test/java/ExcelPath/beymen.xlsx", "Sayfa1", 2);


    }

    public static ArrayList<ArrayList<String>> getListData(String path, String sheet, int columnCount) {
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        Workbook wb = null;
        try {
            FileInputStream dosya = new FileInputStream(path);
            wb = WorkbookFactory.create(dosya);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Sheet st = wb.getSheet(sheet);


        for (int i = 0; i < st.getPhysicalNumberOfRows(); i++) {


            ArrayList<String> satirData = new ArrayList<>();
            for (int j = 0; j < columnCount; j++) {
                satirData.add(st.getRow(i).getCell(j).toString());

            }
            list.add(satirData);

        }

        System.out.println(list);

        return list;
    }

    public static void WriteExcellReport(String path, Scenario scenario, String browserType, String time) {

        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet st = wb.createSheet("rapor");
        Row row = st.createRow(0);


        Cell cell = row.createCell(0);
        cell.setCellValue(scenario.getId());

        cell = row.createCell(1);
        cell.setCellValue(scenario.getStatus().toString());

        cell = row.createCell(2);
        cell.setCellValue(browserType);

        cell = row.createCell(3);
        cell.setCellValue(time);


        try {
            FileOutputStream yazma = new FileOutputStream(path);
            wb.write(yazma);
            yazma.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        System.out.println("Islem bitti");


    }


}
