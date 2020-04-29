package com.example.demo.Service;

import com.example.demo.DTO.BookDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.Entity.BookEntity;
import com.example.demo.Permission;
import com.example.demo.Entity.UserEntity;
import com.example.demo.Repository.BookRepository;
import com.example.demo.Repository.PermissionRepository;
import com.example.demo.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final PermissionRepository permissionRepository;
    public UserEntity save(final UserEntity user) {return userRepository.save(user);}

    public UserEntity registerUser(UserDTO user )
    {
        return save(UserEntity.builder()
                .login(user.getLogin())
                .password(user.getPassword())
                .permissions(Collections.singletonList(permissionRepository.findByPermission(Permission.USER))).build());
    }
    public Optional<UserEntity> getUserByLogin(String log)
    {
        return userRepository.findByLogin(log);
    }
    public boolean userExists(final String login)
    {
        return userRepository.existsByLogin(login);
    }
    public void addFavorites(final BookEntity book, final String login) {
        Optional<UserEntity> optionalUser = getUserByLogin(login);
        if (optionalUser.isPresent()) {
            UserEntity user = optionalUser.get();
            List<BookEntity> favorites = findFavorites(login);
            favorites.add(book);
            user.setFavorites(favorites);
            save(user);
        }
    }
    public void deleteFavorites(final BookEntity book, final String login) {
        Optional<UserEntity> user = getUserByLogin(login);
        if (user.isPresent()) {
            UserEntity us = user.get();
            List<BookEntity> books = findFavorites(login);
            books.remove(book);
            us.setFavorites(books);
            save(us);
        }
    }

    public List<BookEntity> findFavorites(String login) {
        return bookRepository.findFavoritesForUser(login);
    }
    public boolean isFavorite(int id, String login)
    {
        List<BookEntity> favorites = findFavorites(login);
        for(BookEntity b : favorites)
        {
            if (b.getId()==id)
                return true;
        }
      return false;
    }

}
