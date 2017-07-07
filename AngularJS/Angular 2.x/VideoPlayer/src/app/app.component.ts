import { Component } from '@angular/core';
import {Config} from './config.service';
import {Video} from './video';
import {PlayListComponent} from './playList.component';


@Component({
  selector: 'my-app',
  templateUrl: 'app/app.component.html',

})
export class AppComponent  { 
	mainHeading = Config.MAIN_HEADING; 
	videos:Array<Video>;

	constructor(){
		this.videos = [
			new Video(1,"Brock Lesner Tattoo Sketch" , "srthFTLQ7PI" ,"brock lesnar tatto sketch timelapse"),
			new Video(2,"Conor McGregor Sketch" , "https://youtu.be/0faQeUbKZbY" ,"conor mc gregor sketch timelapse"),
		]
	}
}
