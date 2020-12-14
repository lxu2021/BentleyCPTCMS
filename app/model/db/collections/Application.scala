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
import model.db.collections.Course

//Cloudinary
import utils.config.CloudinaryCDN
import model.db.mongo.DataHelpers.GenericObservable
import model.db.mongo.DataStore

//Play
import play.api.Logger

case class Application (id: String, name: String, email: String, international: Boolean, major: String, concentration: Option[String], studentId:String,
        gpa: Option[Double], company: String, position: String, start: Date, end: Date, credit_type: String, course:String,
        description: String, coordinator_status: String, coordinator_email: Option[String], coordinator_comment: String, advisor_status: String,
        advisor_email: Option[String], advisor_comment: String, dean_status: String)
    
object Application extends DataStore  {
  
  val appLogger: Logger = Logger("application")

  //Required for using Case Classes
  val codecRegistry = fromRegistries(fromProviders(classOf[Application]), DEFAULT_CODEC_REGISTRY)

  //Using Case Class to get a collection - Test
  val coll: MongoCollection[Application] = database.withCodecRegistry(codecRegistry).getCollection("ApplicationTest")
  
  //Using Document to get collection - Test
  val listings: MongoCollection[Document] = database.getCollection("ApplicationTest")

  //Creating new application
  def createApplication(name: String, email: String, international: Boolean, major: String, concentration: Option[String], studentId:String,
        gpa: Option[Double], company: String, position: String, start: Date, end: Date, credit_type: String, course:String,
        description: String, coordinator_status: String = "pending", coordinator_email: Option[String], coordinator_comment: String, advisor_status: String = "pending",
        advisor_email: Option[String], advisor_comment: String, dean_status: String = "pending") = {
    
    val coordinator_emailUpdate = Course.findCoor(course).toString
    
    val doc: Document = Document(
        "id" -> UUID.randomUUID().toString(),
        "name" -> name,
        "email" -> email,
        "international" -> international,
        "major" -> major,
        "concentration" -> concentration,
        "studentId" -> studentId,
        "gpa" -> gpa,
        "company" -> company,
        "position" -> position,
        "start" -> start,
        "end" -> end,
        "credit_type" -> credit_type,
        "course" -> course,
        "description" -> description,
        "created" -> new Date(),
        "coordinator_status" -> coordinator_status,
        "coordinator_email" -> coordinator_emailUpdate,
        "coordinator_comment" -> coordinator_comment,
        "advisor_status" -> advisor_status,
        "advisor_email" -> advisor_email,
        "advisor_comment" -> advisor_comment,
        "dean_status" -> dean_status)
        
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
  
  // finds international students 
  def findInternational() = {
    val recs = coll.find(equal("international", true))
    recs.results()
  }
  
  // finds all application that has approved by coordinators and advisors
  def findForDean() = {
    val recs = coll.find(and(equal("coordinator_status","approved"),equal("advisor_status", "approved")))
    recs.results()
  }
  
  //Update advisor comments and status 
  def advisorUpdate(applicationID:String, advisor_status:String, advisor_comment:String) = {
    appLogger.info("Updating advisor result" )
    appLogger.info("Status " + advisor_status  )
    appLogger.info("APP ID " + applicationID  )     
     val oldApp = Application.findIdRecord(applicationID)
            val newApp = Application(applicationID,oldApp.name, oldApp.email, oldApp.international, oldApp.major, oldApp.concentration, oldApp.studentId,
                                      oldApp.gpa, oldApp.company, oldApp.position, oldApp.start, oldApp.end, oldApp.credit_type, oldApp.course, oldApp.description,
                                      oldApp.coordinator_status, oldApp.coordinator_email, oldApp.coordinator_comment, advisor_status, oldApp.advisor_email, advisor_comment,
                                      oldApp.dean_status)
            
            Application.update(newApp)
    
  }
  
  //Update coordinator comment and status 
  def coordinatorUpdate(applicationID:String, coordinator_status:String, coordinator_comment:String) = {
    appLogger.info("Updating advisor result" )
    appLogger.info("Status " + coordinator_status  )
    appLogger.info("APP ID " + applicationID  )     
     val oldApp = Application.findIdRecord(applicationID)
            val newApp = Application(applicationID,oldApp.name, oldApp.email, oldApp.international, oldApp.major, oldApp.concentration, oldApp.studentId,
                                      oldApp.gpa, oldApp.company, oldApp.position, oldApp.start, oldApp.end, oldApp.credit_type, oldApp.course, oldApp.description,
                                      coordinator_status, oldApp.coordinator_email, coordinator_comment, oldApp.advisor_status, oldApp.advisor_email, oldApp.advisor_comment,
                                      oldApp.dean_status)
            
            Application.update(newApp)
    
  }
  
   //Update coordinator comment and status 
  def deanUpdate(applicationID:String, dean_status:String) = {
    appLogger.info("Updating dean result" )
    appLogger.info("Status " + dean_status  )
    appLogger.info("APP ID " + applicationID  )     
     val oldApp = Application.findIdRecord(applicationID)
            val newApp = Application(applicationID,oldApp.name, oldApp.email, oldApp.international, oldApp.major, oldApp.concentration, oldApp.studentId,
                                      oldApp.gpa, oldApp.company, oldApp.position, oldApp.start, oldApp.end, oldApp.credit_type, oldApp.course, oldApp.description,
                                      oldApp.coordinator_status, oldApp.coordinator_email, oldApp.coordinator_comment, oldApp.advisor_status, oldApp.advisor_email, oldApp.advisor_comment, 
                                      dean_status)
            
            Application.update(newApp)
    
  }
  
  // find all
  def findAll() = {
    coll.find().results()
  }

  

}