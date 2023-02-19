package test;

import org.testng.annotations.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileDemoText {

    @Test
    public void readFromFileTest() throws IOException {
        Path filePath;
        filePath = Paths.get("src/test/resources/file_for_demo");
        String fileContent = null;
        fileContent = new String(Files.readAllBytes(filePath));
        System.out.println((fileContent));
    }

    @Test
    public void bufferedReader() throws IOException {
        String file = "src/test/resources/file_for_demo";
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String currentLine = reader.readLine();
        reader.close();
        System.out.println(currentLine);
    }

    @Test
    public void createFileTest() throws IOException {
        Path path = Paths.get("src/test/resources/file_for_demo_2");
        Files.createFile(path);
    }

    @Test
    public void writeToFile() throws IOException {
        Path filePath;
        filePath = Paths.get("src/test/resources/file_for_demo");
       // Files.write(filePath, (System.lineSeparator() + "Text").getBytes(StandardCharsets.UTF_8));
        Files.write(
                Paths.get("src/test/resources/file_for_demo"),
                "\r\nTest".getBytes(), StandardOpenOption.APPEND);
    }
    @Test
    public void bufferedWriter() throws IOException {
        FileWriter fw = new FileWriter("src/test/resources/file_for_demo", true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.newLine();
        bw.write("New Text");
        bw.newLine();
        bw.close();
    }
    @Test
    public void deleteFileTest() throws IOException {
        Path path = Paths.get("src/test/resources/file_for_demo_2");
        Files.delete(path);
    }
}

