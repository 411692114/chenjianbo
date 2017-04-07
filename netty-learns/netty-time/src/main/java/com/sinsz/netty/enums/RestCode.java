package com.sinsz.netty.enums;

/**
 * Created by chenjianbo on 2017/1/24.
 */
public enum RestCode {
    OK(200),E404(404);

    RestCode(int id) {
        this.id = id;
    }

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return getId()+"";
    }
}
