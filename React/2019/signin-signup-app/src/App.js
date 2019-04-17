import React, { Component } from 'react';
import './App.css';
import Component1 from './Components/Component1';
import SignIn from './Components/SignIn';
import SignUp from './Components/SignUp';

class App extends Component {

  constructor(props)
  {
    super(props);

    this.state = {
      showSignIn:false
    }
  }
  
  HandleSignInOnClick=()=>
  {
    console.log("SignIn");
    this.setState({
      showSignIn:true
    });
  }

  HandleSignUpOnClick=()=>
  {
    console.log("SignUp");
    this.setState({
      showSignIn: !this.state.showSignIn
    });
  }

  render() {
    let content;
    if(this.state.showSignIn === true)
      content = <SignIn></SignIn>;
    else
      content = <SignUp></SignUp>;

    return (
      <div>
        <div>Main Component</div>
        <Component1></Component1>
        <br/>
        <div className="container">
          <div>
            <span onClick={this.HandleSignInOnClick}>SignIn</span> | <span onClick={this.HandleSignUpOnClick}>SingUp</span>
          </div>
          {content}
          
        </div>
      </div>
    );
  }
}

export default App;
