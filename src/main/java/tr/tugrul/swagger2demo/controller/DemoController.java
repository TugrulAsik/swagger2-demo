package tr.tugrul.swagger2demo.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.tugrul.swagger2demo.dto.DemoRequestDTO;
import tr.tugrul.swagger2demo.dto.DemoResponseDTO;
import tr.tugrul.swagger2demo.dto.RestResponse;

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

    @PostMapping("/hello-swagger2-obj")
    public DemoResponseDTO helloSwagger2ObjectPost(@RequestBody DemoRequestDTO requestDTO) {
        return DemoResponseDTO.builder()
                .id(1L)
                .demo(Boolean.TRUE)
                .someCurrencyField(new BigDecimal("123.0323"))
                .someStr(requestDTO.getNewMessage())
                .someObj(DemoResponseDTO.builder().someStr("Inner obj").build())
                .build();
    }

    @GetMapping("/hello-swagger2-generic")
    public RestResponse<DemoResponseDTO> helloSwaggerGenerics() {
        DemoResponseDTO responseDTO = DemoResponseDTO.builder()
                .id(2L)
                .demo(Boolean.TRUE)
                .someCurrencyField(new BigDecimal("999.123"))
                .someStr("Swagger2 generic Hello World!")
                .build();

        return RestResponse.newInstance()
                .ok(responseDTO);
    }

    @GetMapping("/hello-swagger2-response-entity")
    public ResponseEntity<DemoResponseDTO> helloSwaggerResponseEntity() {
        DemoResponseDTO responseDTO = DemoResponseDTO.builder()
                .id(3L)
                .demo(Boolean.TRUE)
                .someCurrencyField(new BigDecimal("323.123"))
                .someStr("Swagger2 response entity Hello World!")
                .build();

        return ResponseEntity.ok(responseDTO);
    }


    @ApiOperation(value = "Say hellow world!")
    @ApiResponse(code = 200, message = "Say hellow world!", responseContainer = "data", response = RestResponse.class)
    @GetMapping("/hello-swagger2-api-ops")
    public RestResponse<DemoResponseDTO> helloSwaggerApiOps() {
        DemoResponseDTO responseDTO = DemoResponseDTO.builder()
                .id(4L)
                .demo(Boolean.TRUE)
                .someCurrencyField(new BigDecimal("999.123"))
                .someStr("Swagger2 generic Hello World!")
                .build();

        return RestResponse.newInstance()
                .ok(responseDTO);
    }
}
