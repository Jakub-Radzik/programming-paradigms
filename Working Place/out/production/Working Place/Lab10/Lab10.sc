import scala.collection.mutable
//Jakub Radzik

//1

sealed trait Animal

class Cat extends Animal

class Lion extends Cat

var a: List[Cat] = List[Lion]()
//var b: List[Lion] = List[Cat]()

//2

class TopSecretMessage(protected var content: String):
  override def toString = "TopSecretMessage(" + content + ")"

class EncryptedMessage(content: String) extends TopSecretMessage(content) :
  override def toString = "TopSecretMessage(" + content + ")"

class PlainTextMessage(content: String) extends EncryptedMessage(content) :
  override def toString = "PlainTextMessage(" + content + ")"


class Channel[M]:
  private val queue = mutable.Queue[M]()

  def enqueue(msg: M) = queue.enqueue(msg)

  def dequeue() = queue.dequeue()

abstract class Sender[-M]():
  def send(msg: M): Unit

abstract class Receiver[+M]():
  def receive(): Unit

class ChannelSender[M](private val channel: Channel[M]) extends Sender[M]:
  override def send(msg: M): Unit =
    println("Send " + msg)
    channel.enqueue(msg)

class ChannelReceiver[M](private val channel: Channel[M]) extends Receiver[M] :
  override def receive(): Unit =
    println("Received: " + channel.dequeue())

