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
import org.mongodb.scala.model.Filters._
import org.mongodb.scala.model.Projections._


//Cloudinary
import utils.config.CloudinaryCDN
import model.db.mongo.DataHelpers.GenericObservable
import model.db.mongo.DataStore

//Play
import play.api.Logger

case class Course (id: String, CourseID: String, Name: String, Credits: String, InternshipCoordinator: String)
    
object Course extends DataStore with CloudinaryCDN {
  
  val appLogger: Logger = Logger("application")

  //Required for using Case Classes
  val codecRegistry = fromRegistries(fromProviders(classOf[Course]), DEFAULT_CODEC_REGISTRY)

  //Using Case Class to get a collection - Test
  val coll: MongoCollection[Course] = database.withCodecRegistry(codecRegistry).getCollection("Course")
  
  //Using Document to get collection - Test
  val listings: MongoCollection[Document] = database.getCollection("Course")

  //Creating new application
  def createCourse(id: String, CourseID: String, Name: String, Credits: String, InternshipCoordinator: String) = {
    
    val doc: Document = Document(
        "id" -> UUID.randomUUID().toString(),
        "CourseID" -> CourseID,
        "Name" -> Name,
        "Credits" -> Credits,
        "InternshipCoordinator" -> InternshipCoordinator)
        
    val observable: Observable[Completed] = listings.insertOne(doc)

    observable.subscribe(new Observer[Completed] {
      override def onNext(result: Completed): Unit = appLogger.debug(s"Inserted: $result")
      override def onError(e: Throwable): Unit = appLogger.error(s"Failed: $e")
      override def onComplete(): Unit = appLogger.info("Completed")
    })
  }
  
  // update a document
  def update(newCourse: Course) = {
    coll.findOneAndReplace(equal("id", newCourse.id), newCourse).results()
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
  
  //matching coordinator's email
  def findCoor(course:String){
    val rec = coll.find(equal("CourseID", course)).first().headResult()
    val ic = rec.InternshipCoordinator
    ic
  }
  
}