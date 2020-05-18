import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
export class LoginDto
{
  empId:number;
  password:string;
  roleId:number;
  constructor(empId:number, password:string, roleId:number){
    this.empId = empId;
    this.password = password;
    this.roleId = roleId;
}
}
export class EmployeeDocumentDto
{
  empId:number;
  docId:number;
  docType:string;
  docData:string;
  empName:string;
  verificationDto:VerificationDto
  constructor(empId:number,docId:number,docType:string,docData:string,empName:string,verificationDto:VerificationDto){
    this.empId = empId;
    this.docId = docId;
    this.docType = docType;
    this.empName=empName;
    this.verificationDto=verificationDto;
}
}
export class VerificationDto
{
  verfId:number;
  status:string;
  startDate:Date;
  endDate:Date;
  constructor(verfId:number,status:string,startDate:Date, endDate:Date )
  {
    this.verfId=verfId;
    this.status=status;
    this.startDate=startDate;
    this.endDate=endDate;
  }
}
export class Response{
  message:string;
  verfId: string;

}

@Injectable({
  providedIn: 'root'
})
export class BackgroundService {

  constructor(private http:HttpClient) { }

  logindto:LoginDto;
  employeedocumentdto:EmployeeDocumentDto;
  verification:VerificationDto;
  public getlogindetails(empId:number,password:string,roleId:number){
    
    return this.http.get("http://localhost:8017/BackGroundVerification/Login/"+empId+"/"+password+"/"+roleId);
  
  }
  public getdocumentbyid(empId:number){
  
return this.http.get<EmployeeDocumentDto>("http://localhost:8016/BackGroundVerification/GetDocumentById/"+empId);
  
  }
  public getdocumentbyname(empName:string){
    
    return this.http.get("http://localhost:8016/BackGroundVerification/GetDocumentByName/"+empName,{responseType: 'json'});
  
  }
  
  
  public setstatus(verf){
    console.log(verf);
    return this.http.put("http://localhost:8015/BackGroundVerification/SetStatus",verf,{responseType: 'text'});
  }

  public saveEmployeeProfile(formdata:FormData):Observable<any>{

    return this.http.post("http://localhost:1002/BackgroundVerification-EmployeePortal/UploadDocument",formdata);
  
  }
  public getstatus(verfId:number){
    
    return this.http.get("http://localhost:1002/BackgroundVerification-EmployeePortal/ViewStatus/"+verfId,{responseType: 'json'});
  
  }


  

  

  

}

