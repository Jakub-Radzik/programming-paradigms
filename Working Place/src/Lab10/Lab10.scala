package Lab10

import scala.collection.mutable
//Jakub Radzik

//1

sealed trait Animal

class Cat extends Animal

class Lion extends Cat

//2

class TopSecretMessage(protected var content: String):
  override def toString: String = "TopSecretMessage(" + content + ")"

class EncryptedMessage(content: String) extends TopSecretMessage(content) :
  override def toString: String = "TopSecretMessage(" + content + ")"

class PlainTextMessage(content: String) extends EncryptedMessage(content) :
  override def toString: String = "PlainTextMessage(" + content + ")"


class Channel[M]:
  private val queue = mutable.Queue[M]()

  def enqueue(msg: M): Unit = queue.enqueue(msg)

  def dequeue(): M = queue.dequeue()

  def isEmpty: Boolean = queue.isEmpty

abstract class Sender[-M]():
  def send(msg: M): Unit

abstract class Receiver[+M]():
  def receive(): Unit

class ChannelSender[M](private val channel: Channel[M]) extends Sender[M] :
  override def send(msg: M): Unit =
    println("Send " + msg)
    channel.enqueue(msg)

class ChannelReceiver[M](private val channel: Channel[M]) extends Receiver[M] :
  override def receive(): Unit =
    if (!channel.isEmpty)
      println("Receive " + channel.dequeue())
    else
      println("No message")

object Test extends App {
  //    1
  var a: List[Cat] = List[Lion]()
  //    var b: List[Lion] = List[Cat]()

  //    2
  val channelTopSecret = new Channel[TopSecretMessage]()
  val channelEncrypted = new Channel[EncryptedMessage]()
  val channelPlainText = new Channel[PlainTextMessage]()

  var senderTopSecret: Sender[TopSecretMessage] = new ChannelSender[TopSecretMessage](channelTopSecret)
  var senderEncrypted: Sender[EncryptedMessage] = new ChannelSender[EncryptedMessage](channelEncrypted)
  var senderPlainText: Sender[PlainTextMessage] = new ChannelSender[PlainTextMessage](channelPlainText)

  senderPlainText = senderEncrypted
//  senderTopSecret = senderEncrypted

  var receiverTopSecret: Receiver[TopSecretMessage] = new ChannelReceiver[TopSecretMessage](channelTopSecret)
  var receiverEncrypted: Receiver[EncryptedMessage] = new ChannelReceiver[EncryptedMessage](channelEncrypted)
  var receiverPlainText: Receiver[PlainTextMessage] = new ChannelReceiver[PlainTextMessage](channelPlainText)
//  receiverPlainText = receiverEncrypted
  receiverTopSecret = receiverEncrypted

  senderTopSecret.send(new TopSecretMessage("msg 1"))
  senderEncrypted.send(new EncryptedMessage("msg 2"))
  senderPlainText.send(new PlainTextMessage("msg 3"))

  receiverTopSecret.receive()
  receiverEncrypted.receive()
  receiverEncrypted.receive()

  receiverPlainText.receive()
}
