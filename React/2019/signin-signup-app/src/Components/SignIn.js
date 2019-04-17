import React, {Component} from 'react';

class SignIn extends Component
{
	render()
	{
		return(
			<div className="signin">
				<br/>
				<input type="text" placeholder="Email"/>
				<input type="password" placeholder="Password"/>
			</div>
			);
	}

}

export default SignIn;