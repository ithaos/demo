package haos.demo.redis_cache.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private Integer age;
}
