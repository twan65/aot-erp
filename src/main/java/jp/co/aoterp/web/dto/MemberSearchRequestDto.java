package jp.co.aoterp.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class MemberSearchRequestDto {

    private String name;
    private Long employmentType;
    private Long department;
    private LocalDate enteredDateFrom;
    private LocalDate enteredDateTo;
    private LocalDate dateOfBirthFrom;
    private LocalDate dateOfBirthTo;

    @Builder
    public MemberSearchRequestDto(String name, Long employmentType, Long department, LocalDate dateOfBirthFrom, LocalDate dateOfBirthTo, LocalDate enteredDateFrom, LocalDate enteredDateTo) {
        this.name = name;
        this.employmentType = employmentType;
        this.enteredDateFrom = enteredDateFrom;
        this.department = department;
        this.enteredDateTo = enteredDateTo;
        this.dateOfBirthFrom = dateOfBirthFrom;
        this.dateOfBirthTo = dateOfBirthTo;
    }
}
