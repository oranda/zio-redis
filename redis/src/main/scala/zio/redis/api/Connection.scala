package zio.redis.api

import zio.redis.Input._
import zio.redis.Output._
import zio.redis.RedisCommand

trait Connection {
  final val auth   = RedisCommand("AUTH", StringInput, UnitOutput)
  final val echo   = RedisCommand("ECHO", StringInput, MultiStringOutput)
  final val ping   = RedisCommand("PING", Varargs(StringInput), MultiStringOutput)
  final val select = RedisCommand("SELECT", LongInput, UnitOutput)
}
