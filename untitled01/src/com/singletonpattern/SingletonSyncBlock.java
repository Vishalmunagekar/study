package com.singletonpattern;

public class SingletonSyncBlock {
    private static SingletonSyncBlock INSTANCE = null;

    private SingletonSyncBlock() {

    }

    public static SingletonSyncBlock getInstance() {
        if (INSTANCE != null) {
            synchronized (SingletonSyncBlock.class) {
                if (INSTANCE == null)
                    INSTANCE = new SingletonSyncBlock();

            }
        }
        return INSTANCE;
    }
}
