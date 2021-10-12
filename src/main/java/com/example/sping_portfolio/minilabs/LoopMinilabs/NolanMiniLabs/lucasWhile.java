package com.example.sping_portfolio.minilabs.LoopMinilabs.NolanMiniLabs;

public class lucasWhile extends lucasNum {
    public lucasWhile() {
        super();
    }
    public lucasWhile(int nth) {
        super(nth);
    }
    @Override
    protected void init() {
        super.name = "While";
        long limit = super.algorithmSize;
        long[] f = new long[]{2, 1};
        while (limit-- > 0) {
            super.setData(f[0]);
            f = new long[]{f[1], f[0] + f[1]};
        }
    }



}
