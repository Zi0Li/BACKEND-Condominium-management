package br.com.smartcondo.enums;

public enum UserRole {
    SINDICO("sindico"),
    MORADOR("morador"),
    FUNCIONARIO("funcionario");

    private String role;

    UserRole(String role){
        this.role = role;
    }

    public String getType(){
        return role;
    }
}
