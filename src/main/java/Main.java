import computations.InputData;
import computations.IntegrationResult;
import computations.RectangleMethodCalculator;
import computations.RectangleMethodType;
import computations.functions.FunctionsHandlerImpl;
import computations.functions.NotAllowableRangeException;
import input.InterruptCommandException;
import input.ReturnCommandException;
import input.command.*;
import output.ResultsPrinter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class Main {

    public static void main(String[] args) {
        boolean working = true;
        System.out.println(
                "Добро пожаловать в приложение для вычесления интегралов методом прямоугольников!\n" +
                        "Если вы захотите вернуться на предыдущий шаг, введите \"return\" или \"вернуться\".\n" +
                        "Если вы захотите начать ввод данных с нуля, введите \"cancel\" или \"отменить\".\n" +
                        "Если вы захотите выйти из приложения, то введите \"exit\" или \"выйти\"."
        );
        List<Stage> inputCommands = new ArrayList<>();
        inputCommands.add(new ChooseFunctionStage(new FunctionsHandlerImpl()));
        inputCommands.add(new ChooseTypeStage());
        inputCommands.add(new ChooseUpperIntegrationLimitStage());
        inputCommands.add(new ChooseLowerIntegrationLimitStage());
        inputCommands.add(new ChooseAccuracyStage());
        while (working) {
            InputData data = new InputData();
            try {
                int i = 0;
                while (i < inputCommands.size()) {
                    try {
                        inputCommands.get(i).execute(data);
                        i++;
                    } catch (ReturnCommandException e) {
                        if (i > 0) {
                            System.out.println("Возвращаемся на предыдущий шаг...");
                            i--;
                        } else {
                            System.out.println("Невозможно вернуться на шаг назад, так как это первый шаг.");
                        }
                    }
                }
                try {
                    RectangleMethodCalculator calculator = new RectangleMethodCalculator(data);
                    IntegrationResult result = calculator.calculateIntegral();

                    ResultsPrinter printer = new ResultsPrinter();
                    printer.print(result, data.getType(), data.getAccuracy().scale());
                } catch (NotAllowableRangeException e) {
                    System.out.println("Определенный интеграл не существует, так как введенный интервал не входит в область определения подынтегральной функции.");
                }
            } catch (NoSuchElementException e) {
                System.out.println("Завершение работы программы.");
                working = false;
            } catch (InterruptCommandException e) {
                System.out.println("Начинаем сначала...");
                continue;
            }
        }
    }

}
