package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class BookDTO {
    private Integer id;

    @NotEmpty(message = "Bookname can`t be empty")
    private String name;
    @NotEmpty(message = "ISBN can`t be empty")
    @Pattern(regexp = "[0-9]*[-| ][0-9]*[-| ][0-9]*[-| ][0-9]*[-| ][0-9]*", message = "Match ISBN to standard")
    private String isbn;

    @NotEmpty(message = "Author can`t be empty")
    private String author;
}
