* Built a new Android project - 'steemit2'.
* Debugged each dependencies independently, trying to found the root cause.
* Found out with the solution with another logging library - "Logger".
* Now, the App gets compiled.
* But an exception occured. **NetworkOnMainThreadException** is null. Found out by separating the catch method (didn't use the 'Java 8' approach)
* So, from stack overflow, found out that the Android < Honeycomb doesn't have give such exceptions. 
* Now, the Async method has to be used here while connecting the steem blockchain and giving the output.
