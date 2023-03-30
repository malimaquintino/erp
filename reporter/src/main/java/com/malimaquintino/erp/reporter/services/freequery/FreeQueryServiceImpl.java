package com.malimaquintino.erp.reporter.services.freequery;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.Map;

@Log4j2
@Service
public class FreeQueryServiceImpl implements FreeQueryService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void executeQuery() {
        Map<String, Object> params = new HashMap<>();
        StringBuilder sql = new StringBuilder("select * from catalog.combo");

        Query query = entityManager.createNativeQuery(sql.toString(), Object.class);
        for (Map.Entry<String, Object> param : params.entrySet()) {
            query.setParameter(param.getKey(), param.getValue());
        }
        log.info(query.getResultList());
    }
}
