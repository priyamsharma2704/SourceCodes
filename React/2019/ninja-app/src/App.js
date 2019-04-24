import React from 'react';
import './App.css';
import NinjaList from './components/ninjasList';

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
    //console.log("on submit");
    const inputValueForName = e.target.elements.ninjaName.value;
    const inputValueForColor = e.target.elements.ninjaColor.value;
    const inputValueForLocation = e.target.elements.ninjaLocation.value;

    //console.log(inputValueForName, inputValueForColor, inputValueForLocation)
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
