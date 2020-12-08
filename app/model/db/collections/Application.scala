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
        gpa: Option[Double], school_start: Date, school_end: Date,company: String, position: String, start: Date, end: Date, credit_type: String, course:String,
        description: String, coordinator_status: String, coordinator_email: Option[String], advisor_status: String, advisor_email: Option[String])
    
object Application extends DataStore  {
  
  val appLogger: Logger = Logger("application")

  //Required for using Case Classes
  val codecRegistry = fromRegistries(fromProviders(classOf[Application]), DEFAULT_CODEC_REGISTRY)

  //Using Case Class to get a collection - Test
  val coll: MongoCollection[Application] = database.withCodecRegistry(codecRegistry).getCollection("ApplicationTest")
  
  //Using Document to get collection - Test
  val listings: MongoCollection[Document] = database.getCollection("ApplicationTest")

  //Creating new application
  def createApplication(name: String, email: String, international: Boolean,cpt: Boolean, major: String, concentration: Option[String], studentId:String,
        gpa: Option[Double], school_start: Date, school_end: Date,company: String, position: String, start: Date, end: Date, credit_type: String, course:String,
        description: String, coordinator_status: String = "pending", coordinator_email: Option[String], advisor_status: String = "pending", advisor_email: Option[String]) = {
    
    val doc: Document = Document(
        "id" -> UUID.randomUUID().toString(),
        "name" -> name,
        "email" -> email,
        "international" -> international,
        "cpt" -> cpt,
        "major" -> major,
        "concentration" -> concentration,
        "studentId" -> studentId,
        "gpa" -> gpa,  
        "school_start" -> school_start,
        "school_end" ->  school_end,
        "company" -> company,
        "position" -> position,
        "start" -> start,
        "end" -> end,
        "credit_type" -> credit_type,
        "course" -> course,
        "description" -> description,
        "created" -> new Date(),
        "coordinator_status" -> coordinator_status,
        "coordinator_email" -> coordinator_email,
        "advisor_status" -> advisor_status,
        "advisor_email" -> advisor_email)
        
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
  
   //find record using id
  def findIdRecord(recId: String) = {
    val rec = coll.find(equal("id", recId)).first().headResult()
    appLogger.info("Result is: " + rec)
    rec
  }
  
    /**
   * Find a single record based on its unique email
   */
  def findRecord(recEmail: String) = {

    val rec = coll.find(equal("email", recEmail)).first().headResult()
    appLogger.info("Result  is: " + rec)
    rec
  }
  
  // find records by email
  def findEmail(CoordinatorEmail: String) = {
    val recs = coll.find(equal("coordinator_email", CoordinatorEmail))
    recs.results()
  }
  
  // finds advisor records by email 
  def findAdvisorEmail(AdvisorEmail: String) = {
    val recs = coll.find(equal("advisor_email", AdvisorEmail))
    recs.results()
  }
  
  //Update advisor comments and status 
  def advisorUpdate( applicationID:String, advisor_status:String) = {
//    coll.findOneAndReplace(equal("id", newApplication.id), newApplication).results()
    appLogger.info("Updating advisor result" )
    appLogger.info("Status " + advisor_status  )
    appLogger.info("APP ID " + applicationID  )     
     val oldApp = Application.findIdRecord(applicationID)
            val newApp = Application(applicationID,oldApp.name, oldApp.email, oldApp.international, oldApp.cpt, oldApp.major, oldApp.concentration, oldApp.studentId,
                                      oldApp.gpa, oldApp.school_start, oldApp.school_end, oldApp.company, oldApp.position, oldApp.start, oldApp.end, 
                                      oldApp.credit_type, oldApp.course, oldApp.description, oldApp.coordinator_status, oldApp.coordinator_email, advisor_status, oldApp.advisor_email)
            
            Application.update(newApp)
    
  }
  
  // find all
  def findAll() = {
    coll.find().results()
  }

  

}