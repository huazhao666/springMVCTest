package org.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created with Intellij IDEA
 * Description:
 * User : 花朝
 * Date : 2021-01-05
 * Time : 17:02
 */
@Setter
@Getter
@ToString
public class Article {
    private  Integer id ;
    private  String title ;
    private  String content;


    /*private Integer userId;
    private Date createTime;
    private  Integer viewCount;*/
}
