package com.example.sbb;

import com.example.entity.Answer;
import com.example.entity.Question;
import com.example.repository.AnswerRepository;
import com.example.repository.QuestionRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SbbApplicationTests {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

   @Transactional
   @Test
   void contextLoads() {

      Optional<Question> oq = this.questionRepository.findById(2);
      assertTrue(oq.isPresent());
      Question q = oq.get();

      List<Answer> answerList = q.getAnswerList();

      assertEquals(1,answerList.size());
      assertEquals("네 자동으로 생성됩니다.",answerList.get(0).getContent());


    }

}
