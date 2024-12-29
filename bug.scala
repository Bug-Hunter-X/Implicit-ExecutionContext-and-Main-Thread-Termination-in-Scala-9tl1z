```scala
import scala.concurrent.{ExecutionContext, Future}

class MyClass {
  def myMethod(x: Int)(implicit ec: ExecutionContext): Future[Int] = Future { x * 2 }
}

object Main extends App {
  implicit val ec = scala.concurrent.ExecutionContext.global

  val myClass = new MyClass
  val f = myClass.myMethod(5)

  f.onComplete { 
    case scala.util.Success(value) => println(s"Success: $value") 
    case scala.util.Failure(exception) => println(s"Failure: ${exception.getMessage}") 
  }

  Thread.sleep(1000) // Keep the main thread alive to allow the future to complete
}
```