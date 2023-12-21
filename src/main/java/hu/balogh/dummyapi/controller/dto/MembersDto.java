package hu.balogh.dummyapi.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MembersDto {
    private Integer id;
    private String name;
    private String position;
    private String phoneNumber;
}
