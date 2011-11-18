package com.gu

import org.specs2.mutable._
import PathPatternParser._

class PathPatternSpec extends Specification {
  "A literal path" should {
    "produce a regex matching a literal path" in {
      val pattern = parseFrom("/simple/path")
      pattern.toString must be equalTo ("/simple/path")
    }
  }

  "A splat in a path" should {
    "match  anything at the end" in {
      val pattern = parseFrom("/splat/path/*")
      pattern.toString must be equalTo ("/splat/path/.*?")
    }
    "match anything in the middle" in {
      val pattern = parseFrom("/splat/*/path")
      pattern.toString must be equalTo ("/splat/.*?/path")
    }
  }
}