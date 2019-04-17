import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import Component1 from "./components/component1";
import Component2 from "./components/component2";
import Component3 from './components/component3';

class App extends Component {

  render() {
    var func = function()
    {
      return "asd";
    }

    const func2=()=>{
      return (1+2);
    }
    
    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <p>
            Edit <code>src/App.js</code> and save to reload.
          </p>
          <a
            className="App-link"
            href="https://reactjs.org"
            target="_blank"
            rel="noopener noreferrer"
          >
            Learn React
          </a>
        </header>
        <Component1 p1={1} p2="property2" p3={func()} p4={func2()}></Component1>
        <Component2></Component2>
        <Component3></Component3>
      </div>
      
    );
  }
}

export default App;
