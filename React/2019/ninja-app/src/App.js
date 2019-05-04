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

    if(inputValueForName && inputValueForColor && inputValueForLocation)
    {
      const userRef = db.collection("ninjas").add({
        name: inputValueForName,
        color: inputValueForColor,
        location : inputValueForLocation
      });  

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

  HandleDelete=(e)=>
  {
    e.preventDefault();
    const tempObj = this.state.ninjas;
    const index = e.target.id;
    tempObj.splice(index,1);

    this.setState(
      {
        ninjas: tempObj
      }
    );
  }

  render()
  {
    return (
      <div className="container">
        <div className="row">
          <div className="col"></div>
          <div className="col-16 ninjaComponentDiv">
            <NinjaList
            handleInputOnChangeForName={this.HandleInputOnChangeForName}
            handleInputOnChangeForColor={this.HandleInputOnChangeForColor}
            handleInputOnChangeForLocation={this.HandleInputOnChangeForLocation}
            handleOnSubmit={this.HandleOnSubmit}
            ninjasList={this.state.ninjas}
            nameValue={this.state.inputName}
            colorValue={this.state.inputColor}
            locationValue={this.state.inputLocation}
            handleDelete={this.HandleDelete}
            ></NinjaList>
          </div>
          <div className="col"></div>
        </div>
      </div>
    );
  }
}

export default App;
