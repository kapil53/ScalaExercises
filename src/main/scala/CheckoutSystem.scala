trait CheckoutSystem {

  def calculateTotalCost(scannedItems: List[Item]): String = {
    val totalCost = scannedItems.map(_.cost).sum
    s"£$totalCost"
  }

  def calculateTotalCostAfterOffer(scannedItems: List[Item]): String = {
    val listOfApples = scannedItems.filter(_ == Apple).map(_.cost)
    val listOfOranges = scannedItems.filter(_ == Orange).map(_.cost)
    val listOfBananas = scannedItems.filter(_ == Banana).map(_.cost)

    val totalCost = simpleOffer(listOfApples, 1) + simpleOffer(listOfOranges, 2) + simpleOffer(listOfBananas, 1)
    s"£$totalCost"
  }

  def calculateTotalCostAfterCheapestOffer(scannedItems: List[Item]): String = {
    val listOfBananas = scannedItems.filter(_ == Banana)//.map(_.cost)
    val listOfApples = scannedItems.filter(_ == Apple)//.map(_.cost)
    val listOfOranges = scannedItems.filter(_ == Orange)//.map(_.cost)

    val noOfItemsToBePaidFor = {
      val sizeOfBananas = listOfBananas.size
      val sizeOfApples = listOfApples.size

      val items = {
        if (sizeOfBananas >= sizeOfApples) {
          (sizeOfBananas - sizeOfApples)
        } else 0
      }

      items * Banana.cost + simpleOffer(listOfApples.drop(sizeOfBananas).map(_.cost), 1) + simpleOffer(listOfOranges.map(_.cost), 2)
    }

    s"£$noOfItemsToBePaidFor"
  }

  private[this] def simpleOffer(itemCosts: List[Double], itemOfferedOn: Int): Double = {
    val (_, total) = itemCosts.foldLeft((0, 0.0))((res, curr) => if (res._1 == itemOfferedOn) (0, res._2) else (res._1 + 1, res._2 + curr))
    total
  }
}

object CheckoutSystem extends CheckoutSystem
