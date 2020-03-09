package computations.functions;

import java.math.BigDecimal;
import java.util.function.Function;

public class PolynomialFunction extends FunctionContainer {

    public PolynomialFunction() {
        super("2*x^2 + 3x + 5");
    }

    @Override
    public Function<BigDecimal, BigDecimal> getFunction() {
        return x -> x.multiply(x)
                .multiply(BigDecimal.valueOf(2))
                .add(x.multiply(BigDecimal.valueOf(3)))
                .add(BigDecimal.valueOf(5));
    }

}
