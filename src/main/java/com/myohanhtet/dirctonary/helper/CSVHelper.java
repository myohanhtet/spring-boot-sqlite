package com.myohanhtet.dirctonary.helper;
import com.myohanhtet.dirctonary.model.Dictionary;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVHelper {

    public static String TYPE = "text/csv";

    static String[] HEADERs = {"id", "word","state","def"};

    public static boolean hasCSVFormat(MultipartFile file){
        if (!TYPE.equals(file.getContentType())){
            return false;
        }
        return true;
    }

    public static List<Dictionary> csvToDictionary(InputStream is) {
        try(BufferedReader filereader = new BufferedReader(new InputStreamReader(is,"UTF-8"));
            CSVParser csvParser = new CSVParser(filereader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
        ) {
            List<Dictionary> dictionaries =new ArrayList<Dictionary>();
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords){
                Dictionary dictionary = new Dictionary(
                        csvRecord.get("word"),
                        csvRecord.get("state"),
                        csvRecord.get("def")
                );
                dictionaries.add(dictionary);
            }
            return dictionaries;
        } catch (IOException e){
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }

    }
}