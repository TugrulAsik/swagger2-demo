package tr.tugrul.swagger2demo.dto;

import lombok.Data;

@Data
public class DemoRequestDTO implements RequestDTO {

    private String newMessage;
}
