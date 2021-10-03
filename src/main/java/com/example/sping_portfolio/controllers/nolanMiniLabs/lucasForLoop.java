package com.example.sping_portfolio.controllers.nolanMiniLabs;

public class lucasForLoop extends lucasNum {
    public lucasForLoop() {
        super();
    }

    public lucasForLoop(int nth) {
        super(nth);
    }

    @Override
    protected void init() {
        super.name = "For";
        long limit = super.algorithmSize;

        for (long[] f = new long[]{2, 1}; limit-- > 0; f = new long[]{f[1], f[0] + f[1]})
              super.setData(f[0]);
    }

}
