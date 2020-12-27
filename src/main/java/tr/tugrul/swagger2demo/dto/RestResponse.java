package tr.tugrul.swagger2demo.dto;

import lombok.Data;

import java.util.Map;

@Data
public class RestResponse<D> extends BaseRestResponse<Map, D, Map> {

    public static RestResponse newInstance() {
        return new RestResponse();
    }

    public RestResponse ok(D data) {
        this.setData(data);
        return this;
    }
}
