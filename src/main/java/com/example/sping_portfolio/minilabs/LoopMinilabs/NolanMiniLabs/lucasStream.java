package com.example.sping_portfolio.minilabs.LoopMinilabs.NolanMiniLabs;
import java.util.stream.Stream;

public class lucasStream extends lucasNum {
public lucasStream() {
    super();
}
public lucasStream(int nth) {
    super(nth);
}
@Override
    protected void init () {
    super.name = "Stream";
    Stream.iterate(new long[]{2, 1}, f -> new long[]{f[1], f[0] + f[1]})
            .limit(super.algorithmSize)
            .forEach(f -> super.setData(f[0]));

}


}
