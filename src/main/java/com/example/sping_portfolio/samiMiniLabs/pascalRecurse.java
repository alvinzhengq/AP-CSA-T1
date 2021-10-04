package com.example.sping_portfolio.samiMiniLabs;

public class pascalRecurse extends _pascal {
    public pascalRecurse(int nth) {
        super(nth);
    }

    @Override
    protected void init() {
        //setup for recursion
        super.name = "Recursion";
        long limit = super.size;
        long[] f = new long[]{0, 1};
        initRecurse(limit,f);
    }

    private void initRecurse(long limit, long[] f) {
        if (limit == 0) return;                                 //exit condition
        super.setData(f[0]);
        initRecurse(--limit, new long[]{f[1], f[0] + f[1]});    //recursion requires pre-increment
    }

    public static void main(String[] args) {
        int num = 20;   //number of Fibs, 92 is max for long
        _pascal pascal = new pascalRecurse(num);
        pascal.print();
    }
}

