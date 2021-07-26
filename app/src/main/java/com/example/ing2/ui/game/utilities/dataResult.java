package com.example.ing2.ui.game.utilities;

import java.util.List;

public class dataResult {
    private String data;
    private Float points;

    public dataResult(String data, Float points) {
        this.data = data;
        this.points = points;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setPoints(Float points) {
        this.points = points;
    }

    public String getData() {
        return data;
    }

    public Float getPoints() {
        return points;
    }
}
