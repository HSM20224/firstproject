package com.example.firstproject.controller;


import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j //로깅을 위한 골뱅이(어노테이션)
public class ArticleController {

    @Autowired //스프링 부트가 미리 생성해놓은 객체를 가져다가 자동 연결
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArtcleForm() {
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form) {

        log.info(form.toString());
//        System.out.println(form.toString()); -> 로깅 기능으로 대체

        // 1. Dto를 변환
        Article article = form.toEntity();
//        System.out.println(article.toString());
        log.info(article.toString());
        // 2. 저장소에 개체를 DB에 저장
        Article saved = articleRepository.save(article);
//        System.out.println(saved.toString());
        log.info(saved.toString());

        return "";
    }
}
