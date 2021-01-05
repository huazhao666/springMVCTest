package org.example.DaoController;

import org.example.model.Article;
import org.example.model.JSONResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA
 * Description:
 * User : 花朝
 * Date : 2021-01-05
 * Time : 17:06
 */
@RestController
@RequestMapping("/article")
public class ArticleController {
    @GetMapping("/articleList")
    public Object articleList(){
        List<Article> list = new ArrayList<>();
        Article article1 = new Article();
        article1.setId(1);
        article1.setTitle("马宝国");
        article1.setContent("耗子为之");
        Article article2 = new Article();
        article2.setId(2);
        article2.setTitle("马宝国1");
        article2.setContent("耗子为之1");
        Article article3 = new Article();
        article3.setId(3);
        article3.setTitle("马宝国2");
        article3.setContent("耗子为之1");
        list.add(article1);
        list.add(article2);
        list.add(article2);
        JSONResponse json = new JSONResponse();
        json.setSuccess(true);
        json.setData(list);
        return json;
     }
}
