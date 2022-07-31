package com.crx.shejimoshi;

public class SingleObject_lan {
    private static SingleObject_lan instance = null;

    private SingleObject_lan() {
    }

    /**
     * 1、适用于单线程环境（不推荐）
     */
    public static SingleObject_lan getInstanceA() {
        if (null == instance) {
            instance = new SingleObject_lan();
        }
        return instance;
    }

    /**
     * 2、适用于多线程环境，但效率不高（不推荐）
     */
    public static synchronized SingleObject_lan getInstanceB() {
        if (instance == null) {
            instance = new SingleObject_lan();
        }
        return instance;
    }

    /**
     * 3、双重检查加锁（推荐）
     */
    public static SingleObject_lan getInstanceC() {
        // 先判断实例是否存在，若不存在再对类对象进行加锁处理
        if (instance == null) {
            synchronized (SingleObject_lan.class) {
                if (instance == null) {
                    instance = new SingleObject_lan();
                }
            }
        }
        return instance;
    }
}
