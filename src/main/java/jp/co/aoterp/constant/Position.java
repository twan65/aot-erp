package jp.co.aoterp.constant;

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
}
