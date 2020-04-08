package dev.evak.cratesx.service.key;

public enum KeyType {

    ADMIN("ADMIN"), USER("USER");

    private String keyName;

    KeyType(String keyName) {
        this.keyName = keyName;}

    public static KeyType getByName(String name) {
        for (KeyType keyType : values()) {
            if (keyType.getName().equalsIgnoreCase(name))
                return keyType;
        }
        return null;
    }

    public String getName() {
        return this.keyName;
    }
}
