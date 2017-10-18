package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class JspController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static List<DemoContent> cachedContent = null;

    @RequestMapping("/display")
    public String welcome(Model model){
        List<DemoContent> result = queryContent();
        if(result != null) {
            model.addAttribute("message", result.toString());
        }else{
            model.addAttribute("message","result is null");
        }
        return "welcome";
    }

    @RequestMapping("/cdisplay")
    public String cdisplay(Model model){
        if(cachedContent == null){
            List<DemoContent> result = queryContent();
            cachedContent = result;
        }
        if(cachedContent != null){
            model.addAttribute("message",cachedContent.toString());
        }else{
            model.addAttribute("message","result is null");
        }
        return "welcome";
    }

    private List<DemoContent> queryContent(){
        return jdbcTemplate.query(
                "SELECT id, content FROM demotable",
                (rs, rowNum) -> new DemoContent(rs.getInt("id"),
                        rs.getInt("content"))
        );
    }
}
