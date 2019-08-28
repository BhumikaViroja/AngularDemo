import { Component, OnInit } from '@angular/core';
import { ConfigService } from '../config.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-abc',
  templateUrl: './abc.component.html',
  styleUrls: ['./abc.component.css']
})
export class AbcComponent implements OnInit {

  constructor(private service : ConfigService) { }

  ngOnInit() {
    this.getStudents();
    
  }
 
  students: any[];
  message: string;
  deleteIndex: number;
  headers: any[];
  config: any;

  getStudents()
  {
    this.service.getStudents().subscribe(students => this.students = students);
  }

  addStudent() {
    let student = {
      "name": "added_name",
      "email": "added@gmail.com",
      "contact": 9939999999,
      "city": "added_city"
    }

    this.service.addStudent(student)
      .subscribe(student => this.students.push(student));
  }
  deleteStudent(i: number) {
    console.log(i);

    this.deleteIndex = i;
    this.service.deleteStudent(i)
      .subscribe(message => { this.message = message },
        (err: HttpErrorResponse) => {
          this.students.splice(this.deleteIndex, 1);
          console.log(err);
          this.deleteIndex = null;
        });

  }

}
