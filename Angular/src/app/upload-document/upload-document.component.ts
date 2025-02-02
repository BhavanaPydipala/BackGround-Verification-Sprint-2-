import { Component, OnInit } from '@angular/core';
import { EmployeeDocumentDto, BackgroundService,Response } from '../background.service';
import { Router } from '@angular/router';
import { Subscriber, combineLatest } from 'rxjs';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-upload-document',
  templateUrl: './upload-document.component.html',
  styleUrls: ['./upload-document.component.css']
})
export class UploadDocumentComponent implements OnInit {

  reactiveForm: FormGroup;
  doc:EmployeeDocumentDto = new EmployeeDocumentDto(0,0,"","","",null);
   empId:number;
   empName:string;
   public userfile:any=File;
  private router:Router
  message:string;
  filestatus:Response;
result:number;
  constructor(private service:BackgroundService,router:Router) { 
    this.router=router;
  }

  ngOnInit() {
    this.reactiveForm = new FormGroup({
      empId: new FormControl(),
      empName: new FormControl()
    });
  }

  onSelectFile(event)
  {
const file=event.target.files[0];
console.log(file);
this.userfile=file;
  }

  saveForm(submitForm:FormGroup){
    const user=submitForm.value;
    const formData=new FormData();
    formData.append('user',JSON.stringify(user));
    formData.append('file',this.userfile);
  this.service.saveEmployeeProfile(formData).subscribe((data)=>{
    this.filestatus=data;
        if(this.filestatus.message === 'Document not uploaded' ){
         console.log("if");
        this.message='Document not uploaded';
        }
        else{
          alert("Uploaded succesfully");
          
          //
          this.router.navigate(['app-view-status'])
        }
        
      },
      error=>{
        this.message="*all fields are required";
      }
    );

  }
}

/*uploaddocument(){
  if(this.doc.empId != 0 && this.doc.empName != "" &&this.doc.docData!=""){
    console.log(this.empId+" "+this.empName+" file "+this.doc)
    this.service.document(this.doc.empId,this.doc.empName);//.subscribe((data)=>this.message=data);
     
    
}
else{
  this.message = "employee status was not set";
}
} */


