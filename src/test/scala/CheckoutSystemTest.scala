
import org.scalatest.FlatSpec
import org.scalatest.Matchers._

class CheckoutSystemTest extends FlatSpec {
  markup{
    """
      |# Checkout System
      |
      |It takes a list of items scanned at the till and outputs the total cost
      |
    """.stripMargin
  }

  behavior of "calculateTotalCost"

  it should "calculate the total cost for scanned items" in {
    val scannedItems = List(Apple, Apple, Orange, Apple)

    CheckoutSystem.calculateTotalCost(scannedItems) should be("£2.05")
  }

}
