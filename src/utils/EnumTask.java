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

    public static EnumTask statusToEnum(String status) {
        return switch (status) {
            case "TODO" -> TODO;
            case "IN_PROGRESS" -> IN_PROGRESS;
            case "DONE" -> DONE;
            default -> throw new IllegalStateException("Unexpected value: " + status);
        };
    }
}
