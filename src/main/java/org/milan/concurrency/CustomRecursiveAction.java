package org.milan.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

/**
 * Custom implementation of {@link RecursiveAction}
 *
 * @author Milan Rathod
 */
public class CustomRecursiveAction extends RecursiveAction {

    private String workload = "";

    private static final int THRESHOLD = 4;

    public CustomRecursiveAction(String workload) {
        this.workload = workload;
    }

    @Override
    protected void compute() {
        if (workload.length() > THRESHOLD) {
            ForkJoinTask.invokeAll(createSubTasks());
        } else {
            processing(workload);
        }
    }

    private List<RecursiveAction> createSubTasks() {
        List<RecursiveAction> subTasks = new ArrayList<>();

        String partOne = workload.substring(0, workload.length() / 2);
        String partTwo = workload.substring(workload.length() / 2);

        subTasks.add(new CustomRecursiveAction(partOne));
        subTasks.add(new CustomRecursiveAction(partTwo));

        return subTasks;
    }

    private void processing(String work) {
        String result = work.toUpperCase();

        System.out.println("This result - (" + result + ") - was processed by " + Thread.currentThread().getName());
    }

}
