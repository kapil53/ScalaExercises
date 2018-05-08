sealed trait Item {
  def cost: Double
}

case object Apple extends Item {
  override def cost: Double = 0.60
}

case object Orange extends Item {
  override def cost: Double = 0.25
}
