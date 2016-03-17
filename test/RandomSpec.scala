import collection.mutable.Stack
import org.scalatest._

class RandomSpec extends FunSpec with Matchers {

  describe("A Stack"){
    it("should pop values in last-in-first-out order") {
      val stack = new Stack[Int]
      stack.push(1)
      stack.push(2)
      stack.pop() should be (2)
      stack.pop() should be (1)
    }

    it("should throw NoSuchElementException if an empty stack is popped") {
      val emptyStack = new Stack[Int]
      a [NoSuchElementException] should be thrownBy {
        emptyStack.pop()
      }
    }
  }

  describe("Assertion methods") {
    it("should print nice error message"){
      val left = 2
      val right = 2 //1
      assert(left == right)
    }

    it("should print nicer error message"){
      val left = 2
      val right = 2 //1
      assert(left == right, s"Left:$left should be equal to right: $right")
    }

    it("clarifies expected/actual"){
      val a = 5
      val b = 3 //2
      assertResult(2) {
        a - b
      }
    }

    it("ensures throwables"){
      val s = "hi"
      intercept[IndexOutOfBoundsException] {
        s.charAt(-1)
      }
    }

  }
}