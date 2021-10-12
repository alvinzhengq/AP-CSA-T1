package com.example.sping_portfolio.minilabs.LoopMinilabs.NolanMiniLabs;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import lombok.*;

@Getter
public abstract class lucasNum {
    int algorithmSize;
    int hashID;
    String name;
    Duration elapsedTime;
    ArrayList<Long> list;
    HashMap<Integer, Object> hash;

    public lucasNum() {
        this( 20);
    }

    public lucasNum(int nth) {
        this.algorithmSize = nth;
        this.list = new ArrayList<>();
        this.hashID = 0;
        this.hash = new HashMap<>();
        Instant start = Instant.now();
        this.init();
        Instant end = Instant.now();
        this.elapsedTime = Duration.between(start, end);
    }
    protected abstract void init();

    public void setData(long num) {
        list.add(num);
        hash.put(this.hashID++, list.clone());
    }

    public int getElapsedTime() {
        return elapsedTime.getNano();
    }

    public long getNth() {
        return list.get(algorithmSize - 1);
    }
    public Object getNthSeq(int i) {
        return hash.get(i);
    }


}