package ar.com.porloschicos.backend.contentservice.ContentType;

public enum ContentType {

    CAMPANA("campana", 1),
    PROYECTO("proyecto", 2),
    NOVEDADES("novedades", 4);

    private String type;
    private int id;

    ContentType(String type, int id) {
        this.type = type;
        this.id = id;
    }

    public static ContentType getById(Integer id) {
        for (ContentType type : values()) {
            if (type.getId() == id) return type;
        }
        return null;
    }

    public String getType() {
        return type;
    }

    public int getId() {
        return id;
    }
}
