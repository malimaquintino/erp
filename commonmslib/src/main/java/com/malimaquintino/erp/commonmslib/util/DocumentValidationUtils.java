package com.malimaquintino.erp.commonmslib.util;

import br.com.caelum.stella.validation.CNPJValidator;
import br.com.caelum.stella.validation.CPFValidator;
import com.google.common.base.Strings;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.swing.text.MaskFormatter;
import java.text.Normalizer;
import java.text.ParseException;

@Component
public class DocumentValidationUtils {
    private static final Logger LOGGER = LogManager.getLogger(DocumentValidationUtils.class);

    public Boolean isInvalidCpf(String cpf) {
        var cpfValidator = new CPFValidator();
        return Strings.isNullOrEmpty(cpf) || !cpfValidator.invalidMessagesFor(cpf).isEmpty();
    }

    public Boolean isInvalidCnpj(String cnpj) {
        var cnpjValidator = new CNPJValidator();
        return Strings.isNullOrEmpty(cnpj) || !cnpjValidator.invalidMessagesFor(cnpj).isEmpty();
    }

    public String cleanFormatting(String value) {
        return value.replaceAll("[^0-9]", "");
    }

    public String removeAccents(String value) {
        return Normalizer
                .normalize(value, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "");
    }

    public String formatCnpj(String cnpj) {
        try {
            MaskFormatter mask = new MaskFormatter("##.###.###/####-##");
            mask.setValueContainsLiteralCharacters(false);
            return mask.valueToString(cnpj);
        } catch (ParseException ex) {
            LOGGER.error(ex);
        }
        return cnpj;
    }

    public String getFileExtension(String filename) {
        if (filename.contains(".")) {
            return filename.substring(filename.lastIndexOf(".") + 1);
        }
        return "";
    }

    public String getFileNameWithOutExtension(String filename) {
        if (filename.contains(".")) {
            return filename.substring(0, filename.lastIndexOf("."));
        }
        return filename;
    }

    public static String removeAccent(String value) {
        return Normalizer
                .normalize(value, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "");
    }
}
