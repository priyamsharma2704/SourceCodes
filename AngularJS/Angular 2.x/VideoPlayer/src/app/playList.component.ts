import { Component } from '@angular/core';
import {Video} from './video';
@Component({
	selector:'playList',
	templateUrl: 'app/playList.component.html', 
	inputs: ['videos']
})

export class PlayListComponent{
	onSelect(vid:Video){
		console.log(JSON.stringify(vid));
	}
}