package hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main (String[] args) throws IOException {
        String filename = "C:\\Users\\Dell\\Desktop\\OOP.20232.20225495.PhanMinhHoa\\OtherProjects\\hust\\soict\\dsai\\garbage\\test.exe";
        byte[] inputBytes = { 0 };
        long startTime, endTime;

        inputBytes = Files.readAllBytes(Paths.get(filename));
        startTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (byte b : inputBytes) {
            sb.append((char)b);
        }
        String outputString = sb.toString();
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}
