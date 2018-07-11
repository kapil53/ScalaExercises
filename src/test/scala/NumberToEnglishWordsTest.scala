
import org.scalatest.FlatSpec
import org.scalatest.Matchers._

class NumberToEnglishWordsTest extends FlatSpec {
  markup{
    """
      |# NumberToEnglishWords Test
      |
      |`convertToEnglishWords'
      |
      |Given a number, it should be able to return the equivalent in British English words
    """.stripMargin
  }

  behavior of "convertToEnglishWords"
  it should "be able to convert numbers upto 100" in {
    NumberToEnglishWords.convertToEnglishWords(1) should be("one")
    NumberToEnglishWords.convertToEnglishWords(11) should be("eleven")
    NumberToEnglishWords.convertToEnglishWords(55) should be("fifty five")
    NumberToEnglishWords.convertToEnglishWords(99) should be("ninety nine")
  }

  it should "be able to convert numbers from 100 to 1000" in {
    NumberToEnglishWords.convertToEnglishWords(101) should be("one hundred and one")
    NumberToEnglishWords.convertToEnglishWords(550) should be("five hundred and fifty")
    NumberToEnglishWords.convertToEnglishWords(999) should be("nine hundred and ninety nine")
  }

  it should "be able to convert numbers from 1000 to 100000" in {
    NumberToEnglishWords.convertToEnglishWords(1101) should be("one thousand, one hundred and one")
    NumberToEnglishWords.convertToEnglishWords(5550) should be("five thousand, five hundred and fifty")
    NumberToEnglishWords.convertToEnglishWords(9999) should be("nine thousand, nine hundred and ninety nine")
  }

  it should "be able to convert numbers from 100000 to 999999999" in {
    NumberToEnglishWords.convertToEnglishWords(56945781) should be("fifty six million, nine hundred and forty five thousand, seven hundred and eighty one")
    NumberToEnglishWords.convertToEnglishWords(999999999) should be("nine hundred and ninety nine million, nine hundred and ninety nine thousand, nine hundred and ninety nine")
  }
}
