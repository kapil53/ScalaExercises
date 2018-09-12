
import org.scalatest.FlatSpec
import org.scalatest.Matchers._

class CafeXSystemTest extends FlatSpec {
  markup{
    """
      |# CafeX System
      |
      |##`standardBill`
      |It takes a list of items purchased and returns the total bill
      |
    """.stripMargin
  }

  behavior of "standardBill"
  it should "calculate the total bill for no items purchased" in {
    val purchasedItems = Nil

    CafeXSystem.produceStandardBill(purchasedItems) should be(0.0)
  }

  it should "calculate the total bill for items purchased include single Cola" in {
    val purchasedItems = List(Cola)

    CafeXSystem.produceStandardBill(purchasedItems) should be(0.50)
  }

  it should "calculate the total bill for items purchased include single Coffee" in {
    val purchasedItems = List(Coffee)

    CafeXSystem.produceStandardBill(purchasedItems) should be(1)
  }

  it should "calculate the total bill for items purchased include single Cheese Sandwich" in {
    val purchasedItems = List(CheeseSandwich)

    CafeXSystem.produceStandardBill(purchasedItems) should be(2)
  }

  it should "calculate the total bill for items purchased include single Steak Sandwich" in {
    val purchasedItems = List(SteakSandwich)

    CafeXSystem.produceStandardBill(purchasedItems) should be(4.5)
  }

  it should "calculate the total bill for items purchased include single Cola Coffee and Cheese Sandwich" in {
    val purchasedItems = List(Cola, Coffee, CheeseSandwich)

    CafeXSystem.produceStandardBill(purchasedItems) should be(3.5)
  }
}