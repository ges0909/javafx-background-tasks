package com.valantic.sti.tutorial;

import javafx.concurrent.Task;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CounterTask extends Task<Long> { // generic parameter is type of output

    private final long limit;

    @Override
    protected Long call() {
        long sum = 0;
        for (int i = 0; i < limit; i++) {
            if (isCancelled()) {
                break;
            }
            sum = sum + i;
            updateValue(sum);
            updateProgress(i, limit);
        }
        return sum;
    }
}
