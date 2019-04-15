import React, { Component } from 'react';
import * as firebase from 'firebase';

var config = {
  apiKey: "AIzaSyDtLl4bVQTTsZZcQNCn5Q7DvzgzAKKTinw",
  authDomain: "firestore-cafes.firebaseapp.com",
  databaseURL: "https://firestore-cafes.firebaseio.com",
  projectId: "firestore-cafes",
  storageBucket: "firestore-cafes.appspot.com",
  messagingSenderId: "464289815464"
}
firebase.initializeApp(config);

class Login extends Component {
  constructor(props)
  {
    super(props)
    this.state = {
      email:"",
      password:"" 
    }
  }

  handleChangeOnEmail=(e)=>
  {
    //console.log(e.target.value);
    this.setState({
      email: e.target.value
    })
  }

  handleChangeOnPassword=(e)=>
  {
    //console.log(e.target.value);
    this.setState({
      password: e.target.value
    })
  }

  handleClick=()=>{
    console.log(this.state);
    const email = this.state.email;
    const password = this.state.password;
    firebase.auth().createUserWithEmailAndPassword(email,password).catch(error=>{
      console.log(error);
    })

  }

  render() {
    return (
      <div className="form-block">
        <h2>Sign Up</h2>
        <div className="form-group">
          <input type="text" className="form-control" placeholder="email" onChange={this.handleChangeOnEmail}/>
          <input type="text" className="form-control" placeholder="password" onChange={this.handleChangeOnPassword}/>
          <button className="btn  btn-primary" onClick={this.handleClick}>Sign Up</button>
        </div>
      </div>
    );
  }
}

export default Login;
