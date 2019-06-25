package com.example.demo2.customer;

public class MyAnnotationOperation {
    private String key;
    private String value;
    private String managerName;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(MyAnnotationOperation.class.getName());
        sb.append("-->key:").append(key).append(",");
        sb.append("value:").append(value).append(",");
        sb.append("managerName:").append(managerName).append(",");
        sb.append("name:").append(name);
        return sb.toString();
    }
}
