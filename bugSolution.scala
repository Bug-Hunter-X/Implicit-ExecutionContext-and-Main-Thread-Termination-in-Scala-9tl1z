```scala
import scala.concurrent.{Await, ExecutionContext, Future}
import scala.concurrent.duration._

class MyClass {
  def myMethod(x: Int)(implicit ec: ExecutionContext): Future[Int] = Future { x * 2 }
}

object Main extends App {
  implicit val ec = scala.concurrent.ExecutionContext.global

  val myClass = new MyClass
  val f = myClass.myMethod(5)

  val result = Await.result(f, 1.second) // Wait for the future to complete
  println(s"Result: $result")
}
```