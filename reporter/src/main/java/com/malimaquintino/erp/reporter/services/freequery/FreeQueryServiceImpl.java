package com.malimaquintino.erp.reporter.services.freequery;

import com.malimaquintino.erp.commonmslib.dto.common.CommonResponse;
import com.malimaquintino.erp.commonmslib.dto.report.ReportInputDto;
import com.malimaquintino.erp.reporter.exceptions.BadFormatQueryException;
import com.malimaquintino.erp.reporter.responses.ReportResponse;
import com.malimaquintino.erp.reporter.services.csvexport.CsvExportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.malimaquintino.erp.commonmslib.dto.common.CommonResponse.convertThrowableToCommonResponse;

@Log4j2
@Service
@RequiredArgsConstructor
public class FreeQueryServiceImpl implements FreeQueryService {

    private final CsvExportService csvExportService;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public CommonResponse<?> getQueryData(ReportInputDto inputDto) {
        try {
            return ReportResponse.found(executeQuery(inputDto));
        } catch (Exception e) {
            return convertThrowableToCommonResponse(e);
        }
    }

    @Override
    public CommonResponse<?> generateFile(ReportInputDto inputDto) {
        try {
            List<Map<String, String>> data = executeQuery(inputDto);
            String filePath = csvExportService.generateFile(data);
            return ReportResponse.fileGenerate(filePath);
        } catch (Exception e) {
            return convertThrowableToCommonResponse(e);
        }
    }

    private List<Map<String, String>> executeQuery(ReportInputDto inputDto) {
        validateQuery(inputDto.getQuery());
        Query query = entityManager.createNativeQuery(inputDto.getQuery());
        List<String> fields = getSelectedFields(cleanQuery(inputDto.getQuery()));
        return getResult(fields, query.getResultList());
    }

    private List<Map<String, String>> getResult(List<String> fields, List<Object[]> queryResult) {
        List<Map<String, String>> listResult = new ArrayList<>();

        for (Object o : queryResult) {
            Map<String, String> result = new HashMap<>();
            for (int i = 0; i < fields.size(); i++) {
                result.put(fields.get(i), ((Object[]) o)[i].toString());
            }
            listResult.add(result);
        }
        return listResult;
    }

    /**
     * VALIDATE IF QUERY IS IN ALLOWED FORMAT
     * > UNABLE TO PERFORM SELECT * FROM, MUST EXPLICIT THE SELECTED FIELDS
     *
     * @param query
     * @return
     */
    private boolean validateQuery(String query) {
        String selectedFields = extractSelectedFields(query);
        if ("*".equalsIgnoreCase(selectedFields)) {
            throw new BadFormatQueryException();
        }
        return Boolean.TRUE;
    }

    /**
     * TRANSFORM ALL STRING FIELDS IN ARRAY
     *
     * @param query
     * @return
     */
    private List<String> getSelectedFields(String query) {
        List<String> fields = new ArrayList<>();
        String selectedFields = extractSelectedFields(query);
        List<String> items = Arrays.asList(selectedFields.split("\\s*,\\s*"));

        /* CHECK IF EACH FIELD HAS ALIAS */
        items.forEach(field -> {
            fields.add(getFieldAlias(field));
        });

        return fields;
    }

    /**
     * GET AL FIELDS BETWEEN THE WORDS SELECT AND FROM
     *
     * @param query
     * @return
     */
    private String extractSelectedFields(String query) {
        Pattern r = Pattern.compile("SELECT(.*)FROM", Pattern.CASE_INSENSITIVE);
        Matcher m = r.matcher(query.trim());
        String selectFields = "";

        if (m.find()) {
            selectFields = m.group(1).trim();
        } else {
            throw new BadFormatQueryException();
        }
        return selectFields;
    }

    /**
     * CHECK IF SELECTED HAS ALIAS, IF HAS RETURN THE ALIAS IF NOT RETURN ORIGINAL TEXT
     *
     * @param field
     * @return
     */
    private String getFieldAlias(String field) {
        String pattern = "\\s(.*)";
        if (field.toLowerCase().contains("as")) {
            pattern = "AS (.*)";
        }
        Pattern r = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
        Matcher m = r.matcher(field.trim());
        String alias = field;

        if (m.find()) {
            alias = m.group(1).trim();
        }
        return alias;
    }

    private String cleanQuery(String query) {
        query = query.replace("\"", "");
        return query.trim();
    }
}
