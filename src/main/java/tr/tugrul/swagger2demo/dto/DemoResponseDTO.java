package tr.tugrul.swagger2demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DemoResponseDTO implements ResponseDTO {

    private Long id;
    private String someStr;
    private BigDecimal someCurrencyField;
    private Object someObj;
    private Boolean demo;
}
