package input.command;

import computations.InputData;
import input.InterruptCommandException;
import input.ReturnCommandException;

import java.util.Scanner;

public class ChooseLowerIntegrationLimitStage implements Stage {

    @Override
    public void execute(InputData data) throws InterruptCommandException, ReturnCommandException {
        System.out.println("Введите нижний предел интегрирования.");
        boolean passed = false;
        while (!passed) {
            Scanner scanner = Utils.getScanner();
            String answer = scanner.nextLine();

            checkControlCommand(answer);

            answer = answer.replace(',', '.');
            try {
                double lowerLimit = Double.parseDouble(answer);
                if (answer.trim().length() - (answer.contains(".") ? 1 : 0) > 12) {
                    System.out.println("Вы ввели значение верхнего предела больше 12 знаков. Это может сказаться на точности, пожалуйста, введите верхний предел с меньшим числом знаков.");
                    continue;
                }
                data.setLowerIntegrationLimit(lowerLimit);
                passed = true;
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели неизвестный ответ. Введите в качестве ответа одну десятичную дробь.");
            }
        }
    }

}
