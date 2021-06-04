package jp.co.aoterp.constant;

public enum Sex {
    MALE(1, "男性"),
    FEMALE(2, "女性"),
    OTHER(3, "その他");

    private int code;
    private String name;

    Sex(int code, String name) {
        this.code = code;
        this.name = name;
    }
}
