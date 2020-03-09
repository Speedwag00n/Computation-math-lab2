package computations;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static computations.RectangleMethodType.MEDIUM;

public class RectangleMethodCalculator {

    private InputData inputData;
    private boolean isLimitsSwapped;
    private BigDecimal lowerLimit;
    private BigDecimal upperLimit;

    public RectangleMethodCalculator(InputData inputData) {
        this.inputData = inputData;

        isLimitsSwapped = inputData.getLowerLimit().compareTo(inputData.getUpperLimit()) > 1;
        if (isLimitsSwapped) {
            lowerLimit = inputData.getUpperLimit();
            upperLimit = inputData.getLowerLimit();
        } else {
            lowerLimit = inputData.getLowerLimit();
            upperLimit = inputData.getUpperLimit();
        }
    }

    public IntegrationResult calculateIntegral() {
        if (lowerLimit == upperLimit) {
            IntegrationResult result = new IntegrationResult();
            result.setResult(BigDecimal.valueOf(0));
            result.setSteps(0);
            result.setError(BigDecimal.valueOf(0));

            return result;
        }

        long steps = 1;
        BigDecimal previousResult;
        BigDecimal currentResult = integrate(steps, inputData.getType());
        BigDecimal error;
        do {
            previousResult = currentResult;
            steps *= 2;
            currentResult = integrate(steps, inputData.getType());
            //Используем оценку Рунге
            error = currentResult
                    .subtract(previousResult)
                    .divide(BigDecimal.valueOf(inputData.getType() == MEDIUM ? 3 : 1), RoundingMode.HALF_EVEN)
                    .abs();
        } while (error.compareTo(inputData.getAccuracy()) == 1);

        IntegrationResult result = new IntegrationResult();
        if (isLimitsSwapped) {
            result.setResult(currentResult.multiply(BigDecimal.valueOf(-1)));
        } else {
            result.setResult(currentResult);
        }
        result.setSteps(steps);
        result.setError(error);

        return result;
    }

    private BigDecimal integrate(long steps, RectangleMethodType type) {
        BigDecimal sum = BigDecimal.valueOf(0);
        BigDecimal h = upperLimit
                .subtract(lowerLimit)
                .divide(BigDecimal.valueOf(steps));

        BigDecimal currentX;
        switch (type) {
            case LEFT:
                currentX = lowerLimit;
                for (double i = 0; i < steps; i++) {
                   sum = sum.add(h.multiply(inputData.getFunction().apply(currentX)));
                   currentX= currentX.add(h);
                }
                break;
            case RIGHT:
                currentX = upperLimit;
                for (double i = steps; i > 0; i--) {
                   sum = sum.add(h.multiply(inputData.getFunction().apply(currentX)));
                   currentX = currentX.subtract(h);
                }
                break;
            case MEDIUM:
                currentX = lowerLimit.add(h.divide(BigDecimal.valueOf(2)));
                for (double i = 0; i < steps; i++) {
                    sum = sum.add(h.multiply(inputData.getFunction().apply(currentX)));
                    currentX = currentX.add(h);
                }
                break;
       }

       return sum;
    }

}


