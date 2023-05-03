package com.malimaquintino.erp.reporter.services.csvexport;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface CsvExportService {
    String generateFile(List<Map<String, String>> data) throws IOException;
}
