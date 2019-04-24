import React from 'react';
import './App.css';
import NinjaList from './components/ninjasList';
import * as firebase from 'firebase';
const config = {
  apiKey: "AIzaSyDtLl4bVQTTsZZcQNCn5Q7DvzgzAKKTinw",
  authDomain: "firestore-cafes.firebaseapp.com",
  databaseURL: "https://firestore-cafes.firebaseio.com",
  projectId: "firestore-cafes",
  storageBucket: "firestore-cafes.appspot.com",
  messagingSenderId: "464289815464"
};
const app =  firebase.initializeApp(config);

class App extends React.Component
{
  state=
  {
    inputName:"",
    inputColor:"",
    inputLocation:"",
    ninjas:[{name:"ryu", color:"red",location:"usa"},
            {name:"ken", color:"green",location:"uk"},
            {name:"chun li", color:"blue",location:"china"}
            ]
  }

  HandleInputOnChangeForName=(e)=>
  {
    this.setState({
      inputName:e.target.value
    });
  }
  
  HandleInputOnChangeForColor=(e)=>
  {
    this.setState({
      inputColor:e.target.value
    });
  }

  HandleInputOnChangeForLocation=(e)=>
  {
    this.setState({
      inputLocation:e.target.value
    });
  }

  HandleOnSubmit=(e)=>{
    e.preventDefault();

    const inputValueForName = e.target.elements.ninjaName.value;
    const inputValueForColor = e.target.elements.ninjaColor.value;
    const inputValueForLocation = e.target.elements.ninjaLocation.value;

    const db = firebase.firestore();
    const userRef = db.collection("ninjas").add({
      name: inputValueForName,
      color: inputValueForColor,
      location : inputValueForLocation
    });  

    //console.log(inputValueForName, inputValueForColor, inputValueForLocation)
    if(inputValueForName && inputValueForColor && inputValueForLocation)
    {
      const tempObj = {name:inputValueForName, color:inputValueForColor,location:inputValueForLocation};

      const tempNinjaObj = this.state.ninjas;
      tempNinjaObj.push(tempObj);
  
      this.setState(
        {
          ninjas:tempNinjaObj,
          inputName:"",
          inputColor:"",
          inputLocation:""
        }
      );
    }
  }

  render()
  {
    return (
      <div>
        <NinjaList 
        handleInputOnChangeForName={this.HandleInputOnChangeForName}
        handleInputOnChangeForColor={this.HandleInputOnChangeForColor}
        handleInputOnChangeForLocation={this.HandleInputOnChangeForLocation}
        handleOnSubmit={this.HandleOnSubmit}
        ninjasList={this.state.ninjas}
        nameValue={this.state.inputName}
        colorValue={this.state.inputColor}
        locationValue={this.state.inputLocation}
        ></NinjaList>
      </div>
    );
  }
}

export default App;
