# Implicit ExecutionContext and Main Thread Termination in Scala

This example demonstrates a common issue in Scala when using implicit `ExecutionContext` with `Future`.  The main thread may exit before the asynchronous operation completes, resulting in the callback not being executed.

The `bug.scala` file contains the buggy code. The `bugSolution.scala` file shows how to fix the problem.

## How to reproduce

1. Save `bug.scala` and `bugSolution.scala`.
2. Compile and run `bug.scala`.
3. Observe that you might not see the output `Success: 10`.
4. Compile and run `bugSolution.scala`. Note the correct output.

## Solution

The solution involves ensuring the main thread waits for the Future to complete using `Await.result` (or similar mechanisms).