package jp.co.aoterp.constant;

public enum EmploymentType {
    PERMANENT_EMPLOYEE(1, "正社員"),
    CONTRACT_EMPLOYEE(2, "契約社員"),
    PART_TIMER(3, "アルバイト");

    private int code;
    private String name;

    EmploymentType(int code, String name) {
        this.code = code;
        this.name = name;
    }
}
