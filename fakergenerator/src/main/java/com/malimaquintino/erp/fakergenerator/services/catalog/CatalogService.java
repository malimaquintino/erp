package com.malimaquintino.erp.fakergenerator.services.catalog;

import com.malimaquintino.erp.commonmslib.dto.combo.ComboInputDto;
import com.malimaquintino.erp.commonmslib.dto.product.ProductInputDto;
import com.malimaquintino.erp.fakergenerator.requests.CatalogRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Arrays;

import static com.malimaquintino.erp.fakergenerator.mocks.CatalogMock.getProductType;

@Slf4j
@Service
@RequiredArgsConstructor
public class CatalogService {
    private final CatalogRequest catalogRequest;

//    @Bean
    private void generateFaker() {
        generateTypes();
        generateProduct();
        generateCombo();
    }

    private void generateTypes() {
        log.info("generate types");
        catalogRequest.createType(getProductType("Internet"));
        catalogRequest.createType(getProductType("TV"));
        catalogRequest.createType(getProductType("Telefone"));
    }

    private void generateProduct() {
        log.info("generate products");
        catalogRequest.createProduct(ProductInputDto.builder()
                .name("Internet 200")
                .description("Internet Fibra Optica 200MB")
                .productTypeId(1L)
                .price(99.9)
                .build());
        catalogRequest.createProduct(ProductInputDto.builder()
                .name("Internet 300")
                .description("Internet Fibra Optica 300MB")
                .productTypeId(1L)
                .price(129.9)
                .build());
        catalogRequest.createProduct(ProductInputDto.builder()
                .name("TV Pacote I")
                .description("Pacote I 25 canais")
                .productTypeId(2L)
                .price(69.9)
                .build());
        catalogRequest.createProduct(ProductInputDto.builder()
                .name("TV Pacote II")
                .description("Pacote II 35 canais")
                .productTypeId(2L)
                .price(89.9)
                .build());
        catalogRequest.createProduct(ProductInputDto.builder()
                .name("Telefone Fixo Brasil")
                .description("Telefone Fixo Brasil Ilimitado")
                .productTypeId(3L)
                .price(49.9)
                .build());
    }

    private void generateCombo() {
        log.info("generate combos");
        catalogRequest.createCombo(ComboInputDto.builder()
                .name("Combo Basico")
                .description("Internet Fibra 200mb + TV Pacote I 25 canais + Telefone Fixo")
                .productsIds(Arrays.asList(1L, 3L, 5L))
                .build());
        catalogRequest.createCombo(ComboInputDto.builder()
                .name("Combo Master")
                .description("Internet Fibra 300mb + TV Pacote II 35 canais + Telefone Fixo")
                .productsIds(Arrays.asList(2L, 4L, 5L))
                .build());
    }
}

