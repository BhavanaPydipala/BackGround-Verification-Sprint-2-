import { Component, OnInit } from '@angular/core';
import { VerificationDto, BackgroundService } from '../background.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-set-status',
  templateUrl: './set-status.component.html',
  styleUrls: ['./set-status.component.css']
})
export class SetStatusComponent implements OnInit {

  verification:VerificationDto=new VerificationDto(0,"",null,null);
  private router:Router
  message:string;
  check:boolean;
  constructor(private service:BackgroundService,router:Router) { 
    this.router=router;
  }

  ngOnInit(): void {  
  }
  
  status(){
    if(this.verification.verfId != 0 && this.verification.status != ""){
      this.service.setstatus(this.verification).subscribe((data)=>{
        this.message=data
        console.log(this.message)
        
      },
      error=>
      {
        this.message="id does not exists"
      }
        );
      
  }
  this.check=true;
      
  } 
}

























