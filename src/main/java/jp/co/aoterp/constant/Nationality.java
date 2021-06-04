package jp.co.aoterp.constant;

public enum Nationality {
    JAPAN(1, "日本"),
    KOREA(2, "韓国"),
    AMERICA(3, "アメリカ"),
    CHINA(4, "中国"),
    VIETNAM(5, "ベトナム");

    private int code;
    private String name;

    Nationality(int code, String name) {
        this.code = code;
        this.name = name;
    }
}
