import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';
import { Config } from 'protractor';
import { catchError, retry } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ConfigService {

  students : any;
  handleError : any;
  constructor(private http:HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
      'Authorization': 'my-auth-token'
    })
  };
  
  getStudents(): Observable<any[]> {
    return this.http.get<any>('http://localhost:8080/students/student').pipe(
      retry(3), 
      catchError(this.handleError) 
    );
  }

  addStudent(student): Observable<any>{
    return this.http.post<any>('http://localhost:8080/students/student'
    ,student,this.httpOptions);
  }

  deleteStudent(id): Observable<string> {  
    return this.http.delete<string>(`http://localhost:8080/students/student/${id}`);
  }
}
