package input.stages;

import computations.InputData;
import computations.functions.FunctionsHandler;
import input.ReturnCommandException;
import input.InterruptCommandException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Getter
@Setter
@AllArgsConstructor
public class ChooseFunctionStage implements Stage {

    private FunctionsHandler functionsHandler;

    @Override
    public void execute(InputData data) throws InterruptCommandException, ReturnCommandException {
        System.out.println("Введите цифру, соответствующую номеру функции, интеграл который вы хотели бы вычислить:");
        for (int i = 0; i < functionsHandler.getFunctions().size(); i++) {
            System.out.println(i + 1 + ") " + functionsHandler.getFunctions().get(i).getDescription());
        }
        boolean passed = false;
        while (!passed) {
            Scanner scanner = Utils.getScanner();
            String answer = scanner.nextLine();

            checkControlCommand(answer);

            try {
                int answerNumber = Integer.parseInt(answer);
                if (answerNumber >= 1 && answerNumber <= functionsHandler.getFunctions().size()) {
                    data.setFunction(functionsHandler.getFunctions().get(answerNumber - 1).getFunction());
                    passed = true;
                } else {
                    System.out.println("Неизвестный номер ответа, пожалуйста, введите один из вариантов ответа, предложенных выше.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Неизвестный ответ, пожалуйста, введите один из вариантов ответа, предложенных выше.");
            }
        }
    }

}
