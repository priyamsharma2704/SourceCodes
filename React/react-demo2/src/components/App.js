import React, { Component } from 'react';
import Header from "./Header";
import Footer from "./Footer";
import logo from '../logo.svg';
import './App.css';

class App extends Component {
  constructor(){
    super();
    this.state = {title:"Welcome"};
  }

  changeTitle(title){
    this.setState({title});
  }
  render() {
    return (
      <div className="App">
        <Header changeTitle={this.changeTitle.bind(this)} title={this.state.title}/>
          {this.state.name}
        <Footer/>
      </div>
    );
  }
}

export default App;
