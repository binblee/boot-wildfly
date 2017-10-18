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

    @RequestMapping("/display")
    public String welcome(Model model){
        List<DemoContent> result = jdbcTemplate.query(
                "SELECT id, content FROM demotable",
                (rs, rowNum) -> new DemoContent(rs.getInt("id"),
                        rs.getInt("content"))
        );
        model.addAttribute("message", result.toString());
        return "welcome";
    }
}
