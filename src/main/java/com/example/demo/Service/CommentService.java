package com.example.demo.Service;

import com.example.demo.Entity.CommentEntity;
import com.example.demo.Repository.CommentRepository;
import org.springframework.transaction.annotation.Transactional;

public class CommentService {
    private CommentRepository commentRepository;
    @Transactional
    public CommentEntity createComment(final CommentEntity book) {
        return commentRepository.saveAndFlush(book);
    }

}
