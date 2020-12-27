package tr.tugrul.swagger2demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.tugrul.swagger2demo.dto.DemoResponseDTO;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1")
public class DemoController {

    @GetMapping("/hello-swagger2-str")
    public String helloSwagger2() {
        return "Swagger2 Hello World!";
    }

    @GetMapping("/hello-swagger2-obj")
    public DemoResponseDTO helloSwagger2Object() {
        return DemoResponseDTO.builder()
                .id(1L)
                .demo(Boolean.TRUE)
                .someCurrencyField(new BigDecimal("123.0323"))
                .someStr("Swagger2 Hello World!")
                .someObj(DemoResponseDTO.builder().someStr("Inner obj").build())
                .build();
    }
}
