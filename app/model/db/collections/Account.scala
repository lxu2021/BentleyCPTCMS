package model.db.collections

import scala.util.Try
import java.util.Date
import java.util.UUID

//Mongo
import org.bson.codecs.configuration.CodecRegistries.fromProviders
import org.bson.codecs.configuration.CodecRegistries.fromRegistries
import org.mongodb.scala.Completed
import org.mongodb.scala.Document
import org.mongodb.scala.MongoCollection
import org.mongodb.scala.Observable
import org.mongodb.scala.Observer
import org.mongodb.scala.MongoClient.DEFAULT_CODEC_REGISTRY
import org.mongodb.scala.bson.codecs.Macros.createCodecProvider
import org.mongodb.scala.model.Filters.equal

//Cloudinary
import utils.config.CloudinaryCDN
import model.db.mongo.DataHelpers.GenericObservable
import model.db.mongo.DataStore

//Play
import play.api.Logger

case class Account(Username: String, Password: String, CreationDate: String, 
    LastLoggedIn: Option[String], Name: String, Email: String, AccountType: String, StudentID: String,
    GPA: String, Program: String, International: String, Department: Option[String])

object Account extends DataStore with CloudinaryCDN {

  val appLogger: Logger = Logger("application")

  //Required for using Case Classes
  val codecRegistry = fromRegistries(fromProviders(classOf[Account]), DEFAULT_CODEC_REGISTRY)

  //Using Case Class to get a collection - Test
  val coll: MongoCollection[Account] = database.withCodecRegistry(codecRegistry).getCollection("Account")
  

  //Using Document to get collection - Test
  val listings: MongoCollection[Document] = database.getCollection("Account")

  /**
   * Update a document, with this new document
   * Unique Id is used to find the existing document
   */
  def update(newAccount: Account) = {

    coll.findOneAndReplace(equal("Email", newAccount.Email), newAccount).results()

  }

  /**
   * Delete a single document
   */
  def deleteRecord(recEmail: String) = {
    coll.deleteOne(equal("Email", recEmail)).printHeadResult("Delete Result: ")
  }

    
  /**
   * Find a single record based on its unique email
   */
  def findRecord(recEmail: String) = {

    val rec = coll.find(equal("Email", recEmail)).first().headResult()
    appLogger.info("Result  is: " + rec)
    rec

  }
  

  /**
   * Retrieve all documents in the collection
   */
  def findAll() = {

    coll.find().results()

  }

  
  /**
   * Validate a user that has logged in (added Prof. Matra)
   */
  def validateUser(username: String, password: String) : Boolean = {
    //try to match a record in the DB based to what the user provided
    val rec = coll.find(
      Document("Email" -> username, "Password" -> password)  
      ).first().headResult()
 
      if(rec != null) true else false
  }
  
}