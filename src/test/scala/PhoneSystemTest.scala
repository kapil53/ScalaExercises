import org.scalatest.FlatSpec
import org.scalatest.Matchers._

class PhoneSystemTest extends FlatSpec {
  markup{
    """
      |# Phone System
      |
      |##`generateBillPerCustomer`
      |It takes a list of calls with duration logged by the company and outputs the total call cost per customer, after applying the promotional offer
    """.stripMargin
  }

  behavior of "generateBillPerCustomer"
  it should "generate the total call cost for each customer with promotion applied" in {
    val callsLog: List[String] = List(
      "A 555-333-212 00:02:03",
      "A 555-433-242 00:06:41",
      "A 555-433-242 00:01:03",
      "B 555-333-212 00:01:20",
      "A 555-333-212 00:01:10",
      "A 555-663-111 00:02:09",
      "A 555-333-212 00:04:28",
      "B 555-334-789 00:00:03",
      "A 555-663-111 00:02:03",
      "B 555-334-789 00:00:53",
      "B 555-971-219 00:09:51",
      "B 555-333-212 00:02:03",
      "B 555-333-212 00:04:31",
      "B 555-334-789 00:01:59")

    PhoneSystem.generateBillPerCustomer(callsLog) should be(List(("A", 27.78), ("B", 26.480000000000004)) )
  }
}
