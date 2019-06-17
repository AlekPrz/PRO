package alek.app.symulator_ligi.model;

public enum Role {
    ADMIN("ROLE_ADMIN"),
    MANAGER("ROLE_MANAGER");

    private String description;

    Role(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
