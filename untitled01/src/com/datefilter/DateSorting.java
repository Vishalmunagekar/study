package com.datefilter;

import java.time.LocalDate;
import java.util.*;

public class DateSorting {

    public static void main1(String[] args) {
        List<LocalDate> completeList = new ArrayList<>();
        completeList.add(LocalDate.of(2023, 1, 1));
        completeList.add(LocalDate.of(2022, 1, 1));
        completeList.add(LocalDate.of(2021, 1, 1));
        completeList.add(LocalDate.of(2020, 1, 1));
        completeList.add(null);
        completeList.add(LocalDate.of(2019, 1, 1));
        completeList.add(LocalDate.of(2018, 1, 1));
        completeList.add(LocalDate.of(2016, 1, 1));
        completeList.add(null);

        // Create a null-safe comparator for LocalDate objects
        Comparator<LocalDate> nullSafeComparator = Comparator.nullsLast(Comparator.naturalOrder());

        // Sort the list using the null-safe comparator and the desired sort order
        completeList.sort(true ? nullSafeComparator : nullSafeComparator.reversed());
        System.out.println(completeList);
        completeList.sort(false ? nullSafeComparator : nullSafeComparator.reversed());
        System.out.println(completeList);
    }

    public static void main2(String[] args) {
        List<Date> completeList = new ArrayList<>();
        completeList.add(new Date(123, 1, 1));
        completeList.add(new Date(122, 1, 1));
        completeList.add(new Date(121, 1, 1));
        completeList.add(new Date(120, 1, 1));
        completeList.add(null);
        completeList.add(new Date(119, 1, 1));
        completeList.add(new Date(118, 1, 1));
        completeList.add(new Date(116, 1, 1));
        completeList.add(null);

        boolean isAscending = true;

        // Create a null-safe comparator for Date objects
        Comparator<Date> nullSafeComparator = Comparator.nullsLast(Comparator.naturalOrder());

        // Sort the list using the null-safe comparator and the desired sort order
        completeList.sort(isAscending ? nullSafeComparator : nullSafeComparator.reversed());

        System.out.println(completeList);
    }

    public static void main(String[] args) {
        List<SetupTriggerDto> completeList = new ArrayList<>();
        completeList.add(new SetupTriggerDto("Object 1", new Date(123, 1, 1), new Date()));
        completeList.add(new SetupTriggerDto("Object 2", new Date(122, 1, 1), new Date()));
        completeList.add(new SetupTriggerDto("Object 3", new Date(121, 1, 1), new Date()));
        completeList.add(new SetupTriggerDto("Object 4", new Date(120, 1, 1), new Date()));
        completeList.add(new SetupTriggerDto("Object 5", null, new Date()));
        completeList.add(new SetupTriggerDto("Object 6", new Date(119, 1, 1), new Date()));
        completeList.add(new SetupTriggerDto("Object 7", new Date(118, 1, 1), new Date()));
        completeList.add(new SetupTriggerDto("Object 8", new Date(116, 1, 1), new Date()));
        completeList.add(new SetupTriggerDto("Object 9", null, new Date()));

        boolean isAscending = true;

        Collections.sort(completeList, new Comparator<SetupTriggerDto>() {
            @Override
            public int compare(SetupTriggerDto o1, SetupTriggerDto o2) {
                if (!isAscending) {
                    return compareTo(o2.getPrevRun(),o1.getPrevRun());
                } else {
                    return compareTo(o1.getPrevRun(),o2.getPrevRun());
                }
            }
        });

        for (SetupTriggerDto obj : completeList) {
            System.out.println(obj);
        }
    }

    public static int compareTo(Date fromDate, Date toDate) {
        if (fromDate == null) {
            return 1; // Treat null as greater
        } else if (toDate == null) {
            return -1; // Treat this as smaller
        } else {
            return toDate.compareTo(fromDate);
        }
    }

}
