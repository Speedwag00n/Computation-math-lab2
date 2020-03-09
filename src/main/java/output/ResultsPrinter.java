package output;

import computations.IntegrationResult;
import computations.RectangleMethodType;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ResultsPrinter {

    public void print(IntegrationResult result, RectangleMethodType type, int scale) {
        System.out.println();
        System.out.println("----------------------");
        switch (type) {
            case LEFT:
                System.out.println("Результаты вычисления методом левых прямоугольников: ");
                break;
            case RIGHT:
                System.out.println("Результаты вычисления методом правых прямоугольников: ");
                break;
            case MEDIUM:
                System.out.println("Результаты вычисления методом средних прямоугольников: ");
                break;
        }
        printResult(result, scale);
    }

    private void printResult(IntegrationResult result, int scale) {
        System.out.println("Вычисленное значение определенного интеграла: " + result.getResult().setScale(scale + 1, RoundingMode.HALF_UP));
        System.out.println("Количество разбиений: " + result.getSteps());
        System.out.println("Погрешность: " + result.getError().setScale(scale + 1, BigDecimal.ROUND_HALF_UP));
        System.out.println("----------------------");
        System.out.println();
    }

}
