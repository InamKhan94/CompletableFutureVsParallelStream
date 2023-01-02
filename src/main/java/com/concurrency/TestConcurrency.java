package com.concurrency;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestConcurrency {

	public static final int MAX_TASKS_10 = 10;
	public static final int MAX_TASKS_100 = 100;
	public static final int MAX_TASKS_1000 = 1000;
	public static final int THREAD_COUNT_10 = 10;
	public static final int THREAD_COUNT_1000 = 1000;
	public static final int SECONDS = 1;

	public static void main(String[] args) {

		List<MyTask> tasks10 = IntStream.range(0, MAX_TASKS_10)
				.mapToObj(i -> new MyTask(SECONDS))
				.collect(Collectors.toList());

		List<MyTask> tasks100 = IntStream.range(0, MAX_TASKS_100)
				.mapToObj(i -> new MyTask(SECONDS))
				.collect(Collectors.toList());

		List<MyTask> tasks1000 = IntStream.range(0, MAX_TASKS_1000)
				.mapToObj(i -> new MyTask(SECONDS))
				.collect(Collectors.toList());

		Concurrency concurrency = new ConcurrencyImpl();

		// 10 tasks
		concurrency.useSequential(tasks10);
		System.out.println();
		concurrency.useCompletableFuture(tasks10);
		System.out.println();
		concurrency.useCompletableFutureWithExecutor(tasks10, THREAD_COUNT_10);
		System.out.println();
		concurrency.useParallelStream(tasks10);
		System.out.println();

		// 100 tasks
		concurrency.useCompletableFuture(tasks100);
		System.out.println();
		concurrency.useCompletableFutureWithExecutor(tasks100, THREAD_COUNT_10);
		System.out.println();
		concurrency.useParallelStream(tasks100);
		System.out.println();

		// 1000 tasks
		concurrency.useCompletableFuture(tasks1000);
		System.out.println();
		concurrency.useCompletableFutureWithExecutor(tasks1000, THREAD_COUNT_1000);
		System.out.println();
		concurrency.useParallelStream(tasks1000);
	}
}
