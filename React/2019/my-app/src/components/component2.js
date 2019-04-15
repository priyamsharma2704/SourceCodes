import React, { Component } from 'react';

class Component2 extends Component {
constructor(props){
  super(props);

  this.state = {flag:false}
}

  render() {
    const toggleOnClick =()=>
    {
      this.setState({
        flag:!(this.state.flag)
      })
    }

    return (
      <div>
        -----Component2-----
        <br/>
        <div>State : {this.state.flag.toString()}</div>
        <button onClick={toggleOnClick}>Toggle</button>
      </div>
      
    );
  }
}

export default Component2;
