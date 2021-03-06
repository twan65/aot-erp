package jp.co.aoterp.constant;

import java.util.Arrays;
import java.util.LinkedHashMap;

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

    private final int code() {
        return code;
    }

    private final String sexName() {
        return name;
    }

    /**
     * 画面側でドロップダウンのアイテムをセット＆表示するために使用する。
     * @return 性別のドロップダウン・アイテムMAP
     */
    public static LinkedHashMap<String, String> map() {
        LinkedHashMap map = new LinkedHashMap();
        for(Sex sex : Sex.values()) {
            map.put(sex.code(), sex.sexName());
        }

        return map;
    }

    /**
     * コードから名称を取得する。
     * @param code 各コード
     * @return 各名称
     */
    public static String getNameBy(int code) {
        return Arrays.stream(Sex.values()).
                filter(sex -> sex.code == code)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new)
                .name;
    }
}
