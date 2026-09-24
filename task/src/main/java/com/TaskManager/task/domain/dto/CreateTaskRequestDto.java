package com.TaskManager.task.domain.dto;

import com.TaskManager.task.domain.entities.TaskPriority;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

public record CreateTaskRequestDto(
        @NotBlank(message = "ERROR_MESSAGE")
        @Length(min=3, max=255,message = "ERROR_MESSAGE")
        String title,
                                   @Length(max = 1000,message = "ERROR_MESSAGE2")
                                   @Nullable
                                   String description,
                                   @FutureOrPresent(message = "ERROR_MESSAGE3" )
                                   @Nullable
                                   LocalDate dueDate,
                                   @NotNull(message = "ERROR_MESSAGE4" )
                                   TaskPriority priority
                                   ) {
    public static final String ERROR_MESSAGE = "Title or Description is invalid";
    public static final String ERROR_MESSAGE2 = "Title or Description is invalid";
    public static final String ERROR_MESSAGE3 = "Due date is invalid";
    public static final String ERROR_MESSAGE4 = "Task priority must be provided";

}
