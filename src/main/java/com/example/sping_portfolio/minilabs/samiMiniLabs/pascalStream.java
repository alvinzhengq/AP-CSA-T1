package com.example.sping_portfolio.minilabs.samiMiniLabs;

import java.util.stream.Stream;

public class pascalStream extends _pascal{
    public pascalStream(int nth) {
        super(nth);
    }

    @Override
    protected void init() {
        super.name = "Stream";
        Stream.iterate(new long[]{0, 1}, f -> new long[]{f[1], f[0] + f[1]})
                .limit(super.size)
                .forEach(f -> super.setData(f[0]) );
    }

    public static void main(String[] args) {
        int num = 20;   //number of Fibs, 92 is max for long
        _pascal pascal = new pascalStream(num);
        pascal.print();
    }
}


