package com.example.demo.model;

import java.util.Arrays;

public class Pic {
    Integer id;
    byte[] pic;

    @Override
    public String toString() {
        return "Pic{" +
                "id=" + id +
                ", pic=" + Arrays.toString(pic) +
                '}';
    }

    public Pic() {
    }

    public Pic(Integer id, byte[] pic) {
        this.id = id;
        this.pic = pic;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getPic() {
        return pic;
    }

    public void setPic(byte[] pic) {
        this.pic = pic;
    }
}
