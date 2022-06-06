package com.zuo.blog.controller;

import com.zuo.blog.Service.BlogService;
import com.zuo.blog.Service.TypeService;
import com.zuo.blog.handler.NotFoundException;
import com.zuo.blog.vo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;

@Controller
public class indexController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @GetMapping("/")
    public String index(@PageableDefault(size = 2,sort = {"updateTime"}
            ,direction = Sort.Direction.DESC) Pageable pageable,
                         Model model)
    {
        model.addAttribute("page",blogService.listBlog(pageable));
        model.addAttribute("types",typeService.listTypeTop(6));
        model.addAttribute("recommendBlogs",blogService.listBlogTop(8));
        System.out.println("-----------index----------");
        return "index";
    }
    @GetMapping("/blog/{id}")
    public String blog(@PathVariable Long id,Model model) {
        model.addAttribute("blog", blogService.getAndConvert(id));
        return "blog";
    }

    @GetMapping("/about")
    public String about()
    {
        return "about";
    }

    @GetMapping("/music")
    public String music()
    {
        return "music";
    }

}
