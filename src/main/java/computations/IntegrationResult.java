package computations;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class IntegrationResult {

    private BigDecimal result;
    private long steps;
    private BigDecimal error;

}
