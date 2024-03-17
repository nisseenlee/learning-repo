package com.ibm.next.todoapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder(toBuilder = true)
public class TaskDTO {

    private Long id;
    private String title;
    private String description;
    private boolean updated;

}
