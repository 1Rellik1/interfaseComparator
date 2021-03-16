package Homework.Tenth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public SortingAlgorithm strong() {
        return new InsertionSort();
    }

    @Bean
    public SortingAlgorithm king() {
        return new MergeSort();
    }

    @Bean
    public SortingAlgorithm queen() {
        return new QuickSort();
    }
}
