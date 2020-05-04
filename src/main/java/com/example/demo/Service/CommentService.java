package com.example.demo.Service;

import com.example.demo.Entity.CommentEntity;
import com.example.demo.Repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    @Transactional
    public CommentEntity createComment(final CommentEntity book) {
        return commentRepository.saveAndFlush(book);
    }

}
