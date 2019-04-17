import React, {Component} from 'react';

class Component1 extends Component
{
	constructor(props)
	{
		super(props);
		this.state = {
			msg:"this is state msg"
		}
	} 
	
	HandleInputChnage=(e)=>
	{
		this.setState({
			msg:e.target.value
		})
	}
	
	HandleBtnClick=()=>
	{
		console.log(this.state.msg);
	}

	render(){
		return(
			<div>
				<div>{this.state.msg}</div>
				---Component1---
				<br/>
				<input type="text" onChange={this.HandleInputChnage}/>
				<button onClick={this.HandleBtnClick}>Submit</button>
			</div>
			);
	}

}

export default Component1;