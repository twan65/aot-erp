package jp.co.aoterp.constant;

import java.util.LinkedHashMap;

public enum Position {
    PROGRAMMER(1, "プログラマー"),
    SYSTEM_ENGINEER(2, "システムエンジニア"),
    INFRA_ENGINEER(3, "インフラエンジニア"),
    TEAM_LEADER(4, "チームリーダー"),
    PROJECT_MANAGER(5, "プロジェクトマネージャー"),
    DESIGNER(6, "デザイナー");

    private int code;
    private String name;

    Position(int code, String name) {
        this.code = code;
        this.name = name;
    }


    private final int code() {
        return code;
    }

    private final String positionName() {
        return name;
    }

    /**
     * 画面側でドロップダウンのアイテムをセット＆表示するために使用する。
     * @return ポジションのドロップダウン・アイテムMAP
     */
    public static LinkedHashMap<String, String> map() {
        LinkedHashMap map = new LinkedHashMap();
        for(Position position : Position.values()) {
            map.put( position.code(),  position. positionName());
        }

        return map;
    }
}
