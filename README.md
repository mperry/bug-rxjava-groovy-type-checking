bug-rxjava-groovy-type-checking
===============================

I came across a type checking problem when creating a trivial RxJava Groovy program using:

- Gradle 1.11
- Groovy 2.2.2
- rxjava-groovy 0.18.1

Compiling with gradle produces the error:

```
java.lang.ClassCastException: rx.lang.groovy.RxGroovyPropertiesModuleFactory cannot be cast to org.codehaus.groovy.runtime.m12n.PropertiesModuleFactory
```

Importing the gradle file into Intellij compiles and runs ok.  I converted the program into a script and the program compiles and runs:

```
D:\repositories\bug-rxjava-groovy-type-checking\scripts>groovy rx.groovy
item: mark
item: perry
JUnit 4 Runner, Tests: 1, Failures: 0, Time: 281
```

Removing the @TypeChecked annotation in Test1.groovy allows the progam to compile and run ok.

The full Gradle output appears below:

```
:compileJava UP-TO-DATE
:compileGroovy UP-TO-DATE
:processResources UP-TO-DATE
:classes UP-TO-DATE
:jar UP-TO-DATE
:assemble UP-TO-DATE
:compileTestJava UP-TO-DATE
:compileTestGroovystartup failed:
General error during instruction selection: rx.lang.groovy.RxGroovyPropertiesModuleFactory cannot be cast to org.codehaus.groovy.runtime.m12n.PropertiesModuleFactory

java.lang.ClassCastException: rx.lang.groovy.RxGroovyPropertiesModuleFactory cannot be cast to org.codehaus.groovy.runtime.m12n.PropertiesModuleFactory
	at org.codehaus.groovy.runtime.m12n.StandardPropertiesModuleFactory.newModule(StandardPropertiesModuleFactory.java:38)
	at org.codehaus.groovy.runtime.m12n.ExtensionModuleScanner.scanExtensionModuleFromProperties(ExtensionModuleScanner.java:77)
	at org.codehaus.groovy.runtime.m12n.ExtensionModuleScanner.scanExtensionModuleFromMetaInf(ExtensionModuleScanner.java:72)
	at org.codehaus.groovy.runtime.m12n.ExtensionModuleScanner.scanClasspathModules(ExtensionModuleScanner.java:54)
	at org.codehaus.groovy.transform.stc.StaticTypeCheckingSupport$ExtensionMethodCache.getExtensionMethods(StaticTypeCheckingSupport.java:1554)
	at org.codehaus.groovy.transform.stc.StaticTypeCheckingSupport.findDGMMethodsForClassNode(StaticTypeCheckingSupport.java:178)
	at org.codehaus.groovy.transform.stc.StaticTypeCheckingSupport.findDGMMethodsForClassNode(StaticTypeCheckingSupport.java:164)
	at org.codehaus.groovy.transform.stc.StaticTypeCheckingSupport.findDGMMethodsByNameAndArguments(StaticTypeCheckingSupport.java:876)
	at org.codehaus.groovy.transform.stc.StaticTypeCheckingVisitor.findMethod(StaticTypeCheckingVisitor.java:3114)
	at org.codehaus.groovy.transform.stc.StaticTypeCheckingVisitor.visitMethodCallExpression(StaticTypeCheckingVisitor.java:2198)
	at org.codehaus.groovy.ast.expr.MethodCallExpression.visit(MethodCallExpression.java:64)
	at org.codehaus.groovy.ast.CodeVisitorSupport.visitExpressionStatement(CodeVisitorSupport.java:69)
	at org.codehaus.groovy.ast.ClassCodeVisitorSupport.visitExpressionStatement(ClassCodeVisitorSupport.java:193)
	at org.codehaus.groovy.ast.stmt.ExpressionStatement.visit(ExpressionStatement.java:40)
	at org.codehaus.groovy.ast.CodeVisitorSupport.visitBlockStatement(CodeVisitorSupport.java:35)
	at org.codehaus.groovy.ast.ClassCodeVisitorSupport.visitBlockStatement(ClassCodeVisitorSupport.java:163)
	at org.codehaus.groovy.ast.stmt.BlockStatement.visit(BlockStatement.java:69)
	at org.codehaus.groovy.ast.CodeVisitorSupport.visitClosureExpression(CodeVisitorSupport.java:174)
	at org.codehaus.groovy.transform.stc.StaticTypeCheckingVisitor.visitClosureExpression(StaticTypeCheckingVisitor.java:1658)
	at org.codehaus.groovy.ast.expr.ClosureExpression.visit(ClosureExpression.java:43)
	at org.codehaus.groovy.transform.stc.StaticTypeCheckingVisitor.visitMethodCallArguments(StaticTypeCheckingVisitor.java:2006)
	at org.codehaus.groovy.transform.stc.StaticTypeCheckingVisitor.visitMethodCallExpression(StaticTypeCheckingVisitor.java:2310)
	at org.codehaus.groovy.ast.expr.MethodCallExpression.visit(MethodCallExpression.java:64)
	at org.codehaus.groovy.ast.CodeVisitorSupport.visitExpressionStatement(CodeVisitorSupport.java:69)
	at org.codehaus.groovy.ast.ClassCodeVisitorSupport.visitExpressionStatement(ClassCodeVisitorSupport.java:193)
	at org.codehaus.groovy.ast.stmt.ExpressionStatement.visit(ExpressionStatement.java:40)
	at org.codehaus.groovy.ast.CodeVisitorSupport.visitBlockStatement(CodeVisitorSupport.java:35)
	at org.codehaus.groovy.ast.ClassCodeVisitorSupport.visitBlockStatement(ClassCodeVisitorSupport.java:163)
	at org.codehaus.groovy.ast.stmt.BlockStatement.visit(BlockStatement.java:69)
	at org.codehaus.groovy.ast.ClassCodeVisitorSupport.visitClassCodeContainer(ClassCodeVisitorSupport.java:101)
	at org.codehaus.groovy.ast.ClassCodeVisitorSupport.visitConstructorOrMethod(ClassCodeVisitorSupport.java:112)
	at org.codehaus.groovy.transform.stc.StaticTypeCheckingVisitor.visitConstructorOrMethod(StaticTypeCheckingVisitor.java:1483)
	at org.codehaus.groovy.ast.ClassCodeVisitorSupport.visitMethod(ClassCodeVisitorSupport.java:123)
	at org.codehaus.groovy.transform.stc.StaticTypeCheckingVisitor.startMethodInference(StaticTypeCheckingVisitor.java:1765)
	at org.codehaus.groovy.transform.stc.StaticTypeCheckingVisitor.visitMethod(StaticTypeCheckingVisitor.java:1738)
	at org.codehaus.groovy.ast.ClassNode.visitContents(ClassNode.java:1055)
	at org.codehaus.groovy.ast.ClassCodeVisitorSupport.visitClass(ClassCodeVisitorSupport.java:50)
	at org.codehaus.groovy.transform.stc.StaticTypeCheckingVisitor.visitClass(StaticTypeCheckingVisitor.java:162)
	at org.codehaus.groovy.transform.StaticTypesTransformation.visit(StaticTypesTransformation.java:62)
	at org.codehaus.groovy.transform.ASTTransformationVisitor.visitClass(ASTTransformationVisitor.java:132)
	at org.codehaus.groovy.transform.ASTTransformationVisitor$2.call(ASTTransformationVisitor.java:176)
	at org.codehaus.groovy.control.CompilationUnit.applyToPrimaryClassNodes(CompilationUnit.java:1036)
	at org.codehaus.groovy.control.CompilationUnit.doPhaseOperation(CompilationUnit.java:572)
	at org.codehaus.groovy.control.CompilationUnit.processPhaseOperations(CompilationUnit.java:550)
	at org.codehaus.groovy.control.CompilationUnit.compile(CompilationUnit.java:527)
	at org.codehaus.groovy.control.CompilationUnit.compile(CompilationUnit.java:506)
	at org.gradle.api.internal.tasks.compile.ApiGroovyCompiler.execute(ApiGroovyCompiler.java:119)
	at org.gradle.api.internal.tasks.compile.ApiGroovyCompiler.execute(ApiGroovyCompiler.java:40)
	at org.gradle.api.internal.tasks.compile.daemon.CompilerDaemonServer.execute(CompilerDaemonServer.java:53)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.gradle.messaging.dispatch.ReflectionDispatch.dispatch(ReflectionDispatch.java:35)
	at org.gradle.messaging.dispatch.ReflectionDispatch.dispatch(ReflectionDispatch.java:24)
	at org.gradle.messaging.remote.internal.hub.MessageHub$Handler.run(MessageHub.java:355)
	at org.gradle.internal.concurrent.DefaultExecutorFactory$StoppableExecutorImpl$1.run(DefaultExecutorFactory.java:64)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
	at java.lang.Thread.run(Thread.java:744)

1 error

 FAILED

FAILURE: Build failed with an exception.

* What went wrong:
Execution failed for task ':compileTestGroovy'.
> Compilation failed; see the compiler error output for details.

* Try:
Run with --stacktrace option to get the stack trace. Run with --info or --debug option to get more log output.

BUILD FAILED

Total time: 11.941 secs
```
