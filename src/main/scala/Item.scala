sealed trait Item {
  def cost: BigDecimal
}

case object Cola extends Item {
  override def cost: BigDecimal = 0.50
}

case object Coffee extends Item {
  override def cost: BigDecimal = 1.00
}

case object CheeseSandwich extends Item {
  override def cost: BigDecimal = 2.00
}

case object SteakSandwich extends Item {
  override def cost: BigDecimal = 4.50
}