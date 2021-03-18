package Homework.Tenth;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TenthMain {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

        SortingAlgorithm sortingAlgorithm = context.getBean(MergeSort.class);
        sortingAlgorithm.DoSort();

        sortingAlgorithm = context.getBean(InsertionSort.class);
        sortingAlgorithm.DoSort();

        sortingAlgorithm = context.getBean(QuickSort.class);
        sortingAlgorithm.DoSort();
    }
}
