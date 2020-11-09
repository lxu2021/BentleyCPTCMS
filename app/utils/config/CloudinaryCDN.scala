package utils.config

import com.cloudinary._
import com.cloudinary.utils.ObjectUtils

trait CloudinaryCDN extends AppConfiguration {

  lazy val cloudinaryCDN: String = getConfigString("cloudinary.cdn", "")
  lazy val cloudinaryName: String = getConfigString("cloudinary.cloud_name", "")
  lazy val cloudinaryApiKey: String = getConfigString("cloudinary.api_key", "")
  lazy val cloudinaryApiSecret: String = getConfigString("cloudinary.api_secret", "")

  val cloudinary = new Cloudinary(ObjectUtils.asMap(
    "cloud_name", cloudinaryName,
    "api_key", cloudinaryApiKey,
    "api_secret", cloudinaryApiSecret))

  val baseUrl: String = s"$cloudinaryCDN/$cloudinaryName/image/upload/"
  
  def removeImage(id: String) = {
    val res = cloudinary.uploader().destroy(id, ObjectUtils.emptyMap())
    println(res)
  }
}