package com.model;

/**
 * Created by Alexandr on 07.08.2016.
 */
public enum Role {
    ADMIN {
        public void pass() {
            System.out.println("FullPass");
        }
    }, USER {
        public void pass() {
            System.out.println("NotFullPass");
        }
    };


}
