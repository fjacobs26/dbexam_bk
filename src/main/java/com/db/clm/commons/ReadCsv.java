package com.db.clm.commons;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import com.db.clm.model.Nace;

public class ReadCsv {
	static String TYPE = "text/csv";
	static String[] HEADERs = { "Id", "Title", "Description", "Published" };

	public static boolean isCsv(MultipartFile file) {
		if (!TYPE.contains(file.getContentType())) {
			return false;
		}
		return true;
	}

	public static List<Nace> csvToTutorials(InputStream is) {
		try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				CSVParser csvParser = new CSVParser(fileReader,
						CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

			List<Nace> tutorials = new ArrayList<Nace>();

			Iterable<CSVRecord> csvRecords = csvParser.getRecords();

			for (CSVRecord csvRecord : csvRecords) {
				Nace tutorial = new Nace(
						Long.parseLong(csvRecord.get("orden")),
						Integer.parseInt(csvRecord.get("level")),
						csvRecord.get("code"),
						csvRecord.get("parent"),
						csvRecord.get("description"),
						csvRecord.get("item_description"),
						csvRecord.get("item_extra"),
						csvRecord.get("rulings"),
						csvRecord.get("item_exclude"),
						csvRecord.get("isic_reference")
				);
				tutorials.add(tutorial);
			}

			return tutorials;
		} catch (IOException e) {
			throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
		}
	}
}
