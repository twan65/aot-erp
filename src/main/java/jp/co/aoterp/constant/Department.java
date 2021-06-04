package jp.co.aoterp.constant;

public enum Department {
    SYSTEM_DEVELOPMENT1_T(1, "システム開発１部"),
    SYSTEM_DEVELOPMENT2_T(2, "システム開発２部"),
    SYSTEM_DEVELOPMENT3_T(3, "システム開発３部"),
    DESIGN_T(4, "デザインチーム"),
    HR_T(5, "人事部");

    private int code;
    private String name;

    Department(int code, String name) {
        this.code = code;
        this.name = name;
    }
}
