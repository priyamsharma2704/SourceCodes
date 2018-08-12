import React, { Component } from 'react';
import Ninjas from './Ninjas';
//import logo from './logo.svg';
//import './App.css';

class App extends Component {
  render() {
    return (
      <div className="App">
        <h1>Header!!!!</h1>
        <p>Welcome</p>
        <Ninjas name="Ryu" age="30" belt="Black"/>
        <Ninjas name="Ken" age="32" belt="Brown"/>
      </div>
    );
  }
}

export default App;
