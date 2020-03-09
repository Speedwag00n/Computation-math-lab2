package computations;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.function.Function;

@Getter
@Setter
public class InputData {

    private Function<BigDecimal, BigDecimal> function;
    private BigDecimal upperLimit;
    private BigDecimal lowerLimit;
    private BigDecimal accuracy;
    private RectangleMethodType type;

}
