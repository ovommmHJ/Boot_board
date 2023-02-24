package com.example.controller;

import com.example.entity.Question;
import com.example.repository.QuestionRepository;
import com.example.service.QuestionService;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/question")
@RequiredArgsConstructor //questionRepository 속성을 포함하는 생성자 생성
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/list")
//    @ResponseBody
    public String list(Model model){
        List<Question> questionList = questionService.getList();
        model.addAttribute("questionList",questionList);
        return "question_list";
    }



    @GetMapping(value="/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id){
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question",question);
        return "question_detail";
    }


//    @GetMapping("/create/{id}")
//    public String createAnswer(Model model, @PathVariable("id") Integer id, @RequestParam String content){
//        Question question = this.questionService.getQuestion(id);
//        return String.format("redirect:/question/detail/%s",id);
//    }

}
