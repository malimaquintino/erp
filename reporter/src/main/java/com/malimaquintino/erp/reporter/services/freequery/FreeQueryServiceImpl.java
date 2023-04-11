package com.malimaquintino.erp.reporter.services.freequery;

import com.malimaquintino.erp.commonmslib.dto.common.CommonResponse;
import com.malimaquintino.erp.commonmslib.dto.report.ReportInputDto;
import com.malimaquintino.erp.reporter.exceptions.BadFormatQueryException;
import com.malimaquintino.erp.reporter.responses.ReportResponse;
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
public class FreeQueryServiceImpl implements FreeQueryService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public CommonResponse<?> executeQuery(ReportInputDto inputDto) {
        try {
            validateQuery(inputDto.getQuery());
            Query query = entityManager.createNativeQuery(inputDto.getQuery());
            List<String> fields = getSelectedFields(inputDto.getQuery());
            List result = getResult(fields, query.getResultList());
            return ReportResponse.found(result);

        } catch (Exception e) {
            return convertThrowableToCommonResponse(e);
        }
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
