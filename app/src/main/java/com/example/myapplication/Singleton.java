package com.example.myapplication;

class Single {
    private Single() {
    }

    private static Single single = new Single();

    public static Single getInstance() {
        return single;
    }
}
