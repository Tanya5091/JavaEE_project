package com.example.demo.Repository;

import com.example.demo.Entity.BookEntity;
import com.example.demo.Entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {

    @Query("SELECT comment FROM CommentEntity comment "
            + "JOIN comment.user user "
            + "WHERE user.login = :login")
    List<CommentEntity> findCommentsForUser(@Param("login") final String login);
    @Query("SELECT comment FROM CommentEntity comment "
            + "JOIN comment.book book "
            + "WHERE book.id= :id")
    List<CommentEntity> findCommentsForBook(@Param("id") final int id);

}
