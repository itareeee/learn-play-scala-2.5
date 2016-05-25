import org.scalatest._
import common.utils.StringUtils


/**
  * Created by kitagawa on 2016/05/25.
  */
class ApiRandomSpec extends FunSpec with Matchers {

  describe("StringUtils"){
    it("should count string length properly") {
      val str = "four"
      StringUtils.countChars(str) should be (4)
    }
  }

}
