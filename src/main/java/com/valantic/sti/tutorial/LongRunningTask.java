package com.valantic.sti.tutorial;

import javafx.concurrent.Task;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class LongRunningTask extends Task<Long> implements Runnable { // generic parameter = 'call' method return type

    private final long limit;

    @Override
    protected Long call() {
        long sum = 0;
        for (int iteration = 0; iteration < limit; iteration++) {
            if (isCancelled()) {
                break;
            }
            sum = sum + iteration;
            updateValue(sum);
            updateProgress(iteration, limit);
        }
        return sum;
    }

    @Override
    protected void succeeded() {
        super.succeeded();
        log.info("LongRunningTask.succeeded");
    }

    @Override
    protected void failed() {
        super.failed();
        log.error("LongRunningTask.failed");
    }

    @Override
    protected void cancelled() {
        super.cancelled();
        log.warn("LongRunningTask.cancelled");
    }
}
