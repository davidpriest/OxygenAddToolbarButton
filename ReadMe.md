oxygenXML Add Toolbar Button Demonstration
====

In File > Project Structure > Platform Settings > Global Libraries:

add (+)
* the Scala SDK, `scala-sdk.jar`
* the Scala XML library, `scala-xml.jar`

In File > Project Structure > Project Settings > Libraries:

add (+) 
* the oxygen SDK, `oxygen.jar`

In File > Project Structure > Project Settings > Modules > Dependencies:

add (+)
* the Scala SDK, `scala-sdk.jar`
* the Scala XML library, `scala-xml.jar`
* the Scala SDK, `scala-sdk.jar`

In IntelliJ > Preferences > Build, Execution, Deployment > Compiler > Scala Compiler:

add (+) a new setting
* named `addToolbarButton`
* set Additional Compiler Options to `-Yresolve-term-conflict:error`


