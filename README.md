# AIDLDemo
This is a demo about how to use AIDL in project


1. Add buildFeatures = True
2. Add AIDL
3. Add Service


1. Use the AIDL interface from sever in Clinet
'''
// IAIDLColorInterface.aidl
package com.sea.aidlserver;

// Declare any non-default types here with import statements

interface IAIDLColorInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    int getColor();
}
'''

2. Rename the Clinet of Client to Server to make them are the same
