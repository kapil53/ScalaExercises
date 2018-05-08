trait CheckoutSystem {

  def calculateTotalCost(scannedItems: List[Item]): String = {
    val totalCost = scannedItems.map(_.cost).sum
    s"£$totalCost"
  }

  def calculateTotalCostAfterOffer(scannedItems: List[Item]): String = {
    val listOfApples = scannedItems.filter(_ == Apple).map(_.cost)
    val listOfOranges = scannedItems.filter(_ == Orange).map(_.cost)

    val totalCost = simpleOffer(listOfApples, 1) + simpleOffer(listOfOranges, 2)
    s"£$totalCost"
  }

  private[this] def simpleOffer(itemCosts: List[Double], itemOfferedOn: Int): Double = {
    val (_, total) = itemCosts.foldLeft((0, 0.0))((res, curr) => if (res._1 == itemOfferedOn) (0, res._2) else (res._1 + 1, res._2 + curr))
    total
  }
}

object CheckoutSystem extends CheckoutSystem
