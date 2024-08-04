import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Создание объектов GameProgress
        GameProgress game1 = new GameProgress(100, 2, 10, 50.5);
        GameProgress game2 = new GameProgress(80, 3, 15, 120.2);
        GameProgress game3 = new GameProgress(60, 1, 5, 200.45);

        // Папка для сохранений
        String savePath = "D://Games/savegames/";

        // Сохранение объектов
        SaveAndZip.saveGame(savePath + "save1.dat", game1);
        SaveAndZip.saveGame(savePath + "save2.dat", game2);
        SaveAndZip.saveGame(savePath + "save3.dat", game3);

        // Список файлов для архивации
        List<String> filesToZip = Arrays.asList(
                savePath + "save1.dat",
                savePath + "save2.dat",
                savePath + "save3.dat"
        );

        // Архивация файлов
        String zipFilePath = savePath + "saves.zip";
        SaveAndZip.zipFiles(zipFilePath, filesToZip);

        // Удаление оригинальных файлов
        SaveAndZip.deleteFiles(filesToZip);

    }

}