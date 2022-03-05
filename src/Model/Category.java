package Model;

public enum Category {
    ELECTRONICS("Electronic devices"),
    APPLIANCES("Appliances");

    String displayName;
    Category(String displayName){
        this.displayName = displayName;
    }
}