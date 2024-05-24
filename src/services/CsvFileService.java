package services;

import java.util.List;
import java.util.Map;

public interface CsvFileService {

    boolean createItemsInCsvFile(Map<String, String> map);

    List<Map<String, String>> getAllRows(List<String> keys);

    List<Map<String, String>> getRandomRows(List<String> keys, int numberOfRows);

    List<Map<String, String>> getAllRowsByCondition(List<String> keys, Map<String, String> conditions);

    boolean updateAllRowsByCondition(List<String> keys, Map<String, String> conditions, Map<String, String> updatedValues);
}

