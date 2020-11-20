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

case class Application (id: String, name: String, email: String, international: Boolean,cpt: Boolean, major: String, concentration: Option[String], studentId:String,
        gpa: String, school_start: Date, school_end: Date,company: String, position: String, start: Date, end: Date, credit_type: Boolean,
        description: String)
    
object Application extends DataStore with CloudinaryCDN {
  
  val appLogger: Logger = Logger("application")

  //Required for using Case Classes
  val codecRegistry = fromRegistries(fromProviders(classOf[Application]), DEFAULT_CODEC_REGISTRY)

  //Using Case Class to get a collection - Test
  val coll: MongoCollection[Application] = database.withCodecRegistry(codecRegistry).getCollection("ApplicationTest")
  
  //Using Document to get collection - Test
  val listings: MongoCollection[Document] = database.getCollection("ApplicationTest")

  //Creating new application
  def createApplication(name: String, email: String, international: Boolean,cpt: Boolean, major: String, concentration: Option[String], studentId:String,
        gpa: Option[Double], school_start: Date, school_end: Date,company: String, position: String, start: Date, end: Date, credit_type: String,
        description: String) = {
    
    val doc: Document = Document(
        "id" -> UUID.randomUUID().toString(),
        "Name" -> name,
        "Email" -> email,
        "International" -> international,
        "Cpt" -> cpt,
        "Major" -> major,
        "Concentration" -> concentration,
        "StudentId" -> studentId,
        "Gpa" -> gpa,  
        "School_start" -> school_start,
        "School_end" ->  school_end,
        "Company" -> company,
        "Position" -> position,
        "Start" -> start,
        "End" -> end,
        "Credit_type" -> credit_type,
        "Description" -> description)
        
    val observable: Observable[Completed] = listings.insertOne(doc)

    observable.subscribe(new Observer[Completed] {
      override def onNext(result: Completed): Unit = appLogger.debug(s"Inserted: $result")
      override def onError(e: Throwable): Unit = appLogger.error(s"Failed: $e")
      override def onComplete(): Unit = appLogger.info("Completed")
    })
  }
  
  // update a document
  def update(newApplication: Application) = {
    coll.findOneAndReplace(equal("id", newApplication.id), newApplication).results()
  }
  
  // delete a document
  def deleteRecord(recId: String) = {
    coll.deleteOne(equal("id", recId)).printHeadResult("Delete Result: ")
  }
  
  // find record
  def findRecord(recId: String) = {
    val rec = coll.find(equal("id", recId)).first().headResult()
    appLogger.info("Result is: " + rec)
    rec
  }
  
  // find all
  def findAll() = {
    coll.find().results()
  }
  
}