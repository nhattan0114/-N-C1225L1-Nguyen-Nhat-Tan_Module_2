package iotextfile.ReadFile;

public class Country {
    private String name;
    private String code;
    private String id;

    public Country(String id, String code, String name) {
        this.id=id;
        this.code=code;
        this.name=name;
    }

    public String getCode() {
        return code;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return String.format("| %-10s | %-10s | %-10s |", id, code, name);
    }
}
