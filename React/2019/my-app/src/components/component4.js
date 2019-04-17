import React, { Component } from 'react';

class Component4 extends Component
{
  constructor(props)
  {
    super(props);
    this.state = {message:"Sample text"}
  }

  HandleTextChangeEvent=(e)=>{
    this.setState({
      message:e.target.value
    });
    //console.log(this.state.message)
  }

  HandleButtonClick=(e)=>
  {
    e.preventDefault();
    console.log(this.state.message);
  }

  render(){
    return(
      <div>
        --------Component4---------
        <br/>
        TEXT: {this.state.message}
        <br/>
        <form onSubmit={this.HandleButtonClick}>
          <input type="text" onChange={this.HandleTextChangeEvent}/>
          <button>Submit</button>
        </form>
      </div>
    )
  }
}

export default Component4;