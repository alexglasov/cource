package com.example.demo;

import com.example.demo.models.Transaction;
import com.sun.istack.NotNull;
import org.springframework.util.StringUtils;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionParser extends CsvParser {
    private static final String delimiter = ",";

    public static List<Transaction> parseTransactions(String path) throws FileNotFoundException {
        return parse(path)
                .map(TransactionParser::getTransaction)
                .collect(Collectors.toList());
    }

    private static Transaction getTransaction(
            @NotNull
            String line)
    {
        String[] stringValues = StringUtils.split(line, delimiter);
        Transaction transaction = new Transaction();

        transaction.setId(Long.parseLong(stringValues[0]));
        transaction.setCustomerId(Long.parseLong(stringValues[1]));
        transaction.setDatetime(stringValues[2]);
        transaction.setMccCode(Integer.parseInt(stringValues[3]));
        transaction.setType(Integer.parseInt(stringValues[4]));
        transaction.setAmount(Long.parseLong(stringValues[5]));
        transaction.setTermId(Long.parseLong(stringValues[6]));

        return transaction;
    }
}
