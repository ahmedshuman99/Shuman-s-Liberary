package com.Shuman.s.Project.Shuman.s.Liberary.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDTO {
    private int id;
    private String name;
    private String type;
    private double price;
}
