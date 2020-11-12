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

case class Application (id: String, AppID: String, CPT: String, Status: String, Timestamp: Date, OrgName: String, WorkAddress: String,
    Position: String, Description: String, Hours: Int, Supervisor: String, Start: Date, End: Date, Semester: String, GPA: Int,
    Program: String, MBAConc: String, GA: Boolean, FalconFT: Boolean, International: Boolean, IS_2terms: Boolean, priorFBL: Boolean,
    ReqCourses: Boolean, ProgCourseReq: Boolean, AdvisorApproval: String, CoordinatorApproval: String, DeanApproval: String,
    StudentID: String, CourseID: String, AdvisorEmail: String, CoordinatorEmail: String, DeanEmail: String)
    
object Application extends DataStore with CloudinaryCDN {
  
  val appLogger: Logger = Logger("application")

  //Required for using Case Classes
  val codecRegistry = fromRegistries(fromProviders(classOf[Application]), DEFAULT_CODEC_REGISTRY)

  //Using Case Class to get a collection - Test
  val coll: MongoCollection[Application] = database.withCodecRegistry(codecRegistry).getCollection("Application")
  
  //Using Document to get collection - Test
  val listings: MongoCollection[Document] = database.getCollection("Application")

  //Creating new application
  def createApplication(id: String, AppID: String, CPT: String, Status: String, Timestamp: Date, OrgName: String, WorkAddress: String,
    Position: String, Description: String, Hours: Int, Supervisor: String, Start: Date, End: Date, Semester: String, GPA: Int,
    Program: String, MBAConc: String, GA: Boolean, FalconFT: Boolean, International: Boolean, IS_2terms: Boolean, priorFBL: Boolean,
    ReqCourses: Boolean, ProgCourseReq: Boolean, AdvisorApproval: String, CoordinatorApproval: String, DeanApproval: String,
    StudentID: String, CourseID: String, AdvisorEmail: String, CoordinatorEmail: String, DeanEmail: String) = {
    
    val doc: Document = Document(
        "id" -> UUID.randomUUID().toString(),
        "AppID" -> AppID,
        "CPT" -> CPT,
        "Status" -> Status,
        "Timestamp" -> Timestamp,
        "OrgName" -> OrgName,
        "WorkAddress" -> WorkAddress,
        "Position" -> Position,
        "Description" -> Description,
        "Hours" -> Hours,
        "Supervisor" -> Supervisor,
        "Start" -> Start,
        "End" -> End,
        "Semester" -> Semester,
        "GPA" -> GPA,
        "Program" -> Program,
        "MBAConc" -> MBAConc,
        "GA" -> GA,
        "FalconFT" -> FalconFT,
        "International" -> International,
        "IS_2terms" -> IS_2terms,
        "priorFBL" -> priorFBL,
        "ReqCourses" -> ReqCourses,
        "ProgCourseReq" -> ProgCourseReq,
        "AdvisorApproval" -> AdvisorApproval,
        "CoordinatorApproval" -> CoordinatorApproval,
        "DeanApproval" -> DeanApproval,
        "StudentID" -> StudentID,
        "CourseID" -> CourseID,
        "AdvisorEmail" -> AdvisorEmail,
        "CoordinatorEmail" -> CoordinatorEmail,
        "DeanEmail" -> DeanEmail)
        
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