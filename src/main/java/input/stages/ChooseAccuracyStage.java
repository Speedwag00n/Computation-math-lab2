package input.stages;

import computations.InputData;
import input.InterruptCommandException;
import input.ReturnCommandException;

import java.math.BigDecimal;
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
                BigDecimal accuracy = new BigDecimal(answer);
                if (answer.contains(".") && answer.trim().split("\\.")[1].length() > 8) {
                    System.out.println("Вы ввели для точности больше 8 знаков после запятой. Это может сказаться на длительности вычислений, пожалуйста, введите значение точности с меньшим числом знаков после запятой.");
                    continue;
                } else if (accuracy.compareTo(BigDecimal.ZERO) <= 0) {
                    System.out.println("Введенная точность меньше или равна 0. Пожалуйста, введите точность, которая будет больше 0.");
                    continue;
                }
                if (answer.contains(".")) {
                    accuracy.setScale(answer.trim().split("\\.")[1].length());
                }
                data.setAccuracy(accuracy);
                passed = true;
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели неизвестный ответ. Введите в качестве ответа одну десятичную дробь, большую 0.");
            }
        }
    }

}
