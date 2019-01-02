package com.badboy.stock.common.datasource;

public enum DatabaseType {
	 badboy("badboy"),badboy1("badboy1");
	
	 DatabaseType(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
