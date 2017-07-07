import {Component} from "@angular/core"

@Component({
	selector: "my-app", // directive name same as in index.html
	template: `
	<div>
		<h1>{{getHeading()}}</h1>
		<my-employee></my-employee>
	<div>`
})
export class AppComponent{
	pageHeader:string = "Employee Details ";
	s1:string="Employee";
	s2:string="Details";

	getHeading(){
		return this.s1 + ' ' + this.s2;
	}



}

