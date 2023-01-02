package com.concurrency;

import java.util.List;

public interface Concurrency {
	void useSequential(List<MyTask> tasks);
	void useCompletableFuture(List<MyTask> tasks);
	void useCompletableFutureWithExecutor(List<MyTask> tasks, int threadCount);
	void useParallelStream(List<MyTask> tasks);
}
