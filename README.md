# AIDLDemo
This is a demo about how to use `AIDL` in Android project.


Steps:
1. Add `buildFeatures = True` in `build.gradle.kts(Moudle :app)`
2. Add AIDL
3. Add Service



> [!IMPORTANT]  
> 1. Use the AIDL interface from sever in Clinet
> 2. Rename the Clinet of Client to Server to make them are the same

```java
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
```