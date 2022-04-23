package com.common.myapplication;

class Single {
    private Single() {
    }

    private static Single single = new Single();

    public static Single getInstance() {
        return single;
    }
}
