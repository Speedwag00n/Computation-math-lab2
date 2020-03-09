package input.command;

import computations.InputData;
import input.InterruptCommandException;
import input.ReturnCommandException;

import java.util.Scanner;

import static computations.RectangleMethodType.*;

public class ChooseTypeStage implements Stage {

    @Override
    public void execute(InputData data) throws InterruptCommandException, ReturnCommandException {
        System.out.println("Введите \"1\", если хотите использовать метод левых прямоугольников.");
        System.out.println("Введите \"2\", если хотите использовать метод правых прямоугольников.");
        System.out.println("Введите \"3\", если хотите использовать метод средних прямоугольников.");
        boolean passed = false;
        while (!passed) {
            Scanner scanner = Utils.getScanner();
            String answer = scanner.nextLine();

            checkControlCommand(answer);

            try {
                int answerNumber = Integer.parseInt(answer);
                switch (answerNumber) {
                    case 1:
                        data.setType(LEFT);
                        passed = true;
                        break;
                    case 2:
                        data.setType(RIGHT);
                        passed = true;
                        break;
                    case 3:
                        data.setType(MEDIUM);
                        passed = true;
                        break;
                    default:
                        System.out.println("Неизвестный номер ответа, пожалуйста, введите один из вариантов ответа, предложенных выше.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Неизвестный ответ, пожалуйста, введите один из вариантов ответа, предложенных выше.");
            }
        }
    }

}
