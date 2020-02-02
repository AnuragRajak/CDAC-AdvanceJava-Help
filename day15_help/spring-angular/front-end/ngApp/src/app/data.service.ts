import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DataService {
  baseUrl="http://localhost:8080/test_boot/employees/"

  constructor(public http:HttpClient) {

  }

   getData(){

    return this.http.get(this.baseUrl);

   }
   AddData(emp,image){
     console.log(emp);
     const formData = new FormData();
     formData.append("name",emp.name);
     formData.append("address",emp.address);
     formData.append("image",image);
    
     return this.http.post(this.baseUrl,formData);
   }

   delete(no){
    return this.http.delete(this.baseUrl+no);
   }
   getDataById(no){

    return this.http.get(this.baseUrl+no);

   }

   update(emp,image){
    console.log("Updated Data: "+emp.name);
    const formData = new FormData();
    formData.append("name",emp.name);
    formData.append("address",emp.address);
    formData.append("image",image);
   // console.log(formData);
    return this.http.put(`${this.baseUrl}${emp.no}`,formData);
   //return this.http.put(this.baseUrl+${emp.no},formData);
   }
}
