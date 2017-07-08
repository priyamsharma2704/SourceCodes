import {Component} from 'angular2/core';
import {CourseService} from './course.service';
@Component({
	selector:'courses',
	template:`<h1>Courses</h1>
		{{title}}
		<ul>
			<li *ngFor="#c of courses">{{c}}</li>
		</ul>`,
	providers:[CourseService]
})

export class CoursesComponent{
	title = "the title of courses page";	
	courses;

	constructor(courseService: CourseService){
		this.courses = courseService.getCourses();
	}
}