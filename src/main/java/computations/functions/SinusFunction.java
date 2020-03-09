package computations.functions;

import java.math.BigDecimal;
import java.util.function.Function;

public class SinusFunction extends FunctionContainer {

    public SinusFunction() {
        super("5*sin(x)");
    }

    @Override
    public Function<BigDecimal, BigDecimal> getFunction() {
        return x -> BigDecimal.valueOf(5 * Math.sin(x.doubleValue()));
    }

}
