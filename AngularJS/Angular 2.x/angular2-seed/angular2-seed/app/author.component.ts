import {Component} from 'angular2/core';
import{AuthorsService} from './authors.service';
@Component({
	selector:'authors',
	template:`<h1>Authors</h1>
		{{authorTitle}}
		<ul>
			<li *ngFor="#a of authors">{{a}}</li>
		</ul>`,	
	providers:[AuthorsService]
})
export class AuthorComponent{
	authorTitle="Title for authors page";
	authors;

	constructor(authorService:AuthorsService){
		this.authors = authorService.getAuthors();

	}
}