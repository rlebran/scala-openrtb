package com.powerspace.openrtb.json

import com.google.openrtb.{BidRequest, BidResponse}
import io.circe.{Decoder, Encoder}

trait SerdeModule {

  // bid request encoding
  implicit val userEncoder: Encoder[BidRequest.User]
  implicit val impEncoder: Encoder[BidRequest.Imp]
  implicit val bidRequestEncoder: Encoder[BidRequest]

  // bid response decoding
  implicit val bidDecoder: Decoder[BidResponse.SeatBid.Bid]
  implicit val seatBidDecoder: Decoder[BidResponse.SeatBid]
  implicit val bidResponseDecoder: Decoder[BidResponse]

}

