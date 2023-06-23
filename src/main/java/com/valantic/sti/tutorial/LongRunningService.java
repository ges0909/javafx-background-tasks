package com.valantic.sti.tutorial;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LongRunningService extends Service<Long> {

    private final long limit;

    @Override
    protected Task<Long> createTask() {
        return new LongRunningTask(limit);
    }
}
