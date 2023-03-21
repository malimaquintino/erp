package com.malimaquintino.erp.financialworker.reader;

import com.malimaquintino.erp.commonmslib.dto.bill.BillInputDtoV2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.PagingQueryProvider;
import org.springframework.batch.item.database.builder.JdbcPagingItemReaderBuilder;
import org.springframework.batch.item.database.support.SqlPagingQueryProviderFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import javax.sql.DataSource;

import static com.malimaquintino.erp.commonmslib.util.DateUtils.nowPlusDays;

@Slf4j
@Configuration
public class BillReader {

    @Bean
    public JdbcPagingItemReader<BillInputDtoV2> createBillReader(
            @Qualifier("appDataSource") DataSource dataSource,
            @Qualifier("queryProviderCreateBill") PagingQueryProvider pagingQueryProvider) {
        return new JdbcPagingItemReaderBuilder<BillInputDtoV2>()
                .name("createBillReader")
                .dataSource(dataSource)
                .queryProvider(pagingQueryProvider)
                .pageSize(100)
                .rowMapper(new BeanPropertyRowMapper<>(BillInputDtoV2.class))
                .build();
    }

    @Bean
    public SqlPagingQueryProviderFactoryBean queryProviderCreateBill(@Qualifier("appDataSource") DataSource dataSource) {
        SqlPagingQueryProviderFactoryBean queryProvider = new SqlPagingQueryProviderFactoryBean();
        Integer dueDay = nowPlusDays(10).getDayOfMonth();
        dueDay = 25;
        log.info("Bill customers of the day {}", dueDay);

        queryProvider.setDataSource(dataSource);
        queryProvider.setSelectClause("select " +
                "c.id as \"c.id\", " +
                "c.id as contractId, " +
                "c2.id as customerId, " +
                "c2.name as customerName, " +
                "c2.document as customerDocument, " +
                "c.due_day as dueDay, " +
                "c.total as total, " +
                "c.payment_method as paymentMethod ");
        queryProvider.setFromClause("from customer.contract c " +
                "join customer.client c2 on c.client_id = c2.id");
        queryProvider.setWhereClause("where due_day = " + dueDay);
        queryProvider.setSortKey("c.id");

        return queryProvider;
    }
}
