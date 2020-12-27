package tr.tugrul.swagger2demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseRestResponse<M, D, E> implements ResponseDTO {

    private M meta;
    private D data;
    private E errors;
}
