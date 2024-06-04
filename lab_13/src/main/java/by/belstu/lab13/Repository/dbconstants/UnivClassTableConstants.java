package by.belstu.lab13.Repository.dbconstants;

public enum UnivClassTableConstants {
    ID("id"),
    NAME("name"),
    DAY("day"),
    HOURS("hours");
    private String fieldName;
    private UnivClassTableConstants(String fieldName) {
        this.fieldName = fieldName;
    }
    public String getFieldName() {
        return fieldName;
    }

}
