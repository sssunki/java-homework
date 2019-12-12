package com.team7.yourturn.utils;

public class CoordinateCalculator {

    private int itemSize = 30;

    public int arrayToFrame(int coordinate) {
        return coordinate * itemSize;
    }

    public int frameToArray(int coordinate) {
        return coordinate / itemSize;
    }

    public Bundle calculateBounds(int x, int y) {
        Bundle bundle = new Bundle();

        bundle.addInt("TopLeftX", x);
        bundle.addInt("TopLeftY", y);
        bundle.addInt("TopRightX", x + itemSize);
        bundle.addInt("TopRightY", y);
        bundle.addInt("BottomLeftX", y + itemSize);
        bundle.addInt("BottomLeftY", x);
        bundle.addInt("BottomLeftX", x + itemSize);
        bundle.addInt("BottomLeftY", y + itemSize);

        return bundle;
    }
}
