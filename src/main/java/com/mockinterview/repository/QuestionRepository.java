package com.mockinterview.repository;

import com.mockinterview.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByInterviewIdOrderByQuestionOrder(Long interviewId);
}