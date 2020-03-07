package input.command;

import computations.InputData;
import input.InterruptCommandException;
import input.ReturnCommandException;

import java.util.Scanner;

public class ChooseUpperIntegrationLimitStage implements Stage {

    @Override
    public void execute(InputData data) throws InterruptCommandException, ReturnCommandException {
        System.out.println("Введите верхний предел интегрирования.");
        boolean passed = false;
        while (!passed) {
            Scanner scanner = Utils.getScanner();
            String answer = scanner.nextLine();

            checkControlCommand(answer);

            answer = answer.replace(',', '.');
            try {
                double upperLimit = Double.parseDouble(answer);
                if (answer.trim().length() - (answer.contains(".") ? 1 : 0) > 12) {
                    System.out.println("Вы ввели значение нижнего предела больше 12 знаков. Это может сказаться на точности, пожалуйста, введите нижний предел с меньшим числом знаков.");
                    continue;
                }
                data.setUpperIntegrationLimit(upperLimit);
                passed = true;
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели неизвестный ответ. Введите в качестве ответа одну десятичную дробь.");
            }
        }
    }

}
