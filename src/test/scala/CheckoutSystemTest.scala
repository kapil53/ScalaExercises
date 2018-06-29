
import org.scalatest.FlatSpec
import org.scalatest.Matchers._

class CheckoutSystemTest extends FlatSpec {
  markup{
    """
      |# Checkout System
      |
      |##`calculateTotalCost`
      |It takes a list of items scanned at the till and outputs the total cost
      |
      |##`calculateTotalCostAfterOffer`
      |It takes a list of items scanned at the till and outputs the total cost after applying the offer on items
      |
    """.stripMargin
  }

  behavior of "calculateTotalCost"
  it should "calculate the total cost for scanned items" in {
    val scannedItems = List(Apple, Apple, Orange, Apple)

    CheckoutSystem.calculateTotalCost(scannedItems) should be("£2.05")
  }

  behavior of "calculateTotalCostAfterOffer"
  it should "calculate the total cost for scanned items with offer applied" in {
    val scannedItems = List(Apple, Apple, Orange, Apple, Apple, Apple)

    CheckoutSystem.calculateTotalCostAfterOffer(scannedItems) should be("£2.05")

    val anotherListOfItems = List(Apple, Apple, Orange, Orange, Orange, Orange, Apple)

    CheckoutSystem.calculateTotalCostAfterOffer(anotherListOfItems) should be("£1.95")
  }

}
