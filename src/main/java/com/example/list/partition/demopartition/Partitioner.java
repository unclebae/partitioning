package com.example.list.partition.demopartition;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.ListUtils;

import java.util.List;

public class Partitioner {

    public static <T> List<List<T>> guavaPartition(List<T> lists, int part) {
        return Lists.partition(lists, part);
    }

    public static <T> List<List<T>> commonPartition(List<T> lists, int part) {
        return ListUtils.partition(lists, part);
    }
}
