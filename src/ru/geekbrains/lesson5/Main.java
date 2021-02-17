package ru.geekbrains.lesson5;

import java.util.Arrays;

public class Main {
//    1. Необходимо написать два метода, которые делают следующее:
//            1) Создают одномерный длинный массив, например:
//
//    static final int size = 10000000;
//    static final int h = size / 2;
//    float[] arr = new float[size];
//
//  2) Заполняют этот массив единицами;
//  3) Засекают время выполнения: long a = System.currentTimeMillis();
//  4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
//    arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
//  5) Проверяется время окончания метода System.currentTimeMillis();
//  6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a);
//
//    Отличие первого метода от второго:
//    Первый просто бежит по массиву и вычисляет значения.
//    Второй разбивает массив на два массива, в двух потоках высчитывает новые значения и потом склеивает эти массивы обратно в один.
//
//    Пример деления одного массива на два:
//
//            System.arraycopy(arr, 0, a1, 0, h);
//            System.arraycopy(arr, h, a2, 0, h);
//
//    Пример обратной склейки:
//
//            System.arraycopy(a1, 0, arr, 0, h);
//            System.arraycopy(a2, 0, arr, h, h);
//
//    Примечание:
//            System.arraycopy() – копирует данные из одного массива в другой:
//            System.arraycopy(массив-источник, откуда начинаем брать данные из массива-источника, массив-назначение, откуда начинаем записывать данные в массив-назначение, сколько ячеек копируем)
//    По замерам времени:
//    Для первого метода надо считать время только на цикл расчета:
//
//            for (int i = 0; i < size; i++) {
//        arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
//    }
//
//    Для второго метода замеряете время разбивки массива на 2, просчета каждого из двух массивов и склейки.

    static final int size = 10000000;
    static final int h = size / 2;
    static float[] arr = new float[size];

    public static void main(String[] args) {

        arrLine(arr);
        arrThread(arr);

    }

    private static void arrLine(float[] arr) {
        Arrays.fill(arr, 1f);
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            calc(arr, i);
        }
        System.out.println("One thread time is: " + (System.currentTimeMillis() - a));
    }

    private static void calc(float[] arr, int i) {
        arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
    }

    private static void arrThread(float[] arr) {
        Arrays.fill(arr, 1f);
        long a = System.currentTimeMillis();
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        System.out.println("Time of copy: " + (System.currentTimeMillis() - a));


        long threadStartingTime = System.currentTimeMillis();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < a1.length; i++) {
                calc(a1, i);
            }
            System.out.println("First thread time: " + (System.currentTimeMillis() - threadStartingTime));
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < a1.length; i++) {
                calc(a2, i);
            }
            System.out.println("Second thread time: " + (System.currentTimeMillis() - threadStartingTime));
        });
        t1.start();
        t2.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long arrMergeStart = System.currentTimeMillis();
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        System.out.println("Merging time is: " + (System.currentTimeMillis() - arrMergeStart));
        System.out.println("Two thread time is: " + (System.currentTimeMillis() - a));
    }
}



