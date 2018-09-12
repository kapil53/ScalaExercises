trait CafeXSystem {

  def produceStandardBill(purchasedItems: List[Item]): BigDecimal = {
    purchasedItems.map(_.cost).sum
  }
}

object CafeXSystem extends CafeXSystem