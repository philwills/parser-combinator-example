package com.gu

import org.specs2.mutable._
import PathPatternParser._

class PathPatternSpec extends Specification {
  "A literal path" should {
    "produce a regex matching a literal path" in {
      val pattern = parseFrom("/simple/path")
      pattern.toString must be ("/simple/path")
    }
  }
}