package theoni.initoyaml;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.yaml.snakeyaml.DumperOptions;

public class IniToYamlConverter {

    public static void main(String[] args) throws IOException {

        String inputFilePath = "input.ini";
        String outputFilePath = "output.yml";

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(inputFilePath));
        } catch (FileNotFoundException e) {
            System.out.println("To convert the file, place the file named 'input.ini' in the program folder.");
            System.exit(0);
        }

        DumperOptions options = new DumperOptions();
        options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);

        FileWriter writer = new FileWriter(outputFilePath);

        String line;
        while ((line = reader.readLine()) != null) {
            String[] keyValue = line.split("=", 2);
            if (keyValue.length == 2) {
                String key = keyValue[0].trim();
                String value = keyValue[1].trim();
                writer.write(key + ": \"" + value + "\"\n");
            }
        }

        reader.close();
        writer.close();

        System.out.println("Conversion complete.");
    }
}

