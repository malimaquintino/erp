package com.malimaquintino.erp.fakergenerator.mocks;

import com.github.javafaker.Faker;
import com.malimaquintino.erp.commonmslib.dto.address.AddressInputDto;
import com.malimaquintino.erp.commonmslib.dto.client.ClientInputDto;
import com.malimaquintino.erp.commonmslib.dto.email.EmailInputDto;
import com.malimaquintino.erp.commonmslib.dto.phone.PhoneInputDto;
import com.malimaquintino.erp.commonmslib.enums.BillPaymentMethod;
import com.malimaquintino.erp.commonmslib.enums.PersonType;
import lombok.experimental.UtilityClass;

import java.security.SecureRandom;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@UtilityClass
public class CustomerMock {
    public static Integer randomDueDay() {
        List<Integer> days = Arrays.asList(5, 20, 25);
        SecureRandom rand = new SecureRandom();
        return days.get(rand.nextInt(days.size()));
    }

    public static List<Long> randomProductList() {
        List<List<Long>> options = Arrays.asList(
                List.of(1L),
                List.of(2L),
                List.of(3L),
                List.of(4L),
                List.of(5L),
                Arrays.asList(1L, 3L),
                Arrays.asList(1L, 4L),
                Arrays.asList(2L, 3L),
                Arrays.asList(2L, 4L),
                Arrays.asList(1L, 3L, 5L),
                Arrays.asList(1L, 4L, 5L),
                Arrays.asList(2L, 3L, 5L),
                Arrays.asList(2L, 4L, 5L)
        );
        SecureRandom rand = new SecureRandom();
        return options.get(rand.nextInt(options.size()));
    }

    public static ClientInputDto getClient() {
        Faker faker = new Faker(new Locale("pt-BR"));
        return ClientInputDto.builder()
                .name(faker.name().fullName())
                .birth(faker.date().birthday().toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate())
                .personType(PersonType.PF)
                .document(faker.number().digits(11))
                .build();
    }

    public static AddressInputDto getAddress() {
        Faker faker = new Faker(new Locale("pt-BR"));
        return AddressInputDto.builder()
                .zipcode(faker.address().zipCode())
                .street(faker.address().streetAddress())
                .number(faker.number().digits(4))
                .neighborhood(faker.address().firstName())
                .city(faker.address().city())
                .state(faker.address().state())
                .complement("")
                .build();
    }

    public static EmailInputDto getEmail() {
        Faker faker = new Faker(new Locale("pt-BR"));
        return EmailInputDto.builder()
                .emailAddress(faker.internet().emailAddress())
                .observation("")
                .build();
    }

    public static PhoneInputDto getPhone() {
        Faker faker = new Faker(new Locale("pt-BR"));
        return PhoneInputDto.builder()
                .phoneNumber(faker.phoneNumber().phoneNumber())
                .observation("")
                .build();
    }

    public static BillPaymentMethod randomPaymentMethod() {
        String[] methods = {"MONEY", "BANK_SLIP", "PIX", "CREDIT_CARD", "DEBIT_CARD"};
        SecureRandom rand = new SecureRandom();
        return BillPaymentMethod.valueOf(methods[rand.nextInt(methods.length)]);
    }
}
