package com.example.list.partition.demopartition;

import com.google.common.collect.Lists;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootApplication
public class DemoPartitionApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoPartitionApplication.class, args);
    }

    public void run(String... args) throws Exception {
        List<Integer> numberList = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        final List<List<Integer>> guavaList = Partitioner.guavaPartition(numberList, 3);
        System.out.println("guava list count : " + guavaList.size());

        final List<List<Integer>> commonList = Partitioner.commonPartition(numberList, 3);
        System.out.println("commons list count : " + commonList.size());

        Map<Boolean, List<Integer>> partition =
                numberList.stream().collect(Collectors.partitioningBy(s -> s > 6));
        List<List<Integer>> java8List = new ArrayList<List<Integer>>(partition.values());

        System.out.println("java8 partition by : " + java8List.size());

        Map<Integer, List<Integer>> groups =
                numberList.stream().collect(Collectors.groupingBy(s -> (s - 1) / 3));
        List<List<Integer>> java8GroupByList = new ArrayList<List<Integer>>(groups.values());

        System.out.println("java8 java8GroupByList : " + java8GroupByList.size());
    }
}
