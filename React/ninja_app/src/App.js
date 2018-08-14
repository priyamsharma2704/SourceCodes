import React, { Component } from 'react';
import Ninjas from './Ninjas';
//import logo from './logo.svg';
//import './App.css';

class App extends Component {
  state={
    ninjas:[
      { name:"ken", age:20, belt:"black", id:1},
      { name:"ryu", age:40, belt:"brown", id:2},
      { name:"chun li", age:30, belt:"red", id:3}
    ]
  }
  render() {
    return (
      <div className="App">
        <h1>Header!!!!</h1>
        <p>Welcome</p>
        <Ninjas ninjas={this.state.ninjas}/>
      </div>
    );
  }
}

export default App;
