package com.singletonpattern;

public class SingletonSyncNotEfficient {
    private static SingletonSyncNotEfficient INSTANCE = null;

    private SingletonSyncNotEfficient() {

    }
    // Thread Safe but never use this impl.
    // Not efficient implementation of singleton, this will synchronize
    // all calls to this method not only the 1st.
    public static synchronized SingletonSyncNotEfficient getInstance() {
        if(INSTANCE == null)
            INSTANCE = new SingletonSyncNotEfficient();
        return INSTANCE;
    }

}
