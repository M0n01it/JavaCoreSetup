
public class ZipMain {
    public static void main(String[] args) {
        String zipFilePath = "D://Games/savegames/saves.zip";
        String outputFolderPath = "D://Games/savegames/";

        // Распаковка архивов
        ZipUtil.openZip(zipFilePath, outputFolderPath);

        // Путь к файлу сохраненной игры
        String saveFilePath = "D://Games/savegames/save2.dat";

        // Десериализация объекта сохраненной игры
        GameProgress gameProgress = ProgressUtil.openProgress(saveFilePath);

        // Вывод состояния сохраненной игры в консоль
        if (gameProgress != null) {
            System.out.println(gameProgress);
        } else {
            System.out.println("Не удалось загрузить сохраненную игру.");
        }
    }
}

