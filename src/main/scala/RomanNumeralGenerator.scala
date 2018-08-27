import RomanNumeral._

trait RomanNumeralGenerator {

  def generate(number: Int): String = conversion(number, romanNumeralConstants).trim

  private[this] def conversion(number: Int, numerals: List[(String, Int)]): String = numerals match {
    case Nil => ""
    case h :: t => h._1 * (number / h._2) + conversion(number % h._2, t)
  }
}

object RomanNumeralGenerator extends RomanNumeralGenerator
