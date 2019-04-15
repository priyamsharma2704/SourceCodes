import React, { Component } from 'react';
import './App.css';
import Login from './Components/logIn'

class App extends Component {
  render() {
    return (
      <div className="App">
        <header className="App-header">
          <Login></Login>
        </header>
      </div>
    );
  }
}

export default App;
