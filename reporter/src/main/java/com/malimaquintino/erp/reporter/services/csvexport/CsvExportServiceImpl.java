package com.malimaquintino.erp.reporter.services.csvexport;

import lombok.AllArgsConstructor;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class CsvExportServiceImpl implements CsvExportService {
    @Override
    public String generateFile(List<Map<String, String>> data) throws IOException {
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("Report");

        /* GENERATE FILE HEADER */
        var dataHeaders = data.get(0).keySet().stream().toList();
        Row header = sheet.createRow(0);

        for (int i = 0; i < dataHeaders.size(); i++) {
            Cell headerCell = header.createCell(i);
            headerCell.setCellValue(dataHeaders.get(i));
        }

        /* GENERATE DATA FILES */
        for (int i = 0; i < data.size(); i++) {
            Row dataValues = sheet.createRow(i + 1);
            int finalI = i;
            final int[] cellCount = {0};
            dataHeaders.forEach(headerText -> {
                Cell dataValuesCell = dataValues.createCell(cellCount[0]);
                dataValuesCell.setCellValue(data.get(finalI).get(headerText));
                cellCount[0]++;
            });
        }

        /* GENERATE FILE */
        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        String fileLocation = path.substring(0, path.length() - 1) + "REPORT-"+ LocalDateTime.now() +".xlsx";

        FileOutputStream outputStream = new FileOutputStream(fileLocation);
        workbook.write(outputStream);
        workbook.close();

        return fileLocation;
    }

}
