trait PhoneSystem {

  //Reading call.log file from resources
  //import scala.io.Source
  //val callLog: List[String] = Source.fromResource("calls.log").getLines.toList

  def generateBillPerCustomer(callLog: List[String]) = {
    costPerCustomerPerPhoneNo(callLog).map(applyPromotionPerCustomer)
  }

  private[this] def groupedCallsPerCustomer(callLog: List[String]) =  callLog.groupBy(_.split(" ")(0)).toList

  private[this] def costPerCustomerPerPhoneNo(callLog: List[String]): Seq[(String, Map[String, Double])] = groupedCallsPerCustomer(callLog).map {
    customerCall => {
      val callCost = customerCall._2.groupBy(_.split(" ")(1))
        .map(x => (x._1, phoneNoBasedCostCalc(x._2).sum))
      (customerCall._1, callCost)
    }
  }

  private[this] def phoneNoBasedCostCalc(callDurationList: List[String]) = {
    callDurationList.map(x => calculateCallCost(x.split(" ")(2)))
  }

  private[this] def calculateCallCost(callDuration: String): Double = {
    val callDurationSplit: List[String] = callDuration.split(":").toList
    val callDurationInSec = callDurationSplit match {
      case hour::minute::sec::Nil => (hour.toLong * 60 * 60) + (minute.toLong * 60) +sec.toLong
      case _ => 0
    }

    if(callDurationInSec < 180) callDurationInSec * 0.05
    else callDurationInSec * 0.03
  }

  private[this] def applyPromotionPerCustomer(customerBillCostPerPhoneNo: (String, Map[String,Double])): (String, Double) = {
    val greatestCallCost: Double = customerBillCostPerPhoneNo._2.valuesIterator.reduceLeft((x, y) => if(x > y) x else y)
    val finalCost = customerBillCostPerPhoneNo._2.valuesIterator.sum - greatestCallCost
    (customerBillCostPerPhoneNo._1, finalCost)
  }
}

object PhoneSystem extends PhoneSystem
