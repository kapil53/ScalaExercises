
import org.scalatest.FlatSpec
import org.scalatest.Matchers._

class RomanNumeralsGeneratorTest extends FlatSpec {
  markup{
    """
      |# Roman Numerals Generator Test
      |
      |`generate'
      |
      |Given an integer number, it should be able to return the equivalent Roman Numeral
    """.stripMargin
  }

  behavior of "generate"
  it should "be able to convert numbers upto 10" in {
    RomanNumeralGenerator.generate(1) should be("I")
    RomanNumeralGenerator.generate(3) should be("III")
    RomanNumeralGenerator.generate(4) should be("IV")
    RomanNumeralGenerator.generate(6) should be("VI")
  }

  it should "be able to convert numbers from 10 to 100" in {
    RomanNumeralGenerator.generate(10) should be("X")
    RomanNumeralGenerator.generate(55) should be("LV")
    RomanNumeralGenerator.generate(99) should be("XCIX")
  }

  it should "be able to convert numbers from 100 to 1000" in {
    RomanNumeralGenerator.generate(100) should be("C")
    RomanNumeralGenerator.generate(550) should be("DL")
    RomanNumeralGenerator.generate(990) should be("CMXC")
  }

  it should "be able to convert numbers from 1000 to 3999" in {
    RomanNumeralGenerator.generate(1000) should be("M")
    RomanNumeralGenerator.generate(1559) should be("MDLIX")
    RomanNumeralGenerator.generate(3999) should be("MMMCMXCIX")
  }
}
