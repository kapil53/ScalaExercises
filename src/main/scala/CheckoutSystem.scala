trait CheckoutSystem {

  def calculateTotalCost(scannedItems: List[Item]): String = {
    val totalCost = scannedItems.map(_.cost).sum
    s"£$totalCost"
  }
}

object CheckoutSystem extends CheckoutSystem
