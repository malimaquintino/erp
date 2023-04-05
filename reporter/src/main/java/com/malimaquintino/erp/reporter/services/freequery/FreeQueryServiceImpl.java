package com.malimaquintino.erp.reporter.services.freequery;

import com.malimaquintino.erp.commonmslib.dto.report.ReportInputDto;
import com.malimaquintino.erp.reporter.exceptions.BadFormatQueryException;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Log4j2
@Service
public class FreeQueryServiceImpl implements FreeQueryService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void executeQuery(ReportInputDto inputDto) {
        try {
            if (validateQuery(inputDto.getQuery())) {
                StringBuilder sql = new StringBuilder(inputDto.getQuery());
                Query query = entityManager.createNativeQuery(sql.toString());
                List<String> fields = getSelectedFields(inputDto.getQuery());
                List<Object[]> queryResult = query.getResultList();
                Map<String, String> result = getResult(fields, queryResult);
                log.info("fields {}", fields);
                log.info("result {}", queryResult);
                log.info("result {}", result);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private Map<String, String> getResult(List<String> fields, List<Object[]> queryResult) {
        Map<String, String> result = new HashMap<>();
        queryResult.forEach(queryLine -> {
            String[] vals = (String[])queryLine;
            for(String field : fields) {
                result.put(field, vals[1]);
            }
        });
        return result;
    }

    private boolean validateQuery(String query) {
        String selectedFields = extractSelectedFields(query);
        if ("*".equalsIgnoreCase(selectedFields)) {
            throw new BadFormatQueryException();
        }
        return Boolean.TRUE;
    }

    private List<String> getSelectedFields(String query) {
        String selectedFields = extractSelectedFields(query);
        List<String> items = Arrays.asList(selectedFields.split("\\s*,\\s*"));
        return items;
    }

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
}
