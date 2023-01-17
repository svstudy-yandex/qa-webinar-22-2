import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Булева логика
        //booleanLogic();
        System.out.println();

        // чтение из файла
        List<String> lines = readFileContents("resources/m.202101.csv");

        for (String line : lines) {
            System.out.println(line);
            String[] lineContents = line.split(",");

            MonthLine monthLine = new MonthLine(lineContents[0]);
        }

    }

    static List<String> readFileContents(String path) {
        try {
            Path p = Path.of(path);
            System.out.println(p.getFileName());
            System.out.println(p.getName(0));
            return Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно файл не находится в нужной директории.");
            return Collections.emptyList();
        }
    }

    static void booleanLogic() {
        Scanner scanner = new Scanner(System.in);
        boolean a = scanner.nextBoolean();
        boolean b = scanner.nextBoolean();
        boolean c = scanner.nextBoolean();

        System.out.println(!!a == a);

        System.out.println((a && false) == false);
        System.out.println((a || true) == true);

        System.out.println((a && (b || c)) == (a && b || a && c));
        System.out.println((a || (b && c)) == ((a || b) && (a || c)));

        System.out.println(!(a && b) == (!a || !b));
        System.out.println(!(a || b) == (!a && !b));
    }
}

