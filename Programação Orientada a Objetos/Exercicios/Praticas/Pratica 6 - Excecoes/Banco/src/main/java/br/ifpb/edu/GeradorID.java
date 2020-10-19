package br.ifpb.edu;

import java.util.Random;

public class GeradorID extends Random {

    public GeradorID(Long semente) {
        super(semente);
        setSeed(semente);
    }

    public Long gerarId() {
        Long id = Math.abs(this.nextLong());
        return id;
    }
}
