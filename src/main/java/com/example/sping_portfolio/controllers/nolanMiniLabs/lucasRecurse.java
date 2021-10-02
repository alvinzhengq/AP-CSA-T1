package com.example.sping_portfolio.controllers.nolanMiniLabs;

public class lucasRecurse extends lucasNum {

    public lucasRecurse() {
        super();
    }
    public lucasRecurse(int nth) {
        super(nth);
    }

    @Override
    protected void init() {
        super.name = "Recursion";
        long limit = super.algorithmSize;
        long[] f = new long[]{2,1};
        initRecurse(limit,f);
    }


    private void initRecurse(long limit, long[] f) {
        if (limit == 0) return;
        super.setData(f[0]);
        initRecurse(--limit, new long[]{f[1], f[0] + f[1]});
    }


}
