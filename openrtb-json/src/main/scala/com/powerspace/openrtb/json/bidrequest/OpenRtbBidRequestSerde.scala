package com.powerspace.openrtb.json.bidrequest

import com.google.openrtb.BidRequest.{Imp, Source}
import com.google.openrtb._
import com.powerspace.openrtb.json.util.EncodingUtils
import com.powerspace.openrtb.json.common.OpenRtbProtobufEnumEncoders

/**
  * OpenRTB BidRequest Serde
  */
object OpenRtbBidRequestSerde {

  import EncodingUtils._
  import io.circe._
  import io.circe.generic.extras.semiauto._
  import OpenRtbProtobufEnumEncoders._

  implicit val metricEncoder: Encoder[Imp.Metric] = OpenRtbImpressionSerde.metricEncoder
  implicit val distributionChannelOneofEncoder: Encoder[BidRequest.DistributionchannelOneof] = OpenRtbImpressionSerde.distChannelOneOfEncoder

  implicit val producerEncoder: Encoder[BidRequest.Producer] = deriveEncoder[BidRequest.Producer].cleanRtb
  implicit val publisherEncoder: Encoder[BidRequest.Publisher] = deriveEncoder[BidRequest.Publisher].cleanRtb

  implicit val contentEncoder: Encoder[BidRequest.Content] = deriveEncoder[BidRequest.Content].cleanRtb
  implicit val appEncoder: Encoder[BidRequest.App] = deriveEncoder[BidRequest.App].cleanRtb

  implicit val siteEncoder: Encoder[BidRequest.Site] = deriveEncoder[BidRequest.Site].cleanRtb
  implicit val geoEncoder: Encoder[BidRequest.Geo] = deriveEncoder[BidRequest.Geo].cleanRtb

  implicit val sourceEncoder: Encoder[Source] = deriveEncoder[Source].cleanRtb
  implicit val deviceEncoder: Encoder[BidRequest.Device] = deriveEncoder[BidRequest.Device].cleanRtb
  implicit val regsEncoder: Encoder[BidRequest.Regs] = deriveEncoder[BidRequest.Regs].cleanRtb

  implicit def encoder(implicit userEncoder: Encoder[BidRequest.User], impressionEncoder: Encoder[BidRequest.Imp]):
    Encoder[BidRequest] = deriveEncoder[BidRequest].transformBooleans.clean(toKeep = Seq("imp"))

  /**
    * Decoder for the OpenRTB bid request.
    */
  implicit def decoder: Decoder[BidRequest] = ???

}
