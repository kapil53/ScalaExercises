
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

  it should "calculate the cost for a single banana" in {
    val scannedItems = List(Banana)

    CheckoutSystem.calculateTotalCost(scannedItems) should be("£0.2")
  }

  it should "calculate the cost for a single banana and a single apple" in {
    val scannedItems = List(Banana, Apple)

    CheckoutSystem.calculateTotalCost(scannedItems) should be("£0.8")
  }

  it should "calculate the total cost for two bananas after offer" in {
    val scannedItems = List(Banana, Banana)

    CheckoutSystem.calculateTotalCostAfterOffer(scannedItems) should be("£0.2")
  }

  it should "calculate the total cost for single banana and single apple after offer" in {
    val scannedItems = List(Banana, Apple)

    CheckoutSystem.calculateTotalCostAfterCheapestOffer(scannedItems) should be("£0.6")
  }

  it should "calculate the total cost for 1 bananas and 3 apples after multiple offers" in {
    val scannedItems = List(Banana, Apple, Apple, Apple)

    CheckoutSystem.calculateTotalCostAfterCheapestOffer(scannedItems) should be("£1.2")
  }

  it should "calculate the total cost for 3 bananas and 1 apple after multiple offers" in {
    val scannedItems = List(Banana, Banana, Banana, Apple)

    CheckoutSystem.calculateTotalCostAfterCheapestOffer(scannedItems) should be("£1.0")
  }

  it should "calculate the total cost for 3 bananas 3 apple and 3 oranges after multiple offers" in {
    val scannedItems = List(Banana, Banana, Banana, Apple, Apple, Apple, Orange, Orange, Orange)

    CheckoutSystem.calculateTotalCostAfterCheapestOffer(scannedItems) should be("£2.3")
  }

  it should "calculate the total cost for 3 oranges after simple offer" in {
    val scannedItems = List(Orange, Orange, Orange)

    CheckoutSystem.calculateTotalCostAfterCheapestOffer(scannedItems) should be("£0.5")
  }
}
