import NumberConstants._

trait NumberToEnglishWords {

  def convertToEnglishWords(n: Int): String = conversion(n).trim

  private[this] lazy val conversion: PartialFunction[Int, String] = {
    case n if (n < zero) => s"minus  + ${convertToEnglishWords(-n)}"
    case n if (n < twenty) => numberInUnits(n)
    case n if (n < hundred) => s"${numberInTens(n / ten)}${numberInUnits(n % ten)}"
    case n if (n < thousand) => s"${numberInUnits(n / hundred)} hundred and ${convertToEnglishWords(n % hundred)}"
    case n if (n < million) => s"${convertToEnglishWords(n / thousand)} thousand, ${convertToEnglishWords(n % thousand)}"
    case n if (n < billion) => s"${convertToEnglishWords(n / million)} million, ${convertToEnglishWords(n % million)}"
    case n => s"${convertToEnglishWords(n / billion)} billion ${convertToEnglishWords(n % billion)}"
  }
}

object NumberToEnglishWords extends NumberToEnglishWords
