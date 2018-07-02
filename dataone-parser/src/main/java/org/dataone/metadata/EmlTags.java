package org.dataone.metadata;

public class EmlTags {
    private String principal;
    private String permission;
    private String organizationName;


    public String getPrincipal() {
        return principal;
    }

    public String getPermission() {
        return permission;
    }

    public String getorganizationName() {
        return organizationName;
    }
    @Override
    public String toString() {
        return "EmlTags [principal:" + principal + ", permission=" + permission +  "]";
    }
}