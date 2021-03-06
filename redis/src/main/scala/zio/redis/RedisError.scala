package zio.redis

import scala.util.control.NoStackTrace

import zio.IO

sealed trait RedisError extends NoStackTrace

object RedisError {
  final case class ProtocolError(message: String) extends RedisError
  final case class WrongType(message: String)     extends RedisError

  private[redis] def make(t: Throwable): IO[RedisError, Nothing] = IO.fail(ProtocolError(t.getMessage))
}
