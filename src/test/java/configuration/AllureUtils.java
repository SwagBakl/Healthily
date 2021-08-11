package configuration;

import io.qameta.allure.Allure;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AllureUtils {

    public static void addAllureAttachment(String pathToFile, String nameOfAttach) {
        Path content = Paths.get(pathToFile);
        try(InputStream is = Files.newInputStream(content)) {
            Allure.addAttachment(nameOfAttach, is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
