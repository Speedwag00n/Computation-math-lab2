package computations.functions;

import java.math.BigDecimal;
import java.util.function.Function;

public class XDivisionFunction extends FunctionContainer {

    public XDivisionFunction() {
        super("4/x");
    }

    @Override
    public Function<BigDecimal, BigDecimal> getFunction() {
        return x -> {
            if (x.compareTo(BigDecimal.ZERO) == 0) {
                throw new NotAllowableRangeException();
            }
            return BigDecimal.valueOf(4/x.doubleValue());
        };
    }

}
