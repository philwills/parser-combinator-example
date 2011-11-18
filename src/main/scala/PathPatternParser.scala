package com.gu

import util.parsing.combinator.RegexParsers

object PathPatternParser extends RegexParsers {
  def pathPattern = """.*""".r ^^ { path => path }

  def parseFrom(path: String) = {
    val tokens = parseAll(pathPattern, path) match {
      case Success(tokens, _) => tokens
      case _ => throw new IllegalArgumentException("Invalid path pattern: " + path)
    }
    tokens.r
  }
}