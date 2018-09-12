trait CafeXSystem {

  def produceStandardBill(purchasedItems: List[Item]): BigDecimal = {
    purchasedItems.map(_.cost).sum
  }

  def produceBillWithServiceCharge(purchasedItems: List[Item]): BigDecimal = {
    val standardBill = produceStandardBill(purchasedItems)
    val serviceChargeRate = applyServiceCharge(purchasedItems)
    val serviceCharge = standardBill * serviceChargeRate

    if (serviceChargeRate == 0.20 && serviceCharge > 20) {
      standardBill + 20
    } else {
      standardBill + serviceCharge
    }
  }

  private[this] def applyServiceCharge: PartialFunction[List[Item], BigDecimal] = {
    case items if allDrinks(items) => 0
    case items if anyHotFood(items) => 0.20
    case items if anyFoodItem(items) => 0.10
  }

  private[this] def allDrinks(items: List[Item]) = {
    items.forall {
      item => item.equals(Coffee) || item.equals(Cola)
    }
  }

  private[this] def anyFoodItem(items: List[Item]) = {
    items.contains(CheeseSandwich) || items.contains(SteakSandwich)
  }

  private[this] def anyHotFood(items: List[Item]) = {
    items.contains(SteakSandwich)
  }
}

object CafeXSystem extends CafeXSystem