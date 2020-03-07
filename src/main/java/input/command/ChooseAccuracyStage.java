package input.command;

import computations.InputData;
import input.InterruptCommandException;
import input.ReturnCommandException;

import java.util.Scanner;

public class ChooseAccuracyStage implements Stage {

    @Override
    public void execute(InputData data) throws InterruptCommandException, ReturnCommandException {
        System.out.println("Введите точность интегрирования.");
        boolean passed = false;
        while (!passed) {
            Scanner scanner = Utils.getScanner();
            String answer = scanner.nextLine();

            checkControlCommand(answer);

            answer = answer.replace(',', '.');
            try {
                double accuracy = Double.parseDouble(answer);
                if (answer.trim().length() - (answer.contains(".") ? 1 : 0) > 15) {
                    System.out.println("Вы ввели для точности больше 15 знаков. Это может сказаться на точности, пожалуйста, введите значение точности с меньшим числом знаков.");
                    continue;
                } else if (accuracy <= 0) {
                    System.out.println("Введенная точность меньше или равна 0. Пожалуйста, введите точность, которая будет больше 0.");
                    continue;
                }
                data.setAccuracy(accuracy);
                passed = true;
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели неизвестный ответ. Введите в качестве ответа одну десятичную дробь, большую 0.");
            }
        }
    }

}
