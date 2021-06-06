package jp.co.aoterp.constant;

import java.util.Arrays;
import java.util.LinkedHashMap;

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

    private final int code() {
        return code;
    }

    private final String nationalityName() {
        return name;
    }

    /**
     * 画面側でドロップダウンのアイテムをセット＆表示するために使用する。
     * @return 国籍のドロップダウン・アイテムMAP
     */
    public static LinkedHashMap<String, String> map() {
        LinkedHashMap map = new LinkedHashMap();
        for(Nationality nationality : Nationality.values()) {
            map.put(nationality.code(), nationality.nationalityName());
        }

        return map;
    }

    /**
     * コードから名称を取得する。
     * @param code 各コード
     * @return 各名称
     */
    public static String getNameBy(int code) {
        return Arrays.stream(Nationality.values()).
                filter(nationality -> nationality.code == code)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new)
                .name;
    }
}
