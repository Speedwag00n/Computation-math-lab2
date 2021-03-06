package computations.functions;

import java.math.BigDecimal;
import java.util.function.Function;

public class NaturalLogarithmFunction extends FunctionContainer {

    public NaturalLogarithmFunction() {
        super("ln(x)");
    }

    @Override
    public Function<BigDecimal, BigDecimal> getFunction() {
        return x -> {
            if (x.compareTo(BigDecimal.ONE) <= 0) {
                throw new NotAllowableRangeException();
            }
            return BigDecimal.valueOf(Math.log(x.doubleValue()));
        };
    }

}
