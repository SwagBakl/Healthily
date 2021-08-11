package utils;

import org.apache.commons.csv.CSVParser;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CsvReaderUtil {

    public static void main(String[] args) {
//        readCsv();
        readCsvFile();
    }
    static String path = "src/test/resources/testData.csv";

    public static String getRowValue(String property) {
//        List<String> csvDataList = new ArrayList<>();
        String prop = null;
        try(BufferedReader br = new BufferedReader(new FileReader(path));
            CSVParser parser = CSVFormat.DEFAULT.withDelimiter(',').withHeader().parse(br);){
            for(CSVRecord record : parser) {
                prop = record.get(property);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prop;
    }

    public static List<String[]> readCsvFile() {
        List<String[]> r = null;
        try (CSVReader reader = new CSVReader(new FileReader(path))) {
            r = reader.readAll();
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return r;
    }
}
