package com.saikocat.meownificent.protocol

import spray.json.DefaultJsonProtocol
import spray.httpx.marshalling.Marshaller
import spray.httpx.unmarshalling.Unmarshaller
import spray.json._
import spray.http._

import com.saikocat.meownificent.protocol.ApiMediaType.MeownificentJsonMediaType

trait MeownificentJsonProtocol extends DefaultJsonProtocol {
  implicit def meownificentJsonUnmarshallerConverter[T](reader: RootJsonReader[T]) =
    meownificentJsonUnmarshaller(reader)
  implicit def meownificentJsonUnmarshaller[T: RootJsonReader] =
    Unmarshaller[T](MeownificentJsonMediaType) {
      case x: HttpEntity.NonEmpty ⇒
        val json = JsonParser(x.asString(defaultCharset = HttpCharsets.`UTF-8`))
        jsonReader[T].read(json)
    }

  implicit def meownificentJsonMarshallerConverter[T](writer: RootJsonWriter[T])(implicit printer: JsonPrinter = PrettyPrinter) =
    meownificentJsonMarshaller[T](writer, printer)

  implicit def meownificentJsonMarshaller[T](implicit writer: RootJsonWriter[T], printer: JsonPrinter = PrettyPrinter) =
    Marshaller.delegate[T, String](MeownificentJsonMediaType) { value =>
      val json = writer.write(value)
      printer(json)
    }
}

object MeownificentJsonProtocol extends MeownificentJsonProtocol
