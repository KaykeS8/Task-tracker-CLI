package utils;

public enum EnumTask {
    TODO,
    IN_PROGRESS,
    DONE;

    public static String statusToString(EnumTask status) {
        return switch (status) {
            case TODO -> "todo";
            case IN_PROGRESS -> "in-progress";
            case DONE -> "done";
            default -> "invalid status";
        };
    }
}
