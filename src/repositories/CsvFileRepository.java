import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import services.CsvFileService;

public class CsvFileRepository implements CsvFileService {
    private final String fileName;

    public CsvFileRepository(String fileName) {
        this.fileName = fileName;
    }

    private boolean createCsvFileIfDoesNotExist() {
        try {
            // Check if file exists
            if (!new File(fileName).exists()) {
                // Create the file
                boolean isFileCreated = new File(fileName).createNewFile();
                // If file creation failed, exit
                if (!isFileCreated) {
                    System.out.println("File creation failed");
                    return false;
                }
                // If file creation successful, initialize it with a blank line
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                    writer.write("\n");
                }
            }
            return true;
        } catch (IOException ex) {
            System.out.println("File creation failed. Exception occurred");
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean createItemsInCsvFile(Map<String, String> map) {
        try {
            // Create CSV file if does not exist
            boolean doesFileExist = createCsvFileIfDoesNotExist();
            if (!doesFileExist) {
                return false;
            }

            // Append new data to CSV file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
                StringBuilder sb = new StringBuilder();
                for (Entry<String, String> entry : map.entrySet()) {
                    sb.append(entry.getValue()).append(",");
                }
                sb.deleteCharAt(sb.length() - 1); // Remove the last comma
                writer.write(sb.toString() + "\n");
            }

            return true;
        } catch (IOException ex) {
            System.out.println("CSV file update failed. Exception occurred.");
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public List<Map<String, String>> getAllRows(List<String> keys) {
        try {
            // Create CSV file if does not exist
            boolean doesFileExist = createCsvFileIfDoesNotExist();
            if (!doesFileExist) {
                return null;
            }

            // Read data from CSV file
            List<Map<String, String>> output = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] values = line.split(",");
                    Map<String, String> row = new HashMap<>();
                    for (int i = 0; i < keys.size(); i++) {
                        if (i < values.length) {
                            row.put(keys.get(i), values[i]);
                        }
                    }
                    output.add(row);
                }
            }

            return output;
        } catch (IOException ex) {
            System.out.println("CSV file retrieval failed. Exception occurred.");
            System.out.println(ex.getMessage());
            return null;
        }
    }

    // Implement other methods as needed

    @Override
    public List<Map<String, String>> getRandomRows(List<String> keys, int numberOfRows) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Map<String, String>> getAllRowsByCondition(List<String> keys, Map<String, String> conditions) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean updateAllRowsByCondition(List<String> keys, Map<String, String> conditions, Map<String, String> updatedValues) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

