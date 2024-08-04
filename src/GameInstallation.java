import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GameInstallation {

    public static void main(String[] args) {
        StringBuilder log = new StringBuilder();

        // Путь к папке Games
        String rootPath = "D:\\Games";

        String[] directories = {
                rootPath + "/src",
                rootPath + "/res",
                rootPath + "/savegames",
                rootPath + "/temp",
                rootPath + "/src/main",
                rootPath + "/src/test",
                rootPath + "/res/drawables",
                rootPath + "/res/vectors",
                rootPath + "/res/icons"
        };

        String[] files = {
                rootPath + "/src/main/Main.java",
                rootPath + "/src/main/Utils.java",
                rootPath + "/temp/temp.txt"
        };

        // Создание директорий
        for (String dirPath : directories) {
            File dir = new File(dirPath);
            if (dir.mkdirs()) {
                log.append("Директория создана: ").append(dirPath).append("\n");
            } else {
                log.append("Не удалось создать директорию: ").append(dirPath).append("\n");
            }
        }

        // Создание файлов
        for (String filePath : files) {
            File file = new File(filePath);
            try {
                if (file.createNewFile()) {
                    log.append("Файл создан: ").append(filePath).append("\n");
                } else {
                    log.append("Не удалось создать файл: ").append(filePath).append("\n");
                }
            } catch (IOException e) {
                log.append("Ошибка при создании файла: ").append(filePath).append("\n");
                log.append(e.getMessage()).append("\n");
            }
        }

        // Запись лога в файл temp.txt
        try (FileWriter writer = new FileWriter(new File(rootPath + "/temp/temp.txt"))) {
            writer.write(log.toString());
            System.out.println("Лог успешно записан в temp.txt");
        } catch (IOException e) {
            System.out.println("Ошибка при записи лога в temp.txt");
            e.printStackTrace();
        }
    }
}