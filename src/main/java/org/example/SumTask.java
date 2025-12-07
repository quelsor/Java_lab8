package org.example;

import java.util.concurrent.RecursiveTask;

// class Class1 implements Runnable {
//
// }

// Thread thread = new Thread(new Class1());
// thread.start();

// synchronized (this) {
//
// }

public class SumTask extends RecursiveTask<Long> {
    private static final int THRESHOLD = 20;
    private final int[] array;
    private final int start;
    private final int end;

    public SumTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if (end - start <= THRESHOLD) {
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }

            return sum;
        } else {
            int mid = (start + end) / 2;
            SumTask leftTask = new SumTask(array, start, mid);
            SumTask rightTask = new SumTask(array, mid, end);

            leftTask.fork();
            rightTask.fork();

            long leftResult = leftTask.join();
            long rightResult = rightTask.join();

            return leftResult + rightResult;
        }
    }


}
