package com.lisy.output;

import com.lisy.output.impl.CsvOutputGenerator;

public class OutputHelper {
    private CsvOutputGenerator outpurGenerator;

    public void setOutpurGenerator(CsvOutputGenerator outpurGenerator) {
        this.outpurGenerator = outpurGenerator;
    }

    public CsvOutputGenerator getOutpurGenerator() {
        return outpurGenerator;
    }
}
