package haos.demo.redis_demo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Model {
    private String name;
    private String age;
}
