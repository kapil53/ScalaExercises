
import org.scalatest.FlatSpec
import org.scalatest.Matchers._

class CafeXSystemTest extends FlatSpec {
  markup{
    """
      |# CafeX System
      |
      |##`produceStandardBill`
      |It takes a list of items purchased and returns the total bill
      |
      |##`produceBillWithServiceCharge`
      |It takes a list of items purchased and returns the total bill with conditional service charge applied
    """.stripMargin
  }

  behavior of "produceStandardBill"
  it should "produce the total bill when no items are purchased" in {
    val purchasedItems = Nil

    CafeXSystem.produceStandardBill(purchasedItems) should be(0.0)
  }

  it should "produce the total bill when purchased items include single Cola" in {
    val purchasedItems = List(Cola)

    CafeXSystem.produceStandardBill(purchasedItems) should be(0.50)
  }

  it should "produce the total bill when purchased items include single Coffee" in {
    val purchasedItems = List(Coffee)

    CafeXSystem.produceStandardBill(purchasedItems) should be(1)
  }

  it should "produce the total bill when purchased items include single Cheese Sandwich" in {
    val purchasedItems = List(CheeseSandwich)

    CafeXSystem.produceStandardBill(purchasedItems) should be(2)
  }

  it should "produce the total bill when purchased items include single Steak Sandwich" in {
    val purchasedItems = List(SteakSandwich)

    CafeXSystem.produceStandardBill(purchasedItems) should be(4.5)
  }

  it should "produce the total bill when purchased items are single Cola Coffee and Cheese Sandwich" in {
    val purchasedItems = List(Cola, Coffee, CheeseSandwich)

    CafeXSystem.produceStandardBill(purchasedItems) should be(3.5)
  }

  behavior of "applyServiceCharge"
  it should "apply no service charge when all purchased items are drinks" in {
    val purchasedItems = List(Cola, Coffee)

    CafeXSystem.produceBillWithServiceCharge(purchasedItems) should be(1.5)
  }

  it should "apply a service charge of 10% to the total bill when purchased items include any food item" in {
    val purchasedItems = List(Cola, CheeseSandwich)

    CafeXSystem.produceBillWithServiceCharge(purchasedItems) should be(2.75)
  }

  it should "apply a service charge of 10% to the total bill rounded to 2 decimal places when purchased items include any food item" in {
    val purchasedItems = List(Cola, CheeseSandwich, CheeseSandwich, CheeseSandwich)

    CafeXSystem.produceBillWithServiceCharge(purchasedItems) should be(7.15)
  }

  it should "apply a service charge of 20% to the total bill when purchased items include any hot food" in {
    val purchasedItems = List(Cola, SteakSandwich)

    CafeXSystem.produceBillWithServiceCharge(purchasedItems) should be(6)
  }

  it should "apply a service charge of 20% to the total bill when purchased items include any hot food with a maximum of £20 service charge" in {
    val purchasedItems = List.fill(25)(SteakSandwich)

    CafeXSystem.produceBillWithServiceCharge(purchasedItems) should be(132.5)
  }
}