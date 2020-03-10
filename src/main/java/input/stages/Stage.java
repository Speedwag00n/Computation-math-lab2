package input.stages;

import computations.InputData;
import input.ReturnCommandException;
import input.InterruptCommandException;

public interface Stage {

    void execute(InputData data) throws InterruptCommandException, ReturnCommandException;

    default void checkControlCommand(String answer) throws InterruptCommandException, ReturnCommandException {
        if (Utils.isReturnCommand(answer)) {
            throw new ReturnCommandException();
        } else if (Utils.isInterruptCommand(answer)) {
            throw new InterruptCommandException();
        } else if (Utils.isExitCommand(answer)) {
            System.out.println("Завершение работы программы.");
            System.exit(0);
        }
    }

}
