package jp.co.aoterp.constant;

import java.util.LinkedHashMap;

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

    private final int code() {
        return code;
    }

    private final String employmentTypeName() {
        return name;
    }

    /**
     * 画面側でドロップダウンのアイテムをセット＆表示するために使用する。
     * @return 雇用形態のドロップダウン・アイテムMAP
     */
    public static LinkedHashMap<String, String> map() {
        LinkedHashMap map = new LinkedHashMap();
        for(EmploymentType employmentType : EmploymentType.values()) {
            map.put(employmentType.code(), employmentType.employmentTypeName());
        }

        return map;
    }
}
