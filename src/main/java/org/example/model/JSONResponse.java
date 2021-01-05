package org.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created with Intellij IDEA
 * Description:
 * User : 花朝
 * Date : 2020-12-26
 * Time : 11:41
 */
@Getter
@Setter
@ToString
public class JSONResponse {
    private boolean success;
    private String code;
    private String message;
    private Object data;
}
