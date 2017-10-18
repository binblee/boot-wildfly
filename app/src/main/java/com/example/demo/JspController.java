package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class JspController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static List<DemoContent> cachedContent;

    @GetMapping("/display")
    public String display(Model model){
        List<DemoContent> result = getDemoContentInstances();
        model.addAttribute("message", result.toString());
        return "display";
    }

    @GetMapping("/cdisplay")
    public String cdisplay(Model model){
        if(cachedContent == null){
            cachedContent = getDemoContentInstances();
        }
        model.addAttribute("message", cachedContent.toString());
        return "display";
    }

    private List<DemoContent> getDemoContentInstances(){
        return jdbcTemplate.query(
                "SELECT id, content FROM demotable",
                (rs, rowNum) -> new DemoContent(rs.getInt("id"),
                        rs.getInt("content"))
        );
    }
}
