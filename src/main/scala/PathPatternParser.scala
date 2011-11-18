package com.gu

import util.parsing.combinator.RegexParsers

object PathPatternParser extends RegexParsers {
  def splat = "*" ^^^ { """.*?"""}
  def simpleDirectory = """[^/]*""".r ^^ { identity }

  def directory = "/" ~> (splat | simpleDirectory)

  def pathPattern = rep(directory)

  def parseFrom(path: String) = {
    val tokens = parseAll(pathPattern, path) match {
      case Success(tokens, _) => tokens
      case _ => throw new IllegalArgumentException("Invalid path pattern: " + path)
    }
    tokens.fold("")( _ + "/" + _).r
  }
}