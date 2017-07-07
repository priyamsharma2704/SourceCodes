import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent }  from './app.component';
import { PlayListComponent }  from './playList.component';


@NgModule({
  imports:      [ BrowserModule ],
  declarations: [ AppComponent,PlayListComponent ],
  bootstrap:    [ AppComponent ]
})
export class AppModule { }
