
# Goal

to compile .coffee into .js and consume in Eclipse

1. with `coffee` global executable
`npm install -g coffee-script`  
`coffee -c coffee.coffee`
1. `node bin\coffee`
2. with node (peep into bin/coffee -> require(lib + '/coffee-script/command').run();)
`node lib\coffee-script\command.js -c coffee.coffee`
fails, no out put

3. Java
java -classpath path/to/rhino/js.jar:path/to/closure/compiler.jar org.mozilla.javascript.tools.shell.Main r.js main.js

java -classpath rhino-1.7R4.jar org.mozilla.javascript.tools.shell.Main r.js main.js

## Links

http://www.coderanch.com/t/549722/java/java/Calling-Javascript-function-Java-Code

[5 things you didn't know about ... the Java Scripting API](http://www.ibm.com/developerworks/java/library/j-5things9/index.html)

Note: Could not run `jrunscript` on JDK 6, but ok in JDK 7.

## SOF

http://stackoverflow.com/questions/9119137/run-node-js-from-java-or-groovy

### Running Java from command line

[Executing Java from the command line](http://stackoverflow.com/questions/4225815/executing-java-from-the-commandline)

compile `java -cp . App.java`  
run `java -cp . App println.js`

### Running JavaScript from command line

`jrunscript println.js`

## Require.js

http://requirejs.org/docs/node.html

Yes Node does. That loader uses the CommonJS module format. The CommonJS module format is non-optimal for the browser,
 and I do not agree with some of the trade-offs made in the CommonJS module format. By using RequireJS on the server,
 you can use one format for all your modules, whether they are running server side or in the browser.
 That way you can preserve the speed benefits and easy debugging you get with RequireJS in the browser,
 and not have to worry about extra translation costs for moving between two formats.


TODO

http://stackoverflow.com/questions/17962567/java-how-to-run-javascript-with-node-js-module-definitions-require


http://stackoverflow.com/questions/11074836/resolving-modules-using-require-js-and-java-rhino

 1. You have to make sure to use [r.js][1] (not require.js) , modified version of require.js for rhino.
 2. You have to extend `ScritableObject` class to implement `load` and `print` function. When you call `require(["a"])`, the load function in this class will be called, you can tweak this function to load the js file from any location. In the below example, I load from `classpath`.
 3. You have to define the property `arguments` in the sharedscope as shown below in the sample code
 4. Optionally, you can configure the sub path using `require.config`, to specify the subdirectory inside classpath where js files are located.
 
For information on its use, as well as how to get the JAR files to run it under Rhino, see the r.js README
https://github.com/jrburke/r.js 