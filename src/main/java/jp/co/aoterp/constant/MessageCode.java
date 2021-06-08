package jp.co.aoterp.constant;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MessageCode {

    E00001("E00001"),
    E00002("E00002"),
    E00003("E00003"),
    E00004("E00004"),
    E00005("E00005");

    private final String code;

}
