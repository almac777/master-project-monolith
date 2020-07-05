package at.ac.fhcampus.master.monolith.articles.controllers;

import at.ac.fhcampus.master.monolith.articles.dtos.ArticleDto;
import at.ac.fhcampus.master.monolith.articles.services.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(ArticleController.BASE_URL)
public class ArticleController {
    static final String BASE_URL = "/api/v1/articles";
    private static final String ROOT_URL = "/";
    private static final String ID_URL = "/{id}";

    private final ArticleService articleService;

    @GetMapping(ROOT_URL)
    public List<ArticleDto> articles() {
        return this.articleService.list();
    }

    @GetMapping(ID_URL)
    public ArticleDto article(@PathVariable("id") Long id) {
        return this.articleService.show(id);
    }

    @PostMapping(ROOT_URL)
    public ArticleDto save(@RequestBody ArticleDto articleDto) {
        return this.articleService.register(articleDto);
    }

    @PutMapping(ID_URL)
    public ArticleDto update(@PathVariable("id") Long id, @RequestBody ArticleDto articleDto) {
        return this.articleService.update(id, articleDto);
    }
}
