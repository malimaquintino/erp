package com.malimaquintino.erp.customer.specification;

import com.malimaquintino.erp.commonmslib.util.StringUtils;
import com.malimaquintino.erp.customer.models.Client;
import com.malimaquintino.erp.customer.models.Contract;
import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Join;
import java.text.MessageFormat;
import java.util.Objects;

@UtilityClass
public class ContractSpecification {
    private static final String LIKE_PATTERN = "%{0}%";
    private static final String ID = "id";
    private static final String DUE_DAY = "dueDay";
    private static final String CLIENT = "client";
    private static final String CLIENT_NAME = "name";
    private static final String CLIENT_DOCUMENT = "document";


    public static Specification<Contract> idEquals(Long expression) {
        if (Objects.isNull(expression)) {
            return null;
        }

        return ((root, query, builder) -> builder.equal(root.get(ID), expression));
    }

    public static Specification<Contract> dueDayEquals(Integer expression) {
        if (Objects.isNull(expression)) {
            return null;
        }

        return ((root, query, builder) -> builder.equal(root.get(DUE_DAY), expression));
    }

    public static Specification<Contract> clientNameLike(String expression) {
        if (expression == null) {
            return null;
        }

        return (root, query, builder) -> {
            final Join<Contract, Client> clientJoin = root.join(CLIENT);
            return builder.or(
                    builder.like(builder.lower(clientJoin.get(CLIENT_NAME)), MessageFormat.format(LIKE_PATTERN, expression.toLowerCase())),
                    builder.like(builder.lower(clientJoin.get(CLIENT_NAME)), builder.literal(expression.toLowerCase())),
                    builder.like(builder.lower(clientJoin.get(CLIENT_NAME)), MessageFormat.format(LIKE_PATTERN, StringUtils.stripAccents(expression.toLowerCase()))),

                    builder.like(builder.lower(clientJoin.get(CLIENT_NAME)), MessageFormat.format(LIKE_PATTERN, expression.toLowerCase())),
                    builder.like(builder.lower(clientJoin.get(CLIENT_NAME)), builder.literal(expression.toLowerCase())),
                    builder.like(builder.lower(clientJoin.get(CLIENT_NAME)), MessageFormat.format(LIKE_PATTERN, StringUtils.stripAccents(expression.toLowerCase())))
            );
        };
    }

    public static Specification<Contract> clientDocumentLike(String expression) {
        if (expression == null) {
            return null;
        }

        return (root, query, builder) -> {
            final Join<Contract, Client> clientJoin = root.join(CLIENT);
            return builder.or(
                    builder.like(builder.lower(clientJoin.get(CLIENT_DOCUMENT)), MessageFormat.format(LIKE_PATTERN, StringUtils.onlyNumbers(expression)))
            );
        };
    }
}
